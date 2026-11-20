import java.util.*;

public class PharmacyMaps {
    static volatile int sink;
    static Map<String,Integer> makeHash(int n){Map<String,Integer> m=new HashMap<>();for(int i=0;i<n;i++)m.put(String.format("MED%07d",i),i);return m;}
    static Map<String,Integer> makeTree(int n){Map<String,Integer> m=new TreeMap<>();for(int i=0;i<n;i++)m.put(String.format("MED%07d",i),i);return m;}
    static Map<String,Integer> makeLinked(int n){Map<String,Integer> m=new LinkedHashMap<>();for(int i=0;i<n;i++)m.put(String.format("MED%07d",i),i);return m;}
    static long lookup(Map<String,Integer> m,int n){long t=System.nanoTime();int s=0;for(int i=0;i<100000;i++)s+=m.get("MED"+String.format("%07d",i%n));sink=s;return System.nanoTime()-t;}
    static long iterate(Map<String,Integer> m){long t=System.nanoTime();int s=0;for(var e:m.entrySet())s+=e.getValue();sink=s;return System.nanoTime()-t;}
    static void test(int n){
        Map<String,Integer> h=makeHash(n), tr=makeTree(n), li=makeLinked(n);
        System.out.println("\\nMedicines="+n);
        System.out.printf("100,000 lookups HashMap %.3f ms%n",lookup(h,n)/1e6);
        System.out.printf("100,000 lookups TreeMap %.3f ms%n",lookup(tr,n)/1e6);
        System.out.printf("100,000 lookups LinkedHashMap %.3f ms%n",lookup(li,n)/1e6);
        System.out.printf("Iteration HashMap %.3f ms%n",iterate(h)/1e6);
        System.out.printf("Code-order report TreeMap %.3f ms%n",iterate(tr)/1e6);
        System.out.printf("Insertion-order report LinkedHashMap %.3f ms%n",iterate(li)/1e6);
    }
    public static void main(String[] args){test(1000);test(10000);test(50000);}
}
