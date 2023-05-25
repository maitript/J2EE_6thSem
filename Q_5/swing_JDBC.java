package Q_5;


/*Write a program that uses Java Swing and JDBC to create a stand-alone application:
i. Create a table namely, 
a. Customer (CustNo, CustName, State, Credit_Limit, 
RepNo) in MySQL database. CustNo is the primary key 
ii. Use appropriate Swing components to insert values in a form.
iii. Display Customer information when Credit_Limit is above 15,000  */


import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class swing_JDBC implements ActionListener {
	static Connection con;
	
	static JFrame jf = new JFrame("Customer Information");
	static JTextField cusNo=new JTextField(20);
	static JTextField cusName=new JTextField(20);
	static JTextField state=new JTextField(20);
	static JTextField credLim=new JTextField(20);
	static JTextField repNo=new JTextField(20);
	static JButton insertButton=new JButton("Insert");
	static JButton displayAllButton=new JButton("Display all");
	static JButton credFilterButton=new JButton("Display >15k Cred");
	static JTextArea res = new JTextArea();
	
	static void establishDbConnection() throws Exception
	{	//See the throws exception both in this method and main method
		Class.forName("com.mysql.cj.jdbc.Driver");					
		String url = "jdbc:mysql://localhost:3306/program5";
		String username = "root";
		String password = "1234";
		con = DriverManager.getConnection(url, username, password);
		if (con != null) 
			System.out.println("Database Connected successfully");
		else
			System.out.println("Database Connection failed");		
	}
	
	public static void main(String[] args) throws Exception {
		establishDbConnection();
		
		jf.setSize(800,600);
		jf.setLayout(new BoxLayout(jf.getContentPane(),BoxLayout.Y_AXIS));
		
		jf.add(new JLabel("Customer Number"));
		jf.add(cusNo);
		jf.add(new JLabel("Customer Name"));
		jf.add(cusName);
		jf.add(new JLabel("State"));
		jf.add(state);
		jf.add(new JLabel("Credit limit"));
		jf.add(credLim);
		jf.add(new JLabel("Representative Number"));
		jf.add(repNo);
		jf.add(insertButton);
		jf.add(displayAllButton);
		
		jf.add(new JLabel("For Credit limit > 15k Click below"));
		jf.add(credFilterButton);
		
		jf.add(res);
		
		insertButton.addActionListener(new GUI());
		credFilterButton.addActionListener(new GUI());
		displayAllButton.addActionListener(new GUI());
		
		jf.setVisible(true);
		jf.pack();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== insertButton)
		{
			System.out.println("Hell");
			try {
				Statement stm = con.createStatement();
				String ins = "insert into Customer values("+cusNo.getText()+",'"+cusName.getText()+"','"+state.getText()+"',"+credLim.getText()+","+repNo.getText()+")";
				stm.executeUpdate(ins);
				
				
			} catch (SQLException s) {
				System.out.println(s.toString());
			}
		}
		
		if(e.getSource()==credFilterButton || e.getSource()==displayAllButton)
		{
			try {
				Statement stm = con.createStatement();
				String ins;
				if(e.getSource()==credFilterButton)
					ins="select * from Customer where Credit_Limit>15000";
				else
					ins = "select * from Customer";
				ResultSet rs= stm.executeQuery(ins);
				res.setText(null);
				res.append("CustNo \t CustName \t State \t Credit_Limit \t RepNo \n");

				while(rs.next())
				{
					res.append(rs.getString("CustNo"));
					res.append("\t");
					res.append(rs.getString("CustName"));
					res.append("\t");
					res.append(rs.getString("State"));
					res.append("\t");
					res.append(rs.getString("Credit_Limit"));
					res.append("\t");
					res.append(rs.getString("RepNo"));
					res.append("\n");
				}
				jf.pack();
				
			} catch (SQLException s) {
				System.out.println(s.toString());
			}
		}
		
	}

}

//############################################mysql Customer Table##############################################################
//>mysql -u root -p
//password:password
//mysql>create database msrit;
//mysql> use msrit;
//mysql>create table Customer (CustNo int not null primary key,
//			     CustName varchar(20),
//			     State varchar(20),
//			     Credit_Limit varchar(20),
//			     RepNo varchar(20));
//mysql> select * from customer;
//+--------+----------+-------+--------------+-------+
//| CustNo | CustName | State | Credit_Limit | RepNo |
//+--------+----------+-------+--------------+-------+
//|    121 | DDD      | Delhi |        40000 |     3 |
//|    122 | LLL      | KAR   |        10000 |     2 |
//|    123 | MMM      | TN    |        20000 |     1 |
//|    124 | KKK      | AP    |        80000 |     5 |
//|    126 | JJJ      | Goa   |        25000 |     5 |
//|    127 | RRR      | AP    |        40000 |    11 |
//|    128 | SSS      | Delhi |        60000 |    12 |
//|    129 | TTT      | RAJ   |        12000 |     7 |
//|    130 | AAA      | NAG   |        18000 |    16 |
//|    131 | PPP      | HAR   |        16000 |    19 |
//|    145 | Himanth  | delhi |        50000 |     2 |
//|    147 | waku     | LA    |        40000 |     3 |
//|    150 | Ganada   | har   |         2000 |     3 |
//|    234 | waku     | yan   |        80000 |     1 |
//|    450 | Ronaldo7 | por   |        45000 |     3 |
//+--------+----------+-------+--------------+-------+