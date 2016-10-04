package de.zombielabs.campaign.core;

import de.zombielabs.campaign.core.util.Tuple;
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
     * Scenes are containers for SceneElement-Tuples.
     * I chose tuples here because each scene has parts the game master wants to 
     * tell the players and parts that he/she needs to keep for himself/herself.
     * So when adding a new tuple to a scene, the first part will be the part to 
     * tell the players while the second part will be the part the gamemaster keeps 
     * to himself/herself.
     */
    private final List<Tuple<SceneElement, SceneElement>> elements = new ArrayList<>();
    
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
     * Gets an (unmodifiable) list of all Tuples of SceneElements that build this 
     * scene.
     * @return An unmodifiable list of all scene elements.
     */
    public List<Tuple<SceneElement, SceneElement>> getElements() {
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
     * @param tuple The tuple to add, must not be null. One element of the tuple 
     * is allowed to be null (e.g. if you want to add an element that is purely 
     * for the game master, keep the second element null). 
     */
    public void addElement(final Tuple<SceneElement, SceneElement> tuple) {
        if(tuple == null) { 
            LOG.warn("Ignoring null SceneElement tuple to add to scene '{}'", this.name);
            return; 
        }
        
        if(tuple.x == null && tuple.y == null) {
            LOG.warn("Ignoring empty SceneElement tuple to add to scene '{}'", this.name);
            return;
        }
        
        this.elements.add(tuple);
    }
    
    
}