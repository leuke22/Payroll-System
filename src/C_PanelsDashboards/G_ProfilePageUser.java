package C_PanelsDashboards;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class G_ProfilePageUser extends JPanel {
	private JTextField txtFirstname;
	private JTextField txtLastname;
	private JTextField txtAge;
	private JTextField txtEmail;
	private JTextField txtPosition;
	private JLabel lblPath;

	File f = null;
	String path = null;
	

	int id;
	/**
	 * Create the panel.
	 */
	
	public G_ProfilePageUser(int Id, byte[] images) {
		setForeground(new Color(128, 128, 128));
		setBackground(new Color(51, 51, 51));
		setBounds(0, 0, 936, 656);
		setLayout(null);
		
		this.id = Id;
		
		JLabel lblNewLabel = new JLabel("Profile Information");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 56));
		lblNewLabel.setBounds(10, 11, 916, 56);
		add(lblNewLabel);
		
		JLabel lblFirstname = new JLabel("Firstname : ");
		lblFirstname.setHorizontalAlignment(SwingConstants.LEFT);
		lblFirstname.setForeground(Color.WHITE);
		lblFirstname.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25));
		lblFirstname.setBounds(76, 150, 425, 36);
		add(lblFirstname);
		
		txtFirstname = new JTextField();
		txtFirstname.setForeground(Color.BLACK);
		txtFirstname.setFont(new Font("Arial Black", Font.BOLD, 20));
		txtFirstname.setDisabledTextColor(Color.BLACK);
		txtFirstname.setColumns(10);
		txtFirstname.setBounds(76, 187, 330, 25);
		add(txtFirstname);
		
		JLabel EmployeePicture = new JLabel("");
		EmployeePicture.setIcon(new ImageIcon(images));
		EmployeePicture.setBounds(815, 70, 111, 77);
		add(EmployeePicture);
		
		JLabel lblLastname = new JLabel("Lastname : ");
		lblLastname.setHorizontalAlignment(SwingConstants.LEFT);
		lblLastname.setForeground(Color.WHITE);
		lblLastname.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25));
		lblLastname.setBounds(76, 223, 425, 36);
		add(lblLastname);
		
		txtLastname = new JTextField();
		txtLastname.setForeground(Color.BLACK);
		txtLastname.setFont(new Font("Arial Black", Font.BOLD, 20));
		txtLastname.setDisabledTextColor(Color.BLACK);
		txtLastname.setColumns(10);
		txtLastname.setBounds(76, 261, 330, 25);
		add(txtLastname);
		
		JLabel lblAge = new JLabel("Age : ");
		lblAge.setHorizontalAlignment(SwingConstants.LEFT);
		lblAge.setForeground(Color.WHITE);
		lblAge.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25));
		lblAge.setBounds(76, 297, 425, 36);
		add(lblAge);
		
		txtAge = new JTextField();
		txtAge.setForeground(Color.BLACK);
		txtAge.setFont(new Font("Arial Black", Font.BOLD, 20));
		txtAge.setDisabledTextColor(Color.BLACK);
		txtAge.setColumns(10);
		txtAge.setBounds(76, 335, 330, 25);
		add(txtAge);
		
		JLabel lblEmail = new JLabel("Email : ");
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25));
		lblEmail.setBounds(511, 150, 415, 36);
		add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setForeground(Color.BLACK);
		txtEmail.setFont(new Font("Arial Black", Font.BOLD, 20));
		txtEmail.setDisabledTextColor(Color.BLACK);
		txtEmail.setColumns(10);
		txtEmail.setBounds(511, 187, 330, 25);
		add(txtEmail);
		
		JLabel lblPosition = new JLabel("Position : ");
		lblPosition.setHorizontalAlignment(SwingConstants.LEFT);
		lblPosition.setForeground(Color.WHITE);
		lblPosition.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25));
		lblPosition.setBounds(511, 223, 415, 36);
		add(lblPosition);
		
		txtPosition = new JTextField();
		txtPosition.setForeground(Color.BLACK);
		txtPosition.setFont(new Font("Arial Black", Font.BOLD, 20));
		txtPosition.setDisabledTextColor(Color.BLACK);
		txtPosition.setColumns(10);
		txtPosition.setBounds(511, 261, 330, 25);
		add(txtPosition);
		
		lblPath = new JLabel("");
		lblPath.setForeground(new Color(255, 255, 255));
		lblPath.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPath.setBounds(511, 408, 330, 25);
		add(lblPath);
		
		try {
			Connection con = DriverManager.getConnection("jdbc:sqlite:src/Database/usersDatabase.db");
			Statement state = con.createStatement();
			ResultSet set = state.executeQuery("SELECT * FROM users WHERE id = '" + Id +"'"); 
		
			if(set.next()) {
			
				String firstname = set.getString("Firstname");
				String lastname = set.getString("Lastname");
				int age = set.getInt("Age");
				String email = set.getString("Email");
				String position = set.getString("Position");
				
				txtFirstname.setText(firstname);
				txtLastname.setText(lastname);
				txtAge.setText(Integer.toString(age));
				txtEmail.setText(email);
				txtPosition.setText(position);
				
			}
			
			state.close();
			set.close();
			con.close();
			
		}catch (SQLException e2) {
			// TODO: handle exception
		}
		
		JLabel lblImage = new JLabel("Image : ");
		lblImage.setHorizontalAlignment(SwingConstants.LEFT);
		lblImage.setForeground(Color.WHITE);
		lblImage.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25));
		lblImage.setBounds(511, 297, 415, 36);
		add(lblImage);
		
		JButton btnSelect = new JButton("SELECT");
		
		btnSelect.setForeground(Color.WHITE);
		btnSelect.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 35));
		btnSelect.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnSelect.setBackground(Color.BLACK);
		btnSelect.setBounds(511, 339, 150, 41);
		add(btnSelect);
		
		JButton btnUpdate = new JButton("UPDATE");
		
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 50));
		btnUpdate.setFocusable(false);
		btnUpdate.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnUpdate.setBackground(Color.BLACK);
		btnUpdate.setBounds(351, 564, 222, 70);
		add(btnUpdate);
		
		btnSelect.addActionListener(new ActionListener() {
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
		
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				File f = new File(path);
				
				String Firstname = txtFirstname.getText();
				String Lastname = txtLastname.getText();
				int age = Integer.parseInt(txtAge.getText());
				String Email = txtEmail.getText();
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
				String sql = "UPDATE users SET Firstname = ?, Lastname = ?, Age = ?, Email = ?, Position = ?, Image = ? WHERE Id = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);

				    // Set the new values for each column in the row
				    pstmt.setString(1, Firstname);
				    pstmt.setString(2, Lastname);
				    pstmt.setInt(3, age);
				    pstmt.setString(4, Email);
				    pstmt.setString(5, Position);
				    pstmt.setBytes(6, photo);
				    pstmt.setInt(7, id); // replace 'id' with the ID of the row you want to update

				    int rowsUpdated = pstmt.executeUpdate();
				    
				    if (rowsUpdated > 0) {
				    	JOptionPane.showMessageDialog(null, "Updated Successfully");
				    }
				    
				    con.close();
				
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
		
		
	}
	
	
}
