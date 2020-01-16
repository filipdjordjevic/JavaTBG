package game.ui.screens;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import game.common.exceptions.InvalidEnemyNumberException;
import game.entity.creatures.BasicEnemy;
import game.entity.creatures.CreatureBase;
import game.entity.creatures.HeroBase;
import game.logic.gamestate.CombatManager;
import game.ui.components.CreatureDisplay;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import java.awt.Font;

public class CombatScreen extends JFrame {

	private JPanel contentPane;
	private CombatManager combatManager;
	private JPanel panelControls;
	private ButtonGroup targetButtons;

	/**
	 * Create the frame.
	 */
	public CombatScreen(HeroBase hero) {
		
		this.combatManager = new CombatManager(hero);
		this.targetButtons = new ButtonGroup();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JPanel panelEnemies = new JPanel();
		
		this.displayEnemies(panelEnemies, this.generateEnemiesDisplay(this.combatManager.getEnemies() ));
		
		JPanel panelHero = new JPanel();
		
		panelHero.add(new CreatureDisplay(this.combatManager.getHero() ));
		panelControls = new JPanel();
		panelControls.setLayout(null);
		
		JButton btnAttack = new JButton("Attack");
		btnAttack.setActionCommand("Attack");
		btnAttack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		btnAttack.setBounds(0, 11, 80, 23);
		panelControls.add(btnAttack);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 0, 0);
		panelControls.add(label);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		
		JTextArea textOutput = new JTextArea();
		textOutput.setFont(new Font("Calibri", Font.PLAIN, 12));
		textOutput.setTabSize(6);
		scrollPane.setViewportView(textOutput);
		textOutput.setEditable(false);
		textOutput.setText(this.combatManager.getInitiativeInfo());
		contentPane.add(panelHero);
		contentPane.add(panelControls);
		contentPane.add(panelEnemies);
		panelEnemies.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	
		btnAttack.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		        textOutput.setText(CombatScreen.this.combatManager.playNextTurn(CombatScreen.this.getTarget() ) );
		        CombatScreen.this.updateUI(panelHero, panelEnemies);
		        if(CombatScreen.this.combatManager.checkCombatStatus() == 1) {
		        	setVisible(false);
		        	dispose();
		        }
		    }
		});
		
	}
	
	private List<CreatureDisplay> generateEnemiesDisplay(List<CreatureBase> enemies) {
		List<CreatureDisplay> displayEnemies = new ArrayList<CreatureDisplay>();
		for (CreatureBase enemy : enemies) {
			displayEnemies.add(new CreatureDisplay(enemy));
		}
		
		return displayEnemies;
	}
	
	private void displayEnemies(JPanel panel, List<CreatureDisplay> enemiesDisplay) {
		for (CreatureDisplay display : enemiesDisplay ) {
			panel.add(display);
			JRadioButton btn = new JRadioButton("");
			this.targetButtons.add(btn);
			panel.add(btn);
			
		}
		}
	
	private int getTarget() {
		Enumeration<AbstractButton> buttons = this.targetButtons.getElements();
		for(int i = 0; i < this.targetButtons.getButtonCount(); ++i ) {
			AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return i;
            }
		}
		return 0;

	}
	
	private void updateUI(JPanel panelHero, JPanel panelEnemies) {
		 panelHero.removeAll();
	        panelHero.add(new CreatureDisplay(this.combatManager.getHero() ));
	        panelHero.updateUI();
	        panelEnemies.removeAll();
	        this.targetButtons = new ButtonGroup();
	        this.displayEnemies(
	        		panelEnemies,
	        		this.generateEnemiesDisplay(this.combatManager.getEnemies() )
	        		);
	        panelEnemies.updateUI();
	}


}
