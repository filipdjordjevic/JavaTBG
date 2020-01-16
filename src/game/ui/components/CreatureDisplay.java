package game.ui.components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.entity.creatures.CreatureBase;
import javax.swing.JProgressBar;
import java.awt.Color;
import java.awt.Dimension;

public class CreatureDisplay extends JPanel {

	/**
	 * Create the panel.
	 */
	public CreatureDisplay(CreatureBase creature) {
		this.setPreferredSize(new Dimension(100, 150));
		final String name = creature.getName();
		final int maxHp = creature.getMaxHp();
		
		setLayout(null);
		
		JLabel lblName = new JLabel(name);
		lblName.setBounds(37, 11, 73, 14);
		add(lblName);
		JLabel lblImage = new JLabel("");
		lblImage.setBounds(37, 78, 46, 61);
		add(lblImage);
		
		final ImageIcon image = new ImageIcon(CreatureDisplay.class.getResource(String.format("/assets/%s.jpg", name.toLowerCase() )));
		
		lblImage.setIcon(image);
		
		JLabel lblLevel = new JLabel("lvl " + creature.getLevel());
		lblLevel.setBounds(10, 11, 46, 14);
		add(lblLevel);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setForeground(Color.RED);
		progressBar.setMaximum(maxHp);
		progressBar.setBounds(10, 36, 100, 6);
		progressBar.setValue(creature.getHp());
		add(progressBar);
		
		JLabel lblNewLabel = new JLabel(String.format("%s / %s", creature.getHp(), maxHp));
		lblNewLabel.setBounds(47, 53, 63, 14);
		add(lblNewLabel);
	}
}
