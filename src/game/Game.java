package game;

import materials.Coin;
import materials.CoinState;
import player.Player;
import utils.Statistics;

import java.util.*;

public class Game {

    private Rules rules;
    private Coin coin;
    private Map<Player, List<CoinState>> history;

    public Game() {
        history = new HashMap<>();
    }

    /**
     * Ajouter un nouveau joueur au jeu
     *
     * @param player le nouveau joueur
     */
    public void addPlayer(Player player) {
      // TODO: Votre code ici
        List<CoinState> lst = new ArrayList<>();
        history.put(player,lst);
    }

    /**
     * Faire joueur tous les joueurs et stocker chaque partie dans history
     */
    public void play() {
      // TODO: Votre code ici
        rules = Rules.getInstance(); //Instancie en singleton le processus de jeux
        for(Player p: history.keySet()){ //Itération des joueurs
            coin = Coin.getInstance(); //Instancie un Coin pour chaque utilisateur
            //Boucle - Tant que checkWin est faux
            while (!rules.checkWin(history.get(p))){
                p.play(coin); //On fait jouer le coin
                history.get(p).add(coin.getState()); //On ajout son état
            }
        }
    }

    /**
     * Calculer des statistiques de la partie précédente
     *
     * @return Statistics
     */
    public Statistics getStatistics() {
      // TODO: Votre code ici
        Map<Player, List<CoinState>> historyPrecedent = this.history;
        float nbToWin = 0;
        int nbMin = 0;
        int nbMax = 0;
        int nbTotalLancer = 0;

        for(Player p : historyPrecedent.keySet()){
            nbToWin += historyPrecedent.get(p).size();
            nbTotalLancer += historyPrecedent.get(p).size();
        }

        nbToWin = nbToWin / historyPrecedent.size();
        nbMin = nbMinWinners(historyPrecedent);
        nbMax = nbMinWinners(historyPrecedent);

        return new Statistics(nbToWin, nbMin, nbMax, nbTotalLancer);
    }

    public int nbMinWinners(Map<Player, List<CoinState>> historyPrecedent){

    }

    /**
     * Obtenir l'historique de tous les joueurs de la partie précédente
     *
     * @return Map contenant chaque joueur et la liste des ses lancers
     */
    public Map<Player, List<CoinState>> getHistory() {
      // TODO: Votre code ici
      return this.history;
    }


    /**
     * Obtenir l'historique d'un joueur spécifique
     *
     * @param player instance du joueur pour lequel on veut avoir l'historique
     * @return la liste des lancers d'un joueur
     */
    public List<CoinState> getSpecificHistory(Player player) {
      // TODO: Votre code ici
      return history.get(player);
    }

}
