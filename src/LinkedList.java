public class LinkedList<T extends Comparable> {
    private Node<T> head = null;

    public void add(T number) {
        final Node<T> newNode = new Node<>(number, null);
        if (head == null) {
            head = newNode;
            return;
        }
        Node<T> lastNode = head;
        while (lastNode.getNextNode() != null) {
            lastNode = lastNode.getNextNode();
        }
        lastNode.setNextNode(newNode);

    }

    public void addFirst(T value) {
        Node<T> newNode = new Node<>(value, head);
        head = newNode;
    }

    public void insert(T value, int position) {
        Node<T> newNode = new Node<T>(value, null);
        if (position == 1) {
            newNode.setNextNode(head);
            head = newNode;
        } else {
            Node<T> previous = head;
            int count = 1;
            while (count < position - 1) {
                previous = previous.getNextNode();
                count++;
            }
            Node<T> current = previous.getNextNode();
            previous.setNextNode(newNode);
            newNode.setNextNode(current);


        }
    }


    public void display() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.getValue() + "-->");
            current = current.getNextNode();
        }
        System.out.print("null");
    }

    public int length() {
        if (head == null) {
            return 0;
        }
        int count = 0;
        Node<T> current = head;
        while (current != null) {
            count++;
            current = current.getNextNode();
        }

        return count;
    }

    public Node<T> deleteFirst() {
        if (head == null) {
            return null;
        }
        Node<T> temp = head;
        head = head.getNextNode();
        temp.setNextNode(null);
        return temp;
    }

    public void deleteLast() {
        if (head == null) {
            return;
        }
        if (head.getNextNode() == null) {
            head = null;
            return;
        }

        Node<T> previousNode = head;
        Node<T> currentNode = head;

        while (currentNode.getNextNode() != null) {
            previousNode = currentNode;
            currentNode = currentNode.getNextNode();
        }
        previousNode.setNextNode(null);
    }

    public void delete(int index) {
        if (index == 0) {
            head = head.getNextNode();
            return;
        }
        Node<T> current = head;
        int currentIndex = 0;
        while (currentIndex != index - 1) {
            current = current.getNextNode();
            currentIndex++;
        }
        Node<T> nodeToBeDeleted = current.getNextNode();
        current.setNextNode(nodeToBeDeleted.getNextNode());
        nodeToBeDeleted.setNextNode(null);
    }


    public T get(int index) {
        if (index == 0) {
            return head.getValue();
        }
        Node<T> currentNode = head;

        int i = 0;
        while (currentNode.getNextNode() != null) {
            currentNode = currentNode.getNextNode();
            i++;

            if (i == index) {
                return currentNode.getValue();
            }
        }

        throw new ArrayIndexOutOfBoundsException(index);

    }

    public void add(int index, T value) {
        Node<T> current = head;
        int i = 0;
        if (index == 0) {
            Node<T> newNode = new Node<T>(value, head);
            head = newNode;
            return;
        }
        while (current.getNextNode() != null) {
            i++;
            current = current.getNextNode();
            if (i == index - 1) {
                Node<T> newNode = new Node<>(value, current.getNextNode());
                current.setNextNode(newNode);
                break;
            }
        }
    }

    public void remove(int index) {
        Node<T> current = head;
        int i = 0;

        if (index == 0) {
            head = head.getNextNode();
            return;
        }
        while (current.getNextNode() != null) {
            i++;
            current = current.getNextNode();
            if (i == index - 1) {
                Node<T> nodeToBeDeleted = current.getNextNode();
                current.setNextNode(nodeToBeDeleted.getNextNode());
                return;
            }
        }
    }

    public T findMiddleNode() {
        if (head == null) {
            return null;
        }
        if (head.getNextNode() == null) {
            return head.getValue();
        }

        Node<T> slowPointer = head;
        Node<T> fastPointer = head;
        int count = 1;
        while (fastPointer.getNextNode() != null) {
            count++;
            fastPointer = fastPointer.getNextNode();
            if (count % 2 != 0) {
                slowPointer = slowPointer.getNextNode();
            }
        }
        return slowPointer.getValue();
    }

    public T findNthNode(int n) {
        if (head == null) {
            return null;
        }
        if (head.getNextNode() == null) {
            return head.getValue();
        }
        Node<T> slowPointer = head;
        Node<T> fastPointer = head;
        int count = 1;
        while (fastPointer.getNextNode() != null) {
            count++;
            fastPointer = fastPointer.getNextNode();
            if (count > n) {
                slowPointer = slowPointer.getNextNode();
            }
        }
        return slowPointer.getValue();
    }

    public void deleteDuplicate() {
        if (head == null) {
            return;
        }
        if (head.getNextNode() == null) {
            return;
        }

        Node<T> previous = head;
        Node<T> current = head;
        while (current.getNextNode() != null) {
            previous = current;
            current = current.getNextNode();

            if (previous.getValue() == current.getValue()) {
                Node<T> temp = current.getNextNode();
                current.setNextNode(null);
                previous.setNextNode(temp);
                return;
            }
        }
    }

    public void insertNodeToSortedList(T value){
        Node<T> node = new Node<>(value, null);
        if (head == null) {
            node = head;
        }
        if (head.getNextNode() == null) {
            if(head.getValue().compareTo(node.getValue()) > 0){
                node.setNextNode(head);
                head = node;
            }else{
                head.setNextNode(node);
            }
        }

        Node<T> current = head;
        Node<T> previous = head;
        if(previous.getValue().compareTo(node.getValue())> 0) {
            node.setNextNode(previous);
            head = node;
            return;
        }
        while(current.getNextNode() != null){
            previous = current;
            current = current.getNextNode();

            if(previous.getValue().compareTo(node.getValue()) <= 0 && current.getValue().compareTo(node.getValue()) > 0) {
                previous.setNextNode(node);
                node.setNextNode(current);
                return;
            }
        }
        current.setNextNode(node);
    }

    public void delete(T value){
        if(head == null){
            return;
        }

        if(head.getValue().equals(value)){
            Node<T> temp = head.getNextNode();
            head.setNextNode(null);
            head = temp;
            return;
        }
        Node<T> current = head.getNextNode();
        Node<T> previous = head;
        while(current != null){

            if(current.getValue().equals(value)){
                Node<T> temp = current.getNextNode();
                current.setNextNode(null);
                previous.setNextNode(temp);
            }
            previous = current;
            current = current.getNextNode();
        }
    }

}

class Node<T extends Comparable> {
    private final T value;
    private Node<T> nextNode;

    public Node(T value, Node<T> nextNode) {
        this.value = value;
        this.nextNode = nextNode;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

    public Node<T> getNextNode() {
        return nextNode;
    }

    public T getValue() {
        return value;
    }
}
