package Review;

import Review.NewNode;

public class Test {
    public static void main(String[] args) {
//        NewNode node1 = new NewNode(1);
//        NewNode node2 = new NewNode(2);
//        NewNode node3 = new NewNode(3);
//        NewNode node4 = new NewNode(4);
//        System.out.println(node1);
//        System.out.println(node2);
//        node1.next = node2;
//        System.out.println(node1.next);
//        node2.next = node3;
//        node3.next = node4;
//        NewNode current = node1;
//        while (current!=null){
//            System.out.println(current.id);
//            current = current.next;
//        }

        UserLinkedList list = new UserLinkedList();
        list.insertLastPosition(new UserNode("Jonh", "Doe"));
        list.insertLastPosition(new UserNode("Mike", "Smith"));
        list.insertLastPosition(new UserNode("Luke", "Skywalker"));
        list.printLinkedList();
    }
}
