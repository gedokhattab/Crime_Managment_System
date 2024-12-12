import java.io.Serializable;

import static java.lang.System.out;

public final class Admin implements Serializable {

    private static final long serialVersionUID = -231079148946252998L;
    private final String Username;
    private final String Password;
    private final String Name;
    private final Files file;

    // Singleton instance
    private static Admin adminInstance;

    // Private constructor
    private Admin(String username, String password, String name, Files file) {
        this.Username = username;
        this.Password = password;
        this.Name = name;
        this.file= file;
    }

    // Static method to set or get the admin instance
    public static Admin setAdmin(String username, String password, String name, Files file) {
        if (adminInstance == null) {
            adminInstance = new Admin(username, password, name, file);
        } else {
            System.out.println("Admin is already set!");
        }
        return adminInstance;
    }

    // Getter for the Admin instance
    public static Admin getAdmin() {
        if (adminInstance == null) {
            throw new IllegalStateException("Admin has not been set yet!");
        }
        return adminInstance;
    }


    //Create Department
    public void CreateDepartment(String ID, String Name, String ManagerID) {
        Department newDepartment = new Department(Integer.parseInt(ID), Name, ManagerID);
        file.MainDepartmentsList.add(newDepartment);
        out.println("Department added " + newDepartment);

    }

    //Create case
    public void CreateCase(String ID, String CaseType, String SSN, String Name, String Age, Citizen.Gender gender, String PhoneNumber, String Address, String Description) {
        SpecialCitizen Victim= new SpecialCitizen(SSN, Name, Integer.parseInt(Age), gender, PhoneNumber, Address, Description, SpecialCitizen.Relation.Victim);
        Case newCase = new Case(Integer.parseInt(ID), CaseType, Victim);
        file.MainCasesList.add(newCase);
        out.println("Case added " + newCase);
    }

    //Create Criminal
    public void CreateCriminal(String SSN, String Name, String Age, Citizen.Gender gender, String PhoneNumber, String Address){
        Criminal newCriminal = new Criminal(SSN, Name, Integer.parseInt(Age), gender, PhoneNumber, Address, file);
        file.MainCriminalsList.add(newCriminal);
        out.println("Criminal added " + newCriminal);
    }

    //Create Officer
    public void CreateOfficer(String SSN, String Name, String Age, Citizen.Gender gender, String PhoneNumber, String Address, String salary, String username, String password) {
        Officer newOfficer = new Officer(SSN, Name, Integer.parseInt(Age), gender, PhoneNumber, Address, salary, username, password, file);
        file.MainOfficersList.add(newOfficer);
        out.println("Officer added " + newOfficer);
    }

    //Create Manager
    public Manager createManager(String SSN, String Name, String Age, Citizen.Gender gender, String PhoneNumber, String Address, String salary, String departmentID, String username, String password) {
        Manager newManager = new Manager(SSN, Name,Integer.parseInt(Age), gender,PhoneNumber,Address, salary, departmentID, username, password, file);
        file.MainManagersList.add(newManager);
        return newManager;
    }

    //delete officer
    public boolean deleteOfficer(String SSN) {
        for (int i = 0; i < file.MainOfficersList.size(); i++) {
            if (file.MainOfficersList.get(i).getSSN().equals(SSN)) {
                file.MainOfficersList.remove(i);
                return true;
            }
        }
        return false;
    }

    //delete manager
    public boolean deleteManager(String Name) {
        for (int i = 0; i < file.MainManagersList.size(); i++) {
            if (file.MainManagersList.get(i).getName().equals(Name)) {
                file.MainManagersList.remove(i);
                return true;
            }
        }
        return false;
    }
}

