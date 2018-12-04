import java.util.Scanner;

public class Welcome{
  public static void main(String[] args){
    Scanner console = new Scanner(System.in);
    System.out.println("Welcome to Go Fish!");
    System.out.println("Brought to you by team 27, 'where are we?'");
    System.out.println("Would you like to view the rules?");
    String rules = console.next();
    if(rules.equals("yes")){
      System.out.println("Rules of Go Fish:");
      System.out.println("Players: 2-4");
      System.out.println("Each player is dealt 7 cards. The remaining cards should be placed facedown to create the draw pile.");
      System.out.println("Each turn consists of three main steps:");
      System.out.printf("\t(1) Asking your opponent for a card: Pick a card number from the ones you hold in your hand and then choose another player to ask. %n\tAsk them for the card. For example, 'Do you have any 3's?' If that person has one or more of the called card, they are given to you and become part of your hand. %n\tIf you recieve a card, you can ask again. You can ask a different player or for a different number. %n");
      System.out.printf("\t(2) Go Fish: If your opponent does not have the card, you must 'go fish' and pick a card from the draw pile. If the card you %n\tpick matches the number you asked for, then you show the card to the rest of the players and continue your turn. If it doesn't match, then play moves on. %n");
      System.out.printf("\t(3) Creating sets of 3: As soon as you have 3 cards of the same number in your hand, you immediately place this set face up on the table. %n");
      System.out.println("Winning the game: The game ends when one player reaches 7 sets of cards.");
    }
    //else, proceed to game
  }
}
