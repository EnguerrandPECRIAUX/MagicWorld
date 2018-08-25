/**
 *
 */
public class Ranger extends Characters {
    /**
     *
     */
    private Concentration specialSkill=null;

    /**
     *
     * @param scream
     * @param name
     * @param lvl
     * @param strenght
     * @param agility
     * @param inteligency
     */
    public Ranger(String scream, String name, int lvl, int strenght, int agility, int inteligency){
        super(lvl,strenght,agility,inteligency);
        this.basicAttack = new Skill("Tir à l’Arc",agility);
        this.specialSkill = new Concentration("Concentration",agility);
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
        return scream + " je suis le Rôdeur " + name + " niveau " + lvl + " je possède " + lifePoint + " de vitalité, " + strenght + " de force, " + agility + " d'agilité et " + inteligency + " d'intelligence !";
    }
}