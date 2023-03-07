package in.singh.raman.linkedlist.palindrome;

import in.singh.raman.linkedlist.Node;

/**
 * In this approach, we will create a clone of the input list, reverse it and then compare it with the original linked list
 * <p>
 * TC - O(n)
 * SC - O(n)
 */
public class IsPalindromeApproach2 {

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
        Node reversed = cloneAndReverse(head);
        return isEqual(head, reversed);
    }

    private static boolean isEqual(Node head, Node reversed) {
        Node ptr1 = head;
        Node ptr2 = reversed;

        while (ptr1 != null && ptr2 != null) {
            if (!ptr1.data.equals(ptr2.data))
                return false;
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        // means both pointers reached end of their respective linked lists
        return ptr1 == null && ptr2 == null;
    }

    private static Node cloneAndReverse(Node head) {
        Node list1 = head;
        Node reversed = null;
        Node temp = null;
        while (list1 != null) {
            Node node = new Node(list1.data);
            node.next = reversed;
            reversed = node;
            // move to next element
            list1 = list1.next;
        }
        return reversed;
    }
}
