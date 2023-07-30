package C_PanelsDashboards;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Canvas;
import java.awt.Choice;
import java.awt.Color;

import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class A_HomePage extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private Image iconTotalEmployee = new ImageIcon
			("src/Imagespanels/EmployeList.png")
			.getImage().getScaledInstance(100, 80, Image.SCALE_SMOOTH);
	private Image iconOnlineToday = new ImageIcon
			("src/Imagespanels/OnlineToday.png")
			.getImage().getScaledInstance(100, 80, Image.SCALE_SMOOTH);
	private Image iconOntimePercentage = new ImageIcon
			("src/Imagespanels/OntimePercentage.png")
			.getImage().getScaledInstance(100, 80, Image.SCALE_SMOOTH);
	private Image iconOntime = new ImageIcon
			("src/Imagespanels/Ontime.png")
			.getImage().getScaledInstance(100, 80, Image.SCALE_SMOOTH);
	private Image iconOvertime = new ImageIcon
			("src/Imagespanels/Overtime.png")
			.getImage().getScaledInstance(100, 70, Image.SCALE_SMOOTH);
	private Image iconError = new ImageIcon
			("src/Imagespanels/Error.png")
			.getImage().getScaledInstance(100, 80, Image.SCALE_SMOOTH);
	private Image iconNextPage = new ImageIcon
			("src/Imagespanels/Next page.png")
			.getImage().getScaledInstance(30, 25, Image.SCALE_SMOOTH);
	private JLabel lblEmployeeNumbers;
	
	String TotalEmploy = null;
	String UsersOnline = null;
	String OntimePercentage = null;
	String Ontime = null;
	String Overtime = null;
	String Late = null;
	
	DefaultTableModel tbModel;
	private JTable table;

	public A_HomePage() {
		setBackground(new Color(51, 51, 51));
		setBounds(0, 0, 936, 656);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 300, 120);
		panel.setBackground(new Color(0,101,184));
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		add(panel);
		panel.setLayout(null);
		
		lblEmployeeNumbers = new JLabel("");
		lblEmployeeNumbers.setText(TotalEmployees(TotalEmploy));
		lblEmployeeNumbers.setFont(new Font("Tahoma", Font.BOLD, 60));
		lblEmployeeNumbers.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmployeeNumbers.setForeground(new Color(255, 255, 255));
		lblEmployeeNumbers.setBounds(10, 11, 138, 53);
		panel.add(lblEmployeeNumbers);
		
		JLabel lblNewLabel_1 = new JLabel("Total Employees");
		lblNewLabel_1.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(10, 61, 161, 33);
		panel.add(lblNewLabel_1);
		
		JLabel lblTotalEmployee = new JLabel("");
		lblTotalEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalEmployee.setBounds(181, 11, 109, 71);
		lblTotalEmployee.setIcon(new ImageIcon(iconTotalEmployee));
		panel.add(lblTotalEmployee);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0,61,118));
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel_2.setBounds(0, 93, 300, 27);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("More Informaton ");
		lblNewLabel_3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBackground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(0, 0, 213, 27);
		panel_2.add(lblNewLabel_3);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblIconNextPage = new JLabel("");
		lblIconNextPage.setHorizontalAlignment(SwingConstants.LEFT);
		lblIconNextPage.setBounds(215, 0, 85, 27);
		lblIconNextPage.setIcon(new ImageIcon(iconNextPage));
		panel_2.add(lblIconNextPage);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(320, 11, 300, 120);
		panel_1.setBackground(new Color(1,175,174));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel_2_1.setBackground(new Color(0,114,111));
		panel_2_1.setBounds(0, 93, 300, 27);
		panel_1.add(panel_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("More Informaton ");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		lblNewLabel_3_1.setBackground(Color.WHITE);
		lblNewLabel_3_1.setBounds(0, 0, 213, 27);
		panel_2_1.add(lblNewLabel_3_1);
		
		JLabel lblIconNextPage_1 = new JLabel("");
		lblIconNextPage_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblIconNextPage_1.setIcon(new ImageIcon(iconNextPage));
		lblIconNextPage_1.setBounds(215, 0, 85, 27);
		panel_2_1.add(lblIconNextPage_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Online Today");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(10, 59, 120, 33);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblOnlineToday = new JLabel("");
		lblOnlineToday.setHorizontalAlignment(SwingConstants.CENTER);
		lblOnlineToday.setIcon(new ImageIcon(iconOnlineToday));
		lblOnlineToday.setBounds(190, 11, 100, 71);
		panel_1.add(lblOnlineToday);
		
		JLabel lblOnlineNumbers = new JLabel("");
		lblOnlineNumbers.setText(Onlinetoday(UsersOnline));
		lblOnlineNumbers.setHorizontalAlignment(SwingConstants.LEFT);
		lblOnlineNumbers.setForeground(Color.WHITE);
		lblOnlineNumbers.setFont(new Font("Tahoma", Font.BOLD, 60));
		lblOnlineNumbers.setBounds(10, 11, 79, 55);
		panel_1.add(lblOnlineNumbers);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(630, 11, 296, 120);
		panel_1_1.setBackground(new Color(178,0,146));
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel_2_1_1.setBackground(new Color(116,1,96));
		panel_2_1_1.setBounds(0, 93, 296, 27);
		panel_1_1.add(panel_2_1_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("More Informaton ");
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_1_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		lblNewLabel_3_1_1.setBackground(Color.WHITE);
		lblNewLabel_3_1_1.setBounds(0, 0, 205, 27);
		panel_2_1_1.add(lblNewLabel_3_1_1);
		
		JLabel lblIconNextPage_1_1 = new JLabel("");
		lblIconNextPage_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblIconNextPage_1_1.setIcon(new ImageIcon(iconNextPage));
		lblIconNextPage_1_1.setBounds(207, 0, 93, 27);
		panel_2_1_1.add(lblIconNextPage_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("On Time Percentage");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(10, 59, 168, 33);
		panel_1_1.add(lblNewLabel_1_1_1);
		
		JLabel lblOntimePercent = new JLabel("");
		lblOntimePercent.setText(OntimePercentage(OntimePercentage)+ "%");
		lblOntimePercent.setHorizontalAlignment(SwingConstants.LEFT);
		lblOntimePercent.setForeground(Color.WHITE);
		lblOntimePercent.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblOntimePercent.setBounds(10, 11, 175, 53);
		panel_1_1.add(lblOntimePercent);
		
		JLabel lblOntimePercentage = new JLabel("");
		lblOntimePercentage.setHorizontalAlignment(SwingConstants.CENTER);
		lblOntimePercentage.setIcon(new ImageIcon(iconOntimePercentage));
		lblOntimePercentage.setBounds(188, 11, 100, 71);
		panel_1_1.add(lblOntimePercentage);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBounds(10, 142, 300, 120);
		panel_1_1_1.setBackground(new Color(0,167,85));
		panel_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		add(panel_1_1_1);
		panel_1_1_1.setLayout(null);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setLayout(null);
		panel_2_2.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel_2_2.setBackground(new Color(0,111,53));
		panel_2_2.setBounds(0, 93, 300, 27);
		panel_1_1_1.add(panel_2_2);
		
		JLabel lblNewLabel_3_2 = new JLabel("More Informaton ");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_2.setForeground(Color.WHITE);
		lblNewLabel_3_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		lblNewLabel_3_2.setBackground(Color.WHITE);
		lblNewLabel_3_2.setBounds(0, 0, 213, 27);
		panel_2_2.add(lblNewLabel_3_2);
		
		JLabel lblIconNextPage_2 = new JLabel("");
		lblIconNextPage_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblIconNextPage_2.setIcon(new ImageIcon(iconNextPage));
		lblIconNextPage_2.setBounds(215, 0, 85, 27);
		panel_2_2.add(lblIconNextPage_2);
		
		JLabel lblOvertime = new JLabel("");
		lblOvertime.setText(OvertimeToday(Overtime));
		lblOvertime.setHorizontalAlignment(SwingConstants.LEFT);
		lblOvertime.setForeground(Color.WHITE);
		lblOvertime.setFont(new Font("Tahoma", Font.BOLD, 60));
		lblOvertime.setBounds(10, 11, 85, 53);
		panel_1_1_1.add(lblOvertime);
		
		JLabel lblNewLabel_1_2 = new JLabel("Overtime Today");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(10, 59, 137, 33);
		panel_1_1_1.add(lblNewLabel_1_2);
		
		JLabel lblOvertimeToday = new JLabel("");
		lblOvertimeToday.setHorizontalAlignment(SwingConstants.CENTER);
		lblOvertimeToday.setBounds(181, 11, 109, 71);
		lblOvertimeToday.setIcon(new ImageIcon(iconOvertime));
		panel_1_1_1.add(lblOvertimeToday);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBounds(320, 142, 300, 120);
		panel_1_2.setBackground(new Color(255,162,0));
		panel_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panel_1_2);
		panel_1_2.setLayout(null);
		
		JPanel panel_2_2_1 = new JPanel();
		panel_2_2_1.setLayout(null);
		panel_2_2_1.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel_2_2_1.setBackground(new Color(164,75,0));
		panel_2_2_1.setBounds(0, 93, 300, 27);
		panel_1_2.add(panel_2_2_1);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("More Informaton ");
		lblNewLabel_3_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_2_1.setForeground(Color.WHITE);
		lblNewLabel_3_2_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		lblNewLabel_3_2_1.setBackground(Color.WHITE);
		lblNewLabel_3_2_1.setBounds(0, 0, 213, 27);
		panel_2_2_1.add(lblNewLabel_3_2_1);
		
		JLabel lblIconNextPage_2_1 = new JLabel("");
		lblIconNextPage_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblIconNextPage_2_1.setIcon(new ImageIcon(iconNextPage));
		lblIconNextPage_2_1.setBounds(215, 0, 85, 27);
		panel_2_2_1.add(lblIconNextPage_2_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("On Time Today");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_1.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 20));
		lblNewLabel_1_2_1.setBounds(10, 68, 137, 27);
		panel_1_2.add(lblNewLabel_1_2_1);
		
		JLabel lblOntime = new JLabel("");
		lblOntime.setText(OntimeToday(Ontime));
		lblOntime.setHorizontalAlignment(SwingConstants.LEFT);
		lblOntime.setForeground(Color.WHITE);
		lblOntime.setFont(new Font("Tahoma", Font.BOLD, 60));
		lblOntime.setBounds(10, 11, 83, 46);
		panel_1_2.add(lblOntime);
		
		JLabel lblOntimeToday = new JLabel("");
		lblOntimeToday.setHorizontalAlignment(SwingConstants.CENTER);
		lblOntimeToday.setIcon(new ImageIcon(iconOntime));
		lblOntimeToday.setBounds(181, 11, 109, 71);
		panel_1_2.add(lblOntimeToday);
		
		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setBounds(630, 142, 296, 120);
		panel_1_2_1.setBackground(new Color(255,0,10));
		panel_1_2_1.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		add(panel_1_2_1);
		panel_1_2_1.setLayout(null);
		
		JPanel panel_2_1_1_1 = new JPanel();
		panel_2_1_1_1.setLayout(null);
		panel_2_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel_2_1_1_1.setBackground(new Color(156,0,1));
		panel_2_1_1_1.setBounds(0, 93, 296, 27);
		panel_1_2_1.add(panel_2_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("More Informaton ");
		lblNewLabel_3_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_1_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		lblNewLabel_3_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_3_1_1_1.setBounds(0, 0, 205, 27);
		panel_2_1_1_1.add(lblNewLabel_3_1_1_1);
		
		JLabel lblIconNextPage_1_1_1 = new JLabel("");
		lblIconNextPage_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblIconNextPage_1_1_1.setIcon(new ImageIcon(iconNextPage));
		lblIconNextPage_1_1_1.setBounds(207, 0, 93, 27);
		panel_2_1_1_1.add(lblIconNextPage_1_1_1);
		
		JLabel lblLatetoday = new JLabel("");
		lblLatetoday.setText(LateToday(Late));
		lblLatetoday.setHorizontalAlignment(SwingConstants.LEFT);
		lblLatetoday.setForeground(Color.WHITE);
		lblLatetoday.setFont(new Font("Tahoma", Font.BOLD, 60));
		lblLatetoday.setBounds(10, 11, 74, 53);
		panel_1_2_1.add(lblLatetoday);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Late Today");
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_1_1.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 20));
		lblNewLabel_1_2_1_1.setBounds(10, 59, 137, 33);
		panel_1_2_1.add(lblNewLabel_1_2_1_1);
		
		JLabel lblLate = new JLabel("");
		lblLate.setIcon(new ImageIcon(iconError));
		lblLate.setHorizontalAlignment(SwingConstants.CENTER);
		lblLate.setBounds(186, 11, 100, 71);
		panel_1_2_1.add(lblLate);
	
		
		JLabel lblNewLabel = new JLabel("Recent Onlines");
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 40));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 273, 916, 38);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setForeground(Color.BLACK);
		scrollPane.setBorder(new LineBorder(new Color(130, 135, 144), 0));
		scrollPane.setBackground(Color.BLACK);
		scrollPane.setBounds(10, 322, 916, 323);
		add(scrollPane);
		
		table = new JTable();
		table = new JTable();
		table.setSelectionForeground(new Color(0, 0, 0));
		table.setFont(new Font("Tahoma", Font.BOLD, 18));
		table.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		table.setRowMargin(5);
		table.setRowHeight(30);
		table.setSelectionBackground(new Color(255, 255, 255));
		table.setShowHorizontalLines(false);
		table.setBackground(new Color(21, 21, 21));
		table.setGridColor(new Color(255, 255, 255));
		table.setForeground(new Color(255, 255, 255));
		scrollPane.setViewportView(table);
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Employee ID", "FirstName", "Lastname", "Status Online", "Date Online", "Status Offline", "Date Offline", "Date"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
			
		fillTable();
		
		JTableHeader THeader = table.getTableHeader();
		THeader.setBackground(new Color(102, 0, 0));
		THeader.setForeground(Color.white);
		THeader.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
			
		DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
		centerRender.setHorizontalAlignment(JLabel.CENTER);
		for(int x = 0; x < 8; x++) {
			table.getColumnModel().getColumn(x).setCellRenderer(centerRender);
		}
	}
	
	private String TotalEmployees(String count) {
		try {
			Connection con = DriverManager.getConnection("jdbc:sqlite:src/Database/usersDatabase.db");
			String query = "SELECT COUNT(*) FROM users";
			Statement state = con.createStatement();
			ResultSet set = state.executeQuery(query);
				
				if(set.next()) {
					int counts = set.getInt(1);
					count = Integer.toString(counts);
					
					state.close();
					set.close();
					state.close();
				}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	private String Onlinetoday(String count) {
		try {
			Connection con = DriverManager.getConnection("jdbc:sqlite:src/Database/usersDatabase.db");
			String query = "SELECT COUNT(*) FROM usersStatus";
			Statement state = con.createStatement();
			ResultSet set = state.executeQuery(query);
				
				if(set.next()) {
					int counts = set.getInt(1);
					count = Integer.toString(counts);
					
					
					set.close();
					state.close();
					con.close();
				}
				
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	private String OntimePercentage(String count) {
		try {
			Connection con = DriverManager.getConnection("jdbc:sqlite:src/Database/usersDatabase.db");
			
			Statement state = con.createStatement();
			String queries = "SELECT COUNT(*) FROM usersAttendance WHERE Status = 'Ontime'";
			ResultSet set = state.executeQuery(queries);
		
			
			if(set.next()) {
				
				
				String query = "SELECT COUNT(*) FROM usersAttendance";
				ResultSet sets = state.executeQuery(query);
				
				if(sets.next()) {
					
					int numberofLate = set.getInt(1);
					int counts = sets.getInt(1);
					int percentageofLate = (numberofLate / counts) * 100; 
					count = Integer.toString(percentageofLate);
					
					sets.next();
					set.close();
					state.close();
					con.close();
				}
				
			}
			
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	private String OntimeToday(String count) {
		try {
			Connection con = DriverManager.getConnection("jdbc:sqlite:src/Database/usersDatabase.db");
			
			Statement state = con.createStatement();
			ResultSet set = state.executeQuery("SELECT COUNT(*) FROM usersAttendance WHERE Status = 'Ontime';");
			
			if(set.next()) {
				int numberofLate = set.getInt(1);
				count = Integer.toString(numberofLate);

				state.close();
				set.close();
				con.close();
			}
			
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	private String OvertimeToday(String count) {
		try {
			Connection con = DriverManager.getConnection("jdbc:sqlite:src/Database/usersDatabase.db");
			
			Statement state = con.createStatement();
			ResultSet set = state.executeQuery("SELECT COUNT(*) FROM usersAttendance WHERE Status = 'Overtime';");
			
			if(set.next()) {
				int numberofLate = set.getInt(1);
				count = Integer.toString(numberofLate);
				state.close();
				set.close();
				con.close();
			}
			
		
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	private String LateToday(String count) {
		try {
			Connection con = DriverManager.getConnection("jdbc:sqlite:src/Database/usersDatabase.db");
			
			Statement state = con.createStatement();
			ResultSet set = state.executeQuery("SELECT COUNT(*) FROM usersAttendance WHERE Status = 'Late';");
			
			if(set.next()) {
				int numberofLate = set.getInt(1);
				count = Integer.toString(numberofLate);
				
				state.close();
				set.close();
				con.close();
			}
		
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	public void fillTable() {
	
			try {
				Connection con = DriverManager.getConnection("jdbc:sqlite:src/Database/usersDatabase.db");
				Statement state = con.createStatement();
				ResultSet set = state.executeQuery("SELECT * FROM usersStatus"); 
				
				tbModel = (DefaultTableModel)table.getModel();
				
				while(set.next()) {
					Object rows[] = new Object[table.getColumnCount()];
					rows[0] = set.getInt("Id");
					rows[1] = set.getString("Firstname");
					rows[2] = set.getString("Lastname");
					rows[3] = set.getString("StatusOnline");
					rows[4] = set.getString("DateOnline");	
					rows[5] = set.getString("StatusOffline");	
					rows[6] = set.getString("DateOffline");	
					rows[7] = set.getString("Date");	
					
					tbModel.addRow(rows);
				}
				
				state.close();
				set.close();
				con.close();
				
			}catch (SQLException e2) {
				// TODO: handle exception
			}
	}
}

