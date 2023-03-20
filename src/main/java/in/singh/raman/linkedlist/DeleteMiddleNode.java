package in.singh.raman.linkedlist;

/**
 * Problem - You are given a random element in the linked list (not head or last element) You need to delete it
 *           You don't have access to Head node
 *
 * Solution - Copy data of the next node to current node and delete the next node
 */
public class DeleteMiddleNode {
    public static void main(String[] args) {
        Node node1 = new Node("1");
        Node node2 = new Node("2");
        Node node3 = new Node("3");
        Node node4 = new Node("3");
        Node node5 = new Node("2");
        Node node6 = new Node("1");

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        Node.printLinkedList(node1);
        deleteNode(node4);
        Node.printLinkedList(node1);
    }

    private static void deleteNode(Node node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }
}
