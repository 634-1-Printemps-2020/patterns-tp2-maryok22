package materials;

public class Coin {

  private CoinState coinState;
  private static Coin uniqueCoin = null;

  private Coin(){throwCoin();}

  public static Coin getInstance(){ //Permet de récuperer le COIN UNIQUE
    if(uniqueCoin == null){
      uniqueCoin = new Coin();
    }
    return uniqueCoin;
  }
  /**
   * Change l'état de la pièce.
   * 50% de probabilité d'obtenir HEADS, 50% de probabilité d'obtenir TAILS
   */
  public void throwCoin() {
    // TODO : Votre code ici
    double value = Math.random() * (1);

    if(value < 0.5){
      coinState = coinState.HEADS;
    }else{
      coinState = CoinState.TAILS;
    }

  }

  public CoinState getState() {
    return coinState;
  }

}
