package com.baby_naming_app.backend.integrationtests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class BabyNameIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void findNames_ReturnsBabyNames() throws Exception {
        mockMvc.perform(get("/api/v1/names"))
                .andExpect(status().isOk())
                .andExpect(content().string("[]"));
    }
}
