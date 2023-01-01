public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        //list.display();
        //System.out.println(list.length());
        System.out.println(list.deleteFirst().getValue());
        list.display();


    }
}