package com.myworldcreations.testengine.user.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.myworldcreations.testengine.user.dto.RightDTO;
import com.myworldcreations.testengine.user.dto.UserDTO;

public class DashBoardView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashBoardView frame = new DashBoardView();
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
	
	public void fillDashBoard(UserDTO userDTO){
		if(userDTO!=null){
		userIdlbl.setText("Welcome"+userDTO.getUserid()+"" +userDTO.getRoleName());
		if(userDTO.getRights()!=null){
			for(RightDTO right : userDTO.getRights()){
				JMenuItem menuItem = new JMenuItem(right.getName());
				menuItem.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						System.out.println("Screen Name "+right.getScreenName());
						try{
							int lastIndex = right.getScreenName().lastIndexOf(".java");
							System.out.println("Last Index "+lastIndex);
						String className = right.getScreenName().substring(0,lastIndex);
						System.out.println("ClassNAme "+className);
						Object object = Class.forName(className).newInstance();
						Method method = object.getClass().getMethod("setVisible", boolean.class);
						
						method.invoke(object, true);
						}
						catch(Exception e1){
							System.out.println("Reflection Problem "+e1);
							e1.printStackTrace();
						}
						}
				});
				file.add(menuItem);
			}
		}
		}
	}
	
                  JMenu file = new JMenu("File");
                  JLabel userIdlbl = new JLabel("");


	public DashBoardView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		menuBar.add(file);
		
		userIdlbl.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		userIdlbl.setBounds(17, 56, 334, 51);
		contentPane.add(userIdlbl);
	}
}
	
