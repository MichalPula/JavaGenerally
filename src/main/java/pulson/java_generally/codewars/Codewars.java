package pulson.java_generally.codewars;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Codewars {
    public static void main(String[] args) throws IOException{

        //longestSubstringFromString("aabddfghhhooooooooaaaaayyyyffff");
        //frequencyOfWordsInList(new ArrayList<>(Arrays.asList("cat", "cat", "phone", "car", "dog", "phone", "phone", "chair")));
        //mostFrequentWordInArray(new String[]{"cat", "cat", "phone", "car", "dog", "phone", "phone", "chair"});
        //findFactorialV1(4);
        //findFactorialV2(4);
        //calculateStatistics("01|15|59, 1|47|6, 01|17|20, 1|32|34, 2|3|17");
        //printNPrimeNumbers(15);
        //whichStringsAreInBothArrays(new String[]{ "arp", "live", "strong"}, new String[] { "lively", "alive", "harp", "sharp", "armstrong" });
        //whichStringsAreInBothArraysStream(new String[]{ "arp", "live", "strong"}, new String[] { "lively", "alive", "harp", "sharp", "armstrong" });
        //bubbleSort(new int[]{5, 8, 1, 6, 9, 2});
       // matrixMultiplication(new int[][]{{1,2,3,4}, {5,6,7,8}, {9,8,7,6}}, //3x4
                //new int[][]{{4,3,2,1,2}, {3,4,5,6,7}, {8,9,8,7,6}, {5,4,3,2,1}});
    }


    public static void matrixMultiplication(int[][] arrayA, int[][] arrayB){
        int rowsA = arrayA.length;
        int columnsB = arrayB[0].length;

        int[][] result = new int[rowsA][columnsB];

        for(int i = 0; i < arrayA.length; i++){
            for(int j = 0; j < arrayB[0].length; j++){
                int temp = 0;
                for(int z = 0; z < arrayB.length; z++){
                    temp += (arrayA[i][z] * arrayB[z][j]);
                }
                result[i][j] = temp;
            }
        }
        System.out.println(Arrays.deepToString(result));
    }

    public static void quickSort(int[] arr, int start, int end){
        int partition = partition(arr, start, end);

        if(partition-1>start) {
            quickSort(arr, start, partition - 1);
        }
        if(partition+1<end) {
            quickSort(arr, partition + 1, end);
        }

        System.out.println(Arrays.toString(arr));
    }
    public static int partition(int[] arr, int start, int end){
        int pivot = arr[end];

        for(int i=start; i<end; i++){
            if(arr[i]<pivot){
                int temp= arr[start];
                arr[start]=arr[i];
                arr[i]=temp;
                start++;
            }
        }

        int temp = arr[start];
        arr[start] = pivot;
        arr[end] = temp;

        return start;
    }

    public static void bubbleSort(int[] array) {
//        int [] myIntArray = IntStream.range(0, 100).toArray(); // From 0 to 99
//        int [] myIntArray = IntStream.rangeClosed(0, 100).toArray(); // From 0 to 100
//        int [] myIntArray = IntStream.of(12,25,36,85,28,96,47).toArray(); // The order is preserved
//        int [] myIntArray = IntStream.of(12,25,36,85,28,96,47).sorted().toArray(); // Sort

        int temp = 0;
        for(int i = 0; i < array.length - 1; i++){
            for(int j = 0; j < array.length - 1 - i; j++){//-i to ilość liczb, które już przesunęliśmy na koniec, czyli są największe i już do nich nie wracamy
                                                            //Zostały umiejscowione na końcu i zaczynamy od początku
                if(array[j] > array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));

    }



    private static void whichStringsAreInBothArraysStream(String[] firstArray, String[] secondArray) {
        String[] result = Arrays.stream(firstArray)
                .filter(string -> Arrays.stream(secondArray).anyMatch(s -> s.contains(string)))
                .distinct()
                .sorted()
                .toArray(String[]::new);
        System.out.println(Arrays.toString(result));
    }

    private static void whichStringsAreInBothArrays(String[] firstArray, String[] secondArray) {
        String[] r = new String[firstArray.length];
        int wordCounter = 0;

        for(int i = 0; i <= firstArray.length -1; i ++){
            String currentString = firstArray[i];
            for(int j = 0; j <= secondArray.length -1; j ++){
                String searchedString = secondArray[j];
                if(searchedString.contains(currentString)){
                    if(Arrays.asList(r).contains(currentString)){
                        break;
                    }else {
                        r[wordCounter] = currentString;
                        wordCounter++;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(r));
    }

    public static void printNPrimeNumbers(Integer n) {
        List<Integer> primeNumbers = new ArrayList<>();

        for(int i = 2; i < Integer.MAX_VALUE; i++){
            if(isPrime(i)) {
                primeNumbers.add(i);
            }

            if(primeNumbers.size() == n){
                break;
            }
        }
        System.out.println(primeNumbers);
    }
    private static boolean isPrime(Integer number) {
        boolean isPrime = false;
        for(int i = 2; i <= number - 1; i++){
            if(number % i == 0) {
                isPrime = false;
                break;
            } else {
                isPrime = true;
            }
        }
        return isPrime;
    }

    public static void calculateStatistics(String input) {
        String[] splittedRunners = input.split(", ");

        String[][] splittedHMS = new String[splittedRunners.length][3];

        for(int i = 0; i < splittedRunners.length; i++) {
            String singleTrio = splittedRunners[i];
            String[] splittedTrio = singleTrio.split("\\|");
            splittedHMS[i] = splittedTrio;
        }

        System.out.println(Arrays.deepToString(splittedHMS));

        List<Integer> calculatedSeconds = new ArrayList<>();
        for(int i = 0; i < splittedRunners.length; i++) {
            int seconds = 0;
            for(int j = 0; j < splittedHMS[0].length; j++){
                String currentValue = splittedHMS[i][j];
                if(currentValue.matches("^0\\d")) {
                    currentValue = currentValue.replace("0", "");
                }
                switch (j) {
                    case 0 -> seconds += Integer.parseInt(currentValue) * 3600;
                    case 1 -> seconds += Integer.parseInt(currentValue) * 60;
                    case 2 -> seconds += Integer.parseInt(currentValue);
                }
            }
            calculatedSeconds.add(seconds);
        }
    }

    public static void findFactorialV2(Integer integer) {
        Integer factorial = 1;

        for(int i = 2; i <= integer; i++) {
            factorial = factorial * i;
        }
        System.out.println(factorial);
    }
    public static void findFactorialV1(Integer integer) {
        Integer factorial = 1;
//         while (integer >= 1) {
//             factorial = factorial * integer;
//             integer --;
//         }
//        System.out.println(factorial);
        for(int i = integer; i >= 1; i--) {
            factorial = factorial * i;
        }
        System.out.println(factorial);
    }

    public static void mostFrequentWordInArray(String[] wordsArray) {
        int mostFrequentWordOccurances = 0;
        String mostFrequentWord = "";

        int wordCounter = 1;
        for(int i = 0; i < wordsArray.length - 1; i++) {
            String currentWord = wordsArray[i];
            if(currentWord.equals(mostFrequentWord)) {
                continue;
            }
            for(int j = i + 1; j <= wordsArray.length - 1; j++) {
                String nextWord = wordsArray[j];
                System.out.println(nextWord);
                if (currentWord.equals(nextWord)) {
                    wordCounter ++;
                }
            }

            if(wordCounter > mostFrequentWordOccurances) {
                mostFrequentWord = currentWord;
                mostFrequentWordOccurances = wordCounter;
            }
            wordCounter = 1;
        }
        System.out.println(mostFrequentWord);
        System.out.println(mostFrequentWordOccurances);

    }

    public static void frequencyOfWordsInList(List<String> wordsList) {
        Map<String, Long> counter = wordsList.stream().collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        System.out.println(counter);
    }

    public static void longestSubstringFromString(String input) {
        String longestString = "";
        int numberOfCharsInLongestString = 0;

        char[] charArray = input.toCharArray();


        int charCounter = 1;
        for(int i = 0; i < charArray.length - 1; i++) {

            char currentChar = charArray[i];
            if (currentChar == charArray[i+1]) {
                charCounter  ++;
            } else {
                charCounter = 1;
            }

            if(charCounter > numberOfCharsInLongestString) {
                longestString = String.valueOf(currentChar).repeat(charCounter);
                numberOfCharsInLongestString = charCounter;
            }
        }
        System.out.println(longestString);
        System.out.println(numberOfCharsInLongestString);
    }
}
