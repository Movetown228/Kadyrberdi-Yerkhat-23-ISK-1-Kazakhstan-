import java.util.*;
class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String message) {
        super(message);
    }
}
class LowGradeException extends Exception {
    public LowGradeException(String message) {
        super(message);
    }
}

public class Main {
    public static void findGrade(Map<String, Integer> grades, String student)
            throws StudentNotFoundException, LowGradeException {
        if (!grades.containsKey(student)) {
            throw new StudentNotFoundException("Студент '" + student + "' не найден!");
        }
        int grade = grades.get(student);
        if (grade < 50) {
            throw new LowGradeException("Оценка студента " + student + " слишком низкая: " + grade);
        }

        System.out.println(student + " сдал экзамен успешно! Оценка: " + grade);
    }

    public static void main(String[] args) {
        Map<String, Integer> grades = new HashMap<>();
        grades.put("Алина", 85);
        grades.put("Ержан", 45);
        grades.put("Мария", 74);
        try {
            findGrade(grades, "Шыгыла");   
            findGrade(grades, "Ерке");   
            findGrade(grades, "Айдын");        }
        catch (StudentNotFoundException e) {
            System.out.println(" Ошибка: " + e.getMessage());
        }
        catch (LowGradeException e) {
            System.out.println(" Предупреждение: " + e.getMessage());
        }
        finally {
            System.out.println("Проверка завершена.\n");
        }
    }
}
