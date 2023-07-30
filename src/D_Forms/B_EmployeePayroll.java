package D_Forms;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.jgoodies.common.base.Strings;
import com.jgoodies.common.swing.MnemonicUtils;

public class B_EmployeePayroll extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtFirstname;
	private JTextField txtDailyRate;
	private JTextField txtDaysPerYear;
	private JTextField txtTax;
	private JTextField txtSSS;
	private JTextField txtPhilhealth;
	private JTextField txtPagibig;
	private JTextField txtGrossSalary;
	private JTextField txtTotalNetPay;
	private JTextField txtTotalDeduction;
	
	float resultDailyRate;
	int DaysPerYear;
	float resultGrossSalary;
	int rateSalary;
	
	float resultOvertime;
	float resultUndertime;
	float resultAbsences;
	float resultTardiness;
	int Overtime;
	int Undertime;
	int Absences;
	int Tardiness;
	
	double TotalTax;
	double TotalPhilHealth;
	double TotalSSS;
	double TotalPagibig;
	
	double SSSLoan;
	double PhilHealthLoan;
	double PagibigLoan;
    
	double resultDeduction;
	double resultNetPay;
    private JTextField txtLastname;
    private JTextField txtOvertime;
    private JTextField txtTotalOvertime;
    private JTextField txtAbsences;
    private JTextField txtTotalAbsences;
    private JTextField txtTardiness;
    private JTextField txtTotalTardiness;
    private JTextField txtUndertime;
    private JTextField txtTotalUndertime;
    private JDateChooser dateChooser;
    private JTextField txtSSSLoan;
    private JTextField txtPhilHealthLoan;
    private JTextField txtPagibigLoan;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					B_EmployeePayroll frame = new B_EmployeePayroll();
					frame.setVisible(true);
		
	}

	/**
	 * Create the frame.
	 */
	public B_EmployeePayroll() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Employee's Payroll ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Bookman Old Style", Font.BOLD, 40));
		lblNewLabel_1.setBounds(10, 11, 630, 55);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblEmployeeIdoptional = new JLabel("Employee Id :");
		lblEmployeeIdoptional.setForeground(Color.WHITE);
		lblEmployeeIdoptional.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblEmployeeIdoptional.setBounds(20, 113, 200, 17);
		contentPane.add(lblEmployeeIdoptional);
		
		txtId = new JTextField();
		txtId.setForeground(Color.BLACK);
		txtId.setFont(new Font("Arial Black", Font.BOLD, 15));
		txtId.setDisabledTextColor(Color.BLACK);
		txtId.setColumns(10);
		txtId.setBounds(20, 134, 253, 20);
		contentPane.add(txtId);
		
		JLabel lblFullname = new JLabel("Firstname : ");
		lblFullname.setForeground(Color.WHITE);
		lblFullname.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblFullname.setBounds(20, 160, 200, 17);
		contentPane.add(lblFullname);
		
		txtFirstname = new JTextField();
		txtFirstname.setForeground(Color.BLACK);
		txtFirstname.setFont(new Font("Arial Black", Font.BOLD, 15));
		txtFirstname.setDisabledTextColor(Color.BLACK);
		txtFirstname.setColumns(10);
		txtFirstname.setBounds(20, 180, 253, 20);
		contentPane.add(txtFirstname);
		
		JLabel lblEmployeesPayrollInformation = new JLabel("Employee's Payroll Information");
		lblEmployeesPayrollInformation.setForeground(Color.WHITE);
		lblEmployeesPayrollInformation.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblEmployeesPayrollInformation.setBounds(20, 77, 312, 25);
		contentPane.add(lblEmployeesPayrollInformation);
		
		JLabel lblRatePerHour = new JLabel("Daily Rate : ");
		lblRatePerHour.setForeground(Color.WHITE);
		lblRatePerHour.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblRatePerHour.setBounds(20, 350, 200, 17);
		contentPane.add(lblRatePerHour);
		
		txtDailyRate = new JTextField();
		txtDailyRate.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		txtDailyRate.setForeground(Color.BLACK);
		txtDailyRate.setFont(new Font("Arial Black", Font.BOLD, 15));
		txtDailyRate.setDisabledTextColor(Color.BLACK);
		txtDailyRate.setColumns(10);
		txtDailyRate.setBounds(64, 372, 209, 20);
		contentPane.add(txtDailyRate);
		
		JLabel lblNumberOfDays = new JLabel("Days in a year  :");
		lblNumberOfDays.setForeground(Color.WHITE);
		lblNumberOfDays.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblNumberOfDays.setBounds(20, 305, 200, 17);
		contentPane.add(lblNumberOfDays);
		
		txtDaysPerYear = new JTextField();
		txtDaysPerYear.setHorizontalAlignment(SwingConstants.CENTER);
		txtDaysPerYear.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		txtDaysPerYear.setForeground(Color.BLACK);
		txtDaysPerYear.setFont(new Font("Arial Black", Font.BOLD, 15));
		txtDaysPerYear.setDisabledTextColor(Color.BLACK);
		txtDaysPerYear.setColumns(10);
		txtDaysPerYear.setBounds(20, 326, 68, 20);
		contentPane.add(txtDaysPerYear);
		
		JLabel lblGrossSalarys = new JLabel("Gross Salary :");
		lblGrossSalarys.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrossSalarys.setForeground(Color.WHITE);
		lblGrossSalarys.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		lblGrossSalarys.setBounds(20, 479, 253, 25);
		contentPane.add(lblGrossSalarys);
		
		JLabel lblDeductionPayrollInformation = new JLabel("Deduction Payroll Information");
		lblDeductionPayrollInformation.setHorizontalAlignment(SwingConstants.LEFT);
		lblDeductionPayrollInformation.setForeground(Color.WHITE);
		lblDeductionPayrollInformation.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblDeductionPayrollInformation.setBounds(342, 77, 287, 25);
		contentPane.add(lblDeductionPayrollInformation);
		
		JLabel lblTax = new JLabel("Tax :");
		lblTax.setForeground(Color.WHITE);
		lblTax.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblTax.setBounds(353, 100, 280, 17);
		contentPane.add(lblTax);
		
		txtTax = new JTextField();
		txtTax.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		txtTax.setForeground(Color.BLACK);
		txtTax.setFont(new Font("Arial Black", Font.BOLD, 15));
		txtTax.setDisabledTextColor(Color.BLACK);
		txtTax.setColumns(10);
		txtTax.setBounds(406, 120, 200, 20);
		contentPane.add(txtTax);
		
		JLabel lblPhilhealth = new JLabel("PhilHealth :");
		lblPhilhealth.setForeground(Color.WHITE);
		lblPhilhealth.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblPhilhealth.setBounds(353, 188, 280, 17);
		contentPane.add(lblPhilhealth);
		
		txtSSS = new JTextField();
		txtSSS.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		txtSSS.setForeground(Color.BLACK);
		txtSSS.setFont(new Font("Arial Black", Font.BOLD, 15));
		txtSSS.setDisabledTextColor(Color.BLACK);
		txtSSS.setColumns(10);
		txtSSS.setBounds(406, 165, 200, 20);
		contentPane.add(txtSSS);
		
		JLabel lblSss = new JLabel("SSS :");
		lblSss.setForeground(Color.WHITE);
		lblSss.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblSss.setBounds(353, 145, 280, 17);
		contentPane.add(lblSss);
		
		txtPhilhealth = new JTextField();
		txtPhilhealth.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		txtPhilhealth.setForeground(Color.BLACK);
		txtPhilhealth.setFont(new Font("Arial Black", Font.BOLD, 15));
		txtPhilhealth.setDisabledTextColor(Color.BLACK);
		txtPhilhealth.setColumns(10);
		txtPhilhealth.setBounds(406, 209, 200, 20);
		contentPane.add(txtPhilhealth);
		
		JLabel lblPagibig = new JLabel("Pag-Ibig :");
		lblPagibig.setForeground(Color.WHITE);
		lblPagibig.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblPagibig.setBounds(353, 235, 280, 17);
		contentPane.add(lblPagibig);
		
		txtPagibig = new JTextField();
		txtPagibig.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		txtPagibig.setForeground(Color.BLACK);
		txtPagibig.setFont(new Font("Arial Black", Font.BOLD, 15));
		txtPagibig.setDisabledTextColor(Color.BLACK);
		txtPagibig.setColumns(10);
		txtPagibig.setBounds(406, 258, 200, 20);
		contentPane.add(txtPagibig);
		
		JLabel lblGrossSalary = new JLabel("Total Deduction :");
		lblGrossSalary.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrossSalary.setForeground(Color.WHITE);
		lblGrossSalary.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		lblGrossSalary.setBounds(353, 560, 253, 25);
		contentPane.add(lblGrossSalary);
		
		JLabel lblNetPay = new JLabel("Net Pay  :");
		lblNetPay.setHorizontalAlignment(SwingConstants.CENTER);
		lblNetPay.setForeground(Color.WHITE);
		lblNetPay.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		lblNetPay.setBounds(20, 551, 253, 25);
		contentPane.add(lblNetPay);
		
		JButton btnSubmit = new JButton("SUBMIT");
		
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 25));
		btnSubmit.setFocusable(false);
		btnSubmit.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnSubmit.setBackground(Color.BLACK);
		btnSubmit.setBounds(197, 651, 122, 38);
		contentPane.add(btnSubmit);
		
		JButton btnCancel = new JButton("CANCEL");
		
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 25));
		btnCancel.setFocusable(false);
		btnCancel.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnCancel.setBackground(Color.BLACK);
		btnCancel.setBounds(329, 651, 122, 38);
		contentPane.add(btnCancel);
	
		
		txtGrossSalary = new JTextField();
		txtGrossSalary.setHorizontalAlignment(SwingConstants.CENTER);
		txtGrossSalary.setBackground(new Color(51, 51, 51));
		txtGrossSalary.setBorder(null);
		txtGrossSalary.setForeground(Color.WHITE);
		txtGrossSalary.setFont(new Font("Arial Black", Font.BOLD, 20));
		txtGrossSalary.setDisabledTextColor(Color.BLACK);
		txtGrossSalary.setColumns(10);
		txtGrossSalary.setBounds(20, 510, 253, 30);
		contentPane.add(txtGrossSalary);
		
		txtTotalNetPay = new JTextField();
		txtTotalNetPay.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalNetPay.setForeground(Color.WHITE);
		txtTotalNetPay.setFont(new Font("Arial Black", Font.BOLD, 20));
		txtTotalNetPay.setDisabledTextColor(Color.BLACK);
		txtTotalNetPay.setColumns(10);
		txtTotalNetPay.setBorder(null);
		txtTotalNetPay.setBackground(new Color(51, 51, 51));
		txtTotalNetPay.setBounds(20, 580, 253, 30);
		contentPane.add(txtTotalNetPay);
		
		txtTotalDeduction = new JTextField();
		txtTotalDeduction.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalDeduction.setForeground(Color.WHITE);
		txtTotalDeduction.setFont(new Font("Arial Black", Font.BOLD, 20));
		txtTotalDeduction.setDisabledTextColor(Color.BLACK);
		txtTotalDeduction.setColumns(10);
		txtTotalDeduction.setBorder(null);
		txtTotalDeduction.setBackground(new Color(51, 51, 51));
		txtTotalDeduction.setBounds(353, 596, 253, 30);
		contentPane.add(txtTotalDeduction);
		
		JLabel lblLasta = new JLabel("Lastname : ");
		lblLasta.setForeground(Color.WHITE);
		lblLasta.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblLasta.setBounds(20, 205, 200, 17);
		contentPane.add(lblLasta);
		
		txtLastname = new JTextField();
		txtLastname.setForeground(Color.BLACK);
		txtLastname.setFont(new Font("Arial Black", Font.BOLD, 15));
		txtLastname.setDisabledTextColor(Color.BLACK);
		txtLastname.setColumns(10);
		txtLastname.setBounds(20, 228, 253, 20);
		contentPane.add(txtLastname);
		
		JLabel lblOvertime = new JLabel("Overtime :");
		lblOvertime.setForeground(Color.WHITE);
		lblOvertime.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblOvertime.setBounds(20, 400, 122, 17);
		contentPane.add(lblOvertime);
		
		JLabel lblDate = new JLabel("Date : ");
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblDate.setBounds(20, 256, 200, 17);
		contentPane.add(lblDate);
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("MMMMM d, y");
		dateChooser.setFont(new Font("Arial", Font.BOLD, 12));
		dateChooser.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		dateChooser.setBounds(20, 278, 253, 20);
		contentPane.add(dateChooser);
		
		txtOvertime = new JTextField();
		txtOvertime.setHorizontalAlignment(SwingConstants.CENTER);
		txtOvertime.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		txtOvertime.setForeground(Color.BLACK);
		txtOvertime.setFont(new Font("Arial Black", Font.BOLD, 15));
		txtOvertime.setDisabledTextColor(Color.BLACK);
		txtOvertime.setColumns(10);
		txtOvertime.setBounds(20, 420, 45, 20);
		contentPane.add(txtOvertime);
		
		JLabel lblAbsences = new JLabel("Absences :");
		lblAbsences.setForeground(Color.WHITE);
		lblAbsences.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblAbsences.setBounds(353, 284, 132, 17);
		contentPane.add(lblAbsences);
		
		JLabel lblUndertime = new JLabel("Undertime :");
		lblUndertime.setForeground(Color.WHITE);
		lblUndertime.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblUndertime.setBounds(353, 372, 132, 17);
		contentPane.add(lblUndertime);
		
		JLabel lblTardiness = new JLabel("Tardiness :");
		lblTardiness.setForeground(Color.WHITE);
		lblTardiness.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblTardiness.setBounds(353, 328, 132, 17);
		contentPane.add(lblTardiness);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel.setBounds(20, 372, 45, 20);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PHP");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 46, 20);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(84, 326, 189, 20);
		contentPane.add(panel_1);
		
		JLabel lblDays = new JLabel("Days");
		lblDays.setForeground(new Color(0, 0, 0));
		lblDays.setHorizontalAlignment(SwingConstants.CENTER);
		lblDays.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblDays.setBounds(0, 0, 66, 20);
		panel_1.add(lblDays);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(64, 420, 78, 20);
		contentPane.add(panel_1_1);
		
		JLabel lblHours = new JLabel("Hours");
		lblHours.setForeground(new Color(0, 0, 0));
		lblHours.setHorizontalAlignment(SwingConstants.CENTER);
		lblHours.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblHours.setBounds(0, 0, 66, 20);
		panel_1_1.add(lblHours);
		
		JLabel lblTotalOvertime = new JLabel("Total Overtime  :");
		lblTotalOvertime.setForeground(Color.WHITE);
		lblTotalOvertime.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblTotalOvertime.setBounds(151, 400, 122, 17);
		contentPane.add(lblTotalOvertime);
		
		txtTotalOvertime = new JTextField();
		txtTotalOvertime.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalOvertime.setForeground(Color.WHITE);
		txtTotalOvertime.setFont(new Font("Arial Black", Font.BOLD, 15));
		txtTotalOvertime.setDisabledTextColor(Color.BLACK);
		txtTotalOvertime.setColumns(10);
		txtTotalOvertime.setBorder(null);
		txtTotalOvertime.setBackground(new Color(51, 51, 51));
		txtTotalOvertime.setBounds(150, 420, 123, 20);
		contentPane.add(txtTotalOvertime);
		
		txtAbsences = new JTextField();
		txtAbsences.setHorizontalAlignment(SwingConstants.CENTER);
		txtAbsences.setForeground(Color.BLACK);
		txtAbsences.setFont(new Font("Arial Black", Font.BOLD, 15));
		txtAbsences.setDisabledTextColor(Color.BLACK);
		txtAbsences.setColumns(10);
		txtAbsences.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		txtAbsences.setBounds(353, 305, 45, 20);
		contentPane.add(txtAbsences);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel_1_1_1.setBackground(Color.WHITE);
		panel_1_1_1.setBounds(394, 305, 78, 20);
		contentPane.add(panel_1_1_1);
		
		JLabel lblHours_1 = new JLabel("Hours");
		lblHours_1.setForeground(new Color(0, 0, 0));
		lblHours_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblHours_1.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblHours_1.setBounds(0, 0, 66, 20);
		panel_1_1_1.add(lblHours_1);
		
		JLabel lblTotal = new JLabel("Total Absences :");
		lblTotal.setForeground(Color.WHITE);
		lblTotal.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblTotal.setBounds(483, 284, 122, 17);
		contentPane.add(lblTotal);
		
		txtTotalAbsences = new JTextField();
		txtTotalAbsences.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalAbsences.setForeground(Color.WHITE);
		txtTotalAbsences.setFont(new Font("Arial Black", Font.BOLD, 15));
		txtTotalAbsences.setDisabledTextColor(Color.BLACK);
		txtTotalAbsences.setColumns(10);
		txtTotalAbsences.setBorder(null);
		txtTotalAbsences.setBackground(new Color(51, 51, 51));
		txtTotalAbsences.setBounds(483, 305, 123, 20);
		contentPane.add(txtTotalAbsences);
		
		txtTardiness = new JTextField();
		txtTardiness.setHorizontalAlignment(SwingConstants.CENTER);
		txtTardiness.setForeground(Color.BLACK);
		txtTardiness.setFont(new Font("Arial Black", Font.BOLD, 15));
		txtTardiness.setDisabledTextColor(Color.BLACK);
		txtTardiness.setColumns(10);
		txtTardiness.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		txtTardiness.setBounds(353, 350, 45, 20);
		contentPane.add(txtTardiness);
		
		JPanel panel_1_1_1_1 = new JPanel();
		panel_1_1_1_1.setLayout(null);
		panel_1_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel_1_1_1_1.setBackground(Color.WHITE);
		panel_1_1_1_1.setBounds(394, 350, 78, 20);
		contentPane.add(panel_1_1_1_1);
		
		JLabel lblHours_1_1 = new JLabel("Hours");
		lblHours_1_1.setForeground(new Color(0, 0, 0));
		lblHours_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblHours_1_1.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblHours_1_1.setBounds(0, 0, 66, 20);
		panel_1_1_1_1.add(lblHours_1_1);
		
		txtTotalTardiness = new JTextField();
		txtTotalTardiness.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalTardiness.setForeground(Color.WHITE);
		txtTotalTardiness.setFont(new Font("Arial Black", Font.BOLD, 15));
		txtTotalTardiness.setDisabledTextColor(Color.BLACK);
		txtTotalTardiness.setColumns(10);
		txtTotalTardiness.setBorder(null);
		txtTotalTardiness.setBackground(new Color(51, 51, 51));
		txtTotalTardiness.setBounds(483, 350, 123, 20);
		contentPane.add(txtTotalTardiness);
		
		JLabel lblTotalTardiness = new JLabel("Total Tardiness :");
		lblTotalTardiness.setForeground(Color.WHITE);
		lblTotalTardiness.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblTotalTardiness.setBounds(484, 331, 122, 17);
		contentPane.add(lblTotalTardiness);
		
		txtUndertime = new JTextField();
		txtUndertime.setHorizontalAlignment(SwingConstants.CENTER);
		txtUndertime.setForeground(Color.BLACK);
		txtUndertime.setFont(new Font("Arial Black", Font.BOLD, 15));
		txtUndertime.setDisabledTextColor(Color.BLACK);
		txtUndertime.setColumns(10);
		txtUndertime.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		txtUndertime.setBounds(353, 392, 45, 20);
		contentPane.add(txtUndertime);
		
		JPanel panel_1_1_1_1_1 = new JPanel();
		panel_1_1_1_1_1.setLayout(null);
		panel_1_1_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel_1_1_1_1_1.setBackground(Color.WHITE);
		panel_1_1_1_1_1.setBounds(394, 392, 78, 20);
		contentPane.add(panel_1_1_1_1_1);
		
		JLabel lblHours_1_1_1 = new JLabel("Hours");
		lblHours_1_1_1.setForeground(new Color(0, 0, 0));
		lblHours_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblHours_1_1_1.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblHours_1_1_1.setBounds(0, 0, 66, 20);
		panel_1_1_1_1_1.add(lblHours_1_1_1);
		
		JLabel lblTotalUndertime = new JLabel("Total Undertime :");
		lblTotalUndertime.setForeground(Color.WHITE);
		lblTotalUndertime.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblTotalUndertime.setBounds(484, 372, 128, 17);
		contentPane.add(lblTotalUndertime);
		
		txtTotalUndertime = new JTextField();
		txtTotalUndertime.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalUndertime.setForeground(Color.WHITE);
		txtTotalUndertime.setFont(new Font("Arial Black", Font.BOLD, 15));
		txtTotalUndertime.setDisabledTextColor(Color.BLACK);
		txtTotalUndertime.setColumns(10);
		txtTotalUndertime.setBorder(null);
		txtTotalUndertime.setBackground(new Color(51, 51, 51));
		txtTotalUndertime.setBounds(483, 392, 123, 20);
		contentPane.add(txtTotalUndertime);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(352, 120, 56, 20);
		contentPane.add(panel_2);
		
		JLabel lblNewLabel_2 = new JLabel("PHP");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_2.setBounds(0, 0, 46, 20);
		panel_2.add(lblNewLabel_2);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel_2_1.setBackground(Color.WHITE);
		panel_2_1.setBounds(353, 165, 56, 20);
		contentPane.add(panel_2_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("PHP");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(Color.BLACK);
		lblNewLabel_2_1.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(0, 0, 46, 20);
		panel_2_1.add(lblNewLabel_2_1);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setLayout(null);
		panel_2_2.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel_2_2.setBackground(Color.WHITE);
		panel_2_2.setBounds(353, 209, 56, 20);
		contentPane.add(panel_2_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("PHP");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setForeground(Color.BLACK);
		lblNewLabel_2_2.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_2_2.setBounds(0, 0, 46, 20);
		panel_2_2.add(lblNewLabel_2_2);
		
		JPanel panel_2_3 = new JPanel();
		panel_2_3.setLayout(null);
		panel_2_3.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel_2_3.setBackground(Color.WHITE);
		panel_2_3.setBounds(353, 258, 56, 20);
		contentPane.add(panel_2_3);
		
		JLabel lblNewLabel_2_3 = new JLabel("PHP");
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_3.setForeground(Color.BLACK);
		lblNewLabel_2_3.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_2_3.setBounds(0, 0, 46, 20);
		panel_2_3.add(lblNewLabel_2_3);
		
		JLabel lblSssLoan = new JLabel("SSS Loan :");
		lblSssLoan.setForeground(Color.WHITE);
		lblSssLoan.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblSssLoan.setBounds(353, 416, 280, 17);
		contentPane.add(lblSssLoan);
		
		txtSSSLoan = new JTextField();
		txtSSSLoan.setForeground(Color.BLACK);
		txtSSSLoan.setFont(new Font("Arial Black", Font.BOLD, 15));
		txtSSSLoan.setDisabledTextColor(Color.BLACK);
		txtSSSLoan.setColumns(10);
		txtSSSLoan.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		txtSSSLoan.setBounds(406, 436, 200, 20);
		contentPane.add(txtSSSLoan);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel_2_1_1.setBackground(Color.WHITE);
		panel_2_1_1.setBounds(353, 436, 56, 20);
		contentPane.add(panel_2_1_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("PHP");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1.setForeground(Color.BLACK);
		lblNewLabel_2_1_1.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_2_1_1.setBounds(0, 0, 46, 20);
		panel_2_1_1.add(lblNewLabel_2_1_1);
		
		JPanel panel_2_2_1 = new JPanel();
		panel_2_2_1.setLayout(null);
		panel_2_2_1.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel_2_2_1.setBackground(Color.WHITE);
		panel_2_2_1.setBounds(353, 480, 56, 20);
		contentPane.add(panel_2_2_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("PHP");
		lblNewLabel_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2_1.setForeground(Color.BLACK);
		lblNewLabel_2_2_1.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_2_2_1.setBounds(0, 0, 46, 20);
		panel_2_2_1.add(lblNewLabel_2_2_1);
		
		txtPhilHealthLoan = new JTextField();
		txtPhilHealthLoan.setForeground(Color.BLACK);
		txtPhilHealthLoan.setFont(new Font("Arial Black", Font.BOLD, 15));
		txtPhilHealthLoan.setDisabledTextColor(Color.BLACK);
		txtPhilHealthLoan.setColumns(10);
		txtPhilHealthLoan.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		txtPhilHealthLoan.setBounds(406, 480, 200, 20);
		contentPane.add(txtPhilHealthLoan);
		
		txtPagibigLoan = new JTextField();
		txtPagibigLoan.setForeground(Color.BLACK);
		txtPagibigLoan.setFont(new Font("Arial Black", Font.BOLD, 15));
		txtPagibigLoan.setDisabledTextColor(Color.BLACK);
		txtPagibigLoan.setColumns(10);
		txtPagibigLoan.setBorder(new LineBorder(new Color(171, 173, 179), 0));
		txtPagibigLoan.setBounds(406, 529, 200, 20);
		contentPane.add(txtPagibigLoan);
		
		JPanel panel_2_3_1 = new JPanel();
		panel_2_3_1.setLayout(null);
		panel_2_3_1.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel_2_3_1.setBackground(Color.WHITE);
		panel_2_3_1.setBounds(353, 529, 56, 20);
		contentPane.add(panel_2_3_1);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("PHP");
		lblNewLabel_2_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_3_1.setForeground(Color.BLACK);
		lblNewLabel_2_3_1.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_2_3_1.setBounds(0, 0, 46, 20);
		panel_2_3_1.add(lblNewLabel_2_3_1);
		
		JLabel lblPhilhealthLoan = new JLabel("PhilHealth Loan :");
		lblPhilhealthLoan.setForeground(Color.WHITE);
		lblPhilhealthLoan.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblPhilhealthLoan.setBounds(353, 460, 280, 17);
		contentPane.add(lblPhilhealthLoan);
		
		JLabel lblPagibigLoan = new JLabel("Pag-Ibig Loan :");
		lblPagibigLoan.setForeground(Color.WHITE);
		lblPagibigLoan.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblPagibigLoan.setBounds(353, 505, 280, 17);
		contentPane.add(lblPagibigLoan);
		
		
		DocumentListener listener = new DocumentListener() {
		    public void changedUpdate(DocumentEvent e) {
		        performComputation();
		    }
		    public void removeUpdate(DocumentEvent e) {
		        performComputation();
		    }
		    public void insertUpdate(DocumentEvent e) {
		        performComputation();
		    }
		    private void performComputation() {
			    try {
			    
			    	DaysPerYear = Integer.parseInt(txtDaysPerYear.getText());

			    	rateSalary = 15000;
			        resultDailyRate = ((rateSalary * 12) / DaysPerYear);
			        resultGrossSalary = resultDailyRate * 20;
			        
			        txtDailyRate.setText(String.valueOf(resultDailyRate));
			        txtGrossSalary.setText("PHP " + String.valueOf(resultGrossSalary));
			        
			        Overtime = Integer.parseInt(txtOvertime.getText());
			    	Undertime = Integer.parseInt(txtUndertime.getText());
			    	Absences = Integer.parseInt(txtAbsences.getText());
			    	Tardiness = Integer.parseInt(txtTardiness.getText());
			    	
			        resultOvertime = Overtime * (resultDailyRate / 8);
			    	resultUndertime = Undertime * (resultDailyRate / 8);
			    	resultAbsences = Absences * (resultDailyRate / 8);
			    	resultTardiness = Tardiness * (resultDailyRate / 8);
			    	
			    	txtTotalOvertime.setText("PHP " + String.valueOf(resultOvertime));
			    	txtTotalUndertime.setText("PHP " + String.valueOf(resultUndertime));
			    	txtTotalAbsences.setText("PHP " + String.valueOf(resultAbsences));
			    	txtTotalTardiness.setText("PHP " + String.valueOf(resultTardiness));
			        
			    	WitholdTax();
			    	SSS();
			    	Philhealth();
			    	Pagibig();
			    	
			    	SSSLoan = Integer.parseInt(txtSSSLoan.getText());
			    	PhilHealthLoan = Integer.parseInt(txtPhilHealthLoan.getText());
			    	PagibigLoan = Integer.parseInt(txtPagibigLoan.getText());
			    	
			    	resultDeduction = TotalTax + TotalPhilHealth + TotalSSS + TotalPagibig + resultUndertime + resultAbsences + resultTardiness + SSSLoan + PhilHealthLoan + PagibigLoan;
			    	resultNetPay = resultGrossSalary - resultDeduction;
			    	
			    	txtTotalDeduction.setText("PHP " + String.valueOf(resultDeduction));
					txtTotalNetPay.setText("PHP " + String.valueOf(resultNetPay));
			        
			    } catch (NumberFormatException ex) {
			        // Ignore non-integer input
			    } catch (IllegalStateException e) {
			    	
			    }
			}

		};
		txtGrossSalary.getDocument().addDocumentListener(listener);
		txtDailyRate.getDocument().addDocumentListener(listener);
		txtDaysPerYear.getDocument().addDocumentListener(listener);
		
		txtOvertime.getDocument().addDocumentListener(listener);
	    txtUndertime.getDocument().addDocumentListener(listener);
	    txtAbsences.getDocument().addDocumentListener(listener);
	    txtTardiness.getDocument().addDocumentListener(listener);
		
		txtTotalOvertime.getDocument().addDocumentListener(listener);
    	txtTotalUndertime.getDocument().addDocumentListener(listener);
    	txtTotalAbsences.getDocument().addDocumentListener(listener);
    	txtTotalTardiness.getDocument().addDocumentListener(listener);
		
		txtTax.getDocument().addDocumentListener(listener);
		txtSSS.getDocument().addDocumentListener(listener);
		txtPhilhealth.getDocument().addDocumentListener(listener);
		txtPagibig.getDocument().addDocumentListener(listener);
		
		txtSSSLoan.getDocument().addDocumentListener(listener);
    	txtPhilHealthLoan.getDocument().addDocumentListener(listener);
    	txtPagibigLoan.getDocument().addDocumentListener(listener);
		
		txtTotalDeduction.getDocument().addDocumentListener(listener);
		txtTotalNetPay.getDocument().addDocumentListener(listener);
		
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				
				DateFormat date = new SimpleDateFormat("MMMMMM dd, yyyy");
					
				Connection con = DriverManager.getConnection("jdbc:sqlite:src/Database/usersDatabase.db");
				
				PreparedStatement states = con.prepareStatement("INSERT INTO usersPayroll (Id, Firstname, Lastname, Date, DaysPerYear, DailyRate, Overtime, GrossSalary, Tax, SSS, PhilHealth, Pagibig, SSSLoan, PhilHealthLoan, PagibigLoan, Absences, Tardiness, Undertime, TotalDeduction, NetSalary) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				states.setInt(1, Integer.parseInt(txtId.getText()));
				states.setString(2, txtFirstname.getText());
				states.setString(3, txtLastname.getText());
				states.setString(4, date.format(dateChooser.getDate()));
				states.setString(5, DaysPerYear + " Days");
				states.setString(6, "₱ " + resultDailyRate);
				states.setString(7, "₱ " + resultOvertime);
				states.setString(8, "₱ " + resultGrossSalary);
				states.setString(9, "₱ " + TotalTax);
				states.setString(10, "₱ " + TotalSSS);
				states.setString(11, "₱ " + TotalPhilHealth);
				states.setString(12, "₱ " + TotalPagibig);
				states.setString(13, "₱ " + SSSLoan);
				states.setString(14, "₱ " + PhilHealthLoan);
				states.setString(15, "₱ " + PagibigLoan);
				states.setString(16, "₱ " + resultAbsences);
				states.setString(17, "₱ " + resultTardiness);
				states.setString(18, "₱ " + resultUndertime);
				states.setString(19, "₱ " + resultDeduction);
				states.setString(20,"₱ " + resultNetPay);
				
				int inserted = states.executeUpdate();
			
				
				if (inserted > 0) {
				
					JOptionPane.showMessageDialog(null, "Employee Payroll Added Successfully");
					B_EmployeePayroll.this.dispose();

					states.close();
					con.close();
				}
				
				}catch(SQLException e3) {
					e3.printStackTrace();
				}
			}
		});
		
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				B_EmployeePayroll.this.dispose();
			}
		});
		
		setLocationRelativeTo(null);
	}
	
	public void WitholdTax() {
		if (20832 >= resultGrossSalary) {
			
			TotalTax = 0;
			txtTax.setText(String.valueOf(TotalTax));
			
		} else if (resultGrossSalary > 20833 || resultGrossSalary > 33332){
			
			TotalTax = resultGrossSalary * 0.15;
			txtTax.setText(String.valueOf(TotalTax));
			
		} else {
			
			TotalTax = resultGrossSalary * 0.20;
			txtTax.setText(String.valueOf(TotalTax));
			
		}
	}
	
	public void SSS() {
		if (resultGrossSalary <= 4250) {
			
		    TotalSSS = 180;
		    txtSSS.setText(String.valueOf(TotalSSS));
		    
		} else if (resultGrossSalary > 4250 && resultGrossSalary <= 5750) {
			
		    TotalSSS = 315;
		    txtSSS.setText(String.valueOf(TotalSSS));
		    
		} else if (resultGrossSalary > 5750 && resultGrossSalary <= 6249) {
			
		    TotalSSS = 360;
		    txtSSS.setText(String.valueOf(TotalSSS));
		    
		} else if (resultGrossSalary > 6249 && resultGrossSalary <= 7249) {
			
		    TotalSSS = 405;
		    txtSSS.setText(String.valueOf(TotalSSS));
		    
		} else if (resultGrossSalary > 7249 && resultGrossSalary <= 9249) {
			
		    TotalSSS = 450;
		    txtSSS.setText(String.valueOf(TotalSSS));
		    
		} else if (resultGrossSalary > 9249 && resultGrossSalary <= 11249) {
			
		    TotalSSS = 495;
		    txtSSS.setText(String.valueOf(TotalSSS));
		    
		} else if (resultGrossSalary > 11249 && resultGrossSalary <= 12249) {
			
		    TotalSSS = 540;
		    txtSSS.setText(String.valueOf(TotalSSS));
		    
		} else if (resultGrossSalary > 12249 && resultGrossSalary <= 13249) {
			
		    TotalSSS = 585;
		    txtSSS.setText(String.valueOf(TotalSSS));
		    
		} else if (resultGrossSalary > 13249 && resultGrossSalary <= 14249) {
			
		    TotalSSS = 630;
		    txtSSS.setText(String.valueOf(TotalSSS));
		    
		} else if (resultGrossSalary > 14249 && resultGrossSalary <= 15249) {
			
		    TotalSSS = 675;
		    txtSSS.setText(String.valueOf(TotalSSS));
		    
		} else if (resultGrossSalary > 15249 && resultGrossSalary <= 16249) {
			
		    TotalSSS = 720;
		    txtSSS.setText(String.valueOf(TotalSSS));
		    
		} else {
			
		    TotalSSS = 900;
		    txtSSS.setText(String.valueOf(TotalSSS));
		}

	}
	
	public void Philhealth() {
		if (resultGrossSalary <= 8999) {
			
			TotalPhilHealth = 100;
		    txtPhilhealth.setText(String.valueOf(TotalPhilHealth));
		    
		} else if (resultGrossSalary > 9000 && resultGrossSalary <= 9999) {
			
			TotalPhilHealth = 112;
			txtPhilhealth.setText(String.valueOf(TotalPhilHealth));
		    
		} else if (resultGrossSalary > 10000 && resultGrossSalary <= 10999) {
			
			TotalPhilHealth = 125;
			txtPhilhealth.setText(String.valueOf(TotalPhilHealth));
		    
		} else if (resultGrossSalary > 11000 && resultGrossSalary <= 11999) {
			
			TotalPhilHealth = 137;
			txtPhilhealth.setText(String.valueOf(TotalPhilHealth));
		    
		} else if (resultGrossSalary > 12000 && resultGrossSalary <= 12999) {
			
			TotalPhilHealth = 150;
			txtPhilhealth.setText(String.valueOf(TotalPhilHealth));
			
		} else if (resultGrossSalary > 13000 && resultGrossSalary <= 13999) {
			
			TotalPhilHealth = 162;
			txtPhilhealth.setText(String.valueOf(TotalPhilHealth));
			 
		} else if (resultGrossSalary > 14000 && resultGrossSalary <= 14999) {
			
			TotalPhilHealth = 175;
			txtPhilhealth.setText(String.valueOf(TotalPhilHealth));
			
		} else if (resultGrossSalary > 15000 && resultGrossSalary <= 15999) {
			
			TotalPhilHealth = 187;
			txtPhilhealth.setText(String.valueOf(TotalPhilHealth));
			
		} else {
			
			TotalPhilHealth = 200;
			txtPhilhealth.setText(String.valueOf(TotalPhilHealth));
			
		}

	}
	

	public void Pagibig() {
		if (resultGrossSalary <= 999) {
			
		    TotalPagibig = resultGrossSalary * 0.01;
		    txtPagibig.setText(String.valueOf(TotalPagibig));
		    
		} else if (resultGrossSalary > 1000 && resultGrossSalary <= 1499) {
			
			TotalPagibig = resultGrossSalary * 0.02;
			txtPagibig.setText(String.valueOf(txtPagibig));
		    
		} else if (resultGrossSalary > 1500 && resultGrossSalary <= 4999) {
			
			TotalPagibig = resultGrossSalary * 0.02;
			txtPagibig.setText(String.valueOf(txtPagibig));
			
		} else {
			
			TotalPagibig = resultGrossSalary * 0.03;
			txtPagibig.setText(String.valueOf(TotalPagibig));
			
		}

	}
}
