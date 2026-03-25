/**
 * PalindromeChecker Application
 * Version: 1.0
 * UC13: Performance Comparison
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

        String input = "A man a plan a canal Panama";

        // Stack Strategy
        PalindromeStrategy stackStrategy = new StackStrategy();
        long startStack = System.nanoTime();
        boolean stackResult = stackStrategy.check(input);
        long endStack = System.nanoTime();

        // Deque Strategy
        PalindromeStrategy dequeStrategy = new DequeStrategy();
        long startDeque = System.nanoTime();
        boolean dequeResult = dequeStrategy.check(input);
        long endDeque = System.nanoTime();

        // Two-Pointer Strategy
        PalindromeStrategy twoPointerStrategy = new TwoPointerStrategy();
        long startTwoPointer = System.nanoTime();
        boolean twoPointerResult = twoPointerStrategy.check(input);
        long endTwoPointer = System.nanoTime();

        System.out.println("Input: \"" + input + "\"\n");

        System.out.println("Stack Strategy Result: " + stackResult +
                " | Time: " + (endStack - startStack) + " ns");

        System.out.println("Deque Strategy Result: " + dequeResult +
                " | Time: " + (endDeque - startDeque) + " ns");

        System.out.println("Two-Pointer Strategy Result: " + twoPointerResult +
                " | Time: " + (endTwoPointer - startTwoPointer) + " ns");

        System.out.println("\nProgram exited successfully.");
    }
}

/* Strategy Interface */
interface PalindromeStrategy {
    boolean check(String input);
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

/* Two-Pointer Strategy */
class TwoPointerStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String input) {
        if (input == null) return false;

        String normalized = input.replaceAll("\\s+", "").toLowerCase();
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