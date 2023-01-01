public class LinkedList<T> {
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

    public void insert(T value, int position){
        Node<T> newNode = new Node<T>(value,null);
        if(position ==1){
            newNode.setNextNode(head);
            head = newNode;
        }else {
            Node<T> previous = head;
            int count = 1;
            while(count < position - 1){
                previous = previous.getNextNode();
                count++;
            }
            Node<T> current = previous.getNextNode();
            previous.setNextNode(newNode);
            newNode.setNextNode(current);


        }
    }


    public void display() {
        Node current = head;
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
        Node current = head;
        while (current != null) {
            count++;
            current = current.getNextNode();
        }

        return count;
    }

    public Node deleteFirst(){
        if(head == null){
            return null;
        }
        Node<T> temp = head;
        head = head.getNextNode();
        temp.setNextNode(null);
        return temp ;
    }

    public void deleteLast(){
        if(head == null){
            return;
        }
        if(head.getNextNode() == null){
            head = null;
            return;
        }

        Node<T> previousNode = head;
        Node<T> currentNode = head;

        while(currentNode.getNextNode() != null){
            previousNode = currentNode;
            currentNode = currentNode.getNextNode();
        }
        previousNode.setNextNode(null);
    }

    public void delete(int index){
        if(index == 0){
            head = head.getNextNode();
            return;
        }
        Node<T> current = head;
        int currentIndex = 0;
        while(currentIndex != index-1){
            current = current.getNextNode();
            currentIndex ++;
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
        if(index == 0){
            Node<T> newNode = new Node<>(value, head);
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

    public void remove(int index){
        Node<T> current = head;
        int i = 0;

        if(index == 0){
            head = head.getNextNode();
            return;
        }
        while(current.getNextNode() != null){
            i++;
            current = current.getNextNode();
            if(i == index-1){
                Node<T> nodeToBeDeleted = current.getNextNode();
                current.setNextNode(nodeToBeDeleted.getNextNode());
                return;
            }
        }
    }
}

class Node<T> {
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
