package org.dagon1093.irregularverbstraining.services.serviceimpl;

import org.dagon1093.irregularverbstraining.model.Game;

import org.dagon1093.irregularverbstraining.repositories.PresetRepository;
import org.dagon1093.irregularverbstraining.services.GameService;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {

    private final Game game;
    private final PresetRepository presetRepository;

    public GameServiceImpl(Game game, PresetRepository presetRepository) {
        this.game = game;
        this.presetRepository = presetRepository;
    }

    @Override
    public Game getGame() {
        int count = (int)presetRepository.count();
        long id = (long)(Math.random()*((count-1)+1))+1;
        game.setPresent(presetRepository.findById(id).orElse(null));
        return game;
    }

    @Override
    public Game setWord(String word) {
        return null;
    }
}
