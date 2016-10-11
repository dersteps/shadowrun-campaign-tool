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
public class AttributeTest {
    
    public AttributeTest() {
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
    public void testEmptyAttribute() {
        final Attribute<Integer> attribute = new Attribute<>();
        Assert.assertNull("Natural value of empty attribute should be null", attribute.getNaturalValue());
        Assert.assertNull("Augmented value of empty attribute should be null", attribute.getAugmentedValue());
        Assert.assertEquals("Empty attribute's name should be 'Attribute'", "Attribute", attribute.getName());
    }
}
