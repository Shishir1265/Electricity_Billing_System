package electricity;
import usefulresource.popupincorrect;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.RoundRectangle2D;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Signup implements ActionListener
{
    JFrame frame;
    JLabel label, Icon, popup;
    JPanel moved;
    int mousex, mousey;
    JTextField t1, t2, t3;
    JPasswordField p;
    JComboBox<String>c;
    JButton close,back,create;
    JCheckBox ch;
    public Signup()
    {
        moved = new JPanel();
        moved.setBounds(0, 0, 710, 20);
        moved.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
        moved.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e)
            {
                mousex = e.getX();
                mousey = e.getY();
            }
        });
        moved.addMouseMotionListener(new MouseMotionAdapter() {
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
        close.setBounds(707, 6, 20, 20);
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
                new Login();
                System.exit(0);
            }
        });

        label = new JLabel();
        ImageIcon paint = new ImageIcon(ClassLoader.getSystemResource("icon/bestoutofbest.png"));
        Image i = paint.getImage().getScaledInstance(734, 380, Image.SCALE_DEFAULT);
        ImageIcon paint1 = new ImageIcon(i);
        label.setIcon(paint1);
        label.setBounds(0, -10,816, 400);

        Font f = new Font("Verdana",Font.PLAIN,18);

        create = new JButton();
        create.setFont(f);
        create.setText("Create");
        create.setBounds(395,310,100,40);
        create.setFocusable(false);
        create.setForeground(Color.WHITE);
        create.setBorder(BorderFactory.createLineBorder(new Color(186, 79, 84),1,false));
        create.setBackground(new Color(79,31,61));
        create.addActionListener(this);

        back = new JButton();
        back.setFont(f);
        back.setText("Back");
        back.setBounds(565,310,100,40);
        back.setFocusable(false);
        back.setForeground(Color.WHITE);
        back.setBorder(BorderFactory.createLineBorder(new Color(186, 79, 84),1,false));
        back.setBackground(new Color(79,31,61));
        back.addActionListener(this);

        ImageIcon pan = new ImageIcon(ClassLoader.getSystemResource("icon/icon.png"));
        Image pan1 = pan.getImage().getScaledInstance(240,220, Image.SCALE_DEFAULT);
        ImageIcon pan2 = new ImageIcon(pan1);
        Icon = new JLabel(pan2);
        Icon.setBounds(40,40,240,220);

        t1 = new JTextField(15);
        t1.setBounds(527, 36, 147, 30);
        t1.setForeground(new Color(74, 31, 61));
        t1.setFont(f);
        t1.setOpaque(false);
        t1.setBorder(null);
        
        p = new JPasswordField(15);
        p.setBounds(523, 147, 140, 27);
        p.setForeground(new Color(74, 31, 61));
        p.setFont(f);
        p.setBorder(null);
        p.setOpaque(false);
        
        ImageIcon eye = new ImageIcon(ClassLoader.getSystemResource("icon/eye.png"));
        Image eye1 = eye.getImage().getScaledInstance(14, 12, Image.SCALE_DEFAULT);
        ImageIcon eye2 = new ImageIcon(eye1);
        ch = new JCheckBox(eye2);
        ch.setBounds(661,156,20,14);
        ch.setOpaque(false);
        ch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(ch.isSelected())
                {
                    p.setEchoChar((char)0);
                }
                else{ p.setEchoChar('•'); }
            }
        });
        
        t2 = new JTextField(15);
        t2.setBounds(525, 91, 147, 30);
        t2.setForeground(new Color(74, 31, 61));
        t2.setFont(f);
        t2.setOpaque(false);
        t2.setBorder(null);
        
        t3 = new JTextField(15);
        t3.setBounds(525, 197, 151, 35);
        t3.setForeground(new Color(74, 31, 61));
        t3.setFont(f);
        t3.setOpaque(false);
        t3.setBorder(null);

        final String [] s = {"Customer","Admin"};
        c = new JComboBox<String>(s);
        c.setFont(f);
        c.setBorder(BorderFactory.createLineBorder(new Color(74, 31, 61), 2, true));
        c.setBounds(513, 255, 172, 30);
        c.setOpaque(false);
        c.setBackground(new Color(186, 79, 84));
        c.setFocusable(false);
        
        popup = new JLabel();
        popup.setBounds(30, 335, 260, 40);
        popup.setFont(f);
        popup.setOpaque(false);

        JLayeredPane layer = new JLayeredPane();
        layer.setBounds(0,0,734,380);
        layer.add(label,Integer.valueOf(0));
        layer.add(close,Integer.valueOf(1));
        layer.add(moved,Integer.valueOf(1));
        layer.add(create,Integer.valueOf(1));
        layer.add(back,Integer.valueOf(1));
        layer.add(Icon,Integer.valueOf(1));
        layer.add(t1,Integer.valueOf(1));
        layer.add(p,Integer.valueOf(1));
        layer.add(t2,Integer.valueOf(1));
        layer.add(ch,Integer.valueOf(1));
        layer.add(c,Integer.valueOf(1));
        layer.add(t3,Integer.valueOf(1));
        layer.add(popup,Integer.valueOf(1));

        frame = new JFrame();
        frame.setSize(734, 380);
        frame.setUndecorated(true);
        frame.setVisible(true);
        frame.setShape(new RoundRectangle2D.Double(0, 0, 734, 380, 50, 50));
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(layer);
    }

    public static void main(String[] args) {
        new Signup();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==create){
            String username = t1.getText();
            String name = t2.getText();
<<<<<<< HEAD
            String password = String.valueOf(p.getPassword());
=======
            String password = p.getPassword().toString();
>>>>>>> b6b7790224d388c0f05a7cfa341fef09c9e01d72
            var user = (String) c.getSelectedItem();
            String meter = t3.getText();
            try{
                Conn c = new Conn();
                String str = null;
                if(user.equals("Admin")){
                    str = "Insert into login values ('"+meter+"', '"+username+"', '"+name+"', '"+password+"', '"+user+"')";
                }else{
                    str = "update login set username = '"+username+"', name = '"+name+"', password = '"+password+"', user = '"+user+"' where meter_no = '"+t3.getText()+"'";
                }
                c.s.executeUpdate(str);
                new popupincorrect(10,popup,"Account Created Successfully");
                frame.dispose();
                new Login();
            }catch(Exception ae){
                System.out.println(ae+" error!!! :(");}
        }else if (e.getSource()== back){
            frame.dispose();
            new Login();
        } 
    }
}