/**
 *
 */
public  class RageBlow extends Skill{
    /**
     *
     */
    private int skillEffect2;

    /**
     *
     * @param skillName
     * @param statUse
     */
    public RageBlow(String skillName, int statUse){
        super(skillName,statUse*2);
        this.skillEffect2=statUse/2;
    }

    /**
     *
     * @param target
     * @param mySelf
     */
    @Override
    public void useSkill(Characters target, Characters mySelf){
        System.out.println(mySelf.getName() + " utilise " + skillName + " et inflige " + skillEffect + " dommages.");
        if((target.getLifePoint() - skillEffect)<0){
            System.out.println(target.getName() + " est mort");
        }else{
            System.out.println(target.getName() + " perd " + skillEffect + " points de vie");
        }

        if((mySelf.getLifePoint() - skillEffect2)<0){
            System.out.println(mySelf.getName() + " est mort");
        }else{
            System.out.println(mySelf.getName() + " perd " + skillEffect2 + " points de vie");
        }

        target.setLifePoint(target.getLifePoint() - skillEffect);
        mySelf.setLifePoint(mySelf.getLifePoint() - skillEffect2);
    }
}