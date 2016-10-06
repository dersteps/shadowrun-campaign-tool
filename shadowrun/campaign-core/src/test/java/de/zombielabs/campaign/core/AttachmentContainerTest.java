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
public class AttachmentContainerTest {
    
    public AttachmentContainerTest() {
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
    public void testNullAttachmentOnSceneElement() {
        final SceneElement element = new SceneElement();
        element.addAttachment(null);
        Assert.assertFalse("Adding a null attachment should not work on SceneElements", element.hasAttachments());
    }
    
    @Test
    public void testNullAttachmentOnScene() {
        final Scene scene = new Scene("Testscene");
        scene.addAttachment(null);
        Assert.assertFalse("Adding a null attachment should not work on Scenes", scene.hasAttachments());
    }
  
    @Test
    public void testNullAttachmentOnChapter() {
        final Chapter chapter = new Chapter("Test Chapter");
        chapter.addAttachment(null);
        Assert.assertFalse("Adding a null attachment should not work on Chapters", chapter.hasAttachments());
    }
    
    @Test
    public void testNullAttachmentOnAdventure() {
        final Adventure adventure = new Adventure("Test adventure");
        adventure.addAttachment(null);
        Assert.assertFalse("Adding a null attachment should not work on Adventures", adventure.hasAttachments());
    }
    
}
