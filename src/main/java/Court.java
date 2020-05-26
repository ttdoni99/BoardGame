public class Court {

    private Field[][] fields;

    public Court(int row, int column) {
        this.fields = new Field[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                this.fields[i][j] = new Field();
            }
        }
    }

    public void startingState(Player palyer1, Player player2) {
        this.fields[0][0].addPuppet(new Puppet(palyer1));
        this.fields[1][0].addPuppet(new Puppet(palyer1));
        this.fields[2][0].addPuppet(new Puppet(palyer1));
        this.fields[1][5].addPuppet(new Puppet(palyer1));
        this.fields[2][5].addPuppet(new Puppet(palyer1));
        this.fields[3][5].addPuppet(new Puppet(palyer1));

        this.fields[0][4].addPuppet(new Puppet(player2));
        this.fields[1][4].addPuppet(new Puppet(player2));
        this.fields[2][4].addPuppet(new Puppet(player2));
        this.fields[1][9].addPuppet(new Puppet(player2));
        this.fields[2][9].addPuppet(new Puppet(player2));
        this.fields[3][9].addPuppet(new Puppet(player2));
    }

    public void trackImage() {

        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[i].length; j++) {
                if (!fields[i][j].isEmpty()) {
                    System.out.print(fields[i][j].getPuppet().getParentNameDogtag()+"|");
                } else {
                    System.out.print("_|");
                }
            }
            System.out.println();
        }
    }
}
