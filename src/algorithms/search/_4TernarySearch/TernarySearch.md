Ternary search is a divide-and-conquer search algorithm used to find the position of a target value within an increasing or decreasing function or in a unimodal array (e.g., U-shaped or ∩-shaped).

Unlike binary search, which splits the array into two parts, ternary search divides the range into three equal parts by choosing two mid-points:

mid1 = l + (r - l) / 3
mid2 = r - (r - l) / 3
When to use Ternary Search
Naturally fits for unimodal arrays (e.g., strictly decreasing then increasing, or vice versa). Please refer Minimum in Decreasing Increasing Array as an example.
To optimize a unimodal function (e.g., finding the minimum or maximum of a quadratic function).
For problems like finding the bitonic point in a bitonic sequence.
Evaluating a real-valued function where the function has a single local minimum or maximum.