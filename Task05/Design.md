# Q5 – Generic ranking component

The completed generic Leaderboard<T> stores items and receives Comparator<? super T>. ranking() returns a sorted copy, preserving the original insertion list.

The comparator orders points descending, then goal difference descending, then name ascending. It avoids subtraction (which can overflow) and expresses each tie-breaker explicitly. Bisons ranks above Panthers because their points and goal difference are equal, and "Bisons" comes before "Panthers" alphabetically.

A separate Comparator is more reusable than making Team implement Comparable when different contexts may require different ranking rules. Comparable is suitable for one natural ordering. Comparator chaining is O(n log n) for sorting and uses O(n) additional space for the copied list (plus sorting implementation overhead). Three stable sorts would perform three O(n log n) sorts; it is more work and easier to misuse. The generic comparator-based design can also rank players or colleges when a suitable comparator is supplied.
