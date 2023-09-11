package electricity;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenuBar;

class Project
{
  JFrame frame;
  JLabel background;
  JButton button;
  String meter;
  String person;
  public Project(String meter, String person)
  {
    this.meter = meter;
    this.person = person;    
    
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    frame = new JFrame();
    frame.setIconImage(new ImageIcon("icon/icon.png").getImage());
    frame.setBounds(0, 0,(int)screenSize.getWidth()+10,(int)screenSize.getHeight()-35);
    frame.setLocationRelativeTo(null);
    frame.setLayout(null);
    frame.setResizable(false);

    ImageIcon img = new ImageIcon("icon/1new.png");
    Image img1 = img.getImage().getScaledInstance(frame.getWidth(),frame.getHeight(),Image.SCALE_DEFAULT);
    background = new JLabel(new ImageIcon(img1));
    background.setBounds(0, 0,frame.getWidth(),frame.getHeight());

    JMenuBar mb = new JMenuBar();
    mb.setLocation(187, 17);
    mb.setSize(345,40);
    mb.setBackground(new Color(0,0,0,0));
    new menubar(mb, person, frame, meter);

    button = new JButton("Sign In");
    button.setForeground(new Color(36,134,33));
    button.setBounds(1205,12,111,37);
    button.setFont(new Font("Segoe UI", Font.BOLD, 24));
    button.setBorder(null);
    button.setFocusable(false);
    button.setContentAreaFilled(false);
    //button.setBackground(new Color(0, 0, 0, 0));

    JLayeredPane layer = new JLayeredPane();
    layer.setBounds(0, 0,frame.getWidth(),frame.getHeight());
    layer.add(background,Integer.valueOf(0));
    layer.add(button,Integer.valueOf(1));
    layer.add(mb,Integer.valueOf(1));

    frame.setVisible(true);
    frame.add(layer);
  }
  public static void main(String[] args) {
    new Project("","");
  }
}