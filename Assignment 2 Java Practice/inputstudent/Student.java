
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Student {
    private String name; private boolean gender; private int age;
    private float grade;
    public Student(String name, boolean gender, int age, float grade) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.grade = grade;
    }
     public String getName() {        return this.name;
    }
     public void setName(String name) {       this.name = name;
    }
     public boolean getGender() {       return this.gender;
    }
     public void setGender(boolean gender) {        this.gender = gender;
    }
     public int getAge() {        return this.age;
    }
     public void setAge(int age) {        this.age = age;
    }
     public float getGrade() {        return this.grade;
    }
     public void setGrade(float grade) {        this.grade = grade;
    }
    public static class StudentRecordWriter {
    DataOutputStream dataOutput;
    public StudentRecordWriter(String outputFile) throws IOException {
        dataOutput = new DataOutputStream(new FileOutputStream(outputFile));
    }
    public void write(Student student) throws IOException {
        dataOutput.writeUTF(student.getName());
        dataOutput.writeBoolean(student.getGender());
        dataOutput.writeInt(student.getAge());
        dataOutput.writeFloat(student.getGrade());
    }
    public void save() throws IOException {
        dataOutput.close();
    }
    }
    public static class StudentRecordReader {
   DataInputStream dataInput;
    public StudentRecordReader(String inputFile) throws IOException {
        dataInput = new DataInputStream(new FileInputStream(inputFile));
    }
    public List<Student> readAll() throws IOException {
        List<Student> listStudent = new ArrayList<>();
        try {
            while (true) {
                String name = dataInput.readUTF();
                boolean gender = dataInput.readBoolean();
                int age = dataInput.readInt();
                float grade = dataInput.readFloat();
                Student student = new Student(name, gender, age, grade);
                listStudent.add(student);
            }
        } catch (IOException e) {
            // End of file reached
        } finally {
            dataInput.close();
        }
        return listStudent;
    }
    }

    public static void main(String[] args) throws Exception{
//         List<Student> listStudent = new ArrayList<>();
//         listStudent.add(new Student("Alice", false, 23, 80.5f));
//         listStudent.add(new Student("Brian", true, 22, 95.0f));
//         listStudent.add(new Student("Carol", false, 21, 79.8f));
//         StudentRecordWriter writer = new StudentRecordWriter("students.txt");
//         for (Student student : listStudent) {
//                 writer.write(student);
//             }
StudentRecordReader reader = new StudentRecordReader("students.txt");
             List<Student> listStudent = reader.readAll();
             for (Student student : listStudent) {
                System.out.print(student.getName() + "\t");
                System.out.print(student.getGender() + "\t");
                System.out.print(student.getAge() + "\t");
                System.out.println(student.getGrade());
            }

   }
}


