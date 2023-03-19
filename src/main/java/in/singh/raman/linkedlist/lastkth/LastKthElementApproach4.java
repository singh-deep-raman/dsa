package in.singh.raman.linkedlist.lastkth;

import in.singh.raman.linkedlist.Node;

/**
 * Problem - Given a number k, you need to return the kth element from the end of the linked list
 *
 * Approach:
 *  * Algorithm recurses through the linked list
 *  * When it hits the end, the method passes back a counter set to 0
 *  * Each parent call adds 1 to this counter
 *  * When the counter equals k, means we have reached kth element from the last
 *
 *  TC - O(n)
 *  SC - O(n)
 *
 *  Drawback - In java, we can't return the element but can only print it (You can create a wrapper class which will return both index and the element to make it more better)
 *
 */
public class LastKthElementApproach4 {
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

        getLastKthElement(node1, 10);

        System.out.println(getLastKthElementWithWrapper(node1, 10));
    }

    // version 1
    private static int getLastKthElement(Node head, int k) {
        if (head == null) {
            return 0;
        }

        int index = getLastKthElement(head.next, k) + 1;
        if (index == k)
            System.out.println("Kth element is : "+head.data);
        return index;
    }

    // version 2
    private static String getLastKthElementWithWrapper(Node head, int k) {
        var index = new Index();
        return kthToLast(head, k, index).data;
    }

    private static Node kthToLast(Node head, int k, Index index) {
        if (head == null)
            return null;

        Node node = kthToLast(head.next, k, index);
        index.value = index.value + 1;
        if (index.value == k)
            return head;

        return node;
    }

    private static class Index {
        public int value = 0;
    }
}
