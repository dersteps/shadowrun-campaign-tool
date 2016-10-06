package de.zombielabs.campaign.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Scene class represents scenes in an adventure (each adventure consists of 
 * at least one scene, of course).
 * @author steps
 */
public class Scene extends AbstractAttachmentContainer {
    
    private static final transient Logger LOG = LoggerFactory.getLogger(Scene.class);
    
    /**
     * Each scene has a name.
     */
    private String name;
    
    /**
     * Scenes are containers for SceneElements.
     */
    private final List<SceneElement> elements = new ArrayList<>();
    
    /**
     * Initializes a new instance of the Scene class.
     * @param name The scene's name, e.g. "Meeting Mr. Johnson".
     */
    public Scene(final String name) {
        this.name = name;
    }

    /**
     * Gets the scene's name.
     * @return A String containing the scene's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the scene's name.
     * @param name The scene's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets an (unmodifiable) list of all SceneElements that build this scene.
     * @return An unmodifiable list of all scene elements.
     */
    public List<SceneElement> getElements() {
        return Collections.unmodifiableList(elements);
    }
    
    /**
     * Gets the amount of element-tuples that build this scene.
     * @return An integer value 
     */
    public int getElementCount() {
        return this.elements.size();
    }
    
    /**
     * Adds a SceneElement tuple to this Scene.
     * @param element The element to add to the Scene
     */
    public void addElement(final SceneElement element) {
        if(element == null) { 
            LOG.warn("Ignoring null SceneElement to add to scene '{}'", this.name);
            return; 
        }
        
        this.elements.add(element);
    }
    
    public boolean removeElement(final SceneElement element) {
        return this.elements.remove(element);
    }
    
    
}