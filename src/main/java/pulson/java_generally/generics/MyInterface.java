package pulson.java_generally.generics;

public interface MyInterface {

    Integer myInt = 25;

    default void methodInMyInterface(String message){
        System.out.println("This method is in MyInterface " + message);
    };
}
