import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class seatplan implements ActionListener,MouseListener
{static int x=0,y=1,z=0;
static int rooms,rows,cols;
static String[][][] data;
static JLabel[][][] label;
static JPanel[] panel;
static JPanel jp;
static JPanel jp2;
static JPanel box[];
static ImageIcon i1,i2,i3,i4,i5,i6,ig;
static JButton b1,b2;
static JLabel l1,l2;
static JTextField t1;
static int len;
static int flag1=0;

public void setdata()
{
int i,j,k;

try
{connect c1=new connect();
String q="Select * from rooms";
ResultSet r=c1.execute(q);
if(r.next())
{rooms=r.getInt("room");
rows=r.getInt("row")+1;
cols=r.getInt("col");}

}
catch(Exception e)
{System.out.println(e);}

data=new String[rooms][rows][cols];
label=new JLabel[rooms][rows][cols];
panel=new JPanel[rooms];
len=rooms;

i1=new ImageIcon("images/CSE.jpg");
i2=new ImageIcon("images/ECE.jpg");
i3=new ImageIcon("images/MECH.jpg");
i4=new ImageIcon("images/select.jpg");
i5=new ImageIcon("images/blank.jpg");
i6=new ImageIcon("images/row.jpg");
ig=new ImageIcon("images/CSE.jpg");

try
{connect c2=new connect();
connect c3=new connect();
connect c4=new connect();
String q1="Select * from stud where branch='CSE'";
String q2="Select * from stud where branch='ECE'";
String q3="Select * from stud where branch='MECH'";
ResultSet rs1=c2.execute(q1);
ResultSet rs2=c3.execute(q2);
ResultSet rs3=c4.execute(q3);

boolean a=true,b=true,c=true;

int count=1,cnt=1;
String na="-----";
for(i=0;i<rooms;i++)
{count=1;cnt=1;
 for(k=0;k<cols;k++)
{
for(j=0;j<rows;j++)
{if(j==0)
{data[i][j][k]="Row "+(k+1);
label[i][j][k]=new JLabel(data[i][j][k],i6,JLabel.CENTER);
label[i][j][k].setVerticalAlignment(JLabel.BOTTOM);
label[i][j][k].setHorizontalTextPosition(JLabel.CENTER);
label[i][j][k].setVerticalTextPosition(JLabel.CENTER);
j++;}

if(cnt==1)
{if(a && rs1.next())
{
data[i][j][k]=rs1.getString("rno");
label[i][j][k]=new JLabel(data[i][j][k],i1,JLabel.CENTER);
label[i][j][k].addMouseListener(this);
}
else
{data[i][j][k]=new String(na);
label[i][j][k]=new JLabel(na,i5,JLabel.CENTER);
a=false;
}

cnt=2;}
else if(cnt==2)
{
if(b && rs2.next())
{data[i][j][k]=rs2.getString("rno");
label[i][j][k]=new JLabel(data[i][j][k],i2,JLabel.CENTER);
label[i][j][k].addMouseListener(this);
}
else
{data[i][j][k]=new String(na);
label[i][j][k]=new JLabel(na,i5,JLabel.CENTER);
b=false;
}
cnt=3;

}
else if(cnt==3)
{
if(c && rs3.next())
{data[i][j][k]=rs3.getString("rno");
label[i][j][k]=new JLabel(data[i][j][k],i3,JLabel.CENTER);
label[i][j][k].addMouseListener(this);
}
else
{data[i][j][k]=new String(na);
label[i][j][k]=new JLabel(na,i5,JLabel.CENTER);
c=false;
}
cnt=1;
}

label[i][j][k].setHorizontalTextPosition(JLabel.CENTER);
label[i][j][k].setVerticalTextPosition(JLabel.CENTER);
label[i][j][k].setFont(new Font("Verdana", Font.PLAIN,18));
label[i][j][k].setForeground(Color.cyan);
}
if(count==1)
{cnt=2;
count=2;}
else if(count==2)
{cnt=3;
count=3;}
else if(count==3)
{cnt=1;
count=1;}

}
if(a||b||c)
{}
else
{len=i+1;
break;}

}

}
catch(Exception e)
{System.out.println(e);}

for(i=0;i<len;i++)
{panel[i]=new JPanel(new GridLayout(rows,cols,1,1));
panel[i].setOpaque(false);
for(j=0;j<rows;j++)
{for(k=0;k<cols;k++)
{panel[i].add(label[i][j][k]);}}}

}


seatplan()
{

jp=new JPanel(new BorderLayout(2,2));
JPanel jp1=new JPanel(new FlowLayout(FlowLayout.CENTER,20,10));
l1=new JLabel("Enter Roll No. to Search ");
t1=new JTextField(15);
l1.setFont(new Font("Dialog", Font.BOLD,18));
l1.setForeground(Color.white);
b1=new JButton("Search");
b2=new JButton("Reset");
b1.addActionListener(this);
b2.addActionListener(this);
jp1.add(l1);
jp1.add(t1);
jp1.add(b1);
jp1.add(b2);
jp1.setOpaque(false);
t1.requestFocus();
setdata();
jp.add(jp1,BorderLayout.NORTH);

jp2=new JPanel(new FlowLayout(FlowLayout.CENTER,25,30));
box=new JPanel[rooms];
JLabel head[]=new JLabel[rooms];
for(int p=0;p<len;p++)
{head[p]=new JLabel("Room "+(p+1));
head[p].setFont(new Font("Dialog", Font.PLAIN,18));
head[p].setForeground(Color.white);
box[p] = new JPanel();
box[p].setLayout(new FlowLayout());
box[p].add(head[p]);
box[p].add(panel[p]);

box[p].setOpaque(false);
}

JPanel jp3=new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
JLabel lp1,lp2,lp3;
lp1=new JLabel("CSE Student");
lp2=new JLabel("ECE Student");
lp3=new JLabel("Mech Student");

jp3.add(new JLabel(i1));
jp3.add(lp1);
jp3.add(new JLabel(i2));
jp3.add(lp2);
jp3.add(new JLabel(i3));
jp3.add(lp3);

lp1.setForeground(Color.white);
lp2.setForeground(Color.white);
lp3.setForeground(Color.white);

int v1=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
int h1=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
JScrollPane jsp=new JScrollPane(jp2,v1,h1);
jp.setPreferredSize(new Dimension(1200,585));
jsp.setOpaque(false);
jsp.getViewport().setOpaque(false);

jp.add(jsp,BorderLayout.CENTER);
jp.add(jp3,BorderLayout.SOUTH);


jp2.setOpaque(false);
jp3.setOpaque(false);
jp.setOpaque(false);


}

public void actionPerformed(ActionEvent ae)
{label[x][y][z].setIcon(ig);
if(ae.getSource()==b1)
{String num=t1.getText();
flag1=0;
for(x=0;x<len;x++)
{for(y=1;y<rows;y++)
{for(z=0;z<cols;z++)
{if(data[x][y][z].equals(num))
{flag1=1;
break;}
}
if(flag1==1)
{break;}
}
if(flag1==1)
{break;}
}

if(flag1==0)
{JOptionPane.showMessageDialog(null,"Student Record Not Found");
x=0;y=1;z=0;
ig=i1;}
else
{ig=(ImageIcon)label[x][y][z].getIcon();
label[x][y][z].setIcon(i4);}

}

else
{t1.setText("");
t1.requestFocus();}

}

public void mousePressed(MouseEvent m)
{JLabel jl=(JLabel)m.getComponent();
String num=jl.getText();
show sh=new show(num);}

public void mouseClicked(MouseEvent m){}    
public void mouseEntered(MouseEvent m){}
public void mouseExited(MouseEvent m){} 
public void mouseReleased(MouseEvent m){}

public static void main(String S[])
{seatplan sp=new seatplan();}

}