import java.util.*;

public class AttendanceRedesign {
    static final class Scan {
        final String id;
        Scan(String id){this.id=id;}
    }
    static long linear(List<Scan> scans, List<String> queries){
        long t=System.nanoTime();int found=0;
        for(String q:queries){for(Scan s:scans)if(s.id.equals(q)){found++;break;}}
        if(found<0)throw new AssertionError();
        return System.nanoTime()-t;
    }
    static long indexed(List<Scan> scans,List<String> queries){
        long t=System.nanoTime();
        Set<String> ids=new HashSet<>();
        for(Scan s:scans)ids.add(s.id);
        int found=0;
        for(String q:queries)if(ids.contains(q))found++;
        if(found<0)throw new AssertionError();
        return System.nanoTime()-t;
    }
    static void test(int n,int q){
        List<Scan> scans=new ArrayList<>();
        for(int i=0;i<n;i++)scans.add(new Scan("REG"+i));
        List<String> queries=new ArrayList<>();
        for(int i=0;i<q;i++)queries.add("REG"+(i%n));
        long a=linear(scans,queries),b=indexed(scans,queries);
        System.out.printf("n=%d q=%d linear=%.3f ms indexed(build+queries)=%.3f ms%n",n,q,a/1e6,b/1e6);
        System.out.printf("Predicted complexity: linear O(q*n), indexed O(n+q) average; index space O(n)%n");
    }
    public static void main(String[] args){test(1000,1000);test(10000,10000);test(50000,50000);}
}
