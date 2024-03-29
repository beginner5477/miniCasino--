package miniCasino;

import javax.swing.JFrame;

public class MiniCasinoMenu extends JFrame{
	public MiniCasinoMenu() {
		setSize(800,600);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new MiniCasinoMenu();
	}
}
