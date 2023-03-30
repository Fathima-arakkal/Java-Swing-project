package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
//import com.toedter.calendar.JDayChooser;
import com.raven.datechooser.DateChooser;
//import com.toedter.calendar.JDateChooser;
import java.time.*;
import com.raven.datechooser.DateBetween;
import com.raven.datechooser.DateChooser;
import com.raven.datechooser.listener.DateChooserAction;
import com.raven.datechooser.listener.DateChooserListener;
import java.time.LocalDate; 



public class vehicleadd extends JFrame {

	private JPanel contentPane;
	private JTextField vehid;
	private JTextField vehcolor;
	private JTable table;
	private JTextField t2;
	private JTable table_1;
	private JFrame frame;
    private JTextField textField;
	protected JLabel custiid;
	private JTextField custid;
	
	DateChooser dc;
	java.sql.Date endDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vehicleadd frame = new vehicleadd();
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
	public vehicleadd() {
		frame=this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 863, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 56, 934, 406);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Add", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" Automobile Service Center");
		lblNewLabel.setFont(new Font("Book Antiqua", Font.BOLD, 16));
		lblNewLabel.setBounds(23, 10, 220, 34);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_10 = new JLabel("Vehicle Manage");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_10.setBounds(319, 22, 160, 22);
		panel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_9_1 = new JLabel("New label");
		lblNewLabel_9_1.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\iloveimg-resized (1)\\vehicle.png"));
		lblNewLabel_9_1.setBounds(664, 6, 119, 110);
		panel.add(lblNewLabel_9_1);
		
