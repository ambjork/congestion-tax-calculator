package com.example.myspringbootapp.app;


import static org.assertj.core.api.Assertions.assertThat;

import com.example.myspringbootapp.app.controller.CalculationController;
import com.example.myspringbootapp.app.service.CalculationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
// @ActiveProfiles(value = "test")
class MySpringBootAppApplicationTests {

    @Autowired
    private CalculationController calculationController;

    @Autowired
    private CalculationService calculationService;

    @Test
    void contextLoads() {
        assertThat(calculationController).isNotNull();
        assertThat(calculationService).isNotNull();
    }

}
