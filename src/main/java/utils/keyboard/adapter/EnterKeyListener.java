package utils.keyboard.adapter;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;

import javax.swing.JTextField;

import controllers.IController;
import utils.NumberUtils;

public class EnterKeyListener implements KeyListener {
		
	private final IController controller;
	private final JTextField field;
	private final JTextField target;
	
	public EnterKeyListener(JTextField field, JTextField target, IController controller) {
		this.field = field;
		this.target = target;
		this.controller = controller;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() != KeyEvent.VK_ENTER) {
			this.target.setText("");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			try {
				if (NumberUtils.isNumeric(this.field.getText())) {
					this.target.setText(controller.getEnterValue(this.field.getText()));
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}