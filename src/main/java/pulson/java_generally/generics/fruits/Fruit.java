package pulson.java_generally.generics.fruits;

import java.util.Objects;

public class Fruit implements Comparable<Fruit>{

    private int weight;

    public Fruit(int weight) {
        this.weight = weight;
    }

    public Fruit(){ }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruit fruit = (Fruit) o;
        return weight == fruit.weight;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Fruit{");
        sb.append("weight=").append(weight);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight);
    }

    @Override
    public int compareTo(Fruit fruit) {
        return Integer.compare(this.weight, fruit.weight);
    }
}
