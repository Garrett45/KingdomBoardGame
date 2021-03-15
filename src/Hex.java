public class Hex {
    Hex[] neighbors;
    Terrain terrain;
    Color color;

    public Hex() {
        this(null, new Hex[]{null, null, null, null, null, null});
    }

    public Hex(Terrain inputTerrain) {
        this(inputTerrain, new Hex[]{null, null, null, null, null, null});
    }

    public Hex(Terrain inputTerrain, Hex[] inputNeighbors) {
        if (inputNeighbors.length != 6) throw new IllegalArgumentException("neighbor array needs to be of length 6");
        //we could copy by reference but we'll just do this
        neighbors = new Hex[6];
        System.arraycopy(inputNeighbors, 0, neighbors, 0, 6);

        terrain = inputTerrain;

        //set color to null because you settle after game starts
        color = null;
    }

    public Hex getTopLeftNeighbor() {
        return neighbors[0];
    }

    public Hex getTopRightNeighbor() {
        return neighbors[1];
    }

    public Hex getRightNeighbor() {
        return neighbors[2];
    }

    public Hex getBottomRightNeighbor() {
        return neighbors[3];
    }

    public Hex getBottomLeftNeighbor() {
        return neighbors[4];
    }

    public Hex getLeftNeighbor() {
        return neighbors[5];
    }

    public void setTopLeftNeighbor(Hex inputHex) {
        neighbors[0] = inputHex;
    }

    public void setTopRightNeighbor(Hex inputHex) {
        neighbors[1] = inputHex;
    }

    public void setRightNeighbor(Hex inputHex) {
        neighbors[2] = inputHex;
    }

    public void setBottomRightNeighbor(Hex inputHex) {
        neighbors[3] = inputHex;
    }

    public void setBottomLeftNeighbor(Hex inputHex) {
        neighbors[4] = inputHex;
    }

    public void setLeftNeighbor(Hex inputHex) {
        neighbors[5] = inputHex;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public Color getColor() {
        return color;
    }

    public boolean canSettleOn() {
        return terrain != Terrain.MOUNTAIN && terrain != Terrain.WATER && color == null;
    }

    public void settle(Color playerColor) {
        if(!this.canSettleOn()) throw new IllegalStateException("can not settle here");
        color = playerColor;
    }
}
