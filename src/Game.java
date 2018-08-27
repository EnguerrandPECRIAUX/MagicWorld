import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

/***
 * <b>Game est la classe représentant le déroulement d'une partie </b>
 * <p>
 * Une partie est caractérisé par :
 * <ul>
 * <li> Un object Game crée par singleton </li>
 * <li> Un nombre de joueur(s) </li>
 * <li> L'identifiant du joueur dont c'est le tours </li>
 * <li> La liste des nom des joueur OU des personnages </li>
 * <li> La liste des personnages </li>
 * <ul>
 * </p>
 *
 * @author Enguerrand PECRIAUX
 * @version 1.0
 */
public class Game {
    /***
     * <b>Singleton de la partie</b> actuel
     *
     * @see Game#newGame()
     * @see Game#newGame(int)
     * @see Game#closeGame()
     */
    private static Game myGame;

    /***
     * <b>Nombre de Joueur</b>
     *
     * @see Game#namedCharacter
     * @see Game#playGame
     */
    private int nbPlayer;

    /***
     * <b>Identifiant du joueur actif </b>
     *
     * @value 0
     * @see Game#playGame
     */
    private int crIdPlayer = 0;

    /***
     * <b>Liste des nom de joueurs</b> si 2 joueurs
     * <b>Liste des nom de personnages</b> si nbPlayer > 2
     *
     * <p>
     * La liste est complété par namedCharacter si nbPlayer > 2
     * ou par Game(int) si nbPlayer = 2
     * Une fois la liste complété on ne la modifie pas.
     * </p>
     *
     * @see Game#namedCharacter
     * @see Game#Game(int)
     * @see Game#chooseCaracteristiqueCharacter
     * @see Game#createCaracters(int)
     * @see Game#playGame
     */
    private ArrayList<String> playerList;

    /***
     * <b>Map des personnages</b> la clef est le nom du personnage
     * la valeur est un object de type ICharacter
     *
     * <p>
     * La map est complété avec la fonction createCaracters.
     * Une fois la liste complété on ne la modifie pas.
     * </p>
     *
     * @see Game#createCaracters
     * @see Game#endGame()
     */
    private Hashtable<String, Characters> charactersList;

    /***
     * <b>Permet de nommer les personnages </b>
     *
     * <p>
     * Va demander à l'utilisateur d'entré nbPlayer nom pour les personnages.
     * </p>
     *
     * @see Game#Game(int)
     */
    private void namedCharacter(){
        Scanner sc = new Scanner(System.in);
        for(int i =0; i < nbPlayer;i++)
            playerList.add(sc.next());
    }

    /***
     * <b>Constructeur Game</b>
     *
     * <p>
     * A la construction d'un singleton Game, le nombre de joueur est fixé,
     * la partie commence automatiquement.
     * </p>
     *
     * @param nbPlayer Nombre de joueur par défault = 2
     * @see Game#newGame(int)
     */
    private Game(int nbPlayer){
        this.nbPlayer = nbPlayer;
        playerList = new ArrayList<String>();
        charactersList = new Hashtable<String, Characters>();
        if(nbPlayer == 2){
            playerList.add("Joueur 1");
            playerList.add("Joueur 2");
        }else{
            namedCharacter();
        }
        playGame();
    }

    /***
     * <b>Permet de crée une instance unique de Game </b>
     *
     * <p>
     * Créer une partie avec 2 joueurs.
     * </p>
     *
     * @return L'instance de Game
     */
    public Game newGame(){
        if(myGame==null)
            myGame = new Game(2);
        return myGame;
    }

    /***
     * <b>Permet de crée une instance unique de Game </b>
     *
     * <p>
     * Créer une partie avec plus de 2 joueurs.
     * </p>
     *
     * @param nbPlayer Nombre de joueurs
     * @return L'instance de Game
     */
    public Game newGame(int nbPlayer){
        if(myGame==null)
            myGame = new Game(nbPlayer);
        return myGame;
    }

    /***
     * Intéroge l'utilisateur pour connaitre le job de son personnages
     *
     * <p>
     *
     *
     * </p>
     *
     * @return Une map avec le job du personnage
     * @see Game#createCaracters
     */
    private Hashtable<String, Integer> chooseJobCharacter(int idPlayer){
        Hashtable<String, Integer> characterJob = new Hashtable<String, Integer>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Création du personnage du " + playerList.get(idPlayer));
        System.out.println("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)");
        characterJob.put("JOB",sc.nextInt() );

        return characterJob;
    }

    /***
     * Intéroge l'utilisateur pour connaitre les caractéristique de son personnages
     *
     * <p>
     *
     *
     * </p>
     *
     * @return Une map des caractéritiques d'un personnage
     * @see Game#createCaracters
     */
    private Hashtable<String, Integer> chooseCaracteristiqueCharacter(Hashtable<String, Integer> characterCaracteristique){
        Scanner sc = new Scanner(System.in);

        System.out.println("Niveau du personnage ?");
        characterCaracteristique.put("LVL",sc.nextInt() );
        System.out.println("Force du personnage ?");
        characterCaracteristique.put("STR",sc.nextInt() );
        System.out.println("Agilité du personnage ?");
        characterCaracteristique.put("AGI",sc.nextInt() );
        System.out.println("Intelligence du personnage ?");
        characterCaracteristique.put("INT",sc.nextInt() );

        return characterCaracteristique;
    }

