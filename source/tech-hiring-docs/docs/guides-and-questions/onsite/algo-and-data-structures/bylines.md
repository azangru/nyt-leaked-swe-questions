## The Question

Write a function that, given an object representing by-line data, returns a
valid byline HTML string.

### Interactive Coding Environment Setup

Coderpad.io links:

-   <a href="https://coderpad.io/questions/58622" target="_blank">Javascript</a>
-   <a href="https://coderpad.io/questions/58623" target="_blank">Python</a>
-   <a href="https://coderpad.io/questions/58625" target="_blank">Java</a>
-   <a href="https://coderpad.io/questions/60201" target="_blank">Ruby</a>
-   <a href="https://coderpad.io/questions/60209" target="_blank">Golang</a>
-   <a href="https://coderpad.io/questions/70145" target="_blank">Kotlin</a>
-   <a href="https://coderpad.io/questions/239872" target="_blank">Perl</a>

Click the `Create Pad With Question` link to create a unique coderpad for your
interview, and share it with your co-interviewer and interviewee. Name the pad
after the candidate.

### Requirements

-   The function must accept a valid object format.
-   The function must remove invalid objects
-   The function must output a valid byline HTML string.
-   A byline string must start with a "By"
-   Authors must be separated by a comma "," if there are more than 2.
-   The last Author must be separated by an "and"
-   The Author must be wrapped by the style specified in the "block" parameter
-   Assume that we support the `<em>` and `<strong>` html tags

### Explanatory Example

For the bylines object below:

```javascript
const bylines = {
    authors: [
        {
            firstName: "jonah",
            middleName: "Engel",
            lastName: "bromwich",
            block: {
                __typename: "Bold"
            }
        },
        { random: "node" },
        {},
        {
            firstName: "matthew",
            middleName: "",
            lastName: "sChneier",
            block: {
                __typename: "Italics"
            }
        },
        {
            firstName: "Niraj",
            middleName: "",
            lastName: "chokshi",
            block: {}
        }
    ]
};
```

the function should return:

```javascript
"By <strong>Jonah Engel Bromwich</strong>, <em>Matthew Schneier</em> and Niraj Chokshi";
```

### Follow-ups

If candidates finish this question early, there might be time for follow-up
questions to learn more about their appropriate level and skills.

#### Testing

