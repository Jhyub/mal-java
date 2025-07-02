package dev.jhyub.objects;

public class MalNumberLit extends MalObject {
    Number value;
    boolean isInteger;

    public MalNumberLit(int value) {
        this.value = value;
        this.isInteger = true;
    }

    public MalNumberLit(double value) {
        this.value = value;
        this.isInteger = false;
    }

    public MalNumberLit(String value) throws NumberFormatException {
        try {
            this.value = Integer.valueOf(value);
            this.isInteger = true;
        } catch (NumberFormatException e) {
            this.value = Double.valueOf(value);
            this.isInteger = false;
        }
    }

    public String print() {
        if (isInteger) {
            return value.intValue() + "";
        } else {
            return value.longValue() + "";
        }
    }

}
