package in.singh.raman.linkedlist.lastkth;

import in.singh.raman.linkedlist.Node;

import java.util.Stack;

/**
 * Problem - Given a number k, you need to return the kth element from the end of the linked list
 *
 * Approach:
 *  We find size of the linked list by traversing it
 *  We create offsetCounter = size - k;
 *  We traverse the linkedlist using the offsetCounter and get the kth element from the last
 *
 *  TC - O(n)
 *  SC - O(1)
 */
public class LastKthElementApproach2 {
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

        System.out.println(getLastKthElement(node1, 2));
    }

    private static String getLastKthElement(Node head, int k) {
        var ptr = head;
        int size = 0;
        String result = null;

        while(ptr != null) {
            size++;
            ptr = ptr.next;
        }

        int offSetCounter = size - k + 1;
        ptr = head;
        while (offSetCounter > 0) {
            result = ptr.data;
            ptr = ptr.next;
            offSetCounter--;
        }

        return result;
    }
}
