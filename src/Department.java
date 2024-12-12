import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Department implements Serializable {
    private static final long serialVersionUID = -231079148946252998L;
    int ID;
    String Name;
    LocalDate ActivationDate;
    Long ManagerID;
    ArrayList<Case> Cases = new ArrayList<>();
    ArrayList<Officer> Officers = new ArrayList<>();

//    Used by Admin CreateDepartment();
    public Department(int ID, String name, String managerID) {
        this.ID = ID;
        Name = name;
        ActivationDate = LocalDate.now();
        ManagerID = Long.parseLong(managerID);
    }

    public void FillCases(ArrayList<Officer> officers) {
        for (Officer officer : officers) {
            if (this.ID == officer.department_ID) {
                Cases.addAll(officer.OfficerCases);
            }
        }
    }
}
