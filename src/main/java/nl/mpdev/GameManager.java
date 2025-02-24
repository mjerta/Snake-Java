package nl.mpdev;

import nl.mpdev.panels.Grid;
import nl.mpdev.panels.ScoreBoard;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;

import java.awt.*;

public class GameManager extends JFrame {
  private static GameManager INSTANCE;
  private int level = 1;
  private int scoreToWin = 150;

  private GameManager() throws HeadlessException {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Snake (Java)");

    // SETUP PANELS
    JLayeredPane layeredPane = new JLayeredPane();
    layeredPane.setLayout(new OverlayLayout(layeredPane));

    JPanel mainPanel = new JPanel();

    JPanel overlayPanel = new JPanel(new BorderLayout());

    JPanel inputPanel = new JPanel();
    inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.PAGE_AXIS));
    inputPanel.setBackground(Color.RED);
    inputPanel.add(Box.createVerticalGlue());
    JButton submitButton = new JButton("Submit");
    JButton anotherButton = new JButton("another button");
    JTextField textField = new JTextField(13);
    textField.setFont(new Font("Arial", Font.PLAIN, 30));
    //textField.setBorder(new EmptyBorder(10, 20, 10, 20));
    textField.setMargin(new Insets(10, 20, 10, 20));
    textField.setMaximumSize(textField.getPreferredSize());
    submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    anotherButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    textField.setAlignmentX(Component.CENTER_ALIGNMENT);
    inputPanel.add(submitButton);
    inputPanel.add(Box.createVerticalStrut(10));
    inputPanel.add(anotherButton);
    inputPanel.add(Box.createVerticalStrut(10));
    inputPanel.add(textField);
    inputPanel.add(Box.createVerticalGlue());

    overlayPanel.add(inputPanel);

    Grid grid = new Grid(640, 640, 20);
    mainPanel.add(grid, BorderLayout.WEST);
    mainPanel.add(ScoreBoard.getInstance(), BorderLayout.EAST);

    layeredPane.add(mainPanel, JLayeredPane.DEFAULT_LAYER);
    layeredPane.add(overlayPanel, JLayeredPane.PALETTE_LAYER);

    this.add(layeredPane);
    this.pack();
    System.out.println(this.getWidth() + " " + this.getHeight());
    SwingUtilities.invokeLater(() -> {
      overlayPanel.setPreferredSize(new Dimension(getWidth(), getHeight()));
      overlayPanel.revalidate();
    });
    System.out.println(overlayPanel.getWidth() + " " + overlayPanel.getHeight());
    System.out.println(inputPanel.getWidth() + " " + inputPanel.getHeight());
    this.setResizable(false);
    this.setVisible(true);
  }

  public static GameManager getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new GameManager();
    }
    return INSTANCE;
  }

  public void increaseLevel() {
    level++;
    scoreToWin = scoreToWin * 2;
  }

  public int getScoreToWin() {
    return scoreToWin;
  }

  public void resetGameStatus() {
    level = 1;
    scoreToWin = 150;
  }

  public int getLevel() {
    return level;
  }

}
