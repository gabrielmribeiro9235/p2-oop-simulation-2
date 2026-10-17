package game;

public class Dead implements MarioState {
    protected Dead() {}

    @Override
    public void takeFlower() {
        throw new GameRuleViolationException("Mario can not take flower if he is dead.");
    }

    @Override
    public void takeFeather() {
        throw new GameRuleViolationException("Mario can not take feather if he is dead.");
    }

    @Override
    public void takeMushroom() {
        throw new GameRuleViolationException("Mario can not take mushroom if he is dead.");
    }

    @Override
    public void takeDamage() {
        throw new GameRuleViolationException("Mario can not take damage if he is dead.");
    }
}
