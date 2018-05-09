package runners;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import javax.swing.SwingConstants;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import domain.Administrator;
import domain.Security;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class LoginSystem {

	private JFrame frame;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginSystem window = new LoginSystem();
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
	public LoginSystem() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		
		
		frame = new JFrame();
		frame.setBounds(200, 200, 448, 282);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUserName = new JLabel("Username");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserName.setBounds(59, 58, 73, 20);
		frame.getContentPane().add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(59, 109, 73, 20);
		frame.getContentPane().add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(188, 58, 162, 20);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(188, 109, 162, 20);
		frame.getContentPane().add(txtPassword);
		
		
		
		JButton btnLogin = new JButton("Sign in ");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String password = txtPassword.getText();
				String username = txtUsername.getText();
				
				File adminsFile = new File("Admins.txt");
				ArrayList<Administrator> admins = null;
				ObjectMapper om = new ObjectMapper();
				Scanner input = null;
				
				
				if(adminsFile.exists()) {
					try {
						input = new Scanner(adminsFile);
					} catch (FileNotFoundException e4) {
						e4.printStackTrace();
					}
					if(input.hasNextLine()) {
						try {
							admins = om.readValue(input.nextLine(), new TypeReference<ArrayList<Administrator>>() {});
						} catch (JsonParseException e1) {
							e1.printStackTrace();
						} catch (JsonMappingException e2) {
							e2.printStackTrace();
						} catch (IOException e3) {
							e3.printStackTrace();
						}
						
						if(admins != null) {
							for(Administrator admin: admins) {
								if(Security.decrypt(admin.getUserName()).equals(username) && Security.decrypt(admin.getPassword()).equals(password)) {
									
									try {
										MainScreen.main(null);
									} catch (FileNotFoundException e1) {
									}
								}
							}
						}
					} else {
						if("admin".equals(username) && "admin".equals(password)) {
							
							try {
								MainScreen.main(null);
							} catch (FileNotFoundException e1) {
							}
						}
					}
					
					
				} else {
					if("admin".equals(username) && "admin".equals(password)) {
						
							try {
								MainScreen.main(null);
							} catch (FileNotFoundException e1) {
							}
						
					}
				}
				
				
				txtPassword.setText(null);
				txtUsername.setText(null);
			}		
		});
		
		btnLogin.setBounds(154, 161, 106, 45);
		frame.getContentPane().add(btnLogin);
		
		
		
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	
		    	frame = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Login Systems", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
				System.exit(0);
				}
				
		    }
		});
		
		
		
	}
}
