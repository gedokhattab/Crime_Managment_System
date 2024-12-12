import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Case implements Serializable {
    private static final long serialVersionUID = -231079148946252998L;
    int CaseID;
    String Description;
    LocalDate StartDate;
    LocalDate LastUpdateDate;
    String CaseType;
    ArrayList<Officer> Officers = new ArrayList<>();
    ArrayList<Criminal> Criminals = new ArrayList<>();
    ArrayList<Witness> Witnesses = new ArrayList<>();
    ArrayList<SpecialCitizen> Suspects = new ArrayList<>();
    ArrayList<Evidence> Evidences = new ArrayList<>();
    SpecialCitizen complainant;
    SpecialCitizen Victim;

//Used by Admin for CreateCase();
    public Case(int caseID, String caseType, SpecialCitizen victim) {
        CaseID = caseID;
        StartDate = LocalDate.now();
        CaseType = caseType;
        Victim = victim;
    }
}
