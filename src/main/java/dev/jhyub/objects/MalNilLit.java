package dev.jhyub.objects;

public class MalNilLit extends MalObject {
    public MalNilLit() {}

    @Override
    public String print() {
        return "nil";
    }
}
