package controller;

import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import engine.*;
import exceptions.CannotAttackException;
import exceptions.FullFieldException;
import exceptions.FullHandException;
import exceptions.HeroPowerAlreadyUsedException;
import exceptions.InvalidTargetException;
import exceptions.NotEnoughManaException;
import exceptions.NotSummonedException;
import exceptions.NotYourTurnException;
import exceptions.TauntBypassException;
import model.cards.minions.*;
import model.cards.spells.*;
import model.heroes.*;
import view.*;
import java.awt.*;

public class Controller implements ActionListener, GameListener {
	private Game model;
	private FirstWindow currentScreen = new FirstWindow();
//	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private GameView mainView;
	private JButton startGame;
	private JButton magePlayer1;
	private JButton hunterPlayer1;
	private JButton paladinPlayer1;
	private JButton priestPlayer1;
	private JButton warlockPlayer1;
	private JButton magePlayer2;
	private JButton hunterPlayer2;
	private JButton paladinPlayer2;
	private JButton priestPlayer2;
	private JButton warlockPlayer2;
	private JTextArea blank;
	private JTextArea blankForOpponentField;
	private ArrayList<JButton> cardsInHand = new ArrayList<JButton>();
	private JButton cardInHand;
	private JButton cardOnField;
	private JButton cardOnOpponentField;
	private JButton clickedNow;
	private boolean clickedOnHeroPower = false;
	private ArrayList<JButton> cardsOnField = new ArrayList<JButton>();
	private ArrayList<JButton> cardsOnOpponentField = new ArrayList<JButton>();
	private Spell latestClickedSpell;
	private Hero firstHero;
	private Hero secondHero;
	private Minion attacker;
	private JButton firstClick;

	public Controller() {

		// ----Start Game Button----//
		startGame = new JButton();
//		startGame.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
//		startGame.setFont(new Font("Arial", Font.BOLD, 50));
//		startGame.setForeground(Color.WHITE);
//		startGame.setBackground(Color.DARK_GRAY);
		startGame.setContentAreaFilled(false);
		startGame.setOpaque(false);
		startGame.setFocusPainted(false);
		startGame.setBorderPainted(false);
		startGame.setPreferredSize(new Dimension(395, 100));
		startGame.setIcon(new ImageIcon("Images/buttonDefault1.png"));
		startGame.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				startGame.setIcon(new ImageIcon("Images/buttonHover1.png"));
			}

			public void mousePressed(MouseEvent e) {
				startGame.setIcon(new ImageIcon("Images/buttonPressed1.png"));
			}

