package com.smartrelif.disasteroptimizerdms;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootTest(
    classes = DisasteroptimizerdmsApplication.class,
    properties = {
        "spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration"
    }
)
class DisasteroptimizerdmsApplicationTests {

    @Test
    void contextLoads() {
    }

}
