package com.myworldcreations.testengine.question.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.myworldcreations.testengine.question.helper.QuestionUploadHelper;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class QuestionUploadView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuestionUploadView frame = new QuestionUploadView();
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
	
	
	public void UploadIt(){
   JFileChooser jfileChooser = new JFileChooser("Documents");
   jfileChooser.showOpenDialog(this);
   File file = jfileChooser.getSelectedFile();
   System.out.println("Path is"+file.getAbsolutePath());
   QuestionUploadHelper helper = new QuestionUploadHelper();
   
   try{
   boolean isUploaded = helper.read(file.getAbsolutePath());
   JOptionPane.showMessageDialog(this, isUploaded?"Uploaded Done":"NotUploaded");
   }
   catch (IOException e){
	   JOptionPane.showMessageDialog(this,"Can't Upload the File, Contact System Admin");
        e.printStackTrace();
   }
   
   
	}
	public QuestionUploadView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton UpLoad = new JButton("Upload");
		UpLoad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UploadIt();
			}
		});
		UpLoad.setFont(new Font("Tahoma", Font.BOLD, 16));
		UpLoad.setBounds(0, 0, 434, 40);
		contentPane.add(UpLoad);
	}
}
