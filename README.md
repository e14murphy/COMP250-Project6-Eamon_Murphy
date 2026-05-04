# COMP250-Project6-Eamon_Murphy

For this project, I built a method inside a skeleton program provided by Professor Fanning which validates delimiters in a string. The exact instructions were as follows:
You will complete the included code to create a program that used a stack to check if
a given string contains an appropriate sequence of delimiters.
– ({}([])) would pass because every open delimiter is closed by its partner.
– ({}\[(])) would fail because there is a parenthesis closed by a bracket
– ({}([]) would fail because there is an unclosed parentheses
– ({}([]))) would fail because there is an unopened parentheses

and the original document of instructions, as well as the original skeleton are included, titled COMP250_Delimiters and Provided_Code-BalancedDelimiter, respectively.

The challenge in this project came from determining what conditions could make a string with delimiters invalid, and how to test them. I determined a string would be invalid if:

- There is an uneven amount of close and open delimiters of any type (example: if the string had two open parentheses but only one close parentheses)
- If any one delimiter open and close pair had differing types (example: if the string contained "[}", invalid)
- If the string began with a closing delimiter or ended with an opening delimiter(example: a string started with "}" or ended with "(")

Additionally, I decided empty strings would be considered valid.

The first thing I did was convert the string into the provided char stack. For this, I iterated over every element in the string, using toCharArray to make the elements chars, and adding them to the stack only if they were delimiters, which filters out any irrelevant character. Next, I tested the first condition (even pairs of delimiters) by creating two three element int arrays: open_parentheses_bracket_brace and close_parentheses_bracket_brace. Each one tracks open and close delimiters respectively, with each type at the entry respective to their names. I updated these by using a while loop which repeated until the stack was empty, and popping every element on the stack, determining which array and entry to increment using a switch statement. At the end of the method, the return statement returns the boolean value of the comparison between both arrays, thus only returning true if each type of delimiter has equal close and open parts. The next conditions I tested with a boolean variable other_invalidation. By default it is set to false, and I added it to the conditions of the while loop and return statement with "&& !other_invalidation". In the return statement, if I find an invalidation, this makes it return false. In the while loop, this also ends the loop if an invalidation is detected. Just above the while loop, I first tested if the first element of the stack was an open delimiter, setting other_invalidation to false if so. If the stack, and therefor the string, has a valid first element (A close delimiter), then the while loop runs. The final checks, checking for close delimiters at the beginning of string, thus the bottom of the stack, and if one type of delimiter is paired with a different type, takes place in my close delimiter checks within my switch statement. These use a string of valid next delimiters and peek to determine if the next element is valid. If any of them detects the wrong type of delimiter, or a space, they will set other_invalidation to true, returning that the string is invalid. The variable my valid character string compares against, next_character, becomes a space if the stack is empty. So, if the last character to be popped is a closing delimiter, one of those checks will run and see that there is no opening delimiter pair since the beginning of the stack has been reached, thus invalidating the string. Upon running my method with the provided test and some custom strings for my own testing, all test results returned as expected.

