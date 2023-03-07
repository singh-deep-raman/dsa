package in.singh.raman.linkedlist.palindrome;

import in.singh.raman.linkedlist.Node;

import java.util.Stack;

/**
 * We will put the linked list into a stack, then we pop elements from stack and compare it to the linked list elements
 */
public class IsPalindromeApproach1 {

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
        var stack = new Stack<String>();
        var ptr = head;
        while (ptr != null) {
            stack.push(ptr.data);
            ptr = ptr.next;
        }

        ptr = head;
        for (int i = 0; i < stack.size(); i++) {
            String pop = stack.pop();
            if (!pop.equals(ptr.data))
                return false;
            ptr = ptr.next;
        }

        return true;
    }
}