The coderpads have only a single test case. Candidates should be able to come up
with others. Here are some examples that would be useful (some of these will
make more or less sense based on the candidate's specific approach):

1. Testing an empty `bylines` object
2. Testing an object with an empty or non-Array `authors` property
3. An object with only one author
4. An object with only two authors
5. An object with only invalid objects
6. Authors with only some name parts (i.e. only first, middle or last names)

#### Expanding the API

This API is limited in what it exposes to consumers in that it only allows Bold
or Italic formatting. Prompt a conversation with the candidate about how they
would expand the API to support more complex usage, like custom styling or
classes, or custom event handlers (they don't need to necessarily write code for
this extension). Hopefully, this conversation can lead to alternate solutions or
approaches (maybe ones that don't involve directly returning an HTML string).

## Possible Solutions

??? example "Go"
    ```go
    package main

    import (
      "errors"
      "fmt"
      "strings"
    )

    type blockType int

    const (
      _ blockType = iota
      Normal
      Bold
      Italics
    )

    type Author struct {
      firstName  string
      middleName string
      lastName   string
      block      blockType
    }

    func NewAuthor(f, m, l string, b blockType) Author {
      return Author{
        firstName:  f,
        middleName: m,
        lastName:   l,
        block:      b,
      }
    }

    func main() {
      authors := []Author{
        NewAuthor("jonah", "Engel", "bromwich", Bold),
        NewAuthor("", "", "malformed", 6),
        NewAuthor("matthew", "", "sChneier", Italics),
        Author{},
        NewAuthor("Niraj", "", "chokshi", Normal),
      }

      html, err := createBylineString(authors)

      if err != nil {
        fmt.Printf(err.Error())
      }

      fmt.Println(html)
    }

    func (a Author) isValid() bool {
      return a.firstName != "" && a.lastName != ""
    }

    func (a Author) extractName() string {
      if a.middleName == "" {
        return fmt.Sprintf("%s %s", a.firstName, a.lastName)
      }

      return fmt.Sprintf("%s %s %s", a.firstName, a.middleName, a.lastName)
    }

    func formatName(name string, format blockType) string {
      var tplMap = map[blockType]string{Bold: "<strong>%s</strong>", Italics: "<em>%s</em>"}

      name = strings.Title(strings.ToLower(name))

      if tpl, ok := tplMap[format]; ok {
        name = fmt.Sprintf(tpl, name)
      }

      return name
    }

    func structureByline(names []string) (string, error) {
      if len(names) == 0 {
        return "", errors.New("Must have at least one author")
      }

      tn := len(names)

      if tn == 1 {
        return names[0], nil
      }

      return "By " + strings.Join(names[:tn-1], ", ") + " and " + names[tn-1], nil
    }

    func createBylineString(authors []Author) (string, error) {
      var fmtNames []string

      for _, author := range authors {
        if !author.isValid() {
          continue
        }

        name := author.extractName()
        fmtNames = append(fmtNames, formatName(name, author.block))
      }

      byline, err := structureByline(fmtNames)

      if err != nil {
        return "", err
      }

      return byline, nil
    }
    ```

??? example "Javascript"
    ```javascript
    const exampleBylines = {
        authors: [
            {
                firstName: "jonah",
                middleName: "Engel",
                lastName: "bromwich",
                block: {
                    __typename: "Bold"
                }
            },
            { random: "node" },
            {},
            {
                firstName: "matthew",
                middleName: "",
                lastName: "sChneier",
                block: {
                    __typename: "Italics"
                }
            },
            {
                firstName: "Niraj",
                middleName: "",
                lastName: "chokshi",
                block: {}
            }
        ]
    };
    function toTitleCase(name) {
        if(name === "") { return ""}; // Handles double space case when middle name is empty
        return name.substr(0, 1).toUpperCase() + name.substr(1).toLowerCase() + " ";
    }
    
    function createAuthorString(author) {
        const authorString = `${toTitleCase(author.firstName)}${toTitleCase(author.middleName)}${toTitleCase(author.lastName)}`;
      
        if (
            !(
                author.block &&
                author.block.__typename &&
                typeof author.block.__typename === "string"
            )
        ) {
            return authorString;
        }
        switch (author.block.__typename) {
            case "Bold": {
    
               return "<strong>" + authorString + "</strong>"
            }
            case "Italics": {
    
               return "<em>" + authorString + "</em>"
            }
            default:
                return authorString;
        }
    }
    
    function isValidByline(author) { return author.firstName && author.lastName; }
    
    function joinNames(authorStrings) {
        return `${authorStrings
            .slice(0, authorStrings.length - 1)
            .join(", ")} and ${authorStrings[authorStrings.length - 1]}`;
    }
    
    function buildByline(bylines) {
        if (!bylines.authors || !Array.isArray(bylines.authors)) {
            return "";
        }
    
        const authorStrings = bylines.authors
            .filter(isValidByline)
            .map(createAuthorString);
        const authorsString =
            authorStrings.length > 1 ? joinNames(authorStrings) : authorStrings[0];
        return `By ${authorsString}`;
    }
    
    console.log(buildByline(exampleBylines));
    ```

??? example "Ruby"
    ```ruby
    def filter_bylines(bylines)
      bylines.select do |byline|
        byline[:first_name] && byline[:first_name]
      end
    end

    def build_name(byline)
      %i[first_name middle_name last_name].map do |key|
        byline[key].to_s.capitalize
      end.reject(&:empty?).join(' ')
    end

    def format_byline(byline)
      name = build_name(byline)

      case byline[:block][:type_name]
      when 'Bold'
        "<strong>#{name}</strong>"
      when 'Italics'
        "<em>#{name}</em>"
      else
        name
      end
    end

    def create_byline_string(bylines)
      return '' if bylines.empty?

      names = filter_bylines(bylines).map { |a| format_byline(a) }
      last = names.pop

      if names.empty?
        "By #{last}"
      else
        "By #{names.join(', ')} and #{last}"
      end
    end

    # From Coderpad
    Author = Struct.new(:first_name, :middle_name, :last_name, :block)

    Block = Struct.new(:type_name)

    p1 = Author.new('jonah', 'Engel', 'bromwich', Block.new('Bold'))
    p2 = Author.new(nil, nil, 'malformed', nil)
    p3 = Author.new('matthew', '', 'sChneier', Block.new('Italics'))
    p4 = Author.new
    p5 = Author.new('Niraj', '', 'chokshi', Block.new('Normal'))

    example_bylines = [p1, p2, p3, p4, p5]

    puts create_byline_string(example_bylines)
    ```

??? example "Java"
    ```java
    import java.io.*;
    import java.util.*;

    enum BlockType {
        BOLD,
        ITALICS,
        NORMAL,
    }

    class Author {
        private String firstName;
        private String middleName;
        private String lastName;
        private BlockType blockType;

        public Author(String firstName, String middleName, String lastName, BlockType blockType) {
            this.firstName = firstName;
            this.middleName = middleName;
            this.lastName = lastName;
            this.blockType = blockType;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getMiddleName() {
            return middleName;
        }

        public String getLastName() {
            return lastName;
        }

        public BlockType getBlockType() {
            return blockType;
        }
    }

    class BylineData {
        private List<Author> authors;

        public BylineData(List<Author> authors) {
            this.authors = authors;
        }

        public List<Author> getAuthors() {
            return authors;
        }
    }

    class Solution {
        final static BylineData exampleBylineData = new BylineData(
            Arrays.asList(
                new Author("jonah", "Engel", "bromwich", BlockType.BOLD),
                new Author(null, null, "malformed", null),
                null,
                new Author("matthew", "", "sChneier", BlockType.ITALICS),
                new Author("Niraj", "", "chokshi", BlockType.NORMAL)
            )
        );


      // This would be the candidate's contribution =======================================================

        static Boolean isValidAuthor(Author author) {
          /* Requirements for Author validity:
          1. Must have non-blank first name
          2. Middle name can be blank, but not null
          3. Must have non-blank last name
          4. Must have block type
          */
          if (author == null) {
            return false;
          } else if (author.getFirstName() == null || author.getFirstName().isEmpty()) {
            return false;
          } else if (author.getMiddleName() == null) {
            return false;
          } else if (author.getLastName() == null || author.getLastName().isEmpty()) {
            return false;
          } else if (author.getBlockType() == null) {
            return false;
          }
          return true;
        }

        static String capitalizeFirstLetter(String str) {
          return str.substring(0,1).toUpperCase() + str.substring(1).toLowerCase();
        }

        static String formAuthorString(Author author) {
          String fullName = capitalizeFirstLetter(author.getFirstName()) + " ";
          if (!author.getMiddleName().isEmpty()){
            fullName += capitalizeFirstLetter(author.getMiddleName()) + " ";
          }
          fullName += capitalizeFirstLetter(author.getLastName());
          return fullName;
        }

        static String applyTags(String str, BlockType blockType) {
          if (blockType == BlockType.BOLD) {
            return "<strong>" + str + "</strong>";
          } else if (blockType == BlockType.ITALICS) {
            return "<em>" + str + "</em>";
          } else {
            return str;
          }
        }

        static String combineAuthorStrings(List<String> authorStrings) {
          StringBuilder combinedAuthors = new StringBuilder();
          for (int i = 0; i < authorStrings.size(); i++) {
            combinedAuthors.append(authorStrings.get(i));
            if (i <= (authorStrings.size() - 3)) {
              combinedAuthors.append(",");
            } else if (i == (authorStrings.size() - 2)) {
              combinedAuthors.append(" and");
            }
            if (i != authorStrings.size() - 1) {
              combinedAuthors.append(" ");
            }
          }
          return combinedAuthors.toString();
        }

        static String createBylineString(BylineData bylineData) {
          List<String> formattedNames = new ArrayList<>();
          for (Author author : bylineData.getAuthors()) {
            if (!isValidAuthor(author)) {
              continue;
            }
            formattedNames.add(applyTags(formAuthorString(author), author.getBlockType()));
          }
          return "By " + combineAuthorStrings(formattedNames);
        }

      //===================================================================================================

        public static void main(String[] args) {
            System.out.println(createBylineString(exampleBylineData));
        }
    }
    ```
??? example "Perl"
    ```perl
    sub create_byline_string {
        my $bylines = shift;
        my $authors = $bylines->{authors} or die "No authors\n";

        my @names;
        for my $author (@{ $authors }) {
            my $name = encode_entities join ' ', map { ucfirst lc }
                grep { $_ } @{$author}{qw(firstName middleName lastName)};
            next unless $name;
            if (my $type = lc( eval { $author->{block}{__typename} } // '')) {
                $name = $type eq 'italics' ? "<em>$name</em>"
                      : $type eq 'bold'    ? "<strong>$name</strong>"
                      :                      $name
            }
            push @names => $name;
        }

        return '' unless @names;
        return "By $names[0]" if @names == 1;
        return 'By ' . join(', ', @names[0..$#names-1]) . " and $names[-1]";
    }
    ```

### Solution Notes

Notice that a full solution includes correct proper noun casing (in the example,
but not the requirements). Mid-level and up candidates should notice that there
is a discrepancy between the output of their code (without proper noun casing)
and what makes sense to the user/is in the example. If prompted, encourage the
candidate to support proper noun casing in their solution.

Additionally, the requirements specify that the function must "remove invalid
objects", but does not specify what a valid object is. There's no real right or
wrong answer here, but this a point where the candidate (especially mid-level
and up) should prompt a conversation about what should be in a valid object.

### Leveling notes

#### Associate

An associate engineer is expected to have a basic grasp of core programming
concepts (data structures, control flows), but they are not expected to be
deeply familiar with language-specific paradigms or APIs. An associate candidate
might use simpler control flows (for loops and if statements) and avoid
splitting code into helper methods.

Associate candidates might not finish this question in the time limit. Use your
judgement to evaluate the cause of this; if the candidate was moving through the
process consistently but slowly, that's a more positive signal than someone who
needed to rely on help from the interviewers. Look for candidates that approach
the problem incrementally and are able to get at least part of the solution
working correctly.

An associate candidate is not expected to notice the missing requirements
without prompting.

#### Mid-Level

A mid-level engineer is expected to be able to write clean and reusable code,
following best practices. Mid-level candidates should be able to recognize when
to split out code into separate functions, and more consistently use common
language paradigms. It's acceptable for any candidate to have to check
documentation for exact APIs, but it's important that candidates have a sense of
what can be done in the language their working in and what best practices are.

Mid-level candidates should finish or come very close to finishing the listed
requirements. They should also prompt conversations about missing requirements
and mismatches between requirements and the example problem.

#### Senior

A senior engineer should quickly break up their solution into steps (preferably
before starting to code). They should be able to anticipate what their code will
do without having to run it.

A senior engineer is expected to write their implementation in a way that
indicates the steps (e.g. removing malformed elements, capitalization,
formatting, adding separators).

Senior candidates should also have time to speak to follow-up questions,
successfully coming up with useful test cases and at least holding a
hypothetical conversation about how the API could be expanded or improved.
