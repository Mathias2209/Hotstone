package hotstone.standard;

import hotstone.framework.Hero;
import hotstone.framework.Player;

public class StandardHero implements Hero {

    private final String type;
    private int mana;
    private final String effectDescription;
    private int health;

    public StandardHero(String type, int mana, String effectDescription, int health) {

        this.type = type;
        this.mana = mana;
        this.effectDescription = effectDescription;
        this.health = health;

    }


    @Override
    public int getMana() {
        return mana;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public boolean canUsePower() {
        return false;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public Player getOwner() {
        return null;
    }

    @Override
    public String getEffectDescription() {
        return effectDescription;
    }
}
