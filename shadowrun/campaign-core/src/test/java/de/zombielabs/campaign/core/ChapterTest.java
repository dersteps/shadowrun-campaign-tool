package de.zombielabs.campaign.core;

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
public class ChapterTest {
    
    private Chapter chapter = new Chapter("Example Chapter");
    
    public ChapterTest() {
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
    public void testAddNullScene() {
        final Scene addNull = null;
        final int originalCount = this.chapter.getSceneCount();
        this.chapter.addScene(addNull);
        Assert.assertEquals("After adding null scene to chapter, it should have the same amount of scenes as before", originalCount, this.chapter.getSceneCount());
    }
    
    @Test
    public void testAddScene() {
        final Scene scene = new Scene("Testscene");
        final int originalCount = this.chapter.getSceneCount();
        this.chapter.addScene(scene);
        Assert.assertEquals("After adding a scene to a chapter, its scene count should increase", originalCount+1, this.chapter.getSceneCount());
        Assert.assertTrue("After adding a scene to a chapter, it should be in the list of scenes of said chapter", this.chapter.getScenes().contains(scene));
    }
    
    @Test(expected = UnsupportedOperationException.class)
    public void testImmutablity() {
        this.chapter.getScenes().add(new Scene("Test123"));
        Assert.fail("Adding a scene to a chapter should not be possible by getting its scenes and adding one. Use Chapter#addScene instead");
    }
    
    @Test
    public void testRemoveNull() {
        final int originalCount = this.chapter.getSceneCount();
        this.chapter.removeScene(null);
        Assert.assertEquals("Removing null scene should not alter chapter at all", originalCount, this.chapter.getSceneCount());
    }
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
