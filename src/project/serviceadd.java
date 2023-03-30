package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.raven.datechooser.DateBetween;
import com.raven.datechooser.DateChooser;
import com.raven.datechooser.listener.DateChooserAction;
import com.raven.datechooser.listener.DateChooserListener;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;

public class serviceadd extends JFrame {

	private JPanel contentPane;
	private JTextField serid;
	private JTextField vehicid;
	private JTextField sergivendate;
	private JTextField serreturndate;
	private JTextField amount;
	private JFrame Frame;
	private JTextField t3;
	private JTable table_1;
	private JTable table;
	
	DateChooser dc;
	java.sql.Date endDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					serviceadd frame = new serviceadd();
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
	public serviceadd() {
		Frame=this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 949, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 49, 933, 359);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Add", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" Automobile Service Center");
		lblNewLabel.setFont(new Font("Book Antiqua", Font.BOLD, 16));
		lblNewLabel.setBounds(21, 10, 220, 34);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_8 = new JLabel("Sevice Manage");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_8.setBounds(313, 22, 151, 21);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\iloveimg-resized (1)\\servicedone.png"));
		lblNewLabel_9.setBounds(736, 10, 114, 133);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_4 = new JLabel("Service ID");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(10, 56, 97, 13);
		panel.add(lblNewLabel_4);
		
		serid = new JTextField();
		serid.setColumns(10);
		serid.setBounds(124, 54, 96, 19);
		panel.add(serid);
		
		JLabel lblNewLabel_1_1 = new JLabel("Vehicle ID");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(250, 53, 67, 13);
		panel.add(lblNewLabel_1_1);
		
		vehicid = new JTextField();
		vehicid.setColumns(10);
		vehicid.setBounds(377, 53, 96, 19);
		panel.add(vehicid);
		
		JLabel lblNewLabel_2 = new JLabel("Service Type");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(501, 56, 97, 13);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_6 = new JLabel("Service GiveDate");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(10, 106, 104, 13);
		panel.add(lblNewLabel_6);
		
		sergivendate = new JTextField();
		sergivendate.setColumns(10);
		sergivendate.setBounds(124, 104, 96, 19);
		panel.add(sergivendate);
		
		JLabel lblNewLabel_5 = new JLabel("Service ReturnDate");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(241, 106, 126, 13);
		panel.add(lblNewLabel_5);
		
		serreturndate = new JTextField();
		serreturndate.setColumns(10);
		serreturndate.setBounds(377, 104, 96, 19);
		panel.add(serreturndate);
		
		dc = new DateChooser();
		dc.setDateFormat(new SimpleDateFormat("dd-MMMM-yyyy"));
		dc.addActionDateChooserListener(new DateChooserListener() {

			@Override
			public void dateChanged(Date arg0, DateChooserAction arg1) {
				// TODO Auto-generated method stub
				endDate = new java.sql.Date(arg0.getTime());
				System.out.println(arg0);
		
			}

			@Override
			public void dateBetweenChanged(DateBetween arg0, DateChooserAction arg1) {
				// TODO Auto-generated method stub

			}

		});
		
		dc.setTextField(serreturndate);

		
		JLabel lblNewLabel_7 = new JLabel("Amount");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setBounds(510, 106, 78, 13);
		panel.add(lblNewLabel_7);
		
		amount = new JTextField();
		amount.setColumns(10);
		amount.setBounds(589, 104, 96, 19);
		panel.add(amount);
		
		JComboBox servtype = new JComboBox();
		servtype.setBounds(589, 53, 97, 21);
		panel.add(servtype);
		
		try
        {
        Class.forName("oracle.jdbc.driver.OracleDriver");    
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca","mca");
        Statement stmt=con.createStatement();                
    
        ResultSet rs=stmt.executeQuery("select * from services");
        
        while(rs.next()) {
            servtype.addItem(rs.getString(2));
            
 
        }
        
    }catch (Exception e1 ) {System.out.println(e1);}
	
		
		JButton btnaddcust = new JButton("ADD");
		btnaddcust.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try

