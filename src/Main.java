import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        File adminFile= new File("Files\\Admin.txt");
        Scanner scan= new Scanner(adminFile);
        String username = scan.nextLine();
        String password = scan.nextLine();
        String name = scan.nextLine();

        Files file=new Files();

        Files.read(file);


        SpecialCitizen victim1= new SpecialCitizen("12345678910123", "Rady Mohamed", 18, Citizen.Gender.MALE, "01010202031", "Giza", "Victim is murdered by knife", SpecialCitizen.Relation.Victim);
        Case c1 = new Case(100, "Murder", victim1);
        Department d1= new Department(1,"FBI", "02914054578124");
        Manager M1= new Manager("02914054578124", "Rady Mohamed",43, Citizen.Gender.MALE, "01202320509", "Giza", "12000", "1", "RadyMohamed", "Ahmed123",file );
        Officer Off1= new Officer("30312122103257", "Khattab Abd El-Moniem", 21, Citizen.Gender.MALE, "01101540646",  "Giza", "8000", "gedokhattab", "Gkgk1234", file);

        M1.assignCaseToOfficer("30312122103257", "100");
        M1.assignOfficerToDepartment("30312122103257");
        M1.UpdateCaseDetails("100","12346891582110","Mohamed Aly","30", Citizen.Gender.MALE,"01123456789","Cairo","I found the victim dead");

        Off1.AddCriminal(100, "12345678910123","Hany Yasser", 21, Citizen.Gender.MALE, "01201540646", "Giza");
        Off1.AddEvidence(101, "Knife", "Murder Weapon", "Khattab Abd El-Moniem", 100);
        Off1.AddSuspect(100,"57015236412578", "Ayman Aly", 21, Citizen.Gender.MALE, "01257641238", "Giza", "Suspect was last seen exiting crime scene");
        Off1.AddWitness(100,"21213456258421", "Magdy Mohamed",27, Citizen.Gender.MALE, "01105246785", "Cairo", "I saw him");
        Off1.UpdateCase("100","Murder","Murder happened in giza, victim is 18 years old.");

        file.MainOfficersList.add(Off1);
        file.MainDepartmentsList.add(d1);
        file.MainCasesList.add(c1);
        file.MainManagersList.add(M1);


        Files.write(file);



        // Set the Admin
        Admin.setAdmin(username, password, name, file);

        /*Login_Frame login = new Login_Frame();

        JFrame frame = new JFrame();
        frame.setTitle("Hello World!");
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        gd.setFullScreenWindow(frame);
        //frame.setSize(d.width+50, d.height -10);
        frame.setUndecorated(false);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon logo =new ImageIcon("./Images/logo.png");
        frame.setIconImage(logo.getImage());
        frame.getContentPane().setBackground(Color.decode("#0D2C54"));
        frame.setVisible(true);
    */
    }


}