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
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(1000, 1000);
    this.setTitle("Snake (Java)");
    this.setLayout(new BorderLayout()); // Testing with layout

    JPanel panel1 = new JPanel();
    panel1.setBackground(Color.RED);

    JPanel panel2 = new JPanel();
    panel2.setBackground(Color.GREEN);

    this.add(panel1, BorderLayout.NORTH);
    this.add(panel2, BorderLayout.CENTER);

  }

  public static GameManager getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new GameManager();
    }
    return INSTANCE;
  }

}
