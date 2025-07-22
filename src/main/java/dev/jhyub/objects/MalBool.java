package dev.jhyub.objects;

public class MalBool extends MalObject {
    boolean value;

    public MalBool(boolean value) {
        this.value = value;
    }

    public MalBool(String value) {
        this.value = Boolean.parseBoolean(value);
    }

    @Override
    public String print() {
        return String.valueOf(value);
    }
}
