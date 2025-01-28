package nl.mpdev;

import javax.swing.*;
import java.awt.*;

public class GameManager extends JFrame {
  private static GameManager INSTANCE;
  private Snake snake;
  private Grid grid;
  private Apple apple;
  private ScoreBoard scoreBoard;
  private Timer timer;

  private GameManager() throws HeadlessException {
  }


  public static GameManager getInstance() {
    if(INSTANCE == null) {
      INSTANCE = new GameManager();
    }
    return  INSTANCE;
  }

}
