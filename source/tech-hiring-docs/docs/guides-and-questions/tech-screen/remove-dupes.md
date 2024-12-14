## The Question

Write a function that takes an array of strings as input and outputs a
deduplicated array of strings.

### Interactive Coding Environment Setup

Coderpad.io links:

-   <a href="https://coderpad.io/questions/59328" target="_blank">Javascript</a>
-   <a href="https://coderpad.io/questions/59330" target="_blank">Python</a>
-   <a href="https://coderpad.io/questions/59329" target="_blank">Java</a>
-   <a href="https://coderpad.io/questions/59331" target="_blank">Go</a>
-   <a href="https://coderpad.io/questions/73912" target="_blank">Ruby</a>
-   <a href="https://coderpad.io/questions/103025" target="_blank">PHP</a>
-   <a href="https://coderpad.io/questions/200552" target="_blank">Clojure</a>
-   <a href="https://coderpad.io/questions/72047" target="_blank">Bash</a>
-   <a href="https://coderpad.io/questions/187321" target="_blank">Plain Text</a> (for other languages)

Click the `Create Pad With Question` link to create a unique coderpad for your
interview, and share it with your co-interviewer and interviewee. Name the pad
after the candidate.

### Clarification

The question is fairly vague by design. One signal we can use to assess how
deeply a candidate thinks about a problem is what questions they ask before they
start writing code. These are some of the questions that candidates will often
ask:

-   Do we need to address non-string data types in the array?
    -   If yes: Are there nested arrays of strings and do we need to maintain
        the parent/child relationships?
-   Are the strings sorted?
    -   If yes: This will allow for a solution with linear time complexity where
        adjacent strings are compared and added to a new array.
-   What is the character set we are dealing with?
-   Does the result need to be case sensitive?

Be prepared to have answers to these questions and think about how it will
change the structure of their solution and how you can dial up or down the
difficulty of the question if the candidate solves quickly.

### Structure

There are a lot of ways to build the difficulty of this question. Some
candidates will use the entire time to get something working and others will get
something working in under a minute.

Follow up questions:

-   Explain the time complexity of the function.
-   Improve on time complexity if non-linear.
-   If they used a `Set`, have them explain what a Set is and what is going on
    under the hood. Then solve without a `Set`.
-   Dedupe in place. If they sort, dig into their knowledge of the sort algo and
    the time complexity there.
-   If they started with linear time complexity ask them to code review a
    quadratic time complexity implementation for someone who might not have a
    deep knowledge of time complexity.

### Solutions

#### Quadratic (`O(n²)`) time complexity:

Most of the solutions that implement the Array API iterator functions (`reduce`,
`filter`, `etc.`) will end up executing in quadratic time.

A brute force option is to create a new array for unique elements then loop
through the input array and check against the uniques.

??? example "JavaScript"
    ```javascript
    const deduplicate = inputArray => {
        const unique = [];
        inputArray.forEach(element => {
            if (!unique.includes(element)) {
                unique.push(element);
            }
        });
        return unique;
    };
    ```

??? example "Go"
    ```go
    func deduplicate(strings []string) []string {
      var unique []string
      
      for _, s := range strings {
        var found bool
        for _, u := range unique {
          if u == s {
            found = true
            break
          }
        }
        
        if !found {
          unique = append(unique, s)
        }
      }
      
      return unique
    }
    ```

This answer works but might see performance degradation as the input array gets
larger.

#### "Probably" (`O(n(log(n))`) Time Complexity

??? example "JavaScript"
    ```javascript
    let deduplicate = inputArray => {
        const unique = [];
        const sortedInput = inputArray.slice().sort();
        sortedInput.forEach((element, i) => {
            if (element !== sortedInput[i - 1]) {
                unique.push(element);
            }
        });
        return unique;
    };
    ```

??? example "Go"
    ```go
    func deduplicate(strings []string) []string {
      var unique []string
      sort.Strings(strings)
      
      for i, s := range strings {
        if i == 0 || strings[i - 1] != s {
          unique = append(unique, s) 
        }
      }
      
      return unique
    }
    ```

This answer finds all unique values but may not maintain the original order.

#### Linear (`O(n)`) time complexity:

??? example "JavaScript"
    ```javascript
    const deduplicate = inputArray => {
        const unique = {};
        inputArray.forEach(element => {
            uniq[element] = true; // the value here doesn't really matter;
        });
        return Object.keys(unique);
    };
    ```

??? example "JavaScript with Set"
    ```javascript
    const deduplicate = input => [...new Set(input)];
    ```

??? example "Go"
    ```go
    func deduplicate(strings []string) []string {
      var unique []string
      seen := map[string]bool{}
      
      for _, s := range strings {
        if !seen[s] {
          unique = append(unique, s)
          seen[s] = true
        }
      }
      
      return unique
    }
    ```

