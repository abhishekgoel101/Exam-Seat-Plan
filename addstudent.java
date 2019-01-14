import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class addstudent extends JFrame implements ActionListener
{JFrame f;
JLabel l1,l2,l3,l4,l5,l6,l7,l8;
JButton b1,b2;
JTextField t1,t2,t3,t4,t5,t6;
JRadioButton rb1,rb2,rb3;
ButtonGroup bg;
addstudent()
{f=new JFrame("Add Student");
f.setLayout(new BorderLayout());
l8=new JLabel(new ImageIcon("images/a3.jpg"));
f.setContentPane(l8);
f.setLayout(new FlowLayout());
l1=new JLabel("Roll No.");
l2=new JLabel("Name");
l3=new JLabel("Class Name");
l4=new JLabel("Exam Code");
l5=new JLabel("Date");
l6=new JLabel("Time");
l7=new JLabel("Branch");
t1=new JTextField(15);
t2=new JTextField(15);
t3=new JTextField(13);
t4=new JTextField(14);
t5=new JTextField(15);
t6=new JTextField(15);
b1=new JButton("Add Student");
b2=new JButton("Reset");
rb1=new JRadioButton("CSE",true);
rb1.setActionCommand("CSE");
rb2=new JRadioButton("ECE");
rb2.setActionCommand("ECE");
rb3=new JRadioButton("MECH");
rb3.setActionCommand("MECH");

bg=new ButtonGroup();
bg.add(rb1);
bg.add(rb2);
bg.add(rb3);
f.add(l1);
f.add(t1);
f.add(l2);
f.add(t2);
f.add(l7);
f.add(rb1);
f.add(rb2);
f.add(rb3);
f.add(l3);
f.add(t3);
f.add(l4);
f.add(t4);
f.add(l5);
f.add(t5);
f.add(l6);
f.add(t6);
f.add(b1);
f.add(b2);

rb1.setOpaque(false);
rb2.setOpaque(false);
rb3.setOpaque(false);
b1.addActionListener(this);
b2.addActionListener(this);

t1.requestFocus();

f.setSize(250,400);
f.setLocation(400,150);
f.setVisible(true);
f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
}
public void actionPerformed(ActionEvent a)
{if(a.getSource()==b1)
{String choice=bg.getSelection().getActionCommand();
String qry="insert into stud (rno,name,branch,class,ecode,date,time) values("+t1.getText()+",'"+t2.getText()+"','"+choice+"','"+t3.getText()+"','"+t4.getText()+"','"+t5.getText()+"','"+t6.getText()+"')";
String qry1="alter table stud order by rno";
try
{connect c1=new connect();
c1.update(qry);
c1.update(qry1);
JOptionPane.showMessageDialog(null,"Student Added Successfully");
}
catch(Exception e)
{System.out.println(e);}
}

else if(a.getSource()==b2)
{
}
t1.setText("");
t2.setText("");
t3.setText("");
t4.setText("");
t5.setText("");
t6.setText("");
rb1.setSelected(true);
t1.requestFocus();

}
public static void main(String s[])
{addstudent ads=new addstudent();}
}