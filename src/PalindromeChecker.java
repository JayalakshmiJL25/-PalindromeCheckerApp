/**
 * PalindromeChecker Application
 * Version: 1.0
 */

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Deque;
import java.util.ArrayDeque;

public class PalindromeChecker {

    private static final String APP_NAME = "PalindromeChecker App";
    private static final String VERSION = "1.0";

    // Node class for Singly Linked List (UC8)
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("Welcome to " + APP_NAME);
        System.out.println("Version: " + VERSION);
        System.out.println("======================================");

        // UC8: Linked List Based Palindrome Check
        String word = "madam";

        // Step 1: Convert string to singly linked list
        Node head = null, tail = null;
        for (char ch : word.toCharArray()) {
            Node newNode = new Node(ch);
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        // Step 2: Find middle using fast & slow pointer
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 3: Reverse second half in-place
        Node prev = null;
        Node current = slow;
        while (current != null) {
            Node nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }

        // Step 4: Compare first half and reversed second half
        Node firstHalf = head;
        Node secondHalf = prev;
        boolean isPalindrome = true;

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                isPalindrome = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        System.out.println(word + (isPalindrome
                ? " is a Palindrome (Linked List based)."
                : " is NOT a Palindrome."));

        System.out.println("Program exited successfully.");
    }
}