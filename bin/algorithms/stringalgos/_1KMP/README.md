# Knuth-Morris-Pratt (KMP) String Search

KMP searches for a pattern inside a larger text without rechecking text
characters unnecessarily. It preprocesses the pattern into an **LPS** array:
for each pattern position, LPS records the length of the longest proper prefix
that is also a suffix.

When a character does not match, KMP uses that prefix/suffix information to
move the pattern forward while keeping the text position where it is. This
makes the search linear in the lengths of the text and pattern.

## Usage

```java
int index = KMPStringSearch.search("ABABDABACDABABCABAB", "ABABCABAB");
System.out.println(index); // 10
```

`search(text, pattern)` returns the zero-based index of the first match, or
`-1` if the pattern is not present. An empty pattern matches at index `0`.
Both arguments must be non-null.

## Complexity

- Time: `O(n + m)`, where `n` is the text length and `m` is the pattern length.
- Extra space: `O(m)` for the LPS array.
