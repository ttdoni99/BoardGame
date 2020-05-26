public class Puppet {
    public Player parent;

    public Puppet(Player parent) {
        this.parent = parent;
    }

    public char getParentNameDogtag() {
        return this.parent.getName().charAt(0);
    }
}
