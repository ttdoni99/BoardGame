public class Field {

    private Puppet puppet;

    public Field() {
        this.puppet = null;
    }

    public void addPuppet(Puppet puppet) {
        this.puppet = puppet;
    }

    public void removePuppet() {
        this.puppet = null;
    }

    public Puppet getPuppet() {
        return this.puppet;
    }

    public boolean isEmpty() {
        return this.puppet == null;
    }
}

