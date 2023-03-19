package in.singh.raman.linkedlist.lastkth;

import in.singh.raman.linkedlist.Node;

import java.util.Stack;

/**
 * Problem - Given a number k, you need to return the kth element from the end of the linked list
 *
 * Approach:
 *  We push all the elements of the linked list onto a stack
 *  We pop k elements from the stack and you get your kth element from the last
 *
 *  TC - O(n)
 *  SC - O(n)
 */
public class LastKthElementApproach1 {
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

        System.out.println(getLastKthElement(node1, 10));
    }

    private static String getLastKthElement(Node head, int k) {
        var ptr = head;
        var stack = new Stack<String>();
        while (ptr != null) {
            stack.push(ptr.data);
            ptr = ptr.next;
        }

        if (k > stack.size())
            return "Can't get kth element";

        String result = null;
        while (k > 0) {
            result = stack.pop();
            k--;
        }

        return result;
    }
}
