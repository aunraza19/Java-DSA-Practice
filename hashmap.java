import java.util.HashMap;
import java.util.Scanner;

public class hashmap {
        private HashMap<Integer, String> attendace;
    public hashmap(){
        attendace=new HashMap<>();
    }
    public void add(int student_id, String status){
        if(attendace.containsKey(student_id)){
            System.out.println("student already exist");
        }
        else {
            attendace.put(student_id,status);
        }
    }
    public void update(int student_id, String status){
        if(attendace.containsKey(student_id)){
            attendace.put(student_id,status);
        }
        else{
            System.out.println("student not found");
        }
    }
    public void current_status(int student_id){
        if (attendace.containsKey(student_id)){
            System.out.println("student id: "+student_id+" status: " + attendace.get(student_id));
        }
        else {
            System.out.println("student not found");
        }
    }
    public void remove(int student_id, String status){
        if (attendace.containsKey(student_id)){
            attendace.remove(student_id);
        }
        else{
            System.out.println("student not found");
        }
    }

        public static void main(String[] args) {
            hashmap system = new hashmap();
            Scanner sc= new Scanner(System.in);
            int choice;
            do {
                System.out.println("\nAttendance System Menu:");
                System.out.println("1. Add new student");
                System.out.println("2. Update attendance status");
                System.out.println("3. Check student status");
                System.out.println("4. Remove student");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                switch (choice){
                    case 1:
                        int student_id=sc.nextInt();
                        sc.nextLine();
                        String status= sc.nextLine();
                        system.add(student_id,status);
                        break;
                    case 2:
                         student_id=sc.nextInt();
                        sc.nextLine();
                         status= sc.nextLine();
                         system.update(student_id,status);
                         break;
                    case 3:
                        student_id=sc.nextInt();
                        sc.nextLine();
                        system.current_status(student_id);
                        break;
                    case 4:
                        student_id=sc.nextInt();
                        sc.nextLine();
                        status= sc.nextLine();
                        system.remove(student_id,status);
                        break;
                    case 5:
                        System.out.println("exiting");
                        break;
                    default:
                        System.out.println("wrong choice");

                }

            } while (choice!=5);
            sc.close();

        }

    }

