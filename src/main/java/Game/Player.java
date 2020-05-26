package Game;

public class Player {

    private String name;

    /**
     * A játékos objektum létrehozása.
     * @param name nev
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * A játékos nevét adja vissza.
     * @return visszatér a játékos nevével
     */
    public String getName() {
        return this.name;
    }
}

