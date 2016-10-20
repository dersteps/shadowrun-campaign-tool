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
        
        final Skillgroup sg1 = new Skillgroup();
        sg1.setLevel(BigInteger.valueOf(3));
        sg1.setName("Example skill group");
        
        final Skillgroups sgs = new Skillgroups();
        sgs.getSkillgroup().add(sg1);
        
        sheet1.setSkillgroups(sgs);
        
        
        final Perks perks = new Perks();
        final Flaws flaws = new Flaws();
        
        final Perk p1 = new Perk();
        p1.setCost(BigInteger.valueOf(4));
        p1.setLevel(BigInteger.ONE);
        p1.setName("Example perk");
        
        final Flaw f1 = new Flaw();
        f1.setGain(BigInteger.valueOf(12));
        f1.setLevel(BigInteger.ONE);
        f1.setName("Example flaw");
        
        perks.getPerk().add(p1);
        flaws.getFlaw().add(f1);
        
        sheet1.setFlaws(flaws);
        sheet1.setPerks(perks);
        
        final Gear gear = new Gear();
        
        final Armors armors = new Armors();
        final Armor armor1 = new Armor();
        armor1.setArmor(BigInteger.valueOf(3));
        armor1.setCapacity(BigInteger.valueOf(2));
        armor1.setAvailability("Test-Avail");
        armor1.setId("ARMOR_TEST_00001");
        armor1.setName("Example armor");
        
        armors.getArmor().add(armor1);
        gear.setArmors(armors);
        
        final Weapons weapons = new Weapons();
        final Weapon w1 = new Weapon();
        w1.setAccuracy(BigInteger.valueOf(4));
        w1.setAmmocapacity(BigInteger.valueOf(12));
        w1.setAp(BigInteger.ONE);
        w1.setAvailability("3D");
        w1.setConceal(BigInteger.valueOf(9));
        final Damage dmg1 = new Damage();
        dmg1.setValue(BigInteger.valueOf(10));
        dmg1.setType(Damagetype.P);
        dmg1.setExtra("Target is burning or whatever");
        
        w1.setDamage(dmg1);
        
        w1.setId("WEAPON_TEST_00001");
        w1.setMode("HM");
        w1.setName("Example weapon");
        w1.setReach(BigInteger.ZERO);
        w1.setRecoil(BigInteger.valueOf(2));
        w1.setType("Example weapon type");
        weapons.getWeapon().add(w1);
        
        
        
        gear.setWeapons(weapons);
        
        sheet1.setGear(gear);
        
        
        c.getDatasheet().add(sheet1);
        
        c.setDataVersion(BigDecimal.valueOf(1.0d));

        JAXB.marshal(c, System.out);
    };
    
    
}
