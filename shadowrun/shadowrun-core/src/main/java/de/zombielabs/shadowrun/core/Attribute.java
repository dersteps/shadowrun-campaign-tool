package de.zombielabs.shadowrun.core;

/**
 * The Attribute class is used to represent a character's attributes.
 * @author steps
 */
public class Attribute<T> {
    private T value;
    private String name;
    
    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Attribute() {
        this(null, "Attribute");
    }
    
    public Attribute(final T value, final String name) {
        this.value = value;
        this.name = name;
    }
}
