package in.singh.raman.linkedlist.duplicates;

import in.singh.raman.linkedlist.Node;

import java.util.HashSet;

/**
 *
 * We will use 2 pointers. First pointer will traverse each element of the linked list.
 * Second pointer will check if first element is present in the remaining linked list, if yes we will remove.
 *
 * It's nested for loop like thing.
 *
 * TC - O(n)
 * SC - O(1)
 */
public class RemoveDuplicatesApproach2 {
    public static void main(String[] args) {
        // 1 -> 10 -> 31 -> 4 -> 1 -> 29 -> 31 -> 5 -> 6 -> 93 -> 93 -> X
        var node1 = new Node("1");
        var node2 = new Node("10");
        var node3 = new Node("31");
        var node4 = new Node("4");
        var node5 = new Node("1");
        var node6 = new Node("29");
        var node7 = new Node("31");
        var node8 = new Node("5");
        var node9 = new Node("6");
        var node10 = new Node("93");
        var node11 = new Node("93");

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        node10.next = node11;

        System.out.println("Before removing duplicate:");
        Node.printLinkedList(node1);

        removeDuplicatesBookVersion(node1);

        System.out.println("After removing duplicate:");
        Node.printLinkedList(node1);
    }

    private static void removeDuplicates(Node node1) {
        Node outerPtr = node1;
        Node innerPtr = null;
        Node prev = null;
        while (outerPtr != null) {
            innerPtr = outerPtr.next;
            prev = outerPtr;
            while (innerPtr != null) {
                if (outerPtr.data.equals(innerPtr.data)) {
                    prev.next = innerPtr.next;
                }
                prev = innerPtr;
                innerPtr = innerPtr.next;
            }
            outerPtr = outerPtr.next;
        }
    }

    // Since we need prev pointer to change the next pointer, how about if we look into the next node,
    // so that we don't need prev pointer
    private static void removeDuplicatesBookVersion(Node node) {
        Node current = node;
        while (current != null) {
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.data.equals(current.data)) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }
}
