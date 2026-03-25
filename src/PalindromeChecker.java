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

        // UC10: Case-Insensitive & Space-Ignored Palindrome Check
        String input = "A man a plan a canal Panama";

        // Step 1: Normalize string (remove spaces & convert to lowercase)
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        // Step 2: Apply palindrome logic (two-pointer approach)
        boolean isPalindrome = true;
        int start = 0;
        int end = normalized.length() - 1;

        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        System.out.println("\"" + input + "\"" + (isPalindrome
                ? " is a Palindrome (Case-Insensitive & Space-Ignored)."
                : " is NOT a Palindrome."));

        System.out.println("Program exited successfully.");
    }
}