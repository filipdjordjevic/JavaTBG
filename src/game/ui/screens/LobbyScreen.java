package game.ui.screens;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import game.entity.creatures.HeroBase;
import game.ui.components.CharacterInfo;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;

public class LobbyScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public LobbyScreen(HeroBase hero) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		CharacterInfo panelHeroInfo = new CharacterInfo(hero); 
		contentPane.add(panelHeroInfo);
		
		JButton btnBattle = new JButton("Battle");
		
		contentPane.add(btnBattle);
		
		btnBattle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CombatScreen screen = new CombatScreen(hero);
				screen.setVisible(true);
				LobbyScreen.this.setVisible(false);
			}
		});
	}

}
