package in.singh.raman.linkedlist;

public class Node {

    public String data;
    public Node next;

    public Node(String data) {
        this.data = data;
    }

    public static void printLinkedList(Node head) {
        Node ptr = head;
        while (ptr != null) {
            System.out.print(ptr.data);
            System.out.print(" -> ");
            ptr = ptr.next;
        }
        System.out.println("X");
    }
}
