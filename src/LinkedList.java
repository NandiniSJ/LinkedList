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


    public void display(){
        Node current = head;
        while(current != null){
            System.out.print(current.getValue() + "-->" );
            current = current.getNextNode();
        }
        System.out.print("null");
    }

    public int length(){
        if(head == null){
            return 0;
        }
        int count = 0;
        Node current = head;
        while(current != null){
            count++;
            current = current.getNextNode();
        }

        return count;
    }
    public T get(int index) {
        if(index == 0){
           return head.getValue();
        }
        Node<T> currentNode = head;

        int i = 0;
        while (currentNode.getNextNode() != null) {
            currentNode = currentNode.getNextNode();
            i++;

            if(i == index){
             return currentNode.getValue();
            }
        }

        throw new ArrayIndexOutOfBoundsException(index);

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
