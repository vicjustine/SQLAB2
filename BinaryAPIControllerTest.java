package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BinaryAPIController.class)
@AutoConfigureMockMvc
public class BinaryAPIControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testMultiplyAPI() throws Exception {
        mvc.perform(get("/multiply").param("operand1", "101").param("operand2", "10"))
                .andExpect(status().isOk())
                .andExpect(content().string("1010"));
    }

    @Test
    public void testAndAPI() throws Exception {
        mvc.perform(get("/and").param("operand1", "1101").param("operand2", "1011"))
                .andExpect(status().isOk())
                .andExpect(content().string("1001"));
    }

    @Test
    public void testOrAPI() throws Exception {
        mvc.perform(get("/or").param("operand1", "1101").param("operand2", "1011"))
                .andExpect(status().isOk())
                .andExpect(content().string("1111"));
    }
}

