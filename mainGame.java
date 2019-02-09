package MathGame;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
public class mainGame {
    boolean currentOp = true;
    JLabel Question = new JLabel("8x+8");
    JMenuItem mntmMultiply = new JMenuItem("multiply");
    private static JFrame frame;
    int  total;
    static OperationEnum OPS = new OperationEnum(OperationEnum.operations.add);
    int FirstNum, SecondNum,ThirdNum, FourthNum= 0;
    private JTextField ans;
    public static int max=12;
    public static int min=2;
    JLabel SolveForX = new JLabel("Solve for x");
    public static mainGame m;
    public static Range r;
    JMenuItem mntmSubtract = new JMenuItem("subtract");
    JLabel results;
    private final Action add = new additon();
    private final JMenuItem mntmAdd = new JMenuItem("add");
    private final Action subtract = new subtraction();
    private final Action multiply = new multiply();
    private final Action rangeButton = new range();
    private final Action Alge = new Algebra();
    private final Action division = new Divisiom();
    private final Action exeponents = new Exponents();
    /**
     * Launch the application.
     */
    public void setRange(int min, int max) {
    	this.min=min;
    	this.max=max;
    	Practice();
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    mainGame window = new mainGame();
                    r=new Range(window);
                    mainGame.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    /**
     * Create the application.
     */
    public mainGame() {
    	initialize();
    }
    /**
     * Initialize the contents of the frame.
     */

    //checks if the user answer is correct
    boolean checkIfCorrect() {
        if (!ans.getText().equals("")) 
        {
            if (OPS.GetEnum()==OperationEnum.operations.add) 
            {
            	return FirstNum + SecondNum == Integer.parseInt(ans.getText());
            }
            else if(OPS.GetEnum()==OperationEnum.operations.subtract)
            {
            	return FirstNum - SecondNum == Integer.parseInt(ans.getText());
            }
            else if(OPS.GetEnum()==OperationEnum.operations.Algebra) {
            	return Integer.parseInt(ans.getText())==((total+(-FirstNum))/SecondNum);
            }
            else if(OPS.GetEnum()==OperationEnum.operations.division) {
            	return FirstNum/Integer.parseInt(ans.getText())==SecondNum;
            }
            else if(OPS.GetEnum()==OperationEnum.operations.exponents) {
            	return (int)Math.pow(FirstNum, 2)==Integer.parseInt(ans.getText());
            }
            else
            {
            	return FirstNum * SecondNum == Integer.parseInt(ans.getText());
            }
        } 
        else 
        {
            return false;
        }
    }
    //key lisenter
    class MKeyListener extends KeyAdapter {
        public void keyPressed(KeyEvent event) {
            if (event.getKeyCode() == KeyEvent.VK_ENTER)
            {
            	printMsg();
            }
        }
    }
    void printMsg() {
    	String msg = "";
    	if (checkIfCorrect()) {
            msg = "Correct!";
        } 
    	else {
        	if(OPS.GetEnum()==OperationEnum.operations.add) {
        		msg="Incorrect "+FirstNum+" + "+SecondNum+" is "+(FirstNum+SecondNum);
        	}
        	else if(OPS.GetEnum()==OperationEnum.operations.multiply) {
        		msg="Incorrect "+FirstNum+" * "+SecondNum+" is "+(FirstNum*SecondNum);
        	}
        	else if(OPS.GetEnum()==OperationEnum.operations.Algebra) {
        		msg="Incorrect x is "+Integer.toString((total+(-FirstNum))/SecondNum);
        	}
        	else if(OPS.GetEnum()==OperationEnum.operations.division) {
        		msg="Incorrect "+FirstNum+" ÷ "+SecondNum+" is "+Integer.toString(FirstNum/SecondNum);
        	}

        	else if(OPS.GetEnum()==OperationEnum.operations.exponents) {
        		msg="Incorrect "+FirstNum+" to the power of two is "+Integer.toString((int)Math.pow(FirstNum, 2));
        	}
        	else {
        		msg="Incorrect "+FirstNum+" - "+SecondNum+" is "+(FirstNum-SecondNum);
        	}
        }
    	results.setText(msg);
        Practice();
        ans.setText("");
        ans.requestFocus();
    }
    //sets up for ans
    public void Practice() {
        Random rand = new Random();
    	FirstNum = rand.nextInt(max-min+1) +min;
        SecondNum = rand.nextInt(max-min+1) +min;
    	if(OPS.GetEnum()!=OperationEnum.operations.Algebra) {
    		if(OPS.GetEnum()==OperationEnum.operations.add) {
    			Question.setText(FirstNum+" + "+SecondNum+"=");
    		}
    		else if(OPS.GetEnum()==OperationEnum.operations.multiply) {
    			Question.setText(FirstNum+" * "+SecondNum+"=");
    		}
    		else if(OPS.GetEnum()==OperationEnum.operations.division) {
    			ThirdNum = rand.nextInt(max-min+1) +min;
    			FirstNum=ThirdNum*SecondNum;
    			Question.setText(FirstNum+" ÷ "+SecondNum+"=");
    		}
    		else if(OPS.GetEnum()==OperationEnum.operations.exponents) {
    			Question.setText(FirstNum+"^2  =");
    		}
    		else {
    			Question.setText(FirstNum+" - "+SecondNum+"=");
    		}
    		SolveForX.setVisible(false);
    	}
    	else {
    		ThirdNum=rand.nextInt(max-min+1) +min;
    		total=(FirstNum+(SecondNum*ThirdNum));
    		Question.setText(FirstNum+"+"+SecondNum+"x="+total+"     x=");
    		SolveForX.setVisible(true);
    	}
    }
    //initializes the window
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);

