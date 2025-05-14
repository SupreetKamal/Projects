import java.util.*;

public class HospitalManagementSystem {
    static Scanner scanner = new Scanner(System.in);
    static List<Patient> patients = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Hospital Management System ---");
            System.out.println("1. Add Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Search Patient by ID");
            System.out.println("4. Delete Patient by ID");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addPatient();
                case 2 -> viewPatients();
                case 3 -> searchPatient();
                case 4 -> deletePatient();
                case 5 -> System.out.println("Exiting system...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);
    }

    public static void addPatient() {
        System.out.print("Enter Patient ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Disease: ");
        String disease = scanner.nextLine();

        Patient patient = new Patient(id, name, age, disease);
        patients.add(patient);
        System.out.println("Patient added successfully.");
    }

    public static void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
        } else {
            System.out.println("--- Patient List ---");
            for (Patient p : patients) {
                System.out.println(p);
            }
        }
    }

    public static void searchPatient() {
        System.out.print("Enter Patient ID to search: ");
        int id = scanner.nextInt();
        boolean found = false;
        for (Patient p : patients) {
            if (p.getId() == id) {
                System.out.println("Patient Found: " + p);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Patient not found.");
        }
    }

    public static void deletePatient() {
        System.out.print("Enter Patient ID to delete: ");
        int id = scanner.nextInt();
        Iterator<Patient> iterator = patients.iterator();
        boolean deleted = false;
        while (iterator.hasNext()) {
            Patient p = iterator.next();
            if (p.getId() == id) {
                iterator.remove();
                System.out.println("Patient deleted successfully.");
                deleted = true;
                break;
            }
        }
        if (!deleted) {
            System.out.println("Patient ID not found.");
        }
    }
}
