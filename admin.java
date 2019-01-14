import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class admin extends JFrame implements ActionListener
{JFrame f;
JLabel l1,l2;
JButton b1,b2,b3,b4,b5;
admin()
{f=new JFrame("Admin Panel");
f.setLayout(new BorderLayout());
l2=new JLabel(new ImageIcon("images/a3.jpg"));
f.setContentPane(l2);
f.setLayout(new FlowLayout(FlowLayout.CENTER,150,40));
b1=new JButton("Add Student");
b2=new JButton("Modify Student");
b3=new JButton("Delete Student");
b4=new JButton("Specify Rooms");
b5=new JButton("Show Seating Plan");
l1=new JLabel("Welcome Admin");
l1.setFont(new Font("BatmanForeverOutline", Font.BOLD,30));
l1.setForeground(Color.white);
f.add(l1);
f.add(b1);
f.add(b2);
f.add(b3);
f.add(b4);
f.add(b5);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
b5.addActionListener(this);

f.setSize(400,500);
f.setLocation(400,50);
f.setVisible(true);
f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
}
public void actionPerformed(ActionEvent a)
{if(a.getSource()==b1)
{addstudent ads=new addstudent();}
else if(a.getSource()==b2)
{modifystudent ms=new modifystudent();}
else if(a.getSource()==b3)
{deletestudent ds=new deletestudent();}
else if(a.getSource()==b4)
{specify sp=new specify();}
else if(a.getSource()==b5)
{adminseat as=new adminseat();}
}
public static void main(String s[])
{admin ad=new admin();}
}