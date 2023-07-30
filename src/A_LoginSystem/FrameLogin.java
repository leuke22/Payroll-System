package A_LoginSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Rectangle;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.border.MatteBorder;

import B_DashBoardss.AdminDashBoard;
import B_DashBoardss.StaffDashBoard;
import B_DashBoardss.UsersDashBoard;

import java.awt.Cursor;
import java.awt.Component;

public class FrameLogin extends JFrame {

	
	private Image Ulogo = new ImageIcon
			("src/res/userLog.png")
			.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
	
	private Image Plogo = new ImageIcon
			("src/res/passLog.png")
			.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
	
	private Image Klogo = new ImageIcon
			("src/res/keyLog.png")
			.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	
	private Image Clearlogo = new ImageIcon
			("src/res/clearLog.png")
			.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	
	private Image Glogo = new ImageIcon
			("src/res/LOGO-BLACK BACKROUND-fotor-bg-remover-202303201278.png")
			.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
	
	private Image eyelogo = new ImageIcon
			("src/res/show.png")
			.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	
	private Image noeyelogo = new ImageIcon
			("src/res/inivisible.png")
			.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	
	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtPass;
	private JPanel lblloginbutt;
	private JLabel lblexit;
	private JLabel lblMess;
	private JLabel passLogo;
	private JLabel keyLogo;
	private JLabel clearLogo;
	private JLabel lblNewLabel_4;
	private JLabel lbltime;
	private JLabel lbldate;
	private JLabel lblday;
	private JLabel lblGlogo;
	private JLabel lblnotshow;
	private Connection con;
	private JLabel lblNewLabel_6;
        
