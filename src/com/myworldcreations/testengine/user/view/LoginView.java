 package com.myworldcreations.testengine.user.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.myworldcreations.testengine.user.dao.UserDAO;
import com.myworldcreations.testengine.user.dto.UserDTO;
import com.myworldcreations.testengine.utils.constants.PathConstants;

public class LoginView extends JFrame implements PathConstants {



	private JPanel userid;
	private JTextField usertxt;
	private JPasswordField passwordtxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
			}
			}
		});
	}
	

	/**
	 * Create the frame.
	 */
	
	
	public void register() {
                 String userid = usertxt.getText();
				String Password = new String(passwordtxt.getPassword());
		UserDTO userDTO = new UserDTO();
		userDTO.setUserid(userid); 
		userDTO.setPassword(Password);
		UserDAO userDAO = new UserDAO();
		try {
			String message = userDAO.doRegister(userDTO);
			JOptionPane.showMessageDialog(this, message);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "Can't Register Some DB  Problem Occuer");
		//	logger.error(convertPrintStackIntoString(e));
			//e.printStackTrace();
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "Can't Register Some DB  Problem Occuer");
			// TODO Auto-generated catch block
		//	logger.error(convertPrintStackIntoString(e));
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(this, "Can't Register Some Other  Problem Occuer");
		//	logger.error(convertPrintStackIntoString(e));
		}
	}
	
		
		
		
	
	
	
	public void checkLogin() throws ClassNotFoundException{
		String userid = usertxt.getText();
	    String password= new String(passwordtxt.getPassword());
	   // Logger.debug("Inside Check Login with"+ userid);
	    UserDAO loginDAO = new UserDAO();
		try{
			// throw new SQLException()
			//Logger.debug("Inside Check Login ANd Calling LoginDAO "+userid);
		String message = loginDAO.doLogin(userid, password);
		//Logger.debug("Inside Check Login and After LoginDAO Message is  "+message);
		JOptionPane.showMessageDialog(this, message);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	//	catch(ClassNotFoundException e){
			//String message = CommonUtils.convertPrintStackIntoString(e);
			//logger.error("Inside Catch "+message);
			//Logger.error(convertPrintStackIntoString(e));
			//JOptionPane.showMessageDialog(this, "Contact to System Admin Some DB Problem Occur...");
			//e.printStackTrace();
		}
		//catch(ClassNotFoundException e){
			//logger.error("Inside Catch "+e);
		//	JOptionPane.showMessageDialog(this, "Some Serious Problem Occur Contact to Admin Team");
			//e.printStackTrace();
			//Logger.error(convertPrintStackIntoString(e));
		
	

	    
	   
	    
	private Object convertPrintStackIntoString(ClassNotFoundException e) {
		// TODO Auto-generated method stub
		return null;
	}




	
	public LoginView() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		userid = new JPanel();
		userid.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(userid);
		userid.setLayout(null);
		
		JLabel lblTestEngine = new JLabel("Test Engine");
		lblTestEngine.setHorizontalAlignment(SwingConstants.CENTER);
		lblTestEngine.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTestEngine.setBounds(168, 11, 107, 27);
		userid.add(lblTestEngine);
		
		JLabel Userid = new JLabel("User id");
		Userid.setFont(new Font("Tahoma", Font.BOLD, 13));
		Userid.setHorizontalAlignment(SwingConstants.CENTER);
		Userid.setBounds(33, 62, 87, 27);
		userid.add(Userid);
		
		JLabel Password = new JLabel("Password");
		Password.setHorizontalAlignment(SwingConstants.CENTER);
		Password.setFont(new Font("Tahoma", Font.BOLD, 13));
		Password.setBounds(33, 115, 87, 27);
		userid.add(Password);
		
		usertxt = new JTextField();
		usertxt.setBounds(152, 66, 166, 23);
		userid.add(usertxt);
		usertxt.setColumns(10);
		
		passwordtxt = new JPasswordField();
		passwordtxt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		passwordtxt.setHorizontalAlignment(SwingConstants.LEADING);
		passwordtxt.setBounds(152, 119, 166, 20);
		userid.add(passwordtxt);
		
		JButton loginbtn = new JButton("Login");
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					checkLogin();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		loginbtn.setIcon(new ImageIcon(LoginView.class.getResource(LOGIN_ICON)));
		loginbtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		loginbtn.setBounds(49, 188, 123, 39);
		userid.add(loginbtn);
		
		JButton Register = new JButton("Register");
		Register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 register();
			 }
		});
		
		Register.setFont(new Font("Tahoma", Font.BOLD, 14));
		Register.setBounds(244, 188, 116, 39);
		userid.add(Register);
	
		
	}
}
