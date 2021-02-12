package generators;

public class SimplePair<K, V> implements Pair<K, V> {
    private K first;
    private V second;

    @Override
    public String toString() {
        return "SimplePair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    public SimplePair(K first, V second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public K getFirst() {
        return first;
    }

    @Override
    public V getSecond() {
        return second;
    }
}
