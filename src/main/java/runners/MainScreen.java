package runners;

import domain.*;
import java.util.Scanner;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JScrollBar;
import javax.swing.JPasswordField;

public class MainScreen {

	private JFrame frame;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JTextField txtUsername;
	private JTextField txtNameA;
	private JTextField txtCityA;
	private JTextField txtHouseNumberA;
	private JTextField txtAgeA;
	private JTextField txtStreetNameA;
	private JTextField txtNameE;
	private JTextField txtSalary;
	private JTextField txtStreetNameE;
	private JTextField txtAgeE;
	private JTextField txtCityE;
	private JTextField txtHouseNumberE;
	private JTextField txtNameS;
	private JTextField txtGrade;
	private JTextField txtStreetNameS;
	private JTextField txtAgeS;
	private JTextField txtCityS;
	private JTextField txtHouseNumberS;
	private JTextField txtSearchName;
	private static JTextField txtNameSS;
	private static JTextField txtAgeSS;
	private static JTextField txtCitySS;
	private static JTextField txtStreetNameSS;
	private static JTextField txtHouseNumberSS;
	private static JTextField txtGradeSS;
	private static JTextField txtSalarySS;
	
	
	private static ArrayList<Administrator> admins = new ArrayList<Administrator>();
	private static ArrayList<Person> students = new ArrayList<>();
	private static ArrayList<Person> employees = new ArrayList<>();
	private static ArrayList<Person> matches = new ArrayList<>();
	private static int matchesNum;
	private static ObjectMapper om = new ObjectMapper();
	private JPasswordField txtPassword;
	private JTextField txtSalaryReport;
	private JTextField txtGradeReport;
	
	private static File adminsFile = new File("Admins.txt");
	private static File studentsFile = new File("Students.txt");
	private static File employeesFile = new File("Employees.txt");

