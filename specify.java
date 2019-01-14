import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class specify extends JFrame implements ActionListener
{JFrame f;
JLabel l1,l2,l3,l4;
JButton b1,b2;
JTextField t2,t3,t4;
specify()
{f=new JFrame("Specify Rooms");
f.setLayout(new BorderLayout());
l1=new JLabel(new ImageIcon("images/a3.jpg"));
f.setContentPane(l1);
f.setLayout(new FlowLayout());
l2=new JLabel("Enter No. of Rooms");
l3=new JLabel("Enter No. of Rows in each Room");
l4=new JLabel("Enter No. of Columns in each Room");
t2=new JTextField(18);
t3=new JTextField(18);
t4=new JTextField(18);
b1=new JButton("Specify");
b2=new JButton("Reset");

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

t2.requestFocus();

f.setSize(250,300);
f.setLocation(500,200);
f.setVisible(true);
f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
}
public void actionPerformed(ActionEvent a)
{
if(a.getSource()==b1)
{String q="select * from rooms";
try
{connect c1=new connect();
ResultSet r=c1.execute(q);
if(r.next())
{String qry="update rooms set room="+t2.getText()+", row="+t3.getText()+", col="+t4.getText();
c1.update(qry);
JOptionPane.showMessageDialog(null,"Rooms Specified Successfully");
}
else
{String qry="insert into rooms values("+t2.getText()+","+t3.getText()+","+t4.getText()+")";
c1.update(qry);
JOptionPane.showMessageDialog(null,"Rooms Inserted Successfully");
}
}
catch(Exception e)
{System.out.println(e);}

}

else if(a.getSource()==b2)
{}
t2.setText("");
t3.setText("");
t4.setText("");
t2.requestFocus();
}

public static void main(String s[])
{specify sp=new specify();}
}