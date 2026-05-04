//THIS SHIT MARKS WHERE YOU CHANGED EMPTINESS 1:11

import java.util.*;

public class BalancedDelimiter
{
    public static boolean isBalanced(String s)
    {
        Stack<Character> st = new Stack<>();
        // Your code goes here
        //converting string to stack and removing anything irrelevant
        for(char character : s.toCharArray())
        {
            if("()[]{}".indexOf(character) != -1) st.add(character);
        }
        //these two arrays ensure there are the same amount of open and close delimiters of each type
        //Tracks how many open parentheses, open brackets, and open brace characters there are, respectively
        int[] open_parentheses_bracket_brace = {0,0,0};
        //Tracks how many close parentheses, close brackets, and close brace characters there are, respectively
        int[] close_parentheses_bracket_brace = {0,0,0};
        //Valid characters to follow close delimiters
        String valid_next_close = ")]}";
        //Tracks other invalidating factors, like one kind of delimiter closing a different kind, trailing open delimiters, etc
        boolean other_invalidation = false;
        //I decided to consider the stack valid if it's empty, so no checks run if it is
        if(!st.empty())
        {
            other_invalidation = ("([{".indexOf(st.peek()) != -1);
            while (!st.empty() && !other_invalidation)
            {
                //getting current character to check
                char current_character = st.pop();
                //saves the next character to validate the order is correct. Sets to be a space if the stack is empty.
                //space will represent the beginning of the string
                char next_character;
                if (!st.empty()) next_character = st.peek();
                else next_character = ' ';

                //depending on the type of delimiter, checks the following delimiter is valid, and increases its count in
                //delimiter counting arrays
                switch (current_character)
                {
                    case '(':
                        open_parentheses_bracket_brace[0]++;
                        break;

                    case '[':
                        open_parentheses_bracket_brace[1]++;
                        break;

                    case '{':
                        open_parentheses_bracket_brace[2]++;
                        break;

                    //close delimiter check also checks if the beginning is an open delimiter, and invalidates if so
                    case ')':

                        close_parentheses_bracket_brace[0]++;
                        if (!(valid_next_close.indexOf(next_character) != -1 || next_character == '('))
                            other_invalidation = true;
                        break;

                    case ']':
                        close_parentheses_bracket_brace[1]++;
                        if (!(valid_next_close.indexOf(next_character) != -1 || next_character == '['))
                            other_invalidation = true;
                        break;

                    case '}':
                        close_parentheses_bracket_brace[2]++;
                        if (!(valid_next_close.indexOf(next_character) != -1 || next_character == '{'))
                            other_invalidation = true;
                        break;
                }
            }
        }
        //returns whether delimiters are balanced
        return(Arrays.equals(open_parentheses_bracket_brace, close_parentheses_bracket_brace) && !other_invalidation);
    }

    public static void main(String[] args) {
        String s1 = "({}([]))";
        String s2 = "({}[(]))";
        String s3 = "({}([])";
        String s4 = "({}([])))";
        //slightly adjusted print statements so that correct output will actually print "true false false false"
        System.out.print((isBalanced(s1)) + " ");
        System.out.print((isBalanced(s2)) + " ");
        System.out.print((isBalanced(s3)) + " ");
        System.out.print((isBalanced(s4)) + " ");
        // If the program is written properly
        // The result should be
        // true false false false
    }
}