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

    public MalNumber add(MalNumber other) {
        if (this.isInteger) {
            if (other.isInteger) {
                return new MalNumber(this.value.intValue() + other.value.intValue());
            } else {
                return new MalNumber(this.value.intValue() + other.value.doubleValue());
            }
        } else {
            if (other.isInteger) {
                return new MalNumber(this.value.doubleValue() + other.value.intValue());
            } else {
                return new MalNumber(this.value.doubleValue() + other.value.doubleValue());
            }
        }
    }

    public MalNumber neg() {
        if (this.isInteger) {
            return new MalNumber(-this.value.intValue());
        } else {
            return new MalNumber(-this.value.doubleValue());
        }
    }

    public MalNumber sub(MalNumber other) {
        return add(other.neg());
    }

    public MalNumber mul(MalNumber other) {
        if (this.isInteger) {
            if (other.isInteger) {
                return new MalNumber(this.value.intValue() * other.value.intValue());
            } else {
                return new MalNumber(this.value.intValue() * other.value.doubleValue());
            }
        } else {
            if (other.isInteger) {
                return new MalNumber(this.value.doubleValue() * other.value.intValue());
            } else {
                return new MalNumber(this.value.doubleValue() * other.value.doubleValue());
            }
        }
    }

    public MalNumber div(MalNumber other) {
        if (this.isInteger) {
            if (other.isInteger) {
                return new MalNumber((double)this.value.intValue() / (double)other.value.intValue());
            } else {
                return new MalNumber((double)this.value.intValue() / other.value.doubleValue());
            }
        } else {
            if (other.isInteger) {
                return new MalNumber(this.value.doubleValue() / (double)other.value.intValue());
            } else {
                return new MalNumber(this.value.doubleValue() / other.value.doubleValue());
            }
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
