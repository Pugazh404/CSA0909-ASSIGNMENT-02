import java.util.*;

public class TicketBenchmark {
    static String[] fields(int count) {
        String[] a = new String[count];
        for (int i = 0; i < count; i++) a[i] = "FIELD" + i + "=VALUE" + i;
        return a;
    }
    static String usingPlus(String[] f) {
        String s = "";
        for (String x : f) s += x + "\n";
        return s;
    }
    static String usingBuilder(String[] f) {
        StringBuilder b = new StringBuilder();
        for (String x : f) b.append(x).append('\n');
        return b.toString();
    }
    static String usingBuffer(String[] f) {
        StringBuffer b = new StringBuffer();
        for (String x : f) b.append(x).append('\n');
        return b.toString();
    }
    static long time(Runnable r) {
        long t = System.nanoTime(); r.run(); return System.nanoTime() - t;
    }
    static volatile int blackhole;
    static void runWorkload(int tickets, int fieldCount, int repeats) {
        String[][] data = new String[tickets][];
        for (int i = 0; i < tickets; i++) data[i] = fields(fieldCount);
        System.out.println("\\nTickets=" + tickets + ", fields/ticket=" + fieldCount);
        for (int method = 0; method < 3; method++) {
            long total = 0;
            for (int r = 0; r < repeats; r++) {
                final int m = method;
                total += time(() -> {
                    int length = 0;
                    for (String[] row : data) {
                        String s = m == 0 ? usingPlus(row) : m == 1 ? usingBuilder(row) : usingBuffer(row);
                        length += s.length();
                    }
                    blackhole = length;
                });
            }
            System.out.printf("%s average: %.3f ms (%d runs)%n",
                method == 0 ? "String +" : method == 1 ? "StringBuilder" : "StringBuffer",
                total / (repeats * 1_000_000.0), repeats);
        }
    }
    public static void main(String[] args) {
        runWorkload(1, 6, 10);
        runWorkload(10000, 50, 5);
        runWorkload(2000, 100, 5);
        System.out.println("Estimated intermediate concatenation strings: repeated + creates intermediate results; builder/buffer append into a mutable buffer.");
    }
}
