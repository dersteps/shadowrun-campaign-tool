package de.zombielabs.campaign.core;

import de.zombielabs.campaign.core.util.Tuple;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author steps
 */
public class SceneTest {
    
    private Scene scene = new Scene("Test scene");
    
    public SceneTest() {
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
    public void testAddNullElement() {
        final Tuple<SceneElement, SceneElement> nullTuple = null;
        final int originalCount = this.scene.getElementCount();
        this.scene.addElement(nullTuple);
        Assert.assertEquals("After adding null tuple to scene, it should still have the same amount of elements as before", originalCount, this.scene.getElementCount());
    }
    
    @Test
    public void testAddEmptyElement() {
        final Tuple<SceneElement, SceneElement> emptyTuple = new Tuple<SceneElement, SceneElement>(null, null);
        final int originalCount = this.scene.getElementCount();
        this.scene.addElement(emptyTuple);
        Assert.assertEquals("After adding an empty tuple to scene, it should still have the same amount of elements as before", originalCount, this.scene.getElementCount());
    }
    
    @Test
    public void testAddValidElements() {
        
        final Tuple<SceneElement, SceneElement> validTuple1 = new Tuple<SceneElement, SceneElement>(new SceneElement(), null);
        final Tuple<SceneElement, SceneElement> validTuple2 = new Tuple<SceneElement, SceneElement>(null, new SceneElement());
        final Tuple<SceneElement, SceneElement> validTuple3 = new Tuple<SceneElement, SceneElement>(new SceneElement(), new SceneElement());
        
        final int originalCount = this.scene.getElementCount();

        this.scene.addElement(validTuple1);
        this.scene.addElement(validTuple2);
        this.scene.addElement(validTuple3);
        
        Assert.assertEquals("Scene should now have three (3) more tuples than before, but hasn't", originalCount+3, this.scene.getElementCount());
        
    }
    
    @Test
    public void testImmutability() {
        final int originalCount = this.scene.getElementCount();
        try {
            this.scene.getElements().add(new Tuple<>(new SceneElement(), new SceneElement()));
            Assert.assertEquals("Should not be able to add elements via getting the current list and adding to it (immutable collection)", originalCount, this.scene.getElementCount());
            Assert.fail("...and by the way, this operation should not be supported at all...");
        } catch (UnsupportedOperationException ex) {
            // Expected exception
        }
    }
}
