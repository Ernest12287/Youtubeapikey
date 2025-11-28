package com.ernest.api;

import org.schabi.newpipe.extractor.NewPipe;
import org.schabi.newpipe.extractor.localization.Localization;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class ApiApplication {
    
    @PostConstruct
    public void init() {
        NewPipe.init(new DownloaderImpl(), Localization.DEFAULT);
    }
    
    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
}