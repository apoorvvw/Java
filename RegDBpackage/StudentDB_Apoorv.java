package RegDBpackage;


import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.sql.*;

class  StudentDB extends JFrame implements ActionListener{
	JLabel lEmpId,lName,lSal;
	JTextField tfEmpId,tfEmpName,tfSal;
	JButton bsave,bload,breset,bexit,bupdate,bdelet;
	Container cp;


	public StudentDB()
	{
		cp=getContentPane();
		cp.setLayout(null);
		lEmpId=new JLabel("Student ID : ");
		lEmpId.setBounds(30,30,150,30);
		cp.add(lEmpId);

		tfEmpId=new JTextField(25);
		tfEmpId.setBounds(150,30,100,30);
		cp.add(tfEmpId);

		lName=new JLabel("Student Name : ");
		lName.setBounds(30,70,100,30);
		cp.add(lName);

		tfEmpName=new JTextField(25);
		tfEmpName.setBounds(150,70,100,30);
		cp.add(tfEmpName);

		lSal=new JLabel("Student Marks : ");
		lSal.setBounds(30,110,100,30);
		cp.add(lSal);

		tfSal=new JTextField(25);
		tfSal.setBounds(150,110,100,30);
		cp.add(tfSal);

		
		bsave=new JButton(" Save ");
		bsave.setBounds(30,200,100,30);
		cp.add(bsave);
		bsave.addActionListener(this);

		bupdate=new JButton("Update");
		bupdate.setBounds(30,250,100,30);
		cp.add(bupdate);
		bupdate.addActionListener(this);

		bdelet=new JButton("Delete");
		bdelet.setBounds(150,250,100,30);
		cp.add(bdelet);
		bdelet.addActionListener(this);

		bexit=new JButton("Exit");
		bexit.setBounds(270, 250, 100, 30);
		cp.add(bexit);
		bexit.addActionListener(this);

		
		
		bload=new JButton(" Load ");
		bload.setBounds(150,200,100,30);
		cp.add(bload);
		bload.addActionListener(this);
		breset=new JButton(" Reset ");
		breset.setBounds(270,200,100,30);
		cp.add(breset);
		breset.addActionListener(this);
		setSize(600,600);	
		setVisible(true);
	}


	public static void main(String[] args) 
	{
		StudentDB f=new StudentDB();
	}


	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==bsave)
		{
			try {
				int eid=Integer.parseInt(tfEmpId.getText());
				String ename=tfEmpName.getText();
				int esal=Integer.parseInt(tfSal.getText());
				
				Class.forName("com.mysql.jdbc.Driver");
			    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/monalz", "root", "root");
                String query="insert into emp(empId,name,salary) values(?,?,?)";
			    PreparedStatement st=con.prepareStatement(query);
                st.setInt(1, eid);
                st.setString(2, ename);
                st.setInt(3, esal);
                
                int nrows=st.executeUpdate();
                if(nrows>0)
                {
                	JOptionPane.showMessageDialog(this,"Success");
                	
                }
                else
                {
                	JOptionPane.showMessageDialog(this, "failure");
                }
                
			st.close();
			con.close();
			}
			catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ae.getSource()==bload)
		{
			
			try {
				int eid=Integer.parseInt(tfEmpId.getText());
				Class.forName("com.mysql.jdbc.Driver");
		    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/monalz", "root", "root");
		    	String query="select * from emp where empId=?";
		    	PreparedStatement st=con.prepareStatement(query);
		    	st.setInt(1, eid);
		    	
		    	
		    	ResultSet rs=st.executeQuery();
		    	if(rs.next())
		    	{
		    		tfEmpName.setText(rs.getString(2));
		    		tfSal.setText(rs.getString(3));
		    		JOptionPane.showMessageDialog(this,"Congrats,The record found");
		    	}
		    	else
		    	{
		    		JOptionPane.showMessageDialog(this,"Record Not Found");
		    	}
		    	
		    	
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ae.getSource()==breset)
		{
			tfEmpId.setText(" ");
			tfEmpName.setText(" ");
			tfSal.setText(" ");
			
		}
		if(ae.getSource()==bexit)
		{
		System.exit(0);
		}
		if(ae.getSource()==bupdate)
		{
			try {
				int eid=Integer.parseInt(tfEmpId.getText());
				String ename=tfEmpName.getText();
				int esal=Integer.parseInt(tfSal.getText());
				
				Class.forName("com.mysql.jdbc.Driver");
			    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
                String query="update employee set empName=?,empSal=? where empId=?";
			    PreparedStatement st=con.prepareStatement(query);
                st.setString(1, ename);
                st.setInt(2,esal);
                st.setInt(3, eid);
                
                int nrows=st.executeUpdate();
                if(nrows>0)
                {
                	JOptionPane.showMessageDialog(this,"Upadted");
                	
                }
                else
                {
                	JOptionPane.showMessageDialog(this, "failure");
                }
                
			st.close();
			con.close();
			}
			catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			
		}
		if(ae.getSource()==bdelet)
		{
			try {
				int eid=Integer.parseInt(tfEmpId.getText());
				Class.forName("com.mysql.jdbc.Driver");
		    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		    	String query="delete from employee where empId=?";
		    	PreparedStatement st=con.prepareStatement(query);
		    	st.setInt(1, eid);
		    	
		    	
		    	int rs=st.executeUpdate();
		    	if(rs>0)
		    	{
		    		//tfEmpName.setText(rs.getString(2));
		    		//tfSal.setText(rs.getString(3));
		    		JOptionPane.showMessageDialog(this,"Record deleted");
		    	}
		    	else
		    	{
		    		JOptionPane.showMessageDialog(this,"Record Not Found");
		    	}
		    	
		    	
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
