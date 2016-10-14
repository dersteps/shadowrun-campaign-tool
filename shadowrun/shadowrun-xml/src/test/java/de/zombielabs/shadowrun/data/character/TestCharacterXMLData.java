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
        
        final Skills skills = new Skills();
        final Skill skill1 = new Skill();
        skill1.setName("Example skill");
        skill1.setLevel(BigInteger.valueOf(3));
        
        final SkillSpecialization special1 = new SkillSpecialization();
        special1.setName("Example specialization");
        special1.setValue(BigInteger.valueOf(4));
        skill1.getSpecialization().add(special1);
        
        final Skill skill2 = new Skill();
        skill2.setName("Another example skill");
        skill2.setLevel(BigInteger.valueOf(5));
        
        skills.getSkill().add(skill1);
        skills.getSkill().add(skill2);
        sheet1.setSkills(skills);
        c.getDatasheet().add(sheet1);
        
        c.setDataVersion(BigDecimal.valueOf(1.0d));

        JAXB.marshal(c, System.out);
    };
    
    
}
