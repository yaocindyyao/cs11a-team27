public class initializeCards{
  public static void main(String[] args){
    String[] SUITS = {"Clubs", "Spades", "Hearts", "Diamonds"};

    String[] NUMBERS = {"2", "3", "4", "5", "6", "7", "8", "9", "10",
    "Jack", "Queen", "King", "Ace"};

    int d = SUITS.length * NUMBERS.length;
    String [] deck = new String[d];

    for(int num = 0; num < NUMBERS.length; num++){ //this code initializes the deck
      for(int suit = 0; suit < SUITS.length; suit++){
        deck[SUITS.length * num + suit] = NUMBERS[num] +" of "+SUITS[suit];
      }
    }

    for(int i = 0; i < d; i++){ //shuffles the deck
      int rand = i + (int) (Math.random()* (d-i));
      String temp = deck[rand];
      deck[rand] = deck[i];
      deck[i] = temp;
    }

    for(int i=0; i < d; i++){ //printing out the shuffled deck - not sure we'll need
      System.out.println(deck[i]);
    }
  }
}
