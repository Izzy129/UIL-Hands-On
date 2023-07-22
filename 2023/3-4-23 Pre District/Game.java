import java.util.*;
import java.io.*;
import java.util.concurrent.TimeUnit;
public class Game {
  private String title; // title of game
  private String publisher; // publisher of game
  private double price; // price of game
  private int lowAge; // minimum recommended age
  //------------------------------------------------------//
  // this is the constructor
  public Game(String t, String publish, double p, int l) { // object constructor
    title = t;
    publisher = publish;
    price = p;
    lowAge = l;
  }
  //------------------------------------------------------//
  // this method is an accessor for the private title variable
  public String getTitle() {
    return title;
  }
  //------------------------------------------------------//
  // this method is an accessor for the private publisher variable
  public String getPublisher() {
    return publisher;
  }
  //------------------------------------------------------//
  // this method is an accessor for the private price variable
  public double getPrice() {
    return price;
  }
  //------------------------------------------------------//
  // this method is an accessor for the private lowAge variable
  public int getAge() {
    return lowAge;
  }
  //------------------------------------------------------//
  // this method prints out information about a game
  public String toString() {
    return "Title: " + title + " | Price: " + price + " | Publisher: " + publisher + " | Minimum Recommended age: " + lowAge + "\n";
  }
  public static void main(String[] args) throws InterruptedException {
    ArrayList < Game > gameStore = new ArrayList < Game > (); // creates an arraylist to contain list of games in game store
    // next 9 lines adds games to the store arraylist
    gameStore.add(new Game("Halo", "Bungie", 30.00, 13));
    gameStore.add(new Game("Half Life 2", "Valve", 20.00, 13));
    gameStore.add(new Game("Garry's Mod", "Facepunch", 10.00, 10));
    gameStore.add(new Game("Fortnite", "Epic Games", 0.00, 10));
    gameStore.add(new Game("Worms", "Team17", 20.00, 12));
    gameStore.add(new Game("Minecraft", "Mojang", 27.00, 10));
    gameStore.add(new Game("Elden Ring", "Bandai Namco", 60.00, 14));
    gameStore.add(new Game("Left 4 Dead", "Valve", 20.00, 12));
    gameStore.add(new Game("Left 4 Dead 2 ", "Valve", 20.00, 12));
    ArrayList < Game > myCollection = new ArrayList < Game > (); // creates an arraylist to contain the user's games
    // games are added/removed from myCollection later upon user input
    Scanner scan = new Scanner(System.in);
    boolean playing = true;
    int choice = -1; // choice initial value, will be changed once user chooses what they want to do
    while (playing) { // Iteration-______________________________
      System.out.println();
      System.out.println("Current Available Games:\n");
      showMyGames(gameStore); // prints current games on store
      System.out.println();
      System.out.println("My Game Collection:\n");
      showMyGames(myCollection); // prints current games in user collection
      System.out.println();
      // next 3 lines output what a user can do with the program
      System.out.println("1: Add a new game to my collection");
      System.out.println("2: Remove a game from my collection");
      System.out.println("3: Show my current collection");
      System.out.println("0: Stop the program");
      choice = scan.nextInt();
      switch (choice) { // switch for user input
      case 1:
        System.out.println("Enter the game's ID:"); // user input is 1, adds game to collection if not already in list
        int gameID = scan.nextInt();
        if (gameID >= 0 && gameID < gameStore.size()) { // out of bounds check
          if (addGame(gameStore.get(gameID), myCollection)) { // conditional check to see if game is in list already
            System.out.println();
          } else {
            System.out.println("Game already in collection!");
            TimeUnit.SECONDS.sleep(1);
          }
        } else {
          System.out.println("Invalid game ID, please try again.");
          TimeUnit.SECONDS.sleep(1);
        }
        break;
      case 2:
        System.out.println("Current game collection: ");
        showMyGames(myCollection); // prints current user collection so they can see which one they want to remove
        System.out.println("Enter the game's ID you want to remove:"); // user input is 2, removes game from collection
        int gameID2 = scan.nextInt(); // user input detection
        if (gameID2 >= 0 && gameID2 < myCollection.size()) { // out of bounds check
          Game temp = myCollection.get(gameID2); // temp variable to hold game to be removed
          if (myCollection.remove(temp)) { // conditional check to see if game is in collection or not
            System.out.println(temp.getTitle() + " has been removed from your collection!");
            TimeUnit.SECONDS.sleep(1);
          } else {
            System.out.println("Game not in your collection!");
            TimeUnit.SECONDS.sleep(1);
          }
        } else {
          System.out.println("Invalid game ID, please try again.");
          TimeUnit.SECONDS.sleep(1);
        }
        break;
      case 3:
        System.out.println("Your current game collection:"); // user input is 3, prints out current user collection
        showMyGames(myCollection); // prints user collection
        TimeUnit.SECONDS.sleep(1);
        break;
      case 0:
        playing = false; // user input is 0, exits program
        System.out.println("Goodbye!");
        break;
      default:
        System.out.println("Invalid choice, please try again with a valid choice."); // default for invalid input
        TimeUnit.SECONDS.sleep(1);
        break;
      }
    }
  } // end of main
  // additional methods follow
  //------------------------------------------------------//
  // this method adds a game to the arraylist, conditional to check if game is already in list is checked
  public static boolean addGame(Game theGame, ArrayList < Game > gameList) throws InterruptedException {
    for (Game g: gameList) { // check to see if game is already in list
      if (g.getTitle().equals(theGame.getTitle())) { // conditional
        return false; // exits with false if game is already in list, otherwise it will move on to the rest of the program
      }
    }
    gameList.add(theGame); // adds game if game is not already in list
    System.out.println(theGame.getTitle() + " has been successfully added to your collection!");
    TimeUnit.SECONDS.sleep(1);
    return true;
  }
  //------------------------------------------------------//
  // this methods prints out all games in a Game ArrayList
  public static void showMyGames(ArrayList < Game > gameList) {
    String output = "";
    for (int i = 0; i < gameList.size(); i++) { // loop to iterate through gameList array
      // int counter = i + 1; // ID counter
      output += "ID: " + i + ".) " + gameList.get(i); // string concatenation
    }
    System.out.println(output); // prints and exits
  }
}