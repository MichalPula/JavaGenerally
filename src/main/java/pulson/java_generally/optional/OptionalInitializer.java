package pulson.java_generally.optional;

import java.util.*;

public class OptionalInitializer {
    public static void main(String[] args) {

        Map<Integer, String> strings = new HashMap<>();
        strings.put(1, "a");
        strings.put(2, "b");
        strings.put(3, "c");

        Optional<String> optionalString1 = Optional.of(strings.get(1));//Optional[a]
        //Służy do opakowania wartości jako typ Optional, jednak próba opakowania wartości null skończy się rzuceniem NullPointerException
        Optional<String> optionalString2 = Optional.ofNullable(strings.get(5));//Optional.empty
        //W przypadku nulla nie rzuca NullPointerException tylko zwraca empty Optional
        Optional<String> optionalString3 = Optional.empty();//Optional.empty
        //Pusty Optional może być używany jako domyślna wartość zwracana przez metodę



        Optional<Student> studentOptional = StudentRepository.findByName("John");
        studentOptional.ifPresent(student -> System.out.println(student.getAge()));//32
        //ifPresent jako argument przyjmuje Consumer

        //Optional posiada dwie metody znane ze streamów - map() i filter(). Obie zwracają Optional<T>
        studentOptional.map(Student::getName).ifPresent(System.out::println);//John
        //map() w tym przypadku zmodyfikuje Optional<Student> do Optional<String>

        studentOptional.filter(student -> student.getAge() > 30).map(Student::getName).map(String::toUpperCase).ifPresent(System.out::println);//JOHN
        //filter() przefiltruje Optional używając Predicate tak jak w streamach



        Optional<Student> notExistingEmployee = StudentRepository.findByName("Michael");
        System.out.println(notExistingEmployee);//Optional.empty

        //or() w przypadku nieznalezienia szukanego obiektu, dostarczy domyślny Optional z ustalonym przez nas obiektem
        Optional<Student> optional = notExistingEmployee.or(() -> Optional.of(new Student("Jeffrey", 37)));
        System.out.println(optional);//Optional[Student{name='Jeffrey', age=37}]

        //orElse() zwróci ustaloną przez nas wartość w przypadku, gdy Optional nie zawiera szukanego przez nas obiektu
        String employeesName = notExistingEmployee.map(Student::getName).orElse("Student not found!");
        System.out.println(employeesName);//Student not found!
        Student michaelOrOlaf = notExistingEmployee.orElse(new Student("Olaf" ,44));
        System.out.println(michaelOrOlaf);//Student{name='Olaf', age=44}

        //orElseGet() jako argument przyjmuje Supplier. Dzięki lambdzie rozszerza możliwości dostarczenia obiektu, jakie daje nam metoda orElse()
        Student michaelOrJack = notExistingEmployee.orElseGet(() -> new Student("Jack", 22));
        System.out.println(michaelOrJack);//Student{name='Jack', age=22}

        //orElseThrow() pozwala rzucić ustalonym przez nas wyjątkiem, gdy Optional jest pusty
        //String employeesName2 = notExistingEmployee.map(Student::getName).orElseThrow(RuntimeException::new);

        //ifPresentOrElse() przyjmuje jako argumenty Consumer, który wykona się w przypadku występowania wartości Optional
        //i Runnable, który wykona się, gdy Optional będzie empty
        notExistingEmployee.filter(student -> student.getAge() > 30).map(Student::getName)
                .ifPresentOrElse(System.out::println, () -> System.out.println("No students older than 30 have been found!"));


        Optional<Student> studentOptional2 = StudentRepository.findByName("Mark");
        //W Javie 9 została wprowadzona możliwość stworzenia streamów z Optional
        Integer age = studentOptional2.stream().map(Student::getAge).findFirst().get();
        System.out.println(age);//28
    }
}
