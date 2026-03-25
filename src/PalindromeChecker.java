/**
 * PalindromeChecker Application
 * Version: 1.0
 */

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

        if (isPalindrome1) {
            System.out.println(word1 + " is a Palindrome (Character comparison).");
        } else {
            System.out.println(word1 + " is NOT a Palindrome.");
        }

        // UC3: Palindrome Check Using String Reverse
        String word2 = "level";
        String reversed = "";

        for (int i = word2.length() - 1; i >= 0; i--) {
            reversed = reversed + word2.charAt(i);
        }

        if (word2.equals(reversed)) {
            System.out.println(word2 + " is a Palindrome (String reverse).");
        } else {
            System.out.println(word2 + " is NOT a Palindrome.");
        }

        // UC4: Character Array Based Palindrome Check
        String word3 = "radar";

        // Convert string to char array
        char[] characters = word3.toCharArray();

        int start = 0;
        int end = characters.length - 1;
        boolean isPalindrome2 = true;

        // Two-pointer technique
        while (start < end) {
            if (characters[start] != characters[end]) {
                isPalindrome2 = false;
                break;
            }
            start++;
            end--;
        }

        if (isPalindrome2) {
            System.out.println(word3 + " is a Palindrome (char[] two-pointer).");
        } else {
            System.out.println(word3 + " is NOT a Palindrome.");
        }

        System.out.println("Program exited successfully.");
    }
}