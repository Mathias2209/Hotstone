package hotstone.standard;

import hotstone.framework.Card;
import hotstone.framework.Player;

public class StandardCard implements Card {

    private final String name;
    private final int manaCost;
    private final int attack;
    private int health;

    public StandardCard(String name, int manaCost, int attack, int health) {

    this.name = name;
    this.manaCost = manaCost;
    this.attack = attack;
    this.health = health;

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getManaCost() {
        return manaCost;
    }

    @Override
    public int getAttack() {
        return attack;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public Player getOwner() {
        return null;
    }

    @Override
    public String getEffectDescription() {
        return "";
    }
}
