package in.singh.raman.linkedlist.duplicates;

import in.singh.raman.linkedlist.Node;

import java.util.HashSet;

/**
 * We will traverse the nodes and add node's data to a Set
 * While traversing if a node's data is already there in the Set, then it is a duplicate, so we need to remove it
 *
 * TC - O(n)
 * SC - O(n)
 */
public class RemoveDuplicatesApproach1 {
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

        removeDuplicates(node1);

        System.out.println("After removing duplicate:");
        Node.printLinkedList(node1);
    }

    private static void removeDuplicates(Node node1) {
        var ptr = node1;
        var dataSet = new HashSet<String>();

        Node prev = null;
        while(ptr != null) {
            if (dataSet.contains(ptr.data)) {
                // remove current node
                prev.next = ptr.next;
            } else {
                dataSet.add(ptr.data);
                prev = ptr;
            }
            ptr = ptr.next;
        }
    }
}
