import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

        assertEquals(2, list.get(0));
        assertEquals(3, list.get(1));
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

    @Test
    void shouldFindLengthOfLinkedList() {
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        assertEquals(4, list.length());
    }

    @Test
    void shouldRemoveANode() {
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.remove(2);

        assertEquals(40,list.get(2));
        assertEquals(3,list.length());
    }

    @Test
    void shouldRemoveHeadNode() {
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.remove(0);

        assertEquals(20,list.get(0));
    }

    @Test
    void shouldAddFirst() {
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        list.addFirst(40);

        assertEquals(40,list.get(0));
    }

    @Test
    void shouldAddNewNode() {
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(0,45);
        list.add(2,25);

        assertEquals(25,list.get(2));
        assertEquals(45,list.get(0));
    }

    @Test
    void shouldInsertAtGivenPosition() { //10, 20, 30, // 10,40,20,30 // 10 40 50 20 30
        list.insert(10,1);
        list.insert(20,2);
        list.insert(30,3);
        list.insert(40,2);
        list.insert(50,3);

        assertEquals(40, list.get(1));
        assertEquals(20, list.get(3));

    }

    @Test
    void shouldDeleteFirst() {
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.deleteFirst();

        assertEquals(20,list.get(0));

    }

    @Test
    void shouldDeleteValueOfGivenIndex() {
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        list.delete(1);

        assertEquals(30, list.get(1));
    }

    @Test
    void shouldDeleteLastNode() {
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        list.deleteLast();

        assertEquals(3, list.length());
    }

    @Test
    void shouldFindMiddleNodeWhenListContainsEvenNumberOfElements() {
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        assertEquals(20,list.findMiddleNode());
    }

    @Test
    void shouldFindMiddleNodeWhenListContainsOddNumberOfElements() {
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        assertEquals(30,list.findMiddleNode());
    }

    @Test
    void shouldFindNthNodeFromEndFromLinkedList(){
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        assertEquals(40,list.findNthNode(2));
    }

    @Test
    void shouldDeleteDuplicateNodeFromLinkedList() {
        list.add(10);
        list.add(20);
        list.add(20);
        list.add(40);
        list.add(50);
        list.deleteDuplicate();

        assertEquals(40,list.get(2));
    }

    @Test
    void shouldInsertNodeToSortedList() {
        list.add(10);
        list.add(20);
        list.add(28);
        list.add(40);
        list.add(50);
        list.insertNodeToSortedList(25);

        assertEquals(6, list.length());
        assertEquals(25, list.get(2));
    }@Test
    void shouldInsertDuplicateNodeToSortedList() {
        list.add(10);
        list.add(20);
        list.add(25);
        list.add(40);
        list.add(50);
        list.insertNodeToSortedList(25);

        assertEquals(6, list.length());
        assertEquals(25, list.get(2));
    }

    @Test
    void shouldDeleteGivenNodeByValue() {
        list.add(10);
        list.add(20);
        list.add(25);
        list.add(40);
        list.add(50);
        list.delete(Integer.valueOf(25));
        assertEquals(4, list.length());
        assertEquals(40,list.get(2));
    }
}