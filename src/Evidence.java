import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Evidence implements Serializable {
    private static final long serialVersionUID = -231079148946252998L;
    int ID;
    String Description;
    String Type;
    String CollectedBy;
    LocalDate CollectionDate;
    int CaseID;

    public Evidence(int ID, String description, String type, String collectedBy, int caseID) {
        this.ID = ID;
        Description = description;
        Type = type;
        CollectedBy = collectedBy;
        CollectionDate = LocalDate.now();
        CaseID = caseID;
    }
}
