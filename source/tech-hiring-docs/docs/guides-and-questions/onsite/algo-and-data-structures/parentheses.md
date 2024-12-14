## The Question

Write a function that, given a string containing just the characters '(' and
')', determines if the input string is valid.

### Interactive Coding Environment Setup

Coderpad.io links:

-   <a href="https://coderpad.io/questions/58630" target="_blank">Javascript</a>
-   <a href="https://coderpad.io/questions/49397" target="_blank">Python</a>
-   <a href="https://coderpad.io/questions/49394" target="_blank">Java</a>
-   <a href="https://coderpad.io/questions/58603" target="_blank">Golang</a>
-   <a href="https://coderpad.io/questions/70139" target="_blank">Kotlin</a>

Click the `Create Pad With Question` link to create a unique coderpad for your
interview, and share it with your co-interviewer and interviewee. Name the pad
after the candidate.

### Requirements

-   The function must accept a string.
-   The function must return True or False based on whether the string input is
    a valid string of parentheses.

### Explanatory Examples

Example 1: Input: "()", Output: True

Example 2: Input: "())", Output: False

Example 3: Input: "(", Output: False

Example 4: Input: "()()()", Output: True

Example 5: Input: "(()((())))", Output: True

Example 6: Input: ")(", Output: False

## The Solution

Here's an example solution:

??? example "Python"
    ```python
    def is_valid(parens):
        count_opens = 0

        for par in parens:
            if par == '(':
                count_opens += 1
            elif count_opens == 0:
                return False
            else:
                count_opens -= 1

        return count_opens == 0
    ```

??? example "Go"
    ```go
    func isValid(s string) bool {
      var count int
      
      for _, c := range s {
        switch {
          case c == '(':
            count++
          case count == 0:
            return false
          case c == ')':
            count--
        }
      }
      
      return count == 0
    }
    ```
??? example "Java"
    ```java
    public boolean isValid(String str) {
      if (str == null) {
        return true;
      }
      int opens = 0;
      for (int i = 0; i < str.length(); i++) {
        if (str.charAt(i) == '(') {
          opens++;
        } else if (opens == 0) {
          return false;
        } else {
          opens--;
        }
      }
      return opens == 0;
    }
    ```

### Solution Notes

A full solution should be concise and account for both number of each type of
parenthesis as well as the order in which they appear. No data structure is
needed and though use of one shows consideration towards future cases, it is
also overengineering for this solution.

Behavior for empty strings and None/null values is not specified and it's a good
sign if engineers ask about them. An empty string should be considered valid and
None/null values should be considered invalid.

### Leveling notes

#### Associate

An associate engineer is expected to have a basic grasp of core programming
concepts (data structures, control flows). Associate candidates might take the
full time to complete this problem. Use your judgement to evaluate the cause of
this; if the candidate was moving through the process consistently but slowly,
that's a more positive signal than someone who needed to rely on help from the
interviewers. Look for candidates that approach the problem incrementally and
are able to get at least part of the solution working correctly.

An associate candidate is not expected to notice the missing requirements
without prompting.

#### Mid-Level

A mid-level engineer is expected to be able to write clean and reusable code,
following best practices. Mid-level candidates should be able to recognize when
to optimize the code. The candidate should not need to look anything up and
should use idiomatic constructs in general. For example, treating Python strings
as iterable or using a Deque/ArrayDeque in Java.

Mid-level candidates should finish in 15-20 minutes. They should also prompt
conversations about missing requirements.

#### Senior

A senior engineer should display expertise in knowledge of language principals.
They should write readable and efficient code. Senior candidates should quickly
identify missing requirements and be able to solve for them.

Senior candidates are expected to complete the problem in 10-15 minutes so
there's time for further problems. They should be able to answer questions about
test cases and performance considerations.
