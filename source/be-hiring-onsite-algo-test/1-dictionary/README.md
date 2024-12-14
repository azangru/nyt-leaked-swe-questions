Dictionary Word Finder
======================

Given an alphabetical array of dictionary entries and a word to search for, find
that word's definition (if it exists). 

### Example Dictionary
You may use [1-dictionary.txt](./1-dictionary.txt) or [1-dictionary.json](1-dictionary.json) as input data for this
exercise. The general form, is as follows:
```javascript
const dictionary = [
  'a - Used when mentioning someone or something for the first time in a text or conversation',
  'and - Used to connect words of the same part of speech, clauses, or sentences, that are to be taken jointly',
  'be - Exist',
  'in - Expressing the situation of something that is or appears to be enclosed or surrounded by something else',
  'of - Expressing the relationship between a part and a whole',
  'that - Used to identify a specific person or thing observed or heard by the speaker',
  'the - Denoting one or more people or things already mentioned or assumed to be common knowledge',
  'to - Expressing motion in the direction of (a particular location)'
];
```

### Requirements
Provide facilities with the following general form, in terms of call structure
and expected return values:

```javascript
definitionOf('be', dictionary); // should return 'Exist'
definitionOf('that', dictionary); // should return 'Used to identify a specific person or thing observed or heard by the speaker'
definitionOf('to', dictionary); // should return 'Expressing motion in the direction of (a particular location)'
definitionOf('wizbing', dictionary); // should return undefined
```
