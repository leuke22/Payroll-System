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
import javax.swing.table.TableRowSorter;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.management.modelmbean.ModelMBean;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Cursor;

public class B_AttendanceAdminPage extends JPanel{
	
	
	private JTextField textField;

	
	private JTable table;
	
	DefaultTableModel tbModel;

	private Image iconAttendance = new ImageIcon
			("src/res/iconAtteandance.png")
			.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
	/**
	 * Create the panel.
	 */
	public B_AttendanceAdminPage() {
		setBackground(new Color(51, 51, 51));
		setBounds(0, 0, 936, 656);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 51, 51));
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel.setBounds(0, 142, 936, 514);
		add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(130, 135, 144), 0));
		scrollPane.setForeground(new Color(0, 0, 0));
		scrollPane.setBackground(new Color(0, 0, 0));
		scrollPane.setBounds(10, 11, 914, 492);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setSelectionForeground(new Color(0, 0, 0));
		table.setFont(new Font("Tahoma", Font.BOLD, 13));
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
				"Employee ID", "Firstname",  "Lastname", "Start Time", "Time In", "End Time", "Time Out", "Hours", "Date", "Status"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		JTableHeader THeader = table.getTableHeader();
		THeader.setBackground(new Color(102, 0, 0));
		THeader.setForeground(Color.white);
		THeader.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		
		DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
		centerRender.setHorizontalAlignment(JLabel.CENTER);
		for(int x = 0; x < 10; x++) {
			table.getColumnModel().getColumn(x).setCellRenderer(centerRender);
		}
		
		JLabel lblNewLabel = new JLabel("Attendance of Employees");
		lblNewLabel.setFont(new Font("Britannic Bold", Font.BOLD, 50));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(0, 0, 700, 63);
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
		textField.setBounds(230, 85, 360, 25);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Search Employeee");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(25, 81, 198, 34);
		add(lblNewLabel_1);
		
		fillTable();
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setFocusable(false);
		btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdate.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnUpdate.setBackground(new Color(0, 0, 0));
		btnUpdate.setForeground(new Color(255, 255, 255));
		btnUpdate.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 30));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

					try {
						tbModel = (DefaultTableModel)table.getModel();
						Connection con = DriverManager.getConnection("jdbc:sqlite:src/Database/usersDatabase.db");
						
						
						for (int i = 0; i <tbModel.getRowCount(); i++) {
							
							int Id = Integer.valueOf(tbModel.getValueAt(i, 0).toString());
							String Firstname = tbModel.getValueAt(i, 1).toString();
							String Lastname = tbModel.getValueAt(i, 2).toString();
							String StartTime = tbModel.getValueAt(i, 3).toString();
							String TimeIn = tbModel.getValueAt(i, 4).toString();
							String EndTime = tbModel.getValueAt(i, 5).toString();
							String TimeOut = tbModel.getValueAt(i, 6).toString();
							String Timer = tbModel.getValueAt(i, 7).toString();
							String Date = tbModel.getValueAt(i, 8).toString();
							String Status = tbModel.getValueAt(i, 9).toString();
							
							String updatequery = "UPDATE usersAttendance SET Firstname = '"+ Firstname + "',  Lastname = '" + Lastname + "', StartTime = '" + StartTime + "', TimeIn = '"+ TimeIn+ 
									"', EndTime = '"+ EndTime +"',TimeOut = '"+ TimeOut + "', Timer = '"+ Timer +"', Date = '"+ Date + "', Status = '"+ Status +"' WHERE Id = '"+ Id + "'";
							PreparedStatement state = con.prepareStatement(updatequery);
							
							state.executeUpdate();
							int[] updatedRow = state.executeBatch();
							JOptionPane.showMessageDialog(null, "Data Updated Succesfully, We Have " + updatedRow.length + " Employees");
							
							state.close();
							con.close();	
						}
					
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
			}
		});
		btnUpdate.setBounds(612, 74, 150, 57);
		add(btnUpdate);
		
		JButton btnDeleted = new JButton("DELETE");
		btnDeleted.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDeleted.setBackground(new Color(0, 0, 0));
		btnDeleted.setForeground(new Color(255, 255, 255));
		btnDeleted.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 30));
		btnDeleted.setFocusable(false);
		btnDeleted.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnDeleted.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection con = DriverManager.getConnection("jdbc:sqlite:src/Database/usersDatabase.db");
					tbModel = (DefaultTableModel)table.getModel();
					int row = table.getSelectedRow();
					String cell = table.getModel().getValueAt(row, 0).toString();
					String sql = "DELETE FROM usersAttendance WHERE Id = " + cell;
					
					PreparedStatement state = con.prepareStatement(sql);
					state.executeUpdate();
					JOptionPane.showMessageDialog(null, "Data Deleted Succesfully");
					tbModel.setRowCount(0);
					fillTable();
					
					state.close();
					con.close();					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			

			}
		});
		btnDeleted.setBounds(781, 74, 145, 57);
		add(btnDeleted);
		
		JLabel lblAttendanceIcon = new JLabel("");
		lblAttendanceIcon.setBounds(722, 3, 103, 60);
		lblAttendanceIcon.setIcon(new ImageIcon(iconAttendance));
		add(lblAttendanceIcon);
	}
	public void fillTable() {
		//String query = "SELECT * FROM usersAttendance WHERE id ='"+ id +"', firstname ='"+ firstname +
		//"', StartTime = '"+ StartTime + "', TimeIn = '"+ TimeIn + "',EndTime = '"+ EndTime + "' TimeOut = '" + TimeOut + "', Timer = '"+ Timer + "'";
			try {
				Connection con = DriverManager.getConnection("jdbc:sqlite:src/Database/usersDatabase.db");
				Statement state = con.createStatement();
				ResultSet set = state.executeQuery("SELECT * FROM usersAttendance"); 
				
				tbModel = (DefaultTableModel)table.getModel();
				
				while(set.next()) {
					Object rows[] = new Object[table.getColumnCount()];
					rows[0] = set.getInt("Id");
					rows[1] = set.getString("Firstname");
					rows[2] = set.getString("Lastname");
					rows[3] = set.getString("StartTime");
					rows[4] = set.getString("TimeIn");	
					rows[5] = set.getString("EndTime");	
					rows[6] = set.getString("TimeOut");	
					rows[7] = set.getString("Timer");
					rows[8] = set.getString("Date");	
					rows[9] = set.getString("Status");	
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
