import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        // Specify the path to the classlist file
        String filePath = "C:/Users/Mohamed Rilwan/Desktop/java/CO225/Labs & Assign/Lab1/lab1/co225-classlist.txt";

        // Create a File object
        File file = new File(filePath);

        Scanner scanner;
        Student[] students = new Student[61];
                // Create a Random objectnull, 0
        Random random = new Random();

        
        int i=0,j=1;

        try {
            scanner = new Scanner(file);

            // Read names of students from the file
            while (scanner.hasNextLine()) {
                
                String studentName = scanner.nextLine();
                int StudentAttendence = random.nextInt(46);

                students[i] = new Student(studentName, StudentAttendence);
                i++;    

            } 

            for(Student s: students){
                // System.out.println(s.toString());
                // System.out.println(s.percentageOfaStudent(s.attendence));
                double percentage = s.percentageOfaStudent(s.attendence);
                if(percentage < 80){
                    System.out.println(s.surname);
                    j++;

                }
                    
                // studentPercentage[j] = new Student(s, percentage);
                // j++;

            }
            System.out.println(Student.avgOfAllStudent(students));

            // for(Student s: studentPercentage){
            //     System.out.println(s.toString());
            // }


        }catch (FileNotFoundException e) {
            System.out.println("File is not found");
            e.printStackTrace();
        }





        


        
    }
    
}

