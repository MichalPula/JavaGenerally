package pulson.java_generally.generics;

import pulson.java_generally.generics.fruits.Fruit;

public class GenericClass<T extends Fruit> {// & MyInterface & MyInterface2 & MyInterface3 ograniczenie wielokrotne klasa & interfejs & interfejs...
    private T type;

    public GenericClass(T type) {
        this.type = type;
    }

    public GenericClass() {

    }
    public T getType() {
        return type;
    }

    public void setType(T type) {
        this.type = type;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GenericClass{");
        sb.append("type=").append(type);
        sb.append('}');
        return sb.toString();
    }
}
