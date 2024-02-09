public class Student{

    String surname;
    int attendence;
    double percent;


    public Student() {
    }


    public Student(String surname, int attendence) {
        this.surname = surname;
        this.attendence = attendence;
    }


    public Student(Student obj, double percent) {
        this.surname = obj.surname;
        this.attendence = obj.attendence;
        this.percent = percent;
    }


    public double percentageOfaStudent(int attend){

        percent = ((double) attend/45)*100;

        return percent;

    }

    @Override
    public String toString() {
        return "Student [surname=" + surname + ", attendence=" + attendence + ", percent=" + percent + "]";
    }


    public static double avgOfAllStudent(Student[] arr){
        int sum=0;
        double average;

        for(Student s:arr){
            sum = sum+s.attendence;
        }

        average = (double) sum / arr.length;

        // System.out.println("Average of all student is : " + average);
        return average;
    }


}