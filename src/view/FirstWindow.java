package view;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class FirstWindow extends JFrame implements ActionListener {
	private JButton b;
	private JLabel j;

	public FirstWindow() {
		super();
		setBounds(40,0, 1300,731);
		setVisible(true);
		setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Hearthstone");
		setLayout(new BorderLayout());
		BufferedImage img = null;
		
		try {
		    img = ImageIO.read(new File("images/LoadingScreen.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Image dimg = img.getScaledInstance(getWidth(), getHeight(),Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(dimg);
		j = new JLabel(imageIcon);

		j.setLayout(new FlowLayout(FlowLayout.LEFT, 430,525));
		add(j);
		this.revalidate();
		this.repaint();

	}



	public JLabel getJ() {
		return j;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(b)) {
			new SecondWindow();
			this.dispose();
		}
	}

	public static void main(String[] args) {
		new FirstWindow();
	}

}
