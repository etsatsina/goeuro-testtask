package com.goeuro.testtask;

import com.goeuro.testtask.service.BusRouteLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Paths;

@SpringBootApplication
public class BusRouteApplication implements CommandLineRunner {

	@Autowired
	private BusRouteLoader busRouteLoader;

	@Value("${app.default_route_filepath}")
	private String defaultRouteFilepath;

	@Override
	public void run(String... args) throws Exception {
		if (args.length == 0) {
			busRouteLoader.loadRoute(Paths.get(defaultRouteFilepath).toAbsolutePath().toString());
		}
		else if (args.length == 1) {
			String specifiedRouteFilepath = args[0];
			busRouteLoader.loadRoute(specifiedRouteFilepath);
		}
		else {
			throw new IOException("Wrong number of specified parameters. " +
					" Should get only one - absolute file path to route file");
		}

	}

	public static void main(String[] args) {
		SpringApplication.run(BusRouteApplication.class, args);
	}
}
