package C_PanelsDashboards;

import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Component;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

import D_Forms.A_EmployeeForms;
import D_Forms.B_EmployeePayroll;

import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.management.modelmbean.ModelMBean;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class D_PayrollPageUser extends JPanel{
	
	
	private JTextField textField;

	
	private JTable table;
	
	DefaultTableModel tbModel;

	private Image iconPayroll = new ImageIcon
			("src/res/iconPayroll.png")
			.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
	private Image iconRefresh = new ImageIcon
			("src/Imagespanels/Refresh.png")
			.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);

	/**
	 * Create the panel.
	 */
	public D_PayrollPageUser(String firstname) {
		setBackground(new Color(51, 51, 51));
		setBounds(0, 0, 936, 656);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 51, 51));
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel.setBounds(0, 176, 936, 480);
		add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 919, 458);
		scrollPane.setBorder(new LineBorder(new Color(130, 135, 144), 0));
		scrollPane.setForeground(new Color(0, 0, 0));
		scrollPane.setBackground(new Color(0, 0, 0));
		panel.add(scrollPane);
		
		table = new JTable();
		table.setSelectionForeground(new Color(0, 0, 0));
		table.setFont(new Font("Tahoma", Font.BOLD, 10));
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
					"Employee ID", "Firstname", "Lastname", "Date", "Days per Year", "DailyRate", "Overtime", "Gross Salary", "Tax", "SSS", "PhilHealth", "Pag-Ibig", "SSS Loan", "PhilHealth Loan", "Pag-Ibig Loan", "Absences", "Tardiness", "Undertime", "Total Deduction", "Net Salary"
			}
		) {
			boolean[] columnEditables = new boolean[] {
					false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(2).setPreferredWidth(79);
		table.getColumnModel().getColumn(4).setPreferredWidth(107);
		table.getColumnModel().getColumn(6).setPreferredWidth(48);
		table.getColumnModel().getColumn(7).setPreferredWidth(58);
		table.getColumnModel().getColumn(8).setPreferredWidth(50);
		table.getColumnModel().getColumn(9).setPreferredWidth(55);
		table.getColumnModel().getColumn(10).setPreferredWidth(85);
		
		
		JTableHeader THeader = table.getTableHeader();
		THeader.setBackground(new Color(102, 0, 0));
		THeader.setForeground(Color.white);
		THeader.setFont(new Font("Bookman Old Style", Font.BOLD, 10));
		
		DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
		centerRender.setHorizontalAlignment(JLabel.CENTER);
		for(int x = 0; x < 20; x++) {
			table.getColumnModel().getColumn(x).setCellRenderer(centerRender);
		}
		
		JLabel lblNewLabel = new JLabel("Payroll");
		lblNewLabel.setFont(new Font("Britannic Bold", Font.BOLD, 50));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(447, 0, 174, 79);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				DefaultTableModel tables = (DefaultTableModel)table.getModel();
				String search = textField.getText().toLowerCase();
				TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(tables);
				table.setRowSorter(tr);
				tr.setRowFilter(RowFilter.regexFilter(search));
			}
		});
		textField.setBounds(306, 90, 377, 25);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Search Your Payroll");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(89, 81, 207, 34);
		add(lblNewLabel_1);
		
		DefaultTableModel tableres = (DefaultTableModel)table.getModel();
		tableres.setRowCount(0);
		fillTable(firstname);
		
		JLabel lblEmployeeicon = new JLabel("");
		lblEmployeeicon.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmployeeicon.setBounds(631, 11, 105, 60);
		lblEmployeeicon.setIcon(new ImageIcon(iconPayroll));
		add(lblEmployeeicon);
		
		JLabel btnRefresh = new JLabel("");
		btnRefresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel tableres = (DefaultTableModel)table.getModel();
				tableres.setRowCount(0);
				fillTable(firstname);
			}
		});
		btnRefresh.setBounds(705, 81, 63, 49);
		btnRefresh.setIcon(new ImageIcon(iconRefresh));
		add(btnRefresh);
		
		JLabel lbls = new JLabel("'s");
		lbls.setHorizontalAlignment(SwingConstants.RIGHT);
		lbls.setForeground(Color.WHITE);
		lbls.setFont(new Font("Britannic Bold", Font.BOLD, 50));
		lbls.setBounds(411, 0, 34, 79);
		add(lbls);
		
		JLabel lblFirstname = new JLabel("");
		lblFirstname.setText(firstname);	
		lblFirstname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFirstname.setForeground(Color.WHITE);
		lblFirstname.setFont(new Font("Britannic Bold", Font.BOLD, 50));
		lblFirstname.setBounds(93, 0, 316, 79);
		add(lblFirstname);
		
		JLabel lblNewLabel_1_1 = new JLabel("Check your Payroll History");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1_1.setBounds(10, 126, 916, 43);
		add(lblNewLabel_1_1);
	}
	public void fillTable(String firstname) {
		
	
			try {
				Connection con = DriverManager.getConnection("jdbc:sqlite:src/Database/usersDatabase.db");
				Statement state = con.createStatement();
				ResultSet set = state.executeQuery("SELECT * FROM usersPayroll WHERE Firstname ='"+ firstname+"'"); 
				
				tbModel = (DefaultTableModel)table.getModel();
				
				while(set.next()) {
					Object rows[] = new Object[table.getColumnCount()];
					rows[0] = set.getInt("Id");
					rows[1] = set.getString("Firstname");
					rows[2] = set.getString("Lastname");
					rows[3] = set.getString("Date");
					rows[4] = set.getString("DaysPerYear");	
					rows[5] = set.getString("DailyRate");	
					rows[6] = set.getString("Overtime");
					rows[7] = set.getString("GrossSalary");	
					rows[8] = set.getString("Tax");
					rows[9] = set.getString("SSS");
					rows[10] = set.getString("PhilHealth");	
					rows[11] = set.getString("Pagibig");	
					rows[12] = set.getString("SSSLoan");
					rows[13] = set.getString("PhilHealthLoan");	
					rows[14] = set.getString("PagibigLoan");
					rows[15] = set.getString("Absences");	
					rows[16] = set.getString("Tardiness");	
					rows[17] = set.getString("Undertime");	
					rows[18] = set.getString("TotalDeduction");
					rows[19] = set.getString("NetSalary");
					
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
