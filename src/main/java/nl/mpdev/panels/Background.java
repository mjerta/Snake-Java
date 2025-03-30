package nl.mpdev.panels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Background extends JPanel {

  private Image originalImage;
  private Image scaledImage;

  public Background() {
    this.setBackground(Color.black);
    originalImage = new ImageIcon("assets/java_snake_game_dark_mode.jpg").getImage();
  }

  private void scaleImage() {
    int width = getWidth();
    int height = getHeight();

    if (width > 0 && height > 0) {
      BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
      Graphics2D g2d = resized.createGraphics();
      g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
      g2d.drawImage(originalImage, 0, 0, width, height, null);
      g2d.dispose();
      scaledImage = resized;
    }
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (scaledImage == null || scaledImage.getWidth(null) != getWidth() || scaledImage.getHeight(null) != getHeight()) {
      scaleImage();
    } else {
      g.drawImage(scaledImage, 0, 0, this);
    }
  }

  public Image getOriginalImage() {
    return originalImage;
  }

  public Image getScaledImage() {
    return scaledImage;
  }

}
