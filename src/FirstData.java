import java.io.File;
import java.io.IOException;

public class FirstData {

    Files file= new Files();

    public FirstData(Files file) throws IOException {
//        private void updateCredentialData(Credential updatedCredentials) {
//            this.cast = updatedCredentials.cast;
//            this.director = updatedCredentials.director;
//            this.crew = updatedCredentials.crew;
//            this.producers = updatedCredentials.producers;
//        }
//    }
//    public void editCredential(int credentialID, Scanner scanner) {
//        if (this.credentialID != credentialID) {
//            System.out.println("Credential ID does not match.");
//            return;
//        }
//
//        System.out.println("Editing Credential ID: " + credentialID);
//
//        // Edit Director
//        System.out.print("Enter new Director name (or press Enter to keep current): ");
//        String directorName = scanner.nextLine();
//        if (!directorName.isEmpty()) {
//            this.director = new Director(this.director != null ? this.director.getPersonID() : 0, directorName);
//        }
//
//        // Edit Cast
//        System.out.print("Enter new Actor name to add (or press Enter to skip): ");
//        String actorName = scanner.nextLine();
//        if (!actorName.isEmpty()) {
//            this.cast.add(new Actor(this.cast.size() + 1, actorName));
//        }
//
//        // Edit Crew
//        System.out.print("Enter new Crew Member name to add (or press Enter to skip): ");
//        String crewName = scanner.nextLine();
//        if (!crewName.isEmpty()) {
//            this.crew.add(new CrewMember(this.crew.size() + 1, crewName));
//        }
//
//        // Edit Producers
//        System.out.print("Enter new Producer name to add (or press Enter to skip): ");
//        String producerName = scanner.nextLine();
//        if (!producerName.isEmpty()) {
//            this.producers.add(new Person(this.producers.size() + 1, producerName));
//        }
//
//        System.out.println("Credential updated successfully!");
//    }
}}
