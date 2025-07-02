package dev.jhyub.objects;

/**
 * Fallback atom for unknown objects
 */
public class MalUnknown extends MalObject {
    private String value;

    public MalUnknown(String token) {
        this.value = token;
    }

    public String print() {
        return "UNKNOWN(" + value + ")";
    }
}