			public void mouseReleased(MouseEvent e) {
				startGame.setIcon(new ImageIcon("Images/buttonReleased1.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				startGame.setIcon(new ImageIcon("Images/buttonDefault1.png"));
			}
		});
		currentScreen.getJ().add(startGame);
		startGame.addActionListener(this);
		// ----Start Game Button----//
		currentScreen.revalidate();
		currentScreen.repaint();
	}

	public void actionPerformed(ActionEvent click) {

//--------------------------Start Of StartScreen---------------------//
		if (click.getSource().equals(startGame)) {
			currentScreen.getContentPane().removeAll();
			currentScreen.revalidate();
			currentScreen.repaint();
			SecondWindow player1Screen = new SecondWindow();
			// ----magePlayer1 Button----//
			magePlayer1 = new JButton();
			ImageIcon jainaProudmoore = new ImageIcon("Images/jaina.jpg");
			magePlayer1.setIcon(jainaProudmoore);
			magePlayer1.setContentAreaFilled(false);
			magePlayer1.setBorderPainted(false);
			magePlayer1.setLayout(new BorderLayout());
			magePlayer1.setFocusable(false);
			magePlayer1.addMouseListener(new MouseAdapter() {
				JTextArea jaina = new JTextArea();

				public void mouseEntered(MouseEvent e) {
					magePlayer1.setIcon(new ImageIcon("Images/mageGIF.gif"));
					jaina.setText("Jaina Proudmoore");
					jaina.setFont(new Font("AR BONNIE", Font.BOLD, 30));
					jaina.setOpaque(false);
					jaina.setForeground(Color.WHITE);
					jaina.setEditable(false);
					magePlayer1.add(jaina, BorderLayout.SOUTH);
				}

				public void mouseExited(MouseEvent e) {
					magePlayer1.setIcon(jainaProudmoore);
					jaina.setText("");

				}
			});
			;
			player1Screen.getButtons().add(magePlayer1);
			magePlayer1.addActionListener(this);
			// ----magePlayer1 Button----//

			// ----hunterPlayer1 Button----//
			hunterPlayer1 = new JButton();
			ImageIcon rexxar = new ImageIcon("Images/rexxarButton.jpg");
			hunterPlayer1.setIcon(rexxar);
			hunterPlayer1.setContentAreaFilled(false);
			hunterPlayer1.setBorderPainted(false);
			hunterPlayer1.setLayout(new BorderLayout());
			hunterPlayer1.setFocusable(false);
			hunterPlayer1.addMouseListener(new MouseAdapter() {
				JTextArea rexxarText = new JTextArea();

				public void mouseEntered(MouseEvent e) {
					hunterPlayer1.setIcon(new ImageIcon("Images/rexxarGIF.gif"));
					rexxarText.setText("Rexxar");
					rexxarText.setFont(new Font("AR BONNIE", Font.BOLD, 50));
					rexxarText.setOpaque(false);
					rexxarText.setForeground(Color.WHITE);
					rexxarText.setEditable(false);
					hunterPlayer1.add(rexxarText, BorderLayout.SOUTH);
				}

				public void mouseExited(MouseEvent e) {
					hunterPlayer1.setIcon(rexxar);
					rexxarText.setText("");

				}
			});
			;
			player1Screen.getButtons().add(hunterPlayer1);
			hunterPlayer1.addActionListener(this);
			// ----hunterPlayer1 Button----//

			// ----paladinPlayer1 Button----//
			paladinPlayer1 = new JButton();
			ImageIcon paladin = new ImageIcon("Images/Uther_LightbringerButton.jpg");
			paladinPlayer1.setIcon(paladin);
			paladinPlayer1.setContentAreaFilled(false);
			paladinPlayer1.setBorderPainted(false);
			paladinPlayer1.setLayout(new BorderLayout());
			paladinPlayer1.setFocusable(false);
			paladinPlayer1.addMouseListener(new MouseAdapter() {
				JTextArea paladinText = new JTextArea();

				public void mouseEntered(MouseEvent e) {
					paladinPlayer1.setIcon(new ImageIcon("Images/paladin GIF.gif"));
					paladinText.setText("Uther Lightbringer");
					paladinText.setFont(new Font("AR BONNIE", Font.BOLD, 35));
					paladinText.setOpaque(false);
					paladinText.setForeground(Color.WHITE);
					paladinText.setEditable(false);
					paladinPlayer1.add(paladinText, BorderLayout.SOUTH);
				}

				public void mouseExited(MouseEvent e) {
					paladinPlayer1.setIcon(paladin);
					paladinText.setText("");

				}
			});
			;
			player1Screen.getButtons().add(paladinPlayer1);
			paladinPlayer1.addActionListener(this);
			// ----paladinPlayer1 Button----//

			// ----priestPlayer1 Button----//
			priestPlayer1 = new JButton();
			ImageIcon priest = new ImageIcon("Images/priestButton.jpg");
			priestPlayer1.setIcon(priest);
			priestPlayer1.setContentAreaFilled(false);
			priestPlayer1.setBorderPainted(false);
			priestPlayer1.setLayout(new BorderLayout());
			priestPlayer1.setFocusable(false);
			priestPlayer1.addMouseListener(new MouseAdapter() {
				JTextArea priestText = new JTextArea();

				public void mouseEntered(MouseEvent e) {
					priestPlayer1.setIcon(new ImageIcon("Images/priestGIF.gif"));
					priestText.setText("Anduin Wrynn");
					priestText.setFont(new Font("AR BONNIE", Font.BOLD, 35));
					priestText.setOpaque(false);
					priestText.setForeground(Color.WHITE);
					priestText.setEditable(false);
					priestPlayer1.add(priestText, BorderLayout.SOUTH);
				}

				public void mouseExited(MouseEvent e) {
					priestPlayer1.setIcon(priest);
					priestText.setText("");

				}
			});
			;
			player1Screen.getButtons().add(priestPlayer1);
			priestPlayer1.addActionListener(this);
			// ----priestPlayer1 Button----//

			// ----warlockPlayer1 Button----//
			warlockPlayer1 = new JButton();
			ImageIcon warlock = new ImageIcon("Images/warlockButton.jpg");
			warlockPlayer1.setIcon(warlock);
			warlockPlayer1.setContentAreaFilled(false);
			warlockPlayer1.setBorderPainted(false);
			warlockPlayer1.setLayout(new BorderLayout());
			warlockPlayer1.setFocusable(false);
			warlockPlayer1.addMouseListener(new MouseAdapter() {
				JTextArea warlockText = new JTextArea();

				public void mouseEntered(MouseEvent e) {
					warlockPlayer1.setIcon(new ImageIcon("Images/warlockGIF.gif"));
					warlockText.setText("Gul'dan");
					warlockText.setFont(new Font("AR BONNIE", Font.BOLD, 50));
					warlockText.setOpaque(false);
					warlockText.setForeground(Color.WHITE);
					warlockText.setEditable(false);
					warlockPlayer1.add(warlockText, BorderLayout.SOUTH);
				}

				public void mouseExited(MouseEvent e) {
					warlockPlayer1.setIcon(warlock);
					warlockText.setText("");

				}
			});
			;
			player1Screen.getButtons().add(warlockPlayer1);
			warlockPlayer1.addActionListener(this);
			// ----warlockPlayer1 Button----//

			player1Screen.revalidate();
			player1Screen.repaint();
			currentScreen.add(player1Screen.getJ());
//			currentScreen.add(player1Screen.getButtons(), BorderLayout.CENTER);
//			currentScreen.add(player1Screen.getUpperPanel(), BorderLayout.NORTH);
//			currentScreen.add(player1Screen.getLowerPanel(), BorderLayout.SOUTH);
//			currentScreen.add(player1Screen.getImage(),BorderLayout.NORTH);
			currentScreen.revalidate();
			currentScreen.repaint();
		}

		// --------------------------End Of Start Screen---------------------//

		// ----------------Start Of Choosing First Hero(Second Window)----------------//

		if (click.getSource().equals(magePlayer1) || click.getSource().equals(hunterPlayer1)
				|| click.getSource().equals(priestPlayer1) || click.getSource().equals(paladinPlayer1)
				|| click.getSource().equals(warlockPlayer1)) {

			currentScreen.getContentPane().removeAll();
			currentScreen.revalidate();
			currentScreen.repaint();
			ThirdWindow player2Screen = new ThirdWindow();

			if (click.getSource().equals(magePlayer1)) {
				try {
					firstHero = new Mage();
				} catch (IOException | CloneNotSupportedException e) {
					e.printStackTrace();
				}
			}

			else if (click.getSource().equals(hunterPlayer1)) {
				try {
					firstHero = new Hunter();
				} catch (IOException | CloneNotSupportedException e) {
					e.printStackTrace();
				}
			}

			else if (click.getSource().equals(priestPlayer1)) {
				try {
					firstHero = new Priest();
				} catch (IOException | CloneNotSupportedException e) {
					e.printStackTrace();
				}
			}

			else if (click.getSource().equals(paladinPlayer1)) {
				try {
					firstHero = new Paladin();
				} catch (IOException | CloneNotSupportedException e) {
					e.printStackTrace();
				}
			}

			else if (click.getSource().equals(warlockPlayer1)) {

				try {
					firstHero = new Warlock();
				} catch (IOException | CloneNotSupportedException e) {
					e.printStackTrace();
				}
			}

			// ----magePlayer2 Button----//
			magePlayer2 = new JButton();
			ImageIcon jainaProudmoore = new ImageIcon("Images/jaina.jpg");
			magePlayer2.setIcon(jainaProudmoore);
			magePlayer2.setContentAreaFilled(false);
			magePlayer2.setBorderPainted(false);
			magePlayer2.setLayout(new BorderLayout());
			magePlayer2.setFocusable(false);
			magePlayer2.addMouseListener(new MouseAdapter() {
				JTextArea jaina = new JTextArea();

				public void mouseEntered(MouseEvent e) {
					magePlayer2.setIcon(new ImageIcon("Images/mageGIF.gif"));
					jaina.setText("Jaina Proudmoore");
					jaina.setFont(new Font("AR BONNIE", Font.BOLD, 30));
					jaina.setOpaque(false);
					jaina.setForeground(Color.WHITE);
					jaina.setEditable(false);
					magePlayer2.add(jaina, BorderLayout.SOUTH);
				}

				public void mouseExited(MouseEvent e) {
					magePlayer2.setIcon(jainaProudmoore);
					jaina.setText("");

				}
			});
			;
			player2Screen.getButtons().add(magePlayer2);
			magePlayer2.addActionListener(this);
			// ----magePlayer2 Button----//

			// ----hunterPlayer2 Button----//
			hunterPlayer2 = new JButton();
			ImageIcon rexxar = new ImageIcon("Images/rexxarButton.jpg");
			hunterPlayer2.setIcon(rexxar);
			hunterPlayer2.setContentAreaFilled(false);
			hunterPlayer2.setBorderPainted(false);
			hunterPlayer2.setLayout(new BorderLayout());
			hunterPlayer2.setFocusable(false);
			hunterPlayer2.addMouseListener(new MouseAdapter() {
				JTextArea rexxarText = new JTextArea();

				public void mouseEntered(MouseEvent e) {
					hunterPlayer2.setIcon(new ImageIcon("Images/rexxarGIF.gif"));
					rexxarText.setText("Rexxar");
					rexxarText.setFont(new Font("AR BONNIE", Font.BOLD, 50));
					rexxarText.setOpaque(false);
					rexxarText.setForeground(Color.WHITE);
					rexxarText.setEditable(false);
					hunterPlayer2.add(rexxarText, BorderLayout.SOUTH);
				}

				public void mouseExited(MouseEvent e) {
					hunterPlayer2.setIcon(rexxar);
					rexxarText.setText("");

				}
			});
			;
			player2Screen.getButtons().add(hunterPlayer2);
			hunterPlayer2.addActionListener(this);
			// ----hunterPlayer2 Button----//

			// ----paladinPlayer2 Button----//
			paladinPlayer2 = new JButton();
			ImageIcon paladin = new ImageIcon("Images/Uther_LightbringerButton.jpg");
			paladinPlayer2.setIcon(paladin);
			paladinPlayer2.setContentAreaFilled(false);
			paladinPlayer2.setBorderPainted(false);
			paladinPlayer2.setLayout(new BorderLayout());
			paladinPlayer2.setFocusable(false);
			paladinPlayer2.addMouseListener(new MouseAdapter() {
				JTextArea paladinText = new JTextArea();

				public void mouseEntered(MouseEvent e) {
					paladinPlayer2.setIcon(new ImageIcon("Images/paladin GIF.gif"));
					paladinText.setText("Uther Lightbringer");
					paladinText.setFont(new Font("AR BONNIE", Font.BOLD, 35));
					paladinText.setOpaque(false);
					paladinText.setForeground(Color.WHITE);
					paladinText.setEditable(false);
					paladinPlayer2.add(paladinText, BorderLayout.SOUTH);
				}

				public void mouseExited(MouseEvent e) {
					paladinPlayer2.setIcon(paladin);
					paladinText.setText("");

				}
			});
			;
			player2Screen.getButtons().add(paladinPlayer2);
			paladinPlayer2.addActionListener(this);
			// ----paladinPlayer2 Button----//

			// ----priestPlayer2 Button----//
			priestPlayer2 = new JButton();
			ImageIcon priest = new ImageIcon("Images/priestButton.jpg");
			priestPlayer2.setIcon(priest);
			priestPlayer2.setContentAreaFilled(false);
			priestPlayer2.setBorderPainted(false);
			priestPlayer2.setLayout(new BorderLayout());
			priestPlayer2.setFocusable(false);
			priestPlayer2.addMouseListener(new MouseAdapter() {
				JTextArea priestText = new JTextArea();

				public void mouseEntered(MouseEvent e) {
					priestPlayer2.setIcon(new ImageIcon("Images/priestGIF.gif"));
					priestText.setText("Anduin Wrynn");
					priestText.setFont(new Font("AR BONNIE", Font.BOLD, 35));
					priestText.setOpaque(false);
					priestText.setForeground(Color.WHITE);
					priestText.setEditable(false);
					priestPlayer2.add(priestText, BorderLayout.SOUTH);
				}

				public void mouseExited(MouseEvent e) {
					priestPlayer2.setIcon(priest);
					priestText.setText("");

				}
			});
			;
			player2Screen.getButtons().add(priestPlayer2);
			priestPlayer2.addActionListener(this);
			// ----priestPlayer2 Button----//

			// ----warlockPlayer2 Button----//
			warlockPlayer2 = new JButton();
			ImageIcon warlock = new ImageIcon("Images/warlockButton.jpg");
			warlockPlayer2.setIcon(warlock);
			warlockPlayer2.setContentAreaFilled(false);
			warlockPlayer2.setBorderPainted(false);
			warlockPlayer2.setLayout(new BorderLayout());
			warlockPlayer2.setFocusable(false);
			warlockPlayer2.addMouseListener(new MouseAdapter() {
				JTextArea warlockText = new JTextArea();

				public void mouseEntered(MouseEvent e) {
					warlockPlayer2.setIcon(new ImageIcon("Images/warlockGIF.gif"));
					warlockText.setText("Gul'dan");
					warlockText.setFont(new Font("AR BONNIE", Font.BOLD, 50));
					warlockText.setOpaque(false);
					warlockText.setForeground(Color.WHITE);
					warlockText.setEditable(false);
					warlockPlayer2.add(warlockText, BorderLayout.SOUTH);
				}

				public void mouseExited(MouseEvent e) {
					warlockPlayer2.setIcon(warlock);
					warlockText.setText("");

				}
			});
			;
			player2Screen.getButtons().add(warlockPlayer2);
			warlockPlayer2.addActionListener(this);
			// ----warlockPlayer2 Button----//

			player2Screen.revalidate();
			player2Screen.repaint();
//			currentScreen.add(player2Screen.getImage());
			currentScreen.add(player2Screen.getJ());
//			currentScreen.add(player2Screen.getImage(),BorderLayout.NORTH);
			currentScreen.revalidate();
			currentScreen.repaint();
		}

		// ----------------End Of Choosing First Hero(Second Window)----------------//

		// ----------------Start Of Choosing Second Hero(Third Window)----------------//

		if (click.getSource().equals(magePlayer2) || click.getSource().equals(hunterPlayer2)
				|| click.getSource().equals(priestPlayer2) || click.getSource().equals(paladinPlayer2)
				|| click.getSource().equals(warlockPlayer2)) {

			currentScreen.getContentPane().removeAll();
			currentScreen.revalidate();
			currentScreen.repaint();

			if (click.getSource().equals(magePlayer2)) {
				try {
					secondHero = new Mage();
				} catch (IOException | CloneNotSupportedException e) {
					e.printStackTrace();
				}
			}

			if (click.getSource().equals(hunterPlayer2)) {
				try {
					secondHero = new Hunter();
				} catch (IOException | CloneNotSupportedException e) {
					e.printStackTrace();
				}
			}

			if (click.getSource().equals(priestPlayer2)) {
				try {
					secondHero = new Priest();
				} catch (IOException | CloneNotSupportedException e) {
					e.printStackTrace();
				}
			}

			if (click.getSource().equals(paladinPlayer2)) {
				try {
					secondHero = new Paladin();
				} catch (IOException | CloneNotSupportedException e) {
					e.printStackTrace();
				}
			}

			if (click.getSource().equals(warlockPlayer2)) {
				try {
					secondHero = new Warlock();
				} catch (IOException | CloneNotSupportedException e) {
					e.printStackTrace();
				}
			}

			try {
				model = new Game(firstHero, secondHero);
				model.setListener(this);
			} catch (FullHandException | CloneNotSupportedException e) {
				e.printStackTrace();
			}

			mainView = new GameView();
			screenAdjustment();
		}

		if (click.getActionCommand().equals("endTurn")) {

			try {
				model.endTurn();
			} catch (FullHandException e) {
				popupForFullHandException(e);

			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			} finally {
				mainView = new GameView();
				currentScreen.getContentPane().removeAll();
				screenAdjustment();
				currentScreen.revalidate();
				currentScreen.repaint();
			}
		}

		if (click.getActionCommand().equals("cardInHand")) {
			int u = cardsInHand.indexOf((JButton) click.getSource());

			if (model.getCurrentHero().getHand().get(u) instanceof Minion) {
				try {
					model.getCurrentHero().playMinion((Minion) model.getCurrentHero().getHand().get(u));
					latestClickedSpell = null;

				} catch (NotYourTurnException e) {
					popupForNotYourTurnException();

				} catch (NotEnoughManaException e) {
					popupForNotEnoughManaException();

				} catch (FullFieldException e) {
					popupForFullFieldException();

				} finally {
					mainView = new GameView();
					currentScreen.getContentPane().removeAll();
					screenAdjustment();
					currentScreen.revalidate();
					currentScreen.repaint();
				}
			} else if (model.getCurrentHero().getHand().get(u) instanceof Spell) {
				latestClickedSpell = (Spell) model.getCurrentHero().getHand().get(u);
				if (clickedNow == null && (model.getCurrentHero().getHand().get(u) instanceof MinionTargetSpell
						|| model.getCurrentHero().getHand().get(u) instanceof HeroTargetSpell
						|| model.getCurrentHero().getHand().get(u) instanceof LeechingSpell)) {

					((JButton) click.getSource()).setBorder(BorderFactory.createLineBorder(Color.GREEN, 1));
					clickedNow = (JButton) click.getSource();
					latestClickedSpell = (Spell) model.getCurrentHero().getHand().get(u);

				} else if ((JButton) click.getSource() != clickedNow
						&& (model.getCurrentHero().getHand().get(u) instanceof MinionTargetSpell
								|| model.getCurrentHero().getHand().get(u) instanceof HeroTargetSpell
								|| model.getCurrentHero().getHand().get(u) instanceof LeechingSpell)) {

					clickedNow.setBorder(((JButton) click.getSource()).getBorder());
					((JButton) click.getSource()).setBorder(BorderFactory.createLineBorder(Color.GREEN, 1));
					clickedNow = (JButton) click.getSource();
					latestClickedSpell = (Spell) model.getCurrentHero().getHand().get(u);

				}

				if (model.getCurrentHero().getHand().get(u) instanceof FieldSpell) {
					int response = JOptionPane.showConfirmDialog(currentScreen, "Do you want to cast this spell?",
							"Casting Spell", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

					if (response == JOptionPane.YES_OPTION) {
						try {
							model.getCurrentHero().castSpell((FieldSpell) model.getCurrentHero().getHand().get(u));
						} catch (NotYourTurnException e) {
							popupForNotYourTurnException();

						} catch (NotEnoughManaException e) {
							popupForNotEnoughManaException();

						} finally {
							mainView = new GameView();
							currentScreen.getContentPane().removeAll();
							screenAdjustment();
							currentScreen.revalidate();
							currentScreen.repaint();
						}
					}
				} else if (model.getCurrentHero().getHand().get(u) instanceof AOESpell) {
					int response = JOptionPane.showConfirmDialog(currentScreen, "Do you want to cast this spell?",
							"Casting Spell", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

					if (response == JOptionPane.YES_OPTION) {
						try {
							model.getCurrentHero().castSpell((AOESpell) model.getCurrentHero().getHand().get(u),
									model.getOpponent().getField());
						} catch (NotYourTurnException e) {
							popupForNotYourTurnException();

						} catch (NotEnoughManaException e) {
							popupForNotEnoughManaException();

						} finally {
							mainView = new GameView();
							currentScreen.getContentPane().removeAll();
							screenAdjustment();
							currentScreen.revalidate();
							currentScreen.repaint();
						}
					}
				}

			}
		}

		if (attacker == null && click.getActionCommand().equals("cardOnField") && !clickedOnHeroPower
				&& latestClickedSpell == null) {
			int h = cardsOnField.indexOf((JButton) click.getSource());
			attacker = model.getCurrentHero().getField().get(h);
			firstClick = (JButton) click.getSource();
			((JButton) click.getSource()).setBorder(BorderFactory.createLineBorder(Color.GREEN, 1));
		}

		if (latestClickedSpell != null) {
			if (latestClickedSpell instanceof HeroTargetSpell && (click.getActionCommand().equals("currentHero")
					|| click.getActionCommand().equals("opponentHero"))) {
				if (click.getActionCommand().equals("currentHero")) {
					try {
						model.getCurrentHero().castSpell((HeroTargetSpell) latestClickedSpell, model.getCurrentHero());
						latestClickedSpell = null;
					} catch (NotYourTurnException e) {
						popupForNotYourTurnException();

					} catch (NotEnoughManaException e) {
						popupForNotEnoughManaException();

					} finally {
						mainView = new GameView();
						currentScreen.getContentPane().removeAll();
						screenAdjustment();
						currentScreen.revalidate();
						currentScreen.repaint();
					}
				} else if (click.getActionCommand().equals("opponentHero")) {
					try {
						model.getCurrentHero().castSpell((HeroTargetSpell) latestClickedSpell, model.getOpponent());
						latestClickedSpell = null;
					} catch (NotYourTurnException e) {
						popupForNotYourTurnException();

					} catch (NotEnoughManaException e) {
						popupForNotEnoughManaException();

					} finally {
						mainView = new GameView();
						currentScreen.getContentPane().removeAll();
						screenAdjustment();
						currentScreen.revalidate();
						currentScreen.repaint();
					}
				}
			} else if (latestClickedSpell instanceof MinionTargetSpell) {
				if (cardsOnField.contains((JButton) click.getSource())) {
					int l = cardsOnField.indexOf((JButton) click.getSource());
					try {
						model.getCurrentHero().castSpell((MinionTargetSpell) latestClickedSpell,
								model.getCurrentHero().getField().get(l));
						latestClickedSpell = null;
					} catch (NotYourTurnException e) {
						popupForNotYourTurnException();

					} catch (NotEnoughManaException e) {
						popupForNotEnoughManaException();

					} catch (InvalidTargetException e) {
						JOptionPane.showMessageDialog(currentScreen, "This minion cannot be attacked using this spell!",
								"The 'Shadow Word Death' spell can only be performed when the attacked minion has an attack value of 5 or more!",
								JOptionPane.WARNING_MESSAGE);
					} finally {
						mainView = new GameView();
						currentScreen.getContentPane().removeAll();
						screenAdjustment();
						currentScreen.revalidate();
						currentScreen.repaint();
					}
				} else if (cardsOnOpponentField.contains((JButton) click.getSource())) {
					int f = cardsOnOpponentField.indexOf((JButton) click.getSource());
					try {
						model.getCurrentHero().castSpell((MinionTargetSpell) latestClickedSpell,
								model.getOpponent().getField().get(f));
						latestClickedSpell = null;
					} catch (NotYourTurnException e) {
						popupForNotYourTurnException();

					} catch (NotEnoughManaException e) {
						popupForNotEnoughManaException();

					} catch (InvalidTargetException e) {
						JOptionPane.showMessageDialog(currentScreen, "This minion cannot be attacked using this spell!",
								"The 'Shadow Word Death' spell can only be performed when the attacked minion has an attack value of 5 or more!",
								JOptionPane.WARNING_MESSAGE);
					} finally {
						mainView = new GameView();
						currentScreen.getContentPane().removeAll();
						screenAdjustment();
						currentScreen.revalidate();
						currentScreen.repaint();
					}
				}
			} else if (latestClickedSpell instanceof LeechingSpell) {
				if (cardsOnField.contains((JButton) click.getSource())) {
					int v = cardsOnField.indexOf((JButton) click.getSource());
					try {
						model.getCurrentHero().castSpell((LeechingSpell) latestClickedSpell,
								model.getCurrentHero().getField().get(v));
						latestClickedSpell = null;
					} catch (NotYourTurnException e) {
						popupForNotYourTurnException();

					} catch (NotEnoughManaException e) {
						popupForNotEnoughManaException();

					} finally {
						mainView = new GameView();
						currentScreen.getContentPane().removeAll();
						screenAdjustment();
						currentScreen.revalidate();
						currentScreen.repaint();
					}
				} else if (cardsOnOpponentField.contains((JButton) click.getSource())) {
					int o = cardsOnOpponentField.indexOf((JButton) click.getSource());
					try {
						model.getCurrentHero().castSpell((LeechingSpell) latestClickedSpell,
								model.getOpponent().getField().get(o));
						latestClickedSpell = null;
					} catch (NotYourTurnException e) {
						popupForNotYourTurnException();

					} catch (NotEnoughManaException e) {
						popupForNotEnoughManaException();

					} finally {
						mainView = new GameView();
						currentScreen.getContentPane().removeAll();
						screenAdjustment();
						currentScreen.revalidate();
						currentScreen.repaint();
					}
				}
			}
		}

		if (click.getActionCommand().equals("Use Hero Power")) {
			if (model.getCurrentHero() instanceof Mage || model.getCurrentHero() instanceof Priest) {
				clickedOnHeroPower = true;
				((JButton) click.getSource()).setBorder(BorderFactory.createLineBorder(Color.GREEN, 1));
			} else {
				try {
					model.getCurrentHero().useHeroPower();

				} catch (NotEnoughManaException e) {
					popupForNotEnoughManaException();

				} catch (HeroPowerAlreadyUsedException e) {
					popupForHeroPowerAlreadyUsedException();

				} catch (NotYourTurnException e) {
					popupForNotYourTurnException();

				} catch (FullHandException e) {
					popupForFullHandException(e);

				} catch (FullFieldException e) {
					popupForFullFieldException();

				} catch (CloneNotSupportedException e) {
					e.printStackTrace();
				} finally {
					mainView = new GameView();
					currentScreen.getContentPane().removeAll();
					screenAdjustment();
					currentScreen.revalidate();
					currentScreen.repaint();
				}
			}
		}

		if (clickedOnHeroPower) {
			if (model.getCurrentHero() instanceof Mage) {
				if (click.getActionCommand().equals("currentHero")) {
					try {
						((Mage) model.getCurrentHero()).useHeroPower(model.getCurrentHero());
						clickedOnHeroPower = false;
					} catch (NotEnoughManaException e) {
						popupForNotEnoughManaException();

					} catch (HeroPowerAlreadyUsedException e) {
						popupForHeroPowerAlreadyUsedException();

					} catch (NotYourTurnException e) {
						popupForNotYourTurnException();

					} catch (FullHandException e) {
						popupForFullHandException(e);

					} catch (FullFieldException e) {
						popupForFullFieldException();

					} catch (CloneNotSupportedException e) {
						e.printStackTrace();
					} finally {
						mainView = new GameView();
						currentScreen.getContentPane().removeAll();
						screenAdjustment();
						currentScreen.revalidate();
						currentScreen.repaint();
					}
				} else if (click.getActionCommand().equals("opponentHero")) {
					try {
						((Mage) model.getCurrentHero()).useHeroPower(model.getOpponent());
						clickedOnHeroPower = false;
					} catch (NotEnoughManaException e) {
						popupForNotEnoughManaException();

					} catch (HeroPowerAlreadyUsedException e) {
						popupForHeroPowerAlreadyUsedException();

					} catch (NotYourTurnException e) {
						popupForNotYourTurnException();

					} catch (FullHandException e) {
						popupForFullHandException(e);

					} catch (FullFieldException e) {
						popupForFullFieldException();

					} catch (CloneNotSupportedException e) {
						e.printStackTrace();
					} finally {
						mainView = new GameView();
						currentScreen.getContentPane().removeAll();
						screenAdjustment();
						currentScreen.revalidate();
						currentScreen.repaint();
					}
				} else if (cardsOnField.contains((JButton) click.getSource())) {
					int q = cardsOnField.indexOf((JButton) click.getSource());
					try {
						((Mage) model.getCurrentHero()).useHeroPower(model.getCurrentHero().getField().get(q));
						clickedOnHeroPower = false;
					} catch (NotEnoughManaException e) {
						popupForNotEnoughManaException();

					} catch (HeroPowerAlreadyUsedException e) {
						popupForHeroPowerAlreadyUsedException();

					} catch (NotYourTurnException e) {
						popupForNotYourTurnException();

					} catch (FullHandException e) {
						popupForFullHandException(e);

					} catch (FullFieldException e) {
						popupForFullFieldException();

					} catch (CloneNotSupportedException e) {
						e.printStackTrace();
					} finally {
						mainView = new GameView();
						currentScreen.getContentPane().removeAll();
						screenAdjustment();
						currentScreen.revalidate();
						currentScreen.repaint();
					}

				} else if (cardsOnOpponentField.contains((JButton) click.getSource())) {
					int a = cardsOnOpponentField.indexOf((JButton) click.getSource());
					try {
						((Mage) model.getCurrentHero()).useHeroPower(model.getOpponent().getField().get(a));
						clickedOnHeroPower = false;
					} catch (NotEnoughManaException e) {
						popupForNotEnoughManaException();

					} catch (HeroPowerAlreadyUsedException e) {
						popupForHeroPowerAlreadyUsedException();

					} catch (NotYourTurnException e) {
						popupForNotYourTurnException();

					} catch (FullHandException e) {
						popupForFullHandException(e);

					} catch (FullFieldException e) {
						popupForFullFieldException();

					} catch (CloneNotSupportedException e) {
						e.printStackTrace();
					} finally {
						mainView = new GameView();
						currentScreen.getContentPane().removeAll();
						screenAdjustment();
						currentScreen.revalidate();
						currentScreen.repaint();
					}

				}
			} else if (model.getCurrentHero() instanceof Priest) {
				if (click.getActionCommand().equals("currentHero")) {
					try {
						((Priest) model.getCurrentHero()).useHeroPower(model.getCurrentHero());
						clickedOnHeroPower = false;
					} catch (NotEnoughManaException e) {
						popupForNotEnoughManaException();

					} catch (HeroPowerAlreadyUsedException e) {
						popupForHeroPowerAlreadyUsedException();

					} catch (NotYourTurnException e) {
						popupForNotYourTurnException();

					} catch (FullHandException e) {
						popupForFullHandException(e);

					} catch (FullFieldException e) {
						popupForFullFieldException();

					} catch (CloneNotSupportedException e) {
						e.printStackTrace();
					} finally {
						mainView = new GameView();
						currentScreen.getContentPane().removeAll();
						screenAdjustment();
						currentScreen.revalidate();
						currentScreen.repaint();
					}
				} else if (click.getActionCommand().equals("opponentHero")) {
					try {
						((Priest) model.getCurrentHero()).useHeroPower(model.getOpponent());
						clickedOnHeroPower = false;
					} catch (NotEnoughManaException e) {
						popupForNotEnoughManaException();

					} catch (HeroPowerAlreadyUsedException e) {
						popupForHeroPowerAlreadyUsedException();

					} catch (NotYourTurnException e) {
						popupForNotYourTurnException();

					} catch (FullHandException e) {
						popupForFullHandException(e);

					} catch (FullFieldException e) {
						popupForFullFieldException();

					} catch (CloneNotSupportedException e) {
						e.printStackTrace();
					} finally {
						mainView = new GameView();
						currentScreen.getContentPane().removeAll();
						screenAdjustment();
						currentScreen.revalidate();
						currentScreen.repaint();
					}
				} else if (cardsOnField.contains((JButton) click.getSource())) {
					int p = cardsOnField.indexOf((JButton) click.getSource());
					try {
						((Priest) model.getCurrentHero()).useHeroPower(model.getCurrentHero().getField().get(p));
						clickedOnHeroPower = false;
					} catch (NotEnoughManaException e) {
						popupForNotEnoughManaException();

					} catch (HeroPowerAlreadyUsedException e) {
						popupForHeroPowerAlreadyUsedException();

					} catch (NotYourTurnException e) {
						popupForNotYourTurnException();

					} catch (FullHandException e) {
						popupForFullHandException(e);

					} catch (FullFieldException e) {
						popupForFullFieldException();

					} catch (CloneNotSupportedException e) {
						e.printStackTrace();
					} finally {
						mainView = new GameView();
						currentScreen.getContentPane().removeAll();
						screenAdjustment();
						currentScreen.revalidate();
						currentScreen.repaint();
					}

				} else if (cardsOnOpponentField.contains((JButton) click.getSource())) {
					int r = cardsOnOpponentField.indexOf((JButton) click.getSource());
					try {
						((Priest) model.getCurrentHero()).useHeroPower(model.getOpponent().getField().get(r));
						clickedOnHeroPower = false;

					} catch (NotEnoughManaException e) {
						popupForNotEnoughManaException();

					} catch (HeroPowerAlreadyUsedException e) {
						popupForHeroPowerAlreadyUsedException();

					} catch (NotYourTurnException e) {
						popupForNotYourTurnException();

					} catch (FullHandException e) {
						popupForFullHandException(e);

					} catch (FullFieldException e) {
						popupForFullFieldException();

					} catch (CloneNotSupportedException e) {
						e.printStackTrace();
					} finally {
						mainView = new GameView();
						currentScreen.getContentPane().removeAll();
						screenAdjustment();
						currentScreen.revalidate();
						currentScreen.repaint();
					}

				}
			}

		}

		if (attacker != null && firstClick != (JButton) click.getSource()) {
			if (click.getActionCommand().equals("currentHero")) {
				try {
					model.getCurrentHero().attackWithMinion(attacker, model.getCurrentHero());
				} catch (CannotAttackException e) {
					popupForCannotAttackException(e);

				} catch (NotYourTurnException e) {
					popupForNotYourTurnException();

				} catch (TauntBypassException e) {
					popupForTauntBypassException(e);

				} catch (NotSummonedException e) {
					popupForNotSummonedException(e);

				} catch (InvalidTargetException e) {
					popupForInvalidTargetException(e);

				} finally {
					mainView = new GameView();
					currentScreen.getContentPane().removeAll();
					screenAdjustment();
					currentScreen.revalidate();
					currentScreen.repaint();
					attacker = null;
					firstClick = (JButton) click.getSource();
				}

			} else if (click.getActionCommand().equals("opponentHero")) {
				try {
					model.getCurrentHero().attackWithMinion(attacker, model.getOpponent());

				} catch (CannotAttackException e) {
					popupForCannotAttackException(e);

				} catch (NotYourTurnException e) {
					popupForNotYourTurnException();

				} catch (TauntBypassException e) {
					popupForTauntBypassException(e);

				} catch (NotSummonedException e) {
					popupForNotSummonedException(e);

				} catch (InvalidTargetException e) {
					popupForInvalidTargetException(e);

				} finally {
					mainView = new GameView();
					currentScreen.getContentPane().removeAll();
					screenAdjustment();
					currentScreen.revalidate();
					currentScreen.repaint();
					attacker = null;
					firstClick = (JButton) click.getSource();
				}

			} else if (click.getActionCommand().equals("cardOnField")) {
				try {
					int y = cardsOnField.indexOf((JButton) click.getSource());
					model.getCurrentHero().attackWithMinion(attacker, model.getCurrentHero().getField().get(y));

				} catch (CannotAttackException e) {
					popupForCannotAttackException(e);

				} catch (NotYourTurnException e) {
					popupForNotYourTurnException();

				} catch (TauntBypassException e) {
					popupForTauntBypassException(e);

				} catch (NotSummonedException e) {
					popupForNotSummonedException(e);

				} catch (InvalidTargetException e) {
					popupForInvalidTargetException(e);

				} finally {
					mainView = new GameView();
					currentScreen.getContentPane().removeAll();
					screenAdjustment();
					currentScreen.revalidate();
					currentScreen.repaint();
					attacker = null;
					firstClick = (JButton) click.getSource();
				}

			} else if (click.getActionCommand().equals("cardOnOpponentField")) {
				try {
					int y = cardsOnOpponentField.indexOf((JButton) click.getSource());
					model.getCurrentHero().attackWithMinion(attacker, model.getOpponent().getField().get(y));

				} catch (CannotAttackException e) {
					popupForCannotAttackException(e);

				} catch (NotYourTurnException e) {
					popupForNotYourTurnException();

				} catch (TauntBypassException e) {
					popupForTauntBypassException(e);

				} catch (NotSummonedException e) {
					popupForNotSummonedException(e);

				} catch (InvalidTargetException e) {
					popupForInvalidTargetException(e);

				} finally {
					mainView = new GameView();
					currentScreen.getContentPane().removeAll();
					screenAdjustment();
					currentScreen.revalidate();
					currentScreen.repaint();
					attacker = null;
					firstClick = (JButton) click.getSource();
				}

			}
		}

	}

	public void popupForNotEnoughManaException() {
		JOptionPane.showMessageDialog(currentScreen, "Not enough mana crystals!",
				"You do not have enough mana crystals to play this card", JOptionPane.WARNING_MESSAGE);
	}

	public void popupForNotYourTurnException() {
		JOptionPane.showMessageDialog(currentScreen, "Please await your turn!", "It is not your turn yet",
				JOptionPane.WARNING_MESSAGE);
	}

	public void popupForFullFieldException() {
		JOptionPane.showMessageDialog(currentScreen, "Field is full!", "You cannot play a card onto a full field",
				JOptionPane.WARNING_MESSAGE);
	}

	public void popupForFullHandException(FullHandException e) {
		JOptionPane.showMessageDialog(currentScreen, e.getBurned().toString(), "Hand full, this card will be burned", 0,
				new ImageIcon("Images/BURNING.png"));
	}

	public void popupForHeroPowerAlreadyUsedException() {
		JOptionPane.showMessageDialog(currentScreen, "Hero Power Already Used", "You already used your power this turn",
				JOptionPane.WARNING_MESSAGE);
	}

	public void popupForCannotAttackException(CannotAttackException e) {
		JOptionPane.showMessageDialog(currentScreen, "Cannot Attack", e.getMessage(), JOptionPane.WARNING_MESSAGE);
	}

	public void popupForNotSummonedException(NotSummonedException e) {
		JOptionPane.showMessageDialog(currentScreen, "Minion not summoned onto the field yet", e.getMessage(),
				JOptionPane.WARNING_MESSAGE);
	}

	public void popupForTauntBypassException(TauntBypassException e) {
		JOptionPane.showMessageDialog(currentScreen, "Taunt Bypass", e.getMessage(), JOptionPane.WARNING_MESSAGE);
	}

	public void popupForInvalidTargetException(InvalidTargetException e) {
		JOptionPane.showMessageDialog(currentScreen, "Invalid Target", e.getMessage(), JOptionPane.WARNING_MESSAGE);
	}

	public void screenAdjustment() {

		// ------------Start of EndTurn Button------------//
		JButton endTurn = new JButton();
		endTurn.setActionCommand("endTurn");
		endTurn.addActionListener(this);
		endTurn.setOpaque(true);
		endTurn.setContentAreaFilled(false);
		endTurn.setBorderPainted(false);
		endTurn.setPreferredSize(new Dimension(120, mainView.getBottomTopHalf().getHeight()));
		mainView.getBottomTopHalf().add(endTurn, BorderLayout.EAST);
//		endTurn.setIcon(new ImageIcon("images/Game.png"));
		// ------------End of EndTurn Button------------//

		// ------------Start of currentHero Button------------//

		if (model.getCurrentHero() instanceof Mage) {
			JButton mageHeroButton = new JButton();
			mageHeroButton.setContentAreaFilled(false);
			mageHeroButton.setBorderPainted(false);
			mageHeroButton.setFocusable(false);
			mageHeroButton.addActionListener(this);
			mageHeroButton.setActionCommand("currentHero");
			mageHeroButton.setIcon(new ImageIcon("Images/Jaina_Proudmoore after 2.png"));
			mageHeroButton.setPreferredSize(new Dimension(145, 145));
			mageHeroButton.setLayout(new FlowLayout(FlowLayout.LEFT, 103, 85));
			JTextArea currentHPforCurrentHero = new JTextArea("" + model.getCurrentHero().getCurrentHP());
			currentHPforCurrentHero.setFont(new Font("Arial", Font.BOLD, 15));
			currentHPforCurrentHero.setForeground(Color.WHITE);
			currentHPforCurrentHero.setFocusable(false);
			currentHPforCurrentHero.setEditable(false);
			currentHPforCurrentHero.setOpaque(false);
			mageHeroButton.add(currentHPforCurrentHero);
			mainView.getMiddleMiddleBottomHalf().add(mageHeroButton);

		} else if (model.getCurrentHero() instanceof Hunter) {
			JButton hunterHeroButton = new JButton();
			hunterHeroButton.setActionCommand("currentHero");
			hunterHeroButton.setContentAreaFilled(false);
			hunterHeroButton.setBorderPainted(false);
			hunterHeroButton.setFocusable(false);
			hunterHeroButton.addActionListener(this);
			hunterHeroButton.setIcon(new ImageIcon("Images/Rexxar after 2.png"));
			hunterHeroButton.setPreferredSize(new Dimension(145, 145));
			hunterHeroButton.setLayout(new FlowLayout(FlowLayout.LEFT, 103, 85));
			JTextArea currentHPforCurrentHero = new JTextArea("" + model.getCurrentHero().getCurrentHP());
			currentHPforCurrentHero.setFont(new Font("Arial", Font.BOLD, 15));
			currentHPforCurrentHero.setForeground(Color.WHITE);
			currentHPforCurrentHero.setFocusable(false);
			currentHPforCurrentHero.setEditable(false);
			currentHPforCurrentHero.setOpaque(false);
			hunterHeroButton.add(currentHPforCurrentHero);
			mainView.getMiddleMiddleBottomHalf().add(hunterHeroButton);

		} else if (model.getCurrentHero() instanceof Paladin) {
			JButton paladinHeroButton = new JButton();
			paladinHeroButton.setActionCommand("currentHero");
			paladinHeroButton.setContentAreaFilled(false);
			paladinHeroButton.setBorderPainted(false);
			paladinHeroButton.setFocusable(false);
			paladinHeroButton.addActionListener(this);
			paladinHeroButton.setIcon(new ImageIcon("Images/Uther Lightbringer after 2.png"));
			paladinHeroButton.setPreferredSize(new Dimension(145, 145));
			paladinHeroButton.setLayout(new FlowLayout(FlowLayout.LEFT, 103, 85));
			JTextArea currentHPforCurrentHero = new JTextArea("" + model.getCurrentHero().getCurrentHP());
			currentHPforCurrentHero.setFont(new Font("Arial", Font.BOLD, 15));
			currentHPforCurrentHero.setForeground(Color.WHITE);
			currentHPforCurrentHero.setFocusable(false);
			currentHPforCurrentHero.setEditable(false);
			currentHPforCurrentHero.setOpaque(false);
			paladinHeroButton.add(currentHPforCurrentHero);
			mainView.getMiddleMiddleBottomHalf().add(paladinHeroButton);

		} else if (model.getCurrentHero() instanceof Priest) {
			JButton priestHeroButton = new JButton();
			priestHeroButton.setActionCommand("currentHero");
			priestHeroButton.setContentAreaFilled(false);
			priestHeroButton.setBorderPainted(false);
			priestHeroButton.setFocusable(false);
			priestHeroButton.addActionListener(this);
			priestHeroButton.setIcon(new ImageIcon("Images/Anduin Wrynn after 2.png"));
			priestHeroButton.setPreferredSize(new Dimension(145, 145));
			priestHeroButton.setLayout(new FlowLayout(FlowLayout.LEFT, 103, 85));
			JTextArea currentHPforCurrentHero = new JTextArea("" + model.getCurrentHero().getCurrentHP());
			currentHPforCurrentHero.setFont(new Font("Arial", Font.BOLD, 15));
			currentHPforCurrentHero.setForeground(Color.WHITE);
			currentHPforCurrentHero.setFocusable(false);
			currentHPforCurrentHero.setEditable(false);
			currentHPforCurrentHero.setOpaque(false);
			priestHeroButton.add(currentHPforCurrentHero);
			mainView.getMiddleMiddleBottomHalf().add(priestHeroButton);

		} else if (model.getCurrentHero() instanceof Warlock) {
			JButton warlockHeroButton = new JButton();
			warlockHeroButton.setActionCommand("currentHero");
			warlockHeroButton.setContentAreaFilled(false);
			warlockHeroButton.setBorderPainted(false);
			warlockHeroButton.setFocusable(false);
			warlockHeroButton.addActionListener(this);
			warlockHeroButton.setIcon(new ImageIcon("Images/Gul'dan after 2.png"));
			warlockHeroButton.setPreferredSize(new Dimension(145, 145));
			warlockHeroButton.setLayout(new FlowLayout(FlowLayout.LEFT, 103, 85));
			JTextArea currentHPforCurrentHero = new JTextArea("" + model.getCurrentHero().getCurrentHP());
			currentHPforCurrentHero.setFont(new Font("Arial", Font.BOLD, 15));
			currentHPforCurrentHero.setForeground(Color.WHITE);
			currentHPforCurrentHero.setFocusable(false);
			currentHPforCurrentHero.setEditable(false);
			currentHPforCurrentHero.setOpaque(false);
			warlockHeroButton.add(currentHPforCurrentHero);
			mainView.getMiddleMiddleBottomHalf().add(warlockHeroButton);
		}

		// ------------End of currentHero Button------------//

		// ------------Start of opponentHero Button------------//

		if (model.getOpponent() instanceof Mage) {
			JButton mageOpponentButton = new JButton();
			mageOpponentButton.setActionCommand("opponentHero");
			mageOpponentButton.setContentAreaFilled(false);
			mageOpponentButton.setBorderPainted(false);
			mageOpponentButton.setFocusable(false);
			mageOpponentButton.addActionListener(this);
			mageOpponentButton.setIcon(new ImageIcon("Images/Jaina_Proudmoore after 2.png"));
			mageOpponentButton.setPreferredSize(new Dimension(145, 155));
			mageOpponentButton.setLayout(new FlowLayout(FlowLayout.LEFT, 103, 88));
			JTextArea currentHPforOpponentHero = new JTextArea("" + model.getOpponent().getCurrentHP());
			currentHPforOpponentHero.setFont(new Font("Arial", Font.BOLD, 15));
			currentHPforOpponentHero.setForeground(Color.WHITE);
			currentHPforOpponentHero.setFocusable(false);
			currentHPforOpponentHero.setEditable(false);
			currentHPforOpponentHero.setOpaque(false);
			mageOpponentButton.add(currentHPforOpponentHero);
			mainView.getTopMiddleTopHalf().add(mageOpponentButton);

		} else if (model.getOpponent() instanceof Hunter) {
			JButton hunterOpponentButton = new JButton();
			hunterOpponentButton.setActionCommand("opponentHero");
			hunterOpponentButton.setContentAreaFilled(false);
			hunterOpponentButton.setBorderPainted(false);
			hunterOpponentButton.setFocusable(false);
			hunterOpponentButton.addActionListener(this);
			hunterOpponentButton.setIcon(new ImageIcon("Images/Rexxar after 2.png"));
			hunterOpponentButton.setPreferredSize(new Dimension(145, 155));
			hunterOpponentButton.setLayout(new FlowLayout(FlowLayout.LEFT, 103, 88));
			JTextArea currentHPforOpponentHero = new JTextArea("" + model.getOpponent().getCurrentHP());
			currentHPforOpponentHero.setFont(new Font("Arial", Font.BOLD, 15));
			currentHPforOpponentHero.setForeground(Color.WHITE);
			currentHPforOpponentHero.setFocusable(false);
			currentHPforOpponentHero.setEditable(false);
			currentHPforOpponentHero.setOpaque(false);
			hunterOpponentButton.add(currentHPforOpponentHero);
			mainView.getTopMiddleTopHalf().add(hunterOpponentButton);

		} else if (model.getOpponent() instanceof Paladin) {
			JButton paladinOpponentButton = new JButton();
			paladinOpponentButton.setActionCommand("opponentHero");
			paladinOpponentButton.setContentAreaFilled(false);
			paladinOpponentButton.setBorderPainted(false);
			paladinOpponentButton.setFocusable(false);
			paladinOpponentButton.addActionListener(this);
			paladinOpponentButton.setIcon(new ImageIcon("Images/Uther Lightbringer after 2.png"));
			paladinOpponentButton.setPreferredSize(new Dimension(145, 155));
			paladinOpponentButton.setLayout(new FlowLayout(FlowLayout.LEFT, 103, 88));
			JTextArea currentHPforOpponentHero = new JTextArea("" + model.getOpponent().getCurrentHP());
			currentHPforOpponentHero.setFont(new Font("Arial", Font.BOLD, 15));
			currentHPforOpponentHero.setForeground(Color.WHITE);
			currentHPforOpponentHero.setFocusable(false);
			currentHPforOpponentHero.setEditable(false);
			currentHPforOpponentHero.setOpaque(false);
			paladinOpponentButton.add(currentHPforOpponentHero);
			mainView.getTopMiddleTopHalf().add(paladinOpponentButton);

		} else if (model.getOpponent() instanceof Priest) {
			JButton priestOpponentButton = new JButton();
			priestOpponentButton.setActionCommand("opponentHero");
			priestOpponentButton.setContentAreaFilled(false);
			priestOpponentButton.setBorderPainted(false);
			priestOpponentButton.setFocusable(false);
			priestOpponentButton.addActionListener(this);
			priestOpponentButton.setIcon(new ImageIcon("Images/Anduin Wrynn after 2.png"));
			priestOpponentButton.setPreferredSize(new Dimension(145, 155));
			priestOpponentButton.setLayout(new FlowLayout(FlowLayout.LEFT, 103, 88));
			JTextArea currentHPforOpponentHero = new JTextArea("" + model.getOpponent().getCurrentHP());
			currentHPforOpponentHero.setFont(new Font("Arial", Font.BOLD, 15));
			currentHPforOpponentHero.setForeground(Color.WHITE);
			currentHPforOpponentHero.setFocusable(false);
			currentHPforOpponentHero.setEditable(false);
			currentHPforOpponentHero.setOpaque(false);
			priestOpponentButton.add(currentHPforOpponentHero);
			mainView.getTopMiddleTopHalf().add(priestOpponentButton);

		} else if (model.getOpponent() instanceof Warlock) {
			JButton warlockOpponentButton = new JButton();
			warlockOpponentButton.setActionCommand("opponentHero");
			warlockOpponentButton.setContentAreaFilled(false);
			warlockOpponentButton.setBorderPainted(false);
			warlockOpponentButton.setFocusable(false);
			warlockOpponentButton.addActionListener(this);
			warlockOpponentButton.setIcon(new ImageIcon("Images/Gul'dan after 2.png"));
			warlockOpponentButton.setPreferredSize(new Dimension(145, 155));
			warlockOpponentButton.setLayout(new FlowLayout(FlowLayout.LEFT, 103, 88));
			JTextArea currentHPforOpponentHero = new JTextArea("" + model.getOpponent().getCurrentHP());
			currentHPforOpponentHero.setFont(new Font("Arial", Font.BOLD, 15));
			currentHPforOpponentHero.setForeground(Color.WHITE);
			currentHPforOpponentHero.setFocusable(false);
			currentHPforOpponentHero.setEditable(false);
			currentHPforOpponentHero.setOpaque(false);
			warlockOpponentButton.add(currentHPforOpponentHero);
			mainView.getTopMiddleTopHalf().add(warlockOpponentButton);
		}

		// ------------End of opponentHero Button------------//

		// ------------Start of Opponent's Number of cards in Deck------------//

		JTextArea oppNoOfCardsInDeck = new JTextArea(" " + model.getOpponent().getDeck().size() + " ");
		oppNoOfCardsInDeck.setFont(new Font("Arial", Font.BOLD, 25));
		oppNoOfCardsInDeck.setForeground(Color.WHITE);
		oppNoOfCardsInDeck.setEditable(false);
		oppNoOfCardsInDeck.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
		oppNoOfCardsInDeck.setOpaque(false);
		mainView.getTopRightHandSide().add(oppNoOfCardsInDeck);
		// ------------End of Opponent's Number of cards in Deck------------//

		// ------------Start of CurrentHero's Number of cards in Deck------------//

		JTextArea currNoOfCardsInDeck = new JTextArea(" " + model.getCurrentHero().getDeck().size() + " ");
		currNoOfCardsInDeck.setFont(new Font("Arial", Font.BOLD, 25));
		currNoOfCardsInDeck.setForeground(Color.WHITE);
		currNoOfCardsInDeck.setEditable(false);
		currNoOfCardsInDeck.setOpaque(false);
		currNoOfCardsInDeck.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
		mainView.getBottomRightHandSide().add(currNoOfCardsInDeck);

		// ------------End of CurrentHero's Number of cards in Deck------------//

		// ------------Start of Opponent's number of cards in Hand------------//

		JTextArea noOfCardsInHand = new JTextArea("" + model.getOpponent().getHand().size());
		noOfCardsInHand.setEditable(false);
		noOfCardsInHand.setOpaque(false);
		noOfCardsInHand.setFocusable(false);
		noOfCardsInHand.setForeground(Color.WHITE);
		noOfCardsInHand.setFont(new Font("Arial", Font.BOLD, 14));
		mainView.getMiddleTopTopHalf().add(noOfCardsInHand);

		// ------------End of Opponent's number of cards in Hand------------//

		// ------------Start of Opponent's number of Current Mana Crystals------------//

		JTextArea currentManaCrystals = new JTextArea("" + model.getOpponent().getCurrentManaCrystals());
		currentManaCrystals.setEditable(false);
		currentManaCrystals.setOpaque(false);
		currentManaCrystals.setFocusable(false);
		currentManaCrystals.setForeground(Color.WHITE);
		currentManaCrystals.setFont(new Font("Arial", Font.BOLD, 14));
		mainView.getWestTopTopHalf().add(currentManaCrystals);

		// ------------End of Opponent's number of Current Mana Crystals------------//

		// ------------Start of Opponent's number of Total Mana Crystals------------//

		JTextArea opponentTotalManaCrystals = new JTextArea("" + model.getOpponent().getTotalManaCrystals());
		opponentTotalManaCrystals.setEditable(false);
		opponentTotalManaCrystals.setOpaque(false);
		opponentTotalManaCrystals.setFocusable(false);
		opponentTotalManaCrystals.setForeground(Color.WHITE);
		opponentTotalManaCrystals.setFont(new Font("Arial", Font.BOLD, 14));
		mainView.getEastTopTopHalf().add(opponentTotalManaCrystals);

		// ------------End of Opponent's number of Total Mana Crystals------------//

		// ------------Start of CurrentHero's number of Current Mana
		// Crystals------------//

		JTextArea currentManaCrystalsForCurrentHero = new JTextArea(
				"" + model.getCurrentHero().getCurrentManaCrystals());
		currentManaCrystalsForCurrentHero.setEditable(false);
		currentManaCrystalsForCurrentHero.setOpaque(false);
		currentManaCrystalsForCurrentHero.setFocusable(false);
		currentManaCrystalsForCurrentHero.setForeground(Color.WHITE);
		currentManaCrystalsForCurrentHero.setFont(new Font("Arial", Font.BOLD, 14));
		mainView.getWestMiddleBottomHalf().add(currentManaCrystalsForCurrentHero);

		// ------------End ofCurrentHero's number of Current Mana Crystals------------//

		// ------------Start of CurrentHero's number of Total Mana
		// Crystals------------//

		JTextArea totalManaCrystalsForCurrentHero = new JTextArea("" + model.getCurrentHero().getTotalManaCrystals());
		totalManaCrystalsForCurrentHero.setEditable(false);
		totalManaCrystalsForCurrentHero.setOpaque(false);
		totalManaCrystalsForCurrentHero.setFocusable(false);
		totalManaCrystalsForCurrentHero.setForeground(Color.WHITE);
		totalManaCrystalsForCurrentHero.setFont(new Font("Arial", Font.BOLD, 14));
		mainView.getEastMiddleBottomHalf().add(totalManaCrystalsForCurrentHero);

		// ------------End ofCurrentHero's number of Total Mana Crystals------------//

		
		// ------------Start of Use Hero Power Button------------//
		JButton useHeroPower = new JButton();
		useHeroPower.setActionCommand("Use Hero Power");
		
		useHeroPower.setContentAreaFilled(false);
		useHeroPower.setOpaque(false);
		useHeroPower.setFocusPainted(false);
		useHeroPower.setBorderPainted(false);
		useHeroPower.setPreferredSize(new Dimension(150, 38));
		useHeroPower.setIcon(new ImageIcon("Images/useHeroPowerDefault1.png"));
		useHeroPower.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				useHeroPower.setIcon(new ImageIcon("Images/useHeroPowerHover1.png"));
			}

			public void mousePressed(MouseEvent e) {
				useHeroPower.setIcon(new ImageIcon("Images/useHeroPowerPressed1.png"));
			}

			public void mouseReleased(MouseEvent e) {
				useHeroPower.setIcon(new ImageIcon("Images/useHeroPowerReleased1.png"));
			}

			public void mouseExited(MouseEvent e) {
				useHeroPower.setIcon(new ImageIcon("Images/useHeroPowerDefault1.png"));
			}
		});
		
		
		
		
		
		useHeroPower.addActionListener(this);
		mainView.getLeftHandSide().add(useHeroPower);

		currentScreen.setContentPane(mainView.getContentPane());
		currentScreen.add(mainView.getLeftHandSide(), BorderLayout.WEST);
		currentScreen.add(mainView.getRightHandSide(), BorderLayout.EAST);
		currentScreen.add(mainView.getMiddle(), BorderLayout.CENTER);
