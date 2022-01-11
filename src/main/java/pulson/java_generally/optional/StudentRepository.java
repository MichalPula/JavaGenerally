package pulson.java_generally.optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class StudentRepository {

    private static final Map<String, Student> students = new HashMap<>();
    static {
        students.put("John", new Student("John", 32));
        students.put("Mark", new Student("Mark", 28));
    }

    public static Optional<Student> findByName(String name){
        return Optional.ofNullable(students.get(name));
    }
}
