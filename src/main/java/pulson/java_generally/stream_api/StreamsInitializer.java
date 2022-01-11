package pulson.java_generally.stream_api;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsInitializer {

    private final static List<Employee> EMPLOYEES_LIST = new ArrayList<>(Arrays.asList(
        new Employee(1, "Jeffrey Bezos", 100000.0),
        new Employee(2, "Bill Gates", 200000.0),
        new Employee(3, "Mark Zuckerberg", 300000.0)));


    public static void main(String[] args) {

        Stream.Builder<Employee> employeeStreamBuilder = Stream.builder();
        employeeStreamBuilder.accept(EMPLOYEES_LIST.get(0));
        employeeStreamBuilder.accept(EMPLOYEES_LIST.get(1));
        employeeStreamBuilder.accept(EMPLOYEES_LIST.get(2));

        Stream<Employee> employeeStream = EMPLOYEES_LIST.stream();


        Supplier<Stream<Employee>> employeeStreamSupplier = EMPLOYEES_LIST::stream;
        Stream<Employee> employeeStream1 = employeeStreamSupplier.get();
        Stream<Employee> employeeStream2 = employeeStreamSupplier.get();


        //INTERMEDIATE OPERATIONS

        //map() pozwala transformować elementy streama wywołując na nich Function (przyjmuje argument i zwraca obiekt tego samego lub innego typu)
        //Najczęściej użwana do zwracania streama obiektów innego typu.
        List<Integer> integerList = Arrays.asList(1, 2, 3 );
        List<Integer> doubledIntegerList = integerList.stream().map(integer -> integer * 2).collect(Collectors.toList());
        List<String> employeesNames = EMPLOYEES_LIST.stream().map(Employee::getName).collect(Collectors.toList());
        List<String> employeesNamesUppercase = employeesNames.stream().map(String::toUpperCase).collect(Collectors.toList());


        //flatMap() pozwala uprościć kolekcję danych. Najczęściej używana na liście list
        List<List<Integer>> numbersNested = Arrays.asList(
                Arrays.asList(1,2), Arrays.asList(3,4), Arrays.asList(5,6));

        List<Integer> numbersFlatList = numbersNested.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());


        //filter() zwraca stream elementów, które spełnią podany Predicate (przyjmuje argument i zwraca boolean)
        List<Employee> employeesFilter = EMPLOYEES_LIST.stream()
                .filter(Objects::nonNull)
                .filter(employee -> employee.getSalary() > 250000)
                .collect(Collectors.toList());


        //distinct() dnie przyjmuje argumentów i zwraca unikalne elementy streama eliminując duplikaty
        //Używa equals() do decydowania czy obiekty są równe, czy nie.
        List<Integer> intList = Arrays.asList(2, 5, 3, 2, 4, 2);
        List<Integer> distinctIntList = intList.stream().distinct().collect(Collectors.toList());


        //sorted() sortuje elementy streama. Korzysta z Comparatora podawanego jako argument
        EMPLOYEES_LIST.stream().sorted(Comparator.comparing(Employee::getName));//.forEach(employee -> System.out.println(employee.getName()));
        List<Employee> sortedEmployees = EMPLOYEES_LIST.stream().sorted(Comparator.comparing(Employee::getSalary)).collect(Collectors.toList());
        List<Employee> sortedEmployeesReversed = EMPLOYEES_LIST.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).collect(Collectors.toList());
        List<String> sortedEmployeesNames = EMPLOYEES_LIST.stream()
                .map(Employee::getName)
                .sorted().collect(Collectors.toList());


        //limit() zwraca stream z ograniczoną ilością elementów. Limit 1 ograniczy ilość elementów w streamie do 1
        List<Employee> limitEmployee = EMPLOYEES_LIST.stream().limit(1).collect(Collectors.toList());


        //skip() zwraca stream pomijając x elementów. Skip 2 pominie dwa pierwsze elementy streama i zacznie je zwracać od trzeciego
        List<Employee> skipEmployee = EMPLOYEES_LIST.stream().skip(2).collect(Collectors.toList());


        //peek() zwraca stream, wykonując operację na każdym z jego elementów. Przyjmuje Consumer jako argument
        List<Employee> employeesPeek = EMPLOYEES_LIST.stream().peek(employee -> employee.setSalary(employee.getSalary() + 10))
                .peek(employee -> employee.setSalary(employee.getSalary() - 10))
                .collect(Collectors.toList());




        //TERMINAL OPERATIONS

        //forEach() iteruje po elementach streama i wykonuje na każdym z nich ustalony przez nas Consumer
        EMPLOYEES_LIST.stream().forEach(employee -> employee.setSalary(employee.getSalary() + 10.0));
        EMPLOYEES_LIST.stream().forEach(Employee::getSalary);
        EMPLOYEES_LIST.forEach(System.out::println);


        //toArray() zwraca Array[] zawierający elementy streama
        Employee[] employees = EMPLOYEES_LIST.stream().toArray(Employee[]::new);
        String[] employeesNamesArray = EMPLOYEES_LIST.stream().map(Employee::getName).toArray(String[]::new);


        //reduce() bierze sekwencję elementów i dzięki operacji łączenia łączy je do pojedynczego wyniku
        Double sumSalary = EMPLOYEES_LIST.stream()
                .map(Employee::getSalary)
                .reduce(0.0, Double::sum);//600000.0

        List<String> letters = Arrays.asList("a", "b", "c", "d", "e");
        String result = letters.stream()
                .reduce("", (letter1, letter2) -> letter1 + letter2); //abcde

        List<Integer> numbers = Arrays.asList(123, 456, 789, 246, 135, 802, 791);
        int sum = numbers.stream().reduce(0, Integer::sum); //3342
        int sum2 = numbers.stream().reduce(0, (int1, int2) -> (int1 + int2)); //3342


        //collect() zbiera elementy streama do kolekcji. Używa klasy Collectors. Można za jej pomocą utworzyć dowolną kolekcję
        Map<Integer, String> employeesIdToName = EMPLOYEES_LIST.stream()
        .collect(Collectors.toMap(Employee::getId, Employee::getName));

        String namesString = EMPLOYEES_LIST.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(", "));

        Set<Double> salaries = EMPLOYEES_LIST.stream()
                .map(Employee::getSalary)
                .collect(Collectors.toSet());


        //min() i max() zwracają najmniejszy lub największy element streama bazując na Comparatorze. Typ zwrotny to Optional<?>
        Employee maxSalaryEmployee = EMPLOYEES_LIST.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .orElse(null);

        List<Integer> numbers2 = Arrays.asList(123, 456, 789, 246, 135, 802, 791);
        Integer minInteger = numbers2.stream().min(Integer::compareTo).get();


        //count() zwraca ilość elementów w streamie. Może być używana do liczenia elementów, które spełniają jakiś warunek
        Long countEmployee = EMPLOYEES_LIST.stream()
                .filter(employee -> employee.getSalary() > 500)
                .count();


        //allMatch(), anyMatch(), and noneMatch()
        //Sprawdzają, czy występują elementy, ktre spełniają warunek dostarczonego Predicate i zwracają odpowiedni boolean.
        List<Integer> intListMatch = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        boolean allBiggerThan0 = intListMatch.stream().allMatch(integer -> integer > 0); //true
        boolean anyBiggerThan7 = intListMatch.stream().anyMatch(integer -> integer > 7); //true
        boolean noneBiggerThan10 = intListMatch.stream().noneMatch(integer -> integer > 10); //true


        //findFirst() zwraca Optional pierwszego znalezionego elementu streama. Często łączony z warunkami filter()
        Employee employeeFindFirst = EMPLOYEES_LIST.stream()
                .filter(employee -> employee.getSalary() > 200000)
                .findFirst()
                .orElse(null);


        //findAny() zwraca Optional LOSOWEGO elementu streama (najczęściej pierwszy, ale nie ma na to gwarancji). Często łączony z warunkami filter()
        Employee employeeFindAny = EMPLOYEES_LIST.stream()
                .findAny().orElse(null);
        System.out.println(employeeFindAny);









        //ADDITIONAL STREAM EXAMPLES

        DoubleSummaryStatistics stats1 = EMPLOYEES_LIST.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        DoubleSummaryStatistics stats2 = EMPLOYEES_LIST.stream().mapToDouble(Employee::getSalary).summaryStatistics();//same result
        stats1.getCount();//3
        stats1.getSum();//600000.0
        stats1.getMax();//100000.0
        stats1.getMin();//300000.0
        stats1.getAverage();//200000.0


        List<Integer> intListSplit = Arrays.asList(2, 4, 5, 6, 8);
        Map<Boolean, List<Integer>> isEven = intListSplit.stream().collect(
                Collectors.partitioningBy(i -> i % 2 == 0));
        //{false=[5], true=[2, 4, 6, 8]}

        Map<Character, List<Employee>> groupByAlphabet = EMPLOYEES_LIST.stream().collect(
                Collectors.groupingBy(e -> e.getName().charAt(0)));
        //{B=[model.Employee@6d21714c], J=[model.Employee@108c4c35], M=[model.Employee@4ccabbaa]}


        Map<Character, List<Integer>> idGroupedByAlphabet = EMPLOYEES_LIST.stream().collect(
                Collectors.groupingBy(e -> e.getName().charAt(0),
                        Collectors.mapping(Employee::getId, Collectors.toList())));
        //{B=[2], J=[1], M=[3]}


        //Infinite StreamsInitializer
        //wykonuje operacje na elementach streama podczas gdy te są jeszcze generowane. Sprawdza się, gdy nie do końca wiemy ile elementów bedziemy potrzebować
        //Każdy infinite stream trzeba w jakiś sposób ograniczyć i zakończyć - np. używając limit().
        //Są 2 sposoby na stworzenie infinite streama - generate() i iterate().
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);

        //Iterate zawiera element seed(wartość początkową) i funkcję, na podstawie której generowane będą następne elementy
        Stream.iterate(5, integer -> integer + 5).limit(10).forEach(System.out::println);

        Stream<Integer> evenNumStream = Stream.iterate(2, i -> i * 2);
        List<Integer> collect = evenNumStream
                .limit(5)
                .collect(Collectors.toList());
        //[2, 4, 8, 16, 32]


        //Tworzenie Mapy z częstotliwością występowania elementów
        List<String> strings = new ArrayList<>(Arrays.asList("abc", "bcd", "abc", "fgd", "hdd", "bvn", "abc", "bcd"));
        Map<String, Integer> counterWithStrings = new HashMap<>();
        strings.forEach((singleString)->{
            Integer quantity = counterWithStrings.get(singleString);
            counterWithStrings.put(singleString, (quantity==null) ? 1 : quantity +1);
        });
        System.out.println(counterWithStrings);
        //{bcd=2, fgd=1, abc=3, hdd=1, bvn=1}

        //With streams
        Map<String, Long> counts = strings.stream().collect(Collectors.groupingBy(string -> string, Collectors.counting()));
        //{fgd=1, bcd=2, abc=3, hdd=1, bvn=1}
        int frequency = Collections.frequency(strings, "abc"); //3


        //Obliczanie najczęściej występującego elementu
        Stream.of(1, 3, 4, 3, 4, 3, 2, 3, 3, 3, 3, 3)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(System.out::println); //3=8

        List<String> strings2 = new ArrayList<>(Arrays.asList("abc", "bcd", "abc", "fgd", "hdd", "bvn", "abc", "bcd"));
        System.out.println(strings2.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey()); //abc



        Double highestSalary = EMPLOYEES_LIST.stream()
                .mapToDouble(Employee::getSalary)
                .max().orElseThrow(NoSuchElementException::new);
        //300000.0
        IntStream.of(1, 2, 3);
        IntStream.range(10, 20);//od 10 do 19

        Double avgSalary = EMPLOYEES_LIST.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElseThrow(NoSuchElementException::new);




        //toSet()
        Set<String> empNames = EMPLOYEES_LIST.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());

        //toMap()
        Map<Integer, String> empsToMap = EMPLOYEES_LIST.stream().collect(
                Collectors.toMap(Employee::getId, Employee::getName));
        //{1=Jeff Bezos, 2=Bill Gates, 3=Mark Zuckerberg}
        Map<Integer, Employee> employeesMapIdentity = EMPLOYEES_LIST.stream()
                .collect( Collectors.toMap(Employee::getId,
                        Function.identity()));

        //toCollection()
        Vector<String> empNamesVector = EMPLOYEES_LIST.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(Vector::new));
        //[Jeff Bezos, Bill Gates, Mark Zuckerberg]
        List<String> empNamesMap = EMPLOYEES_LIST.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(LinkedList::new));
        //[Jeff Bezos, Bill Gates, Mark Zuckerberg]



        //reducing() z groupingBy()
        Comparator<Employee> byNameLength = Comparator.comparing(employee -> employee.getName().length());
        Map<Character, Optional<Employee>> longestNameByAlphabet = EMPLOYEES_LIST.stream().collect(
                Collectors.groupingBy(e -> e.getName().charAt(0),
                Collectors.reducing(BinaryOperator.maxBy(byNameLength))));
        //{B=Optional[model.Employee@1cf4f579], J=Optional[model.Employee@18769467], M=Optional[model.Employee@46ee7fe8]};




        //Java 9 improvements
        //takeWhile() zwraca elementy streamu, DOPÓKI Predicate jest spełniony
        Stream.of(1,2,3,4,5,6)
                .takeWhile(i -> i < 4 )
                .forEach(System.out::println);//1,2,3
            //Stream.of(7,1,2,3,4,5,6) = Predicate od początku nie jest spełniony, więc nic nie zostanie zwrócone


        //dropWhile() zwraca elementy streamu, OD kiedy Predicate jest spełniony
        Stream.of(1,2,3,4,5)
                .dropWhile(x -> x < 4)
                .forEach(System.out::println);//4,5
        //Stream.of(1,2,3,4,5,1,4) = 4,5,1,4...
    }
}
