package game.ui.screens;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import game.data.DataQuery;
import game.ui.components.CharacterSelectItem;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import java.awt.GridLayout;



public class CharacterSelectionScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public CharacterSelectionScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton startButton = new JButton("START");
		
		JPanel panelHeroes = new JPanel();
		contentPane.add(panelHeroes);
		panelHeroes.setLayout(new GridLayout(0, 2, 0, 0));
		
		CharacterSelectItem warriorSelect = new CharacterSelectItem("warrior");
		panelHeroes.add(warriorSelect);
		
		JRadioButton rdbtnWarrior = new JRadioButton("");
		panelHeroes.add(rdbtnWarrior);
		CharacterSelectItem archerSelect = new CharacterSelectItem("archer");
		panelHeroes.add(archerSelect);
		
		JRadioButton rdbtnArcher = new JRadioButton("");
		panelHeroes.add(rdbtnArcher);
		CharacterSelectItem mageSelect = new CharacterSelectItem("mage");
		panelHeroes.add(mageSelect);
		
		JRadioButton rdbtnMage = new JRadioButton("");
		panelHeroes.add(rdbtnMage);
		contentPane.add(startButton);
		
		ButtonGroup radioSelect = new ButtonGroup();
		radioSelect.add(rdbtnWarrior);
		radioSelect.add(rdbtnArcher);
		radioSelect.add(rdbtnMage);
		
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnWarrior.isSelected() ) {
					LobbyScreen screen = new LobbyScreen(DataQuery.getHero("Warrior"));
					screen.setVisible(true);
					CharacterSelectionScreen.this.setVisible(false);
				}
				else if(rdbtnArcher.isSelected() ) {
					LobbyScreen screen = new LobbyScreen(DataQuery.getHero("Archer"));
					screen.setVisible(true);
					CharacterSelectionScreen.this.setVisible(false);
				}
				else if(rdbtnMage.isSelected() ) {
					LobbyScreen screen = new LobbyScreen(DataQuery.getHero("Mage"));
					screen.setVisible(true);
					CharacterSelectionScreen.this.setVisible(false);
				}
				
			}
		});
	}

}
