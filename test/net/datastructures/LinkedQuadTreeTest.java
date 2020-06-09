package net.datastructures;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedQuadTreeTest {

    @Test
    public void addNWTest() {
        LinkedQuadTree<String> qt = new LinkedQuadTree<>();
        Position<String> r = qt.addRoot("A");
        qt.addNW(r, "B");
        assertEquals("A", qt.root().getElement());
        assertEquals("B", qt.nw(qt.root()).getElement());

        qt.addNW(qt.nw(qt.root()), "C");
        assertEquals("A", qt.root().getElement());
        assertEquals("B", qt.nw(qt.root()).getElement());
        assertEquals("C", qt.nw(qt.nw(qt.root())).getElement());
    }

    @Test
    public void addNETest() {
        LinkedQuadTree<String> qt = new LinkedQuadTree<>();
        Position<String> r = qt.addRoot("R");
        qt.addNE(r, "S");
        assertEquals("R", qt.root().getElement());
        assertEquals("S", qt.ne(qt.root()).getElement());

        qt.addNE(qt.ne(qt.root()), "T");
        qt.addNE(qt.ne(qt.ne(qt.root())), "U");
        assertEquals("R", qt.root().getElement());
        assertEquals("S", qt.ne(qt.root()).getElement());
        assertEquals("T", qt.ne(qt.ne(qt.root())).getElement());
        assertEquals("U", qt.ne(qt.ne(qt.ne(qt.root()))).getElement());
    }

    @Test
    public void addSWTest() {
        LinkedQuadTree<String> qt = new LinkedQuadTree<>();
        Position<String> r = qt.addRoot("10");
        qt.addSW(r, "14");
        assertEquals("10", qt.root().getElement());
        assertEquals("14", qt.sw(qt.root()).getElement());

        qt.addSW(qt.sw(qt.root()), "5");
        qt.addSW(qt.sw(qt.sw(qt.root())), "7");
        qt.addSW(qt.sw(qt.sw(qt.sw(qt.root()))), "12");
        assertEquals("10", qt.root().getElement());
        assertEquals( "14", qt.sw(qt.root()).getElement());
        assertEquals("5", qt.sw(qt.sw(qt.root())).getElement());
        assertEquals("7", qt.sw(qt.sw(qt.sw(qt.root()))).getElement());
        assertEquals("12", qt.sw(qt.sw(qt.sw(qt.sw(qt.root())))).getElement());

    }

    @Test
    public void addSETest() {
        LinkedQuadTree<String> qt = new LinkedQuadTree<>();
        Position<String> r = qt.addRoot("x");
        qt.addSE(qt.root(), "o");
        qt.addSE(qt.se(qt.root()), "b");
        qt.addSE(qt.se(qt.se(qt.root())), "k");
        assertEquals("x", qt.root().getElement());
        assertEquals("o", qt.se(qt.root()).getElement());
        assertEquals("b", qt.se(qt.se(qt.root())).getElement());
        assertEquals("k", qt.se(qt.se(qt.se(qt.root()))).getElement());


        qt.addSE(qt.se(qt.se(qt.se(qt.root()))), "y");
        assertEquals("x", qt.root().getElement());
        assertEquals("o", qt.se(qt.root()).getElement());
        assertEquals("b", qt.se(qt.se(qt.root())).getElement());
        assertEquals("k", qt.se(qt.se(qt.se(qt.root()))).getElement());
        assertEquals("y", qt.se(qt.se(qt.se(qt.se(qt.root())))).getElement());

    }

    @Test
    public void setTest() {
        // write a test for the LinkedQuadTree.set method
        LinkedQuadTree<String> qt = new LinkedQuadTree<>();
        Position<String> r = qt.addRoot("A");
        qt.addNW(r, "B");
        assertEquals("A", qt.root().getElement());
        assertEquals("B", qt.nw(qt.root()).getElement());

        qt.set(qt.nw(qt.root()), "D");
        qt.addNE(qt.nw(qt.root()), "X");
        assertEquals("A", qt.root().getElement());
        assertEquals("D", qt.nw(qt.root()).getElement());
        assertEquals("X", qt.ne(qt.nw(qt.root())).getElement());

        qt.set(qt.ne(qt.nw(qt.root())), "M");
        assertEquals("A", qt.root().getElement());
        assertEquals("D", qt.nw(qt.root()).getElement());
        assertEquals("M", qt.ne(qt.nw(qt.root())).getElement());

    }

    @Test
    public void everythingTest() {
        LinkedQuadTree<String> qt = new LinkedQuadTree<>();
        Position<String> r = qt.addRoot("H");
        qt.addNW(r,"Y");
        qt.addNE(r, "L");
        qt.addSW(r, "O");
        qt.addSE(r, "B");
        assertEquals("H", qt.root().getElement());
        assertEquals("Y", qt.nw(qt.root()).getElement());
        assertEquals("L", qt.ne(qt.root()).getElement());
        assertEquals("O", qt.sw(qt.root()).getElement());
        assertEquals("B", qt.se(qt.root()).getElement());

        qt.addNW(qt.nw(qt.root()), "I");
        qt.set(qt.sw(qt.root()), "F");
        assertEquals("H", qt.root().getElement());
        assertEquals("Y", qt.nw(qt.root()).getElement());
        assertEquals("L", qt.ne(qt.root()).getElement());
        assertEquals("F", qt.sw(qt.root()).getElement());
        assertEquals("B", qt.se(qt.root()).getElement());
        assertEquals("I", qt.nw(qt.nw(qt.root())).getElement());

        qt.addSE(qt.sw(qt.root()), "W");
        qt.addNE(qt.se(qt.sw(qt.root())), "N");
        qt.addSE(qt.se(qt.sw(qt.root())), "U");
        qt.set(qt.se(qt.sw(qt.root())), "Z");
        qt.set(qt.ne(qt.se(qt.sw(qt.root()))), "C");

        assertEquals("H", qt.root().getElement());
        assertEquals("Y", qt.nw(qt.root()).getElement());
        assertEquals("L", qt.ne(qt.root()).getElement());
        assertEquals("F", qt.sw(qt.root()).getElement());
        assertEquals("B", qt.se(qt.root()).getElement());
        assertEquals("I", qt.nw(qt.nw(qt.root())).getElement());

        assertEquals("Z", qt.se(qt.sw(qt.root())).getElement());
        assertEquals("C", qt.ne(qt.se(qt.sw(qt.root()))).getElement());
        assertEquals("U", qt.se(qt.se(qt.sw(qt.root()))).getElement());
    }
}