import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
class NumberGuessingGame extends JFrame implements ActionListener
{
    JPanel jp1;
    JPanel jp2;
    JPanel jp3;
    JLabel jl1;
    JLabel jl2;
    JLabel jl3;
    JLabel jl4;
    JButton jb;
    JButton jb1;
    JButton jb2;
    JButton jb3;
    JTextField tf;
    JLabel jl5;
    JTextField tf2;
    int number;
    int count=0;
    Random random=new Random();
    NumberGuessingGame()
    {
        ImageIcon icon=new ImageIcon("C:\\Alexa_NumberGuess (2).jpeg");
        Font myfont=new Font("Comic Sans MS",Font.BOLD,40);
        Font myfont1=new Font("Comic Sans MS",Font.BOLD,30);
        Font myfont2=new Font("Comic Sans MS",Font.BOLD,17);
        //adding  the panels 
        jp1=new JPanel();
        jp2=new JPanel();
        jp3=new JPanel();
        add(jp1);
        add(jp2);
        add(jp3);
        jp1.setBounds(0,0,300,600);
        jp2.setBounds(300,0,300,400);
        jp3.setBounds(300,300,300,300);
        jp1.setBackground(Color.ORANGE);
        jp2.setBackground(Color.RED);
        jp3.setBackground(Color.YELLOW);
        jp1.setLayout(null);
        jp2.setLayout(null);
        jp3.setLayout(null);
        //adding the labels
        jl1=new JLabel("Number");
        jl2=new JLabel("Guessing Game");
        jl3=new JLabel("Guess the Number");
        jp1.add(jl1);
        jp1.add(jl2);
        jp2.add(jl3);
        jl1.setBounds(80,80,150,60);
        jl2.setBounds(50,150,280,40);
        jl3.setBounds(10,40,280,40);
        jl1.setFont(myfont);
        jl2.setFont(myfont1);
        jl3.setFont(myfont1);
        //adding the button 
        jb=new JButton(icon);
        jp1.add(jb);
        jb.setBounds(25,250,250,250);
        //adding the text field 
        tf=new JTextField();
        tf.setFont(myfont2);
        jp2.add(tf);
        tf.setBounds(80,100,150,30);
        //adding the button to second panel 
        jb1=new JButton("Guess");
        jp2.add(jb1);
        jb1.setFont(myfont1);
        jb1.setBounds(90,160,120,35);
        jb1.setBackground(Color.pink);
        //------------------------------------
        jb2=new JButton("Give Up!");
        jp2.add(jb2);
        jb2.setFont(myfont2);
        jb2.setBounds(20,300,120,35);
        jb2.setBackground(Color.pink);
        //------------------------------------
        jb3=new JButton("New Game");
        jp2.add(jb3);
        jb3.setFont(myfont2);
        jb3.setBounds(150,300,120,35);
        jb3.setBackground(Color.pink);
        //creating the frame
        setLayout(null);
        setSize(600,600);
        setTitle("Number Guessing Game");
        setVisible(true);
        //creating the label 
        jl4=new JLabel();
        jp2.add(jl4);
        jl4.setBounds(60,220,200,30);
        jl4.setFont(myfont2);
        jl4.setBackground(Color.WHITE);
        number=random.nextInt(101);
        jl5=new JLabel("No of attempts:");
        jl5.setFont(myfont2);
        jp3.add(jl5);
        jl5.setBounds(10,150,150,40);
        tf2=new JTextField();
        jp3.add(tf2);
        tf2.setBounds(160,160,120,30);
        tf2.setFont(myfont2);
        //regestering the component with the listener
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    // interface method implementation
    public void actionPerformed(ActionEvent e)
    {
        String str=tf.getText();
        int num=Integer.parseInt(str);
        if(e.getSource()==jb1) 
        {
            count++;
            tf2.setText(String.valueOf(count));
            if(number==num) 
            {
                JOptionPane.showMessageDialog(jb1,"You Win you entered number is "+number+"\n play new Game");
            }
            if(num<number) 
            {
                jl4.setText(num+" is Low Try Again!");
            }
            if(num>number) 
            {
                jl4.setText(num+" is High Try Again!");
            }
        }
        else if(e.getSource()==jb2) 
        {
            JOptionPane.showMessageDialog(jb2,"The Number is the "+number);
            number=random.nextInt(101);

        }
        if(e.getSource()==jb3)
        {
            tf.setText("");
            number=random.nextInt(101);
            count=0;
            tf2.setText(String.valueOf(count));
        }
    }
    public static void main(String[] args) {
        new NumberGuessingGame();
    }
}