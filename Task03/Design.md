# Q3 – hashCode–equals contract

The supplied Student equality rule treats students with the same regNo as equal. The hashCode implementation must use the same identity field. The completed program prints the required unique count of 2.

**Why duplicates can appear without hashCode:** HashSet first uses hashCode to choose a bucket and then equals to compare candidates in that bucket. Equal objects with different hash codes may be placed in different buckets, so equals may never compare them.

**Tests:** supplied two-student duplicate scan; repeated same register number with a different display name; independent ID-set test. For the experiment requested by the PDF, temporarily comment out hashCode, run the program, record observed size, then restore it and run again. Exact behaviour can vary with hash distribution and JVM implementation, so record what your run actually shows.

**Mutable key warning:** Do not change a field participating in equals/hashCode after insertion into a hash set. The object may remain in the bucket chosen by its old hash and become difficult to find/remove.

**Alternatives:** TreeSet with comparator by regNo gives O(log n) add/search and O(n) storage. HashMap keyed by regNo gives average O(1) lookup and O(n) storage. HashSet gives average O(1) add/contains with a correct hash function.
