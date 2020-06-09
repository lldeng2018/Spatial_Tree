package net.datastructures;

import org.junit.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.junit.Assert.*;

public class SpatialTreeMapTest {

    private SpatialTreeMap<Integer, Integer, Integer> small() {
        SpatialTreeMap<Integer, Integer, Integer> m = new SpatialTreeMap<>();
        m.put(new Coord<>(0, 0), 0);
        m.put(new Coord<>(-3, 4), 1);
        m.put(new Coord<>(3, 2), 2);
        m.put(new Coord<>(-5, -6), 3);
        m.put(new Coord<>(6, -5), 4);
        m.put(new Coord<>(10, 12), 5);
        m.put(new Coord<>(7, 7), 6);
        //m.dump();
        return m;
    }

    private SpatialTreeMap<Integer, Integer, Integer> medium() {
        SpatialTreeMap<Integer, Integer, Integer> m = new SpatialTreeMap<>();
        Random r = new Random(2230); // deterministic
        for (int n=0; n<20; n++) {
            int i = r.nextInt(25);
            int j = r.nextInt(25);
            m.put(new Coord<>(i, j), n);
        }
        m.dump();
        return m;
    }

    @Test
    public void testSmallPut() {
        SpatialTreeMap<Integer, Integer, Integer> m = small();
        assertEquals(7, m.size());
        assertEquals(4, m.treeHeight());
    }

    @Test
    public void testMediumPut() {
        SpatialTreeMap<Integer, Integer, Integer> m = medium();
        assertEquals(20, m.size());
        assertEquals(6, m.treeHeight());
    }

    @Test
    public void testSmallGet() {
        SpatialTreeMap<Integer, Integer, Integer> m = small();
        assertEquals(null, m.get(new Coord<>(0,2)));
        assertEquals(null, m.get(new Coord<>(-6,-5)));
        assertEquals((int)3, (int)m.get(new Coord<>(-5,-6)));
        assertEquals((int)6, (int)m.get(new Coord<>(7,7)));
        assertEquals((int)0, (int)m.get(new Coord<>(0,0)));
    }

    @Test
    public void testMediumGet() {
        SpatialTreeMap<Integer, Integer, Integer> m = medium();
        assertEquals(null, m.get(new Coord<>(0,2)));
        assertEquals(null, m.get(new Coord<>(0,0)));
        assertEquals((int)3, (int)m.get(new Coord<>(11,3)));
        assertEquals((int)18, (int)m.get(new Coord<>(10, 15)));
        assertEquals((int)12, (int)m.get(new Coord<>(1,1)));
    }

}