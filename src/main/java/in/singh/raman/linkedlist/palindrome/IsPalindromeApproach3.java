package in.singh.raman.linkedlist.palindrome;

import in.singh.raman.linkedlist.Node;

import java.util.Stack;

/**
 * This is optimized version of using stack to check palindrome Linked List.
 *
 * Earlier, we put the complete linked list into a stack, then we pop elements from stack and compare it to the linked list elements
 *
 * Now we will only push the first half of the linked list into the stack using Slow-Fast pointer technique.
 *
 * When slow pointer will reach the mid of the linked list, we will have first half of the linked list in the stack,
 * then we can use the slow pointer to compare remaining linked list with elements of the stack
 */
public class IsPalindromeApproach3 {

    public static void main(String[] args) {
        Node oddList = getOddLinkedList();
        Node.printLinkedList(oddList);
        boolean isPalindrome = isPalindrome(oddList);
        System.out.println(isPalindrome);

        Node evenList = getEvenLinkedList();
        Node.printLinkedList(evenList);
        isPalindrome = isPalindrome(oddList);
        System.out.println(isPalindrome);
    }

    private static Node getEvenLinkedList() {
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

        return node1;
    }

    private static Node getOddLinkedList() {
        Node node1 = new Node("1");
        Node node2 = new Node("2");
        Node node3 = new Node("3");
        Node node4 = new Node("2");
        Node node5 = new Node("1");

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        return node1;
    }

    private static boolean isPalindrome(Node head) {
        Node slow = head;
        Node fast = head;
        Stack<String> stack = new Stack<>();
        // reach the mid of the linked list and put first half of the linked list into the stack
        while (fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null)
            slow = slow.next;

        // start of second half of the linked list
        for (int i = stack.size(); i > 0 && slow != null; i--) {
            if (!stack.pop().equals(slow.data))
                return false;
            slow = slow.next;
        }

        return stack.size() == 0 && slow == null;
    }
}
