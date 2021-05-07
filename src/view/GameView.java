package view;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class GameView extends JFrame implements ActionListener {
	private JLabel battlefieldBackground;
	private JPanel middle = new JPanel(); // FlowLayout
	private JPanel topHalf = new JPanel(); // BorderLayout
	private JPanel bottomHalf = new JPanel(); // BorderLayout
	private JPanel bottomTopHalf = new JPanel(); // BorderLayout
	private JPanel handCards = new JPanel(new GridLayout(1, 10, 3, 0)); // GridLayout
	private JPanel leftHandSide = new JPanel(); // FlowLayout
	private JPanel rightHandSide = new JPanel(); // BorderLayout
	private JPanel topRightHandSide = new JPanel(); // FlowLayout
	private JPanel bottomRightHandSide = new JPanel(); // FlowLayout
	private JPanel topTopHalf = new JPanel(); // BorderLayout
	private JPanel eastTopTopHalf = new JPanel(); // FlowLayout	
	private JPanel westTopTopHalf = new JPanel(); // FlowLayout	
	private JPanel middleTopTopHalf = new JPanel(); // FlowLayout	
	private JPanel topBottomHalf = new JPanel(new GridLayout(1, 9, 8, 0)); // GridLayout
	private JPanel middleBottomHalf = new JPanel(); // BorderLayout
	private JPanel westMiddleBottomHalf = new JPanel(); // FlowLayout
	private JPanel middleMiddleBottomHalf = new JPanel(); // FlowLayout
	private JPanel eastMiddleBottomHalf = new JPanel(); // FlowLayout
	private JPanel middleTopHalf = new JPanel(); // FlowLayout
	private JPanel topMiddleTopHalf = new JPanel(); // FlowLayout
	private JPanel bottomMiddleTopHalf = new JPanel(new GridLayout(1,9,8,0)); // GridLayout
	
	public GameView() {
//		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//setSize(new Dimension(screenSize.width, screenSize.height));
		setBounds(80,0, 1300,731);
		//setExtendedState(FirstWindow.MAXIMIZED_BOTH);
		setVisible(false);
		setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//		this.getContentPane().setBackground(Color.DARK_GRAY);
		this.setTitle("Hearthstone");
		setLayout(new BorderLayout());
//		battlefieldBackground = new JLabel(new ImageIcon("images/gameAfterRemovingNumbers.png"));
//		battlefieldBackground.setLayout(new BorderLayout());
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("images/gameAfterRemovingNumbersAfterCrop.PNG"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Image dimg = img.getScaledInstance(getWidth(), getHeight(),Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(dimg);
		battlefieldBackground = new JLabel(imageIcon);

		battlefieldBackground.setLayout(new BorderLayout());
		this.setContentPane(battlefieldBackground);
		
		// -------Start of Adusting Panels-------//

		middle.setPreferredSize(new Dimension(925,731));
		middle.setBackground(Color.DARK_GRAY);
		middle.setOpaque(false);
		add(middle, BorderLayout.CENTER);

		topHalf.setPreferredSize(new Dimension(925, 345));
		topHalf.setBackground(Color.RED);
		topHalf.setOpaque(false);
		middle.add(topHalf, BorderLayout.NORTH);

		bottomHalf.setLayout(new BorderLayout());
		bottomHalf.setPreferredSize(new Dimension(925,375));
		bottomHalf.setBackground(Color.WHITE);
		bottomHalf.setOpaque(false);
		middle.add(bottomHalf, BorderLayout.SOUTH);

		leftHandSide.setPreferredSize(new Dimension(200, 731));
		leftHandSide.setOpaque(false);
		leftHandSide.setBackground(Color.ORANGE);
		leftHandSide.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 310));
		add(leftHandSide, BorderLayout.WEST);

		rightHandSide.setPreferredSize(new Dimension(175, 731));
		rightHandSide.setOpaque(false);
		rightHandSide.setBackground(Color.CYAN);
		add(rightHandSide, BorderLayout.EAST);
		rightHandSide.setLayout(new BorderLayout());
		
		topRightHandSide.setPreferredSize(new Dimension(175,345));
		topRightHandSide.setOpaque(false);
		topRightHandSide.setLayout(new FlowLayout(FlowLayout.LEFT, 2, 200));
		topRightHandSide.setBackground(Color.BLUE);
		rightHandSide.add(topRightHandSide, BorderLayout.NORTH);
		
		bottomRightHandSide.setPreferredSize(new Dimension(175,365));
		bottomRightHandSide.setOpaque(false);
		bottomRightHandSide.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 57));
		bottomRightHandSide.setBackground(Color.ORANGE);
		rightHandSide.add(bottomRightHandSide, BorderLayout.SOUTH);		

		handCards.setPreferredSize(new Dimension(925, 130));
		handCards.setBackground(Color.YELLOW);
		handCards.setOpaque(false);
		bottomHalf.add(handCards, BorderLayout.SOUTH);

		topHalf.setLayout(new BorderLayout());
		
		
		topTopHalf.setPreferredSize(new Dimension(925, 55));
		topTopHalf.setBackground(Color.PINK);
		topTopHalf.setOpaque(false);
		topHalf.add(topTopHalf, BorderLayout.NORTH);
		topTopHalf.setLayout(new BorderLayout());
		
		westTopTopHalf.setPreferredSize(new Dimension(300,50));
		westTopTopHalf.setBackground(Color.WHITE);
		westTopTopHalf.setOpaque(false);
		westTopTopHalf.setLayout(new FlowLayout(FlowLayout.LEFT, 263, 21));
		topTopHalf.add(westTopTopHalf, BorderLayout.WEST);
		
		eastTopTopHalf.setPreferredSize(new Dimension(335, 50));
		eastTopTopHalf.setBackground(Color.BLACK);
		eastTopTopHalf.setOpaque(false);
		eastTopTopHalf.setLayout(new FlowLayout(FlowLayout.LEFT, 31, 24));
		topTopHalf.add(eastTopTopHalf, BorderLayout.EAST);
		
		middleTopTopHalf.setPreferredSize(new Dimension(290, 50));
		middleTopTopHalf.setBackground(Color.CYAN);
		middleTopTopHalf.setOpaque(false);
		middleTopTopHalf.setLayout(new FlowLayout(FlowLayout.LEFT, 144, 9));
		topTopHalf.add(middleTopTopHalf, BorderLayout.CENTER);
		
		topBottomHalf.setPreferredSize(new Dimension(925, 110));
		topBottomHalf.setBackground(Color.CYAN);
		topBottomHalf.setOpaque(false);
		bottomHalf.add(topBottomHalf, BorderLayout.NORTH);
		
		middleBottomHalf.setPreferredSize(new Dimension(925,140));
		middleBottomHalf.setBackground(Color.GREEN);
		middleBottomHalf.setLayout(new BorderLayout());
		middleBottomHalf.setOpaque(false);
		bottomHalf.add(middleBottomHalf, BorderLayout.CENTER);
		
		westMiddleBottomHalf.setPreferredSize(new Dimension(297,140));
		westMiddleBottomHalf.setBackground(Color.RED);
		westMiddleBottomHalf.setOpaque(false);
		middleBottomHalf.add(westMiddleBottomHalf, BorderLayout.WEST);
		
		
		middleMiddleBottomHalf.setPreferredSize(new Dimension(100,140));
		middleMiddleBottomHalf.setBackground(Color.CYAN);
		middleMiddleBottomHalf.setOpaque(false);
		middleBottomHalf.add(middleMiddleBottomHalf,BorderLayout.CENTER);
		
		eastMiddleBottomHalf.setPreferredSize(new Dimension(340, 140));
		eastMiddleBottomHalf.setBackground(Color.WHITE);
		eastMiddleBottomHalf.setOpaque(false);
		middleBottomHalf.add(eastMiddleBottomHalf,BorderLayout.EAST);
		
		
		westMiddleBottomHalf.setLayout(new FlowLayout(FlowLayout.RIGHT, 26, 38));
		eastMiddleBottomHalf.setLayout(new FlowLayout(FlowLayout.LEFT, 34, 38));
		
		
		middleTopHalf.setPreferredSize(new Dimension(925, 215));
		middleTopHalf.setBackground(Color.BLACK);
		middleTopHalf.setOpaque(false);
		topHalf.add(middleTopHalf, BorderLayout.CENTER);
		

		
		bottomTopHalf.setPreferredSize(new Dimension(925,50));
		bottomTopHalf.setBackground(Color.MAGENTA);
		bottomTopHalf.setOpaque(false);
		topHalf.add(bottomTopHalf, BorderLayout.SOUTH);
		bottomTopHalf.setLayout(new BorderLayout());
		
		middleTopHalf.setLayout(new BorderLayout());
		topMiddleTopHalf.setPreferredSize(new Dimension(925, 129));
		topMiddleTopHalf.setBackground(Color.WHITE);
		topMiddleTopHalf.setOpaque(false);
		middleTopHalf.add(topMiddleTopHalf, BorderLayout.NORTH);
		
		bottomMiddleTopHalf.setPreferredSize(new Dimension(925,105));
		bottomMiddleTopHalf.setBackground(Color.CYAN);
		bottomMiddleTopHalf.setOpaque(false);
		middleTopHalf.add(bottomMiddleTopHalf, BorderLayout.SOUTH);
		
		
		topMiddleTopHalf.setLayout(new FlowLayout(FlowLayout.LEFT, 380, 0));
		middleMiddleBottomHalf.setLayout(new FlowLayout(FlowLayout.LEFT, 83, 13));
		
		
		