//		currentScreen.add(mainView.getBottomTopHalf());
		
		// ------------End of Use Hero Power Button------------//

		// ------------Start of CurrentHero's Hand------------//

		cardsInHand.removeAll(cardsInHand);

		for (int i = 0; i < model.getCurrentHero().getHand().size(); i++) {
			String details = model.getCurrentHero().getHand().get(i).toString();
			cardInHand = new JButton();
			cardInHand.setIcon(new ImageIcon("Images/Card.jpg"));

			cardInHand.setText("<html>" + details.replaceAll("\\n", "<br>") + "</html>");
			cardInHand.setFont(new Font("Arial", Font.PLAIN, 8));
			cardInHand.setActionCommand("cardInHand");
			cardInHand.setFocusable(false);
			cardInHand.addActionListener(this);
			cardInHand.setOpaque(true);
			cardInHand.setHorizontalTextPosition(JButton.CENTER);
			cardInHand.setVerticalTextPosition(JButton.CENTER);
			cardsInHand.add(cardInHand);
			mainView.getHandCards().add(cardInHand);
		}

		for (int j = model.getCurrentHero().getHand().size(); j < 10; j++) {
			blank = new JTextArea("");
			blank.setOpaque(false);
			blank.setEditable(false);
			mainView.getHandCards().add(blank);

		}

		// ------------End of CurrentHero's Hand------------//

		blank = new JTextArea("");
		blank.setOpaque(false);
		blank.setEditable(false);
		mainView.getTopBottomHalf().add(blank);

		cardsOnField.removeAll(cardsOnField);

		for (int b = 0; b < model.getCurrentHero().getField().size(); b++) {

//		JTextArea detailsForField = new JTextArea("" + model.getCurrentHero().getField().get(b).toStringForField());
//		detailsForField.setFont(new Font("Arial", Font.PLAIN, 7));
//		detailsForField.setEditable(false);
//		detailsForField.setOpaque(false);
//		detailsForField.setFocusable(false);
			String detailsOfField = model.getCurrentHero().getField().get(b).toStringForField();
			cardOnField = new JButton();
			cardOnField.setIcon(new ImageIcon("Images/Card.jpg"));
			cardOnField.setText("<html>" + detailsOfField.replaceAll("\\n", "<br>") + "</html>");
			cardOnField.setFont(new Font("Arial", Font.PLAIN, 7));
			cardOnField.setActionCommand("cardOnField");
			cardOnField.setFocusable(false);
			cardOnField.addActionListener(this);
			cardOnField.setOpaque(true);
			cardOnField.setHorizontalTextPosition(JButton.CENTER);
			cardOnField.setVerticalTextPosition(JButton.CENTER);
//		cardOnField.add(detailsForField);
			cardOnField.addActionListener(this);
			cardOnField.setActionCommand("cardOnField");
			cardsOnField.add(cardOnField);
			mainView.getTopBottomHalf().add(cardOnField);
		}

		for (int k = model.getCurrentHero().getField().size(); k < 9; k++) {
			blank = new JTextArea("");
			blank.setOpaque(false);
			blank.setEditable(false);
			mainView.getTopBottomHalf().add(blank);

		}

