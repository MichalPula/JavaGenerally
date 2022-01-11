package pulson.java_generally.codewars;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IncomingTasks {
    public static void main(String[] args) {
        //isPalindromeRecursion("xXxshrekxXx");
        //isStringPalindrome();
        //printLongestSubstringOfTheSameLetter();
        //sortListOfStringsInReverseAlphabeticOrder();
        //calculateFactorialRecursion(7);
        //calculateFactorial();
        //isPrime();
        //isPrimeOptimized();
        //findFrequencyOfWordsInList();
        //largestSumOfAnyTwoElements();
        //findSubstringWithRegex();
        //excelColumnCreator();
        //reverseString();
        //longestConsecutiveJoinedStrings(new String[]{"tree", "fooling", "trashy", "blue", "abcdef", "uvwxyz"}, 2);
        //persistence();
        //repeatedSubstringPattern();
        //countBits(1234);
    }


    public static void countBits(int n){
        System.out.println(Stream.of(Integer.toBinaryString(n).split("")).filter(s -> s.equals("1")).count());
    }

    public static void repeatedSubstringPattern() {
        String str = "aaaaaaaaa";
        boolean isBuiltFromSubstrings = false;
        int len = str.length();
        for(int i = len/2 ; i >= 1; i--) {
            if(len % i == 0) {
                int m = len/i;
                String substring = str.substring(0, i);
                StringBuilder sb = new StringBuilder();

                sb.append(substring.repeat(m));

                if(sb.toString().equals(str)) isBuiltFromSubstrings = true;
                break;
            }
        }
        System.out.println(isBuiltFromSubstrings);
    }



    public static void persistence() {
        long number = 999;

        int numberOfPasses = 0;
        int numberAfterMultiplication = 1;
        String[] arrayOfNumbers = String.valueOf(number).split("");

        while (arrayOfNumbers.length > 1) {
            for (int i = 0; i < arrayOfNumbers.length; i++) {
                numberAfterMultiplication *= Integer.parseInt(arrayOfNumbers[i]);
            }
            arrayOfNumbers = String.valueOf(numberAfterMultiplication).split("");
            numberAfterMultiplication = 1;
            numberOfPasses += 1;
        }

        System.out.println(numberOfPasses);
    }

    public static void longestConsecutiveJoinedStrings(String[] strings, int numberOfConsecutiveStrings) {
        String longestString = "";
        List<String> stringList = new ArrayList<>(Arrays.asList(strings));

        if (stringList.size() == 0 || numberOfConsecutiveStrings > stringList.size() || numberOfConsecutiveStrings <= 0) {
            System.out.println("");
        }

        for (int i = 0; i < strings.length; i++) {
            if (i + numberOfConsecutiveStrings <= stringList.size()) {
                String currentExaminedString = stringList.subList(i, i + numberOfConsecutiveStrings).stream().collect(Collectors.joining());
                if (currentExaminedString.length() > longestString.length()) {
                    longestString = currentExaminedString;
                }
            }
        }
        System.out.println(longestString);
    }

    private static void reverseString (){
        String string = "pulson";
        //StringBuilder sb = new StringBuilder(string).reverse();

        char[] result = string.toCharArray();
        int length = result.length;
        int halfLength = length / 2;

        for(int i = 0; i < halfLength; i++) {
            char temp = result[i];
            result[i] = result[length-1-i];
            result[length-1-i] = temp;
        }
        System.out.println(result);
    }


    private static void excelColumnCreator(){
        int numberOfColumns = 55;
        //25 liter od A do Z
        //A=65 Z=90
        //a=97 a=122
        char[] alphabet = new char[25];
        int index = 0;
        for (char ch = 65; ch < 90; ch++) {
            alphabet[index] = ch;
            index++;
        }
        //System.out.println(alphabet);//ABCDEFGHIJKLMNOPQRSTUVWXY

        List<String> results = new ArrayList<>();
        for (int i = 0; i < numberOfColumns; i++) {
            if(numberOfColumns > alphabet.length){
                int numberOfRepeatedCharacters = numberOfColumns / alphabet.length; //2 dla 55
                //............................................................................
                System.out.println(numberOfRepeatedCharacters);
            } else {
                results.add(String.valueOf(alphabet[i]));
            }
        }

        System.out.println(results);
    }

    private static void findSubstringWithRegex() {
        String string = "lkjefhawoehfaoidgufhbofdjinsfdoahgberfo iksljdhfshjkMCD.1234XDfbisladfhjasopdfuh pofjnspinfjsdf";
        //find() próbuje szukać substring, który matchuje pattern
        //matches() zwraca true tylko, jeśli cały string matchuje pattern

        System.out.println(Pattern.compile("MCD.1234").matcher(string).find());
        System.out.println(Pattern.compile("1{5}").matcher(string).find());
        System.out.println(string.contains("MCD.1234"));
        //D=litery d=cyfry
        //() znaki sprawdzane są razem jako grupa!!! (fbi) - sprawdzi ten konkretny substring
        //[] set znaków - matchuje jakikolwiek znak w środku, działa z zakresami a-z. [fbi] - sprawdzi którykolwiek znak
        System.out.println(Pattern.compile("[A-Z]{3}[.][\\d]{4}(AK|XD)(fbi)").matcher(string).find());
                                   //3 litery uppercase + . + 4 cyfry
    }


    private static void largestSumOfAnyTwoElements() {
        int[] array = new int[] {13, 2, 21, 36, 4, 9};

        int j = 0;
        int max = array.length == 1 ? array[0] + array[1] : array[0];

        for (int i = 0; i < array.length; i++) {
            int sum = array[j] + array[i];
            if (sum > max) {
                max = sum;
                if (array[j] < array[i]) {
                    j = i;
                }
            }
        }
        System.out.println(max);
    }


    private static void findFrequencyOfWordsInList() {
        List<String> strings = new ArrayList<>(Arrays.asList("aaa", "bbb", "ggg",
                "hhh", "lll", "ccc", "ooo", "yyy", "aaa", "bbb",
                "eee", "ccc", "aaa")
        );
        Map<String, Long> counts = strings.stream().collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        System.out.println(counts);


        //Optional<Map.Entry<String, Long>> maxentry1 = counts.entrySet().stream().max((o1, o2) -> o1.getValue().compareTo(o2.getValue()));
        //Optional<Map.Entry<String, Long>> maxEntry2 = counts.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue));
        String mostFrequentString = strings.stream().collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();

        int frequency = Collections.frequency(strings, mostFrequentString);
        System.out.println(frequency);
    }

    private static void isPrimeOptimized() {
        long startTime = System.currentTimeMillis();

        int number = 2147483647;
        int sqrt = (int) Math.sqrt(number);
        System.out.println(sqrt);

        boolean isPrime = true;

        for (int i = 2; i <= sqrt + 1; i++) {
            if(number % i == 0){
                isPrime = false;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        System.out.println(isPrime);
    }

    private static void isPrime() {
        long startTime = System.currentTimeMillis();

        int number = 2147483647;
        boolean isPrime = true;

        for (int i = 2; i <= number/2; i++) {
            if(number % i == 0){
                isPrime = false;
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        System.out.println(isPrime);
    }


    private static void calculateFactorial(){
        int number = 7;
        int factorial = 1;

        for(int i = 1; i <= number; i++) {
            factorial = factorial * i;
        }
        System.out.println(factorial);
    }
    private static Integer calculateFactorialRecursion(int number){
        if(number == 0){
            return 1;
        } else {
            return number * calculateFactorialRecursion(number - 1);
        }
    }

    private static void sortListOfStringsInReverseAlphabeticOrder() {
        List<String> strings = new ArrayList<>(Arrays.asList("aaa", "bbb", "ggg",
                "hhh", "lll", "ccc", "ooo", "yyy", "aaa", "bbb",
                "eee", "ccc", "aaa")
        );
        List<String> reverseList = strings.stream()
                .sorted((s1, s2) -> s2.compareToIgnoreCase(s1)).collect(Collectors.toList());
        System.out.println(reverseList);
    }

    private static void printLongestSubstringOfTheSameLetter() {
        String string = "aaaabbbxxxxxffffkkkoooppppabffkk";

        String longestSubstring = "";
        int counter = 1;
        char letter = 0;
        int maxCounter = 1;

        for(int i = 0; i < string.length() - 1; i++){
            if(string.charAt(i) == string.charAt(i + 1)) {
               counter++;
            }else {
                if(counter >= maxCounter){
                    maxCounter = counter;
                    longestSubstring = String.valueOf(string.charAt(i)).repeat(maxCounter);
                }
                counter = 1;
            }
        }
        System.out.println(longestSubstring);
    }



    private static void isStringPalindrome() {
        String original = "racecar";
        String reversed = "";

        //String strReverse = new StringBuffer(original).reverse().toString();

        for(int i = original.length() - 1; i >= 0; i--){
            reversed = reversed + original.charAt(i);
        }

        System.out.println("Is string palindrome? " + original.equals(reversed));
    }
    public static boolean isPalindromeRecursion(String str) {
        if(str.length() == 0 || str.length() == 1){
            System.out.println(true);
            return true;
        }

        if(str.charAt(0) == str.charAt(str.length() - 1)){
            return isPalindromeRecursion(str.substring(1, str.length() - 1));
        } else {
            System.out.println(false);
            return false;
        }
    }
}
