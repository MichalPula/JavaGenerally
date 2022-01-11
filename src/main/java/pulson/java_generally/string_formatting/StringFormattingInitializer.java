package pulson.java_generally.string_formatting;

import java.util.Locale;

public class StringFormattingInitializer {
    public static void main(String[] args) {

        //% [indeks_argumentu$][flagi][szerokość][.precyzja] typ_argumentu

        //Typ argumentu 's'  'd'  'f'...
        String str1 = String.format("I just checked the weather on my %s", "phone");
        System.out.println(str1); //I just checked the weather on my phone

        String str2 = String.format("Its suppose to get up to %d degrees today", 71);
        System.out.println(str2); //Its suppose to get up to 71 degrees today

        String str3 = String.format("Float rounded to default 6 decimal places = %f", 0.0123456789);
        System.out.println(str3); //Float rounded to default 6 decimal places = 0.012346

        String str4 = String.format("The correct answer is %b", true);
        System.out.println(str4); //The correct answer is true

        String str5= String.format("The correct answer is %c", 'c');
        System.out.println(str5); //The correct answer is c

        //Indeks argumentu '1$'  '2$'  '3$'...
        String str6 = String.format("Hello %2$s, welcome to %1$s!", "the gym", "brahz");
        System.out.println(str6); //Hello brahz, welcome to the gym !

        //Precyzja '.'
        double x = 1.1234567890123;
        System.out.format("%.10f   %.3f   %f   %n", x, x, x);
        //1.1234567890   1.123   1.123457

        //Szerokość 10/ 5...
        //Flagi '-'   '+'   '0'  '('  ','
        String str7 = String.format("[%10s]  [%3s]", "test", "test");
        System.out.println(str7); //[      test]   test
        System.out.printf("|%20d|  %n", 93); //|                  93| szerokość 20 znaków
        System.out.printf("|%-20d|  %n", 93); //|93                  | wyrównanie do lewej strony
        System.out.printf("|%+20d|  %n", 93); //|                 +93| liczba zawsze zawiera znak + -
        System.out.printf("|%020d|  %n", 93); //|00000000000000000093| uzupełnienie zerami do żądanej szerokości
        System.out.printf("|%(20d|  %n", -93); //|                (93)| pomija minus i drukuje liczbę w nawiasie

        double someNumber = 12345.12;
        System.out.format(Locale.US, "%,.2f   %n", someNumber);//12,345.12
        System.out.format(Locale.GERMAN, "%,.2f   %n", someNumber);//12.345,12
        System.out.format(Locale.forLanguageTag("PL"), "%,.2f   %n", someNumber);//12 345,12


        //% [indeks_argumentu$][flagi][szerokość][.precyzja] typ_argumentu
        //%3$(,08.3f
        //%3$ - trzeci argument
        //( - liczba ujemna otoczona nawiasami
        //, - separator grup liczb
        //0 - uzupełnienie reszty miejsc zerami
        //8 - minimalna wyświetlana długość to 8 znaków
        //.3 wyświetlenie trzech miejsc po przecinku
        //f konwersja liczby zmiennoprzecinkowej
    }
}
