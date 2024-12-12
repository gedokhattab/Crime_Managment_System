import java.io.Serializable;
import java.util.ArrayList;

public class Criminal extends Citizen implements Serializable {
    private static final long serialVersionUID = -231079148946252998L;
    String CurrentLocation;
    ArrayList<Case> CrimesCommitted = new ArrayList<>();
    Files file;
    enum Danger {
        High,
        Moderate,
        Low
    }
    Danger Level;

    public Criminal(String SSN, String Name, int Age, Gender gender, String PhoneNumber, String Address, Files file) {
        super(SSN, Name, Age, gender, PhoneNumber, Address);
        this.file = file;
    }

    public Criminal(String currentLocation, ArrayList<Case> crimesCommitted) {
        CurrentLocation = currentLocation;
        CrimesCommitted = crimesCommitted;
        Level = CalcDangerLevel(crimesCommitted);
    }

    public Criminal(String SSN, String Name, int Age, Gender gender, String PhoneNumber, String Address, String currentLocation) {
        super(SSN, Name, Age, gender, PhoneNumber, Address);
        CurrentLocation = currentLocation;
    }



    public Danger CalcDangerLevel(ArrayList <Case> CrimesCommitted) {
        int NumberCrimes = CrimesCommitted.size();
        if (NumberCrimes > 5 && NumberCrimes < 10)
            return Danger.Moderate;
        else if (NumberCrimes > 10)
            return Danger.High;
        else
            return Danger.Low;
    }
}
