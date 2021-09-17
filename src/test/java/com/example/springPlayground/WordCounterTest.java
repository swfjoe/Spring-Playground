package com.example.springPlayground;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest

public class WordCounterTest {
    @Autowired
    private MockMvc mvc;

    @Test
    void testPostCrewMemberRequestAcceptsFormDataInBodyBob() throws Exception {
        this.mvc.perform(post("/words/count")
                        .contentType(MediaType.TEXT_PLAIN)
                        .content("A brown cow jumps over a brown fox"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"A\": 1,\"brown\": 2,\"cow\": 1,\"jumps\": 1,\"over\": 1,\"a\": 1,\"fox\": 1}"));
    }
}
