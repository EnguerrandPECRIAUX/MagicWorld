import java.util.Scanner;

/**
 *
 */
public abstract class Characters implements ICharacters{

    /**
     *
     */
    protected Skill basicAttack = null;
    /**
     *
     */
    protected String scream;
    /**
     *
     */
    protected String name;
    /**
     *
     */
    protected int lvl;
    /**
     *
     */
    protected int lifePoint;
    /**
     *
     */
    protected int strenght;
    /**
     *
     */
    protected int agility;
    /**
     *
     */
    protected int inteligency;

    /**
     *
     * @param scream
     * @param name
     * @param lvl
     * @param strenght
     * @param agility
     * @param inteligency
     * @throws CharactersException
     */
    public Characters(String scream, String name, int lvl, int strenght, int agility, int inteligency)throws  CharactersException{
        if(lvl<(strenght+agility+inteligency)){
            throw new CharactersException();
        }else {
            this.name = name;
            this.lvl = lvl;
            this.lifePoint = lvl * 5;
            this.strenght = strenght;
            this.agility = agility;
            this.inteligency = inteligency;
        }
    }

    /**
     *
     */
    public int chooseSkill(){
        Scanner sc = new Scanner(System.in);
        System.out.println(name + "(" + lifePoint + " Vitalité) veuillez choisir votre action (1: Attaque Basique, 2 : Attaque Spéciale)");
        return sc.nextInt();
    }

    /**
     *
     * @param target
     */
    public void useBasicAttack(Characters target) {
        basicAttack.useSkill(target, this);
    }

    /**
     *
     * @param scream
     */
    public void setScream(String scream) {
        this.scream = scream;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param lvl
     */
    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    /**
     *
     * @param lifePoint
     */
    public void setLifePoint(int lifePoint) {
        this.lifePoint = lifePoint;
    }

    /**
     *
     * @param strenght
     */
    public void setStrenght(int strenght) {
        this.strenght = strenght;
    }

    /**
     *
     * @param agility
     */
    public void setAgility(int agility) {
        this.agility = agility;
    }

    /**
     *
     * @param inteligency
     */
    public void setInteligency(int inteligency) {
        this.inteligency = inteligency;
    }

    /**
     *
     * @return
     */
    public String getScream() {
        return scream;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    public int getLvl() {
        return lvl;
    }

    /**
     *
     * @return
     */
    public int getLifePoint() {
        return lifePoint;
    }

    /**
     *
     * @return
     */
    public int getStrenght() {
        return strenght;
    }

    /**
     *
     * @return
     */
    public int getAgility() {
        return agility;
    }

    /**
     *
     * @return
     */
    public int getInteligency() {
        return inteligency;
    }

    /**
     *
     * @param basicAttack
     */
    public void setBasicAttack(Skill basicAttack) {
        this.basicAttack = basicAttack;
    }
}