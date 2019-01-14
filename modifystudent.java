import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class modifystudent extends JFrame implements ActionListener
{JFrame f;
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
JButton b1,b2,b3;
JTextField t1,t2,t3,t4,t5,t6,t7;
JRadioButton rb1,rb2,rb3;
ButtonGroup bg;
modifystudent()
{f=new JFrame("Modify Student");
f.setLayout(new BorderLayout());
l9=new JLabel(new ImageIcon("images/a3.jpg"));
f.setContentPane(l9);
f.setLayout(new FlowLayout());
l8=new JLabel("Enter Roll No. to Search                         ");
l1=new JLabel("Roll No.");
l2=new JLabel("Name");
l3=new JLabel("Class Name");
l4=new JLabel("Exam Code");
l5=new JLabel("Date");
l6=new JLabel("Time");
l7=new JLabel("Branch");
t7=new JTextField(12);
t1=new JTextField(15);
t2=new JTextField(16);
t3=new JTextField(13);
t4=new JTextField(13);
t5=new JTextField(16);
t6=new JTextField(16);
b1=new JButton("Modify Student");
b2=new JButton("Reset");
b3=new JButton("Search");
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
f.add(l8);
f.add(t7);
f.add(b3);
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
b3.addActionListener(this);
t7.requestFocus();

f.setSize(250,400);
f.setLocation(400,150);
f.setVisible(true);
f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
}
public void actionPerformed(ActionEvent a)
{String no=t7.getText();
if(a.getSource()==b3)
{String qry="select * from stud where rno="+no;
try
{connect c1=new connect();
ResultSet rs=c1.execute(qry);
if(rs.next())
{t1.setText(rs.getString("rno"));
t2.setText(rs.getString("name"));
String c=rs.getString("branch");
if(c.equals("CSE"))
{rb1.setSelected(true);}
else if(c.equals("ECE"))
{rb2.setSelected(true);}
else
{rb3.setSelected(true);}
t3.setText(rs.getString("class"));
t4.setText(rs.getString("ecode"));
t5.setText(rs.getString("date"));
t6.setText(rs.getString("time"));
}
else
{JOptionPane.showMessageDialog(null,"Student Record not found");}
}
catch(Exception e)
{System.out.println(e);}
}

else if(a.getSource()==b1)
{String choice=bg.getSelection().getActionCommand();
String qry="update stud set rno="+t1.getText()+",name='"+t2.getText()+"',branch='"+choice+"',class='"+t3.getText()+"',ecode='"+t4.getText()+"',date='"+t5.getText()+"',time='"+t6.getText()+"' where rno="+no;
String qry1="alter table stud order by rno";
try
{connect c1=new connect();
c1.update(qry);
c1.update(qry1);
JOptionPane.showMessageDialog(null,"Student Record Updated Successfully");
}
catch(Exception e)
{System.out.println(e);}
t1.setText("");
t2.setText("");
t3.setText("");
t4.setText("");
t5.setText("");
t6.setText("");
t7.setText("");
rb1.setSelected(true);
t7.requestFocus();

}

else if(a.getSource()==b2)
{t1.setText("");
t2.setText("");
t3.setText("");
t4.setText("");
t5.setText("");
t6.setText("");
t7.setText("");
rb1.setSelected(true);
t7.requestFocus();
}

}
public static void main(String s[])
{modifystudent ms=new modifystudent();}
}