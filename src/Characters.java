public abstract class Characters implements ICharacters{
    protected Skill basicAttack = new Skill();
    protected String scream;
    protected String name;
    protected int lvl;
    protected int lifePoint;
    protected int strenght;
    protected int agility;
    protected int inteligency;

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

    public void chooseSkill(){
        System.out.println(name + "(" + lifePoint + " Vitalité) veuillez choisir votre action (1: Attaque Basique, 2 : Attaque Spéciale)");
    }

    public void useBasicAttack(Characters target) {
        basicAttack.useSkill(target, this)
    }

    public void setScream(String scream) {
        this.scream = scream;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public void setLifePoint(int lifePoint) {
        this.lifePoint = lifePoint;
    }

    public void setStrenght(int strenght) {
        this.strenght = strenght;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setInteligency(int inteligency) {
        this.inteligency = inteligency;
    }

    public String getScream() {
        return scream;
    }

    public String getName() {
        return name;
    }

    public int getLvl() {
        return lvl;
    }

    public int getLifePoint() {
        return lifePoint;
    }

    public int getStrenght() {
        return strenght;
    }

    public int getAgility() {
        return agility;
    }

    public int getInteligency() {
        return inteligency;
    }
}