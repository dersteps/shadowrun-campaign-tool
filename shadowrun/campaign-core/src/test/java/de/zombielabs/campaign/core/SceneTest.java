package de.zombielabs.campaign.core;

import org.junit.*;

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
        final SceneElement nullElement = null;
        final int originalCount = this.scene.getElementCount();
        this.scene.addElement(nullElement);
        Assert.assertEquals("After adding null element to scene, it should still have the same amount of elements as before", originalCount, this.scene.getElementCount());
    }
    
    @Test
    public void testAddValidElements() {
        final SceneElement element = new SceneElement();
        final int originalCount = this.scene.getElementCount();
        this.scene.addElement(element);
        
        Assert.assertEquals("Scene should now have 1 more element than before, but hasn't", originalCount+1, this.scene.getElementCount());
    }
    
    @Test(expected = UnsupportedOperationException.class)
    public void testImmutability() {
        final int originalCount = this.scene.getElementCount();
        this.scene.getElements().add(new SceneElement());
        Assert.assertEquals("Should not be able to add elements via getting the current list and adding to it (immutable collection)", originalCount, this.scene.getElementCount());
        Assert.fail("...and by the way, this operation should not be supported at all...");
    }
    
    @Test
    public void testRemoveNull() {
        final SceneElement element = new SceneElement();
        final int originalCount = this.scene.getElementCount();
        this.scene.addElement(element);
        
        Assert.assertEquals("Scene should now have 1 more element than before, but hasn't", originalCount+1, this.scene.getElementCount());
        this.scene.removeElement(null);
        Assert.assertEquals("Scene should have same amount of elements after removing null element", originalCount+1, this.scene.getElementCount());
    }
    
    @Test
    public void testRemove() {
        final SceneElement one = new SceneElement();
        final SceneElement two = new SceneElement();
        this.scene.addElement(one);
        this.scene.addElement(two);
        final int count = this.scene.getElementCount();
        this.scene.removeElement(one);
        Assert.assertEquals("Removing an element should decrease the count", count-1, this.scene.getElementCount());
        Assert.assertFalse("Removing an element should actually remove it", this.scene.getElements().contains(one));
        Assert.assertTrue("Not removing an element should not remove it", this.scene.getElements().contains(two));
    }
}
