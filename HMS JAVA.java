import java.util.*;

/* Main Class */
public class HospitalManagementSystem {

    static Scanner scanner = new Scanner(System.in);
    static List<Patient> patients = new ArrayList<>();

    public static void main(String[] args) {
        boolean continueSystem = true;

        while (continueSystem) {

            System.out.println("\n--- Hospital Management System ---");
            System.out.println("1. Add Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Search Patient by ID");
            System.out.println("4. Delete Patient by ID");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    viewPatients();
                    break;
                case 3:
                    searchPatient();
                    break;
                case 4:
                    deletePatient();
                    break;
                case 5:
                    System.out.println("\nThank you for using the Hospital Management System.");
                    continueSystem = false;
                    continue;
                default:
                    System.out.println("Invalid choice.");
            }

            if (continueSystem) {
                continueSystem = askToContinue();
                if (!continueSystem) {
                    System.out.println("\nThank you for using the Hospital Management System.");
                }
            }
        }
    }

    /* Ask user to continue or exit */
    public static boolean askToContinue() {
        System.out.print("\nDo you want to continue? (Y/N): ");
        char ch = scanner.next().charAt(0);
        return ch == 'Y' || ch == 'y';
    }

    /* Add Patient */
    public static void addPatient() {
        System.out.print("Enter Patient ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Disease: ");
        String disease = scanner.nextLine();

        patients.add(new Patient(id, name, age, disease));
        System.out.println("Patient added successfully.");
    }

    /* View Patients */
    public static void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
        } else {
            System.out.println("\n--- Patient List ---");
            for (Patient p : patients) {
                System.out.println(p);
            }
        }
    }

    /* Search Patient */
    public static void searchPatient() {
        System.out.print("Enter Patient ID to search: ");
        int id = scanner.nextInt();

        for (Patient p : patients) {
            if (p.getId() == id) {
                System.out.println("Patient Found:");
                System.out.println(p);
                return;
            }
        }
        System.out.println("Patient not found.");
    }

    /* Delete Patient */
    public static void deletePatient() {
        System.out.print("Enter Patient ID to delete: ");
        int id = scanner.nextInt();

        Iterator<Patient> iterator = patients.iterator();
        while (iterator.hasNext()) {
            Patient p = iterator.next();
            if (p.getId() == id) {
                iterator.remove();
                System.out.println("Patient deleted successfully.");
                return;
            }
        }
        System.out.println("Patient ID not found.");
    }
}

/* Patient Class */
class Patient {

    private int id;
    private String name;
    private int age;
    private String disease;

    public Patient(int id, String name, int age, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ID: " + id +
               ", Name: " + name +
               ", Age: " + age +
               ", Disease: " + disease;
    }
}
