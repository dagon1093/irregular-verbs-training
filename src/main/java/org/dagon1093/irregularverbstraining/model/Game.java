package org.dagon1093.irregularverbstraining.model;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "game")
@Component
@ToString
public class Game {

    private static int countOfWins;
    private static boolean isStarted = false;
    private Present present;

}
