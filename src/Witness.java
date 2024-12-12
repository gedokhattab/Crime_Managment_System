import java.io.Serializable;

public class Witness extends Citizen implements Serializable {
    private static final long serialVersionUID = -231079148946252998L;
    String Testimony;
    int CaseID;

    public Witness(String SSN, String Name, int Age, Gender gender, String PhoneNumber, String Address, String testimony, int caseID) {
        super(SSN, Name, Age, gender, PhoneNumber, Address);
        Testimony = testimony;
        CaseID = caseID;
    }
}
