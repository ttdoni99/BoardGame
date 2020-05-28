package Game;

public class World {

    public Field[][] fields;

    /**
     * Létrehozza az adott sor oszlop számú világot.
     * @param row sor mennyiség
     * @param column oszlop mennyiség
     */
    public World(int row, int column) {
        this.fields = new Field[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                this.fields[i][j] = new Field();
            }
        }
    }

    /**
     * Felhelyzi a játékosok bábúit a táblára.
     * @param player1 első játokos
     * @param player2 második játékos
     */
    public void startingState(Player player1, Player player2) {
        this.fields[0][0].addPuppet(new Puppet(player1));
        this.fields[1][0].addPuppet(new Puppet(player1));
        this.fields[2][0].addPuppet(new Puppet(player1));
        this.fields[1][5].addPuppet(new Puppet(player1));
        this.fields[2][5].addPuppet(new Puppet(player1));
        this.fields[3][5].addPuppet(new Puppet(player1));

        this.fields[0][4].addPuppet(new Puppet(player2));
        this.fields[1][4].addPuppet(new Puppet(player2));
        this.fields[2][4].addPuppet(new Puppet(player2));
        this.fields[1][9].addPuppet(new Puppet(player2));
        this.fields[2][9].addPuppet(new Puppet(player2));
        this.fields[3][9].addPuppet(new Puppet(player2));
    }

    /**
     * Áthelyezi a bábut az egyik helyről a másikra.
     * @param fromRow    honnan sor index
     * @param fromColumn honnan oszlop index
     * @param toRow      hova sor index
     * @param toColumn   hova oszlop index
     * @return visszatér azzal, hogy bábút sikerült e egyik mezőről a másikra átmozgatni
     */
    public boolean movePuppet(Player player, int fromRow, int fromColumn, int toRow, int toColumn) {
        if (this.isCorrectStep(fromRow, fromColumn, toRow, toColumn)) {
            Puppet act = this.getPuppet(fromRow, fromColumn);
            if (act.itIsMyParent(player)) {
                this.removePuppet(fromRow, fromColumn);
                this.addPuppet(toRow, toColumn, act);
                return true;
            }
            return false;
        }
        return false;
    }

    /**
     * Hozzá adja a bábut a megfelelő sor oszlop helyre a táblán.
     * @param row    sor index
     * @param column oszlop index
     * @return visszatér az adott mezőn lévő bábúval ha van
     */
    public Puppet getPuppet(int row, int column) {
        if (!this.isFiledIsEmpty(row, column)) {
            return this.fields[row][column].getPuppet();
        }
        return null;
    }

    /**
     *  Kitőrli az adott mezőn lévő bábút.
     * @param row    sor index
     * @param column oszlop index
     */
    public void removePuppet(int row, int column) {
        if (!this.isFiledIsEmpty(row, column)) {
            this.fields[row][column].removePuppet();
        }
    }

    /**
     * Az act Bábút az adott mezőre rakja.
     * @param row    sor index
     * @param column oszlop index
     * @param act    aktuális bábú
     */
    public void addPuppet(int row, int column, Puppet act) {
        if (this.isFiledIsEmpty(row, column)) {
            this.fields[row][column].addPuppet(act);
        }
    }

    /**
     * Megvizsgálja, hogy az adott bábu lépés-e helyes.
     * @param fromRow    honnan sor index
     * @param fromColumn honnan oszlop index
     * @param toRow      hova sor index
     * @param toColumn   hova oszlop index
     * @return visszatér azzal, hogy az adott végrehajtandó lépés helyes-e vagy sem
     */
    public boolean isCorrectStep(int fromRow, int fromColumn, int toRow, int toColumn) {
        if (this.dimensionsIsCorrect(fromRow, fromColumn) && !this.isFiledIsEmpty(fromRow, fromColumn)) {
//            System.out.println("AHONNAN AKAROM OTT VAN BÁBÚ");
            if (this.dimensionsIsCorrect(toRow, toColumn) && this.isFiledIsEmpty(toRow, toColumn)) {
//                System.out.println("AHOVA RAKNÁM OTT NINCS BÁBÚ");
                int modifiedValue;
                modifiedValue = fromRow - 1;
                if (modifiedValue == toRow && fromColumn == toColumn) {
                    return true;
                }
                modifiedValue = fromRow + 1;
                if (modifiedValue == toRow && fromColumn == toColumn) {
                    return true;
                }
                modifiedValue = fromColumn - 1;
                if (fromRow == toRow && modifiedValue == toColumn) {
                    return true;
                }
                modifiedValue = fromColumn + 1;
                if (fromRow == toRow && modifiedValue == toColumn) {
                    return true;
                }
                return false;
            } else {
                return false;
            }
        }
        return false;
    }

    /**
     * Paraméterül kapott értékekre megvizsgálja, hogy az adott mező szabad-e vagy sem.
     * @param row    sor index
     * @param column oszlop index
     * @return ez a függvény visszaadja, hogy az adott pálya adott pontja szabad-e vagy sem
     */
    public boolean isFiledIsEmpty(int row, int column) {
        if (this.dimensionsIsCorrect(row, column)) {
            return this.fields[row][column].isEmpty();
        }
        return false;
    }

    /**
     * Megvizsgálja, hogy sor oszlop értékei helyesek-e.
     * @param row    sor index
     * @param column oszlop index
     * @return visszatér azzal, hogy az adott sor, oszlop értékek a világ méretéhez képest helyesek-e vagy sem
     */
    public boolean dimensionsIsCorrect(int row, int column) {
        return row >= 0 && row <= 3 && column >= 0 && column <= 9;
    }

    /**
     * Megvizsgálja, hogy a paraméterül kapott játékosnak van e 4 bábúja egymás mellett.
     * @param player Adott játékos
     * @return visszatér, ha az adott player nyert-e vagy sem
     */
    public boolean somebodyIsWin(Player player) {
        Puppet act;
        int beside;
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[i].length; j++) {
                act = this.fields[i][j].getPuppet();
                if (act != null && act.itIsMyParent(player)) {
                    beside = 1;
                    for (int k = i + 1; k < i + 4; k++) {//row
                        if (this.dimensionsIsCorrect(k, j)) {
                            act = this.fields[k][j].getPuppet();
                            if (act != null && act.itIsMyParent(player)) {
                                beside++;
                            }
                        }
                    }
//                    System.out.println(beside+" row");
                    if (beside == 4) {
                        return true;
                    }
                    beside = 1;
                    for (int k = j + 1; k < j + 4; k++) {//colunm
                        if (this.dimensionsIsCorrect(i, k)) {
                            act = this.fields[i][k].getPuppet();
                            if (act != null && act.itIsMyParent(player)) {
                                beside++;
                            }
                        }
                    }
//                    System.out.println(beside+" colunm");
                    if (beside == 4) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * A világ reprezentációjának terminálbeli szöveges megfelelője.
     */
    public void terminalImage() {
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[i].length; j++) {
                if (!fields[i][j].isEmpty()) {
                    System.out.print(fields[i][j].getPuppet().getParentNameDogtag() + "|");
                } else {
                    System.out.print("_|");
                }
            }
            System.out.println();
        }
    }
}
