package pulson.java_generally.an_interface;

public class Main {
    public static void main(String[] args) {
        //CanShoot --> It shoots (at) something
        //CanFly --> It flies
        //CanChange --> It changes
        //
        //Action is performed on the object:
        //Readable --> You can read it
        //Writable --> You can write (to) it
        //Printable --> You can print it

        Dog dog = new Dog();//class Dog implements Huggable
        dog.bark();
        dog.inhale();
        dog.getLungsCapacity();
        dog.hug();

        Huggable huggable = new Dog();//interface Huggable extends CanBreathe
        huggable.inhale();
        huggable.getLungsCapacity();
        huggable.hug();

        CanBreathe canBreathe = new Dog();//interface CanBreathe
        canBreathe.inhale();
        canBreathe.getLungsCapacity();
    }
}