//		JButton gully = new JButton();
//		gully.setContentAreaFilled(false);
//		gully.setBorderPainted(false);
//		gully.setFocusable(false);
//		gully.setIcon(new ImageIcon("Images/Gul'dan after 2.png"));
//		gully.setPreferredSize(new Dimension((int)(screenSize.width/9), (int)(screenSize.height/6)));
//		
//		
//		gully.setLayout(new FlowLayout(FlowLayout.LEFT, 98,76));
//		JTextArea hp1 = new JTextArea("22");
//		hp1.setFont(new Font("Arial",Font.BOLD,15));
//		hp1.setForeground(Color.WHITE);
//		hp1.setFocusable(false);
//		hp1.setEditable(false);
//		hp1.setOpaque(false);
//		gully.add(hp1);
//		middleMiddleBottomHalf.add(gully);
//		
//		topMiddleTopHalf.add(gully);
		

//		JButton andy = new JButton();
//		andy.setContentAreaFilled(false);
//		andy.setBorderPainted(false);
//		andy.setFocusable(false);
//		andy.setIcon(new ImageIcon("Images/Anduin Wrynn after 2.png"));
//		andy.setPreferredSize(new Dimension((int)(screenSize.width/9), (int)(screenSize.height/6)));
//		
//		andy.setLayout(new FlowLayout(FlowLayout.LEFT, 98,76));
//		JTextArea hp = new JTextArea("22");
//		hp.setFont(new Font("Arial",Font.BOLD,15));
//		hp.setForeground(Color.WHITE);
//		hp.setFocusable(false);
//		hp.setEditable(false);
//		hp.setOpaque(false);
//		andy.add(hp);
//		middleMiddleBottomHalf.add(andy);
		
		
		
