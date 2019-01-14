import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class adminseat extends JFrame
{JLabel l2;
JFrame f;
JPanel jf;
adminseat()
{f=new JFrame("Admin Seating Plan");
f.setLayout(new BorderLayout());
l2=new JLabel(new ImageIcon("images/a5.jpg"));
f.setContentPane(l2);
f.setLayout(new FlowLayout());
seatplan sp=new seatplan();

JLabel la=new JLabel("Welcome Admin",JLabel.CENTER);
la.setFont(new Font("BatmanForeverOutline", Font.BOLD,60));
la.setForeground(Color.white);

jf=new JPanel(new BorderLayout(10,20));

jf.add(la,BorderLayout.NORTH);
jf.add(sp.jp,BorderLayout.CENTER);
f.add(jf);
jf.setOpaque(false);

int p;
for(p=0;p<sp.len;p++)
{sp.jp2.add(sp.box[p]);}

f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
f.setVisible(true);

//f.setSize(1500,1500);
Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
f.setSize(screenSize.width,screenSize.height);
}
public static void main(String s[])
{adminseat as=new adminseat();}

}