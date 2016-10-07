package de.zombielabs.shadowrun.core;

/**
 * The ShadowrunCharacter class represents a character in the Shadowrun universe.
 * @author steps
 */
public class ShadowrunCharacter {
    private Attribute<Integer> body;
    private Attribute<Integer> dexterity;
    private Attribute<Integer> strength;
    private Attribute<Integer> reaction;
    private Attribute<Integer> logic;
    private Attribute<Integer> intution;
    private Attribute<Integer> charisma;
    private Attribute<Integer> willpower;
    private Attribute<Integer> edge;
    private Attribute<Integer> magic;
    private Attribute<Integer> resonance;
    private Attribute<Double> essence;
    
    private String name;
    private String nickname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Attribute<Integer> getBody() {
        return body;
    }

    public void setBody(Attribute<Integer> body) {
        this.body = body;
    }

    public Attribute<Integer> getDexterity() {
        return dexterity;
    }

    public void setDexterity(Attribute<Integer> dexterity) {
        this.dexterity = dexterity;
    }

    public Attribute<Integer> getStrength() {
        return strength;
    }

    public void setStrength(Attribute<Integer> strength) {
        this.strength = strength;
    }

    public Attribute<Integer> getReaction() {
        return reaction;
    }

    public void setReaction(Attribute<Integer> reaction) {
        this.reaction = reaction;
    }

    public Attribute<Integer> getLogic() {
        return logic;
    }

    public void setLogic(Attribute<Integer> logic) {
        this.logic = logic;
    }

    public Attribute<Integer> getIntution() {
        return intution;
    }

    public void setIntution(Attribute<Integer> intution) {
        this.intution = intution;
    }

    public Attribute<Integer> getCharisma() {
        return charisma;
    }

    public void setCharisma(Attribute<Integer> charisma) {
        this.charisma = charisma;
    }

    public Attribute<Integer> getWillpower() {
        return willpower;
    }

    public void setWillpower(Attribute<Integer> willpower) {
        this.willpower = willpower;
    }

    public Attribute<Integer> getEdge() {
        return edge;
    }

    public void setEdge(Attribute<Integer> edge) {
        this.edge = edge;
    }

    public Attribute<Integer> getMagic() {
        return magic;
    }

    public void setMagic(Attribute<Integer> magic) {
        this.magic = magic;
    }

    public Attribute<Integer> getResonance() {
        return resonance;
    }

    public void setResonance(Attribute<Integer> resonance) {
        this.resonance = resonance;
    }

    public Attribute<Double> getEssence() {
        return essence;
    }

    public void setEssence(Attribute<Double> essence) {
        this.essence = essence;
    }
    
    
    
}