		JLabel lblNewLabel_1 = new JLabel("vehicle id");
		lblNewLabel_1.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 74, 108, 19);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("customerID");
		lblNewLabel_2.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 103, 79, 13);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("vehicle model");
		lblNewLabel_4.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		lblNewLabel_4.setBounds(10, 126, 108, 13);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("vehicle type");
		lblNewLabel_5.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		lblNewLabel_5.setBounds(10, 149, 86, 19);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_9 = new JLabel("vehicle color");
		lblNewLabel_9.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		lblNewLabel_9.setBackground(SystemColor.menu);
		lblNewLabel_9.setBounds(10, 178, 96, 13);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_7 = new JLabel("vehicle year");
		lblNewLabel_7.setFont(new Font("Book Antiqua", Font.BOLD, 14));
		lblNewLabel_7.setBounds(10, 201, 86, 13);
		panel.add(lblNewLabel_7);
		
	
		
		vehid = new JTextField();
		vehid.setBounds(128, 75, 96, 19);
		panel.add(vehid);
		vehid.setColumns(10);
		
		vehcolor = new JTextField();
		vehcolor.setBounds(128, 176, 96, 19);
		panel.add(vehcolor);
		vehcolor.setColumns(10);
		
		JComboBox vehmodel = new JComboBox();
		vehmodel.setModel(new DefaultComboBoxModel(new String[] {"Hyundai", "Mahindra", "Tata", "Maruti", "Toyota ", "Nissan", "Kia", "Benz", "Audi", "Lexus", "BMW", "Skoda", "Mini", "Range Rover", "Renault", "Honda", "Yamaha", "TVS", "Hero", "Royal Enfield", "Suzuki", "Jawa"}));
		vehmodel.setBounds(128, 123, 96, 21);
		panel.add(vehmodel);
		
		JComboBox vehtype = new JComboBox();
		vehtype.setModel(new DefaultComboBoxModel(new String[] {"SUV", "Hatchback", "Crossover", "Convertible", "Sedan", "Sports Car", "Coupe", "Minivan", "Station Wagon", "Bike-Standard", "Bike-Cruiser", "Bike-Off-road", "Bike-Dual-purpose"}));
		vehtype.setBounds(128, 149, 96, 21);
		panel.add(vehtype);
		
		JComboBox vehyear = new JComboBox();
		vehyear.setModel(new DefaultComboBoxModel(new String[] {"1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023"}));
		vehyear.setBounds(128, 198, 96, 21);
		panel.add(vehyear);
		
		JButton btnaddcust = new JButton("ADD");
		btnaddcust.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try

				{

				Class.forName("oracle.jdbc.driver.OracleDriver");

				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca","mca");

				Statement stmt=con.createStatement();

				PreparedStatement pstmt = con.prepareStatement("insert into vehicle values(?,?,?,?,?,?)");

				ResultSet rsuid=stmt.executeQuery("select count(vehid) from vehicle");

				rsuid.next();

				int vehid=rsuid.getInt(1);

				int newvehid=vehid+1;

				pstmt.setInt(1, newvehid);

				pstmt.setString(2, custid.getText());

				pstmt.setString(3, vehmodel.getSelectedItem().toString());
				
				pstmt.setString(4, vehtype.getSelectedItem().toString());

				pstmt.setString(5, vehcolor.getText());
				
				pstmt.setString(6, vehyear.getSelectedItem().toString());
				
//				LocalDate myObj = LocalDate.now(); // Create a date object
//			    System.out.println(myObj);
			    
				

				pstmt.executeUpdate();

				System.out.println("Insertion successful");

				//

				// frame.setVisible(false);

				// new Login().setVisible(true);

				}catch (Exception e1 ) {System.out.println(e1);}
			}
		});
		btnaddcust.setFont(new Font("Book Antiqua", Font.BOLD, 12));
		btnaddcust.setBounds(23, 272, 85, 21);
		panel.add(btnaddcust);
		
		JButton btnNewButton_2 = new JButton("Display");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
                {
                Class.forName("oracle.jdbc.driver.OracleDriver");    
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca","mca");
                Statement stmt=con.createStatement();                
            
                ResultSet rs=stmt.executeQuery("select * from vehicle");
                
                while(rs.next()) {
                    String vehid=String.valueOf(rs.getInt("vehid"));
                    String custid=rs.getString("id");
                    String vehmodel=rs.getString("vehmodel");
                    String vehtype=rs.getString("vehtype");
                    String vehcolor=rs.getString("vehcolor");
                    String vehyear=rs.getString("vehyear");
//                    Date date_chooser=rs.getDate("currentdate");
                    
                    
                    String tbData[]= {vehid,custid,vehmodel,vehtype,vehcolor,vehyear};
                    DefaultTableModel tblModel=(DefaultTableModel)table.getModel();
                    tblModel.addRow(tbData);
                    
                }
                
            }catch (Exception e1 ) {System.out.println(e1);}
			}
		});
		btnNewButton_2.setBounds(128, 272, 85, 21);
		panel.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(256, 119, 578, 215);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Vehicle ID", "Customer ID", "Vehicle Model", "Vehicle Type", "Vehicle Color", "Vehicle Year"
			}
		));
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new dashpage().setVisible(true);
			}
		});
		btnNewButton_3.setBounds(77, 313, 85, 21);
		panel.add(btnNewButton_3);
		
		custid = new JTextField();
		custid.setBounds(128, 97, 96, 19);
		panel.add(custid);
		custid.setColumns(10);
	
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Delete", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel(" Automobile Service Center");
		lblNewLabel_6.setFont(new Font("Book Antiqua", Font.BOLD, 16));
		lblNewLabel_6.setBounds(10, 10, 220, 34);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_9_1_1_1 = new JLabel("New label");
		lblNewLabel_9_1_1_1.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\iloveimg-resized (1)\\vehicle.png"));
		lblNewLabel_9_1_1_1.setBounds(679, 11, 119, 110);
		panel_1.add(lblNewLabel_9_1_1_1);
		
		JLabel lblNewLabel_7_1 = new JLabel("Enter id to delete:");
		lblNewLabel_7_1.setBounds(30, 85, 85, 13);
		panel_1.add(lblNewLabel_7_1);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(125, 82, 96, 19);
		panel_1.add(t2);
		
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
                  String vid=t2.getText();
                  PreparedStatement stmt=con.prepareStatement("Delete from vehicle where id="+vid+"");
                  stmt.execute();
                  System.out.println("Deletion successful");
                  
              }catch (Exception e1 ) {System.out.println(e1);}
				
			}
		});
		btnNewButton.setBounds(289, 81, 85, 21);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Display");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
                {
                Class.forName("oracle.jdbc.driver.OracleDriver");    
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca","mca");
                Statement stmt=con.createStatement();                
            
                ResultSet rs=stmt.executeQuery("select * from vehicle");
                
                while(rs.next()) {
                	String vehid=String.valueOf(rs.getInt("vehid"));
                    String custid=rs.getString("id");
                    String vehmodel=rs.getString("vehmodel");
                    String vehtype=rs.getString("vehtype");
                    String vehcolor=rs.getString("vehcolor");
                    String vehyear=rs.getString("vehyear");
//                    Date date_chooser=rs.getDate("currentdate");
                    
                    
                    String tbData1[]= {vehid,custid,vehmodel,vehtype,vehcolor,vehyear,};
                    DefaultTableModel tblModel1=(DefaultTableModel)table_1.getModel();
                    tblModel1.addRow(tbData1);
                    
                }
                
            }catch (Exception e1 ) {System.out.println(e1);}
			}
		});
		btnNewButton_1.setBounds(418, 81, 85, 21);
		panel_1.add(btnNewButton_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 131, 831, 206);
		panel_1.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Vehicle ID", "Customer ID", "Vehicle Model", "Vechicle Type", "Vehicle Color", "Vehicle Year"
			}
		));
		
		JLabel lblNewLabel_10_1 = new JLabel("Vehicle Manage");
		lblNewLabel_10_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_10_1.setBounds(343, 33, 160, 22);
		panel_1.add(lblNewLabel_10_1);
		
		JLabel lblNewLabel_11 = new JLabel("New label");
		lblNewLabel_11.setIcon(new ImageIcon("D:\\sem2java\\asdfg.jpg"));
		lblNewLabel_11.setBounds(-12, 0, 889, 369);
		panel_1.add(lblNewLabel_11);
	}
}
