//private
//int player1Score;
//int player2Score;
//int player3Score;
//int player4Score;

//public Fish() {           //all to be replaced w/ actual class
  player1Score = 0;
  player2Score = 0;
  player3Score = 0;
  player4Score = 0;

  cplayerHand = new Hand();   //requires new class above
  for (int i=0; i<7; i++){
    cplayerHand.add(deck.(m));    //m is placeholder for dealing the cards from deck defined in some other method; necessary?
  }
}
public class NG {
  public static void main(String[] args) {
    String player1 = "";  //placeholder
    //new variables
    boolean newGame = true;

    while (true) {
      //main game
      System.out.printf("%s has won the game. Congratulations!%n", player1);
      System.out.println("Would you like to start a New Game?");
      newGame = TextIO.getlnBoolean();
    }
  }
}
