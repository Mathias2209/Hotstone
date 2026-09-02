package hotstone.standard;

import hotstone.framework.Card;
import hotstone.framework.Player;

public class StandardCard implements Card {

    private final String name;
    private final int manaCost;
    private final int attack;
    private int health;
    private final Player owner;

    public StandardCard(String name, int manaCost, int attack, int health, Player owner) {

    this.name = name;
    this.manaCost = manaCost;
    this.attack = attack;
    this.health = health;
    this.owner = owner;

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
        return owner;
    }

    @Override
    public String getEffectDescription() {
        return "";
    }
}
