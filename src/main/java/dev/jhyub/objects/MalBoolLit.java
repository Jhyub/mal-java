package dev.jhyub.objects;

public class MalBoolLit extends MalObject {
    boolean value;

    public MalBoolLit(boolean value) {
        this.value = value;
    }

    public MalBoolLit(String value) {
        this.value = Boolean.parseBoolean(value);
    }

    @Override
    public String print() {
        return String.valueOf(value);
    }
}
