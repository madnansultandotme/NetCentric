import java.io.*;
import java.util.Scanner;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    int empID;
    String cnic;
    String designation;
    String department;

    public Employee(String name, int empID, String cnic, String designation, String department) {
        this.name = name;
        this.empID = empID;
        this.cnic = cnic;
        this.designation = designation;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", ID: " + empID + ", CNIC: " + cnic + 
               ", Designation: " + designation + ", Department: " + department;
    }
}

public class EmployeeFileHandling {
    private static final String OBJECT_FILE = "employee_object.dat";
    private static final String SIMPLE_FILE = "employee_simple.txt";
    private static final String RANDOM_ACCESS_FILE = "employee_random.dat";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);

        // Input Employee Record
        System.out.println("Enter Employee Details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Employee ID: ");
        int empID = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("CNIC: ");
        String cnic = scanner.nextLine();
        System.out.print("Designation: ");
        String designation = scanner.nextLine();
        System.out.print("Department: ");
        String department = scanner.nextLine();

        Employee employee = new Employee(name, empID, cnic, designation, department);

        // (a) Store and Read using Object Streams
        storeUsingObjectStream(employee);
        System.out.println("\nReading from Object Stream:");
        readUsingObjectStream();

        // (b) Store and Read using Random Access File
        storeUsingRandomAccessFile(employee);
        System.out.println("\nReading from Random Access File:");
        readUsingRandomAccessFile();

        // (c) Store and Read using Simple File
        storeUsingSimpleFile(employee);
        System.out.println("\nReading from Simple File:");
        readUsingSimpleFile();
    }

    // (a) Object Streams
    private static void storeUsingObjectStream(Employee employee) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(OBJECT_FILE))) {
            oos.writeObject(employee);
        }
    }

    private static void readUsingObjectStream() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(OBJECT_FILE))) {
            Employee employee = (Employee) ois.readObject();
            System.out.println(employee);
        }
    }

    // (b) Random Access File
    private static void storeUsingRandomAccessFile(Employee employee) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(RANDOM_ACCESS_FILE, "rw")) {
            raf.writeUTF(employee.name);
            raf.writeInt(employee.empID);
            raf.writeUTF(employee.cnic);
            raf.writeUTF(employee.designation);
            raf.writeUTF(employee.department);
        }
    }

    private static void readUsingRandomAccessFile() throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(RANDOM_ACCESS_FILE, "r")) {
            String name = raf.readUTF();
            int empID = raf.readInt();
            String cnic = raf.readUTF();
            String designation = raf.readUTF();
            String department = raf.readUTF();

            System.out.println("Name: " + name + ", ID: " + empID + ", CNIC: " + cnic +
                    ", Designation: " + designation + ", Department: " + department);
        }
    }

    // (c) Simple File
    private static void storeUsingSimpleFile(Employee employee) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SIMPLE_FILE))) {
            writer.write(employee.name + "," + employee.empID + "," + employee.cnic + "," +
                    employee.designation + "," + employee.department);
        }
    }

    private static void readUsingSimpleFile() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(SIMPLE_FILE))) {
            String line = reader.readLine();
            if (line != null) {
                String[] parts = line.split(",");
                System.out.println("Name: " + parts[0] + ", ID: " + parts[1] + ", CNIC: " + parts[2] +
                        ", Designation: " + parts[3] + ", Department: " + parts[4]);
            }
        }
    }
}
