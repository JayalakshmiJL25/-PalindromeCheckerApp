/**
 * PalindromeChecker Application
 * Version: 1.0
 */

import java.util.Stack;

public class PalindromeChecker {

    private static final String APP_NAME = "PalindromeChecker App";
    private static final String VERSION = "1.0";

    public static void main(String[] args) {

        // UC1: Welcome Message
        System.out.println("======================================");
        System.out.println("Welcome to " + APP_NAME);
        System.out.println("Version: " + VERSION);
        System.out.println("======================================");

        // UC2: Hardcoded Palindrome Check (Character Comparison)
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

        // UC3: Palindrome Check Using String Reverse
        String word2 = "level";
        String reversed = "";

        for (int i = word2.length() - 1; i >= 0; i--) {
            reversed = reversed + word2.charAt(i);
        }

        System.out.println(word2 + (word2.equals(reversed)
                ? " is a Palindrome (String reverse)."
                : " is NOT a Palindrome."));

        // UC4: Character Array Based Palindrome Check
        String word3 = "radar";
        char[] characters = word3.toCharArray();
        int start = 0;
        int end = characters.length - 1;
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

        // UC5: Stack-Based Palindrome Check
        String word4 = "civic";
        Stack<Character> stack = new Stack<>();

        // Push characters into stack
        for (int i = 0; i < word4.length(); i++) {
            stack.push(word4.charAt(i));
        }

        boolean isPalindrome3 = true;

        // Pop and compare
        for (int i = 0; i < word4.length(); i++) {
            if (word4.charAt(i) != stack.pop()) {
                isPalindrome3 = false;
                break;
            }
        }

        System.out.println(word4 + (isPalindrome3
                ? " is a Palindrome (Stack-based)."
                : " is NOT a Palindrome."));

        System.out.println("Program exited successfully.");
    }
}