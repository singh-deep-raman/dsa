package in.singh.raman.linkedlist.middle;

import in.singh.raman.linkedlist.Node;

import static in.singh.raman.linkedlist.LinkedListUtil.calculateLength;


/**
 * This is the most efficient technique
 * We use 2 pointers - fast & slow, or also called hare & tortoise
 * slow pointer will move one step at a time
 * fast pointer will move two steps at a time
 * by the time fast pointer reaches the end of the linked list, slow pointer will reach the mid
 *
 * You can use counter variables also instead of ptr variables, you traverse the linked list and set the mid element if count%2 == 0
 */
public class MiddleNodeApproach2 {
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
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
