package game;

public class Fire implements MarioState {
    private final MarioGame mario;

    protected Fire(MarioGame mario) {
        this.mario = mario;
    }

    @Override
    public void takeFlower() {
        mario.incrementScore();
    }

    @Override
    public void takeFeather() {
        mario.nextState(new Cape(mario));
    }

    @Override
    public void takeMushroom() {
        mario.incrementScore();
    }

    @Override
    public void takeDamage() {
        mario.nextState(new Big(mario));
    }
}
