import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class deletestudent extends JFrame implements ActionListener
{JFrame f;
JLabel l1,l2,l3,l4,l5,l6;
JButton b1,b2,b3;
JTextField t1,t2,t3,t4,t5;
deletestudent()
{f=new JFrame("Delete Student");
f.setLayout(new BorderLayout());
l6=new JLabel(new ImageIcon("images/a3.jpg"));
f.setContentPane(l6);
f.setLayout(new FlowLayout());
l5=new JLabel("Enter Roll No. to Search                         ");
l1=new JLabel("Roll No.");
l2=new JLabel("Name");
l3=new JLabel("Branch");
l4=new JLabel("Class Name");
t5=new JTextField(12);
t1=new JTextField(15);
t2=new JTextField(16);
t3=new JTextField(15);
t4=new JTextField(13);
b1=new JButton("Delete Student");
b2=new JButton("Reset");
b3=new JButton("Search");

f.add(l5);
f.add(t5);
f.add(b3);
f.add(l1);
f.add(t1);
f.add(l2);
f.add(t2);
f.add(l3);
f.add(t3);
f.add(l4);
f.add(t4);
f.add(b1);
f.add(b2);

b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
t5.requestFocus();

f.setSize(250,400);
f.setLocation(400,150);
f.setVisible(true);
f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
}
public void actionPerformed(ActionEvent a)
{String no=t5.getText();
if(a.getSource()==b3)
{String qry="select * from stud where rno="+no;
try
{connect c1=new connect();
ResultSet rs=c1.execute(qry);
if(rs.next())
{t1.setText(rs.getString("rno"));
t2.setText(rs.getString("name"));
t3.setText(rs.getString("branch"));
t4.setText(rs.getString("class"));
}
else
{JOptionPane.showMessageDialog(null,"Student Record not found");}
}
catch(Exception e)
{System.out.println(e);}
}

else if(a.getSource()==b1)
{String qry="delete from stud where rno="+no;
String qry1="alter table stud order by rno";
try
{connect c1=new connect();
c1.update(qry);
c1.update(qry1);
JOptionPane.showMessageDialog(null,"Student Record Deleted Successfully");
}
catch(Exception e)
{System.out.println(e);}
t1.setText("");
t2.setText("");
t3.setText("");
t4.setText("");
t5.setText("");

t5.requestFocus();
}

else if(a.getSource()==b2)
{t1.setText("");
t2.setText("");
t3.setText("");
t4.setText("");
t5.setText("");

t5.requestFocus();
}

}
public static void main(String s[])
{deletestudent ds=new deletestudent();}
}