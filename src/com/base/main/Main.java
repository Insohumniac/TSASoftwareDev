package com.base.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 596, 446);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 60, 461, 221);
		panel.add(textPane);
		
		textField = new JTextField();
		textField.setBounds(10, 321, 461, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblFlashcard = new JLabel("Flashcard");
		lblFlashcard.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblFlashcard.setBounds(10, 34, 82, 14);
		panel.add(lblFlashcard);
		
		JLabel lblNewLabel = new JLabel("Answer:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 296, 110, 14);
		panel.add(lblNewLabel);
		
		JButton btnOpenFile = new JButton("Open File");
		btnOpenFile.setBounds(481, 60, 110, 23);
		panel.add(btnOpenFile);
		
		JButton btnEditFlashcard = new JButton("Edit Flashcard");
		btnEditFlashcard.setBounds(10, 359, 110, 23);
		panel.add(btnEditFlashcard);
		
		JButton btnNewButton = new JButton("Next Flashcard");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(130, 359, 110, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add tags");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(250, 359, 110, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Edit tags");
		btnNewButton_2.setBounds(370, 359, 110, 23);
		panel.add(btnNewButton_2);
		
		JSlider slider = new JSlider();
		slider.setBounds(10, 410, 461, 26);
		panel.add(slider);
		
		JLabel lblNewLabel_1 = new JLabel("Rating (lowest is 0, highest is 10)");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(39, 385, 160, 14);
		panel.add(lblNewLabel_1);
		
		JLabel label = new JLabel("10");
		label.setBounds(459, 399, 12, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("0");
		label_1.setBounds(10, 399, 12, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("5");
		label_2.setBounds(235, 399, 12, 14);
		panel.add(label_2);
		
		JButton btnNewButton_3 = new JButton("Open Folder");
		btnNewButton_3.setBounds(481, 94, 110, 23);
		panel.add(btnNewButton_3);
	}
}
