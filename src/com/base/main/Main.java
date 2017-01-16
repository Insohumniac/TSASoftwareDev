package com.base.main;

import com.base.flashcard.Flashcard;

import java.awt.*;
import java.io.File;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField answerField;

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
        //Base flashcard to make testing and moving between cards easier
        String[] blankTags = {"example", "test", "blank"};
        Flashcard blank = new Flashcard("Flashcard question is located here", "This is where the answer is typed", blankTags);
        int currentCardVal = blank.index;

        //Maybe separate file management class if we want to start doing more
        String filePath = JOptionPane.showInputDialog(null, "Choose default directory for flashcard storage",
                System.getProperty("user.home") + "\\Documents");

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
		
		JTextPane questionPane = new JTextPane();
		questionPane.setBounds(10, 60, 461, 221);
		panel.add(questionPane);
        questionPane.setText("\nThe value of currentCardVal is: " + currentCardVal + "\nThe question for the card is: " +
        Flashcard.cardList.get(currentCardVal).question);
		
		answerField = new JTextField();
		answerField.setBounds(10, 321, 461, 20);
		panel.add(answerField);
		answerField.setColumns(10);

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
		
		JButton btnNextCard = new JButton("Next Flashcard");
		btnNextCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Sloppy workaround
               questionPane.setText(Flashcard.cardList.get(currentCardVal).nextCard().question);

            }
        });
		btnNextCard.setBounds(130, 359, 110, 23);
		panel.add(btnNextCard);

		JButton btnAddTags = new JButton("Add tags");
		//On action pops up a JOptionPane that prompts the user to input their tags
        btnAddTags.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Flashcard.cardList.get(currentCardVal).tags = (JOptionPane.showInputDialog("Type in comma separated tags for the current notecard. " +
						"e.g. science, biology, cell function, active transport").split(", "));


			}
		});
		btnAddTags.setBounds(250, 359, 110, 23);
		panel.add(btnAddTags);

		JButton btnEditTags = new JButton("Edit tags");
        btnEditTags.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder sb = new StringBuilder(Arrays.toString(Flashcard.cardList.get(currentCardVal).tags));
                sb.deleteCharAt(0);
                sb.deleteCharAt(sb.length()-1);
                String noBrackets = sb.toString();

                Flashcard.cardList.get(currentCardVal).tags = (JOptionPane.showInputDialog("Edit the current set of tags with the removal or adding of " +
                        "new tags in the same format", noBrackets).split(", "));
            }
        });
		btnEditTags.setBounds(370, 359, 110, 23);
		panel.add(btnEditTags);
		
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
		
		JButton btnOpenFolder = new JButton("Open Folder");
		btnOpenFolder.setBounds(481, 94, 110, 23);
        btnOpenFolder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Desktop.getDesktop().open(new File(filePath));
                }catch(Exception exc){
                    JOptionPane.showMessageDialog(null, exc.getMessage());
                }
            }
        });
		panel.add(btnOpenFolder);
	}
}
