package dev.jhyub.objects;

public class MalSymbol extends MalObject {
    String name;

    public MalSymbol(String name) {
        this.name = name;
    }

    @Override
    public String print() {
        return this.name;
    }

    public String getName() {
        return name;
    }
}
