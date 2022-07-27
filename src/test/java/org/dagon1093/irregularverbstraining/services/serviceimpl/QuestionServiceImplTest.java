package org.dagon1093.irregularverbstraining.services.serviceimpl;

import org.dagon1093.irregularverbstraining.model.*;
import org.dagon1093.irregularverbstraining.services.QuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class QuestionServiceImplTest {

    Game game;
    Present presentWord;
    Past past;
    Participle participle;
    List<Past> pastList;
    List<Participle> participleList;
    QuestionServiceImpl service;
    final int WORD_MAP_SIZE = 3;

    @BeforeEach
    void setUp() {
        presentWord = new Present();
        presentWord.setWord("abide");

        past = new Past();
        past.setWord("abode");
        past.setPresent(presentWord);
        pastList = new ArrayList<>();
        pastList.add(past);

        participle = new Participle();
        participle.setWord("abode");
        participle.setPresent(presentWord);
        participleList = new ArrayList<>();
        participleList.add(participle);

        game = new Game();
        game.setPresent(presentWord);
        Map<String, String> questionMap = new HashMap<>();
        questionMap.put("Present","abide");
        game.setQuestionMap(questionMap);

        presentWord.setPastSet(pastList);
        presentWord.setParticipleSet(participleList);

        service = new QuestionServiceImpl();

    }

    @Test
    void fillWordsMap() {
        HashMap<String, String> map = service.fillWordsMap(game);
        assertNotNull(map);
        assertEquals(WORD_MAP_SIZE,map.size());
        assertTrue(map.containsValue("___"));
    }
}