package dev.jhyub.objects;

import java.util.List;
import java.util.function.Function;

public class MalFunction<T extends MalObject> extends MalObject {
    Function<List<MalObject>, T> function;

    public MalFunction(Function<List<MalObject>, T> function) {
        this.function = function;
    }

    public static MalFunction<MalNumber> add = new MalFunction<>((List<MalObject> l) -> {
        MalNumber a = (MalNumber) l.get(0);
        MalNumber b = (MalNumber) l.get(1);

        return a.add(b);
    });

    public static MalFunction<MalNumber> sub = new MalFunction<>((List<MalObject> l) -> {
        MalNumber a = (MalNumber) l.get(0);
        MalNumber b = (MalNumber) l.get(1);

        return a.sub(b);
    });

    public static MalFunction<MalNumber> mul = new MalFunction<>((List<MalObject> l) -> {
        MalNumber a = (MalNumber) l.get(0);
        MalNumber b = (MalNumber) l.get(1);

        return a.mul(b);
    });

    public static MalFunction<MalNumber> div = new MalFunction<>((List<MalObject> l) -> {
        MalNumber a = (MalNumber) l.get(0);
        MalNumber b = (MalNumber) l.get(1);

        return a.div(b);
    });

    public Function<List<MalObject>, T> getFunction() {
        return function;
    }

    @Override
    public String print() {
        return "#function";
    }
}
