package org.dagon1093.irregularverbstraining.model.mapping.mappingimpl;

import org.dagon1093.irregularverbstraining.model.Answer;
import org.dagon1093.irregularverbstraining.model.dto.AnswerDTO;
import org.dagon1093.irregularverbstraining.model.mapping.AnswerMapper;

public class AnswerMapperImpl implements AnswerMapper {

    @Override
    public Answer dtoToAnswer(AnswerDTO answerDTO) {
        Answer answer = new Answer();
        answer.setAnswer(answer.getAnswer());
        return answer;
    }
}
