import java.util.*;

class Grade {
    String name;
    String Id;
    String section;
    String grade;
    public Grade (String name, String Id, String section, String grade){
        this.name = name;
        this.Id = Id;
        this.section = section;
        this.grade = grade;
    }
    void Displaygrade(String name, String Id, String section, String grade){
        System.out.println("Name: " + name);
        System.out.println("ID: " + Id);
        System.out.println("Section: " + section);
        System.out.println("Grade: " + grade);
    }
}
public class Main {
    public static List <Grade> gradelist = new ArrayList<>();
    public static void main(String[] args) {
        int choice;
        do {
            
            System.out.println("Enter your choice: ");
            System.out.println("1. Add A student Grade");
            System.out.println("2. Edit a Student Grade");
            System.out.println("3. delete a student Grade");
            System.out.println("4. Display all the Grades");
            System.out.println("5. Exit...");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            switch (choice){
                case 1 ->addgrade(scanner);
                case 2 ->editgrade(scanner);
                case 3 -> deletegrade(scanner);
                case 4 -> Displaygradee();
                default-> System.out.println("Invalid choice.. try again !");
               }    
        } while (choice != 5);
    }
    private static void addgrade(Scanner scanner){
        scanner.nextLine();
        System.out.println("Enter the name: ");
        String name = scanner.nextLine();
        System.out.println("Enter ID: ");
        String ID = scanner.nextLine();
        System.out.println("Enter the Grade: ");
        String Gradee = scanner.nextLine();
        System.out.println("Enter your Section: ");
        String section = scanner.nextLine();
        gradelist.add(new Grade(name, ID, section, Gradee));
    }
    private static void editgrade(Scanner scanner){
        scanner.nextLine();
        System.out.println("Enter the name of student to Edit: ");
        String name = scanner.nextLine();
        for (Grade grade : gradelist) {
            if(grade.name == name){
                System.out.println("please enter the new name: ");
                String newname = scanner.nextLine();
                System.out.println("Enter ID: ");
                String newID = scanner.nextLine();
                System.out.println("Enter the Grade: ");
                String newGradee = scanner.nextLine();
                System.out.println("Enter your Section: ");
                String newsection = scanner.nextLine();
                grade.name = newname;
                grade.Id = newID;
                grade.section = newsection;
                grade.grade = newGradee;
                return;
            }
        }
        System.out.println("the student is not found: ");
    }
    private static void deletegrade(Scanner scanner){
        scanner.nextLine();
        System.out.println("Enter the name of student to Edit: ");
        String name = scanner.nextLine();
        Grade studenttodelete = null;

         for (Grade g: gradelist) {
            if(g.name.equals(name)){
                studenttodelete = g;
                break;
            }
        }
        if (studenttodelete == null){
            System.out.println("the student is not found: ");
        }
        else{
            gradelist.remove(studenttodelete);
            System.out.println("the Student have been Deleted succesfully");
        }

    }
    private static void Displaygradee(){
        System.out.println("all students data: ");
        for (Grade g : gradelist) {
            System.out.println("Name: " + g.name);
            System.out.println("ID: " + g.Id);
            System.out.println("Section: " + g.section);
            System.out.println("Grade: " + g.grade);
            System.out.println("-------------");
        }
    }   
}
