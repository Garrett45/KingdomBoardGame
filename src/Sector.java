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

                currentRow[j].setTopLeftNeighbor(previousRow[j]);
                if (j+1 <= 9) currentRow[j].setTopRightNeighbor(previousRow[j+1]);
                if(j-1 >= 0) previousRow[j].setBottomLeftNeighbor(currentRow[j-1]);
                previousRow[j].setBottomRightNeighbor(currentRow[j]);

                if (i < 9) {
                    Hex[] nextRow = rows[i+1].getHexes();

                    currentRow[j].setBottomLeftNeighbor(nextRow[j]);
                    if (j+1 <= 9) currentRow[j].setBottomRightNeighbor(nextRow[j+1]);
                    if (j-1 >= 0) nextRow[j].setTopLeftNeighbor(currentRow[j-1]);
                    nextRow[j].setTopRightNeighbor(currentRow[j]);
                }
            }
        }
    }
}
