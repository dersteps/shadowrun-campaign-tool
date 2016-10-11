package de.zombielabs.shadowrun.core;

/**
 * The Attribute class is used to represent a character's attributes.
 * @author steps
 */
public class Attribute<T> {
    private T naturalValue;
    private T augmentedValue;
    
    private String name;
    
    public T getNaturalValue() {
        return naturalValue;
    }

    public void setNaturalValue(T value) {
        this.naturalValue = value;
    }

    public T getAugmentedValue() {
        return augmentedValue;
    }

    public void setAugmentedValue(T augmentedValue) {
        this.augmentedValue = augmentedValue;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Attribute() {
        this(null, null, "Attribute");
    }
    
    public Attribute(final T naturalValue, final T augmentedValue, final String name) {
        this.naturalValue = naturalValue;
        this.name = name;
        this.augmentedValue = augmentedValue;
    }
}
