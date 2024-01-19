class Student{
    private String name;
    private int age;



    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public int getAge() {
        return age;
    }



    public void setAge(int age,Student obj) {
        Student obj1 = obj;
        obj1.age = age;
    }



    public void print(){

        System.out.println(this.name + " : " + this.age);
    }

}

public class Demo{

    public static void main(String args[] ){

            Student obj = new Student();
            obj.setName("Rilwan");
            obj.setAge(26,obj);

            obj.print();
    }


}