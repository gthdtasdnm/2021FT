import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
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

        int countInRange = 0;
        if (Math.abs(x) <= k) countInRange++;
        if (Math.abs(y) <= k) countInRange++;
        if (Math.abs(z) <= k) countInRange++;

        return countInRange >= 2;
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
        return new RoadNetworkIterator();
    }

    private class RoadNetworkIterator implements Iterator<Location> {

        private List<Location> allLocations = new ArrayList<>();

        public RoadNetworkIterator(){
            for(int i = -2 * k; i <= 2 * k; i++){
                for(int j = -2 * k; j <= 2 * k; j++){
                    if(contains(new Location(i,j))) {
                        allLocations.add(new Location(i, j));
                    }

                }
            }
        }

        @Override
        public boolean hasNext() {
            return !allLocations.isEmpty();
        }

        @Override
        public Location next() {
            Location res = allLocations.getFirst();
            allLocations.removeFirst();
            return res;
        }
    }

}
