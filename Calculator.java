import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Calculator implements ActionListener
{
    JTextField tf;
    JButton jb;
    JFrame jf;
    JPanel jp1;
    JButton numberButtons[]=new JButton[10];
    JButton functionButtons[]=new JButton[8];
    JButton addition,subtraction,multiplication,division;
    JButton decimal,equal,delete,clear;
    JPanel jp;
    double num1=0,num2=0,result=0;
    char operator;
    Font myfont=new Font("Calibri",Font.BOLD,23);
    Calculator()
    {
        jp1=new JPanel();
        jf=new JFrame();
        ImageIcon icon=new ImageIcon("C:\\R (1) (1).png");
        tf=new JTextField();
        jf.setSize(400,500);
        jf.setTitle("Calculator");
        jf.setVisible(true);
        jf.setLayout(null);
        //adding the jp1 components
        jf.add(jp1);
        jp1.setBounds(0,0,400,500);
        jp1.setLayout(null);
        jp1.setBackground(Color.GRAY);
        //text field components
        jf.add(tf);
        tf.setBounds(80,60,240,40);
        tf.setFont(myfont);
        //adding the function buttons to frame
        addition=new JButton("+");
        subtraction=new JButton("-");
        multiplication=new JButton("*");
        division=new JButton("/");
        decimal=new JButton(".");
        equal=new JButton("=");
        delete=new JButton("delete");
        clear=new JButton("clear");
        //addition=new JButton();

        functionButtons[0]=addition;
        functionButtons[1]=subtraction;
        functionButtons[2]=multiplication;
        functionButtons[3]=division;
        functionButtons[4]=decimal;
        functionButtons[5]=equal;
        functionButtons[6]=delete;
        functionButtons[7]=clear;
        //registering the components with listeners
        for(int i=0;i<8;i++)
        {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myfont);
            functionButtons[i].setFocusable(false);
        }
        for(int i=0;i<10;i++)
        {
            numberButtons[i]=new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myfont);
            numberButtons[i].setFocusable(false);
        }
        //adding the panel 
        jp=new JPanel();
        jf.add(jp);
        jp.setBounds(80,110,240,220);
        jp.setLayout(new GridLayout(4,4,11,11));
        jp.setBackground(Color.GRAY);
        //adding the buttons to the panel 
        jp.add(numberButtons[1]);
        jp.add(numberButtons[2]);
        jp.add(numberButtons[3]);
        jp.add(addition);
        jp.add(numberButtons[4]);
        jp.add(numberButtons[5]);
        jp.add(numberButtons[6]);
        jp.add(subtraction);
        jp.add(numberButtons[7]);
        jp.add(numberButtons[8]);
        jp.add(numberButtons[9]);
        jp.add(multiplication);
        jp.add(decimal);
        jp.add(numberButtons[0]);
        jp.add(equal);
        jp.add(division);
        //adding the delete and clear buttons
        jf.add(delete);
        jf.add(clear);
        delete.setBounds(80,350,100,30);
        clear.setBounds(220,350,100,30);
        jb=new JButton(icon);
        jf.add(jb);
        jb.setBounds(100,10,200,40);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public void actionPerformed(ActionEvent e)
    {
          for(int i=0;i<10;i++) 
          {
              if(e.getSource()==numberButtons[i])
              {
                tf.setText(tf.getText().concat(String.valueOf(i)));
              }
          }
          if(e.getSource()==decimal) 
          {
              tf.setText(tf.getText().concat("."));
          }
          if(e.getSource()==addition) 
          {
              num1=Double.parseDouble(tf.getText());
              operator='+';
              tf.setText("");
          }
          if(e.getSource()==subtraction) 
          {
              num1=Double.parseDouble(tf.getText());
              operator='-';
              tf.setText("");
          }
          if(e.getSource()==multiplication) 
          {
              num1=Double.parseDouble(tf.getText());
              operator='*';
              tf.setText("");
          }
          if(e.getSource()==division) 
          {
              num1=Double.parseDouble(tf.getText());
              operator='/';
              tf.setText("");
          }
          if(e.getSource()==equal)
          {
              num2=Double.parseDouble(tf.getText());
              switch(operator)
              {
                   case '+':
                        result=num1+num2;
                        //tf.setText(String.valueOf(result));
                        break;
                   case '-':
                        result=num1-num2;
                        //tf.setText(String.valueOf(result));
                        break;
                   case '*':
                        result=num1*num2;
                        //tf.setText(String.valueOf(result));
                        break;
                   case '/':
                        result=num1/num2;
                        //tf.setText(String.valueOf(result));
                        break;
              }
              tf.setText(String.valueOf(result));
              num1=result;
          }
          if(e.getSource()==clear) 
          {
              tf.setText("");
          }
          if(e.getSource()==delete)
          {
              String txt=tf.getText();
              tf.setText("");
              for(int i=0;i<txt.length()-1;i++) 
              {
                tf.setText(tf.getText()+(txt.charAt(i)));
              }

          }
          
    }
    public static void main(String[] args) {
        new Calculator();
    }
}