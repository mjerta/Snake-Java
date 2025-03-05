package nl.mpdev.panels;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Background extends JPanel {

  private Image originalImage;
  private Image scaledImage;

  public Background() {
    originalImage = new ImageIcon("assets/java_snake_game_dark_mode.jpg").getImage();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    System.out.println("paintComponent called: " + getWidth() + " x " + getHeight());

    if (scaledImage == null) {
      scaledImage = originalImage.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
    } else {
      g.drawImage(scaledImage, 0, 0, this);
    }
  }
}
