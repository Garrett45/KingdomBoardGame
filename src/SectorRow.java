public class SectorRow {
    Hex[] hexes;

    public SectorRow() {
        hexes = new Hex[10];

        for (int i = 0; i < 10; i++) {
            hexes[i] = new Hex();
            if (i - 1 >= 0) {
                hexes[i-1].setRightNeighbor(hexes[i]);
                hexes[i].setLeftNeighbor(hexes[i-1]);
            }
        }
    }

    public Hex[] getHexes() {
        return hexes;
    }
}
