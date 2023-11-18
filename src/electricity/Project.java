package electricity;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenuBar;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

class Project
{
  JFrame frame;
  JLabel background;
  JButton notice;
  JTextField tf;
  JPasswordField p;
  String meter;
  String person;
  public Project(String meter, String person)
  {
    this.meter = meter;
    this.person = person;    
    
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    frame = new JFrame();
    frame.setIconImage(new ImageIcon(ClassLoader.getSystemResource("icon/icon.png")).getImage());
    frame.setBounds(0, 0,(int)screenSize.getWidth()+10,(int)screenSize.getHeight()-35);
    frame.setLocationRelativeTo(null);
    frame.setLayout(null);
    frame.setResizable(false);

    ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icon/1.png"));
    Image img1 = img.getImage().getScaledInstance(frame.getWidth(),frame.getHeight(),Image.SCALE_DEFAULT);
    background = new JLabel(new ImageIcon(img1));
    background.setBounds(0, 0,frame.getWidth(),frame.getHeight());

    JMenuBar mb = new JMenuBar();
    mb.setLocation(187, 17);
    mb.setSize(345,40);
    mb.setBackground(new Color(0,0,0,0));
    new menubar(mb, person, frame, meter);

    JLabel sign = new JLabel("Sign In");
    sign.setForeground(new Color(36,134,33));
    sign.setBounds(1221,11,111,37);
    sign.setFont(new Font("Segoe UI", Font.BOLD, 23));
    sign.setBorder(null);
    sign.setFocusable(false);
    sign.setOpaque(false);
    sign.setBackground(new Color(0, 0, 0, 0));

    notice = new JButton("Notices");
    notice.setForeground(new Color(232,242,244));
    notice.setBounds(820,510,130,50);
    notice.setFont(new Font("Segoe UI", Font.BOLD, 27));
    notice.setBorder(BorderFactory.createLineBorder(Color.white, 2, true));
    notice.setFocusable(false);
    notice.setContentAreaFilled(false);
    notice.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
          
      }
    });

    JTextArea area1 = new JTextArea(null, "     Electricity Bill Mangement System",20,20);
    area1.setOpaque(false);
    area1.setBackground(new Color(0, 0, 0, 0));
    area1.setBounds(235,232,500,200);
    area1.setFont(new Font("Lucida Grande", Font.PLAIN,45));
    area1.setForeground(new Color(51,55,56));
    area1.setBorder(null);
    area1.setLineWrap(true);
    area1.setWrapStyleWord(true);
    area1.setCaretColor(new Color(0, 0, 0, 0));

    JTextArea area = new JTextArea(null, null,20,76);
    area.setOpaque(false);
    area.setBackground(new Color(0, 0, 0, 0));
    area.setBounds(160,380,600,150);
    area.setFont(new Font("Calibri",Font.PLAIN,20));
    area.setForeground(new Color(10,10,10));
    area.setBorder(null);
    area.setLineWrap(true);
    area.setWrapStyleWord(true);
    area.setEditable(false);
    area.setCaretColor(new Color(0, 0, 0, 0));
    String str = "EMS provides customer oriented services for users, for the easy"+
                 " payment of their respective Electricity Bills as well as "+
                 "interaction with electricity providers in case of any queries and greviances."+
                 " It is a platform which can ease the process of paying bills and provies an easy"+
                 " and efficient way to pay from devices.";
    Thread thread = new Thread(new Thread(){
        public void run(){
          for(int i=0;i<str.length();i++){
            try{
              Thread.sleep(15);
            }catch(InterruptedException e){
                System.out.println("hellllllll");
            }
            area.setText(area.getText()+str.charAt(i));
          }
        }
    });

    tf = new JTextField(15);
    tf.setBounds(650, 17, 230, 31);
    tf.setForeground(new Color(74, 31, 61));
    tf.setFont(new Font("Consolas", Font.PLAIN,23));
    tf.setText("Username");
    tf.setBorder(null);
    tf.setOpaque(false);
    tf.setBackground(new Color(0,0,0,0));
    tf.setCaretColor(new Color(0, 0, 0, 0));
    p = new JPasswordField(15);
    p.setBounds(930, 17, 230, 31);
    p.setForeground(new Color(74, 31, 61));
    p.setFont(new Font("Consolas", Font.PLAIN,23));
    p.setText("passdddword");
    p.setBorder(null);
    p.setOpaque(false);
    p.setBackground(new Color(0,0,0,0));
    p.setCaretColor(new Color(0, 0, 0, 0));

    JLayeredPane layer = new JLayeredPane();
    layer.setBounds(0, 0,frame.getWidth(),frame.getHeight());
    layer.add(background,Integer.valueOf(0));
    layer.add(sign,Integer.valueOf(1));
    layer.add(mb,Integer.valueOf(1));
    layer.add(area1,Integer.valueOf(1));
    layer.add(area,Integer.valueOf(1));
    layer.add(tf,Integer.valueOf(1));
    layer.add(p,Integer.valueOf(1));
    layer.add(notice,Integer.valueOf(1));

    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.add(layer);
    thread.start();
  }
  public static void main(String[] args) {
    new Project("","");
  }
}