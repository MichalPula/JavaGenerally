package pulson.java_generally.generics.fruits;

public class Apple extends Fruit {

    private int weight;

    public Apple(int weight) {
        super(weight);
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Apple{");
        sb.append("weight=").append(weight);
        sb.append('}');
        return sb.toString();
    }
}
