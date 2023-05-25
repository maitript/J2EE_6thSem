//SUBMIT DOES THE VALIDATION
//DONE DOES THE CGPA CALCULATION
// DISPLAY TO JUST SHOW RESULTS

package Q_3;

import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class GUI1 implements ActionListener{
	static JFrame f1=new JFrame("STUDENT INFO");
	static JLabel label1=new JLabel("ENTER NAME");
	static JLabel label2=new JLabel("ENTER USN");
	static JLabel label3=new JLabel("ENTER ADDRESS");
	static JLabel label4=new JLabel("ENTER CATEGORY");
	static JLabel label5=new JLabel("ENTER AGE");
	static JLabel label6=new JLabel("ENTER SGPA1");
	static JLabel label7=new JLabel("ENTER SGPA2");
	static JLabel label8=new JLabel("ENTER SGPA3");
	static JLabel label9=new JLabel("ENTER SGPA4");
	
	static JTextField tname=new JTextField(20);
	static JTextField tusn=new JTextField(20);
	static JTextField taddr=new JTextField(20);
	static JTextField tcat=new JTextField(20);
	static JTextField tage=new JTextField(10);
	static JTextField sgpa1=new JTextField(5);
	static JTextField sgpa2=new JTextField(5);
	static JTextField sgpa3=new JTextField(5);
	static JTextField sgpa4=new JTextField(5);
	
	static JButton submit=new JButton("submit");
	static JButton done=new JButton("done");
	static JButton display=new JButton("display");
	
	static ArrayList<STUDENT1> AA=new ArrayList<STUDENT1>();
	public static void main(String[] args)
	{
		f1.setSize(800, 600);
		f1.setLayout(new FlowLayout());
		f1.setVisible(true);
		
		f1.add(label1);
		f1.add(tname);
		f1.add(label2);
		f1.add(tusn);
		f1.add(label3);
		f1.add(taddr);
		f1.add(label4);
		f1.add(tcat);
		f1.add(label5);
		f1.add(tage);
		f1.add(label6);
		f1.add(sgpa1);
		f1.add(label7);
		f1.add(sgpa2);
		f1.add(label8);
		f1.add(sgpa3);
		f1.add(label9);
		f1.add(sgpa4);
		
		f1.add(submit);
		f1.add(done);
		f1.add(display);
		
		submit.addActionListener(new GUI1());	
		done.addActionListener(new GUI1());
		display.addActionListener(new GUI1());

	}
		
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==submit)
		{
			int age=Integer.parseInt(tage.getText());
			if(18>age||age>30)
			{
				System.out.println("invalide age");
				String temp=JOptionPane.showInputDialog(null,"Enter valid age 18 to 30=");
				tage.setText(temp);
			}
			else
			{
				System.out.println("valide age");
				System.out.println("its working");
			}
			check(1,sgpa1);
			check(2,sgpa2);
			check(3,sgpa3);
			check(4,sgpa4);
			
		}
		else if(e.getSource()==done)
		{

			double s1=Double.parseDouble(sgpa1.getText());
			double s2=Double.parseDouble(sgpa1.getText());
			double s3=Double.parseDouble(sgpa1.getText());
			double s4=Double.parseDouble(sgpa1.getText());
			double cg=(s1+s2+s3+s4)/4;
			STUDENT1 ob=new STUDENT1(tname.getText(),tusn.getText(),taddr.getText(),tcat.getText(),Integer.parseInt(tage.getText()),s1,s2,s3,s4,9.0,7.0,8.0,9.0);
			ob.cgpa=cg;
			
			AA.add(ob);
			
		
		}
		else
		{
			
			f1.setVisible(false);
			JFrame f2=new JFrame("DISPLAY FRAME");
			f2.setSize(500, 500);
			f2.setVisible(true);
			JTextArea info=new JTextArea(20,20);
			f2.add(info);
			for(STUDENT1 ob1:AA)
			{
				info.setText(ob1.toString());
			}
			
			//System.out.println(".............perfect............");
		}
		
		
			
		
		// TODO Auto-generated method stub
		
	}
	void check(int i,JTextField sgpa)
	{
		if(Double.parseDouble(sgpa.getText())>=10)
		{
			//System.out.println("sem "+i+"invalide SGPA");
			String temp=JOptionPane.showInputDialog(null,"sem "+i+" Enter valid sgpa 0 to 10=");
			sgpa.setText(temp);
	
		}
	}

}