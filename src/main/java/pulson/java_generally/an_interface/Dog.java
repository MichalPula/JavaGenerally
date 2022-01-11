package pulson.java_generally.an_interface;

public class Dog implements Huggable {

    private final Integer lungsCapacity = 3;

    @Override
    public Integer getLungsCapacity() {
        return this.lungsCapacity;
    }

    @Override
    public void inhale() {
        System.out.println("Inhale like a dog");
    }

    @Override
    public void hug() {
        System.out.println("After hugging, the dog is in heaven <3");
    }

    public void bark() {
        System.out.println("Woof woof!");
    }
}
