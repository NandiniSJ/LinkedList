public class LinkedList<T> {
    private Node<T> head = null;

    public void add(T number){
        final Node<T> newNode = new Node<>(number, null);
        if(head == null){
            head = newNode;
            return;
        }
        Node<T> lastNode = head;
        while(lastNode.getNextNode() != null){
            lastNode = lastNode.getNextNode();
        }
        lastNode.setNextNode(newNode);

    }

    public T get(int index){
        if(index == 0){
            return head.getValue();
        }
        int i = 0;
        Node<T> currentNode = head;
        while (currentNode.getNextNode() != null){
            currentNode = currentNode.getNextNode();
            i++;
            if (i == index){
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
