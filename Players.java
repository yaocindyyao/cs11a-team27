import java.util.Scanner;

public class Players{
  public static void main(String[] args){
    Scanner console = new Scanner(System.in);
    System.out.println("This is a 2-4 player game");
    System.out.print("How many players? ");
    int players = console.nextInt();

    String player1 = "";
    String player2 = "";
    String player3 = "";
    String player4 = "";

    for(int i = 0; i < players; i++){
      System.out.printf("Please enter the name of Player %d: ",i+1);
      if(i + 1 == 1){
        player1 = console.next();
      }
      if(i + 1 == 2){
        player2 = console.next();
      }
      if(i + 1 == 3){
        player3 = console.next();
      }
      if(i + 1 == 4){
        player4 = console.next();
      }
    }
  }
}
