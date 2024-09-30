package com.techelevator;

public class SlotGame extends Game{

    public SlotGame() {
        super(House.generateNewId("SL"));
    }

    public SlotGame(String id) {
        super(id);
    }

    @Override
    public String toString() {
        return getName() + ": a slot game where you are sure to have fun and win a lot";
    }
}
