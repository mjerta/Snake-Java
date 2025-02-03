package nl.mpdev;

public class Player {
  private static Player instance;
  private final String name;
  private int score = 0;

  private Player(String name) {
    this.name = name;
  }

  public static Player getInstance(String playersName){
    if(instance == null){
      instance = new Player(playersName);
    }
    return instance;
  }

  public void increaseScore() {
    score += 30;
  }

  public String getName() {
    return name;
  }

  public int getScore() {
    return score;
  }
}
