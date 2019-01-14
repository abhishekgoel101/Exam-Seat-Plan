import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class show extends JFrame implements ActionListener
{JFrame f;
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
JButton b1;
JTextField t2,t3,t4,t5,t6,t7,t8;
show(String no)
{f=new JFrame("Show Student Details");
f.setLayout(new BorderLayout());
l1=new JLabel(new ImageIcon("images/a3.jpg"));
f.setContentPane(l1);
f.setLayout(new FlowLayout());
l9=new JLabel("      Student's Details                           ");
l2=new JLabel("Roll No.");
l3=new JLabel("Name");
l4=new JLabel("Branch ");
l5=new JLabel("Class Name");
l6=new JLabel("Exam Code");
l7=new JLabel("Date ");
l8=new JLabel("Time ");

t2=new JTextField(15);
t3=new JTextField(16);
t4=new JTextField(15);
t5=new JTextField(13);
t6=new JTextField(13);
t7=new JTextField(16);
t8=new JTextField(16);
b1=new JButton("OK");

f.add(l9);
f.add(l2);
f.add(t2);
f.add(l3);
f.add(t3);
f.add(l4);
f.add(t4);
f.add(l5);
f.add(t5);
f.add(l6);
f.add(t6);
f.add(l7);
f.add(t7);
f.add(l8);
f.add(t8);
f.add(b1);
b1.addActionListener(this);
b1.requestFocus();

String qry="select * from stud where rno="+no;
try
{connect c1=new connect();
ResultSet rs=c1.execute(qry);
if(rs.next())
{t2.setText(rs.getString("rno"));
t3.setText(rs.getString("name"));
t4.setText(rs.getString("branch"));
t5.setText(rs.getString("class"));
t6.setText(rs.getString("ecode"));
t7.setText(rs.getString("date"));
t8.setText(rs.getString("time"));
}
else
{JOptionPane.showMessageDialog(null,"Student Record not found");}
}
catch(Exception e)
{System.out.println(e);}

f.setSize(250,400);
f.setLocation(400,150);
f.setVisible(true);
f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

}
public void actionPerformed(ActionEvent a)
{
if(a.getSource()==b1)
{f.dispose();  }

}
public static void main(String s[])
{show sh=new show("101");}
}