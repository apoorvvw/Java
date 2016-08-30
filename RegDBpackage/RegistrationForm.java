package RegDBpackage;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RegistrationForm extends JFrame implements ActionListener
{
	Container cp;
	static int id;
	
	JLabel jlFirstName, jlLastName, jlGender, jlMale, jlFemale, jlPassword, jlAddress, jlQualificattion, 
			jlReferances, jlCoursesInstructed, jlC, jlCpp, jlJava, jlDotNet, jlTesting, jlAsp ;
	JTextField tfFirstName, tfLastName;
	JTextArea taAddress;
	JComboBox cbQualification;
	JPasswordField pfPassword;
	JRadioButton rbMale, rbFemale;
	JList lPrefrances;
	JCheckBox checkC, checkCpp, checkJava, checkDotNet, checkTesting, checkAsp;
	JButton jbRegister, jbLoad, jbClear;
	
	
	RegistrationForm()
	{
		cp = getContentPane();
		cp.setLayout(null);
		
		jlFirstName = new JLabel("Frist Name");
		cp.add(jlFirstName);
		jlLastName = new JLabel("Last Name");
		cp.add(jlLastName);
		jlGender = new JLabel("Gender :");
		cp.add(jlGender);
		jlMale = new JLabel("Male");
		cp.add(jlMale);
		jlFemale = new JLabel("Female");
		cp.add(jlFemale);
		jlPassword = new JLabel("Password");
		cp.add(jlPassword);
		jlAddress = new JLabel("Address");
		cp.add(jlAddress);
		jlQualificattion = new JLabel("Qualification");
		cp.add(jlQualificattion);
		jlReferances = new JLabel("Referances");
		cp.add(jlReferances);
		jlCoursesInstructed = new JLabel("Courses Instructed");
		cp.add(jlCoursesInstructed);
		jlC = new JLabel("C");
		cp.add(jlC);
		jlCpp = new JLabel("C++");
		cp.add(jlCpp);
		jlJava = new JLabel("Java");
		cp.add(jlJava);
		jlAsp = new JLabel("ASP");
		cp.add(jlAsp);
		jlTesting = new JLabel("Testing");
		cp.add(jlTesting);
		jlDotNet = new JLabel(".NET");
		cp.add(jlDotNet);
		
		tfFirstName = new JTextField();
		cp.add(tfFirstName);
		tfLastName = new JTextField();
		cp.add(tfLastName);
		taAddress = new JTextArea();
		cp.add(taAddress);
		
		cbQualification = new JComboBox();
		cbQualification.addItem("");
		cbQualification.addItem("10th");
		cbQualification.addItem("12th");
		cbQualification.addItem("Graduate");
		cbQualification.addItem("Post Graduate");
		cbQualification.addItem("Working");
		cp.add(cbQualification);
		
		pfPassword = new JPasswordField();
		cp.add(pfPassword);
		
		rbMale = new JRadioButton();
		cp.add(rbMale);
		rbFemale = new JRadioButton();
		cp.add(rbFemale);
		ButtonGroup bg = new ButtonGroup();
		bg.add(rbMale);
		bg.add(rbFemale);
		
		lPrefrances=new JList();		
		Vector listData=new Vector();
		listData.add("NewsPaper");
		listData.add("Advertisment");
		listData.add("Website");
		listData.add("Friend");
		listData.add("Other");
		
		lPrefrances.setListData(listData);
		cp.add(lPrefrances);
		
		checkJava=new JCheckBox("Java");
		cp.add(checkJava);
		checkDotNet=new JCheckBox(".Net");
		cp.add(checkDotNet);
		checkAsp=new JCheckBox("SAP");
		cp.add(checkAsp);
		checkCpp=new JCheckBox("C++");
		cp.add(checkCpp);
		checkC=new JCheckBox("C");
		cp.add(checkC);
		checkTesting = new JCheckBox("Testing");
		cp.add(checkTesting);
		
		jbRegister = new JButton("Save");
		jbRegister.addActionListener(this);
		jbLoad = new JButton("Load");
		jbLoad.addActionListener(this);
		jbClear = new JButton("Clear");
		jbClear.addActionListener(this);
		JPanel jp = new JPanel();
		jp.add(jbRegister);
		jp.add(jbClear);
		jp.add(jbLoad);
		cp.add(jp);
		
		jlFirstName.setBounds(10,10, 80,20);
		tfFirstName.setBounds(100,10,200,20);
		jlLastName. setBounds(10,40, 80,20);
		tfLastName. setBounds(100,40,200,20);
		jlGender.   setBounds(10,64,60,30);
		jlMale.     setBounds(70+30+20, 70, 50, 20);
		rbMale.     setBounds(100+30+20, 70, 20, 20);
		jlFemale.   setBounds(136+30+25+20,70,60,20);
		rbFemale.   setBounds(180+30+30+20, 70, 20, 20);
		jlPassword. setBounds(10,100,80,20);
		pfPassword. setBounds(100,100,200,20);
		jlAddress.  setBounds(10,130,80,20);
		taAddress.  setBounds(100,130,200,50);
		jlQualificattion.   setBounds(10,190,80,20);
		cbQualification.    setBounds(100,190,200,20);	
		jlReferances.       setBounds(10,220,80,20);
		lPrefrances.        setBounds(100,220,200,100);
		jlCoursesInstructed.setBounds(10,330,120,40);
		checkC.             setBounds(100,360,20,20);
		jlC.                setBounds(122,360,8,20);
		checkCpp. 		    setBounds(175,360,20,20);
		jlCpp.              setBounds(197,360,50,20);
		checkJava.          setBounds(100,380,20,20);
		jlJava.             setBounds(122,380,50,20);
		checkDotNet. 		setBounds(175,380,20,20);
		jlDotNet.           setBounds(197,380,50,20);
		checkAsp.           setBounds(100,400,20,20);
		jlAsp.              setBounds(122,400,50,20);
		checkTesting. 		setBounds(175,400,20,20);
		jlTesting.          setBounds(197,400,100,20);
		jp.setBounds(0, 430, 350, 40);
		
		setTitle("Registration From");
		setSize(340, 500);
		setVisible(true);
	}

	public static void main(String[] Args)
	{
		RegistrationForm rf = new RegistrationForm();
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource()==jbRegister)
		{
			try {
				id++;
				String firstName = tfFirstName.getText();
				String lastName = tfLastName.getText();
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
				String query="insert into emp(id,name) values(?,?)";
				PreparedStatement st=con.prepareStatement(query);
				st.setInt(1, id);
				st.setString(2, firstName+"_"+lastName);
				int nrows=0;//st.executeUpdate();
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
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
