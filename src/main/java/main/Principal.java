package main;

import game.MarioGame;
import player.Player;

import java.util.ArrayList;
import java.util.List;

public class Principal {
    static void main() {
        List<Player> players = new ArrayList<>();

        players.add(new Player("Anthony"));
        players.add(new Player("Mary"));
        players.add(new Player("Joseph"));
        players.add(new Player("Brian"));
        players.add(new Player("Kelly"));

        for (int i = 0; i < 10; i++) {
            System.out.printf("----------------------------Round %s%s----------------------------\n", (i + 1 < 10 ? 0 : ""), (i + 1));

            for (Player player : players) {
                MarioGame game = new MarioGame();

                while (!game.isDone()) game.takeMysteryBox();

                player.addScore(game.getScore());
            }

            players.sort(Player::compareTo);

            players.forEach(System.out::println);
        }
    }
}
