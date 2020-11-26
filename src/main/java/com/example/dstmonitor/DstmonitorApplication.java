package com.example.dstmonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
//@EnableAdminServer
public class DstmonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(DstmonitorApplication.class, args);
    }

}
