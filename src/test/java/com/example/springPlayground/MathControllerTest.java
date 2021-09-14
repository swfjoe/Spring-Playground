package com.example.springPlayground;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(MathController.class)
public class MathControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testIndexEndpoint() throws Exception {
        this.mvc.perform(get("/math/pi").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("3.141592653589793"));
    }

    @Test
    public void testOperationRequestReturnsInteger() throws Exception {
            this.mvc.perform(get("/math/calculate").accept(MediaType.TEXT_PLAIN))
                    .andExpect(status().is(400));
    }

    @Test
    public void testOperationAddProducesTotal() throws Exception {
        this.mvc.perform(get("/math/calculate?operation=add&x=4&y=6").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("4 + 6 = 10"));
    }

    @Test
    public void testOperationSubtractProducesDifference() throws Exception {
        this.mvc.perform(get("/math/calculate?operation=subtract&x=4&y=6").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("4 - 6 = -2"));
    }

    @Test
    public void testOperationMultiplyProducesProduct() throws Exception {
        this.mvc.perform(get("/math/calculate?operation=multiply&x=4&y=6").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("4 * 6 = 24"));
    }

    @Test
    public void testOperationDivideProducesTotalQuotient() throws Exception {
        this.mvc.perform(get("/math/calculate?operation=divide&x=6&y=3").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("6 / 3 = 2"));
    }

    @Test
    void testSumFunctionProducesSum() throws Exception {
        this.mvc.perform(get("/math/sum?n=1&n=3&n=5").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("1 + 3 + 5 = 9"));
    }

    @Test
    void testSumFunctionProducesSumMoreValues() throws Exception {
        this.mvc.perform(get("/math/sum?n=1&n=3&n=5&n=7&n=9&n=11").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("1 + 3 + 5 + 7 + 9 + 11 = 36"));
    }

    @Test
    void testSumFunctionProducesEqualsStatementWhenGivenOneN() throws Exception {
        this.mvc.perform(get("/math/sum?n=5").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("5 = 5"));
    }
}
