package electricity;
import usefulresource.popupincorrect;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class Login implements ActionListener{
    JFrame frame;
    JButton close,min,login,sign;
    int mousex, mousey;
    JTextField tf;
    JPasswordField p;
    JComboBox<String> c;
    JLabel l1,l2,wrong;
    JSeparator line1,line2;
    JLabel panel;

    Login()
    {
        JPanel move = new JPanel();
        move.setBounds(0, 0, 550, 20);
        move.setBackground(new Color(186, 79, 84));
        move.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e)
            {
                mousex = e.getX();
                mousey = e.getY();
            }
        });
        move.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged (MouseEvent e)
            {
                frame.setLocation(e.getX()+frame.getX()-mousex, frame.getY()+e.getY()-mousey);
            }
        });

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icon/close-button.png"));
        Image image = icon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon(image);
        close = new JButton(icon2);
        close.setBackground(new Color(186, 79, 84));
        close.setBounds(575, 1, 20, 20);
        close.setBorder(null);
        close.setContentAreaFilled(false);
        close.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                close.setBorder(BorderFactory.createLineBorder(new Color(74, 31, 61),2,true));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                close.setBorder(null);
            }
        });
        close.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });

        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icon/minimize-sign.png"));
        Image img = i.getImage().getScaledInstance(13, 10, Image.SCALE_DEFAULT);
        ImageIcon icon3 = new ImageIcon(img);
        min = new JButton(icon3);
        min.setBackground(new Color(186, 79, 84));
        min.setBounds(552, 1, 20, 20);
        min.setBorder(null);
        min.setFocusable(false);
        min.setContentAreaFilled(false);
        min.addActionListener((ActionEvent e) -> {
            frame.setState(JFrame.ICONIFIED);
        });

        Font f = new Font("Verdana", Font.PLAIN, 14);

        tf = new JTextField(15);
        tf.setBounds(350, 60, 180, 20);
        tf.setForeground(new Color(74, 31, 61));
        tf.setFont(f);
        tf.setText("Username");
        tf.setBorder(null);
        tf.setBackground(new Color(186, 79, 84));
        p = new JPasswordField(15);
        p.setBounds(350, 110, 180, 20);
        p.setForeground(new Color(74, 31, 61));
        p.setFont(new Font("Verdana", Font.PLAIN, 14));
        p.setText("passdddword");
        p.setBorder(null);
        p.setBackground(new Color(186, 79, 84));

        line1 = new JSeparator(JSeparator.HORIZONTAL);
        line1.setPreferredSize(new Dimension(150,5));
        line1.setBounds(350, 134, 180, 5);
        line2 = new JSeparator(JSeparator.HORIZONTAL);
        line2.setPreferredSize(new Dimension(150,5));
        line2.setBounds(350, 84, 180, 5);

        ImageIcon user = new ImageIcon(ClassLoader.getSystemResource("icon/user.png"));
        Image user1 = user.getImage().getScaledInstance(34, 19, Image.SCALE_DEFAULT);
        ImageIcon user2 = new ImageIcon(user1);
        l1 = new JLabel(user2);
        l1.setBounds(314,61,34,19);

        ImageIcon lock = new ImageIcon(ClassLoader.getSystemResource("icon/icons8-lock-24.png"));
        Image lock1 = lock.getImage().getScaledInstance(19, 20, Image.SCALE_DEFAULT);
        ImageIcon lock2 = new ImageIcon(lock1);
        l2 = new JLabel(lock2);
        l2.setBounds(315,105,30,30);

        final String [] s = {"User","Admin","Customer"};
        c = new JComboBox<String>(s);
        c.setFont(f);
        c.setBorder(BorderFactory.createLineBorder(new Color(74, 31, 61), 2, true));
        c.setBounds(348, 170, 182, 27);
        c.setBackground(new Color(186, 79, 84));
        c.setFocusable(false);

        login = new JButton("Sign in");
        login.setBounds(349, 225, 80, 29);
        login.setFocusable(false);
        login.setForeground(Color.WHITE);
        login.setBorder(BorderFactory.createLineBorder(Color.WHITE,1,false));
        login.setBackground(new Color(186, 79, 84));
        login.addActionListener(this);

        sign = new JButton("Sign up");
        sign.setBounds(449, 225, 80, 29);
        sign.setFocusable(false);
        sign.setForeground(Color.WHITE);
        sign.setBorder(BorderFactory.createLineBorder(Color.WHITE,1,false));
        sign.setBackground(new Color(186, 79, 84));
        sign.addActionListener(this);

        ImageIcon pan = new ImageIcon(ClassLoader.getSystemResource("icon/icon.png"));
        Image pan1 = pan.getImage().getScaledInstance(160, 170, Image.SCALE_DEFAULT);
        ImageIcon pan2 = new ImageIcon(pan1);
        panel = new JLabel();
        panel.setText("L A Z Y P A N");
        panel.setIcon(pan2);
        panel.setHorizontalTextPosition(JLabel.CENTER);
        panel.setVerticalTextPosition(JLabel.BOTTOM);
        panel.setBounds(90, 0, 200, 300);
        panel.setForeground(new Color(74, 31, 61));
        panel.setFont(new Font("SansSerif", Font.BOLD, 28));
        panel.setIconTextGap(15);
        panel.setBackground(new Color(74, 31, 61));
        panel.setVisible(true);
        
        wrong = new JLabel();
        wrong.setBounds(170, 275, 600, 15);
        wrong.setFont(f);

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 300);
        frame.setUndecorated(true);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(186, 79, 84));
        frame.setLocationRelativeTo(null);
        frame.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.WHITE));
        frame.add(move);
        frame.add(close);
        frame.add(min);
        frame.add(l1);
        frame.add(l2);
        frame.add(line2);
        frame.add(tf);
        frame.add(line1);
        frame.add(p);
        frame.add(c);
        frame.add(login);
        frame.add(sign);
        frame.add(panel);
        frame.add(wrong);

    }
    public static void main(String[] args) {
        new Login();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==login)
        {
            Conn c1 = new Conn();
            String a  = tf.getText();
            String b  = String.valueOf(p.getPassword());
            String user = (String) c.getSelectedItem();
            String q  = "select * from login where username = '"+a+"' and password = '"+b+"' and user = '"+user+"'";
            ResultSet rs = null;
            try {
                rs = c1.s.executeQuery(q);
   
                if(rs.next()){
                String meter = rs.getString("meter_no");
                new Project(meter, user);
                frame.dispose();
                }else{
                    new popupincorrect(10,wrong,"Incorrect username or password! ");
                    tf.setText("");
                    p.setText("");
                }
            }
            catch (Exception ex) {System.out.print("aaaaaaaaaaaaaahhhhh");}
            }else if(e.getSource() == sign){
                frame.dispose();
                new Signup();
            }
            
    }
    
}
