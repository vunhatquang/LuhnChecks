import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Luhn implements ActionListener {
	private JTextField text;
	private JLabel label;
	private JFrame frame;
	private JPanel panel;
	public Luhn() {
		frame = new JFrame();
		
		JButton button = new JButton("Check");
		button.addActionListener(this);
		text = new JTextField(20);
		
		label = new JLabel("type in the number and click the button");
		
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		panel.setLayout(new GridLayout(0, 1));
		panel.add(button);
		panel.add(text);
		panel.add(label);
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Luhn check");
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Luhn();
	}
	
	public static boolean luhnCheck(String num) {
		int sum = 0;
		int index = 0;
		while (num.length() != 0) {
			int len = num.length();
			int last = Integer.parseInt(num.substring(len - 1, len));
			num = num.substring(0, len - 1);
			if (index % 2 == 0) {
				sum += last;
			} else {
				if (last * 2 > 9) {
					sum += last * 2 - 9;
				} else {
					sum += last * 2;
				}
			}
			index += 1;
		}
		System.out.println(sum);
		if (sum % 10 == 0) {
			return true;
		}
		return false;
	}
	
	public static boolean isNumeric(String str) {
		return str != null && str.matches("[-+]?\\d*\\.?\\d+");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String num = text.getText();
		if (isNumeric(num)) {
			boolean result = luhnCheck(num);
			if (result) {
				label.setText("valid credit card number");
			} else {
				label.setText("invalid credit card number");
			}
		} else {
			label.setText("What you typed in is not number");
		}
		
	}
	
}
