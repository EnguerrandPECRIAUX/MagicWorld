/**
 *
 */
public class Warrior extends Characters {
    /**
     *
     */
    private RageBlow specialSkill=null;

    /**
     *
     * @param scream
     * @param name
     * @param lvl
     * @param strenght
     * @param agility
     * @param inteligency
     */
    public Warrior(String scream, String name, int lvl, int strenght, int agility, int inteligency){
        super(name,lvl,strenght,agility,inteligency);
        this.basicAttack = new Skill("Coup d’Épée",strenght);
        this.specialSkill = new RageBlow("Coup de Rage",strenght);
    }

    /**
     *
     * @param target
     */
    public void useSpecialSkill(Characters target) {
        specialSkill.useSkill(target, this);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString(){
        return scream + " je suis le Guerrier " + name + " niveau " + lvl + " je possède " + lifePoint + " de vitalité, " + strenght + " de force, " + agility + " d'agilité et " + inteligency + " d'intelligence !";
    }
}