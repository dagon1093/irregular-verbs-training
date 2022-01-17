package org.dagon1093.irregularverbstraining.model.mapping.mappingimpl;

import org.dagon1093.irregularverbstraining.model.Question;
import org.dagon1093.irregularverbstraining.model.dto.QuestionDTO;
import org.dagon1093.irregularverbstraining.model.mapping.QuestionMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Map;

@Component
public class QuestionMapperIml implements QuestionMapper {

    @Override
    public QuestionDTO questionToDTO(Question question) {

        QuestionDTO questionDTO = new QuestionDTO();
        ArrayList<String> words = new ArrayList<>();

        Map<String, String> map =  question.getWordsMap();
        words.add(map.get("Present"));
        words.add(map.get("Past"));
        words.add(map.get("Participle"));
        questionDTO.setWords(words);
        return questionDTO;
    }
}
