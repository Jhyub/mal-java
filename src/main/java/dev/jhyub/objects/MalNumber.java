package dev.jhyub.objects;

public class MalNumber extends MalObject {
    Number value;
    boolean isInteger;

    public MalNumber(int value) {
        this.value = value;
        this.isInteger = true;
    }

    public MalNumber(double value) {
        this.value = value;
        this.isInteger = false;
    }

    public MalNumber(String value) throws NumberFormatException {
        try {
            this.value = Integer.valueOf(value);
            this.isInteger = true;
        } catch (NumberFormatException e) {
            this.value = Double.valueOf(value);
            this.isInteger = false;
        }
    }

    @Override
    public String print() {
        if (isInteger) {
            return value.intValue() + "";
        } else {
            return value.longValue() + "";
        }
    }

}
