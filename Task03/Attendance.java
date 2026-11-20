import java.util.*;

class Student {
    private final String regNo;
    private final String name;
    Student(String regNo,String name){this.regNo=regNo;this.name=name;}
    @Override public boolean equals(Object o){
        if(this==o)return true;
        if(!(o instanceof Student))return false;
        Student s=(Student)o; return Objects.equals(regNo,s.regNo);
    }
    // TODO 1 completed: equal register numbers produce equal hash codes.
    @Override public int hashCode(){return Objects.hash(regNo);}
    @Override public String toString(){return regNo+" "+name;}
}
public class Attendance {
    public static void main(String[] args){
        Set<Student> present=new HashSet<>();
        present.add(new Student("192311001","Arun"));
        present.add(new Student("192311002","Divya"));
        present.add(new Student("192311001","Arun"));
        System.out.println("Unique students: "+present.size());
        System.out.println("Students: "+present);
        Set<Student> repeated=new HashSet<>();
        repeated.add(new Student("REG10","A"));
        repeated.add(new Student("REG10","A"));
        repeated.add(new Student("REG10","Different display name"));
        System.out.println("Repeated same ID scans: "+repeated.size());
        Set<String> ids=new HashSet<>(Arrays.asList("R1","R2","R1","R3","R2"));
        System.out.println("Independent ID test: "+ids.size());
    }
}
