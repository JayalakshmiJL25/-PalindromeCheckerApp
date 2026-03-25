/**
 * PalindromeChecker Application
 * Version: 1.0
 * UC11: Object-Oriented Palindrome Service
 */

public class PalindromeChecker {

    private static final String APP_NAME = "PalindromeChecker App";
    private static final String VERSION = "1.0";

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("Welcome to " + APP_NAME);
        System.out.println("Version: " + VERSION);
        System.out.println("======================================");

        String input = "Madam";

        // Using encapsulated service
        PalindromeService service = new PalindromeService();
        boolean result = service.checkPalindrome(input);

        System.out.println(input + (result
                ? " is a Palindrome (OOP Service)."
                : " is NOT a Palindrome."));

        System.out.println("Program exited successfully.");
    }
}

/**
 * PalindromeService
 * Encapsulates palindrome checking logic.
 * Follows Single Responsibility Principle.
 */
class PalindromeService {

    // Public method exposed to clients
    public boolean checkPalindrome(String input) {

        if (input == null) {
            return false;
        }

        // Normalize input (case-insensitive, ignore spaces)
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        // Internal logic using two-pointer (Array-based access)
        int start = 0;
        int end = normalized.length() - 1;

        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}