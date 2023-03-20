package in.singh.raman.linkedlist.palindrome;

import in.singh.raman.linkedlist.Node;

import static in.singh.raman.linkedlist.LinkedListUtil.calculateLength;

/**
 * Main idea behind this approach is to reach mid of the linked list using recursion.
 * You need to calculate the length in advance before calling recursive function.
 * Reaching the mid of the linked list will be the BASE case of recursion.
 * After reaching mid of the linked list, you have access to all the elements before mid element in previous stack call.
 * Now in each previous call, you will send next element of the remaining linked list by using a reference variable.
 * Then you compare if the data match or not.
 * In each recursive call, we will be decreasing the length by 2, so that we reach our mid element.
 * 2 cases -
 *
 * Case 1 - Even number of elements
 *          Mid element will be when length is zero
 *
 *
 * Case 2 - Odd number of elements
 *          Mid element will be when length is one.
 *
 * Practical example:
 *
 *          0 -> 1 -> 2 -> 3 -> 2 -> 1 -> 0
 *          You have reached mid i.e. 3, now you need to compare it's next and previous element
 *          To access previous element of 3, you need to go back in the prev recursion call
 *          You can pass the next element of 3, in the response (create a new class)
 *          Now you have access to both neighbors of the middle element. You can compare if they are equal or not.
 *          If not, means there is no point in comparing other values, so you need to send this failure as boolean value to previous recursion calls.
 *          So we need a new class Data {Node node, boolean match}
 */
public class IsPalindromeApproach4 {
    private static class Result {
        public Node node;
        public boolean result;

        public Result(Node next, boolean b) {
            this.node = next;
            this.result = b;
        }
    }
    public static void main(String[] args) {
        // 1 -> 2 -> 3 -> 2 -> 1
        Node node1 = new Node("1");
        Node node2 = new Node("2");
        Node node3 = new Node("3");
        Node node4 = new Node("2");
        Node node5 = new Node("1");

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Node.printLinkedList(node1);

        boolean isPalindrome = isPalindrome(node1);
        System.out.println(isPalindrome);
    }

    private static boolean isPalindrome(Node head) {
        int length = calculateLength(head);
        Result result = isPalindromeRecursive(head, length);
        return result.result;
    }

    /**
     * Actual comparison starts when we reach the mid of the linked list
     */
    private static Result isPalindromeRecursive(Node head, int length) {
        // because linked list is even, means it is palindrome at this point
        if (length == 0) {
            return new Result(head, true);
        }
        // because linked lis odd, means it is pa
        if (length == 1) {
            return new Result(head.next, true);
        }

        Result res = isPalindromeRecursive(head.next, length - 2);

        // if child calls are not palindrome, no need to check further
        if (!res.result) {
            return res;
        }

        res.result = (head.data.equals(res.node.data));

        // return corresponding node
        res.node = res.node.next;

        return res;
    }

}
