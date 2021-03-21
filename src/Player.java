import java.util.HashSet;
import java.util.Set;

public class Player {
    Color color;
    Set<Hex> settledHexes;
    Set<Hex> clusteredHexes;
    Set<Cluster> clusters;

    private void updateClusters() {
        for (Cluster c : clusters) {
            Set<Hex> clusterHexes = new HashSet<>();
            determineCluster((Hex) c.getHexes().toArray()[0], clusterHexes);
            c.setHexes(clusterHexes);
        }
    }

    public void determineAllClusters(GameBoard gb) {
        updateClusters();

        for (Hex hex : settledHexes) {
            if (!clusteredHexes.contains(hex)) {
                clusters.add(determineCluster(hex));
            }
        }
    }

    public Cluster determineCluster(Hex hex) {
        Cluster c = new Cluster();
        Set<Hex> hexesInCluster = new HashSet<>();
        determineCluster(hex, hexesInCluster);
        c.setHexes(hexesInCluster);
        return c;
    }

    private Set<Hex> determineCluster(Hex lastPlayedHex, Set<Hex> foundHexes) {
        foundHexes.add(lastPlayedHex);
        clusteredHexes.add(lastPlayedHex);

        for (Hex hex : lastPlayedHex.getNeighbors()) {
            if (hex.getColor() == color && !foundHexes.contains(hex)) {
                foundHexes.addAll(determineCluster(hex, foundHexes));
            }
        }

        return foundHexes;
    }
}
