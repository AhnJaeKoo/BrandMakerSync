package com.enuri.brndmkr.sync;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;

import com.enuri.brndmkr.sync.banner.BannerPrinter;

@RefreshScope
@EnableDiscoveryClient
@EnableBatchProcessing
@SpringBootApplication
public class BrandMakerSyncApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(BrandMakerSyncApplication.class);
		app.setBannerMode(Mode.OFF);
		ConfigurableApplicationContext context = app.run(args);
	    app.setBannerMode(Mode.CONSOLE);
		new BannerPrinter(context).print(BrandMakerSyncApplication.class);
	}
}
