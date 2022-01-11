package pulson.java_generally.generics;


import pulson.java_generally.generics.fruits.Fruit;

//ograniczanie zestawu klas, którymi możemy parametryzować typ generyczny
public class Trio<T extends String, K, U extends Fruit> {
    private T first;
    private K second;
    private U third;

    public Trio(T first, K second, U third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public K getSecond() {
        return second;
    }

    public void setSecond(K second) {
        this.second = second;
    }

    public U getThird() {
        return third;
    }

    public void setThird(U third) {
        this.third = third;
    }
}
