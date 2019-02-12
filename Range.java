 package MathGame;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JTextField;
import java.awt.Label;
import java.awt.Font;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class Range {

	private JFrame frame;
	private mainGame main;
	private JTextField bottomNum;
	private final Action action = new SwingAction();
	private JTextField topNum;
	JButton EnterRangeBttn = new JButton("Enter");
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 */
	public Range(mainGame main) {
		this.main=main;
		frame = new JFrame();
		frame.setTitle("Set range");
		frame.setBounds(100, 100, 295, 191);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(false);
		frame.setDefaultCloseOperation(1);
		frame.getContentPane().setLayout(null);
		
		EnterRangeBttn.setAction(action);
		EnterRangeBttn.setBounds(100, 92, 89, 23);
		frame.getContentPane().add(EnterRangeBttn);
		
		bottomNum = new JTextField();
		bottomNum.setBounds(10, 31, 86, 20);
		frame.getContentPane().add(bottomNum);
		bottomNum.setColumns(10);
		
		topNum = new JTextField();
		topNum.addKeyListener(new MKeyListener());
		topNum.setBounds(183, 31, 86, 20);
		frame.getContentPane().add(topNum);
		topNum.setColumns(10);
		
		Label label = new Label("to");
		label.setFont(new Font("Dialog", Font.PLAIN, 13));
		label.setAlignment(Label.CENTER);
		label.setBounds(112, 31, 62, 22);
		frame.getContentPane().add(label);
	}
	JFrame getFrame() {
		return frame;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize(mainGame m) {;
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Enter");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			try {
			main.setRange(Integer.parseInt(bottomNum.getText()), Integer.parseInt(topNum.getText()));
			}
			catch (NumberFormatException e1) {
				bottomNum.setText("");
				topNum.setText("");
			}
		}
	}
	class MKeyListener extends KeyAdapter {
        public void keyPressed(KeyEvent event) {
            if (event.getKeyCode() == KeyEvent.VK_ENTER) {
            		try {
            			main.setRange(Integer.parseInt(bottomNum.getText()), Integer.parseInt(topNum.getText()));
        			}
        			catch (NumberFormatException e1) {
        				bottomNum.setText("");
        				topNum.setText("");
        			}
            }
        }
    }
}
