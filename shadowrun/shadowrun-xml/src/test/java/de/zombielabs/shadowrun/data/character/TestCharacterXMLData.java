package de.zombielabs.shadowrun.data.character;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.JAXB;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author steps
 */
public class TestCharacterXMLData {
    
    public TestCharacterXMLData() {
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
    public void testXMLStructure() {
        final SRCharacterXML c = new SRCharacterXML();
        
        final Datasheet sheet1 = new Datasheet();
        sheet1.setVersion(BigInteger.valueOf(1));
        
        final CharacterInfo info = new CharacterInfo();
        info.setAge(BigInteger.valueOf(23));
        info.setGender(Gender.MALE);
        info.setMetatype("Example metatype");
        info.setName("Example name");
        info.setNickname("Example nickname");
        sheet1.setInfo(info);
        
        final Attributes attribs = new Attributes();
        final Attribute testAttr1 = new Attribute();
        testAttr1.setId(AttributeID.BOD);
        testAttr1.setNatural(BigDecimal.valueOf(4));
        testAttr1.setAugmented(BigDecimal.valueOf(5));
        attribs.getAttribute().add(testAttr1);
        
        sheet1.setAttributes(attribs);
        c.getDatasheet().add(sheet1);
        
        c.setDataVersion(BigDecimal.valueOf(1.0d));

        JAXB.marshal(c, System.out);
    };
    
    
}
