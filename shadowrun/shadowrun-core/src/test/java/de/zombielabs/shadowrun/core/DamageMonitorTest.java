/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zombielabs.shadowrun.core;

import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author steps
 */
public class DamageMonitorTest {
    
    public DamageMonitorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test 
    public void testEmptyDamageMonitor() {
        final Attribute<Integer> sample = new Attribute<>();
        final DamageMonitor dmg = new DamageMonitor(sample, sample);
        Assert.assertEquals("Empty damage monitor's physical boxes should be 8", 8, dmg.getPhysicalBoxes());
        Assert.assertEquals("Empty damage monitor's stun boxes should be 8", 8, dmg.getStunBoxes());
        Assert.assertEquals("Empty damage monitor's physical damage should be 0", 0, dmg.getPhysicalDamage());
        Assert.assertEquals("Empty damage monitor's stun damage should be 0", 0, dmg.getStunDamage());
        Assert.assertEquals("Empty damage monitor's physical overflow should be 0", 0, dmg.getPhysicalOverflow());
        Assert.assertFalse("Empty damage monitor should mean 'not unconscious'", dmg.isUnconscious());
    }
    
    @Test
    public void testBoxesCalculation() {
        final Attribute<Integer> body = new Attribute<>(5, 5, "Body");
        final Attribute<Integer> will = new Attribute<>(1, 1, "Willpower");
        final DamageMonitor dmg = new DamageMonitor(body, will);
        Assert.assertEquals("Damage monitor calculation for physical boxes should be '8 + (body/2)' (round up)", 11, dmg.getPhysicalBoxes());
        Assert.assertEquals("Damage monitor calculation for stun boxes should be '8 + (willpower/2)' (round up)", 9, dmg.getStunBoxes());
    }
    
    @Test
    public void testStunOverflow() {
        final Attribute<Integer> body = new Attribute<>(5, 5, "Body");
        final Attribute<Integer> will = new Attribute<>(1, 1, "Willpower");
        final DamageMonitor dmg = new DamageMonitor(body, will);
        
        // Take 8 stun damage -> fine
        dmg.stunDamage(8);
        Assert.assertFalse("With 1 remaining stun box, character should not be unconscious", dmg.isUnconscious());
        Assert.assertEquals("With only stun damage, physical damage should be 0", 0, dmg.getPhysicalDamage());
        Assert.assertEquals("With only stun damage, physical overflow should be 0", 0, dmg.getPhysicalOverflow());
        
        // Take 1 more stun damage -> unconscious
        dmg.stunDamage(1);
        Assert.assertTrue("With full stun track, character should be unconscious", dmg.isUnconscious());
        Assert.assertEquals("With only stun damage and no overflow, there should be no physical damage", 0, dmg.getPhysicalDamage());
        Assert.assertEquals("With only stun damage and no overflow, there should be no physical overflow", 0, dmg.getPhysicalOverflow());
        
        // Overflow
        dmg.stunDamage(1);
        Assert.assertTrue("With one damage marker overflowing, character should (still) be unconscious", dmg.isUnconscious());
        Assert.assertEquals("With one damage marker overflowing, character should have 1 point of physical damage", 1, dmg.getPhysicalDamage());
        Assert.assertEquals("With one damage marker overflowing, character should have 0 physical overflow", 0, dmg.getPhysicalOverflow());
    }
    
    @Test
    public void testPhysicalOverflow() {
        final Attribute<Integer> body = new Attribute<>(5, 5, "Body");
        final Attribute<Integer> will = new Attribute<>(1, 1, "Willpower");
        final DamageMonitor dmg = new DamageMonitor(body, will);
        
        // Take 10 physical -> not unconscious
        dmg.physicalDamage(10);
        Assert.assertFalse("With one box left on the physical track and no stun damage, character should not be unconscious", dmg.isUnconscious());
        Assert.assertEquals("With the physical track not exceeded, physical overflow should be 0", 0, dmg.getPhysicalOverflow());
        
        // Take 1 more physical -> unconscious
        dmg.physicalDamage(1);
        Assert.assertTrue("With full physical track, character should be unconscious", dmg.isUnconscious());
        
        // Overflow
        dmg.physicalDamage(1);
        Assert.assertTrue("With one damage marker overflowing, character should (still) be unconscious", dmg.isUnconscious());
        Assert.assertEquals("With one overflowing damage, character should have physical overflow value of 1", 1, dmg.getPhysicalOverflow());
    }
    
