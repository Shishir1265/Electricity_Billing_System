package electricity;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class menubar implements ActionListener {

    JMenuBar mb;
    JFrame frame;
    String meter;
    String not[] = { "Notepad.exe" };
    String cal[] = { "calc.exe" };
    String browser[] = { "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe" };

    menubar(JMenuBar mb, String person, JFrame frame, String meter) {
        this.mb = mb;
        this.frame = frame;
        this.meter = meter;
        Font f = new Font("Verdana", Font.PLAIN, 20);
        Color c = new Color(105, 127, 226);

        /* First Column */
        JMenu master = new JMenu("Master");
        master.setFont(new Font("Verdana", Font.PLAIN, 20));
        master.setForeground(Color.WHITE);
        JMenuItem m1 = new JMenuItem("New Customer");
        JMenuItem m2 = new JMenuItem("Customer Details");
        JMenuItem m3 = new JMenuItem("Deposit Details");
        JMenuItem m4 = new JMenuItem("Calculate Bill");

        /* ---- Customer Details ---- */
        m1.setFont(new Font("monospaced", Font.PLAIN, 12));
        // ImageIcon icon1 = new
        // ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
        // Image image1 = icon1.getImage().getScaledInstance(20,
        // 20,Image.SCALE_DEFAULT);
        // m1.setIcon(new ImageIcon(image1));
        m1.setMnemonic(KeyEvent.VK_D);
        m1.setBackground(Color.WHITE);
        m1.setSize(30, 20);
        m1.setFont(f);
        m1.setForeground(c);
        
        /* ---- Meter Details ---- */
        m2.setFont(new Font("monospaced", Font.PLAIN, 12));
        // ImageIcon icon2 = new
        // ImageIcon(ClassLoader.getSystemResource("icon/icon2.png"));
        // Image image2 = icon2.getImage().getScaledInstance(20,
        // 20,Image.SCALE_DEFAULT);
        // m2.setIcon(new ImageIcon(image2));
        m2.setMnemonic(KeyEvent.VK_M);
        m2.setBackground(Color.WHITE);

        /* ---- Deposit Details ----- */
        m3.setFont(new Font("monospaced", Font.PLAIN, 12));
        // ImageIcon icon3 = new
        // ImageIcon(ClassLoader.getSystemResource("icon/icon3.png"));
        // Image image3 = icon3.getImage().getScaledInstance(20,
        // 20,Image.SCALE_DEFAULT);
        // m3.setIcon(new ImageIcon(image3));
        m3.setMnemonic(KeyEvent.VK_D);
        m3.setBackground(Color.WHITE);

        m4.setFont(new Font("monospaced", Font.PLAIN, 12));
        // ImageIcon icon5 = new
        // ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
        // Image image5 = icon5.getImage().getScaledInstance(20,
        // 20,Image.SCALE_DEFAULT);
        // m4.setIcon(new ImageIcon(image5));
        m4.setMnemonic(KeyEvent.VK_C);
        m4.setBackground(Color.WHITE);

        m1.addActionListener(this);
        m2.addActionListener(this);
        m3.addActionListener(this);
        m4.addActionListener(this);

        /* First Column */
        JMenu info = new JMenu("Info");
        info.setFont(new Font("Verdana", Font.PLAIN, 20));
        info.setForeground(Color.WHITE);
        JMenuItem info1 = new JMenuItem("Update");
        JMenuItem info2 = new JMenuItem("View");
        
        /* ---- Pay Bill ---- */
        info1.setFont(new Font("monospaced", Font.PLAIN, 12));
        // ImageIcon icon41 = new
        // ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        // Image image41 = icon41.getImage().getScaledInstance(20,
        // 20,Image.SCALE_DEFAULT);
        // info1.setIcon(new ImageIcon(image41));
        info1.setMnemonic(KeyEvent.VK_U);
        info1.setBackground(Color.WHITE);
        info1.setSize(30, 20);
        info1.setFont(f);
        info1.setForeground(c);

        /* ---- Last Bill ---- */
        info2.setFont(new Font("monospaced", Font.PLAIN, 12));
        // ImageIcon icon42 = new
        // ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        // Image image42 = icon42.getImage().getScaledInstance(20,
        // 20,Image.SCALE_DEFAULT);
        // info2.setIcon(new ImageIcon(image42));
        info2.setMnemonic(KeyEvent.VK_V);
        info2.setBackground(Color.WHITE);
        info2.setSize(30, 20);
        info2.setFont(f);
        info2.setForeground(c);

        info1.addActionListener(this);
        info2.addActionListener(this);

        /* Second Column */
        JMenu user = new JMenu("User");
        user.setFont(new Font("Verdana", Font.PLAIN, 20));
        user.setForeground(Color.WHITE);
        JMenuItem u1 = new JMenuItem("Pay");
        JMenuItem u3 = new JMenuItem("Bill");

        u1.setFont(new Font("monospaced", Font.PLAIN, 12));
        // ImageIcon icon4 = new
        // ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        // Image image4 = icon4.getImage().getScaledInstance(20,
        // 20,Image.SCALE_DEFAULT);
        // u1.setIcon(new ImageIcon(image4));
        u1.setMnemonic(KeyEvent.VK_P);
        u1.setBackground(Color.WHITE);
        u1.setSize(30, 20);
        u1.setFont(f);
        u1.setForeground(c);

        /* ---- Last Bill ---- */
        u3.setFont(new Font("monospaced", Font.PLAIN, 12));
        // ImageIcon icon6 = new
        // ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        // Image image6 = icon6.getImage().getScaledInstance(20,
        // 20,Image.SCALE_DEFAULT);
        // u3.setIcon(new ImageIcon(image6));
        u3.setMnemonic(KeyEvent.VK_B);
        u3.setBackground(Color.WHITE);
        u3.setSize(30, 20);
        u3.setFont(f);
        u3.setForeground(c);

        u1.addActionListener(this);
        u3.addActionListener(this);

        /* Third Column */
        JMenu report = new JMenu("Report");
        report.setFont(new Font("Verdana", Font.PLAIN, 20));
        report.setForeground(Color.WHITE);
        JMenuItem r1 = new JMenuItem("Make Bill");

        /* ---- Report ---- */
        r1.setFont(new Font("monospaced", Font.PLAIN, 12));
        // ImageIcon icon7 = new
        // ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
        // Image image7 = icon7.getImage().getScaledInstance(20,
        // 20,Image.SCALE_DEFAULT);
        // r1.setIcon(new ImageIcon(image7));
        r1.setMnemonic(KeyEvent.VK_M);
        r1.setBackground(Color.WHITE);
        r1.setSize(30, 20);
        r1.setFont(f);
        r1.setForeground(c);

        r1.addActionListener(this);

        /* Fourth Column */
        JMenu utility = new JMenu("Utility");
        utility.setFont(new Font("Verdana", Font.PLAIN, 20));
        utility.setForeground(Color.WHITE);
        JMenuItem ut1 = new JMenuItem("Notepad");
        JMenuItem ut2 = new JMenuItem("Calculator");
        JMenuItem ut3 = new JMenuItem("Web Browser");

        /* ---- Notepad ---- */
        ut1.setFont(new Font("monospaced", Font.PLAIN, 12));
        // ImageIcon icon8 = new
        // ImageIcon(ClassLoader.getSystemResource("icon/icon12.png"));
        // Image image8 = icon8.getImage().getScaledInstance(20,
        // 20,Image.SCALE_DEFAULT);
        // ut1.setIcon(new ImageIcon(image8));
        ut1.setMnemonic(KeyEvent.VK_N);
        ut1.setBackground(Color.WHITE);
        ut1.setSize(30, 20);
        ut1.setFont(f);
        ut1.setForeground(c);

        /* ---- Calculator ---- */
        ut2.setFont(new Font("monospaced", Font.PLAIN, 12));
        // ImageIcon icon9 = new
        // ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
        // Image image9 = icon9.getImage().getScaledInstance(20,
        // 20,Image.SCALE_DEFAULT);
        // ut2.setIcon(new ImageIcon(image9));
        ut2.setMnemonic(KeyEvent.VK_C);
        ut2.setBackground(Color.WHITE);
        ut2.setSize(30, 20);
        ut2.setFont(f);
        ut2.setForeground(c);

        /* ---- Web Browser ---- */
        ut3.setFont(new Font("monospaced", Font.PLAIN, 12));
        // ImageIcon icon10 = new
        // ImageIcon(ClassLoader.getSystemResource("icon/icon10.png"));
        // Image image10 = icon10.getImage().getScaledInstance(20,
        // 20,Image.SCALE_DEFAULT);
        // ut3.setIcon(new ImageIcon(image10));
        ut3.setMnemonic(KeyEvent.VK_W);
        ut3.setBackground(Color.WHITE);
        ut3.setSize(30, 20);
        ut3.setFont(f);
        ut3.setForeground(c);

        ut1.addActionListener(this);
        ut2.addActionListener(this);
        ut3.addActionListener(this);

        /* Fifth Column */
        JMenu exit = new JMenu("Logout");
        exit.setFont(new Font("Verdana", Font.PLAIN, 20));
        exit.setForeground(Color.WHITE);
        JMenuItem ex = new JMenuItem("Logout");

        /* ---- Exit ---- */
        ex.setFont(new Font("monospaced", Font.PLAIN, 12));
        // ImageIcon icon11 = new
        // ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
        // Image image11 = icon11.getImage().getScaledInstance(20,
        // 20,Image.SCALE_DEFAULT);
        // ex.setIcon(new ImageIcon(image11));
        ex.setMnemonic(KeyEvent.VK_L);
        ex.setBackground(Color.WHITE);
        ex.setSize(30, 20);
        ex.setFont(f);
        ex.setForeground(c);
        ex.addActionListener(this);

        master.add(m1);
        master.addSeparator();
        master.add(m2);
        master.addSeparator();
        master.add(m3);
        master.addSeparator();
        master.add(m4);

        info.add(info1);
        info.addSeparator();
        info.add(info2);

        user.add(u1);
        user.addSeparator();
        user.add(u3);

        report.add(r1);

        utility.add(ut1);
        utility.addSeparator();
        utility.add(ut2);
        utility.addSeparator();
        utility.add(ut3);

        exit.add(ex);

        if (person.equals("Admin")) {
            mb.add(master);
        } else {
            mb.add(info);
            mb.add(user);
            mb.add(report);
        }
        mb.add(utility);
        mb.add(exit);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();
        if (msg.equals("Customer Details")) {
            // new CustomerDetails();

        } else if (msg.equals("New Customer")) {
            // new NewCustomer();

        } else if (msg.equals("Calculate Bill")) {
            // new CalculateBill();

        } else if (msg.equals("Pay Bill")) {
            // new PayBill(meter);

        } else if (msg.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec(not);
            } catch (Exception e) {
            }
        } else if (msg.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec(cal);
            } catch (Exception e) {
            }
        } else if (msg.equals("Web Browser")) {
            try {
                Runtime.getRuntime().exec(browser);
            } catch (Exception e) {
            }
        } else if (msg.equals("Logout")) {
            frame.dispose();
            // new Login();
        } else if (msg.equals("Generate Bill")) {
            // new GenerateBill(meter);
        } else if (msg.equals("Deposit Details")) {
            // new DepositDetails();
        } else if (msg.equals("View Information")) {
            // new ViewInformation(meter);
        } else if (msg.equals("Update Info")) {
            // new UpdateInformation(meter);
        } else if (msg.equals("Bill Details")) {
            // new BillDetails(meter);
        }
    }

}

