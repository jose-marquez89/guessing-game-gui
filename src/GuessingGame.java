import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// TODO Add error handling
// TODO Remove old guesses

public class GuessingGame extends JFrame {
	private JTextField playerGuessField;
	private JLabel labelOutput;
	private int theNumber;
	
	public void checkGuess() {
		// TODO something is wrong with this flow
		String guessText = playerGuessField.getText();
		String message = "";
		int guess = Integer.parseInt(guessText);
		
		if (guess < theNumber)
			message = guess + " is too low. Try again."; 
		else if (guess > theNumber)
			message = guess + " is too high. Try again.";
		else
			message = guess + " is correct. You won this round, let's play again!";
			newGame();
		labelOutput.setText(message);
	}
	
	public void newGame() {
		theNumber = (int)(Math.random() * 22 - 11);
	}

	public GuessingGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("A Very Very Guessing Game");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("A Fun Game...We Promise");
		lblNewLabel.setFont(new Font("Apple Chancery", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(132, 40, 170, 16);
		getContentPane().add(lblNewLabel);
		
		JLabel promptLabel = new JLabel("Guess a number between -10 and 10:");
		promptLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		promptLabel.setBounds(6, 96, 259, 16);
		getContentPane().add(promptLabel);
		
		playerGuessField = new JTextField();
		playerGuessField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		playerGuessField.setBounds(277, 91, 130, 26);
		getContentPane().add(playerGuessField);
		playerGuessField.setColumns(10);
		
		JButton btnNewButton = new JButton("Guess!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnNewButton.setBounds(166, 152, 117, 29);
		getContentPane().add(btnNewButton);
		
		labelOutput = new JLabel("Enter a number and then click the button to guess");
		labelOutput.setHorizontalAlignment(SwingConstants.CENTER);
		labelOutput.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		labelOutput.setBounds(111, 221, 249, 16);
		getContentPane().add(labelOutput);
	}
	public static void main(String[] args) {
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(450, 400));
		theGame.setVisible(true);

	}
}
