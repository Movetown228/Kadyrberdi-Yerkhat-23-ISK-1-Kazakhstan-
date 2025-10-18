class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}
class Student {
    private String name;
    private int age;

    public Student(String name, int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Возраст студента должен быть не меньше 18 лет!");
        }
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " (" + age + " лет)";
    }
}
import java.util.ArrayList;
import java.util.List;
class School {
    private List<Student> students = new ArrayList<>();

    public void addStudent(String name, int age) {
        try {
            Student student = new Student(name, age);
            students.add(student);
            System.out.println("Студент добавлен: " + student);
        } catch (InvalidAgeException e) {
            System.out.println("Ошибка при добавлении студента " + name + ": " + e.getMessage());
        }
    }

    public void printAllStudents() {
        System.out.println("Список студентов школы:");
        for (Student s : students) {
            System.out.println(" - " + s);
        }
    }
}
public class Main {
    public static void main(String[] args) {
        School school = new School();

        school.addStudent("Алина", 17);   
        school.addStudent("Дамир", 19);  
        school.addStudent("Мария", 22);   
        school.addStudent("Ерхан", 15);   

        System.out.println();
        school.printAllStudents();
    }
}
