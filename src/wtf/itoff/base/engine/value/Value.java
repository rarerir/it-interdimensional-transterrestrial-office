package wtf.itoff.base.engine.value;

public class Value<T> {

    private T value;
    public String name;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Value(T value, String name) {
        this.value = value;
        this.name = name;
    }
}
