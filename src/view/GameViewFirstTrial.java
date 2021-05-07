package view;

import javax.swing.*;
import java.awt.*;

public class GameViewFirstTrial extends JFrame {
	private JPanel player1;
	private JPanel player2;
	private JTextArea text;
	private GridBagConstraints gbc = new GridBagConstraints();
	public GameViewFirstTrial() {
		super();
		this.setSize(800, 600);
		gbc.insets = new Insets(20, 20, 10, 20);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		player1 = new JPanel();
		player2 = new JPanel();
		player1.setPreferredSize(new Dimension(800,this.getHeight()/2));
		player1.setLayout(new GridBagLayout());
		player2.setPreferredSize(new Dimension(800,this.getHeight()/2));
		player2.setLayout(new GridBagLayout());
		this.add(player1, BorderLayout.NORTH);
		this.add(player2, BorderLayout.SOUTH);
		JButton button1 = new JButton("Player1");
		//--------------CreatingButtons------------//
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 2;
		gbc.fill = GridBagConstraints.VERTICAL;
		player1.add(button1, gbc);
		JButton button6 = new JButton("Player1");
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		player1.add(button6, gbc);
		JButton button7 = new JButton("Player1");
		gbc.gridx = 2;
		gbc.gridy = 0;
		player1.add(button7, gbc);
		JButton button8 = new JButton("Player1");
		gbc.gridx = 3;
		gbc.gridy = 0;
		player1.add(button8, gbc);
		JButton button2 = new JButton("Player2");
		gbc.gridx = 1;
		gbc.gridy = 1;
		player1.add(button2, gbc);
		gbc.gridx = 2;
		gbc.gridy = 2;
		JButton button3 = new JButton("Player3");
		player1.add(button3, gbc);
		JButton button4 = new JButton("Player4");
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		player1.add(button4,gbc);
		JButton button01 = new JButton("Player1");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 2;
		gbc.fill = GridBagConstraints.VERTICAL;
		player2.add(button01, gbc);
		JButton button06 = new JButton("Player1");
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		player2.add(button06, gbc);
		JButton button07 = new JButton("Player1");
		gbc.gridx = 2;
		gbc.gridy = 0;
		player2.add(button07, gbc);
		JButton button08 = new JButton("Player1");
		gbc.gridx = 3;
		gbc.gridy = 0;
		player2.add(button08, gbc);
		JButton button02 = new JButton("Player2");
		gbc.gridx = 1;
		gbc.gridy = 1;
		player2.add(button02, gbc);
		gbc.gridx = 2;
		gbc.gridy = 2;
		JButton button03 = new JButton("Player3");
		player2.add(button03, gbc);
		JButton button04 = new JButton("Player4");
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		player2.add(button04,gbc);
		//-----End of CreatingButtons----//
		//-----Creating JTextArea-------//
		text = new JTextArea("HP:------");
		gbc.gridx = 3;
		gbc.gridy = 2;
		gbc.gridheight = 2;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.VERTICAL;
		text.setEditable(false);
		player1.add(text, gbc);
		this.revalidate();
		this.repaint();
		
		
	}
	public static void main(String[] args) {
		new GameViewFirstTrial();
	}
	

}
