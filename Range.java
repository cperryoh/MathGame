package MathGame;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import java.awt.Label;
import java.awt.Font;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JPanel;

public class Range {

	private JFrame frame;
	private mainGame main;
	public JTextField bottomNum;
	private final Action action = new SwingAction();
	private JTextField topNum;
	Color startColor;
	JButton EnterRangeBttn = new JButton("Enter");

	public Label label = new Label("to");
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
		
		startColor = main.getFrame().getContentPane().getBackground();
		EnterRangeBttn.setAction(action);
		EnterRangeBttn.setBounds(100, 92, 89, 23);
		frame.getContentPane().add(EnterRangeBttn);
		
		label.setFont(new Font("Dialog", Font.PLAIN, 13));
		label.setAlignment(Label.CENTER);
		label.setBounds(125, 31, 38, 22);
		frame.getContentPane().add(label);
		
		bottomNum = new JTextField();
		bottomNum.setBounds(10, 31, 109, 20);
		frame.getContentPane().add(bottomNum);
		bottomNum.setColumns(10);
		
		topNum = new JTextField();
		main.createTooltip(topNum, "Top of range");
		main.createTooltip(bottomNum, "Bottom of range");
		topNum.addKeyListener(new MKeyListener());
		bottomNum.addKeyListener(new MKeyListener());
		topNum.setBounds(169, 31, 110, 20);
		frame.getContentPane().add(topNum);
		topNum.setColumns(10);
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
    		main.setColors(startColor); 
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
            		main.setColors(startColor);
            		
            }
            else if(event.getKeyCode() == KeyEvent.VK_ESCAPE) {
            	main.ans.requestFocus(true);
            	frame.setVisible(false);
            }
        }
		@Override
		 public void keyTyped(KeyEvent e) {
            if (!Character.isDigit(e.getKeyChar())&&e.getKeyCode()!=KeyEvent.VK_ENTER) {
                e.consume();
                
            }
           
        }
    }
}
