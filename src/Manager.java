import java.io.Serializable;

public class Manager extends Citizen implements Serializable {
    private static final long serialVersionUID = -231079148946252998L;
    private int Salary;
    int DepartmentID;
    private String username;
    private String password;
    private final Files file;

    //  Used by Admin for CreateManager();
    public Manager(String SSN, String Name, int Age, Gender gender, String PhoneNumber, String Address, String salary, String departmentID, String username, String password, Files file) {
        super(SSN, Name, Age, gender, PhoneNumber, Address);
        this.file = file;
        setSalary(salary);
        setDepartmentID(departmentID);
        setUsername(username);
        setPassword(password);

    }

    //Used by Officer for setUsername();
    public String getUsername() {
        return username;
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

    // Used in Manager Constructor
    public void setDepartmentID(String departmentID) {
        try {
            int intDepartmentID = Integer.parseInt(departmentID); // string to num

            if (intDepartmentID < 0) {
                throw new IllegalArgumentException("INVALID ID !! Department ID must be positive.");
            }

            this.DepartmentID = intDepartmentID;

        } catch (NumberFormatException e) {
            System.out.println("Error: Department ID must be an integer value.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Used in Manager Constructor
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

    // Used in Manager Constructor
    public void setUsername(String username) {
        if (username == null || username.isEmpty())
            throw new IllegalArgumentException(" Username cannot be null or empty.");
        for (int i = 0; i < file.MainManagersList.size(); i++)
            if (file.MainManagersList.get(i).username.equals(username))
                throw new IllegalArgumentException("Username is already assigned to a manager!!");
        for (int j = 0; j < file.MainOfficersList.size(); j++)
            if (file.MainOfficersList.get(j).getUsername().equals(username))
                throw new IllegalArgumentException("Username is already assigned to an officer!!");
        this.username = username;
    }

    public void assignCaseToOfficer(String ID, String CaseID) {

        for (Case caseObj : file.MainCasesList)
            if (caseObj.CaseID == Integer.parseInt(CaseID)) {
                for (Officer officer : file.MainOfficersList) {
                    if (officer.SSN.equals(ID))
                        try {
                            if (!officer.OfficerCases.contains(caseObj) && !caseObj.Officers.contains(officer)) {
                                officer.OfficerCases.add(caseObj);
                                caseObj.Officers.add(officer);
                                System.out.println("Case assigned to the officer successfully.");
                            } else {
                                System.out.println("The officer is already handling this case.");
                            }
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                }
            }
    }

    public void assignOfficerToDepartment(String ID) {

        for (Department departmentObj : file.MainDepartmentsList)
            if (departmentObj.ID == this.DepartmentID) {
                for (Officer officer : file.MainOfficersList) {
                    if (officer.SSN.equals(ID))
                        try {
                            if (officer.department_ID == 0 && departmentObj.Officers.contains(officer)) {
                                officer.department_ID = departmentObj.ID;
                                departmentObj.Officers.add(officer);
                                System.out.println("Officer assigned to the department successfully.");
                            } else {
                                System.out.println("The officer is already assigned to this department.");
                            }
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                }
            }
    }


    public void UpdateCaseDetails(String CaseID, String SSN, String Name, String Age, Gender gender, String PhoneNumber, String Address, String description) {
        SpecialCitizen newComplainant = new SpecialCitizen(SSN, Name, Integer.parseInt(Age), gender, PhoneNumber, Address, description, SpecialCitizen.Relation.Complainant);
        // Iterate through departments
        for (int i = 0; i < file.MainDepartmentsList.size(); i++) {
            // Check if the department's manager ID matches this Manager's department
            if (file.MainDepartmentsList.get(i).ManagerID == this.DepartmentID) {
                // Iterate through the cases in the department
                for (int j = 0; j < file.MainDepartmentsList.get(i).Cases.size(); j++) {
                    // Find the case with the matching CaseID
                    if (file.MainDepartmentsList.get(i).Cases.get(j).CaseID == Integer.parseInt(CaseID)) {
                        // Assign the newComplainant to the case's complainant field
                        file.MainDepartmentsList.get(i).Cases.get(j).complainant = newComplainant;
                    }
                }
            }
        }
    }
}
