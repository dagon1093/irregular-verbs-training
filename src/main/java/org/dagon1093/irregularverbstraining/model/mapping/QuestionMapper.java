package org.dagon1093.irregularverbstraining.model.mapping;

import org.dagon1093.irregularverbstraining.model.Question;
import org.dagon1093.irregularverbstraining.model.dto.QuestionDTO;

public interface QuestionMapper {

    QuestionDTO questionToDTO (Question question);
}