### Optional Increase in Difficulty (Using Objects)

There may be situations where some candidates may solve the problem perfectly in just a few minutes, leaving a lot of time left in the interview. Alternatively, some candidates can possibly have seen the question prior as well. To address these concerns, an optional increase in difficulty can be included as an addendum to the original problem. You can do so by replacing the values inside the array with objects of N-depth instead of strings. In this way, the developer should write a function that executes a deep equals as object comparison. This can test their ability to think more deeply about the problem (perhaps using recursion), as well as provide further justification for hiring someone as senior.

Example:

```javascript
const inputArray = [
  {
    name: "chair",
    inventory: 5,
    unit_price: 45.99,
    units: {
        value: 3,
        marker: '123b'
    }
  },
  {
    name: "chair",
    inventory: 5,
    unit_price: 45.99,
    units: {
        value: 1,
        marker: '123a'
    }
  },
  {
    name: "table",
    inventory: 10,
    unit_price: 123.75,
    units: {
        value: 10,
        marker: '313c'
    }
  },
  {
    name: "sofa",
    inventory: 2,
    unit_price: 399.50,
    units: {
        value: 13,
        marker: '412c'
    }
  },
  {
    name: "chair",
    inventory: 5,
    unit_price: 45.99,
    units: {
        value: 3,
        marker: '123b'
    }
  },
  {
    name: "bed",
    inventory: 2,
    unit_price: 399.50,
    units: {
        value: 13,
        marker: '412c'
    },
  },
  {
    name: "table",
    inventory: 10,
    unit_price: 123.75,
    units: {
        value: 10,
        marker: '313c'
    },
  },
]
```

### Potential Approaches

#### Creating a deep equals function

```javascript
const deepEqual = (obj1, obj2) => {

    if(obj1 === obj2) // it's just the same object. No need to compare.
        return true;

    if(isPrimitive(obj1) && isPrimitive(obj2)) // compare primitives
        return obj1 === obj2;

    if(Object.keys(obj1).length !== Object.keys(obj2).length)
        return false;

    // compare objects with same number of keys
    for(let key in obj1)
    {
        if(!(key in obj2)) return false; //other object doesn't have this prop
        if(!deepEqual(obj1[key], obj2[key])) return false;
    }

    return true;
}

//check if value is primitive
const isPrimitive = (obj) => obj !== Object(obj)
```

After creating a deep equals function, the intended purpose is to integrate this with the existing functionality of dedupes.

#### A simple solution using optimized nested for-loops

```javascript
const deduplicate = inputArray => {
  const unique = [];
  for (let i = 0; i < inputArray.length - 1; i += 1) {
    let isUnique = true;
    for (let j = i + 1; j < inputArray.length - 1; j += 1) {
      if (deepEqual(inputArray[i], inputArray[j])) {
        isUnique = false;
      }
    }
    if (isUnique) {
      unique.push(inputArray[i]);
    }
  }
  return unique;
};
```

#### Additional solution using ES6

```javascript
const deduplicate = inputArray =>
  inputArray
    .reduce((p, n) => p
      .filter(v => !deepEqual(v, n))
      .concat([n]), 
    []
  );
```

#### Avoiding JSON.stringify (Javascript)

JSON.stringify() is generally not a good practice as it doesn't take into account the ordering of keys and is therefore not a recommended practice. An experienced developer may be aware of this issue when solving the problem.

### Leveling

#### Associate Software Engineer

An associate should be able to reach a working solution in any time complexity
within the given time. If they ask clarifying questions or are able to speak to
the time complexity this is a stronger positive signal.

*For Optional Increase in Difficulty:* An associate software engineer will most likely not encounter this problem.

#### Software Engineer

A mid-level software engineer should be able to produce a linear time answer and
have the ability to speak to the time complexity of their function(s).

*For Optional Increase in Difficulty:* A mid-level software engineer will know concepts related to deepEqual as it relates to objects, but may not fully capture all edge cases in object comparison. They may also be aware of the difference between a recursive and non-recursive solution. They may encounter expected hiccups in their solution, but will likely be able to verbally indicate their desired process for solving the problem.

#### Senior Software Engineer

A senior software engineer should begin with some clarifying questions and
produce a linear time answer on their initial implementation. They should
subsequently be able to get through all of the follow up questions mentioned
above.

*For Optional Increase in Difficulty:* A senior software engineer will know many concepts as it relates to deepEqual comparisons, as well as provide a non-naive solution integrating deepEqual into their answer. They should be able to verbally describe their recursion algorithm for deepEqual, as well as have strong understanding of different object properties as it relates to their equality. 
