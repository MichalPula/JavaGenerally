package pulson.java_generally.nested_classes;

public class NestedClassesInitializer {
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        //OuterClass.outer_x
        //outerClass.outer_y

        OuterClass.InnerClass innerClass = outerClass.new InnerClass(); //Do stworzenia obiektu potrzebuje utworzonego wcześniej obiektu klasy zewnętrznej
        //innerClass.innerField

        OuterClass.StaticNestedClass staticNestedClass = new OuterClass.StaticNestedClass();//Instancja może istnieć bez obiektu klasy zewnętrznej
        //staticNestedClass.nestedField
        //OuterClass.StaticNestedClass.staticNestedField
    }
}