	String timeOnline;
	String dates;
	private JLabel lblNewLabel_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
					FrameLogin frame = new FrameLogin();
					frame.setVisible(true);
					
					
	}

	public FrameLogin() {
		try {
			con = DriverManager.getConnection("jdbc:sqlite:src/Database/usersDatabase.db");
		}catch(SQLException e){
			e.printStackTrace();
		}
		initialize();
	}
	public void initialize() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(924, 70, 413, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new LineBorder(new Color(255, 255, 255), 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(90, 261, 300, 1);
		contentPane.add(panel);
		panel.setLayout(null);
                
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(90, 344, 300, 1);
		contentPane.add(panel_1);
		
		lblloginbutt = new JPanel();
		lblloginbutt.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		lblloginbutt.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				String nameAdmin = "MANJARO";
				String nameManager = "RISARE'S";
				String nameStaff = "STAFF";
				
				String positionAdmin = "Admin";
				String positionManager = "Manager";
				String positionStaff = "Staff";
				
				String user = txtUser.getText();
				String pass = String.valueOf(txtPass.getPassword());


				try {
					String query = "SELECT * FROM users WHERE Username='"+ user +"' AND Password='"+ pass +"'";
					Statement state = con.createStatement();
					ResultSet set = state.executeQuery(query);
					
					String fname = set.getString("Firstname");
					String lname = set.getString("Lastname");
					int Id = set.getInt("Id");
					
					
					if(txtUser.getText().equals("Admin") && txtPass.getText().equals("Admin123")) {
					
							lblMess.setText("");
							JOptionPane.showMessageDialog(null, "Login Succesfully");
							AdminDashBoard admindash = new AdminDashBoard(nameAdmin, positionAdmin);
							admindash.setVisible(true);	
							FrameLogin.this.dispose();
					
					} else if(txtUser.getText().equals("Manager") && txtPass.getText().equals("Manager123")) {
						
							lblMess.setText("");
							JOptionPane.showMessageDialog(null, "Login Succesfully");
							AdminDashBoard dash = new AdminDashBoard(nameManager, positionManager);
							dash.setVisible(true);	
							FrameLogin.this.dispose();
							
					}  else if(txtUser.getText().equals("Staff") && txtPass.getText().equals("Staff123")) {
						
							lblMess.setText("");
							JOptionPane.showMessageDialog(null, "Login Succesfully");
							StaffDashBoard staffdash = new StaffDashBoard(nameStaff, positionStaff);
							staffdash.setVisible(true);	
							FrameLogin.this.dispose();
					
					} else if(set.next()) {
					
							String online = "ONLINE";
							String offline = "";
							String DateOnline = showTimeOnline(timeOnline);
							String DateOffline = "";
							String Date = showDates(dates);
							
							String inquery = "INSERT INTO usersStatus VALUES('"+ Id + "','" + fname +"','" + lname + "','"+ online + "','" + DateOnline + "','" + offline + "','" + DateOffline + "','" + Date +"')";
							
							Statement states = con.createStatement();
							
							if (!states.execute(inquery)) {
								
								byte [] images = set.getBytes("Image");
								lblMess.setText("");
								JOptionPane.showMessageDialog(null, "Login Succesfully");
								UsersDashBoard userdash = new UsersDashBoard(fname, lname, Id, images);
								userdash.setVisible(true);	
								FrameLogin.this.dispose();
	
								state.close();
								states.close();
								set.close();
								con.close();
							}
							
					} else if(txtUser.getText().equals("") || txtUser.getText().equals("USERNAME") 
					   || txtPass.getText().equals("") || txtPass.getText().equals("PASSWORD") ) {
							lblMess.setText("Please Input all requirements");
					
					} else {
							lblMess.setText("Username & Password didn't match");
					}
					
				
				}catch(Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Something went wrong");
				
				}
			} 
			@Override
			public void mouseEntered(MouseEvent e) {
				lblloginbutt.setBackground(Color.gray);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblloginbutt.setBackground(Color.black);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				lblloginbutt.setBackground(Color.gray);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblloginbutt.setBackground(Color.black);
			}
		});
		lblloginbutt.setBackground(new Color(0, 0, 0));
		lblloginbutt.setBounds(20, 391, 189, 53);
		contentPane.add(lblloginbutt);
		lblloginbutt.setLayout(null);
		
		keyLogo = new JLabel("");
		keyLogo.setBounds(5, 5, 50, 45);
		keyLogo.setIcon(new ImageIcon(Klogo));
		lblloginbutt.add(keyLogo);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(new Rectangle(64, 5, 117, 40));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblloginbutt.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		
		lblexit = new JLabel("X");
		lblexit.setForeground(new Color(255, 255, 255));
		lblexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want this application?", 
						"Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					FrameLogin.this.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblexit.setForeground(Color.gray);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblexit.setForeground(Color.black);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				lblexit.setForeground(Color.gray);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblexit.setForeground(Color.black);
			}
		});
		lblexit.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblexit.setHorizontalAlignment(SwingConstants.CENTER);
		lblexit.setBounds(380, 5, 18, 14);
		contentPane.add(lblexit);
		
		lblMess = new JLabel("");
		lblMess.setForeground(new Color(255, 0, 0));
		lblMess.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblMess.setBounds(20, 356, 363, 24);
		contentPane.add(lblMess);
		
		txtUser = new JTextField();
		txtUser.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txtUser.setForeground(new Color(255, 255, 255));
		txtUser.setBackground(new Color(0, 0, 0));
		txtUser.setBounds(90, 222, 300, 29);
		contentPane.add(txtUser);
		txtUser.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtUser.getText().equals("Enter your username:")) {
					txtUser.setText("");
				}else {
					txtUser.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtUser.getText().equals("")) {
					txtUser.setText("Enter your username:");
				}
			}
		});
		txtUser.setBorder(null);
		txtUser.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtUser.setText("Enter your username:");
		txtUser.setColumns(10);
		
		txtPass = new JPasswordField();
		txtPass.setForeground(new Color(255, 255, 255));
		txtPass.setBackground(new Color(0, 0, 0));
		txtPass.setBounds(90, 304, 244, 37);
		contentPane.add(txtPass);
		txtPass.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtPass.getText().equals("Enter your password:")) {
					txtPass.setEchoChar('●');
					txtPass.setText("");
				}else {
					txtPass.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPass.getText().equals("")) {
					txtPass.setText("Enter your password:");
					txtPass.setEchoChar((char)0);
				}
			}
		});
		txtPass.setBorder(null);
		txtPass.setEchoChar((char)0);
		txtPass.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtPass.setText("Enter your password:");
		
		JLabel lblNewLabel_1 = new JLabel("Username*");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Arial Rounded MT Bold", Font.ITALIC, 20));
		lblNewLabel_1.setBounds(90, 200, 159, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password*");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Arial Rounded MT Bold", Font.ITALIC, 20));
		lblNewLabel_1_1.setBounds(90, 281, 119, 26);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel userLogo = new JLabel("");
		userLogo.setBounds(20, 208, 60, 60);
		userLogo.setIcon(new ImageIcon(Ulogo));;
		contentPane.add(userLogo);
		
		passLogo = new JLabel("");
		passLogo.setBounds(20, 285, 60, 60);
		passLogo.setIcon(new ImageIcon(Plogo));
		contentPane.add(passLogo);
		
		JPanel lblclearbutt = new JPanel();
		lblclearbutt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtUser.setText("");
				txtPass.setText("");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblclearbutt.setBackground(Color.gray);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblclearbutt.setBackground(Color.black);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				lblclearbutt.setBackground(Color.gray);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblclearbutt.setBackground(Color.black);
			}
		});
		lblclearbutt.setLayout(null);
		lblclearbutt.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		lblclearbutt.setBackground(Color.BLACK);
		lblclearbutt.setBounds(219, 391, 178, 53);
		contentPane.add(lblclearbutt);
		
		JLabel lblclear = new JLabel("CLEAR");
		lblclear.setHorizontalTextPosition(SwingConstants.CENTER);
		lblclear.setHorizontalAlignment(SwingConstants.CENTER);
		lblclear.setForeground(Color.WHITE);
		lblclear.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblclear.setBounds(new Rectangle(37, 5, 171, 40));
		lblclear.setBackground(Color.WHITE);
		lblclear.setBounds(47, 6, 133, 40);
		lblclearbutt.add(lblclear);
		
		clearLogo = new JLabel("");
		clearLogo.setBounds(5, 0, 50, 53);
		clearLogo.setIcon(new ImageIcon(Clearlogo));
		lblclearbutt.add(clearLogo);
		
		lbltime = new JLabel("");
		lbltime.setHorizontalAlignment(SwingConstants.RIGHT);
		lbltime.setForeground(Color.WHITE);
		lbltime.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbltime.setBounds(250, 11, 119, 31);
		
		contentPane.add(lbltime);
		
		
		lbldate = new JLabel("");
		lbldate.setHorizontalAlignment(SwingConstants.RIGHT);
		lbldate.setForeground(Color.WHITE);
		lbldate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbldate.setBounds(250, 66, 119, 31);
		contentPane.add(lbldate);
		
		lblday = new JLabel("");
		lblday.setHorizontalAlignment(SwingConstants.RIGHT);
		lblday.setForeground(Color.WHITE);
		lblday.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblday.setBounds(250, 38, 119, 31);
		contentPane.add(lblday);
		
		lblNewLabel_4 = new JLabel("Payroll Management");
		lblNewLabel_4.setBounds(10, 97, 380, 45);
		contentPane.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Gill Sans Ultra Bold", Font.BOLD, 25));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(Color.WHITE);
		
		JLabel lblshow = new JLabel("");
		lblshow.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				lblshow.setVisible(false);
				lblnotshow.setVisible(true);
				txtPass.setEchoChar((char)0);
			}
		});
		lblshow.setHorizontalAlignment(SwingConstants.RIGHT);
		lblshow.setBounds(340, 293, 48, 45);
		lblshow.setIcon(new ImageIcon(eyelogo));
		contentPane.add(lblshow);
		
		lblGlogo = new JLabel("");
		lblGlogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblGlogo.setBounds(890, 513, 85, 76);
		lblGlogo.setIcon(new ImageIcon(Glogo));
		contentPane.add(lblGlogo);
		
		lblnotshow = new JLabel("");
		lblnotshow.setVisible(false);
		lblnotshow.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				lblnotshow.setVisible(false);
				lblshow.setVisible(true);
				txtPass.setEchoChar('●');
				
			}
		});
		lblnotshow.setHorizontalAlignment(SwingConstants.RIGHT);
		lblnotshow.setBounds(340, 293, 48, 45);
		lblnotshow.setIcon(new ImageIcon(noeyelogo));
		contentPane.add(lblnotshow);
		
		lblNewLabel_6 = new JLabel("System");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Gill Sans Ultra Bold", Font.BOLD, 30));
		lblNewLabel_6.setBounds(10, 139, 380, 37);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_2 = new JLabel("Login Form");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Goudy Old Style", Font.BOLD, 60));
		lblNewLabel_2.setBounds(10, 477, 388, 85);
		contentPane.add(lblNewLabel_2);
		
		showTime();
		showDate();
		showDay();
	}

	private void showDate() {
		Date d = new Date();
		SimpleDateFormat s = new SimpleDateFormat("MMMM dd yyyy");
		String dat = s.format(d);
		lbldate.setText(dat);
	}
	
	private void showDay() {
		Date d = new Date();
		SimpleDateFormat s = new SimpleDateFormat("EEEE");
		String dat = s.format(d);
		lblday.setText(dat);
	}

	public void showTime() {
		new Timer(0, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date d = new Date();
				SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss a");
				String tim = s.format(d);
				lbltime.setText(tim);
			}
		}).start();
	}
	
	public String showTimeOnline(String timeOnline) {
		
		this.timeOnline = timeOnline;
		Date d = new Date();
		SimpleDateFormat s = new SimpleDateFormat("hh:mm a");
		return timeOnline = s.format(d);
		
	}
	
	public String showDates(String date) {
		Date d = new Date();
		SimpleDateFormat s = new SimpleDateFormat("MMMM dd, yyyy");
		return date = s.format(d);
	}
}