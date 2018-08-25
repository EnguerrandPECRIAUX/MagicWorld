/**
 *
 */
public class Wizard extends Characters {
    /**
     *
     */
    private Heal specialSkill=null;

    /**
     *
     * @param scream
     * @param name
     * @param lvl
     * @param strenght
     * @param agility
     * @param inteligency
     */
    public Wizard(String scream, String name, int lvl, int strenght, int agility, int inteligency){
        super(lvl,strenght,agility,inteligency);
        this.basicAttack = new Skill("Boule de Feu",inteligency);
        this.specialSkill = new Heal("Soin",inteligency);
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
        return scream + " je suis le Mage " + name + " niveau " + lvl + " je possède " + lifePoint + " de vitalité, " + strenght + " de force, " + agility + " d'agilité et " + inteligency + " d'intelligence !";
    }
}