	/**
	 * Launch the application.
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		
		
		
		
		
		//Read the files -- I know it can be one interface method but this is easier :P 
		if(adminsFile.exists()) {
			if(new Scanner(adminsFile).hasNextLine()) {
				try {
					admins = om.readValue(new Scanner(adminsFile).nextLine(), new TypeReference<ArrayList<Administrator>>() {});
				} catch (JsonParseException e) {
					e.printStackTrace();
				} catch (JsonMappingException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		if(studentsFile.exists()) {
			if(new Scanner(studentsFile).hasNextLine()) {
				try {
					students = om.readValue(new Scanner(studentsFile).nextLine(), new TypeReference<ArrayList<Student>>() {});
				} catch (JsonParseException e) {
					e.printStackTrace();
				} catch (JsonMappingException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		if(employeesFile.exists()) {
			if(new Scanner(employeesFile).hasNextLine()) {
				try {
					employees = om.readValue(new Scanner(employeesFile).nextLine(), new TypeReference<ArrayList<Employee>>() {});
				} catch (JsonParseException e) {
					e.printStackTrace();
				} catch (JsonMappingException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen window = new MainScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the application.
	 */
	public MainScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 630, 461);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		tabbedPane.setBounds(0, 0, 808, 521);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Add Administrator", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblStreetNameA = new JLabel("Street name");
		lblStreetNameA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStreetNameA.setHorizontalAlignment(SwingConstants.CENTER);
		lblStreetNameA.setBounds(320, 186, 96, 29);
		panel.add(lblStreetNameA);
		
		JLabel lblHouseNumberA = new JLabel("House number");
		lblHouseNumberA.setHorizontalAlignment(SwingConstants.CENTER);
		lblHouseNumberA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHouseNumberA.setBounds(57, 253, 96, 29);
		panel.add(lblHouseNumberA);
		
		JLabel lblCityA = new JLabel("City");
		lblCityA.setHorizontalAlignment(SwingConstants.CENTER);
		lblCityA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCityA.setBounds(57, 186, 96, 29);
		panel.add(lblCityA);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(57, 36, 96, 29);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(320, 36, 96, 29);
		panel.add(lblPassword);
		
		JLabel lblNameA = new JLabel("Name");
		lblNameA.setHorizontalAlignment(SwingConstants.CENTER);
		lblNameA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNameA.setBounds(57, 107, 96, 29);
		panel.add(lblNameA);
		
		JLabel lblAgeA = new JLabel("Age");
		lblAgeA.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgeA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAgeA.setBounds(320, 107, 96, 29);
		panel.add(lblAgeA);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(165, 40, 116, 22);
		panel.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtNameA = new JTextField();
		txtNameA.setColumns(10);
		txtNameA.setBounds(165, 111, 116, 22);
		panel.add(txtNameA);
		
		txtCityA = new JTextField();
		txtCityA.setColumns(10);
		txtCityA.setBounds(165, 190, 116, 22);
		panel.add(txtCityA);
		
		txtHouseNumberA = new JTextField();
		txtHouseNumberA.setColumns(10);
		txtHouseNumberA.setBounds(165, 257, 116, 22);
		panel.add(txtHouseNumberA);
		
		txtAgeA = new JTextField();
		txtAgeA.setColumns(10);
		txtAgeA.setBounds(428, 111, 116, 22);
		panel.add(txtAgeA);
		
		txtStreetNameA = new JTextField();
		txtStreetNameA.setColumns(10);
		txtStreetNameA.setBounds(428, 190, 116, 22);
		panel.add(txtStreetNameA);
		
		JButton btnAddAdmin = new JButton("Add");
		btnAddAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Administrator admin = new Administrator(txtNameA.getText(),Integer.parseInt(txtAgeA.getText()),Security.encrypt(txtUsername.getText()),Security.encrypt(txtPassword.getText()));
					admin.setAddress(new Address(txtStreetNameA.getText(),txtHouseNumberA.getText(),txtCityA.getText()));
					admins.add(admin);
					
				} catch (NumberFormatException e) {
					Security.parseHandeling();
				}
				
				
				
				txtNameA.setText(null);
				txtAgeA.setText(null);
				txtCityA.setText(null);
				txtHouseNumberA.setText(null);
				txtStreetNameA.setText(null);
				txtUsername.setText(null);
				txtPassword.setText(null);
				
				
			}
		});
		btnAddAdmin.setBounds(417, 271, 127, 61);
		panel.add(btnAddAdmin);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(428, 40, 116, 22);
		panel.add(txtPassword);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Add Employee", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNameE = new JLabel("Name");
		lblNameE.setHorizontalAlignment(SwingConstants.CENTER);
		lblNameE.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNameE.setBounds(48, 39, 96, 29);
		panel_1.add(lblNameE);
		
		JLabel lblAgeE = new JLabel("Age");
		lblAgeE.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgeE.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAgeE.setBounds(344, 39, 96, 29);
		panel_1.add(lblAgeE);
		
		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalary.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSalary.setBounds(48, 131, 96, 29);
		panel_1.add(lblSalary);
		
		JLabel lblCityE = new JLabel("City");
		lblCityE.setHorizontalAlignment(SwingConstants.CENTER);
		lblCityE.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCityE.setBounds(344, 131, 96, 29);
		panel_1.add(lblCityE);
		
		JLabel lblStreetNameE = new JLabel("Street name");
		lblStreetNameE.setHorizontalAlignment(SwingConstants.CENTER);
		lblStreetNameE.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStreetNameE.setBounds(48, 220, 96, 29);
		panel_1.add(lblStreetNameE);
		
		JLabel lblHouseNumberE = new JLabel("House Number");
		lblHouseNumberE.setHorizontalAlignment(SwingConstants.CENTER);
		lblHouseNumberE.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHouseNumberE.setBounds(344, 220, 96, 29);
		panel_1.add(lblHouseNumberE);
		
		txtNameE = new JTextField();
		txtNameE.setBounds(167, 43, 116, 22);
		panel_1.add(txtNameE);
		txtNameE.setColumns(10);
		
		txtSalary = new JTextField();
		txtSalary.setColumns(10);
		txtSalary.setBounds(167, 135, 116, 22);
		panel_1.add(txtSalary);
		
		txtStreetNameE = new JTextField();
		txtStreetNameE.setColumns(10);
		txtStreetNameE.setBounds(167, 224, 116, 22);
		panel_1.add(txtStreetNameE);
		
		txtAgeE = new JTextField();
		txtAgeE.setColumns(10);
		txtAgeE.setBounds(452, 43, 116, 22);
		panel_1.add(txtAgeE);
		
		txtCityE = new JTextField();
		txtCityE.setColumns(10);
		txtCityE.setBounds(452, 135, 116, 22);
		panel_1.add(txtCityE);
		
		txtHouseNumberE = new JTextField();
		txtHouseNumberE.setColumns(10);
		txtHouseNumberE.setBounds(452, 224, 116, 22);
		panel_1.add(txtHouseNumberE);
		
		JButton btnAddEmployee = new JButton("Add");
		btnAddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Employee employee = new Employee(txtNameE.getText(),Integer.parseInt(txtAgeE.getText()),Integer.parseInt(txtSalary.getText()));
					employee.setAddress(new Address(txtStreetNameE.getText(),txtHouseNumberE.getText(),txtCityE.getText()));
					employees.add(employee);
				} catch (NumberFormatException e) {
					Security.parseHandeling();
				}
				
				
				txtNameE.setText(null);
				txtAgeE.setText(null);
				txtCityE.setText(null);
				txtHouseNumberE.setText(null);
				txtStreetNameE.setText(null);
				txtSalary.setText(null);
			}
		});
		btnAddEmployee.setBounds(246, 282, 127, 61);
		panel_1.add(btnAddEmployee);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Add Student", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNameS = new JLabel("Name");
		lblNameS.setHorizontalAlignment(SwingConstants.CENTER);
		lblNameS.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNameS.setBounds(48, 39, 96, 29);
		panel_2.add(lblNameS);
		
		JLabel lblAgeS = new JLabel("Age");
		lblAgeS.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgeS.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAgeS.setBounds(326, 39, 96, 29);
		panel_2.add(lblAgeS);
		
		JLabel lblGrade = new JLabel("Grade");
		lblGrade.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGrade.setBounds(48, 130, 96, 29);
		panel_2.add(lblGrade);
		
		JLabel lblStreetNameS = new JLabel("Street name");
		lblStreetNameS.setHorizontalAlignment(SwingConstants.CENTER);
		lblStreetNameS.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStreetNameS.setBounds(48, 222, 96, 29);
		panel_2.add(lblStreetNameS);
		
		JLabel lblCityS = new JLabel("City");
		lblCityS.setHorizontalAlignment(SwingConstants.CENTER);
		lblCityS.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCityS.setBounds(326, 130, 96, 29);
		panel_2.add(lblCityS);
		
		JLabel lblHouseNumberS = new JLabel("House Number");
		lblHouseNumberS.setHorizontalAlignment(SwingConstants.CENTER);
		lblHouseNumberS.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHouseNumberS.setBounds(326, 222, 96, 29);
		panel_2.add(lblHouseNumberS);
		
		txtNameS = new JTextField();
		txtNameS.setColumns(10);
		txtNameS.setBounds(173, 43, 116, 22);
		panel_2.add(txtNameS);
		
		txtGrade = new JTextField();
		txtGrade.setColumns(10);
		txtGrade.setBounds(173, 134, 116, 22);
		panel_2.add(txtGrade);
		
		txtStreetNameS = new JTextField();
		txtStreetNameS.setColumns(10);
		txtStreetNameS.setBounds(173, 226, 116, 22);
		panel_2.add(txtStreetNameS);
		
		txtAgeS = new JTextField();
		txtAgeS.setColumns(10);
		txtAgeS.setBounds(439, 43, 116, 22);
		panel_2.add(txtAgeS);
		
		txtCityS = new JTextField();
		txtCityS.setColumns(10);
		txtCityS.setBounds(439, 134, 116, 22);
		panel_2.add(txtCityS);
		
		txtHouseNumberS = new JTextField();
		txtHouseNumberS.setColumns(10);
		txtHouseNumberS.setBounds(439, 226, 116, 22);
		panel_2.add(txtHouseNumberS);
		
		JButton btnAddStudent = new JButton("Add");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					Student student = new Student(txtNameS.getText(),Integer.parseInt(txtAgeS.getText()),Integer.parseInt(txtGrade.getText()));
					student.setAddress(new Address(txtStreetNameS.getText(),txtHouseNumberS.getText(),txtCityS.getText()));
					students.add(student);
					
				} catch (NumberFormatException e1) {
					Security.parseHandeling();
				}
				
				
				
				txtNameS.setText(null);
				txtAgeS.setText(null);
				txtCityS.setText(null);
				txtHouseNumberS.setText(null);
				txtStreetNameS.setText(null);
				txtGrade.setText(null);
			}
		});
		btnAddStudent.setBounds(243, 279, 127, 61);
		panel_2.add(btnAddStudent);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Reports", null, panel_3, null);
		panel_3.setLayout(null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(0, 0, 607, 386);
		panel_3.add(tabbedPane_1);
		
		JPanel panel_5 = new JPanel();
		tabbedPane_1.addTab("Salary Report", null, panel_5, null);
		panel_5.setLayout(null);
		
		txtSalaryReport = new JTextField();
		txtSalaryReport.setColumns(10);
		txtSalaryReport.setBounds(341, 79, 127, 22);
		panel_5.add(txtSalaryReport);
		
		JButton btnPrintSR = new JButton("Print Report");
		btnPrintSR.setBounds(341, 190, 127, 61);
		panel_5.add(btnPrintSR);
		
		JLabel lblSalaryReport = new JLabel("Salary Report");
		lblSalaryReport.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalaryReport.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSalaryReport.setBounds(127, 75, 127, 29);
		panel_5.add(lblSalaryReport);
		
		JButton btnSearchSR = new JButton("Search");
		btnSearchSR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int SalaryReport;
				File outFile = new File("Salaries Report.txt");
				PrintWriter printer = null;
				
				try {
					SalaryReport =Integer.parseInt(txtSalaryReport.getText());
					printer = new PrintWriter(outFile);
					
					for(Person e: employees) {
						if(((Employee)e).getSalary() >= SalaryReport) {
							printer.println(((Employee)e).toString());
						}
					
					}
				} catch (NumberFormatException e) {
					Security.parseHandeling();
				} catch (FileNotFoundException e) {
				}
				
				printer.flush();
				printer.close();
			}
		});
		btnSearchSR.setBounds(127, 190, 127, 61);
		panel_5.add(btnSearchSR);
		
		JPanel panel_6 = new JPanel();
		tabbedPane_1.addTab("Grade Report", null, panel_6, null);
		panel_6.setLayout(null);
		
		txtGradeReport = new JTextField();
		txtGradeReport.setColumns(10);
		txtGradeReport.setBounds(341, 80, 127, 22);
		panel_6.add(txtGradeReport);
		
		JButton btnSearchGR = new JButton("Search");
		btnSearchGR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				int GradeReport;
				File outFile = new File("Grades Report.txt");
				PrintWriter printer = null;
				
				try {
					GradeReport = Integer.parseInt(txtGradeReport.getText());
					printer = new PrintWriter(outFile);
					
					for(Person s: students) {
						if(((Student)s).getGrade() >= GradeReport) {
							printer.println(((Student)s).toString());
						}
					
					}
				} catch (NumberFormatException e) {
					Security.parseHandeling();
				} catch (FileNotFoundException e) {
				}
				
				printer.flush();
				printer.close();
				
				
			}
		});
		btnSearchGR.setBounds(127, 190, 127, 61);
		panel_6.add(btnSearchGR);
		
		JLabel lblGradeReport = new JLabel("Grade Report");
		lblGradeReport.setHorizontalAlignment(SwingConstants.CENTER);
		lblGradeReport.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGradeReport.setBounds(127, 76, 127, 29);
		panel_6.add(lblGradeReport);
		
		JButton btnPrintGR = new JButton("Print Report");
		btnPrintGR.setBounds(341, 190, 127, 61);
		panel_6.add(btnPrintGR);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Search", null, panel_4, null);
		panel_4.setLayout(null);
		
		final JCheckBox chckbxStudents = new JCheckBox("Students");
		chckbxStudents.setSelected(true);
		chckbxStudents.setBounds(57, 146, 113, 25);
		panel_4.add(chckbxStudents);
		
		final JCheckBox chckbxEmployees = new JCheckBox("Employees");
		chckbxEmployees.setSelected(true);
		chckbxEmployees.setBounds(57, 176, 113, 25);
		panel_4.add(chckbxEmployees);
		
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				matchesNum=0;
				if(chckbxStudents.isSelected() && !chckbxEmployees.isSelected()) {
					matches = Search.search(students, txtSearchName.getText());
					print(matches.get(matchesNum));
					matchesNum++;
					
				}else if(!chckbxStudents.isSelected() && chckbxEmployees.isSelected()) {
					matches = Search.search(employees, txtSearchName.getText());
					print(matches.get(matchesNum));	
					matchesNum++;
				}else {
					matches = Search.search(students, employees, txtSearchName.getText());
					print(matches.get(matchesNum));
					matchesNum++;
				}
			}
		});
		btnSearch.setBounds(43, 252, 127, 61);
		panel_4.add(btnSearch);
		
		JLabel lblNameSS = new JLabel("Name");
		lblNameSS.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNameSS.setBounds(44, 53, 83, 19);
		panel_4.add(lblNameSS);
		
		txtSearchName = new JTextField();
		txtSearchName.setBounds(43, 95, 127, 22);
		panel_4.add(txtSearchName);
		txtSearchName.setColumns(10);
		
		txtNameSS = new JTextField();
		txtNameSS.setHorizontalAlignment(SwingConstants.CENTER);
		txtNameSS.setText("Name");
		txtNameSS.setColumns(10);
		txtNameSS.setBounds(382, 52, 127, 22);
		panel_4.add(txtNameSS);
		
		txtAgeSS = new JTextField();
		txtAgeSS.setHorizontalAlignment(SwingConstants.CENTER);
		txtAgeSS.setText("Age");
		txtAgeSS.setColumns(10);
		txtAgeSS.setBounds(382, 95, 127, 22);
		panel_4.add(txtAgeSS);
		
		txtCitySS = new JTextField();
		txtCitySS.setHorizontalAlignment(SwingConstants.CENTER);
		txtCitySS.setText("City");
		txtCitySS.setColumns(10);
		txtCitySS.setBounds(382, 142, 127, 22);
		panel_4.add(txtCitySS);
		
		txtStreetNameSS = new JTextField();
		txtStreetNameSS.setHorizontalAlignment(SwingConstants.CENTER);
		txtStreetNameSS.setText("Street name");
		txtStreetNameSS.setColumns(10);
		txtStreetNameSS.setBounds(382, 187, 127, 22);
		panel_4.add(txtStreetNameSS);
		
		txtHouseNumberSS = new JTextField();
		txtHouseNumberSS.setHorizontalAlignment(SwingConstants.CENTER);
		txtHouseNumberSS.setText("House number");
		txtHouseNumberSS.setColumns(10);
		txtHouseNumberSS.setBounds(382, 225, 127, 22);
		panel_4.add(txtHouseNumberSS);
		
		txtGradeSS = new JTextField();
		txtGradeSS.setHorizontalAlignment(SwingConstants.CENTER);
		txtGradeSS.setText("Grade");
		txtGradeSS.setColumns(10);
		txtGradeSS.setBounds(382, 271, 127, 22);
		panel_4.add(txtGradeSS);
		
		txtSalarySS = new JTextField();
		txtSalarySS.setHorizontalAlignment(SwingConstants.CENTER);
		txtSalarySS.setText("Salary");
		txtSalarySS.setColumns(10);
		txtSalarySS.setBounds(382, 316, 127, 22);
		panel_4.add(txtSalarySS);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(matches.size()!= 0) {
					if(matchesNum == 0) {
						matchesNum = matches.size()-1;
					}else if(matchesNum == matches.size()){
						matchesNum=0;
					}
					print(matches.get(matchesNum));
					matchesNum++;
				}
				
			}
		});
		btnNext.setBounds(245, 118, 93, 46);
		panel_4.add(btnNext);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(matches.get(matchesNum-1) instanceof Student) {
					
					int i = Search.search(students, matches.get(matchesNum-1));
					Student student = new Student(txtNameSS.getText(),Integer.parseInt(txtAgeSS.getText()),Integer.parseInt(txtGradeSS.getText()));
					student.setAddress(new Address(txtStreetNameSS.getText(),txtHouseNumberSS.getText(),txtCitySS.getText()));
					students.set(i, student);
				}else {
					int i = Search.search(employees, matches.get(matchesNum-1));
					Employee employee = new Employee(txtNameSS.getText(),Integer.parseInt(txtAgeSS.getText()),Integer.parseInt(txtSalarySS.getText()));
					employee.setAddress(new Address(txtStreetNameSS.getText(),txtHouseNumberSS.getText(),txtCitySS.getText()));
					employees.set(i, employee);
				}
				
				
			}
		});
		btnSave.setBounds(245, 204, 93, 46);
		panel_4.add(btnSave);
		
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	
		    	frame = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Login Systems", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					
					PrintWriter printer = null;
					String jsonArray;
					
					try {
						
						printer = new PrintWriter(adminsFile);
						jsonArray = om.writeValueAsString(admins);
						printer.println(jsonArray);
						printer.flush();
						printer.close();
						
						printer = new PrintWriter(employeesFile);
						jsonArray = om.writeValueAsString(employees);
						printer.println(jsonArray);
						printer.flush();
						printer.close();
						
						printer = new PrintWriter(studentsFile);
						jsonArray = om.writeValueAsString(students);
						printer.println(jsonArray);
						printer.flush();
						printer.close();
						
					} catch (FileNotFoundException e) {
					} catch (JsonProcessingException e) {
					}
					printer.flush();
					printer.close();
					System.exit(0);
				}
				
		    }
		});
	}
	
	public static void print(Person p) {
		if(p instanceof Student) {
			Student s = (Student) p;
			txtNameSS.setText(s.getName());
			txtAgeSS.setText(s.getAge()+"");
			txtCitySS.setText(s.getAddress().getCity());
			txtHouseNumberSS.setText(s.getAddress().getHouseNumber());
			txtStreetNameSS.setText(s.getAddress().getStreetName());
			txtGradeSS.setText(s.getGrade()+"");
			txtSalarySS.setText("unknown");
		}else {
			Employee e = (Employee) p;
			txtNameSS.setText(e.getName());
			txtAgeSS.setText(e.getAge()+"");
			txtCitySS.setText(e.getAddress().getCity());
			txtHouseNumberSS.setText(e.getAddress().getHouseNumber());
			txtStreetNameSS.setText(e.getAddress().getStreetName());
			txtGradeSS.setText("unknown");
			txtSalarySS.setText(e.getSalary()+"");
		}
		
		
		
	}
	
}
