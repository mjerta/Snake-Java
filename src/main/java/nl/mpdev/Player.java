package nl.mpdev;

public class Player {
  private final String name;
  private int score;

  public Player(String name, int score) {
    this.name = name;
    this.score = score;
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
