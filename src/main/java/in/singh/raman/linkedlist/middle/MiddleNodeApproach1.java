package in.singh.raman.linkedlist.middle;

import in.singh.raman.linkedlist.Node;

import static in.singh.raman.linkedlist.LinkedListUtil.calculateLength;


/**
 * We will find the length of linked list
 * We divide the length by 2 to find the middle element using a ptr
 *
 * n/2 + 1 will be the middle element, for both even and odd linked list case
 *
 * TC - O(n)
 * SC - O(1)c
 */
public class MiddleNodeApproach1 {
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

        Node middle = getMiddleNode(node1);
        System.out.println(middle.data);
    }

    private static Node getMiddleNode(Node head) {
        int length = calculateLength(head);
        if (length == 0)
            return new Node("");
        int mid = (length / 2) + 1;

        var ptr = head;
        while (--mid > 0) {
            ptr = ptr.next;
        }

        return ptr;
    }
}
