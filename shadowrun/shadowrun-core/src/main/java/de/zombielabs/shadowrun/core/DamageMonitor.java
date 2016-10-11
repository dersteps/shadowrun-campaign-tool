package de.zombielabs.shadowrun.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The DamageMonitor class represents the physical and stun damage that a character 
 * takes. 
 * @author steps
 */
public class DamageMonitor {
    private static final transient Logger LOG = LoggerFactory.getLogger(DamageMonitor.class);
    
    private int physicalTrack = 0;
    private int stunTrack = 0;
    private int physicalDamage = 0;
    private int stunDamage = 0;
    
    private int physicalOverflow = 0;
    
    private boolean unconscious = false;

    public boolean isUnconscious() {
        return unconscious;
    }
    
    public int getPhysicalOverflow() {
        return this.physicalOverflow;
    }
    
    public int getPhysicalBoxes() {
        return this.physicalTrack;
    }
    
    public int getStunBoxes() {
        return this.stunTrack;
    }
    
    public int getPhysicalModifier() {
        return this.physicalDamage / 3;
    }    
    
    public int getStunModifier() {
        return this.stunDamage / 3;
    }
    
    public void physicalDamage(final int amount) {
        LOG.debug("Character takes {} points physical damage", amount);
        final int boxesRemaining = this.physicalTrack - this.physicalDamage;
        if(amount > boxesRemaining) {
            // Overflow!
            this.physicalDamage = this.physicalTrack;
            final int remaining = amount - boxesRemaining;
            this.physicalOverflow = remaining;
        } else {
            this.physicalDamage += amount;
        }
        
        if(this.physicalDamage >= this.physicalTrack) {
            this.unconscious = true;
        }
    }
    
    public void stunDamage(final int amount) {
        LOG.debug("Character takes {} points stun damage", amount);
        final int boxesRemaining = this.stunTrack - this.stunDamage;
        if(amount > boxesRemaining) {
            // Will flow over to physical damage...
            // Fill stun
            this.stunDamage = this.stunTrack;
            // Subtract remaining boxes
            final int remaining = amount - boxesRemaining;
            this.physicalDamage(remaining);
        } else {
            this.stunDamage += amount;
        }
        
        if(this.stunDamage >= this.stunTrack) {
            this.unconscious = true;
        }
    }
    
    public void physicalHeal(final int amount) {
        LOG.debug("Character heals {} points physical damage", amount);
        if(this.physicalOverflow == 0) {
            this.physicalDamage -= amount;
            this.physicalDamage = Math.max(0, this.physicalDamage);

            if(this.physicalDamage < this.physicalTrack && this.stunDamage < this.stunTrack) {
                this.unconscious = false;
            }
        } else {
            if(physicalOverflow > amount) {
                this.physicalOverflow -= amount;
            } else {
                final int remaining = amount - this.physicalOverflow;
                this.physicalOverflow = 0;
                this.physicalHeal(remaining);
            }
        }
    }

    public void stunHeal(final int amount) {
        LOG.debug("Character heals {} points stun damage", amount);
        this.stunDamage -= amount;
        this.stunDamage = Math.max(0, this.stunDamage);
        
        if(this.physicalDamage < this.physicalTrack && this.stunDamage < this.stunTrack) {
            this.unconscious = false;
        }
    }
    
    public int getPhysicalDamage() {
        return this.physicalDamage;
    }
    
    public int getStunDamage() {
        return this.stunDamage;
    }
    
    public DamageMonitor(final Attribute<Integer> body, final Attribute<Integer> willpower) {
        final int augmentedBody = body.getAugmentedValue() == null ? 0 : body.getAugmentedValue();
        final int augmentedWill = willpower.getAugmentedValue() == null ? 0 : willpower.getAugmentedValue();
        this.physicalTrack = 8 + (augmentedBody / 2) + (augmentedBody % 2 != 0 ? 1 : 0);
        this.stunTrack = 8 + (augmentedWill / 2) + (augmentedWill % 2 != 0 ? 1 : 0);
    }
}
