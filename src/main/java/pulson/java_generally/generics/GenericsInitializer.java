package pulson.java_generally.generics;

import pulson.java_generally.generics.fruits.Apple;
import pulson.java_generally.generics.fruits.Fruit;
import pulson.java_generally.generics.fruits.Orange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericsInitializer {
    public static void main(String[] args) {

    }

    private static void genericClasses() {
        GenericClass<Orange> orangeBox = new GenericClass<>(new Orange(400));
        GenericClass<Apple> appleBox = new GenericClass<>(new Apple(250));
        Orange orange = orangeBox.getType();

        GenericClass<Apple> appleBox2 = new GenericClass<>();
        appleBox2.setType(new Apple(300));
        //appleBox2.setFruitType(new Orange(300)); //Required: Apple Provided: Orange
    }

    private static void upperBound() {
        List<Fruit> fruits = new ArrayList<>(Arrays.asList(new Fruit(200)));
        List<Orange> oranges = new ArrayList<>(Arrays.asList(new Orange(200)));
        List<Apple> apples = new ArrayList<>(Arrays.asList(new Apple(200)));
        List<String> strings = new ArrayList<>(Arrays.asList(""));

        extendsUpperBound(oranges);
        extendsUpperBound(fruits);
        extendsUpperBound(apples);
        //extendsUpperBound(strings);//Required type: List<? extends Fruit> Provided: List<String>
        //String nie jest podklasą Fruit
    }
    private static void extendsUpperBound(List<? extends Fruit> box) {
        //Metoda przyjmuje tylko obiekty klasy Fruit lub jej podklas
    }
    private static <T extends Fruit> void extendsUpperBound(T t) {
        //Metoda przyjmuje tylko obiekty klasy Fruit lub jej podklas
        System.out.println(t);
    } //PRZY OGRANICZANIU PRZYJMOWANYCH ARGUMENTÓW W METODACH NIE MOŻNA UŻYWAĆ LOWER BOUND Z SUPER!


    private static void lowerBound() {
        List<Fruit> fruits = new ArrayList<>(Arrays.asList(new Fruit(200)));
        List<Orange> oranges = new ArrayList<>(Arrays.asList(new Orange(200)));
        List<Apple> apples = new ArrayList<>(Arrays.asList(new Apple(200)));
        List<String> strings = new ArrayList<>(Arrays.asList(""));

        superLowerBound(fruits);
        superLowerBound(apples);
        //superLowerBound(oranges);//Required type: List<? super Apple> Provided: List<Orange>
        //Orange nie jest nadklasą Apple


        List<Object> objects = new ArrayList<>(Arrays.asList("abc", 2));
        List<Integer> integers = new ArrayList<>(Arrays.asList(55, 76));
        superLowerBound2(objects);
        //superLowerBound2(integers);
    }
    private static void superLowerBound(List<? super Apple> box) {
        //Metoda przyjmuje tylko obiekty klasy Apple lub jej nadklas
    }
    private static void superLowerBound2(List<? super Object> box) {
    }


}
