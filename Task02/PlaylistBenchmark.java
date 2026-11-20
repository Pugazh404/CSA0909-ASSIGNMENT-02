import java.util.*;

public class PlaylistBenchmark {
    static volatile long sink;
    static long measure(Runnable r){long t=System.nanoTime();r.run();return System.nanoTime()-t;}
    static ArrayList<Integer> array(int n){ArrayList<Integer>a=new ArrayList<>();for(int i=0;i<n;i++)a.add(i);return a;}
    static LinkedList<Integer> linked(int n){LinkedList<Integer>a=new LinkedList<>();for(int i=0;i<n;i++)a.add(i);return a;}
    static ArrayDeque<Integer> deque(int n){ArrayDeque<Integer>a=new ArrayDeque<>();for(int i=0;i<n;i++)a.addLast(i);return a;}
    static void test(int n){
        int ops=Math.min(1000,Math.max(100,n/10)), mid=n/2;
        System.out.println("\nPlaylist size: "+n+"; operation repetitions: "+ops);
        long t=measure(()->{ArrayList<Integer>a=array(n);for(int i=0;i<ops;i++)a.add(i);});
        System.out.printf("ArrayList add end: %.3f ms%n",t/1e6);
        t=measure(()->{LinkedList<Integer>a=linked(n);for(int i=0;i<ops;i++)a.add(i);});
        System.out.printf("LinkedList add end: %.3f ms%n",t/1e6);
        t=measure(()->{ArrayDeque<Integer>a=deque(n);for(int i=0;i<ops;i++)a.addLast(i);});
        System.out.printf("ArrayDeque add end: %.3f ms%n",t/1e6);
        t=measure(()->{ArrayList<Integer>a=array(n);for(int i=0;i<ops;i++)a.add(0,-i);});
        System.out.printf("ArrayList insert front: %.3f ms%n",t/1e6);
        t=measure(()->{LinkedList<Integer>a=linked(n);for(int i=0;i<ops;i++)a.addFirst(-i);});
        System.out.printf("LinkedList insert front: %.3f ms%n",t/1e6);
        t=measure(()->{ArrayDeque<Integer>a=deque(n);for(int i=0;i<ops;i++)a.addFirst(-i);});
        System.out.printf("ArrayDeque insert front: %.3f ms%n",t/1e6);
        t=measure(()->{ArrayList<Integer>a=array(n);for(int i=0;i<ops;i++)a.add(a.size()/2,-i);});
        System.out.printf("ArrayList insert middle: %.3f ms%n",t/1e6);
        t=measure(()->{LinkedList<Integer>a=linked(n);for(int i=0;i<ops;i++)a.add(a.size()/2,-i);});
        System.out.printf("LinkedList insert middle by index: %.3f ms%n",t/1e6);
        t=measure(()->{ArrayList<Integer>a=array(n);for(int i=0;i<ops;i++)a.remove(0);});
        System.out.printf("ArrayList remove front: %.3f ms%n",t/1e6);
        t=measure(()->{LinkedList<Integer>a=linked(n);for(int i=0;i<ops;i++)a.removeFirst();});
        System.out.printf("LinkedList remove front: %.3f ms%n",t/1e6);
        t=measure(()->{ArrayDeque<Integer>a=deque(n);for(int i=0;i<ops;i++)a.removeFirst();});
        System.out.printf("ArrayDeque remove front: %.3f ms%n",t/1e6);
        t=measure(()->{ArrayList<Integer>a=array(n);for(int i=0;i<ops;i++)a.remove(a.size()/2);});
        System.out.printf("ArrayList remove middle: %.3f ms%n",t/1e6);
        t=measure(()->{LinkedList<Integer>a=linked(n);for(int i=0;i<ops;i++)a.remove(a.size()/2);});
        System.out.printf("LinkedList remove middle by index: %.3f ms%n",t/1e6);
        t=measure(()->{ArrayList<Integer>a=array(n);long s=0;for(int i=0;i<ops;i++)s+=a.get(i%n);sink=s;});
        System.out.printf("ArrayList get k-th: %.3f ms%n",t/1e6);
        t=measure(()->{LinkedList<Integer>a=linked(n);long s=0;for(int i=0;i<ops;i++)s+=a.get(i%n);sink=s;});
        System.out.printf("LinkedList get k-th: %.3f ms%n",t/1e6);
        t=measure(()->{long s=0;for(int x:array(n))s+=x;sink=s;});
        System.out.printf("ArrayList full iteration: %.3f ms%n",t/1e6);
        t=measure(()->{long s=0;for(int x:linked(n))s+=x;sink=s;});
        System.out.printf("LinkedList full iteration: %.3f ms%n",t/1e6);
        t=measure(()->{long s=0;for(int x:deque(n))s+=x;sink=s;});
        System.out.printf("ArrayDeque full iteration: %.3f ms%n",t/1e6);
    }
    public static void main(String[] args){test(1000);test(10000);test(50000);}
}
