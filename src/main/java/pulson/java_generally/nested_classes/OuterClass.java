package pulson.java_generally.nested_classes;

public class OuterClass {
    static int outer_x = 10;
    int outer_y = 20;
    private static int outer_private = 30;

    static class StaticNestedClass {
        //Z wnętrza można odwoływać się TYLKO do pól statycznych klasy zewnętrznej
        //Statyczne elementy mogą być deklarowane
        public static int staticNestedField = 40;
        public int nestedField = 50;

        void display() {
            System.out.println("outer_x = " + outer_x); //ok
            System.out.println("outer_private = " + outer_private); //ok
            //System.out.println(outer_y);//Non-static field 'outer_y' cannot be referenced from a static context
        }
    }

    class InnerClass {
        //Z wnętrza można odwoływać się do pól klasy zewnętrznej (w tym do statycznych)
        //Statyczne elementy NIE mogą być deklarowane

        //private static int xd = 40;//Inner classes cannot have static declarations
        public int innerField = 60;

       void  display() {
            System.out.println("outer_x = " + outer_x);
            System.out.println("outer_y = " + outer_y);
            System.out.println("outer_private = " + outer_private);
       }
    }
}
