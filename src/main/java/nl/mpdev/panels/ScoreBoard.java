package nl.mpdev.panels;

import nl.mpdev.GameManager;

import javax.swing.*;
import java.awt.*;

public class ScoreBoard extends JPanel {

  public ScoreBoard(int width,int height) {
    this.setBackground(Color.BLACK);
    this.setPreferredSize(new Dimension(width, height));
  }

  private void drawScore(Graphics g) {
    g.setColor(Color.WHITE);
    g.setFont(new Font("Arial", Font.PLAIN, 20));
    g.drawString("Score: " + GameManager.getPlayer().getScore(), 10, 20);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    drawScore(g);
  }
}
