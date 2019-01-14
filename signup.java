import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class signup extends JFrame implements ActionListener
{JFrame f;
JLabel l1,l2,l3,l4;
JButton b1,b2;
JTextField t1,t2;
JPasswordField t3;
signup()
{f=new JFrame("Signup Panel");
f.setLayout(new BorderLayout());
l4=new JLabel(new ImageIcon("images/a3.jpg"));
f.setContentPane(l4);
f.setLayout(new FlowLayout(FlowLayout.CENTER,50,50));
l1=new JLabel("Roll Number");
l2=new JLabel("Username");
l3=new JLabel("Password");

t1=new JTextField(10);
t2=new JTextField(10);
t3=new JPasswordField(10);
b1=new JButton("Signup");
b2=new JButton("Reset");
f.add(l1);
f.add(t1);
f.add(l2);
f.add(t2);
f.add(l3);
f.add(t3);
f.add(b1);
f.add(b2);

b1.addActionListener(this);
b2.addActionListener(this);
t1.requestFocus();

f.setSize(300,400);
f.setLocation(200,50);
f.setVisible(true);
f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
}
public void actionPerformed(ActionEvent a)
{if(a.getSource()==b1)
{try{
connect c1=new connect();
String qry="update stud set uname='"+t2.getText()+"',pass='"+t3.getText()+"' where rno="+t1.getText()+" and uname is null";
c1.update(qry);
JOptionPane.showMessageDialog(null,"Signup done Succesfully");

}
catch(Exception e)
{System.out.println(e);}
}
else
{}
t1.setText("");
t2.setText("");
t3.setText("");
t1.requestFocus();
}
public static void main(String s[])
{signup sg=new signup();}

}