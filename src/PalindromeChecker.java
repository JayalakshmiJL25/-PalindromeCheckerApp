/**
 * PalindromeChecker Application
 * Version: 1.0
 */

public class PalindromeChecker {

    private static final String APP_NAME = "PalindromeChecker App";
    private static final String VERSION = "1.0";

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("Welcome to " + APP_NAME);
        System.out.println("Version: " + VERSION);
        System.out.println("======================================");

        // UC9: Recursive Palindrome Check
        String word = "racecar";

        boolean isPalindrome = isPalindromeRecursive(word, 0, word.length() - 1);

        System.out.println(word + (isPalindrome
                ? " is a Palindrome (Recursive)."
                : " is NOT a Palindrome."));

        System.out.println("Program exited successfully.");
    }

    // Recursive method
    public static boolean isPalindromeRecursive(String str, int start, int end) {

        // Base Condition: If pointers cross or meet
        if (start >= end) {
            return true;
        }

        // If characters don't match
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive call (smaller subproblem)
        return isPalindromeRecursive(str, start + 1, end - 1);
    }
}