//		int i = 0;
//		
//		JTextArea y = new JTextArea("");
//		y.setEditable(false);
//		y.setOpaque(false);
//		y.setFocusable(false);
//		bottomMiddleTopHalf.add(y);
//		
//		JButton a = new JButton(""+i);
//		i++;
//		bottomMiddleTopHalf.add(a);
//		
//		JButton b = new JButton(""+i);
//		i++;
//		bottomMiddleTopHalf.add(b);
//		
//		JButton c = new JButton(""+i);
//		i++;
//		bottomMiddleTopHalf.add(c);
//		
//		JButton d = new JButton(""+i);
//		i++;
//		bottomMiddleTopHalf.add(d);
//		
//		JButton e = new JButton(""+i);
//		i++;
//		bottomMiddleTopHalf.add(e);
//		
//		JButton f = new JButton(""+i);
//		i++;
//		bottomMiddleTopHalf.add(f);
//		
//		JButton g = new JButton(""+i);
//		i++;
//		bottomMiddleTopHalf.add(g);
//		
//		JTextArea h = new JTextArea("");
//		h.setEditable(false);
//		h.setOpaque(false);
//		h.setFocusable(false);
//		bottomMiddleTopHalf.add(h);
		
		
		
		
		
		
//		JTextArea currentManaCrystals = new JTextArea("2");
//		currentManaCrystals.setEditable(false);
//		currentManaCrystals.setOpaque(false);
//		currentManaCrystals.setFocusable(false);
//		currentManaCrystals.setFont(new Font("Arial", Font.BOLD, 14));
//		westMiddleBottomHalf.add(currentManaCrystals);
		
		
//		JTextArea totalManaCrystals1 = new JTextArea("2");
//		totalManaCrystals1.setEditable(false);
//		totalManaCrystals1.setOpaque(false);
//		totalManaCrystals1.setFocusable(false);
//		totalManaCrystals1.setFont(new Font("Arial", Font.BOLD, 14));
//		eastMiddleBottomHalf.add(totalManaCrystals1);
		
		
		
		
		
		
//		int i = 0;
//		
//		JTextArea ya = new JTextArea("");
//		ya.setEditable(false);
//		ya.setOpaque(false);
//		ya.setFocusable(false);
//		topBottomHalf.add(ya);
//		
//		JButton aa = new JButton(""+i);
//		i++;
//		topBottomHalf.add(aa);
//		
//		JButton ba = new JButton(""+i);
//		i++;
//		topBottomHalf.add(ba);
//		
//		JButton ca = new JButton(""+i);
//		i++;
//		topBottomHalf.add(ca);
//		
//		JButton da = new JButton(""+i);
//		i++;
//		topBottomHalf.add(da);
//		
//		JButton ea = new JButton(""+i);
//		i++;
//		topBottomHalf.add(ea);
//		
//		JButton fa = new JButton(""+i);
//		i++;
//		topBottomHalf.add(fa);
//		
//		JButton ga = new JButton(""+i);
//		i++;
//		topBottomHalf.add(ga);
//		
//		JTextArea ha = new JTextArea("");
//		ha.setEditable(false);
//		ha.setOpaque(false);
//		ha.setFocusable(false);
//		topBottomHalf.add(ha);
		
		
//		JTextArea noOfCardsInHand = new JTextArea("22");
//		noOfCardsInHand.setEditable(false);
//		noOfCardsInHand.setOpaque(false);
//		noOfCardsInHand.setFocusable(false);
//		noOfCardsInHand.setFont(new Font("Arial", Font.BOLD, 14));
//		middleTopTopHalf.add(noOfCardsInHand);
//
//		JTextArea opponentTotalManaCrystals = new JTextArea("22");
//		opponentTotalManaCrystals.setEditable(false);
//		opponentTotalManaCrystals.setOpaque(false);
//		opponentTotalManaCrystals.setFocusable(false);
//		opponentTotalManaCrystals.setFont(new Font("Arial", Font.BOLD, 14));
//		westTopTopHalf.add(opponentTotalManaCrystals);
//		
//		
//		JTextArea opponentCurrentHP = new JTextArea("22");
//		opponentCurrentHP.setEditable(false);
//		opponentCurrentHP.setOpaque(false);
//		opponentCurrentHP.setFocusable(false);
//		opponentCurrentHP.setFont(new Font("Arial", Font.BOLD, 14));
//		eastTopTopHalf.add(opponentCurrentHP);
		
