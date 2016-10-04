package de.zombielabs.campaign.core;

import java.util.ArrayList;
import java.util.List;

/**
 * The AbstractAttachmentContainer interface defines classes that are able to have 
 attachments attached to instances of them.
 * @author steps
 */
public abstract class AbstractAttachmentContainer {
    
    private final List<Attachment<?>> attachments = new ArrayList<>();
    
    /**
     * When implemented in a class, this method should add an attachment to the 
     * instance on which it is called.
     * @param attachment The attachment to add.
     */
    public void addAttachment(final Attachment<?> attachment) {
        if(attachment != null) {
            this.attachments.add(attachment);
        }
    }
    
    /**
     * When implemented in a class, this method should remove a given attachment.
     * If no such attachment exists, it should do nothing.
     * @param attachment The attachment to remove.
     */
    public void removeAttachment(final Attachment<?> attachment) {
        if(attachment != null) {
            this.attachments.remove(attachment);
        }
    }
    
    /**
     * When implemented in a class, this method should remove all attachments from 
     * the instance it is called on.
     */
    public void clearAttachments() {
        this.attachments.clear();
    }
    
    /**
     * When implemented in a class, this method should return true if at least 
     * one attachment is attached to the instance it was called on, false otherwise.
     * @return True if the instance has one or more attachments, false otherwise.
     */
    public boolean hasAttachments() {
        return !this.attachments.isEmpty();
    }
    
    /**
     * When implemented in a class, this method should return the number of
     * attachments attached to the instance it is called on.
     * @return A positive integer (0 included).
     */
    public int getAttachmentCount() {
        return this.attachments.size();
    }
}
