package game;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class MarioGame {
    private int score;
    private MarioState state;
    private final List<String> logs;
    private final Stack<String> stack;

    public MarioGame() {
        state = new Small(this);
        logs = new ArrayList<>();
        stack = new Stack<>();
    }

    public int getScore() {
        return score;
    }

    public void takeMysteryBox() throws GameRuleViolationException {
        Random random = new Random();

        switch (random.nextInt(4)) {
            case 0 -> takeFlower();
            case 1 -> takeFeather();
            case 2 -> takeMushroom();
            case 3 -> takeDamage();
        }
    }

    public void takeFlower() throws GameRuleViolationException {
        stack.push("Take flower");
        state.takeFlower();
    }

    public void takeFeather() throws GameRuleViolationException {
        stack.push("Take feather");
        state.takeFeather();
    }

    public void takeMushroom() throws GameRuleViolationException {
        stack.push("Take mushroom");
        state.takeMushroom();
    }

    public void takeDamage() throws GameRuleViolationException {
        stack.push("Take Damage");
        state.takeDamage();
    }

    public void nextState(MarioState next) {
        String event = String.format("[%s] %s | %s => %s | Score = %d",
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss")),
                stack.pop(),
                state.getClass().getSimpleName(),
                next.getClass().getSimpleName(),
                score
        );

        logs.add(event);

        state = next;
    }

    public void incrementScore() {
        score += 1000;
        nextState(state);
    }

    public boolean isDone() {
        return "Dead".equals(state.getClass().getSimpleName());
    }

    @Override
    public String toString() {
        return String.join("\n", logs);
    }
}
