import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class RoadNetworkTest {

    @Test
    public void testLocationCreation() {
        Location loc = new Location(2, -1);
        assertEquals(2, loc.getX());
        assertEquals(-1, loc.getY());
        assertEquals(-1, loc.getZ()); // z = -x - y
    }

    @Test
    public void testLocationEquality() {
        Location a = new Location(1, -2);
        Location b = new Location(1, -2);
        Location c = new Location(2, -1);
        assertEquals(a, b);
        assertNotEquals(a, c);
    }

    @Test
    public void testLocationCompareTo() {
        Location a = new Location(1, -2);
        Location b = new Location(1, -2);
        Location c = new Location(2, -3);
        assertTrue(a.compareTo(b) == 0);
        assertTrue(a.compareTo(c) < 0);
        assertTrue(c.compareTo(a) > 0);
    }

    @Test
    public void testToStringFormat() {
        Location loc = new Location(1, -3);
        assertEquals("(1,-3,2)", loc.toString());
    }

    @Test
    public void testNeighborComputation() {
        Location center = new Location(0, 0);
        Location northeast = center.neighbor(Direction.NORTHEAST);
        assertEquals(new Location(1, -1), northeast);
        assertEquals(0, northeast.getZ());
    }

    @Test
    public void testRoadBlockOrder() {
        Location a = new Location(0, 0);
        Location b = a.neighbor(Direction.EAST);
        RoadBlock rb = new RoadBlock(a, Direction.EAST);

        assertTrue(rb.getLeft().compareTo(rb.getRight()) < 0);
        assertEquals(rb.getLeft(), a);
        assertEquals(rb.getRight(), b);
    }

    @Test
    public void testRoadNetworkContains() {
        RoadNetwork net = new RoadNetwork(2);

        assertTrue(net.contains(new Location(0, 0)));
        assertTrue(net.contains(new Location(2, -2)));  // äußerster Punkt in Zacke
        assertFalse(net.contains(new Location(3, -3))); // außerhalb des Sterns
    }

    @Test
    public void testRoadNetworkIterator() {
        RoadNetwork net = new RoadNetwork(1);
        Set<Location> iterated = new HashSet<>();
        for (Location loc : net) {
            iterated.add(loc);
        }

        // Im Stern mit k=1 gibt es genau 19 Städte
        assertEquals(19, iterated.size());

        // Zentrum ist immer dabei
        assertTrue(iterated.contains(new Location(0, 0)));
    }
}
