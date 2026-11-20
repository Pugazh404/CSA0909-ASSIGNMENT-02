# Q1 – Building text under load

**Prediction:** String is immutable; repeated concatenation inside a loop may allocate intermediate strings and copy growing prefixes. StringBuilder mutates one buffer and is expected to perform better for large workloads. StringBuffer provides synchronized methods and may add overhead when synchronization is unnecessary.

**Workloads:** one short ticket (1 × 6 fields), large workload (10,000 × 50 fields), and an additional workload (2,000 × 100 fields). The program repeats measurements and reports average elapsed time.

**Complexity:** For n appended fields with growing prefix copies, repeated concatenation can copy O(n²) total characters when field sizes are similar. StringBuilder append is amortized O(n) total characters, excluding resizing/copying overhead. Both ultimately need O(total output) space; repeated concatenation creates more temporary objects.

**Decision:** Use StringBuilder for a ticket built by one thread. For a shared multithreaded log, use a thread-safe design (e.g. synchronized access or a dedicated logging service); StringBuffer is synchronized but does not make a multi-step logging operation automatically atomic. StringJoiner/String.join are alternatives when joining known values with a delimiter.

**Evidence:** Run TicketBenchmark.java. Record raw averages and memory observations in measurements.csv. Results must be measured on your own machine.
