package pulson.java_generally.stream_api;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Fork(value = 2, jvmArgs = {"-Xms2G", "-Xmx2G"})
@Warmup(iterations = 1)
@Measurement(iterations = 5)
public class SequentialVsParallelStreamBenchmark {

    List<Integer> arrayListData;
    List<Integer> linkedListData;

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder().include(SequentialVsParallelStreamBenchmark.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(options).run();
    }

    @Setup
    public void setup(){
        arrayListData = new ArrayList<>();
        linkedListData = new LinkedList<>();

        IntStream.rangeClosed(1, 1_000_000).forEach(i -> {
            arrayListData.add(i);
            linkedListData.add(i);
        });
    }


    @Benchmark
    public void linkedListParallelReduce(){
        linkedListData.parallelStream().reduce(0, Integer::sum);
    }
    @Benchmark
    public void linkedListSequentialReduce(){
        linkedListData.stream().reduce(0, Integer::sum);
    }

    @Benchmark
    public void arrayListParallelReduce(){
        arrayListData.parallelStream().reduce(0, Integer::sum);
    }
    @Benchmark
    public void arrayListSequentialReduce(){
        arrayListData.stream().reduce(0, Integer::sum);
    }
    @Benchmark
    public void arrayListParallelCollect(){
        arrayListData.parallelStream().collect(Collectors.toSet());
    }
    @Benchmark
    public void arrayListSequentialCollect(){
        arrayListData.stream().collect(Collectors.toSet());
    }
}
