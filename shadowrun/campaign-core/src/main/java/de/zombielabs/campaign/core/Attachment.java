package de.zombielabs.campaign.core;

/**
 * The Attachment class is used as a generic base for all attachments to elements.
 * @author steps
 */
public abstract class Attachment<AttachmentType> {
    private AttachmentType data;
    
    private String name;

    public AttachmentType getData() {
        return data;
    }

    public void setData(AttachmentType data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Attachment(AttachmentType data, String name) {
        this.data = data;
        this.name = name;
    }
}
