package dev.jhyub.objects;

public class MalString extends MalObject {
    private String value;

    public MalString(String value) {
        this.value = value.substring(1, value.length() - 1);

    }

    @Override
    public String print() {
        return "\"" + value + "\"";
    }
}
