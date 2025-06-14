public class Location implements Comparable<Location>{
    private final int x;
    private final int y;
    private final int z;

    public Location(int x, int y){
        this.x = x;
        this.y = y;
        this.z = -x-y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Location other = (Location) obj;
        return x == other.x && y == other.y && z == other.z;
    }


    @Override
    public int hashCode() {
        return 31 * x + 17 * y + z;
    }

    @Override
    public String toString(){
        return "("+x+","+y+","+z+")";
    }

    @Override
    public int compareTo(Location other) {
        if (this.x != other.x) {
            return Integer.compare(this.x, other.x);
        } else if (this.y != other.y) {
            return Integer.compare(this.y, other.y);
        } else {
            return Integer.compare(this.z, other.z);
        }
    }

    public Location neighbor(Direction dir){
        int newX = this.x + dir.deltaX();
        int newY = this.y + dir.deltaY();
        // z wird automatisch berechnet als -x - y
        return new Location(newX, newY);
    }


}
