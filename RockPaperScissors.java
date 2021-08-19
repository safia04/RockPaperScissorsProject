import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class RockPaperScissors {
	public static void main(String args[]) {
		RPS obj=new RPS();
	}

}
class RPS extends JFrame implements ActionListener{
		
	JLabel l1,l2,l3,l4,l5,res;
	JButton b1,b2,b3;
	
	public RPS() {
		
		l1=new JLabel("Welcome to Our Rock Paper Scissors Game!");
		l2=new JLabel("Computer Vs You");
		l3=new JLabel("Please, Enter Your Move !!");
		res=new JLabel("                                                                                         ");
		l4=new JLabel("                                          ");
		l5=new JLabel("                                          ");
		
		JButton b1=new JButton("ROCK");
		JButton b2=new JButton("PAPER");
		JButton b3=new JButton("SCISSORS");
		
		add(l1);
		add(l2);
		add(l3);
		add(b1);
		add(b2);
		add(b3);
		add(res);
		add(l4);
		add(l5);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		l1.setFont(new Font("Serif",Font.BOLD+Font.ITALIC,30));
		l2.setFont(new Font("Serif",Font.BOLD+Font.ITALIC,40));
		l3.setFont(new Font("Serif",Font.BOLD,25));
		res.setFont(new Font("Serif",Font.BOLD+Font.ITALIC,30));
		l4.setFont(new Font("Serif",Font.BOLD+Font.ITALIC,20));
		l5.setFont(new Font("Serif",Font.BOLD+Font.ITALIC,20));
		
		
		b1.setFont(new Font("Serif",Font.BOLD+Font.ITALIC,30));
		b2.setFont(new Font("Serif",Font.BOLD+Font.ITALIC,30));
		b3.setFont(new Font("Serif",Font.BOLD+Font.ITALIC,30));
		
		l2.setForeground(Color.white);
		res.setForeground(Color.white);
		
		Dimension size1=l1.getPreferredSize();
		l1.setBounds(100,10,size1.width,size1.height);
		
		Dimension size2=l2.getPreferredSize();
		l2.setBounds(220,60,size2.width,size2.height);
		
		Dimension size3=l3.getPreferredSize();
		l3.setBounds(210,150,size3.width,size3.height);
		
		Dimension size4=res.getPreferredSize();
		res.setBounds(220,300,size4.width,size4.height);
		
		Dimension size5=res.getPreferredSize();
		l4.setBounds(290,350,size5.width,size5.height);
		
		Dimension size6=res.getPreferredSize();
		l5.setBounds(290,380,size6.width,size6.height);
		
		
		b1.setBounds(100,200,180,50);
		b2.setBounds(285,200,180,50);
		b3.setBounds(470,200,180,50);
		
		
		setLayout(null);
		setVisible(true);
		setSize(750,500);
		getContentPane().setBackground(Color.PINK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Random rand=new Random();
			String s = e.getActionCommand();
			String comp="";
			int rand_int=rand.nextInt(3);
			if(rand_int==0)
				comp="ROCK";
			else if(rand_int==1)
				comp="PAPER";
			else if(rand_int==2)
				comp="SCISSORS";
			int result=game(comp,s);
			if(result==0) {
				res.setText("It's a Tie!");
			}
			else if(result==1) {
				res.setText("You Win, Congratulations!");
			}
			else if(result==-1) {
				res.setText("You Loose, Better Luck Next Time!");
			}
			l4.setText("Your Move: "+s);
			l5.setText("Computer Move: "+comp);		
	}
	public static int game(String comp,String player) {
		if(comp.equals(player)) {
			return 0;
		}
		else if(comp.equals("ROCK"))
		{
			if(player.equals("PAPER"))
				return 1;
			else if(player.equals("SCISSORS"))
				return -1;
		}
		else if(comp.equals("PAPER"))
		{
			if(player.equals("SCISSORS"))
				return 1;
			else if(player.equals("ROCK"))
				return -1;
		}
		else
		{
			if(player.equals("ROCK"))
				return 1;
			else if(player.equals("PAPER"))
				return -1;
		}
		return 10;
	}
}
