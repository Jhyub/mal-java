package dev.jhyub.objects;

import java.util.List;
import java.util.StringJoiner;

public class MalList extends MalObject {
    private final List<MalObject> items;

    public MalList(List<MalObject> items) {
        this.items = items;
    }

    @Override
    public String print() {
        StringJoiner sj = new StringJoiner(" ", "(", ")");
        for (MalObject item : items) {
            sj.add(item.print());
        }
        return sj.toString();
    }

    public void append(MalObject item) {
        items.add(item);
    }
}
