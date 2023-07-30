package D_Forms;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class C_EmployeeID extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmployeeId;
	private JTextField txtFirstname;
	private JTextField txtNational;
	private JTextField txtPhilhealth;
	private JTextField txtSSS;
	private JTextField txtPagibig;
	private JTextField txtLastname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
			C_EmployeeID frame = new C_EmployeeID();
			frame.setVisible(true);
		
	}

	/**
	 * Create the frame.
	 */
	public C_EmployeeID() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 326, 502);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Employee ID Information");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 37));
		lblNewLabel_1.setBounds(10, 11, 309, 40);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Employee Id (Optional) :");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblNewLabel.setBounds(20, 62, 280, 17);
		contentPane.add(lblNewLabel);
		
		txtEmployeeId = new JTextField();
		txtEmployeeId.setForeground(Color.BLACK);
		txtEmployeeId.setFont(new Font("Arial Black", Font.BOLD, 15));
		txtEmployeeId.setDisabledTextColor(Color.BLACK);
		txtEmployeeId.setColumns(10);
		txtEmployeeId.setBounds(20, 90, 280, 20);
		contentPane.add(txtEmployeeId);
		
		JLabel lblFirstname = new JLabel("Firstname : ");
		lblFirstname.setForeground(Color.WHITE);
		lblFirstname.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblFirstname.setBounds(20, 115, 280, 17);
		contentPane.add(lblFirstname);
		
		txtFirstname = new JTextField();
		txtFirstname.setForeground(Color.BLACK);
		txtFirstname.setFont(new Font("Arial Black", Font.BOLD, 15));
		txtFirstname.setDisabledTextColor(Color.BLACK);
		txtFirstname.setColumns(10);
		txtFirstname.setBounds(20, 141, 280, 20);
		contentPane.add(txtFirstname);
		
		JLabel lblNationalId = new JLabel("National ID : ");
		lblNationalId.setForeground(Color.WHITE);
		lblNationalId.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblNationalId.setBounds(20, 215, 280, 17);
		contentPane.add(lblNationalId);
		
		txtNational = new JTextField();
		txtNational.setForeground(Color.BLACK);
		txtNational.setFont(new Font("Arial Black", Font.BOLD, 15));
		txtNational.setDisabledTextColor(Color.BLACK);
		txtNational.setColumns(10);
		txtNational.setBounds(20, 238, 280, 20);
		contentPane.add(txtNational);
		
		JLabel lblPhilhealthId = new JLabel("PhilHealth ID : ");
		lblPhilhealthId.setForeground(Color.WHITE);
		lblPhilhealthId.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblPhilhealthId.setBounds(20, 266, 280, 17);
		contentPane.add(lblPhilhealthId);
		
		txtPhilhealth = new JTextField();
		txtPhilhealth.setForeground(Color.BLACK);
		txtPhilhealth.setFont(new Font("Arial Black", Font.BOLD, 15));
		txtPhilhealth.setDisabledTextColor(Color.BLACK);
		txtPhilhealth.setColumns(10);
		txtPhilhealth.setBounds(20, 286, 280, 20);
		contentPane.add(txtPhilhealth);
		
		JLabel lblNationalId_1_1 = new JLabel("SSS ID : ");
		lblNationalId_1_1.setForeground(Color.WHITE);
		lblNationalId_1_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblNationalId_1_1.setBounds(20, 308, 280, 17);
		contentPane.add(lblNationalId_1_1);
		
		txtSSS = new JTextField();
		txtSSS.setForeground(Color.BLACK);
		txtSSS.setFont(new Font("Arial Black", Font.BOLD, 15));
		txtSSS.setDisabledTextColor(Color.BLACK);
		txtSSS.setColumns(10);
		txtSSS.setBounds(20, 330, 280, 20);
		contentPane.add(txtSSS);
		
		JLabel lblNationalId_1_1_1 = new JLabel("Pag-Ibig ID : ");
		lblNationalId_1_1_1.setForeground(Color.WHITE);
		lblNationalId_1_1_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblNationalId_1_1_1.setBounds(20, 354, 280, 17);
		contentPane.add(lblNationalId_1_1_1);
		
		txtPagibig = new JTextField();
		txtPagibig.setForeground(Color.BLACK);
		txtPagibig.setFont(new Font("Arial Black", Font.BOLD, 15));
		txtPagibig.setDisabledTextColor(Color.BLACK);
		txtPagibig.setColumns(10);
		txtPagibig.setBounds(20, 376, 280, 20);
		contentPane.add(txtPagibig);
		
		JLabel lblNationalId_1_1_1_1 = new JLabel("Lastname :");
		lblNationalId_1_1_1_1.setForeground(Color.WHITE);
		lblNationalId_1_1_1_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblNationalId_1_1_1_1.setBounds(20, 166, 280, 17);
		contentPane.add(lblNationalId_1_1_1_1);
		
		txtLastname = new JTextField();
		txtLastname.setForeground(Color.BLACK);
		txtLastname.setFont(new Font("Arial Black", Font.BOLD, 15));
		txtLastname.setDisabledTextColor(Color.BLACK);
		txtLastname.setColumns(10);
		txtLastname.setBounds(20, 188, 280, 20);
		contentPane.add(txtLastname);
		
		JButton btnSubmit = new JButton("SUBMIT");
	
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 30));
		btnSubmit.setFocusable(false);
		btnSubmit.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnSubmit.setBackground(Color.BLACK);
		btnSubmit.setBounds(20, 456, 134, 35);
		contentPane.add(btnSubmit);
		
		JButton btnCancel = new JButton("CANCEL");
		
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 30));
		btnCancel.setFocusable(false);
		btnCancel.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnCancel.setBackground(Color.BLACK);
		btnCancel.setBounds(166, 456, 134, 35);
		contentPane.add(btnCancel);
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int Id = Integer.parseInt(txtEmployeeId.getText());
				String Firstname = txtFirstname.getText();
				String Lastname = txtLastname.getText();
				String National = txtNational.getText();
				String PhilHealth = txtPhilhealth.getText();
				String SSS = txtSSS.getText();
				String Pagibig = txtPagibig.getText();
				
				
				try {
					Connection con = DriverManager.getConnection("jdbc:sqlite:src/Database/usersDatabase.db");
					
					PreparedStatement states = con.prepareStatement("INSERT INTO usersId (Id, Firstname, Lastname, NationalId, PhilHealthId, SSSId, PagibigId) VALUES (?,?,?,?,?,?,?)");
					states.setInt(1, Id);
					states.setString(2, Firstname);
					states.setString(3, Lastname);
					states.setString(4, National);
					states.setString(5, PhilHealth);
					states.setString(6, SSS);
					states.setString(7, Pagibig);
					
					int inserted = states.executeUpdate();
				
					
					if (inserted > 0) {
					
						JOptionPane.showMessageDialog(null, "Employee ID Successfully");
						C_EmployeeID.this.dispose();
						
	
						states.close();
						con.close();
					}
				}catch(SQLException e2) {
					e2.printStackTrace();
				}
			}
		});
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				C_EmployeeID.this.dispose();
			}
		});
		
		setLocationRelativeTo(null);
	}
}
