# Q6 – Hospital emergency triage

A FIFO Queue cannot select a more severe patient who arrived later. PriorityQueue orders patients by severity ascending (1 is most critical) and then by an increasing arrival counter, preserving FIFO among equal severities. poll() removes the next patient. To display treatment order, repeatedly poll a copy; PriorityQueue.toString() is not guaranteed to be sorted.

**Complexity:** PriorityQueue add O(log n), poll O(log n), peek O(1), storage O(n). LinkedList kept sorted requires O(n) insertion and O(1) removal from the head. Five FIFO queues allow O(1) admission and O(1) selection when checking severity queues (at most five checks), with O(n) storage.

**Starvation:** severity 5 may wait indefinitely if more severe arrivals continue. A fair policy can promote patients after a maximum waiting duration or periodically age their effective severity. Rebuild/reinsert priorities when aging changes; define clinical safeguards so aging never delays a critical patient.

The program includes six sample patients and prints treatment order. Extend to about eight for the hand-check requested, then measure at three queue sizes (e.g. 1,000, 10,000, 100,000). For a 5,000/day hospital, average daily volume is not itself a bottleneck; validate peak arrival bursts, concurrent admissions, clinical safety and persistence before deployment.
