package pulson.java_generally.generics;

public class MyClass implements MyInterface2<String, Integer>{

    @Override
    public String doSomeOperation(String s) {
        return "Operation";
    }
    @Override
    public Integer doAnotherOperation(Integer integer) {
        return 5;
    }
}
