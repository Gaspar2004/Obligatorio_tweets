package src;

import BST.BST;

import static org.junit.jupiter.api.Assertions.*;
public class BSTTest {
    //add, find, contains, remove, findMin, findMax, inOrder
    @org.junit.jupiter.api.Test
    void add() {
        BST arbolDePrueba = new BST();
        arbolDePrueba.add(1, "a");
        arbolDePrueba.add(5, "b");
        arbolDePrueba.add(3, "c");
        assertEquals("a", arbolDePrueba.find(1));
        assertEquals("b", arbolDePrueba.find(5));
        assertEquals("c", arbolDePrueba.find(3));
        assertEquals(null, arbolDePrueba.find(2));
        assertEquals ( 3, arbolDePrueba.size() );
    }
    @org.junit.jupiter.api.Test
    void find() {
        BST arbolDePrueba = new BST();
        arbolDePrueba.add(1, "a");
        arbolDePrueba.add(5, "b");
        arbolDePrueba.add(3, "c");
        assertEquals("a", arbolDePrueba.find(1));
        assertEquals("b", arbolDePrueba.find(5));
        assertEquals("c", arbolDePrueba.find(3));
        assertEquals(null, arbolDePrueba.find(2));
    }

    @org.junit.jupiter.api.Test
    void contains() {
        BST arbolDePrueba = new BST();
        arbolDePrueba.add(1, "a");
        arbolDePrueba.add(5, "b");
        arbolDePrueba.add(3, "c");
        assertEquals(true, arbolDePrueba.contains(1));
        assertEquals(true, arbolDePrueba.contains(5));
        assertEquals(true, arbolDePrueba.contains(3));
        assertEquals(false, arbolDePrueba.contains(2));
    }
    @org.junit.jupiter.api.Test
    void remove() {
        BST arbolDePrueba = new BST();
        arbolDePrueba.add(1, "a");
        arbolDePrueba.add(5, "b");
        arbolDePrueba.add(3, "c");
        assertEquals ( 3, arbolDePrueba.size() );

        arbolDePrueba.remove(1);
        assertEquals(false, arbolDePrueba.contains(1));
        assertEquals(true, arbolDePrueba.contains(5));
        assertEquals(true, arbolDePrueba.contains(3));

        arbolDePrueba.remove(5);
        assertEquals(false, arbolDePrueba.contains(1));
        assertEquals(false, arbolDePrueba.contains(5));
        assertEquals(true, arbolDePrueba.contains(3));

        arbolDePrueba.remove(3);
        assertEquals(false, arbolDePrueba.contains(1));
        assertEquals(false, arbolDePrueba.contains(5));
        assertEquals(false, arbolDePrueba.contains(3));
        assertEquals ( 0, arbolDePrueba.size() );
    }
    @org.junit.jupiter.api.Test
    void findMin() {
        BST arbolDePrueba = new BST();
        arbolDePrueba.add(1, "a");
        arbolDePrueba.add(5, "b");
        arbolDePrueba.add(3, "c");
        assertEquals(1, arbolDePrueba.findMin());
    }
    @org.junit.jupiter.api.Test
    void findMax() {
        BST arbolDePrueba = new BST();
        arbolDePrueba.add(1, "a");
        arbolDePrueba.add(5, "b");
        arbolDePrueba.add(3, "c");
        assertEquals(5, arbolDePrueba.findMax());
    }
    @org.junit.jupiter.api.Test
    void inOrder() {
        BST arbolDePrueba = new BST();
        arbolDePrueba.add(1, "a");
        arbolDePrueba.add(5, "b");
        arbolDePrueba.add(3, "c");
        assertEquals(1, arbolDePrueba.inOrder().get(0));
        assertEquals(3, arbolDePrueba.inOrder().get(1));
        assertEquals(5, arbolDePrueba.inOrder().get(2));
    }
}
