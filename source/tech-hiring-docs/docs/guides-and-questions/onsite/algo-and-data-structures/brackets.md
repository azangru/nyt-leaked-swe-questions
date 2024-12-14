## The Question

This is a continuation of the parentheses question. Be sure to read through that
problem first.

Write a function that, given a string containing just the characters?'(', ')',
'{', '}', '[' and ']', determine if the input string is valid. An input string
is valid if:

1.  Open brackets must be closed by the same type of brackets.
2.  Open brackets must be closed in the correct order.

### Interactive Coding Environment Setup

Coderpad.io links:

-   <a href="https://coderpad.io/questions/58636" target="_blank">Javascript</a>
-   <a href="https://coderpad.io/questions/49398" target="_blank">Python</a>
-   <a href="https://coderpad.io/questions/49395" target="_blank">Java</a>
-   <a href="https://coderpad.io/questions/58603" target="_blank">Golang</a>

Click the `Create Pad With Question` link to create a unique coderpad for your
interview, and share it with your co-interviewer and interviewee. Name the pad
after the candidate.

Allow the candidate to copy over whatever part of their parentheses solution
that they want to keep.

### Requirements

-   The function must accept a string of brackets.
-   The function must return True or False based on whether the string input is
    a valid string of brackets.

### Explanatory Examples

Example 1: Input: "()", Output: True

Example 2: Input: "()[]{}", Output: True

Example 3: Input: "(]", Output: False

Example 4: Input: "([)]", Output: False

Example 5: Input: "{[]}", Output: True

## The Solution

Here's an example solution:

??? example "Python"
    ```python
    def is_valid(brackets):
        pairs = {
            '(': ')',
            '[': ']',
            '{': '}',
        }
        stack = []

        for bracket in brackets:
            if bracket in pairs.keys():
                stack.append(bracket)
            elif not stack:
                return False
            else:
                popped = stack.pop()
                if pairs[popped] != bracket:
                    return False
        return not stack
    ```

??? example "Go"
    ```go
    func isValid(s string) bool {
      pairs := map[rune]rune{
        '(': ')',
        '{': '}',
        '[': ']',
      }
      var stack []rune
      
      for _, c := range s {
        switch {
        case pairs[c] != 0:
          stack = append(stack, c)
        case len(stack) == 0:
          return false
        default:
          last := stack[len(stack) - 1]
          if pairs[last] != c {
            return false 
          }
          stack = stack[:len(stack) - 1]
        }
      }
      
      return len(stack) == 0
    }
    ```

??? example "Java"
    ```java
    import java.util.Map;
    import java.util.Stack;

    // ...

    public boolean isValid(String str) {
      if (str == null) {
        return true;
      }
      Map<Character, Character> bracketMap = Map.of(
        '{', '}',
        '(', ')',
        '[', ']'
      );
      Stack<Character> openings = new Stack<Character>();
      for (int i = 0; i < str.length(); i++) {
        if (bracketMap.containsKey(str.charAt(i))) {
          openings.push(str.charAt(i));
        } else if (openings.isEmpty() || str.charAt(i) != bracketMap.get(openings.pop())) {
          return false;
        }
      }
      return openings.isEmpty();
    }
    ```
### Solution Notes

A full solution should be concise and account for both number of each type of
bracket as well as the order in which they appear. Recognizing that a simple
count for each style of bracket doesn't work here is crucial to deriving the
solution.

Behavior for empty strings and None/null values is not specified and it's a good
sign if engineers ask about them. An empty string should be considered valid and
None/null values should be considered invalid.

### Leveling notes

#### Associate

Associate engineers are not expected to get to this problem, let alone complete
it. An associate would need substantial help figuring out the data structure to
use and how to implement it.

#### Mid-Level

A mid-level engineer is expected to be able to write clean and reusable code,
following best practices. Mid-level candidates should be able to recognize that
simply counting won't work and come up with using a stack. The candidate may
need to look up stack methods, but should use idiomatic constructs in general.
For example, treating Python strings as iterable or using a Deque/ArrayDeque in
Java.

Mid-level candidates should finish, but might be just shy of completing the
problem after the parentheses question. They should also prompt conversations
about missing requirements.

#### Senior

A senior engineer should display expertise in knowledge of language principals.
They should write readable and efficient code. Senior candidates should quickly
identify the data structure to use and any missing requirements.

Senior candidates should be able to answer questions about test cases and
performance considerations.
