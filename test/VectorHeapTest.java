import static org.junit.jupiter.api.Assertions.*;

class VectorHeapTest {

    @org.junit.jupiter.api.Test
    void add() {
        VectorHeap Vector= new VectorHeap();
        Vector.add("A");
        assertEquals("A",Vector.getFirst());
    }

    @org.junit.jupiter.api.Test
    void remove() {
        VectorHeap Vector = new VectorHeap();
        Vector.add("A");
        Vector.add("B");
        Vector.add("C");
        Vector.add("D");
        assertEquals("A",Vector.remove());
    }
}