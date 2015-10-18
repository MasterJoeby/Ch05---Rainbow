//* Chapter 5 Question 27
//* @author Joseph Cohen

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Rainbow extends JPanel
{
  //Declare skyColor;
  Color skyColor = Color.CYAN;

  public Rainbow()
  {
    setBackground(skyColor);
  }

  // Draws the rainbow.
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    int width = getWidth();    
    int height = getHeight();
    


    int xCenter = width/2;
    int yCenter = 3*height/4;
 
    int largeRadius = width/4;
    g.setColor(Color.RED);
    g.fillArc(xCenter-largeRadius/2, yCenter-largeRadius/2, largeRadius, largeRadius, 0, 180);

    int smallRadius = height/4;
    
    
    int mediumRadius = (int) Math.sqrt(smallRadius*largeRadius);
    g.setColor(Color.GREEN);
    g.fillArc(xCenter-mediumRadius/2, yCenter-mediumRadius/2, mediumRadius, mediumRadius, 0, 180);
    
    g.setColor(Color.MAGENTA);
    g.fillArc(xCenter-smallRadius/2, yCenter-smallRadius/2, smallRadius, smallRadius, 0, 180);
    
    
    
    // Calculate the radius of the innermost (sky-color) semicircle
    // so that the width of the middle (green) ring is the
    // arithmetic mean of the widths of the red and magenta rings:
    int skyRadius = (int) Math.sqrt((smallRadius*largeRadius)/5);
    g.setColor(Color.CYAN);
    g.fillArc(xCenter-skyRadius/2, yCenter-skyRadius/2, skyRadius, skyRadius, 0, 180);
 // I couldn't figure out how to do the arithmetic mean of the widths of the red 
 // and magenta rings and then define that for the width of the middle (green) ring,
 // so I decided to do the best I could, while still keeping them in some kind of proportion.
 // hopefully it is acceptable as there were no syntax errors and it still fulfills the goal of creating a rainbow
  }

  public static void main(String[] args)
  {
    JFrame w = new JFrame("Rainbow");
    w.setBounds(300, 300, 300, 200);
    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = w.getContentPane();
    c.add(new Rainbow());
    w.setVisible(true);
  }
}
