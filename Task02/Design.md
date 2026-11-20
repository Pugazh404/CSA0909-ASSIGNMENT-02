# Q2 – Playlist collections

**Test sizes:** 1,000, 10,000 and 50,000 songs. The program compares end insertion, front insertion, indexed access and full iteration for ArrayList and LinkedList, plus end/front operations for ArrayDeque.

| Operation | ArrayList | LinkedList | ArrayDeque |
|---|---:|---:|---:|
| Add at end | amortized O(1) | O(1) | amortized O(1) |
| Insert at front | O(n) | O(1) | O(1) |
| Insert middle (by index) | O(n) shift | O(n) traversal, O(1) link once located | not supported by index |
| Get k-th | O(1) | O(n) | no indexed access |
| Iterate all | O(n) | O(n) | O(n) |
| Remove front | O(n) | O(1) | O(1) |
| Per-element storage | reference in backing array | node with links and item | reference in circular array |

**Recommendation:** ArrayList is appropriate when random access and iteration are frequent and most additions are at the end. LinkedList may be useful for frequent endpoint changes when already positioned at the relevant node, but it has node overhead and slow indexed access. ArrayDeque is appropriate for the Up Next double-ended queue.

**Plain array alternative:** Front/middle insertion requires shifting O(n) elements; indexed access is O(1). The benchmark is illustrative; use repeated runs and record your own values in measurements.csv.
