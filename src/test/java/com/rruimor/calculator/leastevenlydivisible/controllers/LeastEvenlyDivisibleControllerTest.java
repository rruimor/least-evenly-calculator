package com.rruimor.calculator.leastevenlydivisible.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rruimor.calculator.leastevenlydivisible.domain.CalculationResult;
import com.rruimor.calculator.leastevenlydivisible.models.UpperRange;
import com.rruimor.calculator.leastevenlydivisible.services.LeastEvenlyDividableService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import java.math.BigDecimal;

import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LeastEvenlyDivisibleControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    private LeastEvenlyDividableService leastEvenlyDividableService;

    @Test
    public void getLeastEvenlyDivisor() throws Exception {
        given(leastEvenlyDividableService.findSmallestMultiple(1))
                .willReturn(new CalculationResult(12345L, BigDecimal.ONE));

        RequestBuilder request = get("/least-evenly-divisible");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON))
                .andExpect(jsonPath("result").isNumber());
    }

    @Test
    public void getLeastEvenlyDivisorXML() throws Exception {
        CalculationResult result = new CalculationResult(12345L, BigDecimal.ONE);

        given(leastEvenlyDividableService.findSmallestMultiple(1))
                .willReturn(result);

        RequestBuilder request = get("/least-evenly-divisible")
                .accept(APPLICATION_XML_VALUE);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(APPLICATION_XML));
    }

    @Test
    public void setRangeUpperNumberWithValidValue() throws Exception {
        String jsonBody = objectMapper.writeValueAsString(new UpperRange(5));

        RequestBuilder request = post("/least-evenly-divisible/upper-range")
                .content(jsonBody)
                .contentType(APPLICATION_JSON);

        this.mvc.perform(request)
                .andExpect(status().isOk());
    }

    @Test
    public void setRangeUpperNumberWithInvalidValue() throws Exception {
        String jsonBody = objectMapper.writeValueAsString(new UpperRange(28));

        RequestBuilder request = post("/least-evenly-divisible/upper-range")
                .content(jsonBody)
                .contentType(APPLICATION_JSON);

        this.mvc.perform(request)
                .andExpect(status().isBadRequest());
    }
}