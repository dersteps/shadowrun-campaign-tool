package de.zombielabs.campaign.core;

import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author steps
 */
public class SceneElementIsAttachmentContainerTest {
    
    public SceneElementIsAttachmentContainerTest() {
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
    public void testSceneElementIsContainer() {
        final SceneElement element = new SceneElement();
        element.addAttachment(null);
        Assert.assertFalse("Adding a null attachment should not work on SceneElements", element.hasAttachments());
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
