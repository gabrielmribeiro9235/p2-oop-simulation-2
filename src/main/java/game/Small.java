package game;

public class Small implements MarioState {
    private final MarioGame mario;

    protected Small(MarioGame mario) {
        this.mario = mario;
    }

    @Override
    public void takeFlower() {
        mario.nextState(new Fire(mario));
    }

    @Override
    public void takeFeather() {
        mario.nextState(new Cape(mario));
    }

    @Override
    public void takeMushroom() {
        mario.nextState(new Big(mario));
    }

    @Override
    public void takeDamage() {
        mario.nextState(new Dead());
    }
}
