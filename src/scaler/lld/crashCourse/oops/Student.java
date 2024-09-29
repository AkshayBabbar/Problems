package src.scaler.lld.crashCourse.oops;

public class Student extends User {


    public static final String PREFIX = "S";
    StudentStatus studentStatus;
    String batchName;
    private int psp;


    public Student(Long id, String name, StudentStatus studentStatus,
                   String emailId, String batchName, int psp) {
        super(id, name, emailId);
        this.studentStatus = StudentStatus.ACTIVE;
        if (psp > 100 || psp < 0) {
            throw new IllegalArgumentException("Wrong PSP entered");
        }
        this.batchName = batchName;
        this.psp = psp;
    }


    private String generateRollNumber() {
        return PREFIX + batchName + id;
    }

    @Override
    public void printDetails() {
        System.out.println(name + " (" + email + ") - " + batchName);
    }
}
