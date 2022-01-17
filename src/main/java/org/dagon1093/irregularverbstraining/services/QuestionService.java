package org.dagon1093.irregularverbstraining.services;

import org.dagon1093.irregularverbstraining.model.Game;

import java.util.Map;

public interface QuestionService {

    Map<String, String> fillWordsMap(Game game);
}
