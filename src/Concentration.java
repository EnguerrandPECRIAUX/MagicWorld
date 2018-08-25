/**
 *
 */
public  class Concentration extends Skill{

    /**
     *
     * @param skillName
     * @param statUse
     */
    public Concentration(String skillName, int statUse){
        super(skillName,statUse/2);
    }

    /**
     *
     * @param target
     * @param mySelf
     */
    @Override
    public void useSkill(Characters target, Characters mySelf){
        System.out.println(mySelf.getName() + " utilise " + skillName + " et gagne " + skillEffect + " en agilité.");
        target.setAgility(target.getAgility() + skillEffect);
    }
}