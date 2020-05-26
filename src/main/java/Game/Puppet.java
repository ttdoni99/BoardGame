package Game;

import Game.Player;

public class Puppet {
    public Player parent;

    /**
     * Bábú objektum létrehozása.
     * @param parent Az adott bábúhoz tartozó játékos eltárolása
     */
    public Puppet(Player parent) {
        this.parent = parent;
    }

    /**
     * Visszatér az adott bábúhoz tartozó játékos nevének kezdőbetűjével.
     * @return visszatér az első karakterrel
     */
    public char getParentNameDogtag() {
        return this.parent.getName().charAt(0);
    }

    /**
     * Megizsgálja, hogy az aktuális játékos a saját bábújával lép.
     * @param parent Aktuális játékos
     * @return visszatér azzal, hogy ennek a bábúnak a parameter játékos tényleg a szülője-e vagy sem
     */
    public boolean itIsMyParent(Player parent){
        return parent== this.parent;
    }
}