        ans = new JTextField();
        ans.setBounds(235, 79, 133, 36);
        ans.addKeyListener(new MKeyListener());
        ans.setFont(new Font("Tahoma", Font.PLAIN, 30));
        ans.setToolTipText("");
        ans.setHorizontalAlignment(SwingConstants.CENTER);
        ans.setColumns(10);

        results = new JLabel("");
        results.setBounds(0, 180, 444, 47);
        results.setFont(new Font("Tahoma", Font.PLAIN, 30));
        results.setHorizontalAlignment(SwingConstants.CENTER);
        SolveForX.setBounds(0, 26, 444, 37);
        
        
        SolveForX.setEnabled(true);
        SolveForX.setHorizontalAlignment(SwingConstants.CENTER);
        SolveForX.setFont(new Font("Tahoma", Font.PLAIN, 25));
        Question.setBounds(2, 81, 223, 37);
        
        
        Question.setFont(new Font("Tahoma", Font.PLAIN, 25));
        Question.setHorizontalAlignment(SwingConstants.TRAILING);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().add(ans);
        frame.getContentPane().add(results);
        frame.getContentPane().add(SolveForX);
        frame.getContentPane().add(Question);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        
        Component horizontalStrut_1 = Box.createHorizontalStrut(27);
        menuBar.add(horizontalStrut_1);
        
        JMenu mnNewMenu = new JMenu("Practice");
        mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        menuBar.add(mnNewMenu);
        mntmAdd.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        mntmAdd.setAction(add);
        mnNewMenu.add(mntmAdd);
        mntmSubtract.setFont(new Font("Segoe UI", Font.PLAIN, 20));

        
        mntmSubtract.setAction(subtract);
        mnNewMenu.add(mntmSubtract);
        mntmMultiply.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        
        mntmMultiply.setAction(multiply);
        
        
        mnNewMenu.add(mntmMultiply);
        
        JMenuItem mntmDivision = new JMenuItem("Division");
        mntmDivision.setAction(division);
        mntmDivision.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        mnNewMenu.add(mntmDivision);
        
        JMenuItem mntmExponents = new JMenuItem("Exponents");
        mntmExponents.setAction(exeponents);
        mntmExponents.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        mnNewMenu.add(mntmExponents);
        
        JMenuItem MenuAlgebra = new JMenuItem("algebra");
        MenuAlgebra.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        MenuAlgebra.setAction(Alge);
        mnNewMenu.add(MenuAlgebra);
        
        Component horizontalStrut = Box.createHorizontalStrut(27);
        menuBar.add(horizontalStrut);
        
        JButton btnRange = new JButton("Range");
        btnRange.setAction(rangeButton);
        menuBar.add(btnRange);
        Practice();
    }

    //enter button action
    //addition menue item action
    private class additon extends AbstractAction {
        public additon() {
            putValue(NAME, "A"
            		+ "dd");
            putValue(SHORT_DESCRIPTION, "Some short description");
        }
        public void actionPerformed(ActionEvent e) {
            OPS.SetEnum(OperationEnum.operations.add);
            results.setText("");
            Practice();
            Question.setText(FirstNum+"+"+SecondNum+"=");
        }
    }
    //subtraction menue item action
    private class subtraction extends AbstractAction {
        public subtraction() {
            putValue(NAME, "subtract");
            putValue(SHORT_DESCRIPTION, "Some short description");
        }
        public void actionPerformed(ActionEvent e) {
        	OPS.SetEnum(OperationEnum.operations.subtract);
            results.setText("");
            Practice();
            Question.setText(FirstNum+"-"+SecondNum+"=");
            
        }
    }
	private class multiply extends AbstractAction {
		public multiply() {
			putValue(NAME, "multiply");
			putValue(SHORT_DESCRIPTION, "");
		}
		public void actionPerformed(ActionEvent e) {
			OPS.SetEnum(OperationEnum.operations.multiply);
			results.setText("");
			Practice();
            Question.setText(FirstNum+" * "+SecondNum+"=");
		}
	}
	private class range extends AbstractAction {
		public range() {
			putValue(NAME, "range");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			if(r.getFrame().isVisible()) {
				r.getFrame().setLocation(frame.getX()+frame.getWidth(), frame.getY());
			}
			else {
				r.getFrame().setLocation(frame.getX()+frame.getWidth(), frame.getY());
				r.getFrame().setVisible(true);
			}
		}
	}
	private class Algebra extends AbstractAction {
		public Algebra() {
			putValue(NAME, "Algebra");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			OPS.SetEnum(OperationEnum.operations.Algebra);
			Practice();
			
		}
	}
	private class Divisiom extends AbstractAction {
		public Divisiom() {
			putValue(NAME, "Division");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			OPS.SetEnum(OperationEnum.operations.division);
			results.setText("");
			Practice();
            Question.setText(FirstNum+" ÷ "+SecondNum+"=");
		}
	}
	private class Exponents extends AbstractAction {
		public Exponents() {
			putValue(NAME, "Exponents");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			OPS.SetEnum(OperationEnum.operations.exponents);
			results.setText("");
			Practice();
		}
	}
}


