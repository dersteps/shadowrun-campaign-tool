package de.zombielabs.campaign.core.attachments;

import de.zombielabs.campaign.core.Attachment;
import de.zombielabs.shadowrun.core.ShadowrunCharacter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author steps
 */
public class CharacterAttachment extends Attachment<ShadowrunCharacter> {

    private static final transient Logger LOG = LoggerFactory.getLogger(CharacterAttachment.class);
    
    /**
     * Initializes a new instance of the CharacterAttachment class.
     * @param data The character that is attached 
     * @param name A name that can be displayed.
     */
    public CharacterAttachment(final ShadowrunCharacter data, final String name) {
        super(data, name);
    }
    
}
