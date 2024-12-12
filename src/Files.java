import java.io.*;
import java.util.ArrayList;

public class Files implements Serializable{
    private static final long serialVersionUID = -231079148946252998L;
    public Files() throws IOException {

    }
    public  static void read(Files file){
        file.readCaseFiles();
        file.readComplainantFiles();
        file.readCriminalFiles();
        file.readDepartmentFiles();
        file.readEvidenceFiles();
        file.readManagerFiles();
        file.readOfficerFiles();
        file.readSuspectFiles();
        file.readVictimFiles();
        file.readWitnessFiles();
    }
    public  static void write(Files file) throws IOException {
        file.writeCaseFiles();
        file.writeComplainantFiles();
        file.writeCriminalFiles();
        file.writeDepartmentFiles();
        file.writeEvidenceFiles();
        file.writeManagerFiles();
        file.writeOfficerFiles();
        file.writeSuspectFiles();
        file.writeVictimFiles();
        file.writeWitnessFiles();
    }

    //    Case File definition
    File CasesFile= new File("Files\\Cases.txt");
    public ArrayList<Case> MainCasesList = new ArrayList<>();
    public void readCaseFiles() {
        try (ObjectInputStream Casesois = new ObjectInputStream(new FileInputStream(CasesFile))) {
            while (true) {
                try {
                    MainCasesList.add((Case) Casesois.readObject());
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void writeCaseFiles() {
        try (ObjectOutputStream Casesoos = new ObjectOutputStream(new FileOutputStream(CasesFile))) {
            for (Case aCase : MainCasesList) {
                Casesoos.writeObject(aCase);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    Complainants File definition
    File ComplainantsFile= new File("Files\\Complainants.txt");
    public ArrayList<SpecialCitizen> MainComplainantsList = new ArrayList<>();
    public void readComplainantFiles() {
        try (ObjectInputStream Complainantsois= new ObjectInputStream(new FileInputStream(ComplainantsFile))) {
            while (true) {
                try {
                    MainComplainantsList.add((SpecialCitizen) Complainantsois.readObject());
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void writeComplainantFiles() {
        try (ObjectOutputStream Complainantsoos= new ObjectOutputStream(new FileOutputStream(ComplainantsFile))) {
            for (SpecialCitizen specialCitizen : MainComplainantsList) {
                Complainantsoos.writeObject(specialCitizen);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    Criminals File definition
    File CriminalsFile= new File("Files\\Criminals.txt");
    public ArrayList<Criminal> MainCriminalsList = new ArrayList<>();
    public void readCriminalFiles() {
        try (ObjectInputStream Criminalsois= new ObjectInputStream(new FileInputStream(CriminalsFile))) {
            while (true) {
                try {
                    MainCriminalsList.add((Criminal) Criminalsois.readObject());
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void writeCriminalFiles() {
        try (ObjectOutputStream Criminalsoos= new ObjectOutputStream(new FileOutputStream(CriminalsFile))) {
            for (Criminal criminal : MainCriminalsList) {
                Criminalsoos.writeObject(criminal);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


//    Departments File definition
    File DepartmentsFile= new File("Files\\Departments.txt");
    public ArrayList<Department> MainDepartmentsList = new ArrayList<>();
    public void readDepartmentFiles() {
        try (ObjectInputStream Departmentsois= new ObjectInputStream(new FileInputStream(DepartmentsFile))) {
            while (true) {
                try {
                    MainDepartmentsList.add((Department) Departmentsois.readObject());
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void writeDepartmentFiles() {
        try (ObjectOutputStream Departmentsoos= new ObjectOutputStream(new FileOutputStream(DepartmentsFile))) {
            for (Department department : MainDepartmentsList) {
                Departmentsoos.writeObject(department);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    Evidences File definition
    File EvidencesFile= new File("Files\\Evidences.txt");
    public ArrayList<Evidence> MainEvidencesList = new ArrayList<>();
    public void readEvidenceFiles() {
        try (ObjectInputStream Evidencesois= new ObjectInputStream(new FileInputStream(EvidencesFile))) {
            while (true) {
                try {
                    MainEvidencesList.add((Evidence) Evidencesois.readObject());
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void writeEvidenceFiles() {
        try (ObjectOutputStream Evidencesoos= new ObjectOutputStream(new FileOutputStream(EvidencesFile))) {
            for (Evidence evidence : MainEvidencesList) {
                Evidencesoos.writeObject(evidence);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    Managers File definition
    File ManagersFile= new File("Files\\Managers.txt");
    public ArrayList<Manager> MainManagersList = new ArrayList<>();
    public void readManagerFiles() {
        try (ObjectInputStream Managersois= new ObjectInputStream(new FileInputStream(ManagersFile))) {
            while (true) {
                try {
                    MainManagersList.add((Manager) Managersois.readObject());
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void writeManagerFiles() {
        try (ObjectOutputStream Managersoos= new ObjectOutputStream(new FileOutputStream(ManagersFile))) {
            for (Manager manager : MainManagersList) {
                Managersoos.writeObject(manager);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    Officers File definition
    File OfficersFile= new File("Files\\Officers.txt");
    public ArrayList<Officer> MainOfficersList = new ArrayList<>();
    public void readOfficerFiles() {
        try (ObjectInputStream Officersois= new ObjectInputStream(new FileInputStream(OfficersFile))) {
            while (true) {
                try {
                    MainOfficersList.add((Officer) Officersois.readObject());
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void writeOfficerFiles() {
        try (ObjectOutputStream Officersoos= new ObjectOutputStream(new FileOutputStream(OfficersFile))) {
            for (Officer officer : MainOfficersList) {
                Officersoos.writeObject(officer);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //    Suspects File definition
    File SuspectsFile= new File("Files\\Suspects.txt");
    public ArrayList<SpecialCitizen> MainSuspectsList = new ArrayList<>();
    public void readSuspectFiles() {
        try (ObjectInputStream Suspectsois= new ObjectInputStream(new FileInputStream(SuspectsFile))) {
            while (true) {
                try {
                    MainSuspectsList.add((SpecialCitizen) Suspectsois.readObject());
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void writeSuspectFiles() {
        try (ObjectOutputStream Suspectsoos= new ObjectOutputStream(new FileOutputStream(SuspectsFile))) {
            for (SpecialCitizen suspect : MainSuspectsList) {
                Suspectsoos.writeObject(suspect);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    Victims File definition
    File VictimsFile= new File("Files\\Victims.txt");
    public ArrayList<SpecialCitizen> MainVictimsList = new ArrayList<>();
    public void readVictimFiles() {
        try (ObjectInputStream Victimsois= new ObjectInputStream(new FileInputStream(VictimsFile))) {
            while (true) {
                try {
                    MainVictimsList.add((SpecialCitizen) Victimsois.readObject());
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void writeVictimFiles() {
        try (ObjectOutputStream Victimsoos= new ObjectOutputStream(new FileOutputStream(VictimsFile))) {
            for (SpecialCitizen victim : MainVictimsList) {
                Victimsoos.writeObject(victim);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    Witnesses File definition
    File WitnessesFile= new File("Files\\Witnesses.txt");
    public ArrayList<Witness> MainWitnessesList = new ArrayList<>();
    public void readWitnessFiles() {
        try (ObjectInputStream Witnessesois= new ObjectInputStream(new FileInputStream(WitnessesFile))) {
            while (true) {
                try {
                    MainWitnessesList.add((Witness) Witnessesois.readObject());
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void writeWitnessFiles() {
        try (ObjectOutputStream Witnessesoos= new ObjectOutputStream(new FileOutputStream(WitnessesFile))) {
            for (Witness witness : MainWitnessesList) {
                Witnessesoos.writeObject(witness);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }}
