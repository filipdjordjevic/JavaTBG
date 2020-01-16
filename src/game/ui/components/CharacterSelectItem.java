package game.ui.components;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.LayoutStyle.ComponentPlacement;

public class CharacterSelectItem extends JPanel {

	/**
	 * Create the panel.
	 */
	public CharacterSelectItem(String name) {
		this.setPreferredSize(new Dimension(150, 100));
		JLabel lblName = new JLabel(name);
		
		JLabel lblImage = new JLabel("");
		
		final ImageIcon image = new ImageIcon(CharacterSelectItem.class.getResource(String.format("/assets/%s.jpg", name.toLowerCase())));
		
		lblImage.setIcon(image);
		lblImage.setBackground(new Color(240, 240, 240));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblImage, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblName)
					.addContainerGap(340, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblImage, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(27)
							.addComponent(lblName)))
					.addContainerGap(241, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}
