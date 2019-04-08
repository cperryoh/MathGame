package MathGame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.border.EmptyBorder;

public class Log {

	private JFrame frame;
	JTextArea logBox = new JTextArea();
	private final Action action = new SwingAction();
	JScrollPane scrollPane = new JScrollPane();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Log window = new Log();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Log() {
		initialize();
		frame.setResizable(false);
		
		JButton btnNewButton = new JButton("Clear");
		btnNewButton.setAction(action);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds((frame.getWidth()/2)-(79/2),0, 79, 23);
		frame.getContentPane().add(btnNewButton);
		logBox.setBorder(new EmptyBorder(0, 0, 0, 0));
		logBox.setEditable(false);
		logBox.setFont(new Font("Consolas", Font.PLAIN, 13));

	}
	JFrame getFrame() {
		return frame;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 422, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		scrollPane.setBounds(0, 0, 415, 260);
		frame.getContentPane().add(scrollPane);
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setAutoscrolls(true);
		
		scrollPane.setViewportView(logBox);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Clear");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			logBox.setText("");
			scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
		}
		
	}
}
