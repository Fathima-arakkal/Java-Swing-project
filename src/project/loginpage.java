package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;


public class loginpage extends JFrame{

	private JFrame frame;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginpage window = new loginpage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public loginpage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = this;
		frame.setBounds(100, 100, 661, 378);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBackground(new Color(192, 192, 192));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(218, 164, 118, 17);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(218, 217, 104, 17);
		frame.getContentPane().add(lblNewLabel_1);
		
		username = new JTextField();
		username.setBounds(319, 165, 96, 19);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(319, 218, 96, 19);
		frame.getContentPane().add(password);
		password.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				try {
					//String pass=new String(password.getPassword());
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca","mca");
					Statement stmt=con.createStatement();
					System.out.println("Correct");
					//ResultSet rs=stmt.executeQuery("select * from loginpage where username='"+username.getText()+"' and password='"+password.getText()+"'");
					PreparedStatement pstmt = con.prepareStatement("select * from loginpage where username=? and password=?");
					pstmt.setString(1,username.getText());
					pstmt.setString(2,password.getText());
					ResultSet rs = pstmt.executeQuery();
					if(rs.next())
					{
						System.out.println("Correct");
						JOptionPane.showMessageDialog(btnNewButton,"Correct Username and Password");
						frame.setVisible(false);
						new dashpage().setVisible(true);
					}
					else
					{
						System.out.println("Wrong");
						JOptionPane.showMessageDialog(btnNewButton, "Invalid Credentials");
					}
					
				}catch(Exception e1) {System.out.println(e1);}
				
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(256, 259, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel(" Automobile Service Center");
		lblNewLabel_3.setBackground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setBounds(161, 28, 342, 57);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\iloveimg-resized\\admin.jpg"));
		lblNewLabel_4.setBounds(173, 152, 35, 40);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("New label");
		lblNewLabel_4_1.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\iloveimg-resized\\password.png"));
		lblNewLabel_4_1.setBounds(173, 208, 42, 40);
		frame.getContentPane().add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\sem2java\\asdfg.jpg"));
		lblNewLabel_2.setBounds(-18, -11, 665, 352);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
