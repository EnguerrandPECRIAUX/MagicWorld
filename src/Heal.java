/**
 *
 */
public  class Heal extends Skill{
    /**
     *
     * @param skillName
     * @param statUse
     */
    public Heal(String skillName, int statUse){
        super(skillName,statUse*2);
    }

    /**
     *
     * @param target
     * @param mySelf
     */
    @Override
    public void useSkill(Characters target, Characters mySelf){
        int realSkillEffect;

        if((target.getLvl()*5)>target.getLifePoint() + skillEffect){
            realSkillEffect = skillEffect;
            System.out.println(mySelf.getName() + " utilise " + skillName + " et gagne " + realSkillEffect + " en vitalité.");
        }else{
            realSkillEffect= (target.getLvl()*5)-target.getLifePoint();
            System.out.println(mySelf.getName() + " utilise " + skillName + " et gagne " + realSkillEffect + " en vitalité.");
        }
        target.setLifePoint(target.getLifePoint() + realSkillEffect);
    }
}