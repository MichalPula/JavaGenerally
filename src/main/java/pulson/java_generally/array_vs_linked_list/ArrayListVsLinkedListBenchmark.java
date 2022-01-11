package pulson.java_generally.array_vs_linked_list;

import org.openjdk.jmh.annotations.*;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
public class ArrayListVsLinkedListBenchmark {
    public static void main(String[] args) throws IOException {

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        Map<String, Integer> xd = new LinkedHashMap<>();

        // ArrayList add
        long startTime = System.nanoTime();

        for (int i = 0; i < 100000; i++) {
            arrayList.add(i);
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("ArrayList add:  " + duration);

        // LinkedList add
        startTime = System.nanoTime();

        for (int i = 0; i < 100000; i++) {
            linkedList.add(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("LinkedList add: " + duration);

        // ArrayList get
        startTime = System.nanoTime();

        for (int i = 0; i < 10000; i++) {
            arrayList.get(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("ArrayList get:  " + duration);

        // LinkedList get
        startTime = System.nanoTime();

        for (int i = 0; i < 10000; i++) {
            linkedList.get(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("LinkedList get: " + duration);



        // ArrayList remove
        startTime = System.nanoTime();

        for (int i = 1; i <= 9999; i++) {
            arrayList.remove(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("ArrayList remove:  " + duration);



        // LinkedList remove
        startTime = System.nanoTime();

        for (int i = 9999; i >=0; i--) {
            linkedList.remove(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("LinkedList remove: " + duration);


        org.openjdk.jmh.Main.main(args);
    }




    private static final int MAX = 500000;
    private String[] strings = maxArray();
    private String[] maxArray() {
        String[] strings = new String[MAX];
        Boolean result = Boolean.TRUE;
        for (int i = 0; i < MAX; i++) {
            strings[i] = getString(result, i);
            result = !result;
        }
        return strings;
    }
    private String getString(Boolean result, int i) {
        return String.valueOf(result) + i + String.valueOf(!result);
    }


    @Benchmark
    @Fork(value = 1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 10)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void ArrayListAdd() {
        List<String> arrayList = new ArrayList<>(100000);
        for (String string : strings) {
            arrayList.add(string);
        }
    }


    @Benchmark
    @Fork(value = 1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 10)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void LinkedListAdd() {
        List<String> linkedList = new LinkedList<String>();
        for (String string : strings) {
            linkedList.add(string);
        }
    }
}
