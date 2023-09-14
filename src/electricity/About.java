
package electricity;

/* @author Shishir */

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

class About implements ActionListener
{
    JFrame frame;
    About()
    {
        JButton button = new JButton("Exit");
        button.setBounds(195, 380, 90, 30);
        button.setFocusable(false);
        button.setFont(new Font("Verdana", Font.BOLD, 16));
        button.setBorder(BorderFactory.createEtchedBorder());
        button.setVerticalTextPosition(JButton.CENTER);
        button.setBackground(Color.LIGHT_GRAY);
        button.addActionListener(this);

        String s ="\n      Electricity Billing System is a software-based "
                  + "\n       application developed in Java programming "
                  + "\n       language. The project aims at serving the "
                  + "\ndepartment of electricity by computerizing the billing"
                  + "  system. It mainly focuses on the calculation of Units"
                  + "   consumed during the specified time and the money "
                  + "   to be paid to electricity offices. This computerized"
                  + "      system will make the overall billing system easy, "
                  + "   accessible, comfortable and effective for consumers.";
        JTextArea text = new JTextArea(null,s, 10, 40);
        text.setEditable(false);
        text.setFont(new Font("Verdana", Font.PLAIN, 16));
        text.setBorder(BorderFactory.createLineBorder(Color.lightGray,3));
        text.setBounds(16, 100, 450, 250);
        text.setCaretColor(Color.WHITE);
        text.setLineWrap(true);
        text.setWrapStyleWord(true);

        JLabel label = new JLabel("<html><u>About Project</u></html>");
        label.setBounds(168, 10, 180, 80);
        label.setForeground(new Color( 82, 164, 195));
        label.setFont(new Font("RALEWAY", Font.BOLD, 22));

        
        frame = new JFrame();
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icon/icon.png"));
        frame.setIconImage(img.getImage());
        frame.setSize(500, 480);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Electicity Billing System");
        frame.add(button);
        frame.add(text);
        frame.add(label);
    }
    public static void main(String[] args) {
        //JFrame.setDefaultLookAndFeelDecorated(true);
        About about = new About();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.dispose();
        new Login();
    }
}