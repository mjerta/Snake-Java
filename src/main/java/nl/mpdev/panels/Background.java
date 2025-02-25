package nl.mpdev.panels;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Background extends JPanel {

  private Image backgroundImage;

  public Background() {
    backgroundImage = new ImageIcon("assets/snake_game_menu.jpg").getImage();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    System.out.println("paintComponent called: " + getWidth() + " x " + getHeight());
    if(backgroundImage != null) {
      g.drawImage(backgroundImage, 0, 0, this);
    }
  }
}
