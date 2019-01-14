import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class login extends JFrame implements ActionListener
{JFrame f;

JLabel l1,l2,l3;
JTextField t1;
JPasswordField t2;
JButton b1,b2;
JRadioButton rb1,rb2;
login()
{f=new JFrame("Login Seating Plan Project");
f.setLayout(new BorderLayout());
l3=new JLabel(new ImageIcon("images/a3.jpg"));
f.setContentPane(l3);
f.setLayout(null);
b1=new JButton("Login");
b2=new JButton("Signup");
l1=new JLabel("Username");
l2=new JLabel("Password");
t1=new JTextField(20);
t2=new JPasswordField(15);
rb1=new JRadioButton("Admin",true);
rb2=new JRadioButton("Student");
ButtonGroup bg=new ButtonGroup();
bg.add(rb1);
bg.add(rb2);
f.add(rb1);
f.add(rb2);
f.add(l1);
f.add(l2);
f.add(t1);
f.add(t2);
f.add(b1);
f.add(b2);
rb1.setBounds(60,50,100,40);
rb2.setBounds(200,50,100,40);
l1.setBounds(60,100,150,20);
l2.setBounds(60,150,150,20);
t1.setBounds(250,100,200,20);
t2.setBounds(250,150,200,20);
b1.setBounds(80,250,150,60);
b2.setBounds(260,250,150,60);
t1.requestFocus();

rb1.setOpaque(false);
rb2.setOpaque(false);

b1.addActionListener(this);
b2.addActionListener(this);

f.setSize(500,400);
f.setLocation(300,100);
f.setVisible(true);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}
public void actionPerformed(ActionEvent a)
{if(a.getSource()==b1)
{String uname=t1.getText();
String pass=t2.getText();
if(rb1.isSelected())
{String qry="Select * from admin where uname='"+uname+"'and pass='"+pass+"'";
try
{connect c1=new connect();
ResultSet rs=c1.execute(qry);
if(rs.next())
{JOptionPane.showMessageDialog(null,"Valid Admin User");
admin ad=new admin();}
else
{JOptionPane.showMessageDialog(null,"Invalid Admin User");}
}
catch(Exception e)
{System.out.println(e);}
}
else
{String qry="Select * from stud where uname='"+uname+"'and pass='"+pass+"'";
try
{connect c1=new connect();
ResultSet rs=c1.execute(qry);
if(rs.next())
{JOptionPane.showMessageDialog(null,"Valid Student User");
student sd=new student();}
else
{JOptionPane.showMessageDialog(null,"Invalid Student User");}
}
catch(Exception e)
{System.out.println(e);}

}
}
else if(a.getSource()==b2)
{signup sg=new signup();}
t1.setText("");
t2.setText("");
rb1.setSelected(true);
t1.requestFocus();
}
public static void main(String s[])
{login lg=new login();}
}