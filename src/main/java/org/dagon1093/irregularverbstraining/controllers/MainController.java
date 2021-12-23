package org.dagon1093.irregularverbstraining.controllers;

import org.dagon1093.irregularverbstraining.model.Game;
import org.dagon1093.irregularverbstraining.services.serviceimpl.GameServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private final GameServiceImpl gameService;

    public MainController(GameServiceImpl gameService) {
        this.gameService = gameService;
    }

    @GetMapping({"","/"})
    public String getIndexPage(){
        return "index";
    }

    @GetMapping({"/match"})
    public Game getMatch(){
        return gameService.getGame();
    }
}
