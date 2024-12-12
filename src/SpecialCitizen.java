import java.io.Serializable;

public class SpecialCitizen extends Citizen implements Serializable {
    private static final long serialVersionUID = -231079148946252998L;
    String Description;

    enum Relation {
        Victim,
        Complainant,
        Suspect
    }

    Relation RelationToCase;

    public SpecialCitizen(String SSN, String Name, int Age, Gender gender, String PhoneNumber, String Address, String description, Relation relationToCase) {
        super(SSN, Name, Age, gender, PhoneNumber, Address);
        Description = description;
        RelationToCase = relationToCase;
    }
}
