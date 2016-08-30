package RegDBpackage;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class myStudentBD extends JFrame implements ActionListener
{
	Container cp;
	JTextField tfID, tfName, tfMarks;
	JLabel lID, lName, lMarks;
	JPanel input, buttons;
	JButton bSave,bLoad,bReset,bExit,bUpdate,bDelete;
	public myStudentBD() 
	{
		// TODO Auto-generated constructor stub
		cp = getContentPane();
		input = new JPanel();
		buttons = new JPanel();
		
		cp.setLayout(new BorderLayout(30,30));
		input.setLayout(new GridLayout(3,2, 20,20));
		
		buttons.setLayout(new GridLayout(2,3,10,10));
		
		cp.add(input, "North");
		cp.add(buttons,"South");
		lID = new JLabel("Student ID: ");
		input.add(lID);
		
		tfID = new JTextField();
		input.add(tfID);
		
		lName = new JLabel("Name: ");
		input.add(lName);
		
		tfName = new JTextField();
		input.add(tfName);
		
		lMarks= new JLabel("Marks: ");
		input.add(lMarks);
		
		tfMarks = new JTextField();
		input.add(tfMarks);
		
		bSave = new JButton("Save");
		bSave.addActionListener(this);

		bLoad = new JButton("Load");
		bSave.addActionListener(this);
		
		bUpdate = new JButton("Update");
		bUpdate.addActionListener(this);

		bReset = new JButton("Reset");
		bReset.addActionListener(this);

		bExit = new JButton("Exit");
		bExit.addActionListener(this);

		bDelete = new JButton("Delete");
		bDelete.addActionListener(this);

		
		buttons.add(bSave);
		buttons.add(bLoad);
		buttons.add(bReset);
		buttons.add(bUpdate);
		buttons.add(bDelete);
		buttons.add(bExit);
		
		
		setSize(400,250);		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		// TODO Auto-generated method stub
		 
		
		if (ae.getSource()==bSave)
		{
			try {
				int eid=Integer.parseInt(tfID.getText());
				String ename=tfName.getText();
				int esal=Integer.parseInt(tfMarks.getText());
				
				Class.forName("com.mysql.jdbc.Driver");
			    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/myDB", "root", "root");
                String query="insert into studentDB(Id,name,marks) values(?,?,?)";
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
		
		if(ae.getSource()==bUpdate)
		{
			try {
				int eid=Integer.parseInt(tfID.getText());
				String ename=tfName.getText();
				int esal=Integer.parseInt(tfMarks.getText());
				
				Class.forName("com.mysql.jdbc.Driver");
			    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/myDB", "root", "root");
                String query="update studentDB set name=?,marks=? where Id=?";
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
                	JOptionPane.showMessageDialog(this, "Failed");
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
		if(ae.getSource()==bExit)
		{
			System.exit(0);
		}
		if(ae.getSource()==bDelete)
		{
			try {
				int eid=Integer.parseInt(tfID.getText());
				Class.forName("com.mysql.jdbc.Driver");
		    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/myDB", "root", "root");
		    	String query="delete from studentDB where Id=?";
		    	PreparedStatement st=con.prepareStatement(query);
		    	st.setInt(1, eid);
		    	
		    	int rs=st.executeUpdate();
		    	if(rs>0)
		    	{
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
		if(ae.getSource()==bReset)
		{
			tfID.setText("");
			tfName.setText("");
			tfMarks.setText("");
		}
		if(ae.getSource()==bLoad)
		{
			try {
				int eid=Integer.parseInt(tfID.getText());
				Class.forName("com.mysql.jdbc.Driver");
		    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/myDB", "root", "root");
		    	String query="select * from studentDB where Id=?";
		    	PreparedStatement st=con.prepareStatement(query);
		    	st.setInt(1, eid);
		    	
		    	
		    	ResultSet rs=st.executeQuery();
		    	if(rs.next())
		    	{
		    		tfName.setText(rs.getString(2));
		    		tfMarks.setText(rs.getString(3));
	  	    		JOptionPane.showMessageDialog(this,"Record found");
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
	public static void main(String[] Args)
	{
		myStudentBD msdb = new myStudentBD();
	}
}
