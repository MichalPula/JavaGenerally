package pulson.java_generally.readers_writers;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadersAndWriters {

    private final static List<String> strings = new ArrayList<>(Stream.of("aaa", "bbb", "ggg",
            "hhh", "lll", "ccc", "ooo", "yyy", "aaa", "bbb",
            "eee", "ccc", "aaa").map(s -> s.concat("\n")).collect(Collectors.toList()));
    private static final String TXT_FILE_PATH = "src/main/resources/read_write.txt";

    public static void main(String[] args) {

        writeWithBufferedWriter();
        readWithBufferedReader();
    }

    private static void readWithBufferedReader() {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(TXT_FILE_PATH))) {
            List<String> strings = new ArrayList<>();

            strings = bufferedReader.lines().collect(Collectors.toList());
            System.out.println(strings);

        } catch(IOException e){System.out.println(e);}
    }

    private static void writeWithBufferedWriter() {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(TXT_FILE_PATH, false))) {
            strings.forEach(s -> {
                try {
                    bufferedWriter.write(s);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch(IOException e){System.out.println(e);}
    }
}
