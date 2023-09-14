package usefulresource;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class moveclose{
    int mousex ,mousey;
    JButton close;
    int x,y; JFrame frame;
    public moveclose(JButton close, JPanel move, JFrame frame, int w, int x, int y)
    {
        
        this.frame = frame;
        this.close = close;
        this.x = x; this.y =y;
        action();
        move = new JPanel();
        move.setBounds(0, 0, w, 20);
        move.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
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
        frame.add(move);
    }
    private void action()
    {
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icon/close-button.png"));
        Image image = icon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon(image);
        close = new JButton(icon2);
        //close.setBackground(frame.getBackground());
        close.setBounds(x,y, 20, 20);
        close.setBorder(null);
        close.setContentAreaFilled(false);
        close.setOpaque(true);
        
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
        close.addActionListener((ActionEvent e) -> {
            //new Login();
            System.exit(0);
        });
        frame.add(close);
    }
}
