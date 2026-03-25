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
        boolean isPalindrome = true;

        for (int i = 0; i < word1.length() / 2; i++) {
            if (word1.charAt(i) != word1.charAt(word1.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println(word1 + " is a Palindrome (Checked using character comparison).");
        } else {
            System.out.println(word1 + " is NOT a Palindrome.");
        }

        // UC3: Palindrome Check Using String Reverse
        String word2 = "level";
        String reversed = "";

        // Reverse string using for loop
        for (int i = word2.length() - 1; i >= 0; i--) {
            reversed = reversed + word2.charAt(i); // String concatenation
        }

        // Compare original and reversed using equals()
        if (word2.equals(reversed)) {
            System.out.println(word2 + " is a Palindrome (Checked using string reverse).");
        } else {
            System.out.println(word2 + " is NOT a Palindrome.");
        }

        System.out.println("Program exited successfully.");
    }
}