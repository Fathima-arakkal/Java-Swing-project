package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class update extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField name;
	private JTextField phone;
	private JTextField loc;
	private JTable table;
	private JTextField t1;
	private JTable table_1;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					update frame = new update();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public update() {
		frame=this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 864, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(215, 10, 5, 5);
		contentPane.add(tabbedPane);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(10, 41, 889, 400);
		contentPane.add(tabbedPane_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane_1.addTab("add", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" Automobile Service Center");
		lblNewLabel.setFont(new Font("Book Antiqua", Font.BOLD, 16));
		lblNewLabel.setBounds(27, 10, 220, 34);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Customer ID");
		lblNewLabel_1.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 85, 86, 13);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(144, 83, 96, 19);
		panel_1.add(textField);
		
		JLabel lblNewLabel_2 = new JLabel("Customer Name");
		lblNewLabel_2.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 138, 107, 13);
		panel_1.add(lblNewLabel_2);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(144, 136, 96, 19);
		panel_1.add(name);
		
		JLabel lblNewLabel_3 = new JLabel("Customer Mobile");
		lblNewLabel_3.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 194, 124, 13);
		panel_1.add(lblNewLabel_3);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(144, 192, 96, 19);
		panel_1.add(phone);
		
		JLabel lblNewLabel_4 = new JLabel("Customer Address");
		lblNewLabel_4.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		lblNewLabel_4.setBounds(10, 237, 124, 13);
		panel_1.add(lblNewLabel_4);
		
		loc = new JTextField();
		loc.setColumns(10);
		loc.setBounds(144, 235, 96, 19);
		panel_1.add(loc);
		
		JLabel lblNewLabel_5 = new JLabel("Customer Manage");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(379, 9, 193, 34);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_9_1_1 = new JLabel("New label");
		lblNewLabel_9_1_1.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\iloveimg-resized (1)\\customer.png"));
		lblNewLabel_9_1_1.setBounds(666, 10, 119, 110);
		panel_1.add(lblNewLabel_9_1_1);
		
		JButton btnaddcust = new JButton("ADD");
		btnaddcust.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try

				{

				Class.forName("oracle.jdbc.driver.OracleDriver");

				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca","mca");

				Statement stmt=con.createStatement();

				PreparedStatement pstmt = con.prepareStatement("insert into register values(?,?,?,?)");

				ResultSet rsuid=stmt.executeQuery("select count(id) from register");

				rsuid.next();

				int id=rsuid.getInt(1);

				int newuid=id+1;

				pstmt.setInt(1, newuid);

				pstmt.setString(2, name.getText());

				pstmt.setString(3, phone.getText());

				pstmt.setString(4, loc.getText());

				pstmt.executeUpdate();

				System.out.println("Insertion successful");

				//

				// frame.setVisible(false);

				// new Login().setVisible(true);

				}catch (Exception e1 ) {System.out.println(e1);}
			}
		});
		btnaddcust.setFont(new Font("Book Antiqua", Font.BOLD, 12));
		btnaddcust.setBounds(50, 280, 85, 21);
		panel_1.add(btnaddcust);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(268, 132, 560, 227);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Customer ID", "Customer Name", "Customer Mobile", "Customer Address"
			}
		));
		
		JButton btnNewButton_2 = new JButton("Display");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
                {
                Class.forName("oracle.jdbc.driver.OracleDriver");    
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca","mca");
                Statement stmt=con.createStatement();                
            
                ResultSet rs=stmt.executeQuery("select * from register");
                
                while(rs.next()) {
                    String id=String.valueOf(rs.getInt("id"));
                    String name=rs.getString("name");
                    String phone=rs.getString("phone");
                    String loc=rs.getString("loc");
                    
                    
                    String tbData[]= {id,name,phone,loc};
                    DefaultTableModel tblModel=(DefaultTableModel)table.getModel();
                    tblModel.addRow(tbData);
                    
                }
                
            }catch (Exception e1 ) {System.out.println(e1);}
			}
		});
		btnNewButton_2.setBounds(173, 280, 85, 21);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				new dashpage().setVisible(true);
			}
			
			
		});
		btnNewButton_3.setBounds(105, 323, 85, 21);
		panel_1.add(btnNewButton_3);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setIcon(new ImageIcon("D:\\sem2java\\asdfg.jpg"));
		lblNewLabel_8.setBounds(-12, 0, 866, 383);
		panel_1.add(lblNewLabel_8);
		table.getColumnModel().getColumn(0).setPreferredWidth(102);
		table.getColumnModel().getColumn(1).setPreferredWidth(106);
		table.getColumnModel().getColumn(2).setPreferredWidth(101);
		table.getColumnModel().getColumn(3).setPreferredWidth(111);
		
		JPanel panel_2 = new JPanel();
		tabbedPane_1.addTab("delete", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel(" Automobile Service Center");
		lblNewLabel_6.setFont(new Font("Book Antiqua", Font.BOLD, 16));
		lblNewLabel_6.setBounds(34, 21, 220, 34);
		panel_2.add(lblNewLabel_6);
		
		JLabel lblNewLabel_5_1 = new JLabel("Customer Manage");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5_1.setBounds(327, 21, 193, 34);
		panel_2.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_9_1_1_1 = new JLabel("New label");
		lblNewLabel_9_1_1_1.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\iloveimg-resized (1)\\customer.png"));
		lblNewLabel_9_1_1_1.setBounds(722, 10, 119, 110);
		panel_2.add(lblNewLabel_9_1_1_1);
		
		JLabel lblNewLabel_7 = new JLabel("Enter id to delete:");
		lblNewLabel_7.setBounds(29, 88, 85, 13);
		panel_2.add(lblNewLabel_7);
		
		t1 = new JTextField();
		t1.setBounds(124, 85, 96, 19);
		panel_2.add(t1);
		t1.setColumns(10);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel tblModel=(DefaultTableModel)table_1.getModel();
//              if(table_1.getSelectedRowCount()==1) {
                  tblModel.removeRow(table_1.getSelectedRow());
                  try
                  {
                  Class.forName("oracle.jdbc.driver.OracleDriver");    
                  Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca","mca");
                  String cid=t1.getText();
                  PreparedStatement stmt=con.prepareStatement("Delete from register where id="+cid+"");
                  stmt.execute();
                  System.out.println("Deletion successful");
                  
              }catch (Exception e1 ) {System.out.println(e1);}
			}
		});
		btnNewButton.setBounds(313, 84, 85, 21);
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Display");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
                {
                Class.forName("oracle.jdbc.driver.OracleDriver");    
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca","mca");
                Statement stmt=con.createStatement();                
            
                ResultSet rs=stmt.executeQuery("select * from register");
                
                while(rs.next()) {
                    String id=String.valueOf(rs.getInt("id"));
                    String name=rs.getString("name");
                    String phone=rs.getString("phone");
                    String loc=rs.getString("loc");
                    
                    
                    String tbData1[]= {id,name,phone,loc};
                    DefaultTableModel tblModel1=(DefaultTableModel)table_1.getModel();
                    tblModel1.addRow(tbData1);
                    
                }
                
            }catch (Exception e1 ) {System.out.println(e1);}
				
			}
		});
		btnNewButton_1.setBounds(408, 84, 85, 21);
		panel_2.add(btnNewButton_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(34, 136, 796, 215);
		panel_2.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Customer ID", "Customer Name", "Customer Mobile", "Customer Address"
			}
		));
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setIcon(new ImageIcon("D:\\sem2java\\asdfg.jpg"));
		lblNewLabel_9.setBounds(0, -2, 874, 375);
		panel_2.add(lblNewLabel_9);
		table_1.getColumnModel().getColumn(0).setPreferredWidth(90);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(103);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(109);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(121);
	}
}
