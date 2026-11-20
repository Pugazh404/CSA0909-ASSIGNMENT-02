# Q4 – Pharmacy inventory maps

**Required reports:** medicine code order and insertion order. HashMap provides average O(1) put/get and does not guarantee iteration order. TreeMap provides O(log n) put/get and sorted key iteration. LinkedHashMap provides average O(1) put/get and preserves insertion order.

| Operation | HashMap | TreeMap | LinkedHashMap |
|---|---:|---:|---:|
| put/get | average O(1) | O(log n) | average O(1) |
| Iterate | O(n) | O(n) in key order | O(n) insertion order |
| Extra order requirement | sort keys O(n log n) | already sorted | already insertion order |

The program tests 1,000, 10,000 and 50,000 medicines and performs 100,000 lookups for each map. Set an acceptable lookup target before testing (for example, a local engineering target of under 100 ms for the full 100,000 lookups; justify or revise it using observed conditions). Hashtable is generally not preferred for new code because its legacy API synchronizes individual methods; modern alternatives and explicit concurrency choices are clearer.

**Sorted array alternative:** binarySearch lookup O(log n), insertion O(n) due to shifting, code-order report O(n); storage O(n). HashMap lookup is average O(1), but sorted reporting requires sorting keys. TreeMap maintains sorted order with O(log n) updates.