				{

				Class.forName("oracle.jdbc.driver.OracleDriver");

				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca","mca");

				Statement stmt=con.createStatement();

				PreparedStatement pstmt = con.prepareStatement("insert into complaints values(?,?,?,?,?,?)");

				ResultSet rsuid=stmt.executeQuery("select count(serid) from complaints");

				rsuid.next();

				int serid=rsuid.getInt(1);

				int newserid=serid+1;

				pstmt.setInt(1, newserid);

				pstmt.setString(2, vehicid.getText());

				pstmt.setString(3, null);

				pstmt.setDate(4,new java.sql.Date(new Date().getTime()));
				
				pstmt.setDate(5, endDate);
				
				pstmt.setString(6, amount.getText());
				

				pstmt.executeUpdate();
				
				pstmt = con.prepareStatement("INSERT INTO service_opted values(?,?)");
				Statement st = con.createStatement();
				ResultSet sid = st.executeQuery("SELECT sid from services where sname='"+servtype.getSelectedItem().toString()+"'");
				sid.next();
				String s = sid.getString(1);
				
				pstmt.setString(1, String.valueOf(newserid));
				pstmt.setString(2, s);
				pstmt.executeUpdate();

				System.out.println("Insertion successful");

				//

				// frame.setVisible(false);

				// new Login().setVisible(true);

				}catch (Exception e2 ) {System.out.println(e2);}
			}
		});
		btnaddcust.setFont(new Font("Book Antiqua", Font.BOLD, 12));
		btnaddcust.setBounds(623, 157, 85, 21);
		panel.add(btnaddcust);
		
		
	
		
		
		JButton btnNewButton_2 = new JButton("DISPLAY");
		btnNewButton_2.setFont(new Font("Book Antiqua", Font.BOLD, 10));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
                {
                Class.forName("oracle.jdbc.driver.OracleDriver");    
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca","mca");
                Statement stmt=con.createStatement();                
            
                ResultSet rs=stmt.executeQuery("select * from complaints");
                
                while(rs.next()) {
                    String serid=String.valueOf(rs.getInt("serid"));
                    String vehicid=rs.getString("vehid");
                    String servtype=rs.getString("sertype");
                    String sergivendate=rs.getString("sergivendate");
                    String serreturndate=rs.getString("serreturndate");
                    String amount=rs.getString("amount");
                    
                    
                    String tbData[]= {serid,vehicid,servtype,sergivendate,serreturndate,amount};
                    DefaultTableModel tblModel=(DefaultTableModel)table.getModel();
                    tblModel.addRow(tbData);
                    
                }
                
            }catch (Exception e1 ) {System.out.println(e1);}
			}
		});
		btnNewButton_2.setBounds(718, 153, 85, 21);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.setFont(new Font("Book Antiqua", Font.BOLD, 10));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new dashpage().setVisible(true);
			}
		});
		btnNewButton.setBounds(813, 153, 85, 21);
		panel.add(btnNewButton);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 189, 885, 121);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Sevice Id", "Vehicle Id", "Service Type", "Service Given Date", "Service Return Date", "Amount"
			}
		));
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Delete", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(10, 54, 45, 13);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_7_1 = new JLabel("Enter id to delete:");
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7_1.setBounds(20, 77, 119, 21);
		panel_1.add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_6_1 = new JLabel(" Automobile Service Center");
		lblNewLabel_6_1.setFont(new Font("Book Antiqua", Font.BOLD, 16));
		lblNewLabel_6_1.setBounds(10, 10, 220, 34);
		panel_1.add(lblNewLabel_6_1);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(169, 77, 108, 27);
		panel_1.add(t3);
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel tblModel=(DefaultTableModel)table_1.getModel();
//              if(table_1.getSelectedRowCount()==1) {
                  tblModel.removeRow(table_1.getSelectedRow());
                  try
                  {
                  Class.forName("oracle.jdbc.driver.OracleDriver");    
                  Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca","mca");
                  String servid=t3.getText();
                  PreparedStatement stmt=con.prepareStatement("Delete from service where serid="+servid+"");
                  stmt.execute();
                  System.out.println("Deletion successful");
                  
              }catch (Exception e1 ) {System.out.println(e1);}
			}
		});
		btnNewButton_1.setBounds(296, 73, 85, 34);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Display");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
                {
                Class.forName("oracle.jdbc.driver.OracleDriver");    
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","mca","mca");
                Statement stmt=con.createStatement();                
            
                ResultSet rs=stmt.executeQuery("select * from complaints");
                
                while(rs.next()) {
                	String serid=String.valueOf(rs.getInt("serid"));
                    String vehi=rs.getString("vehid");
                    String servtype=rs.getString("servtype");
                    String sergivendate=rs.getString("sergivendate");
                    String serreturndate=rs.getString("serreturndate");
                    String amount=rs.getString("amount");
                    
                    
                    String tbData1[]= {serid,vehi,servtype,sergivendate,serreturndate,amount};
                    DefaultTableModel tblModel1=(DefaultTableModel)table_1.getModel();
                    tblModel1.addRow(tbData1);
                    
                }
                
            }catch (Exception e1 ) {System.out.println(e1);}
			}
			
		});
		btnNewButton_1_1.setBounds(408, 73, 96, 34);
		panel_1.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_9_1 = new JLabel("New label");
		lblNewLabel_9_1.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\iloveimg-resized (1)\\servicedone.png"));
		lblNewLabel_9_1.setBounds(720, 17, 114, 133);
		panel_1.add(lblNewLabel_9_1);
		
		JLabel lblNewLabel_8_1 = new JLabel("Sevice Manage");
		lblNewLabel_8_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_8_1.setBounds(365, 22, 151, 21);
		panel_1.add(lblNewLabel_8_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(56, 142, 804, 169);
		panel_1.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Service ID", "Vehicle ID",  "Service Type", "Service Given Date", "Service Return Date", "Amount"
			}
		));
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon("D:\\sem2java\\asdfg.jpg"));
		lblNewLabel_11.setBounds(0, 0, 928, 332);
		panel_1.add(lblNewLabel_11);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(105);
		table_1.getColumnModel().getColumn(5).setPreferredWidth(106);
		
		
		
		
	}
}
