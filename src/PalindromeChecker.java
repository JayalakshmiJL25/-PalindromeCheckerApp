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

    public static void main(String[] args) {

        // UC1: Welcome Message
        System.out.println("======================================");
        System.out.println("Welcome to " + APP_NAME);
        System.out.println("Version: " + VERSION);
        System.out.println("======================================");

        // UC2: Character Comparison
        String word1 = "madam";
        boolean isPalindrome1 = true;
        for (int i = 0; i < word1.length() / 2; i++) {
            if (word1.charAt(i) != word1.charAt(word1.length() - 1 - i)) {
                isPalindrome1 = false;
                break;
            }
        }
        System.out.println(word1 + (isPalindrome1 ? " is a Palindrome (Character comparison)."
                : " is NOT a Palindrome."));

        // UC3: String Reverse
        String word2 = "level";
        String reversed = "";
        for (int i = word2.length() - 1; i >= 0; i--) {
            reversed = reversed + word2.charAt(i);
        }
        System.out.println(word2 + (word2.equals(reversed)
                ? " is a Palindrome (String reverse)."
                : " is NOT a Palindrome."));

        // UC4: char[] Two-Pointer
        String word3 = "radar";
        char[] characters = word3.toCharArray();
        int start = 0, end = characters.length - 1;
        boolean isPalindrome2 = true;
        while (start < end) {
            if (characters[start] != characters[end]) {
                isPalindrome2 = false;
                break;
            }
            start++;
            end--;
        }
        System.out.println(word3 + (isPalindrome2
                ? " is a Palindrome (char[] two-pointer)."
                : " is NOT a Palindrome."));

        // UC5: Stack-Based
        String word4 = "civic";
        Stack<Character> stack = new Stack<>();
        for (char ch : word4.toCharArray()) {
            stack.push(ch);
        }
        boolean isPalindrome3 = true;
        for (int i = 0; i < word4.length(); i++) {
            if (word4.charAt(i) != stack.pop()) {
                isPalindrome3 = false;
                break;
            }
        }
        System.out.println(word4 + (isPalindrome3
                ? " is a Palindrome (Stack-based)."
                : " is NOT a Palindrome."));

        // UC6: Queue + Stack Based
        String word5 = "refer";
        Stack<Character> stack2 = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        for (char ch : word5.toCharArray()) {
            stack2.push(ch);
            queue.add(ch);
        }
        boolean isPalindrome4 = true;
        while (!stack2.isEmpty()) {
            if (!queue.remove().equals(stack2.pop())) {
                isPalindrome4 = false;
                break;
            }
        }
        System.out.println(word5 + (isPalindrome4
                ? " is a Palindrome (Queue + Stack)."
                : " is NOT a Palindrome."));

        // UC7: Deque-Based Optimized Palindrome Check
        String word6 = "noon";
        Deque<Character> deque = new ArrayDeque<>();

        // Insert characters into deque
        for (char ch : word6.toCharArray()) {
            deque.addLast(ch);
        }

        boolean isPalindrome5 = true;

        // Compare front and rear
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                isPalindrome5 = false;
                break;
            }
        }

        System.out.println(word6 + (isPalindrome5
                ? " is a Palindrome (Deque-based optimized)."
                : " is NOT a Palindrome."));

        System.out.println("Program exited successfully.");
    }
}