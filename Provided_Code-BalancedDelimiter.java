import java.util.*;

public class BalancedDelimiter {
    public static boolean isBalanced(String s) {
        Stack<Character> st = new Stack<>();
        // Your code goes here
        return(true);
        //
    }

    public static void main(String[] args) {
        String s1 = "({}([]))";
        String s2 = "({}[(]))";
        String s3 = "({}([])";
        String s4 = "({}([])))";
        System.out.println((isBalanced(s1)));
        System.out.println((isBalanced(s2)));
        System.out.println((isBalanced(s3)));
        System.out.println((isBalanced(s4)));
        // If the program is written properly
        // The result should be
        // true false false false
    }
}