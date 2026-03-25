/**
 * PalindromeChecker Application
 * Version: 1.0
 * UC12: Strategy Pattern Implementation
 */

import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

public class PalindromeChecker {

    private static final String APP_NAME = "PalindromeChecker App";
    private static final String VERSION = "1.0";

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("Welcome to " + APP_NAME);
        System.out.println("Version: " + VERSION);
        System.out.println("======================================");

        String input = "level";

        // Injecting strategy at runtime
        PalindromeStrategy strategy;

        // Change strategy here dynamically
        strategy = new StackStrategy();
        // strategy = new DequeStrategy();

        PalindromeContext context = new PalindromeContext(strategy);

        boolean result = context.executeStrategy(input);

        System.out.println(input + (result
                ? " is a Palindrome (Strategy Pattern)."
                : " is NOT a Palindrome."));

        System.out.println("Program exited successfully.");
    }
}

/* Strategy Interface */
interface PalindromeStrategy {
    boolean check(String input);
}

/* Context Class */
class PalindromeContext {

    private PalindromeStrategy strategy;

    public PalindromeContext(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeStrategy(String input) {
        return strategy.check(input);
    }
}

/* Stack-Based Strategy */
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String input) {

        if (input == null) return false;

        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char ch : normalized.toCharArray()) {
            stack.push(ch);
        }

        for (int i = 0; i < normalized.length(); i++) {
            if (normalized.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

/* Deque-Based Strategy */
class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String input) {

        if (input == null) return false;

        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();

        for (char ch : normalized.toCharArray()) {
            deque.addLast(ch);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }

        return true;
    }
}