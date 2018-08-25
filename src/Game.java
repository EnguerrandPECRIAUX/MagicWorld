import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

/**
 *
 */
public class Game {
    /**
     *
     * @see Game#Game
     * @see Game#Game(int)
     * @see Game#namedPlayer
     * @see Game#startGame
     */
    public int nbPlayer;

    /**
     *
     * @see Game#namedPlayer
     */
    public ArrayList playerList = new ArrayList();

    /**
     *
     * @see Game#createCaracters
     */
    public Hashtable charactersList = new Hashtable ();

    /**
     *
     */
    public Game(){
        this.nbPlayer=2;
        startGame();
    }

    /**
     *
     * @param nbPlayer
     */
    public Game(int nbPlayer){
        this.nbPlayer=nbPlayer;
        startGame();
    }

    /**
     *
     */
    private void namedPlayer(){

        if(nbPlayer==2){
            playerList.add("Joueur 1");
            playerList.add("Joueur 2");
        }else{
            Scanner sc = new Scanner(System.in);
            for(int i =0;i<nbPlayer;i++){
                playerList.add(sc.next());
            }
        }
    }

    /***
     *
     * @param idPlayer
     */
    private void createCaracters(int idPlayer){
        boolean endLoop =true;
        int classCRT,lvlCRT,frcCRT,agiCRT,intCRT;
        Scanner sc = new Scanner(System.in);

        System.out.println("Création du personnage du " + playerList.get(idPlayer));
        System.out.println("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)");
        classCRT=sc.nextInt();
        System.out.println("Niveau du personnage ?");
        lvlCRT=sc.nextInt();
        System.out.println("Force du personnage ?");
        frcCRT=sc.nextInt();
        System.out.println("Agilité du personnage ?");
        agiCRT=sc.nextInt();
        System.out.println("Intelligence du personnage ?");
        intCRT=sc.nextInt();

        do {
            switch (classCRT) {
                case 1:
                    // Warrior
                    Warrior warriorCRT = null;
                    try {
                        warriorCRT = new Warrior("Woarg", (String) playerList.get(idPlayer),lvlCRT,frcCRT,agiCRT,intCRT);
                    } catch (CharactersException e) {
                        e.printStackTrace();
                    }
                    charactersList.put( playerList.get(idPlayer),warriorCRT);
                    break;
                case 2:
                    //Ranger
                    Ranger rangerCRT = null;
                    try {
                        rangerCRT = new Ranger("Je suis le ranger, ce donjon n'a jamais était explorer", (String) playerList.get(idPlayer),lvlCRT,frcCRT,agiCRT,intCRT);
                    } catch (CharactersException e) {
                        e.printStackTrace();
                    }
                    charactersList.put( playerList.get(idPlayer),rangerCRT);
                    break;
                case 3:
                    //Wizard
                    Wizard wizardCRT = null;
                    try {
                        wizardCRT = new Wizard("Abracadabra", (String) playerList.get(idPlayer),lvlCRT,frcCRT,agiCRT,intCRT);
                    } catch (CharactersException e) {
                        e.printStackTrace();
                    }
                    charactersList.put( playerList.get(idPlayer),wizardCRT);
                    break;
                default:
                    System.out.println("Choix non valide se doit etre 1,2 ou 3");
                    endLoop =false;
            }
        }while(endLoop);
    }

    /***
     *
     */
    private void startGame(){
        for (int i = 0;i<nbPlayer;i++){
            namedPlayer();
        }
        for (int j = 0;j<nbPlayer;j++){
            createCaracters(j);
        }
    }
}
