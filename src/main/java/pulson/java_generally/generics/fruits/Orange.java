package pulson.java_generally.generics.fruits;

public class Orange extends Fruit {

    private int weight;

    public Orange(int weight) {
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
        final StringBuilder sb = new StringBuilder("Orange{");
        sb.append("weight=").append(weight);
        sb.append('}');
        return sb.toString();
    }
}