    /***
     * <b>Crée un personnage </b>
     *
     * <p>
     * Lorque l'on crée un personnage on choisie:
     * <ul>
     * <li>Son Job</li>
     * <li>Son niveau</li>
     * <li>Ces Caratéristiques (Force, Agilité, Intelligence)</li>
     * </ul>
     * </p>
     *
     * @param idPlayer Identifiant du joueur dans la liste des joueurs
     * @see Game#playGame()
     */
    private void createCaracters(int idPlayer) {
        Scanner sc = new Scanner(System.in);
        boolean endLoop = true;
        Hashtable<String, Integer> characterCaracteristique = chooseJobCharacter(idPlayer);
        characterCaracteristique = chooseCaracteristiqueCharacter(characterCaracteristique);
        do {
            switch (characterCaracteristique.get("JOB")){
                case 1:
                    Warrior warriorCRT = null;
                    try {
                        warriorCRT = new Warrior("Woarg", playerList.get(idPlayer), characterCaracteristique.get("LVL"), characterCaracteristique.get("STR"), characterCaracteristique.get("AGI"), characterCaracteristique.get("INT"));
                        charactersList.put(playerList.get(idPlayer), warriorCRT);
                        warriorCRT.toString();
                    }catch(CharactersException e){
                            characterCaracteristique = chooseCaracteristiqueCharacter(characterCaracteristique);
                            endLoop = false;
					}
                    break;
                case 2:
                    Ranger rangerCRT = null;
                    try {
                        rangerCRT = new Ranger("Je suis le ranger, ce donjon n'a jamais était explorer", playerList.get(idPlayer), characterCaracteristique.get("LVL"), characterCaracteristique.get("STR"), characterCaracteristique.get("AGI"), characterCaracteristique.get("INT"));
                        charactersList.put(playerList.get(idPlayer), rangerCRT);
                        rangerCRT.toString();
                    }catch(CharactersException e){
                            characterCaracteristique = chooseCaracteristiqueCharacter(characterCaracteristique);
                            endLoop = false;
                    }
                    break;
                case 3:
                    Wizard wizardCRT = null;
                    try {
                        wizardCRT = new Wizard("Abracadabra", playerList.get(idPlayer), characterCaracteristique.get("LVL"), characterCaracteristique.get("STR"), characterCaracteristique.get("AGI"), characterCaracteristique.get("INT"));
                        charactersList.put(playerList.get(idPlayer), wizardCRT);
                        wizardCRT.toString();
                    }catch( CharactersException e){
                            characterCaracteristique = chooseCaracteristiqueCharacter(characterCaracteristique);
                            endLoop = false;
                    }
                    break;

                default:
                        System.out.println("Choix non valide : veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)");
                        //characterCaracteristique.remove("JOB");
                        characterCaracteristique.put("JOB", sc.nextInt());
                        endLoop = false;
            }
        } while (endLoop) ;
    }

    /***
     * <b> Test si la partie est fini </b>
     *
     * <p>
     * Test chaque personnage pour savoir s'il est mort
     * Si oui affiche nom de personnage + a perdu !
     * </p>
     *
     * @return Si la partie est fini (au moins un joueur mort)
     * @see Game#playGame()
     */
    private boolean endGame () {
        boolean gameIsEnd = false;
        for (int i=0;i<nbPlayer;i++) {
            if ( charactersList.get(playerList.get(i)).getLifePoint() < 1) {
                System.out.println(charactersList.get(playerList.get(i)).getName() + " a perdu !");
                gameIsEnd = true;
            }
        }
        return gameIsEnd;
    }

    /***
     * <b>Choisi la cible d'une attaque</b>
     *
     * <p>
     * Affiche la liste des personnages
     * L'utilisateur entre l'idtentifiant du personnage qu'(il/elle) souhaite attaquer.
     * </p>
     *
     * @return L'identifiant du personnage selectionnée comme cible
     * @see Game#playGame
     */
    private int playerListChooseTarget () {
        return 0;
    }

    /***
     * <b>Met à null le singleton Game </b>
     *
     * <p>
     * Supprime le singleton Game pour permettre de crée une nouvelle partie.
     * </p>
     *
     * @see Game#playGame
     */
    public void closeGame () {
        myGame = null;
    }

    /***
     * <b>Déroule l'algorithme d'une partie </b>
     *
     * <p>
     * Dans un premier temps on va demander aux joueurs de crée leur personnage.
     * Puis les personnages vont s'affronter à tours de rôles
     * </p>
     *
     * @see Game#Game(int)
     */
    private void playGame () {
        String crPlayerName, targetPlayerName;
        int atqType, nextCrIdPlayer;

        for (int i = 0; i < nbPlayer; i++)
            createCaracters(nbPlayer);

        nextCrIdPlayer=0;
        do {
            crPlayerName = playerList.get(crIdPlayer);
            nextCrIdPlayer = (!(nextCrIdPlayer + 1 = nbPlayer)) ? (nextCrIdPlayer + 1) : 0;
            atqType =  charactersList.get(crPlayerName).chooseSkill();
            targetPlayerName = (nbPlayer == 2) ? playerList.get(crIdPlayer) : playerList.get(playerListChooseTarget());

            if (atqType == 1) {
                charactersList.get(crPlayerName).useBasicAttack(charactersList.get(targetPlayerName));
            } else {
                charactersList.get(crPlayerName).useSpecialSkill((Characters)charactersList.get(targetPlayerName));
            }
            crIdPlayer = nextCrIdPlayer;
        } while (endGame());
        closeGame();
    }

}
