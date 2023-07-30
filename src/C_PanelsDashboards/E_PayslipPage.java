package C_PanelsDashboards;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.text.AbstractDocument.Content;

import D_Forms.PrintPanel;

import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;

public class E_PayslipPage extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private JTable table;
	
	DefaultTableModel tbModel;
	private JPanel panel;
	private JLabel lbldate;
	private JLabel lblday;
	
	private JLabel lblId;
	private JLabel lblFirstname;
	private JLabel lblDaysPerYear;
	private JLabel lblDailyRate;
	private JLabel lblOvertime;
	private JLabel lblGrossPays;
	private JLabel lblTax;
	private JLabel lblPhilHealth;
	private JLabel lblSSS;
	private JLabel lblPagibig;
	private JLabel lblDeduction;
	private JLabel lblNetpay;

	private Image Clogo = new ImageIcon
			("src/res/companyLogo.png")
			.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
	private Image iconPayslip = new ImageIcon
			("src/res/iconPayslip.png")
			.getImage().getScaledInstance(80, 60, Image.SCALE_SMOOTH);
	
	private JLabel lblSSSLoan;
	private JLabel lblPhilHealthLoan;
	private JLabel lblPagibigLoan;
	private JLabel lblAbsences;
	private JLabel lblTardiness;
	private JLabel lblUndertime;
	private JLabel lblLastname;
	private JLabel lblSSSId;
	private JLabel lblPhilHealthId;
	private JLabel lblPagibigId;
	private JLabel lblNationalId;
	
	public E_PayslipPage() {
		setBackground(new Color(51, 51, 51));
		setBounds(0, 0, 936, 656);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(608, 11, 321, 166);
		scrollPane.setBorder(new LineBorder(new Color(130, 135, 144), 0));
		scrollPane.setForeground(new Color(0, 0, 0));
		scrollPane.setBackground(new Color(0, 0, 0));
		add(scrollPane);
		
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
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
		
		JLabel lblEmployeesPayslip = new JLabel("Employees");
		lblEmployeesPayslip.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployeesPayslip.setForeground(Color.WHITE);
		lblEmployeesPayslip.setFont(new Font("Britannic Bold", Font.BOLD, 60));
		lblEmployeesPayslip.setBounds(608, 220, 321, 73);
		add(lblEmployeesPayslip);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(10, 11, 585, 638);
		add(scrollPane_1);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		scrollPane_1.setViewportView(panel);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("SAMGY");
		lblNewLabel_2.setBounds(100, 10, 168, 45);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Segoe Print", Font.BOLD, 42));
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("RESTAURANT");
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setFont(new Font("Segoe Print", Font.BOLD, 40));
		lblNewLabel_3.setBounds(278, 11, 295, 45);
		panel.add(lblNewLabel_3);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Clogo));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setForeground(Color.WHITE);
		lblLogo.setBackground(Color.WHITE);
		lblLogo.setBounds(10, 11, 80, 82);
		panel.add(lblLogo);
		
		JLabel lblBy = new JLabel("by ");
		lblBy.setFont(new Font("Eras Medium ITC", Font.ITALIC, 40));
		lblBy.setBounds(169, 46, 67, 59);
		panel.add(lblBy);
		
		JLabel lblName = new JLabel("RISARE'S");
		lblName.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 50));
		lblName.setBounds(240, 56, 278, 59);
		panel.add(lblName);
		
		JLabel lblNewLabel = new JLabel("Date of Payment : ");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 116, 129, 22);
		panel.add(lblNewLabel);
		
		lbldate = new JLabel("");
		lbldate.setFont(new Font("Arial", Font.PLAIN, 15));
		lbldate.setBounds(140, 116, 89, 22);
		panel.add(lbldate);
		
		lblday = new JLabel("");
		lblday.setFont(new Font("Arial", Font.PLAIN, 15));
		lblday.setBounds(228, 116, 77, 22);
		panel.add(lblday);
		
		JLabel lblEmployeeInformation = new JLabel("Employee Information");
		lblEmployeeInformation.setFont(new Font("Arial", Font.BOLD, 15));
		lblEmployeeInformation.setBounds(10, 137, 261, 22);
		panel.add(lblEmployeeInformation);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel_1.setBounds(10, 164, 563, 2);
		panel.add(panel_1);
		
		JLabel lblEmployeeId = new JLabel("Employee Id : ");
		lblEmployeeId.setFont(new Font("Arial", Font.BOLD, 15));
		lblEmployeeId.setBounds(10, 170, 109, 22);
		panel.add(lblEmployeeId);
		
		JLabel lblEmployeeId_1 = new JLabel("Firstname : ");
		lblEmployeeId_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblEmployeeId_1.setBounds(10, 195, 89, 22);
		panel.add(lblEmployeeId_1);
		
		JLabel lblEmployeeId_2 = new JLabel("PhilHealth Id : ");
		lblEmployeeId_2.setFont(new Font("Arial", Font.BOLD, 15));
		lblEmployeeId_2.setBounds(10, 267, 109, 22);
		panel.add(lblEmployeeId_2);
		
		JLabel lblEmployeeId_2_1 = new JLabel("SSS Id : ");
		lblEmployeeId_2_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblEmployeeId_2_1.setBounds(10, 244, 67, 22);
		panel.add(lblEmployeeId_2_1);
		
		JLabel lblEmployeeId_2_1_1 = new JLabel("Pag-Ibig Id : ");
		lblEmployeeId_2_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblEmployeeId_2_1_1.setBounds(10, 294, 89, 22);
		panel.add(lblEmployeeId_2_1_1);
		
		JLabel lblEmployeeInformation_1 = new JLabel("Earnings");
		lblEmployeeInformation_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblEmployeeInformation_1.setBounds(10, 390, 89, 22);
		panel.add(lblEmployeeInformation_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel_1_1.setBackground(Color.BLACK);
		panel_1_1.setBounds(10, 415, 285, 2);
		panel.add(panel_1_1);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel_1_1_1.setBackground(Color.BLACK);
		panel_1_1_1.setBounds(330, 267, 243, 2);
		panel.add(panel_1_1_1);
		
		JLabel lblEmployeeInformation_1_1 = new JLabel("Deduction");
		lblEmployeeInformation_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblEmployeeInformation_1_1.setBounds(330, 244, 89, 22);
		panel.add(lblEmployeeInformation_1_1);
		
		JLabel lblRatePerHour = new JLabel("Days per Year : ");
		lblRatePerHour.setFont(new Font("Arial", Font.BOLD, 15));
		lblRatePerHour.setBounds(10, 420, 129, 22);
		panel.add(lblRatePerHour);
		
		JLabel lblHourPerDay = new JLabel("Daily Rate : ");
		lblHourPerDay.setFont(new Font("Arial", Font.BOLD, 15));
		lblHourPerDay.setBounds(10, 444, 109, 22);
		panel.add(lblHourPerDay);
		
		JLabel lblNumberOfDays = new JLabel("Overtime : ");
		lblNumberOfDays.setFont(new Font("Arial", Font.BOLD, 15));
		lblNumberOfDays.setBounds(10, 470, 94, 22);
		panel.add(lblNumberOfDays);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(128, 128, 128));
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel_2.setBounds(10, 503, 310, 30);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblGrossPay = new JLabel("Gross Pay  : ");
		lblGrossPay.setForeground(new Color(255, 255, 255));
		lblGrossPay.setBounds(10, 0, 94, 30);
		lblGrossPay.setFont(new Font("Arial", Font.BOLD, 15));
		panel_2.add(lblGrossPay);
		
		lblGrossPays = new JLabel("");
		lblGrossPays.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrossPays.setForeground(Color.WHITE);
		lblGrossPays.setFont(new Font("Arial", Font.PLAIN, 15));
		lblGrossPays.setBounds(114, 0, 161, 30);
		panel_2.add(lblGrossPays);
		
		JLabel lblTaxs = new JLabel("Tax : ");
		lblTaxs.setFont(new Font("Arial", Font.BOLD, 15));
		lblTaxs.setBounds(330, 270, 58, 22);
		panel.add(lblTaxs);
		
		JLabel lblPhilhealth = new JLabel("PhilHealth : ");
		lblPhilhealth.setFont(new Font("Arial", Font.BOLD, 15));
		lblPhilhealth.setBounds(330, 320, 89, 22);
		panel.add(lblPhilhealth);
		
		JLabel lblSss = new JLabel("SSS : ");
		lblSss.setFont(new Font("Arial", Font.BOLD, 15));
		lblSss.setBounds(330, 294, 51, 22);
		panel.add(lblSss);
		
		JLabel lblPagibi = new JLabel("Pag-Ibig : ");
		lblPagibi.setFont(new Font("Arial", Font.BOLD, 15));
		lblPagibi.setBounds(330, 344, 75, 22);
		panel.add(lblPagibi);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel_2_1.setBackground(Color.GRAY);
		panel_2_1.setBounds(330, 537, 243, 30);
		panel.add(panel_2_1);
		
		JLabel lblTotalDeduction = new JLabel("Total Deduction  : ");
		lblTotalDeduction.setForeground(Color.WHITE);
		lblTotalDeduction.setFont(new Font("Arial", Font.BOLD, 15));
		lblTotalDeduction.setBounds(10, 0, 129, 30);
		panel_2_1.add(lblTotalDeduction);
		
		lblDeduction = new JLabel("");
		lblDeduction.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeduction.setForeground(Color.WHITE);
		lblDeduction.setFont(new Font("Arial", Font.PLAIN, 15));
		lblDeduction.setBounds(143, 0, 90, 30);
		panel_2_1.add(lblDeduction);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setLayout(null);
		panel_2_2.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel_2_2.setBackground(Color.GRAY);
		panel_2_2.setBounds(10, 578, 563, 30);
		panel.add(panel_2_2);
		
		JLabel lblNetPay = new JLabel("Net Pay  : ");
		lblNetPay.setForeground(Color.WHITE);
		lblNetPay.setFont(new Font("Arial", Font.BOLD, 15));
		lblNetPay.setBounds(10, 0, 94, 30);
		panel_2_2.add(lblNetPay);
		
		lblNetpay = new JLabel("");
		lblNetpay.setHorizontalAlignment(SwingConstants.CENTER);
		lblNetpay.setForeground(Color.WHITE);
		lblNetpay.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNetpay.setBounds(96, 0, 196, 30);
		panel_2_2.add(lblNetpay);
		
		lblId = new JLabel("");
		lblId.setHorizontalAlignment(SwingConstants.LEFT);
		lblId.setFont(new Font("Arial", Font.PLAIN, 15));
		lblId.setBounds(116, 170, 145, 22);
		panel.add(lblId);
		
		lblFirstname = new JLabel("");
		lblFirstname.setHorizontalAlignment(SwingConstants.LEFT);
		lblFirstname.setFont(new Font("Arial", Font.PLAIN, 15));
		lblFirstname.setBounds(100, 195, 121, 22);
		panel.add(lblFirstname);
		
		lblDaysPerYear = new JLabel("");
		lblDaysPerYear.setHorizontalAlignment(SwingConstants.LEFT);
		lblDaysPerYear.setFont(new Font("Arial", Font.PLAIN, 15));
		lblDaysPerYear.setBounds(126, 420, 145, 22);
		panel.add(lblDaysPerYear);
		
		lblDailyRate = new JLabel("");
		lblDailyRate.setHorizontalAlignment(SwingConstants.LEFT);
		lblDailyRate.setFont(new Font("Arial", Font.PLAIN, 15));
		lblDailyRate.setBounds(116, 444, 145, 22);
		panel.add(lblDailyRate);
		
		lblOvertime = new JLabel("");
		lblOvertime.setHorizontalAlignment(SwingConstants.LEFT);
		lblOvertime.setFont(new Font("Arial", Font.PLAIN, 15));
		lblOvertime.setBounds(100, 470, 145, 22);
		panel.add(lblOvertime);
		
		lblTax = new JLabel("");
		lblTax.setHorizontalAlignment(SwingConstants.LEFT);
		lblTax.setFont(new Font("Arial", Font.PLAIN, 15));
		lblTax.setBounds(374, 270, 155, 22);
		panel.add(lblTax);
		
		lblPhilHealth = new JLabel("");
		lblPhilHealth.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhilHealth.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPhilHealth.setBounds(418, 320, 155, 22);
		panel.add(lblPhilHealth);
		
		lblSSS = new JLabel("");
		lblSSS.setHorizontalAlignment(SwingConstants.LEFT);
		lblSSS.setFont(new Font("Arial", Font.PLAIN, 15));
		lblSSS.setBounds(377, 294, 162, 22);
		panel.add(lblSSS);
		
		lblPagibig = new JLabel("");
		lblPagibig.setHorizontalAlignment(SwingConstants.LEFT);
		lblPagibig.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPagibig.setBounds(412, 344, 117, 22);
		panel.add(lblPagibig);
		
		JLabel lblEmployeeId_1_1 = new JLabel("Lastname : ");
		lblEmployeeId_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblEmployeeId_1_1.setBounds(10, 220, 80, 22);
		panel.add(lblEmployeeId_1_1);
		
		lblLastname = new JLabel("");
		lblLastname.setHorizontalAlignment(SwingConstants.LEFT);
		lblLastname.setFont(new Font("Arial", Font.PLAIN, 15));
		lblLastname.setBounds(100, 220, 121, 22);
		panel.add(lblLastname);
		
		JLabel lblEmployeeId_2_1_1_1 = new JLabel("National Id : ");
		lblEmployeeId_2_1_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblEmployeeId_2_1_1_1.setBounds(10, 323, 89, 22);
		panel.add(lblEmployeeId_2_1_1_1);
		
		JLabel lblAbsencess = new JLabel("Absences : ");
		lblAbsencess.setFont(new Font("Arial", Font.BOLD, 15));
		lblAbsencess.setBounds(330, 370, 89, 22);
		panel.add(lblAbsencess);
		
		JLabel lblTardinesss = new JLabel("Tardiness : ");
		lblTardinesss.setFont(new Font("Arial", Font.BOLD, 15));
		lblTardinesss.setBounds(330, 395, 89, 22);
		panel.add(lblTardinesss);
		
		JLabel lblUndertimes = new JLabel("Undertime : ");
		lblUndertimes.setFont(new Font("Arial", Font.BOLD, 15));
		lblUndertimes.setBounds(330, 423, 89, 22);
		panel.add(lblUndertimes);
		
		JLabel lblSssLoan = new JLabel("SSS Loan : ");
		lblSssLoan.setFont(new Font("Arial", Font.BOLD, 15));
		lblSssLoan.setBounds(330, 450, 89, 22);
		panel.add(lblSssLoan);
		
		lblSSSLoan = new JLabel("");
		lblSSSLoan.setHorizontalAlignment(SwingConstants.LEFT);
		lblSSSLoan.setFont(new Font("Arial", Font.PLAIN, 15));
		lblSSSLoan.setBounds(418, 450, 135, 22);
		panel.add(lblSSSLoan);
		
		JLabel lblPhilhealthLoan = new JLabel("PhilHealth Loan : ");
		lblPhilhealthLoan.setFont(new Font("Arial", Font.BOLD, 15));
		lblPhilhealthLoan.setBounds(330, 478, 129, 22);
		panel.add(lblPhilhealthLoan);
		
		lblPhilHealthLoan = new JLabel("");
		lblPhilHealthLoan.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhilHealthLoan.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPhilHealthLoan.setBounds(456, 478, 117, 22);
		panel.add(lblPhilHealthLoan);
		
		JLabel lblPagibigLoan_1 = new JLabel("Pag-Ibig Loan : ");
		lblPagibigLoan_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblPagibigLoan_1.setBounds(330, 504, 109, 22);
		panel.add(lblPagibigLoan_1);
		
		lblPagibigLoan = new JLabel("");
		lblPagibigLoan.setHorizontalAlignment(SwingConstants.LEFT);
		lblPagibigLoan.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPagibigLoan.setBounds(442, 504, 121, 22);
		panel.add(lblPagibigLoan);
		
		lblAbsences = new JLabel("");
		lblAbsences.setHorizontalAlignment(SwingConstants.LEFT);
		lblAbsences.setFont(new Font("Arial", Font.PLAIN, 15));
		lblAbsences.setBounds(412, 370, 135, 22);
		panel.add(lblAbsences);
		
		lblTardiness = new JLabel("");
		lblTardiness.setHorizontalAlignment(SwingConstants.LEFT);
		lblTardiness.setFont(new Font("Arial", Font.PLAIN, 15));
		lblTardiness.setBounds(418, 395, 129, 22);
		panel.add(lblTardiness);
		
		lblUndertime = new JLabel("");
		lblUndertime.setHorizontalAlignment(SwingConstants.LEFT);
		lblUndertime.setFont(new Font("Arial", Font.PLAIN, 15));
		lblUndertime.setBounds(418, 423, 129, 22);
		panel.add(lblUndertime);
		
		lblSSSId = new JLabel("");
		lblSSSId.setHorizontalAlignment(SwingConstants.LEFT);
		lblSSSId.setFont(new Font("Arial", Font.PLAIN, 15));
		lblSSSId.setBounds(74, 244, 135, 22);
		panel.add(lblSSSId);
		
		lblPhilHealthId = new JLabel("");
		lblPhilHealthId.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhilHealthId.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPhilHealthId.setBounds(117, 267, 104, 22);
		panel.add(lblPhilHealthId);
		
		lblNationalId = new JLabel("");
		lblNationalId.setHorizontalAlignment(SwingConstants.LEFT);
		lblNationalId.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNationalId.setBounds(100, 323, 117, 22);
		panel.add(lblNationalId);
		
		lblPagibigId = new JLabel("");
		lblPagibigId.setHorizontalAlignment(SwingConstants.LEFT);
		lblPagibigId.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPagibigId.setBounds(100, 294, 104, 22);
		panel.add(lblPagibigId);
		
		JButton btnPrint = new JButton("SAVE");
		
		btnPrint.setForeground(Color.WHITE);
		btnPrint.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 40));
		btnPrint.setFocusable(false);
		btnPrint.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnPrint.setBackground(Color.BLACK);
		btnPrint.setBounds(649, 482, 240, 50);
		add(btnPrint);
		
		JButton btnPrint_2 = new JButton("PRINT");
		
		btnPrint_2.setForeground(Color.WHITE);
		btnPrint_2.setFont(new Font("Franklin Gothic Demi", Font.BOLD, 40));
		btnPrint_2.setFocusable(false);
		btnPrint_2.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		btnPrint_2.setBackground(Color.BLACK);
		btnPrint_2.setBounds(649, 558, 240, 50);
		add(btnPrint_2);
		
		JLabel lblPaylip = new JLabel("Payslip");
		lblPaylip.setHorizontalAlignment(SwingConstants.LEFT);
		lblPaylip.setForeground(Color.WHITE);
		lblPaylip.setFont(new Font("Britannic Bold", Font.BOLD, 60));
		lblPaylip.setBounds(618, 289, 210, 73);
		add(lblPaylip);
		
		JLabel lblPayslipLogo = new JLabel("");
		lblPayslipLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPayslipLogo.setBounds(832, 289, 82, 65);
		lblPayslipLogo.setIcon(new ImageIcon(iconPayslip));
		add(lblPayslipLogo);
		
		table.getColumnModel().getColumn(2).setPreferredWidth(79);
		table.getColumnModel().getColumn(4).setPreferredWidth(107);
		table.getColumnModel().getColumn(6).setPreferredWidth(48);
		table.getColumnModel().getColumn(7).setPreferredWidth(58);
		table.getColumnModel().getColumn(8).setPreferredWidth(50);
		table.getColumnModel().getColumn(9).setPreferredWidth(55);
		table.getColumnModel().getColumn(10).setPreferredWidth(85);
		
		fillTable();
		
		JTableHeader THeader = table.getTableHeader();
		THeader.setBackground(new Color(102, 0, 0));
		THeader.setForeground(Color.white);
		THeader.setFont(new Font("Bookman Old Style", Font.BOLD, 10));
		
		DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
		centerRender.setHorizontalAlignment(JLabel.CENTER);
		for(int x = 0; x < 20; x++) {
			table.getColumnModel().getColumn(x).setCellRenderer(centerRender);
		}
		
		showDate();
		showDay();
		
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				int selectedRow = table.getSelectedRow();
					
				if(selectedRow != -1) { 
					 int primaryKey = (int) table.getValueAt(selectedRow, 0);
					 
					 	Connection con = DriverManager.getConnection("jdbc:sqlite:src/Database/usersDatabase.db");
						String sql = "SELECT * FROM usersPayroll WHERE Id = ?";
						String sqls = "SELECT * FROM usersId WHERE Id = ?";
					    
						PreparedStatement statement = con.prepareStatement(sql);
						PreparedStatement statements = con.prepareStatement(sqls);
					    statement.setInt(1, primaryKey);
					    statements.setInt(1, primaryKey);
					    
					    ResultSet resultSet = statement.executeQuery();
					    ResultSet resultSets = statements.executeQuery();

				
					    if (resultSet.next()) {
					    
					    	if(resultSets.next()) {
					    		
						        int id = resultSet.getInt("Id");
						        String Firstname = resultSet.getString("Firstname");
						        String Lastname = resultSet.getString("Lastname");
						        String DaysPerYear = resultSet.getString("DaysPerYear");
						        String DailyRate = resultSet.getString("DailyRate");	
						        String Overtime = resultSet.getString("Overtime");	
						        String GrossSalary = resultSet.getString("GrossSalary");	
						        String Tax = resultSet.getString("Tax");
						        String SSS = resultSet.getString("SSS");
						        String PhilHealth = resultSet.getString("PhilHealth");	
						        String Pagibig = resultSet.getString("Pagibig");
						        String SSSLoan = resultSet.getString("SSSLoan");
						        String PhilHealthLoan = resultSet.getString("PhilHealthLoan");	
						        String PagibigLoan = resultSet.getString("PagibigLoan");
						        String Absences = resultSet.getString("Absences");
						        String Tardiness = resultSet.getString("Tardiness");	
						        String Undertime = resultSet.getString("Undertime");
						        String TotalDeduction = resultSet.getString("TotalDeduction");
						        String Netsalary = resultSet.getString("NetSalary");
						        
						        String SSSId = resultSets.getString("SSSId");
						        String PhilHealthId = resultSets.getString("PhilHealthId");
						        String PagibigId = resultSets.getString("PagibigId");
						        String NationalId = resultSets.getString("NationalId");
						        
						    	lblId.setText(String.valueOf(id));
						    	lblFirstname.setText(Firstname);
						    	lblLastname.setText(Lastname);
						    	lblDaysPerYear.setText(DaysPerYear);
						    	lblDailyRate.setText(DailyRate);
						    	lblOvertime.setText(Overtime);
						    	lblGrossPays.setText(GrossSalary);
						    	lblTax.setText(Tax);
						    	lblSSS.setText(SSS);
						    	lblPhilHealth.setText(PhilHealth);
						    	lblPagibig.setText(Pagibig);
						    	lblSSSLoan.setText(SSSLoan);
						    	lblPhilHealthLoan.setText(PhilHealthLoan);
						    	lblPagibigLoan.setText(PagibigLoan);
						    	lblAbsences.setText(Absences);
						    	lblTardiness.setText(Tardiness);
						    	lblUndertime.setText(Undertime);
						    	lblDeduction.setText(TotalDeduction);
						    	lblNetpay.setText(Netsalary);
						    	
						    	lblSSSId.setText(SSSId);
						        lblPhilHealthId.setText(PhilHealthId);
						        lblPagibigId.setText(PagibigId);
						        lblNationalId.setText(NationalId);
					    	}
					    }

					    // close the ResultSet and statement
					    resultSet.close();
					    statement.close();
					    con.close();
					}
				}catch (SQLException e2) {
					
				}
				
			}
		});
		
		btnPrint_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				try {
					PrintPanel printPanel = new PrintPanel(panel);
					printPanel.print();
					JOptionPane.showMessageDialog(null, "PDF Save Successfully");
					
				} catch (PrinterException e1) {
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
			ResultSet set = state.executeQuery("SELECT * FROM usersPayroll"); 
			
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
		lblday.setText("- "+dat);
	}
}
