package de.zombielabs.campaign.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Chapter class is used to wrap several instances of the Scene class into 
 * a useful package which is - obviously - a chapter of an adventure.
 * @author steps
 */
public class Chapter extends AbstractAttachmentContainer {
    
    /**
     * Logger.
     */
    private static final transient Logger LOG = LoggerFactory.getLogger(Chapter.class);
    
    /**
     * This chapter's name.
     */
    private String name;
    
    /**
     * A List of all the scenes that make this chapter.
     */
    private final List<Scene> scenes = new ArrayList<>();
    
    public Chapter(final String name) {
        this.name = name;
    }
    
    /**
     * Gets this chapter's name
     * @return A String containing the name of the chapter.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets this chapter's name.
     * @param name The new name to use.
     */
    public void setName(final String name) {
        this.name = name;
    }
    
    /**
     * Obtains an immutable copy of the scenes that make this chapter.
     * @return An immutable list of scenes.
     */
    public List<Scene> getScenes() {
        return Collections.unmodifiableList(this.scenes);
    }
    
    public int getSceneCount() {
        return this.scenes.size();
    }
    
    public void addScene(final Scene scene) {
        if(scene == null) {
            LOG.warn("Ignoring null scene added to chapter '{}'", this.name);
            return;
        }
        
        this.scenes.add(scene);
    }
    
    public void removeScene(final Scene scene) {
        if(scene == null) {
            LOG.warn("Ignoring removal of null scene from chapter '{}'", this.name);
            return;
        }
        
        this.scenes.remove(scene);
    }
    
}
