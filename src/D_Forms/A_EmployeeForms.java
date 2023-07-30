package D_Forms;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import C_PanelsDashboards.C_EmployeePage;

import javax.swing.border.LineBorder;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

public class A_EmployeeForms extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtFirstname;
	private JTextField txtLastname;
	private JTextField txtAge;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtEmail;
	private JTextField txtPosition;
	private JLabel lblPath;
	private JButton btnSelectPath;
	
	File f = null;
	String path = null;
	
	private JButton btnSubmit;
	private JDateChooser dateChooser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
			A_EmployeeForms frame = new A_EmployeeForms();
			frame.setVisible(true);
	
	}

	/**
	 * Create the frame.
	 */
	public A_EmployeeForms() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Employee Id (Optional) :");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 130, 280, 17);
		contentPane.add(lblNewLabel);
		
		txtId = new JTextField();
		txtId.setForeground(new Color(0, 0, 0));
		txtId.setDisabledTextColor(new Color(0, 0, 0));
		txtId.setFont(new Font("Arial Black", Font.BOLD, 15));
		txtId.setBounds(10, 152, 280, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JLabel EmployeePicture = new JLabel("");
		EmployeePicture.setBounds(219, 59, 71, 60);
		contentPane.add(EmployeePicture);
		
		JLabel lblFirstname = new JLabel("Firstname : ");
		lblFirstname.setForeground(Color.WHITE);
		lblFirstname.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblFirstname.setBounds(10, 174, 280, 17);
		contentPane.add(lblFirstname);
		
		txtFirstname = new JTextField();
		txtFirstname.setForeground(Color.BLACK);
		txtFirstname.setFont(new Font("Arial Black", Font.BOLD, 15));
		txtFirstname.setDisabledTextColor(Color.BLACK);
		txtFirstname.setColumns(10);
		txtFirstname.setBounds(10, 196, 280, 20);
		contentPane.add(txtFirstname);
		
		JLabel lblLastname = new JLabel("Lastname :");
		lblLastname.setForeground(Color.WHITE);
		lblLastname.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblLastname.setBounds(10, 218, 280, 17);
		contentPane.add(lblLastname);
		
		txtLastname = new JTextField();
		txtLastname.setForeground(Color.BLACK);
		txtLastname.setFont(new Font("Arial Black", Font.BOLD, 15));
		txtLastname.setDisabledTextColor(Color.BLACK);
		txtLastname.setColumns(10);
		txtLastname.setBounds(10, 237, 280, 20);
		contentPane.add(txtLastname);
		
		JLabel lblAge = new JLabel("Age :");
		lblAge.setForeground(Color.WHITE);
		lblAge.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblAge.setBounds(10, 268, 65, 17);
		contentPane.add(lblAge);
		
		txtAge = new JTextField();
		txtAge.setForeground(Color.BLACK);
		txtAge.setFont(new Font("Arial Black", Font.BOLD, 15));
		txtAge.setDisabledTextColor(Color.BLACK);
		txtAge.setColumns(10);
		txtAge.setBounds(10, 290, 100, 20);
		contentPane.add(txtAge);
		
		JLabel lblGender = new JLabel("Gender : ");
		lblGender.setForeground(Color.WHITE);
		lblGender.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblGender.setBounds(128, 268, 128, 17);
		contentPane.add(lblGender);
		
		JRadioButton rdMale = new JRadioButton("Male");
		rdMale.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		rdMale.setFocusable(false);
		rdMale.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		rdMale.setForeground(new Color(255, 255, 255));
		rdMale.setBackground(new Color(51, 51, 51));
		rdMale.setBounds(130, 290, 71, 20);
		contentPane.add(rdMale);
		
		JRadioButton rdFemale = new JRadioButton("Female");
		rdFemale.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		rdFemale.setFocusable(false);
		rdFemale.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		rdFemale.setForeground(new Color(255, 255, 255));
		rdFemale.setBackground(new Color(51, 51, 51));
		rdFemale.setBounds(210, 290, 80, 20);
		
		ButtonGroup rdButtons = new ButtonGroup();
		rdButtons.add(rdMale);
		rdButtons.add(rdFemale);
		
		contentPane.add(rdFemale);
		
		JLabel lblNewLabel_1 = new JLabel("Employee Information");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Bodoni MT Condensed", Font.BOLD, 37));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 11, 280, 40);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblUsername = new JLabel("Username (Optional) :");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblUsername.setBounds(10, 321, 280, 17);
		contentPane.add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setForeground(Color.BLACK);
		txtUsername.setFont(new Font("Arial Black", Font.BOLD, 15));
		txtUsername.setDisabledTextColor(Color.BLACK);
		txtUsername.setColumns(10);
		txtUsername.setBounds(10, 342, 280, 20);
		contentPane.add(txtUsername);
		
		JLabel lblPassword = new JLabel("Password (Optional) : ");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblPassword.setBounds(10, 369, 280, 17);
		contentPane.add(lblPassword);
		
		txtPassword = new JTextField();
		txtPassword.setForeground(Color.BLACK);
		txtPassword.setFont(new Font("Arial Black", Font.BOLD, 15));
		txtPassword.setDisabledTextColor(Color.BLACK);
		txtPassword.setColumns(10);
		txtPassword.setBounds(10, 390, 280, 20);
		contentPane.add(txtPassword);
		
		JLabel lblEmail = new JLabel("Email : ");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblEmail.setBounds(10, 418, 280, 17);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setForeground(Color.BLACK);
		txtEmail.setFont(new Font("Arial Black", Font.BOLD, 15));
		txtEmail.setDisabledTextColor(Color.BLACK);
		txtEmail.setColumns(10);
		txtEmail.setBounds(10, 438, 280, 20);
		contentPane.add(txtEmail);
		
		JLabel lblDate = new JLabel("Date :");
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblDate.setBounds(10, 465, 280, 17);
		contentPane.add(lblDate);
		
		JLabel lblPosition = new JLabel("Position :");
		lblPosition.setForeground(Color.WHITE);
		lblPosition.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblPosition.setBounds(10, 516, 280, 17);
		contentPane.add(lblPosition);
		
		txtPosition = new JTextField();
		txtPosition.setForeground(Color.BLACK);
		txtPosition.setFont(new Font("Arial Black", Font.BOLD, 15));
		txtPosition.setDisabledTextColor(Color.BLACK);
		txtPosition.setColumns(10);
		txtPosition.setBounds(10, 535, 280, 20);
		contentPane.add(txtPosition);
		
		btnSubmit = new JButton("SUBMIT");
	
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 30));
		btnSubmit.setFocusable(false);
		btnSubmit.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnSubmit.setBackground(Color.BLACK);
		btnSubmit.setBounds(10, 604, 134, 35);
		contentPane.add(btnSubmit);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				A_EmployeeForms.this.dispose();
			}
		});
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 30));
		btnCancel.setFocusable(false);
		btnCancel.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnCancel.setBackground(Color.BLACK);
		btnCancel.setBounds(156, 604, 134, 35);
		contentPane.add(btnCancel);
		
		JLabel lblImage = new JLabel("Image :");
		lblImage.setForeground(Color.WHITE);
		lblImage.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblImage.setBounds(10, 558, 280, 17);
		contentPane.add(lblImage);
		
		lblPath = new JLabel("");
		lblPath.setForeground(new Color(255, 255, 255));
		lblPath.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPath.setBounds(109, 579, 181, 18);
		contentPane.add(lblPath);
		
		showDate();
	
		btnSelectPath = new JButton("Select");
		btnSelectPath.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnSelectPath.setBackground(new Color(0, 0, 0));
		btnSelectPath.setForeground(new Color(255, 255, 255));
		btnSelectPath.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 15));
		btnSelectPath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter filterfile = new FileNameExtensionFilter("PNG JPG AND JPEG","png", "jpg", "jpeg");
				fileChooser.addChoosableFileFilter(filterfile);
				int load = fileChooser.showOpenDialog(null);
				
				if(load == fileChooser.APPROVE_OPTION) {
					f = fileChooser.getSelectedFile();
					path = f.getAbsolutePath();
					lblPath.setText(path);
					ImageIcon icons = new ImageIcon(path);
					Image img = icons.getImage().getScaledInstance(EmployeePicture.getWidth(), EmployeePicture.getHeight(), Image.SCALE_SMOOTH);
					EmployeePicture.setIcon(new ImageIcon(img));
					
				}
			}
		});
		btnSelectPath.setBounds(10, 580, 89, 17);
		contentPane.add(btnSelectPath);
		
		dateChooser = new JDateChooser();
		dateChooser.setFont(new Font("Arial Black", Font.PLAIN, 12));
		dateChooser.setDateFormatString("MMMMMMM d, y");
		dateChooser.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		dateChooser.setBounds(10, 487, 280, 20);
		contentPane.add(dateChooser);
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					DateFormat date = new SimpleDateFormat("MMMMMM dd, yyyy");
				
					File f = new File(path);
					
					int Id = Integer.parseInt(txtId.getText());
					String Firstname = txtFirstname.getText();
					String Lastname = txtLastname.getText();
					int age = Integer.parseInt(txtAge.getText());
					String male = "Male";
					String female = "Female";
					String Username = txtUsername.getText();
					String Password = txtPassword.getText();
					String Email = txtEmail.getText();
					String Date = date.format(dateChooser.getDate());
					String Position = txtPosition.getText();
					
					try {
						
						FileInputStream is = new FileInputStream(f);
						ByteArrayOutputStream buffer = new ByteArrayOutputStream();

						
						byte[] data = new byte[1024];

						for (int nRead; (nRead = is.read(data)) != -1;) {
							 buffer.write(data, 0, nRead);
						}

						byte[] photo = buffer.toByteArray();
						
						Connection con = DriverManager.getConnection("jdbc:sqlite:src/Database/usersDatabase.db");
						
						if(rdMale.getText().equals("Male")) {
						
							PreparedStatement states = con.prepareStatement("INSERT INTO users (Id, Firstname, Lastname, Age, Gender, Username, Password, Email, DateApply, Position, Image) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
							states.setInt(1, Id);
							states.setString(2, Firstname);
							states.setString(3, Lastname);
							states.setInt(4, age);
							states.setString(5, male);
							states.setString(6, Username);
							states.setString(7, Password);
							states.setString(8, Email);
							states.setString(9, Date);
							states.setString(10, Position);
							states.setBytes(11, photo);
							
							int inserted = states.executeUpdate();
						
							
							if (inserted > 0) {
							
								JOptionPane.showMessageDialog(null, "Employee Added Successfully");
								A_EmployeeForms.this.dispose();
								

								states.close();
								con.close();
							}
							
						} else if (rdMale.getText().equals("Female")) {
							PreparedStatement states = con.prepareStatement("INSERT INTO users (Id, Firstname, Lastname, Age, Gender, Username, Password, Email, DateApply, Position, Image) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
							states.setInt(1, Id);
							states.setString(2, Firstname);
							states.setString(3, Lastname);
							states.setInt(4, age);
							states.setString(5, female);
							states.setString(6, Username);
							states.setString(7, Password);
							states.setString(8, Email);
							states.setString(9, Date);
							states.setString(10, Position);
							states.setBytes(11, photo);
							
							int inserted = states.executeUpdate();
						
							
							if (inserted > 0) {
								
								
								JOptionPane.showMessageDialog(null, "Employee Added Successfully");
								A_EmployeeForms.this.dispose();


								states.close();
								con.close();
							}
						}
					
					
						
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				
			
			
			}
		});
		
		setLocationRelativeTo(null);
	}
	
	public void showDate() {
		Date d = new Date();
		SimpleDateFormat date = new SimpleDateFormat("MMMM dd, yyyy");
	}
}
