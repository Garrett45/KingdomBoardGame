public class LocationHex extends Hex{
    int tiles = 2;

    @Override
    public boolean canSettleOn() {
        return false;
    }

    public void pullTile() {
        tiles--;
    }
}
