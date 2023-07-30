package C_PanelsDashboards;

import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

import C_PanelsDashboards.C_EmployeePage.ImageRenderer;
import D_Forms.A_EmployeeForms;
import D_Forms.C_EmployeeID;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class F_EmployeeId extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private JTable table;
	private JTextField textField;

	DefaultTableModel tbModel;
	
	private Image iconEmployeeId = new ImageIcon
			("src/res/iconId.png")
			.getImage().getScaledInstance(70, 60, Image.SCALE_SMOOTH);
	private Image iconRefresh = new ImageIcon
			("src/Imagespanels/Refresh.png")
			.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	
	public F_EmployeeId() {
		setForeground(new Color(128, 128, 128));
		setBackground(new Color(51, 51, 51));
		setBounds(0, 0, 936, 656);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 145, 919, 500);
		scrollPane.setBorder(new LineBorder(new Color(130, 135, 144), 0));
		scrollPane.setForeground(new Color(0, 0, 0));
		scrollPane.setBackground(new Color(0, 0, 0));
		add(scrollPane);
		
		table = new JTable();
		table.setSelectionForeground(new Color(0, 0, 0));
		table.setFont(new Font("Tahoma", Font.BOLD, 15));
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
				"Employee ID",  "Firstname", "Lastname", "National ID", "PhilHealth ID", "SSS ID", "Pag-ibig ID"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		fillTable();
		
		JLabel lblEmployeeId = new JLabel("Employee ID Information");
		lblEmployeeId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmployeeId.setForeground(Color.WHITE);
		lblEmployeeId.setFont(new Font("Britannic Bold", Font.BOLD, 50));
		lblEmployeeId.setBounds(0, 0, 728, 79);
		add(lblEmployeeId);
		
		JLabel lblEmployeeicon = new JLabel("");
		lblEmployeeicon.setIcon(new ImageIcon(iconEmployeeId));
		lblEmployeeicon.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmployeeicon.setBounds(759, 11, 99, 60);
		add(lblEmployeeicon);
		
		JTableHeader THeader = table.getTableHeader();
		THeader.setBackground(new Color(102, 0, 0));
		THeader.setForeground(Color.white);
		THeader.setFont(new Font("Bookman Old Style", Font.BOLD, 13));
		
		DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
		centerRender.setHorizontalAlignment(JLabel.CENTER);
		for(int x = 0; x < 7; x++) {
			table.getColumnModel().getColumn(x).setCellRenderer(centerRender);
		}
		
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
		textField.setBounds(242, 90, 350, 25);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Search Employeee");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(32, 81, 186, 34);
		add(lblNewLabel_1);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 30));
		btnAdd.setFocusable(false);
		btnAdd.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnAdd.setBackground(Color.BLACK);
		btnAdd.setBounds(613, 81, 122, 46);
		add(btnAdd);
		
		JButton btnDeleted = new JButton("DELETE");
		btnDeleted.setForeground(Color.WHITE);
		btnDeleted.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 30));
		btnDeleted.setFocusable(false);
		btnDeleted.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnDeleted.setBackground(Color.BLACK);
		btnDeleted.setBounds(751, 82, 122, 46);
		add(btnDeleted);
		
		JLabel btnRefresh = new JLabel("");
		btnRefresh.setIcon(new ImageIcon(iconRefresh));
		btnRefresh.setBounds(883, 81, 46, 41);
		add(btnRefresh);
		
		btnRefresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel tableres = (DefaultTableModel)table.getModel();
				tableres.setRowCount(0);
				fillTable();
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				C_EmployeeID EmployeeID = new C_EmployeeID();
				EmployeeID.setVisible(true);
			}
		});
		
		btnDeleted.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = DriverManager.getConnection("jdbc:sqlite:src/Database/usersDatabase.db");
					tbModel = (DefaultTableModel)table.getModel();
					int row = table.getSelectedRow();
					String cell = table.getModel().getValueAt(row, 0).toString();
					String sql = "DELETE FROM usersId WHERE Id = " + cell;
					
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
	}
	
	public void fillTable() {

		try {
			Connection con = DriverManager.getConnection("jdbc:sqlite:src/Database/usersDatabase.db");
			Statement state = con.createStatement();
			ResultSet set = state.executeQuery("SELECT * FROM usersId"); 
			
			tbModel = (DefaultTableModel)table.getModel();
			
			while(set.next()) {
				Object rows[] = new Object[table.getColumnCount()];
				rows[0] = set.getInt("Id");
				rows[1] = set.getString("Firstname");
				rows[2] = set.getString("Lastname");
				rows[3] = set.getString("NationalId");
				rows[4] = set.getString("PhilHealthId");	
				rows[5] = set.getString("SSSId");	
				rows[6] = set.getString("PagibigId");	
				
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
