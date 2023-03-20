package in.singh.raman.linkedlist;

public class LinkedListUtil {

    public static int calculateLength(Node head) {
        int length = 0;
        var ptr = head;
        while (ptr != null) {
            ptr = ptr.next;
            length++;
        }
        return length;
    }
}
