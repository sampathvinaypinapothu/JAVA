import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Sample2 extends JFrame implements ActionListener
{
    JTextField t1,t2,t3;
    JButton b1,b2;
    Sample2()
    {
        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        b1=new JButton("+");
        b2=new JButton("-");
        t1.setBounds(150,50,100,30);
        t2.setBounds(150,100,100,30);
        t3.setBounds(150,150,100,30);
        b1.setBounds(150,200,50,20);
        b2.setBounds(200,200,50,20);
        add(t1);
        add(t2);
        add(t3);
        add(b1);
        add(b2);
        setTitle("Calculator");
        setSize(500,600);
        b1.addActionListener(this); //regestering the component with the listener
        b2.addActionListener(this);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    //interface implementation
    public void actionPerformed(ActionEvent e)
    {
        String s1=t1.getText();
        String s2=t2.getText();
        int a=Integer.parseInt(s1);
        int b=Integer.parseInt(s2);
        int c=0;
        if(e.getSource()==b1) 
        {
            c=a+b;
        }
        else 
        {
            c=a-b;
        }
        String result=String.valueOf(c);
        t3.setText(result);
    }
     public static void main(String[] args) {
        new Sample2();
     }
}
