public class RoadBlock {
    private final Location left;
    private final Location right;

    public RoadBlock(Location loc, Direction dir) {
        Location neighbor = loc.neighbor((dir));

        // lexikografisch sortieren
        if (loc.compareTo(neighbor) <= 0) {
            this.left = loc;
            this.right = neighbor;
        } else {
            this.left = neighbor;
            this.right = loc;
        }
    }

    public Location getLeft() {
        return left;
    }

    public Location getRight() {
        return right;
    }
}
