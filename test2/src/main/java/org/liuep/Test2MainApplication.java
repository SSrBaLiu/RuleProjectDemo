package org.liuep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class Test2MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(Test2MainApplication.class,args);
    }
}
