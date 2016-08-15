package com.goeuro.testtask;

import com.goeuro.testtask.service.BusRouteLoader;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.file.Paths;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by etsatsina on 31-Jul-16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class IntegrationTest {

    private MockMvc mvc;

    @Autowired
    private BusRouteLoader loader;

    @Value("${app.default_route_filepath}")
    private String defaultRouteFilepath;

    @Autowired
    protected WebApplicationContext webApplicationContext;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        loader.loadRoute(Paths.get(defaultRouteFilepath).toAbsolutePath().toString());
    }

    @Test
    public void shouldReturnTrueWhenHasDirectRoute() throws Exception {
        mvc.perform(get("/rest/provider/goeurobus/direct/3/6"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"dep_sid\":3,\"arr_sid\":6,\"direct_bus_route\":true}"));
    }


    @Test
    public void shouldReturnFalseWhenHasNotDirectRoute() throws Exception {
        mvc.perform(get("/rest/provider/goeurobus/direct/3/2"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"dep_sid\":3,\"arr_sid\":2,\"direct_bus_route\":false}"));
    }


    @Test
    public void shouldReturnFalseWhenHasNotSuchArrivalStation() throws Exception {
        mvc.perform(get("/rest/provider/goeurobus/direct/3/15"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"dep_sid\":3,\"arr_sid\":15,\"direct_bus_route\":false}"));
    }

    @Test
    public void shouldReturnFalseWhenHasNotSuchDepartureStation() throws Exception {
        mvc.perform(get("/rest/provider/goeurobus/direct/15/2"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"dep_sid\":15,\"arr_sid\":2,\"direct_bus_route\":false}"));
    }

}