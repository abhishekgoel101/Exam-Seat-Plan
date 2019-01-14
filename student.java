import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class student extends JFrame implements ActionListener
{JFrame f;
JLabel l2,ls;
static int flag=0;
seatplan sp;
JPanel jf;
JMenuBar mb;
JMenuItem m1;
student()
{f=new JFrame("Student Panel");
f.setLayout(new BorderLayout());
l2=new JLabel(new ImageIcon("images/a5.jpg"));
f.setContentPane(l2);

mb=new JMenuBar();
f.setJMenuBar(mb);
m1=new JMenuItem("Change Username  OR  Password");

/*MenuItem m1=new MenuItem("Change Username or Password"); 
MenuItem m2=new MenuItem("Password");
mn.add(m1);
mn.add(m2);
m1.addActionListener(this);
m2.addActionListener(this);
*/

mb.add(m1);
m1.addActionListener(this);

ls=new JLabel("Welcome Student",JLabel.CENTER);
ls.setFont(new Font("BatmanForeverOutline", Font.BOLD,60));
ls.setForeground(Color.white);

jf=new JPanel(new BorderLayout(10,20));
f.setLayout(new FlowLayout());
sp=new seatplan();
jf.add(ls,BorderLayout.NORTH);
jf.add(sp.jp,BorderLayout.CENTER);
f.add(jf);
jf.setOpaque(false);

for(ActionListener al : sp.b1.getActionListeners()) 
{sp.b1.removeActionListener( al );}

for(ActionListener al : sp.b2.getActionListeners()) 
{sp.b2.removeActionListener(al);}

sp.b1.addActionListener(this);
sp.b2.addActionListener(this);

f.setSize(1500,1500);
f.setVisible(true);
f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

}

public void actionPerformed(ActionEvent a)
{
if(a.getSource()==m1)
{change ch=new change();}
else
{
if(flag==1)
{sp.jp2.remove(sp.box[sp.x]);}

sp.actionPerformed(a);

if(a.getSource()==sp.b1 && sp.flag1==1)
{sp.jp2.add(sp.box[sp.x]);
flag=1;}
else
{flag=0;}

sp.jp2.revalidate();
sp.jp2.repaint();

}


}

public static void main(String s[])
{student sd=new student();}

}