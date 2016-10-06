package de.zombielabs.campaign.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * An Adventure instance is composed of several instances of the Chapter class.
 * @author steps
 */
public class Adventure extends AbstractAttachmentContainer {
    private static final transient Logger LOG = LoggerFactory.getLogger(Adventure.class);
    
    private String name;

    private final List<Chapter> chapters = new ArrayList<>();
    
    public Adventure(final String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public List<Chapter> getChapters() {
        return Collections.unmodifiableList(this.chapters);
    }
    
    public int getChapterCount() {
        return this.chapters.size();
    }
    
    public void addChapter(final Chapter chapter) {
        if(chapter == null) {
            LOG.warn("Ignoring null chapter added to Adventure '{}'", this.name);
            return;
        }
        
        this.chapters.add(chapter);
    }
    
    public void removeChapter(final Chapter chapter) {
        if(chapter == null) {
            LOG.warn("Ignoring removal of null chapter from Adventure '{}'", this.name);
            return;
        }
        
        this.chapters.remove(chapter);
    }
    
    
    
}
