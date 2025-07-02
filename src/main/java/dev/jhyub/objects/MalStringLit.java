package dev.jhyub.objects;

public class MalStringLit extends MalObject {
    private String value;

    public MalStringLit(String value) {
        this.value = value.substring(1, value.length() - 1);

    }

    public String print() {
        return "\"" + value + "\"";
    }
}
