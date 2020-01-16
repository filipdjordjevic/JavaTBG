package game.ui.components;

import javax.swing.JPanel;

import game.entity.creatures.HeroBase;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CharacterInfo extends JPanel {

	/**
	 * Create the panel.
	 */
	public CharacterInfo(HeroBase hero) {
		setLayout(null);
		
		JLabel lblLevel = new JLabel("Level: " + hero.getLevel());
		lblLevel.setBounds(10, 11, 100, 14);
		add(lblLevel);
		
		JLabel lblMaxHp = new JLabel("Hp: " + hero.getMaxHp());
		lblMaxHp.setBounds(10, 36, 100, 14);
		add(lblMaxHp);
		
		JLabel lblStrength = new JLabel("Strenght: " + hero.getStrength());
		lblStrength.setBounds(10, 61, 100, 14);
		add(lblStrength);
		
		JLabel lblDexterity = new JLabel("Dexterity: " + hero.getDexterity());
		lblDexterity.setBounds(10, 86, 100, 14);
		add(lblDexterity);
		
		JLabel lblConstitution = new JLabel("Constitution: " + hero.getConstitution());
		lblConstitution.setBounds(10, 111, 100, 14);
		add(lblConstitution);
		
		JLabel lblWisdom = new JLabel("Wisdom: " + hero.getWisdom());
		lblWisdom.setBounds(10, 136, 100, 14);
		add(lblWisdom);
		
		JLabel lblIntelligence = new JLabel("Intelligence: " + hero.getIntelligence());
		lblIntelligence.setBounds(10, 161, 100, 14);
		add(lblIntelligence);
		
		JLabel lblCharisma = new JLabel("Charisma: " + hero.getCharisma());
		lblCharisma.setBounds(10, 186, 100, 14);
		add(lblCharisma);
		
		final ImageIcon image = new ImageIcon(CreatureDisplay.class.getResource(String.format("/assets/%s.jpg", hero.getName().toLowerCase() )));
		
		JLabel lblImage = new JLabel("");
		lblImage.setBounds(144, 11, 46, 64);
		lblImage.setIcon(image);
		add(lblImage);
		
	}
}
