import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class change extends JFrame implements ActionListener
{JFrame f;
JLabel l1,l2,l3,l4,l5,l6;
JButton b1,b2,b3;
JTextField t1,t2,t3,t4,t5;

change()
{f=new JFrame("Change");
f.setLayout(new BorderLayout());
l6=new JLabel(new ImageIcon("images/a3.jpg"));
f.setContentPane(l6);
f.setLayout(new FlowLayout(FlowLayout.CENTER,40,10));
l1=new JLabel("Roll Number");
l2=new JLabel("Old Username");
l3=new JLabel("Old Password");
l4=new JLabel("New Username");
l5=new JLabel("New Password");

t1=new JTextField(10);
t2=new JTextField(10);
t3=new JTextField(10);
t4=new JTextField(10);
t5=new JTextField(10);

b1=new JButton("Search");
b2=new JButton("Change");
b3=new JButton("Reset");
f.add(l1);
f.add(t1);
f.add(l2);
f.add(t2);
f.add(l3);
f.add(t3);
f.add(b1);
f.add(l4);
f.add(t4);
f.add(l5);
f.add(t5);
f.add(b2);
f.add(b3);

b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
t1.requestFocus();

f.setSize(250,500);
f.setLocation(200,50);
f.setVisible(true);
f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
}
public void actionPerformed(ActionEvent a)
{String rno=new String(t1.getText());
String ouname=new String(t2.getText());
String opass=new String(t3.getText());
String nuname=new String(t4.getText());
String npass=new String(t5.getText());
if(a.getSource()==b1)
{
try{
connect c1=new connect();
String qry="select * from stud where rno="+rno+" and uname='"+ouname+"' and pass='"+opass+"'";

ResultSet rs=c1.execute(qry);
if(!(rs.next()))
{JOptionPane.showMessageDialog(null,"Student Record Not Found");}
else
{t4.setText(rs.getString("uname"));
t5.setText(rs.getString("pass"));
}

}
catch(Exception e)
{System.out.println(e);}
}
else
{if(a.getSource()==b2)
{
try
{connect c1=new connect();
String qry="update stud set uname='"+nuname+"' ,pass='"+npass+"' where rno="+rno+" and uname='"+ouname+"' and pass='"+opass+"'";
c1.update(qry);

JOptionPane.showMessageDialog(null,"Details Changed Successfully");
}
catch(Exception e)
{System.out.println(e);}

}
else
{}
t1.setText("");
t2.setText("");
t3.setText("");
t4.setText("");
t5.setText("");
t1.requestFocus();
}

}


public static void main(String s[])
{change ch=new change();}

}