import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class RoadNetwork implements Iterable<Location>{
    private final int k;
    private final Set<RoadBlock> roadBlocks;

    public RoadNetwork(int k) {
        if (k < 1) {
            throw new IllegalArgumentException("k<1");
        }
        else {
            this.k = k;
            roadBlocks = new HashSet<>();
        }
    }

    public boolean contains(Location loc) {
        int x = loc.getX();
        int y = loc.getY();
        int z = loc.getZ();

        // x + y + z muss 0 sein (wird durch Konstruktor garantiert)
        int absX = Math.abs(x);
        int absY = Math.abs(y);
        int absZ = Math.abs(z);

        // Gültig ist: jede Koordinate liegt im Bereich [-k, k]
        // UND die Summe der absoluten Koordinaten ist <= 2 * k
        return absX <= k && absY <= k && absZ <= k && (absX + absY + absZ) <= 2 * k;
    }



    public void addRoadBlock(RoadBlock roadBlock) {
        if (contains(roadBlock.getLeft()) && contains(roadBlock.getRight())) {
            roadBlocks.add(roadBlock);
        }
        else {
            throw new IllegalArgumentException("nicht teil der Straßen netzes");
        }
    }

    public boolean canDrive(Location loc, Direction dir) {
        Location n = loc.neighbor(dir);
        for (RoadBlock r : roadBlocks) {
            if ((r.getLeft() == loc || r.getRight() == loc) && (r.getLeft() == n || r.getRight() == n)) {
                return false;
            }
        }

        if (!(contains(loc) && contains(n))) {
            return false;
        }
        else {
            return true;
        }
    }


    @Override
    public Iterator<Location> iterator() {
        List<Location> allLocations = new ArrayList<>();
        for (int x = -k; x <= k; x++) {
            for (int y = -k; y <= k; y++) {
                Location loc = new Location(x, y); // z wird intern berechnet
                if (contains(loc)) {
                    allLocations.add(loc);
                }
            }
        }
        return allLocations.iterator();
    }


}
