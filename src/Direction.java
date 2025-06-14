public enum Direction {
    NORTHEAST(1, -1, 0),
    EAST(1, 0, -1),
    SOUTHEAST(0, 1, -1),
    SOUTHWEST(-1, 1, 0),
    WEST(-1, 0, 1),
    NORTHWEST(0, -1, 1);

    private final int deltaX;
    private final int deltaY;
    private final int deltaZ;

    Direction(int deltaX, int deltaY, int deltaZ) {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
        this.deltaZ = deltaZ;
    }

    public int deltaX() { return deltaX; }
    public int deltaY() { return deltaY; }
    public int deltaZ() { return deltaZ; }

    public Direction oppositeDirection() {
        return Direction.values()[
                (this.ordinal() + 3) % Direction.values().length];
    }
}
