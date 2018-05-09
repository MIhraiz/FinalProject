package domain;

import javax.swing.JOptionPane;

public abstract class Security {
	
	public static String encrypt (String s) {
		String s2 = "";		
		for(int i = 0; i < s.length(); i++) {
			s2 = s2 + (char)((int)s.charAt(i)+1);
		}
		return s2;
		
	}
	
	public static String decrypt (String s) {
		String s2 = "";		
		for(int i = 0; i < s.length(); i++) {
			s2 = s2 + (char)((int)s.charAt(i)-1);
		}
		return s2;
		
	}
	
	public static void parseHandeling() {
		JOptionPane.showMessageDialog(null, "Invalid number input, pleas enter integers only ♥");
	}
	
}