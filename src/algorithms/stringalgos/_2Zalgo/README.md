# Z Algorithm String Search

The Z algorithm computes a **Z array** for a string. At each index `i`, `z[i]`
is the number of characters that match between the string starting at index
`i` and the string's prefix. In this implementation, `z[0]` is `0`.

To search for a pattern, the implementation combines the pattern, a separator,
and the text. It calculates the Z array for this combined sequence. Wherever a
Z value is at least the pattern length, the pattern matches the text at that
position. The separator is represented internally by `-1`, which cannot match
a Java `char`.

## Example

Search for `aba` in `xxabaxxaba`:

```java
int index = Zalgo.search("xxabaxxaba", "aba");
System.out.println(index); // 2
```

The combined sequence is `aba#xxabaxxaba` (`#` represents the separator).
At the first text position, the substring starts with `aba`, so its Z value is
at least `3`, the pattern length. That position is index `2` in the original
text, so the search returns `2`.

`search(text, pattern)` returns the first match's zero-based index, or `-1` if
the pattern is absent. An empty pattern matches at index `0`; both arguments
must be non-null.

## Complexity

- Time: `O(n + m)`, where `n` is the text length and `m` is the pattern length.
- Extra space: `O(n + m)` for the combined sequence and Z array.