//		blank = new JTextArea("");
//		blank.setOpaque(false);
//		blank.setEditable(false);
//		mainView.getTopBottomHalf().add(blank);

		// ------------Start of Opponent's Field------------//

		blankForOpponentField = new JTextArea("");
		blankForOpponentField.setOpaque(false);
		blankForOpponentField.setEditable(false);
		mainView.getBottomMiddleTopHalf().add(blankForOpponentField);

		cardsOnOpponentField.removeAll(cardsOnOpponentField);

		for (int c = 0; c < model.getOpponent().getField().size(); c++) {

			String detailsForOpponentField = model.getOpponent().getField().get(c).toStringForField();
//		detailsForOpponentField.setFont(new Font("Arial", Font.PLAIN, 9));
//		detailsForOpponentField.setEditable(false);
//		detailsForOpponentField.setOpaque(false);
//		detailsForOpponentField.setFocusable(false);
			cardOnOpponentField = new JButton();
			cardOnOpponentField.setIcon(new ImageIcon("Images/Card.jpg"));
			cardOnOpponentField.setText("<html>" + detailsForOpponentField.replaceAll("\\n", "<br>") + "</html>");
			cardOnOpponentField.setFont(new Font("Arial", Font.PLAIN, 7));
			cardOnOpponentField.setActionCommand("cardOnField");
			cardOnOpponentField.setFocusable(false);
			cardOnOpponentField.addActionListener(this);
			cardOnOpponentField.setOpaque(true);
			cardOnOpponentField.setHorizontalTextPosition(JButton.CENTER);
			cardOnOpponentField.setVerticalTextPosition(JButton.CENTER);
			cardOnOpponentField.addActionListener(this);
			cardOnOpponentField.setActionCommand("cardOnOpponentField");
			cardsOnOpponentField.add(cardOnOpponentField);
			mainView.getBottomMiddleTopHalf().add(cardOnOpponentField);
		}

		for (int v = model.getOpponent().getField().size(); v < 9; v++) {
			blankForOpponentField = new JTextArea("");
			blankForOpponentField.setOpaque(false);
			blankForOpponentField.setEditable(false);
			mainView.getBottomMiddleTopHalf().add(blankForOpponentField);

		}

//		blankForOpponentField = new JTextArea("");
//		blankForOpponentField.setOpaque(false);
//		blankForOpponentField.setEditable(false);
//		mainView.getTopBottomHalf().add(blankForOpponentField);

		// ------------End of Opponent's Field------------//

		currentScreen.revalidate();
		currentScreen.repaint();

	}

	public void onGameOver() {
		if (model.getCurrentHero().getCurrentHP() <= 0) {
			JOptionPane.showMessageDialog(currentScreen,
					"Game Over: " + model.getOpponent().getName() + " is the winner!!");

		} else if (model.getOpponent().getCurrentHP() <= 0) {
			JOptionPane.showMessageDialog(currentScreen,
					"Game Over: " + model.getCurrentHero().getName() + " is the winner!!");

		}

		currentScreen.dispose();
		new Controller();
	}

	public static void main(String[] args) {
		new Controller();
	}

}
