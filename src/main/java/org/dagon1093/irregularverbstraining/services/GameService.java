package org.dagon1093.irregularverbstraining.services;

import org.dagon1093.irregularverbstraining.model.Game;
import org.dagon1093.irregularverbstraining.model.Present;

public interface GameService {

    Game getGame();
    Game setWord(String word);
}
