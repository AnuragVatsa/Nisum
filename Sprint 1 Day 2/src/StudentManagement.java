import java.util.*;
public class StudentManagement {
    ArrayList<String> name=new ArrayList<>();
    ArrayList<Integer> ID=new ArrayList<>();
    ArrayList<Double> grade=new ArrayList<>();
    public void add()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter student name: ");
        name.add(sc.nextLine());
        System.out.println("Enter student id: ");
        ID.add(sc.nextInt());
        System.out.println("Enter student grade: ");
        grade.add(sc.nextDouble());
    }
    public void remove()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter student name: ");
        String n=sc.nextLine();
        int ind=name.indexOf(n);
        name.remove(ind);
        ID.remove(ind);
        grade.remove(ind);
    }
    public void search()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter student id: ");
        int id=sc.nextInt();
        int i=ID.indexOf(id);
        System.out.println("student details with id:"+id);
        System.out.println(name.get(i));
        System.out.println(grade.get(i));
    }
    public void display()
    {
        for(String str:name)
            System.out.println(str);
        for(int i:ID)
            System.out.println(i);
        for(double j:grade)
            System.out.println(j);
    }
    public static void main(String[] args) {
        StudentManagement s=new StudentManagement();
        System.out.println("1.Add ");
        System.out.println("2.Remove");
        System.out.println("3.Search");
        System.out.println("4.Display");
        System.out.println("5.Exit");
        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    s.add();
                    break;
                case 2:
                    s.remove();
                    break;
                case 3:
                    s.search();
                    break;
                case 4:
                    s.display();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
