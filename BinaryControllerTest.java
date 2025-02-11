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
@WebMvcTest(BinaryController.class)
@AutoConfigureMockMvc
public class BinaryControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testAddition() throws Exception {
        mvc.perform(post("/").param("operand1", "101").param("operator", "+").param("operand2", "11"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1000"));
    }

    @Test
    public void testMultiplication() throws Exception {
        mvc.perform(post("/").param("operand1", "101").param("operator", "*").param("operand2", "10"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1010"));
    }

    @Test
    public void testBitwiseAnd() throws Exception {
        mvc.perform(post("/").param("operand1", "1101").param("operator", "&").param("operand2", "1011"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1001"));
    }

    @Test
    public void testBitwiseOr() throws Exception {
        mvc.perform(post("/").param("operand1", "1101").param("operator", "|").param("operand2", "1011"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1111"));
    }
}

