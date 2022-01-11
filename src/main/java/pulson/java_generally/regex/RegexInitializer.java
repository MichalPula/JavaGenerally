package pulson.java_generally.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexInitializer {
    public static void main(String[] args) {
        //Regex - regular expression - wzór który opisuje grupę łańcuchów znaków. Lańcuch znaków pasuje do wzorca jeśli dane wyrażenie regularne go opisuje.

        //Pattern object to skompilowana reprezentacja regexa. Nie ma publicznych konstruktorów (nie można użyć new Pattern) dlatego
        //trzeba wywołać statyczną metodę compile z naszym regexem jako pierwszym argumentem, która zwróci pattern.
        String name = "MichaeL";
        Pattern pattern1 = Pattern.compile("[A-z]{7}"); //true
        Pattern pattern2 = Pattern.compile("\\D{7}"); //true
        //Matcher interpretuje pattern i przeprowadza operacje na podanym inpucie
        Matcher matcher1 = pattern1.matcher(name);
        Matcher matcher2 = pattern2.matcher(name);
        //System.out.println(matcher1.find()); //tru
        //System.out.println(matcher2.find()); //true


        //zakresy i grupy
        String car = "Tesla123FF";
        Pattern patternCar1 = Pattern.compile("^Tesla"); //^ sprawdza początek linii
        Pattern patternCar2 = Pattern.compile("3F$"); //$ sprawdza koniec linii
        Pattern patternCar3 = Pattern.compile(".esla"); //. zastępuje jakokolwiek znak poza nową linią
        Pattern patternCar4 = Pattern.compile("[abc]"); //[abc] sprawdza jakikolwiek znak podany w środku nawiasów
        Pattern patternCar5 = Pattern.compile("[Tbz][egh]"); //[Tbz][egh] sprawdza T,b lub z i następujące po nim mogą być tylko e,g i h
        Pattern patternCar6 = Pattern.compile("[^klcbn]"); //[^klcbn] sprawdza czy podane znaki NIE występują, neguje
        Pattern patternCar7 = Pattern.compile("[3-9]"); //[3-9] sprawdza czy występuje cyfra w podanym zakresie
        Pattern patternCar8 = Pattern.compile("[s-z]"); //[s-z] sprawdza czy występuje litera w podanym zakresie
        Pattern patternCar9 = Pattern.compile("[5-6y-z]"); //[D-g4-5] sprawdza czy występuje duża lub mała litera od D do g i cyfra od 3 do 5 BEZ g4
        Pattern patternCar10 = Pattern.compile("AK|3F"); // AK|3F sprawdza czy występuje AK lub 3F ()
        Pattern patternCar11 = Pattern.compile("la12"); // la12 sprawdza konkretnie ten podany ciąg znaków


        Pattern patternCar13a = Pattern.compile("2(?!F)"); //true- 2(?!F) zwróci true ,gdy bezpośrednio po znaku '2' NIE będzie znaku 'F' (zwraca fałsz jeśli po '2' jest 'F')
        Pattern patternCar13b = Pattern.compile("(?i)3(?!f)"); //false- (?i) formułka na początku regexu sprawia, że jest case insensitive, nie ma znaczenia wielkość liter (bez tego sprawdzi tylko małe 'f')
        Pattern patternCar13c = Pattern.compile("2(?!f)", Pattern.CASE_INSENSITIVE); //(?i) formułka na początku regexu sprawia, że jest case insensitive (bez tego sprawdzi tylko małe 'f')
        //(?s) for "single line mode" sprawia że kropka poza każdym znakiem może zastąpić też nową linę
        //(?m) for "multi-line mode" makes the caret and dollar match at the start and end of each line in the subject string.

        //meta characters - mają predeifiniowane znaczenie i ułatwia używanie niektórych patternów
        Pattern patternCar13l = Pattern.compile("\\d"); // \\d szuka jakiejkolwiek cyfry, inaczej [0-9]
        Pattern patternCar14 = Pattern.compile("\\D"); // \\D szuka jakiegokolwiek znaku, który nie jest cyfrą, inaczej [^0-9]
        Pattern patternCar15 = Pattern.compile("\\s"); // \\s szuka spacji, inaczej [ \t\n\x0b\r\f]
        Pattern patternCar16 = Pattern.compile("\\S"); // \\S szuka jakiegokolwiek znaku, który nie jest spacją
        Pattern patternCar17 = Pattern.compile("\\w"); // \\w szuka słowa bez spacji, inaczej [a-zA-Z_0-9]
        Pattern patternCar18 = Pattern.compile("\\W"); // \\W szuka ciągu znaków, który nie jest słowem np. ma dodany nawias, inaczej [^\w]
        Pattern patternCar19 = Pattern.compile("\\S+"); // \\S+ szuka znaków, które nie są spacją
        Pattern patternCar20 = Pattern.compile("\\b"); // \\b szuka słowa ciągu znaków [a-zA-Z0-9_] wszystkie litery i cyfry razem z innymi znakami

        //quantifiers - kwantyfikatory - definiują jak często występuje dany element
        Pattern patternCar21 = Pattern.compile("b*"); // * (zawsze true?) szuka ciągu znaków które występują zero lub więcej razy (każdy znak osobno), inaczej {0,}
        Pattern patternCar22 = Pattern.compile("sla1+"); // + szuka ciągu znaków które występują raz lub więcej razy, inaczej {1,} po dopisaniu FF+z+ jeśli nie znajdzie obu z rzędu da false
        Pattern patternCar23 = Pattern.compile("F?"); // F? (zawsze true?) szuka ciągu znaków występujących zero lub raz, nawet jeśli jest więcej niż 1 raz to ? zatrzymuje dalsze przeszukiwanie po jednym matchu
        Pattern patternCar24 = Pattern.compile("\\d{3}"); // \\d{3} szuka trzech cyfr pod rząd, .{10} to ciąg dowolnych znaków o długości 10
        Pattern patternCar25 = Pattern.compile("\\d{3,5}"); // \d{3,5} szuka ciągu trzech, czterech lub pięciu cyfr

        System.out.println(pattern1.matcher(car).find());


        System.out.println(Pattern.compile("\\d{4}").matcher("3456F").find()); //true
        System.out.println(Pattern.compile("\\d{4}").matcher("3456F").matches()); //false
        //find() vs matches()
        //find() próbuje szukać substring, który matchuje pattern
        //matches() zwraca true tylko jeśli cały string matchuje pattern


        //Grupowanie patternów odbywa się dzięki ().
        //((znajdź spację)(przed kropką lub przecinkiem)
        String groupPattern = "(\\s)([.,])";
        String testing = "Testing .Is it gonna work ,i dunno";

        String testingReplacedSpaces = testing.replaceAll(groupPattern, "|");
        //testingReplacedSpaces = Testing|Is it gonna work|i dunno

        testing = testing.replaceAll("[\\s][.]", ". ");// zamieni spacja. na .spacja
        testing = testing.replaceAll("[\\s][,]", ", ");// zamieni spacja, na ,spacja
        //testing = Testing. Is it gonna work, i dunno
    }
}
