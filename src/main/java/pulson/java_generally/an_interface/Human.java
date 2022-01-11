package pulson.java_generally.an_interface;

public class Human implements Huggable {
    private final Integer lungsCapacity = 5;

    @Override
    public Integer getLungsCapacity() {
        return this.lungsCapacity;
    }

    @Override
    public void inhale() {
        System.out.println("Inhale like a human");
    }

    @Override
    public void hug() {
        System.out.println("Human hugs you back <3");
    }

    public void speak() {
        System.out.println("Hi!");
    }
}
