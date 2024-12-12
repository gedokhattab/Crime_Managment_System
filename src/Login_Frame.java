import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


public class Login_Frame extends JFrame {
    ImageIcon logo = new ImageIcon("Images/logo.png");
    ImageIcon FCISLogo = new ImageIcon("Images/FCIS.png");
    JLabel MOI = new JLabel();
    JLabel FCIS = new JLabel();
    JPanel bgr = new JPanel();

    //JPanel northPanel = new JPanel();
    //JPanel southPanel = new JPanel();
    //JPanel eastPanel = new JPanel();
    //JPanel westPanel = new JPanel();
    Login_Frame() {

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(d.width + 50, d.height - 40);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(new Color(0xF5F5F5));
        this.setVisible(true);
        this.setTitle("Crime Management System");
        this.setResizable(false);

        //northPanel.setSize(d.width,500);
        //southPanel.setSize(d.width,500);
        //eastPanel.setSize(500,d.height);
        //westPanel.setSize(500,d.height);

        MOI.setSize(100, 100);
        MOI.setBounds(50, 50, 100, 100);
        MOI.setIcon(logo);

        FCIS.setSize(100, 100);
        FCIS.setBounds(d.width - 150, 50, 100, 100);
        FCIS.setIcon(FCISLogo);

        bgr.setBounds(0, 100, d.width - 200, d.height - 200);
        bgr.setBackground(new Color(0x0D2C54));
        bgr.setOpaque(true);

        this.add(MOI);
        this.add(FCIS);
        //this.add(northPanel,BorderLayout.NORTH);
        //this.add(southPanel,BorderLayout.SOUTH);
        //this.add(eastPanel,BorderLayout.EAST);
        //this.add(westPanel,BorderLayout.WEST);
        this.add(bgr);
        this.setIconImage(logo.getImage());


        Border border = BorderFactory.createLineBorder(new Color(0x6A1017), 5);

        JLabel label = new JLabel();
        label.setText("Hello");//set text for label
        label.setIcon(logo);//set icon
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setForeground(Color.red);//set font color of the text
        label.setFont(new Font("MV Boli", Font.PLAIN, 20));//set font of text
        label.setIconTextGap(-25);//set gap of text to image
        label.setBackground(Color.black);//set background color
        label.setOpaque(true);//display background color
        label.setBorder(border);//sets border of label
        label.setHorizontalAlignment(JLabel.CENTER);//set horizontal position of icon+text within label
        label.setVerticalAlignment(JLabel.CENTER);//set vertical position of icon+text within label
        label.setBounds(100, 100, 250, 250);

        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.RED);
        redPanel.setBounds(0, 0, 250, 250);
        redPanel.setLayout(null);


    }
}
