import java.util.Arrays;
import java.util.Scanner;

public class Game {
	private static String[] SUITS = {"Clubs", "Spades", "Hearts", "Diamonds"};

	private static String[] NUMBERS = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10",
			"Jack", "Queen", "King"};



	public static void printCard(String[] cards){
		//this helper method is for test use
		for(String a: cards){
			System.out.println(a);
		}
		System.out.println(cards.length);
	}


	private static boolean validInput(String[] guess) {
		if(guess.length>=3){
			if(Arrays.stream(NUMBERS).anyMatch(guess[0]::equals)){
				if(Arrays.stream(SUITS).anyMatch(guess[2]::equals)){
					return true;
				}
			}
		}
		return false;
	}


	private static boolean cardMatch(String[] guess, String card) {
		String[] answer = card.split(" ");
		if(guess[0].equals(answer[0]) && guess[2].equals(answer[2])){
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Hello!! This is Team 27's Game!");
		System.out.println("Please enter your username:");
		String username = scan.nextLine();
		System.out.println("Welcome," +username+"!");
		boolean run = true;
		while(run){
			System.out.println("Choose from the following options by enter the number/letter in bracket(e.g: 2):");
			System.out.println("[1] Guess the number");
			System.out.println("[2] Guess the card");
			System.out.println("[Q] Quit the game");
			String gameChoice = scan.nextLine();
			if(gameChoice.equals("1")){

				System.out.println("GAME1: Guess the Number!");
				System.out.println("Do you want to view the rules for the game? Enter YES for rules.");
				String rule = scan.nextLine();
				if(rule.equals("YES")){
					System.out.println("The game randomly generates a number from 1 to 100.");
					System.out.println("The player enters the number to guess, and if guessed the number, then the game wins.");
					System.out.println("If you guess the wrong number, the game will tell the player whether the guessed number is bigger or smaller than the answer.");
					System.out.println("Each round the game player will have 10 chances to guess the number.");
				}else{
					System.out.println("Here begins the game!");
				}
				System.out.println("Please enter an integer from 1 to 100");
				int random = (int)(Math.random()*100)+1;
				int count = 0;
				while(true){
					int player = scan.nextInt();
					if(player==random){
						System.out.println("Congratulations! Your guess is correct:"+random);
						break;
					}
					else if(player>random){
						System.out.println("Sorry, your guess is too big");
					}
					else if(player<random){
						System.out.println("Sorry, your guess is too small");
					}
					count++;
					if(count>9){
						System.out.println("I'm sorry, you have used up all your chances. The answer is:"+random);
						break;
					}

					System.out.println("You still have "+(10-count)+" chance(s)! Try it again!");
				}
			}else if(gameChoice.equals("2")){
				//creating deck
				int d = SUITS.length * NUMBERS.length;
				String [] deck = new String[d];
				for(int suit = 0; suit < SUITS.length; suit++){
					for(int num = 0; num < NUMBERS.length; num++){
						deck[suit * NUMBERS.length + num] = NUMBERS[num] +" of "+SUITS[suit];
					}
				}

				for(int i = 0; i < d; i++){
					//shuffles the deck
					int rand = i + (int) (Math.random()* (d-i));
					String temp = deck[rand];
					deck[rand] = deck[i];
					deck[i] = temp;
				}
				//print out info for player
				System.out.println("Do you want to view the rules for the game? Enter YES for rules.");
				String rule = scan.nextLine();
				if(rule.equals("YES")){
					System.out.println("The game randomly generates a card from a deck of 52(without the jokers).");
					System.out.println("The player enters the card's number of suit, if guessed the card, then the game wins.");
					System.out.println("If you guess the wrong card, the game will tell the player whether the guessed suit is wrong or guessed card is bigger or smaller than the answer.");
					System.out.println("Each round the game player will have 5 chances to guess the card.");
				}


				System.out.println("Guess the Card");
				System.out.println("Please enter an string in format of (number of suit). e.g: King of Hearts");

				//count is tracked # of guess for each card
				int count = 0;
				//keep track of if we lose all cards
				int cardIndex = 0;

				while(true && cardIndex<deck.length){
					String player = scan.nextLine();
					String[] guess = player.split(" ");
					String[] answer = deck[cardIndex].split(" ");
					if(validInput(guess)){
						if(cardMatch(guess,deck[cardIndex])){
							System.out.println("Congratulations! Your guess is correct!");
							break;
						}else if(!guess[2].equals(answer[2])){
							System.out.println("Hint: try another suit!");
						}else{
							//player get the right suit but wrong number;
							int guessIndex = Arrays.asList(NUMBERS).indexOf(guess[0]);
							int ansIndex = Arrays.asList(NUMBERS).indexOf(answer[0]);
							if(guessIndex < ansIndex){
								System.out.println("Hint: the number is too small!");
							}else{
								System.out.println("Hint: the number is too big!");
							}
						}
						count++;
						if(count>=6){
							System.out.println("I'm sorry, you have used up all your chances. The answer is:"+ deck[cardIndex]);
							//move to next card, reset the number of guess
							System.out.println("Try next card!");
							cardIndex++;
							count = 0;
						}else{
							System.out.println("You still have "+(6-count)+" chance(s) on this card! Try it again!");
						}
					}else{
						System.out.println("Invalid card input! Follow the instruction!");
					}

				}
				if(cardIndex > deck.length){
					System.out.println("Sorry, we run out of cards. Good luck on next deck!");
				}
			}else if(gameChoice.equals("Q")){
				run = false;
			}else{
				System.out.println("Invalid Choice. Please reselect.");
			}
		}
		scan.close();
		System.out.println("Thank you for playing! Goodbye " + username);
	}
}
