package com.example.myspringbootapp.app.controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.myspringbootapp.app.model.Car;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Date;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
// @ActiveProfiles(value = "test")
class TestingWebApplicationTest {

    //TODO: Don't boot application only controller
    @Autowired
    private MockMvc mockMvc;

    @Test
    void GET_shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/calculation")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("GET request successful")));
    }

    @Test
    void POST_shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(post("/calculation")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("POST request successful")));

        Car car = new Car();
        car.setRegNum("XYZ123");
        car.addPassageTime(LocalDateTime.parse("2013-01-14T21:00:00"));


    }
}