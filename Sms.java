import java.util.ArrayList;
import java.util.Scanner;

class Data{

    
    private int id;
    private String name;
    private int age;
    private String course;

    public Data(int id, String name, int age, String course){
        this.id=id;
        this.name=name;
        this.age=age;
        this.course=course;
    }
    public int getId(){
        return id;
    }
    @Override
    public String toString(){
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Course: " + course;

    }
}

public class Sms{
    static ArrayList<Data> students=new ArrayList<>();
    static Scanner sc=new Scanner(System.in);

    public static void main(String[]args){
        while (true) { 
            System.out.println("\n====== student management system ======");
            System.out.println("1.add student");
            System.out.println("2.view all students");
            System.out.println("3.search student by id");
            System.out.println("4.delete student");
            System.out.println("5.exit");

            System.out.println("enter your choice:");
            
            int choice=sc.nextInt();

            switch(choice){
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("bye bye tata");
                    System.exit(0);
            }


        }

    }
    public static void addStudent(){
        System.out.println("enter id:");
        int id=sc.nextInt();
        sc.nextLine();
        

        System.out.println("enter name:");
        String name=sc.nextLine();

        System.out.println("enter age:");
        int age=sc.nextInt();
        sc.nextLine();
        
        System.out.println("enter course:");
        String course=sc.nextLine();
        
        Data s=new Data(id,name,age,course);
        students.add(s);
    }

    public static void viewStudents(){
        if(students.isEmpty()){
            System.out.println("nothing in datalist");

        }
        else{
            System.out.println("\n------students list here------");

            for(Data s:students){
                System.out.println(s);
            }
        }
    }

    public static void searchStudent(){
        System.out.println("enter id to search:");
        int id=sc.nextInt();
        
        for(Data s: students)
        {
            if(s.getId()==id){
                System.out.println("student found:" +s);
                return;
            }

        }
        System.out.println("Student not found here!");
        }

    public static void deleteStudent(){
        System.out.println("enter id to delete:");
        int id=sc.nextInt();

        for(Data s: students){
            if(s.getId()==id){
                students.remove(s);
                System.out.println("student deleted:" +s);
            }
            System.out.println("student not found here!");
        }


    }
    




} 

