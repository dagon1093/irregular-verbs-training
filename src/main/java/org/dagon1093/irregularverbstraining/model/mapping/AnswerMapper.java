package org.dagon1093.irregularverbstraining.model.mapping;

import org.dagon1093.irregularverbstraining.model.Answer;
import org.dagon1093.irregularverbstraining.model.dto.AnswerDTO;

public interface AnswerMapper {

    Answer dtoToAnswer(AnswerDTO answerDTO);
}
