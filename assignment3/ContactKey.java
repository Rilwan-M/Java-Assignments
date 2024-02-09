public class ContactKey{

    public String fName;
    public  String lName;


    public ContactKey(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
    }

    


    @Override
    public String toString() {
        return "ContactKey{" +
                "firstName='" + fName + '\'' +
                ", lastName='" + lName + '\'' +
                '}';
    }

    // public String getfName() {
    //     return fName;
    // }
    // public void setfName(String fName) {
    //     this.fName = fName;
    // }
    // public String getlName() {
    //     return lName;
    // }
    // public void setlName(String lName) {
    //     this.lName = lName;
    // }

    


}