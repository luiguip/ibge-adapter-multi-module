package com.github.luiguip.ibge_adapter_multi_module.ibge_adapter_launcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@EnableCaching
@SpringBootApplication(scanBasePackages = "com.github.luiguip.ibge_adapter_multi_module")
public class LauncherApplication {

    public static void main(String[] args) {
        SpringApplication.run(LauncherApplication.class, args);
    }

}
