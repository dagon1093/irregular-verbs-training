package org.dagon1093.irregularverbstraining.services.serviceimpl;

import org.dagon1093.irregularverbstraining.model.Game;
import org.dagon1093.irregularverbstraining.services.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;


@Service
public class QuestionServiceImpl implements QuestionService {


    @Override
    public HashMap<String, String> fillWordsMap(@Autowired Game game) {
        HashMap<String, String> wordsList = new HashMap<>();

        if(!game.getQuestionMap().containsKey("Present")) {
            wordsList.put("Present", game.getPresent().getWord());
        } else { wordsList.put("Present", "___");}
        if(!game.getQuestionMap().containsKey("Past")) {
            wordsList.put("Past", game.getPresent().getPastSet().get(0).getWord());
        } else { wordsList.put("Past", "___");}
        if(!game.getQuestionMap().containsKey("Participle")) {
            wordsList.put("Participle", game.getPresent().getParticipleSet().get(0).getWord());
        } else { wordsList.put("Participle", "___");}
        return wordsList;
    }
}
