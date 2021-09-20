package com.example.springPlayground;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WebMvcTest
@SpringBootTest
@AutoConfigureMockMvc
public class WordCounterTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private WordCounter newWordCounter;

    @Test
    void testPostCrewMemberRequestAcceptsFormDataInBodyBob() throws Exception {
        this.mvc.perform(post("/words/count")
                        .contentType(MediaType.TEXT_PLAIN)
                        .content("A brown cow jumps over a brown fox"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"A\": 1,\"brown\": 2,\"cow\": 1,\"jumps\": 1,\"over\": 1,\"a\": 1,\"fox\": 1}"));
    }

    @Test
    void testPostCrewMemberRequestAcceptsFormDataInBodyBobTest() throws Exception {
        Map<String, Integer> expected = new HashMap<>();
        expected.put("test",1);
        when(newWordCounter.wordCount("test"))
                .thenReturn(expected);
        Map<String, Integer> actual = newWordCounter.wordCount("test");
        assertEquals(expected, actual);
    }
}
