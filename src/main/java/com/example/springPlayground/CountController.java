package com.example.springPlayground;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CountController {
    private final WordCounter newWordCounter;


    public CountController(WordCounter newWordCounter) {
        this.newWordCounter = newWordCounter;
    }

    @PostMapping("/words/count")
    public Map<String, Integer> getWordCount(@RequestBody String wordCount) {
        return this.newWordCounter.wordCount(wordCount);
    }

}
