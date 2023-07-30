package A_LoginSystem;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import B_DashBoardss.AdminDashBoard;
import B_DashBoardss.UsersDashBoard;

public class AttendanceLogin extends JFrame {

	private Image Clogo = new ImageIcon
			("src/res/companyLogo.png")
			.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
	
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
	private JPanel lbltimeinbutt;
	private JLabel lblexit;
	private JLabel lblLogo;
	private JLabel lblMess;
	private JLabel passLogo;
	private JLabel keyLogo;
	private JLabel lblNewLabel_2;
	private JLabel lblBy;
	private JLabel lblNewLabel_3;
	private JLabel clearLogo;
	private JLabel lblNewLabel_4;
	private JLabel lbltime;
	private JLabel lbldate;
	private JLabel lblday;
	private JLabel lblNewLabel_5;
	private JLabel lblGlogo;
	private JLabel lblnotshow;
	
	String date;
	String time;
	
	int timee;
	int elapseTime = 0;
	int minutes = 0;
	int hours = 0;

        
	/**
	 * Launch the application.
	 */
	
	String minutes_string = String.format("%02d", minutes);
	String hours_string = String.format("%02d", hours);

	String string_time;
	
	Timer timer = new Timer(1000, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			elapseTime = elapseTime + 1000;
			hours = (elapseTime/3600000);
			minutes = (elapseTime/60000) % 60;
			
			minutes_string = String.format("%02d", minutes);
			hours_string = String.format("%02d", hours);
			
			string_time = String.format(hours_string + ":" + minutes_string, timee);
		}
		
	});
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	
	public static void main(String[] args) {
	
					AttendanceLogin frame = new AttendanceLogin();
					frame.setVisible(true);
					
					
	}

	public AttendanceLogin() {
		initialize();
	}
	public void initialize() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(20, 70, 904, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new LineBorder(new Color(255, 255, 255), 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(575, 261, 315, 1);
		contentPane.add(panel);
		panel.setLayout(null);
                
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(575, 344, 315, 1);
		contentPane.add(panel_1);
		
		lbltimeinbutt = new JPanel();
		lbltimeinbutt.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		lbltimeinbutt.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				TimeInButt();
			} 
			@Override
			public void mouseEntered(MouseEvent e) {
				lbltimeinbutt.setBackground(Color.gray);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbltimeinbutt.setBackground(Color.black);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				lbltimeinbutt.setBackground(Color.gray);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lbltimeinbutt.setBackground(Color.black);
			}
		});
		lbltimeinbutt.setBackground(new Color(0, 0, 0));
		lbltimeinbutt.setBounds(505, 391, 190, 53);
		contentPane.add(lbltimeinbutt);
		lbltimeinbutt.setLayout(null);
		
		keyLogo = new JLabel("");
		keyLogo.setBounds(10, 5, 50, 45);
		keyLogo.setIcon(new ImageIcon(Klogo));
		lbltimeinbutt.add(keyLogo);
		
		JLabel lblNewLabel = new JLabel("TIMEIN /");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(new Rectangle(63, 5, 123, 19));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbltimeinbutt.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		
		JLabel lblTimeout = new JLabel("TIMEOUT ");
		lblTimeout.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTimeout.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimeout.setForeground(Color.WHITE);
		lblTimeout.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTimeout.setBounds(new Rectangle(63, 5, 161, 19));
		lblTimeout.setBackground(Color.WHITE);
		lblTimeout.setBounds(68, 26, 118, 19);
		lbltimeinbutt.add(lblTimeout);
		
		lblexit = new JLabel("X");
		lblexit.setForeground(new Color(255, 255, 255));
		lblexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want this application?", 
						"Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					AttendanceLogin.this.dispose();
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
		lblexit.setBounds(880, 2, 18, 14);
		contentPane.add(lblexit);
		
		lblMess = new JLabel("");
		lblMess.setForeground(new Color(255, 0, 0));
		lblMess.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblMess.setBounds(515, 356, 375, 24);
		contentPane.add(lblMess);
		
		txtUser = new JTextField();
		txtUser.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txtUser.setForeground(new Color(255, 255, 255));
		txtUser.setBackground(new Color(0, 0, 0));
		txtUser.setBounds(575, 228, 278, 26);
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
		txtPass.setBounds(575, 306, 243, 37);
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
		lblNewLabel_1.setBounds(575, 200, 159, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password*");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Arial Rounded MT Bold", Font.ITALIC, 20));
		lblNewLabel_1_1.setBounds(575, 281, 119, 26);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel userLogo = new JLabel("");
		userLogo.setBounds(505, 208, 60, 60);
		userLogo.setIcon(new ImageIcon(Ulogo));;
		contentPane.add(userLogo);
		
		passLogo = new JLabel("");
		passLogo.setBounds(505, 285, 60, 60);
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
		lblclearbutt.setBounds(705, 391, 190, 53);
		contentPane.add(lblclearbutt);
		
		JLabel lblclear = new JLabel("CLEAR");
		lblclear.setHorizontalTextPosition(SwingConstants.CENTER);
		lblclear.setHorizontalAlignment(SwingConstants.CENTER);
		lblclear.setForeground(Color.WHITE);
		lblclear.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblclear.setBounds(new Rectangle(37, 5, 171, 40));
		lblclear.setBackground(Color.WHITE);
		lblclear.setBounds(55, 6, 125, 40);
		lblclearbutt.add(lblclear);
		
		clearLogo = new JLabel("");
		clearLogo.setBounds(10, 0, 50, 53);
		clearLogo.setIcon(new ImageIcon(Clearlogo));
		lblclearbutt.add(clearLogo);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 0, 495, 600);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		lblLogo = new JLabel("");
		lblLogo.setBackground(Color.WHITE);
		lblLogo.setForeground(Color.WHITE);
		lblLogo.setBounds(71, 226, 333, 310);
		panel_2.add(lblLogo);
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(new ImageIcon(Clogo));
		
		lblNewLabel_2 = new JLabel("SAMGY");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 11, 465, 78);
		panel_2.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Segoe Print", Font.BOLD, 60));
		
		JLabel lblName = new JLabel("RISARE'S");
		lblName.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 50));
		lblName.setBounds(151, 156, 304, 59);
		panel_2.add(lblName);
		
		lblBy = new JLabel("by ");
		lblBy.setFont(new Font("Eras Medium ITC", Font.ITALIC, 40));
		lblBy.setBounds(94, 136, 67, 59);
		panel_2.add(lblBy);
		
		lblNewLabel_3 = new JLabel("RESTAURANT");
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setFont(new Font("Segoe Print", Font.BOLD, 60));
		lblNewLabel_3.setBounds(20, 78, 465, 78);
		panel_2.add(lblNewLabel_3);
		
		lblNewLabel_5 = new JLabel("Copyright 2023 | All Rights Reserves by Manjaro");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(71, 561, 363, 28);
		panel_2.add(lblNewLabel_5);
		
		lbltime = new JLabel("");
		lbltime.setHorizontalAlignment(SwingConstants.RIGHT);
		lbltime.setForeground(Color.WHITE);
		lbltime.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbltime.setBounds(750, 5, 119, 31);
		
		contentPane.add(lbltime);
		
		
		lbldate = new JLabel("");
		lbldate.setHorizontalAlignment(SwingConstants.RIGHT);
		lbldate.setForeground(Color.WHITE);
		lbldate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbldate.setBounds(750, 63, 119, 31);
		contentPane.add(lbldate);
		
		lblday = new JLabel("");
		lblday.setHorizontalAlignment(SwingConstants.RIGHT);
		lblday.setForeground(Color.WHITE);
		lblday.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblday.setBounds(750, 37, 119, 31);
		contentPane.add(lblday);
		
		lblNewLabel_4 = new JLabel("Employee's");
		lblNewLabel_4.setBounds(508, 101, 390, 45);
		contentPane.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Gill Sans Ultra Bold", Font.BOLD, 35));
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
		lblshow.setBounds(843, 293, 48, 45);
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
		lblnotshow.setBounds(843, 293, 48, 45);
		lblnotshow.setIcon(new ImageIcon(noeyelogo));
		contentPane.add(lblnotshow);
		
		lblNewLabel_6 = new JLabel("Attendance");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Gill Sans Ultra Bold", Font.BOLD, 30));
		lblNewLabel_6.setBounds(505, 144, 385, 45);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Attendace Form");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Goudy Old Style", Font.BOLD, 60));
		lblNewLabel_7.setBounds(505, 466, 388, 85);
		contentPane.add(lblNewLabel_7);
		
		showTime();
		showDate();
		showDay();
	}

	private void showDate() {
		Date d = new Date();
		SimpleDateFormat s = new SimpleDateFormat("MMMM dd yyyy");
		String date = s.format(d);
		lbldate.setText(date);
	}
	
	private String showDate(String date) {
		this.date = date;
		Date d = new Date();
		SimpleDateFormat s = new SimpleDateFormat("MMMM dd, yyyy");
		return date = s.format(d);
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
	
	public String showTime(String time) {
		
		Date d = new Date();
		SimpleDateFormat s = new SimpleDateFormat("hh:mm a");
		time = s.format(d);
		
		return time;
	}
	
	
	public void Start() {
		timer.start();
	}
	
	public void Stop() {
		timer.stop();
	}
	
	public void TimeInButt() {
		
		String user = txtUser.getText();
		String pass = String.valueOf(txtPass.getPassword());
	
		try {
			Connection con = DriverManager.getConnection("jdbc:sqlite:src/Database/usersDatabase.db");
			String query = "SELECT * FROM users WHERE username ='"+ user +"' AND password='"+ pass +"'";
			Statement state = con.createStatement();
			ResultSet set = state.executeQuery(query);
			
			String fname = set.getString("Firstname");
			String lname = set.getString("Lastname");
			int Id = set.getInt("id");
		
			if(set.next()) {
				
				 String endtime = "";
				 String quuery = "SELECT * FROM usersAttendance WHERE Id = '" + Id + "' AND EndTime IS '" + endtime + "'";
				 Statement statee = con.createStatement();
				 ResultSet resultSet = statee.executeQuery(quuery);
				 boolean hasTimeIn = resultSet.next();
				 
				 if (hasTimeIn) {
					 
					 if(JOptionPane.showConfirmDialog(null, "Do you want to Timeout?", 
								"Confirmation", JOptionPane.YES_NO_OPTION) == 0) {	
							
							Statement states = null;
							String endTime = "Time Out";
							
							Stop();
							
							String timeee = null;
							String timesin = showTime(timeee);
							
							String timeoutquery = "UPDATE usersAttendance SET TimeOut = '"+ timesin +  "' , EndTime = '" + endTime + "', Timer = '"+ string_time +"' WHERE Id = '" + Id + "'";
							states = con.createStatement();
							
									
								if(!states.execute(timeoutquery)) {
								
									JOptionPane.showMessageDialog(null, "TimeOut Successfully");	
										
										lblMess.setText("");
										
											if(hours >= 8) {
												String Overtimestats = "Overtime";
												String Overtimequery = "UPDATE usersAttendance SET Status = '"+ Overtimestats + "' WHERE Id = '" + Id + "'";
												Statement overtimeState = con.createStatement();
												
														
													if(!overtimeState.execute(Overtimequery)) {
														
															overtimeState.close();
															con.close();
													}
													
											}else if(hours < 8) {
												String Latestats = "Late";
												String Latequery = "UPDATE usersAttendance SET Status = '"+ Latestats + "' WHERE Id = '" + Id + "'";
												Statement lateState = con.createStatement();
												
														
												if(!lateState.execute(Latequery)) {
													lateState.close();
													con.close();
												}
											}else {
												
												String Ontimestats = "Ontime";
												String Statusquery = "UPDATE usersAttendance SET Status = '"+ Ontimestats + "' WHERE Id = '" + Id + "'";
												Statement ontimeState = con.createStatement();
												
														
												if(!ontimeState.execute(Statusquery)) {
													
													ontimeState.close();
													con.close();
													
												}
												
											
										}
									
									states.close();
								
								}	
					 }
					 
					 resultSet.close();
					 state.close();
				 } else {
					 
						if(JOptionPane.showConfirmDialog(null, "Do you want to TimeIn?", 
								"Confirmation", JOptionPane.YES_NO_OPTION) == 0) {		
			
							String startTime = "Time In";
							String endTime_2 = "";
							String timeout = "";
							String time = "";
							String stats = "";
							
							String dateUp = showDate(date);
							Start();
							
								String timeee = null;
								String timesin = showTime(timeee);
								String inquery = "INSERT INTO usersAttendance VALUES('"+ Id + "','" + fname +"','" + lname +"','" + startTime + "','" + timesin + "','" + endTime_2 + "','" + timeout+"','" + time + "', '" + dateUp +"','"+ stats +"')";
								Statement states = con.createStatement();
							
								if (!states.execute(inquery)) {
								
										JOptionPane.showMessageDialog(null, "TimeIn Successfully");	
										lblMess.setText("");
										
										states.close();
										con.close();
									
								}
								
							set.close();
							state.close();
						}
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
}
