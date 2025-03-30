package nl.mpdev;

import nl.mpdev.panels.ScoreBoard;

public class Player {
  private String name;
  private int score = 0;

  private boolean wonRound = false;
  private static Player INSTANCE;

  private Player() {
  }

  public static Player getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new Player();
    }
    return INSTANCE;
  }

  public void resetScore() {
    this.score = 0;
  }

  public void increaseScore() {
    score += 30;
    ScoreBoard scoreBoard = ScoreBoard.getInstance();
    scoreBoard.updateScoreBoard();
  }

  public String getName() {
    return name;
  }

  public int getScore() {
    return score;
  }

  public boolean isWonRound() {
    return wonRound;
  }

  public void setWonRound(boolean wonRound) {
    this.wonRound = wonRound;
  }

  public void setName(String name) {
    this.name = name;
  }
}
