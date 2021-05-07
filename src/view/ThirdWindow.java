package view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class ThirdWindow extends JFrame {
	private JPanel buttons = new JPanel(new GridLayout(1, 5, 15, 0));
	private JPanel upperPanel = new JPanel();
	private JPanel lowerPanel = new JPanel();
	private JTextArea choosePlayer1;
	private JLabel j;

	public ThirdWindow() {
//		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//		setSize(new Dimension(screenSize.width, screenSize.height));
//		setExtendedState(Frame.MAXIMIZED_BOTH);
		setBounds(70,40, 1300,731);
		setVisible(false);
		setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Hearthstone");

		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("images/BackgroundForChooseHero2.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image dimg = img.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(dimg);
		j = new JLabel(imageIcon);
		setContentPane(j);
		j.setLayout(new BorderLayout());
		// ----Buttons Panel-----//
		buttons.setPreferredSize(new Dimension(1350, 430));;
		buttons.setOpaque(false);
		buttons.setBackground(Color.BLACK);
		buttons.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		// ----Buttons Panel-----//

		// ----upperPanel Panel-----//
		upperPanel.setPreferredSize(new Dimension(1350, 150));
		upperPanel.setOpaque(false);
		upperPanel.setBackground(Color.GREEN);
		// ----upperPanel Panel-----//

		// ----lowerPanel Panel-----//
		lowerPanel.setLayout(new GridLayout(1, 5, 15, 0));
		lowerPanel.setPreferredSize(new Dimension(1350, 150));
		lowerPanel.setOpaque(false);
		lowerPanel.setBackground(Color.CYAN);
		// ----lowerPanel Panel-----//


		// ----Choosing First Player----//
		choosePlayer1 = new JTextArea("Choose The Second Hero");
		choosePlayer1.setFont(new Font("AR BONNIE", Font.ITALIC, 70));
		choosePlayer1.setForeground(Color.WHITE);
		choosePlayer1.setBackground(Color.DARK_GRAY);
		choosePlayer1.setOpaque(false);
		choosePlayer1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		choosePlayer1.setEditable(false);
		upperPanel.add(choosePlayer1, BorderLayout.CENTER);
		// ----Choosing First Player----//



		j.add(buttons, BorderLayout.CENTER);
		j.add(upperPanel, BorderLayout.NORTH);
		j.add(lowerPanel, BorderLayout.SOUTH);
//		add(image,BorderLayout.NORTH);

		this.revalidate();
		this.repaint();
	}

	public JPanel getButtons() {
		return buttons;
	}

//	public void actionPerformed(ActionEvent e) {
//		if (e.getSource().equals(mage) || e.getSource().equals(hunter) || e.getSource().equals(paladin)
//				|| e.getSource().equals(priest) || e.getSource().equals(warlock)) {
//			new ThirdWindow();
//			this.dispose();
//		}
//	}

	public JPanel getUpperPanel() {
		return upperPanel;
	}

	public JPanel getLowerPanel() {
		return lowerPanel;
	}

	public JTextArea getChoosePlayer1() {
		return choosePlayer1;
	}

	public JLabel getJ() {
		return j;
	}

	public static void main(String[] args) {
		new ThirdWindow();

	}

}