//		JButton endTurn = new JButton();
//		endTurn.setActionCommand("endTurn");
//		endTurn.addActionListener(this);
//		endTurn.setOpaque(true);
//		endTurn.setContentAreaFilled(false);
//		endTurn.setBorderPainted(false);
////		endTurn.setIcon(new ImageIcon("images/Game.png"));
//		endTurn.setPreferredSize(new Dimension(120, bottomTopHalf.getHeight()));
//		bottomTopHalf.add(endTurn, BorderLayout.EAST);

		// -------End of Adusting Panels-------//

		this.revalidate();
		this.repaint();

	}

	
	public JLabel getBattlefieldBackground() {
		return battlefieldBackground;
	}


	public JPanel getMiddle() {
		return middle;
	}


	public JPanel getTopHalf() {
		return topHalf;
	}


	public JPanel getBottomHalf() {
		return bottomHalf;
	}


	public JPanel getBottomTopHalf() {
		return bottomTopHalf;
	}


	public JPanel getHandCards() {
		return handCards;
	}


	public JPanel getLeftHandSide() {
		return leftHandSide;
	}


	public JPanel getRightHandSide() {
		return rightHandSide;
	}


	public JPanel getTopRightHandSide() {
		return topRightHandSide;
	}


	public JPanel getBottomRightHandSide() {
		return bottomRightHandSide;
	}


	public JPanel getTopTopHalf() {
		return topTopHalf;
	}


	public JPanel getEastTopTopHalf() {
		return eastTopTopHalf;
	}


	public JPanel getWestTopTopHalf() {
		return westTopTopHalf;
	}


	public JPanel getMiddleTopTopHalf() {
		return middleTopTopHalf;
	}


	public JPanel getTopBottomHalf() {
		return topBottomHalf;
	}


	public JPanel getMiddleBottomHalf() {
		return middleBottomHalf;
	}


	public JPanel getWestMiddleBottomHalf() {
		return westMiddleBottomHalf;
	}


	public JPanel getMiddleMiddleBottomHalf() {
		return middleMiddleBottomHalf;
	}


	public JPanel getEastMiddleBottomHalf() {
		return eastMiddleBottomHalf;
	}


	public JPanel getMiddleTopHalf() {
		return middleTopHalf;
	}


	public JPanel getTopMiddleTopHalf() {
		return topMiddleTopHalf;
	}


	public JPanel getBottomMiddleTopHalf() {
		return bottomMiddleTopHalf;
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("endTurn"))
			this.dispose();
			
	}

	public static void main(String[] args) {
		new GameView();
	}

}
