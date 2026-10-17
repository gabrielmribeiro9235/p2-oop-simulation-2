package game;

public class Cape implements MarioState {
    private final MarioGame mario;

    protected Cape(MarioGame mario) {
        this.mario = mario;
    }

    @Override
    public void takeFlower() {
        mario.nextState(new Fire(mario));
    }

    @Override
    public void takeFeather() {
        mario.incrementScore();
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
