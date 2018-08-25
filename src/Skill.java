public  class Skill implements ISkill{
    protected String skillName;
    protected int skillEffect;

    public Skill(String skillName, int skillEffect){
        this.skillName = skillName;
        this.skillEffect = skillEffect;
    }

    public void useSkill(Characters target, Characters mySelf){
        System.out.println(mySelf.getName() + " utilise " + skillName + " et inflige " + skillEffect + " dommages.");
        System.out.println(target.getName() + " perd " + skillEffect + " points de vie");
        if((target.getLifePoint() - skillEffect)>0){
            target.setLifePoint(target.getLifePoint() - skillEffect);
        }else{
            target.setLifePoint(target.getLifePoint() - skillEffect);
            System.out.println(target.getName() + " est mort");
        }
    }
}