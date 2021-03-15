public class Sector {
    SectorRow[] rows;

    public Sector() {
        rows = new SectorRow[10];

        for (int i = 0; i < 10; i++) {
            rows[i] = new SectorRow();
        }

        for (int i = 1; i < 10; i=i+2) {
            for (int j = 0; j < 10; j++) {
                Hex[] currentRow = rows[i].getHexes();
                Hex[] previousRow = rows[i-1].getHexes();

                currentRow[j].setNWNeighbor(previousRow[j]);
                if (j+1 <= 9) currentRow[j].setNENeighbor(previousRow[j+1]);
                if(j-1 >= 0) previousRow[j].setSWNeighbor(currentRow[j-1]);
                previousRow[j].setSENeighbor(currentRow[j]);

                if (i < 9) {
                    Hex[] nextRow = rows[i+1].getHexes();

                    currentRow[j].setSWNeighbor(nextRow[j]);
                    if (j+1 <= 9) currentRow[j].setSENeighbor(nextRow[j+1]);
                    if (j-1 >= 0) nextRow[j].setNWNeighbor(currentRow[j-1]);
                    nextRow[j].setNENeighbor(currentRow[j]);
                }
            }
        }
    }
}