    @Test
    public void testOverflowChaining() {
        final Attribute<Integer> body = new Attribute<>(5, 5, "Body");
        final Attribute<Integer> will = new Attribute<>(1, 1, "Willpower");
        final DamageMonitor dmg = new DamageMonitor(body, will);
        
        dmg.stunDamage(9);
        
        // Should have no physical and no physical overflow
        Assert.assertEquals("Should not have physical damage at all", 0, dmg.getPhysicalDamage());
        Assert.assertEquals("Should not have physical overflow", 0, dmg.getPhysicalOverflow()); 
        
        dmg.stunDamage(10);
        Assert.assertEquals("With stun track 9 and 19 stun damage, character should have 10 physical", 10, dmg.getPhysicalDamage());
        dmg.stunDamage(2);
        Assert.assertEquals("With stun track 9, physical track 11 and 21 damage, character should have 1 physical overflow", 1, dmg.getPhysicalOverflow());
    }
    
    @Test
    public void testHealing() {
        final Attribute<Integer> body = new Attribute<>(5, 5, "Body");
        final Attribute<Integer> will = new Attribute<>(1, 1, "Willpower");
        final DamageMonitor dmg = new DamageMonitor(body, will);
        
        dmg.stunDamage(20);
        
        // Assert phsyical damage 11 and stun damage 9
        Assert.assertEquals("Physical damage should be 11", 11, dmg.getPhysicalDamage());
        Assert.assertEquals("Stun damage should be 9", 9, dmg.getStunDamage());
        Assert.assertEquals("Overflow should be 0", 0, dmg.getPhysicalOverflow());
        Assert.assertTrue("Character should be unconscious", dmg.isUnconscious());
        
        dmg.physicalDamage(1);
        Assert.assertEquals("Overflow should be 1", 1, dmg.getPhysicalOverflow());
        
        dmg.physicalHeal(2);
        Assert.assertEquals("Overflow should be 0", 0, dmg.getPhysicalOverflow());
        Assert.assertEquals("Physical damage should be 10", 10, dmg.getPhysicalDamage());
        
        // Still unconscious
        Assert.assertTrue("Character should still be unconscious", dmg.isUnconscious());
        dmg.physicalHeal(100);
        Assert.assertEquals("Character's physical damage should be 0", 0, dmg.getPhysicalDamage());
        
        dmg.stunHeal(1);
        Assert.assertFalse("Character should no long be unconscious", dmg.isUnconscious());
        dmg.stunHeal(100);
        Assert.assertEquals("Character's stun damage should be 0", 0, dmg.getStunDamage());
    }
    
    @Test
    public void testModifiers() {
        final Attribute<Integer> body = new Attribute<>(5, 5, "Body");
        final Attribute<Integer> will = new Attribute<>(1, 1, "Willpower");
        final DamageMonitor dmg = new DamageMonitor(body, will);
        
        Assert.assertEquals("Stun modifier should be 0 on an empty monitor", 0, dmg.getStunModifier());
        Assert.assertEquals("Physical modifier should be 0 on an empty monitor", 0, dmg.getPhysicalModifier());
        
        // Light damage
        dmg.physicalDamage(2);
        dmg.stunDamage(2);
        Assert.assertEquals("Stun modifier should be 0", 0, dmg.getStunModifier());
        Assert.assertEquals("Physical modifier should be 0", 0, dmg.getPhysicalModifier());
        
        // More damage
        dmg.stunDamage(1);
        Assert.assertEquals("Stun modifier should be 1", 1, dmg.getStunModifier());
        dmg.physicalDamage(1);
        Assert.assertEquals("Physical modifier should be 1", 1, dmg.getPhysicalModifier());
        
        // Even more
        dmg.stunDamage(3);
        Assert.assertEquals("Stun modifier should be 2", 2, dmg.getStunModifier());
        dmg.physicalDamage(4);
        Assert.assertEquals("Physical modifier should be 2", 2, dmg.getPhysicalModifier());
    }

}
