import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Officer extends Citizen implements Serializable {
    private static final long serialVersionUID = -231079148946252998L;
    private int Salary;
    public ArrayList<Case> OfficerCases = new ArrayList<>();
    public int department_ID;
    private String username;
    private String password;
    private final Files file;

//    Used by Admin for CreateOfficer();
    public Officer(String SSN, String Name, int Age, Gender gender, String PhoneNumber, String Address, String salary, String username, String password, Files file) {
        super(SSN, Name, Age, gender, PhoneNumber, Address);
        setSalary(salary);
        this.username = username;
        this.password = password;
        this.file = file;
    }

    // Used in Manager Constructor
    public void setSalary(String Salary) {
        try {

            int IntSalary = Integer.parseInt(Salary); //string to num

            if (IntSalary < 0) {
                throw new IllegalArgumentException("INVALID SALARY!! Salary must be positive.");
            }

            this.Salary = IntSalary;

        } catch (NumberFormatException e) {

            System.out.println("Error: Salary must be an integer value.");
        } catch (IllegalArgumentException e) {  //if salary -veً
            System.out.println("Error: " + e.getMessage());
        }
    }

    public float getSalary() {
        return Salary;
    }

    // Used in Manager Constructor
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        try {
            if (password == null || password.isEmpty()) {
                throw new IllegalArgumentException("Password cannot be null or empty.");
            }

            if (password.length() < 6) {
                throw new IllegalArgumentException("Password must be at least 6 characters long.");
            }

            if (!password.matches(".*[A-Z].*") || !password.matches(".*[a-z].*") || !password.matches(".*\\d.*")) {  //.any char ,*repeating
                throw new IllegalArgumentException("Your password is not secure. Please try again");
            }

            this.password = password;

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void setUsername(String username) {
        if (username == null || username.isEmpty())
            throw new IllegalArgumentException(" Username cannot be null or empty.");
        for (int i = 0; i < file.MainManagersList.size(); i++)
            if (file.MainManagersList.get(i).getUsername().equals(username))
                throw new IllegalArgumentException("Username is already assigned to a manager!!");
        for (int j = 0; j < file.MainOfficersList.size(); j++)
            if (file.MainOfficersList.get(j).username.equals(username))
                throw new IllegalArgumentException("Username is already assigned to an officer!!");
        this.username = username;
    }

    public void UpdateCase(String CaseID, String CaseType, String Description) {
        int index;
        UpdateCaseDetails(CaseID, CaseType, Description);
        for (int i = 0; i < OfficerCases.size(); i++) {
            if (OfficerCases.get(i).CaseID == Integer.parseInt(CaseID)) {
                index = i;
                for (int j = 0; j < file.MainCasesList.size(); j++)
                    if (file.MainCasesList.get(j).CaseID == OfficerCases.get(index).CaseID)
                        file.MainCasesList.set(j, OfficerCases.get(index));
            }
        }
        UpdateCaseDetails(CaseID, CaseType, Description);
    }

    public void UpdateCaseDetails(String CaseID, String CaseType,String Description) {
        for (Case officerCase : OfficerCases)
            if (officerCase.CaseID == Integer.parseInt(CaseID)) {
                officerCase.CaseType = CaseType;
                officerCase.Description = Description;
                officerCase.LastUpdateDate = LocalDate.now();
            }
    }

    public void AddWitness(int CaseID, String SSN, String Name, int Age, Gender gender, String PhoneNumber, String Address, String testimony) {
        Witness newWitness = new Witness(SSN, Name, Age, gender, PhoneNumber, Address, testimony, CaseID);
        file.MainWitnessesList.add(newWitness);
        for (Case officerCase : OfficerCases)
            if (officerCase.CaseID == CaseID) {
                officerCase.Witnesses.add(newWitness);
            }
    }

    public void AddSuspect(int CaseID, String SSN, String Name, int Age, Gender gender, String PhoneNumber, String Address, String Description) {
        SpecialCitizen newSuspect = new SpecialCitizen(SSN, Name, Age, gender, PhoneNumber, Address, Description, SpecialCitizen.Relation.Suspect);
        file.MainSuspectsList.add(newSuspect);
        for (Case officerCase : OfficerCases)
            if (officerCase.CaseID == CaseID) {
                officerCase.Suspects.add(newSuspect);
            }
    }

    public void AddCriminal(int CaseID, String SSN, String Name, int Age, Gender gender, String PhoneNumber, String Address) {
        Criminal newCriminal = new Criminal(SSN, Name, Age, gender, PhoneNumber, Address, file);
        file.MainCriminalsList.add(newCriminal);
        for (Case officerCase : OfficerCases)
            if (officerCase.CaseID == CaseID) {
                officerCase.Criminals.add(newCriminal);
            }
    }

    public void AddEvidence(int ID, String description, String type, String collectedBy, int CaseID) {
        Evidence newEvidence = new Evidence(ID, description, type, collectedBy, CaseID);
        file.MainEvidencesList.add(newEvidence);
        for (Case officerCase : OfficerCases)
            if (officerCase.CaseID == CaseID) {
                officerCase.Evidences.add(newEvidence);
            }
    }

    public void RemoveWitness(int CaseID, String Name) {
        for (Case officerCase : OfficerCases)
            if (officerCase.CaseID == CaseID) {
                for (int j = 0; j < officerCase.Witnesses.size(); j++) {
                    if (officerCase.Witnesses.get(j).Name.equals(Name)) {
                        officerCase.Witnesses.remove(j);
                        j--;
                    }
                }
            }
    }

    public void RemoveSuspect(int CaseID, String Name) {
        for (Case officerCase : OfficerCases)
            if (officerCase.CaseID == CaseID) {
                for (int j = 0; j < officerCase.Suspects.size(); j++) {
                    if (officerCase.Suspects.get(j).Name.equals(Name)) {
                        officerCase.Suspects.remove(j);
                        j--;
                    }
                }
            }
    }

    public void RemoveCriminal(int CaseID, String Name) {
        for (Case officerCase : OfficerCases)
            if (officerCase.CaseID == CaseID) {
                for (int j = 0; j < officerCase.Criminals.size(); j++) {
                    if (officerCase.Criminals.get(j).Name.equals(Name)) {
                        officerCase.Criminals.remove(j);
                        j--;
                    }
                }
            }
    }

    public void RemoveEvidence(int ID, int CaseID) {
        for (Case officerCase : OfficerCases)
            if (officerCase.CaseID == CaseID) {
                for (int j = 0; j < officerCase.Evidences.size(); j++) {
                    if (officerCase.Evidences.get(j).ID == ID) {
                        officerCase.Evidences.remove(j);
                        j--;
                    }
                }
            }
    }

    public static void Display_Case(Case Case) {
        StringBuilder officerList = new StringBuilder("\t");
        for (int i = 0; i < Case.Officers.size(); i++) {
            officerList.append(Case.Officers.get(i).Name).append("\n\t");
        }

        StringBuilder witnessList = new StringBuilder("\t");
        for (int i = 0; i < Case.Witnesses.size(); i++) {
            witnessList.append(Case.Witnesses.get(i).Name).append("\n\t");
        }

        StringBuilder suspectList = new StringBuilder("\t");
        for (int i = 0; i < Case.Suspects.size(); i++) {
            suspectList.append(Case.Suspects.get(i).Name).append("\n\t");
        }

        StringBuilder criminalsList = new StringBuilder("\t");
        for (int i = 0; i < Case.Criminals.size(); i++) {
            criminalsList.append(Case.Criminals.get(i).Name).append("\n\t");
        }

        StringBuilder evidenceList = new StringBuilder("\t");
        for (int i = 0; i < Case.Evidences.size(); i++) {
            evidenceList.append(Case.Evidences.get(i).Type).append("\n\t");
        }


        {String caseID = "Case ID: " + Case.CaseID;
        String caseType = "Case Type: " + Case.CaseType;
        String crimeDate = "Crime Date: " + Case.StartDate;
        String lastUpdate = "Last Updated: " + Case.LastUpdateDate;
        String officers = "Officers: \n" + officerList;
        String Witness = "Witnesses: \n" + witnessList;
        String suspects = "Suspects: \n" + suspectList;
        String criminals = "Criminals: \n" + criminalsList;
        String complainant = "Complainant:" + Case.complainant.Name;
        String evidences = "Evidences: \n" + evidenceList;

        {
            System.out.println(caseID + "\t\t" + caseType);
            System.out.println(complainant);
            System.out.println(crimeDate);
            System.out.println(lastUpdate);
            System.out.println("\n----------------------------------------------------------------\n");
            System.out.println(officers);
            System.out.println("\n----------------------------------------------------------------\n");
            System.out.println(Witness);
            System.out.println("\n----------------------------------------------------------------\n");
            System.out.println(suspects);
            System.out.println("\n----------------------------------------------------------------\n");
            System.out.println(criminals);
            System.out.println("\n----------------------------------------------------------------\n");
            System.out.println(evidences);
            System.out.println("\n----------------------------------------------------------------\n");
        }}
    }


    @Override
    public String toString() {
        return "Officer{" +
                "salary=" + Salary +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", SSN='" + SSN + '\'' +
                ", Name='" + Name + '\'' +
                ", Age=" + Age +
                ", gender=" + gender +
                ", PhoneNumber=" + PhoneNumber +
                ", Address='" + Address + '\'' +
                '}';
    }
}
