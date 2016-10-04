package de.zombielabs.campaign.core;

/**
 * The SceneElement class describes parts of a scene. It can either be a background 
 * element (game master only) or an element to read to the players.
 * @author steps
 */
public class SceneElement extends AbstractAttachmentContainer {
    /**
     * The element's content as a String. This can be virtually any String, from
     * simple text to Markup/Markdown or LaTeX.
     */
    private String content;

    /**
     * Gets this SceneElement's contents as a String.
     * @return The SceneElement's contents.
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets this SceneElement's contents.
     * @param content The new contents.
     */
    public void setContent(final String content) {
        this.content = content;
    }
}
