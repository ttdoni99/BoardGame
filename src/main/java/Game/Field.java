package Game;

public class Field {

    private Puppet puppet;

    /**
     * Mező objektum létrehozása
     */
    public Field() {
        this.puppet = null;
    }

    /**
     * Hozzáad egy bábú objektumot az adott mezőhőz
     * @param puppet bábú objektum
     */
    public void addPuppet(Puppet puppet) {
        this.puppet = puppet;
    }

    /**
     * Kit0rli az adott bábút a mezőről.
     */
    public void removePuppet() {
        this.puppet = null;
    }

    /**
     * A mezőhőz tartozó bábút visszaadja.
     * @return visszaadja az adott bábút ami a mezőn ál
     */
    public Puppet getPuppet() {
        return this.puppet;
    }

    /**
     * A mező üres-e.
     * @return visszatér a mezőn lévő bábú állapotával
     */
    public boolean isEmpty() {
        return this.puppet == null;
    }
}

