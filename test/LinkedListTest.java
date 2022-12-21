import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    private LinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new LinkedList<>();
    }

    @Test
    void shouldAddNumberToLinkedList() {
        int number = 2;
        list.add(number);
        list.add(3);

        assertEquals(2,list.get(0));
        assertEquals(3,list.get(1));
    }

    @Test
    void shouldThrowArrayIndexOutOfBoundException() {
        list.add(2);
        list.add(7);

        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.get(2));
        assertEquals("Array index out of range: 2", arrayIndexOutOfBoundsException.getMessage());
    }

    @Test
    void shouldAddStringToLinkedList() {
        LinkedList<String> strings = new LinkedList<>();
        strings.add("xxx");

        assertEquals("xxx", strings.get(0));
    }
}