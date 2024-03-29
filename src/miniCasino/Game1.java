package miniCasino;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Game1 extends JFrame{
	private JLabel lblTitle,lblFgr,lblBgr,lblRsMenu,lblRsContent,lblRsMessage,lblChoMenu,lblBetMenu;
	private JTextField txtBet;
	private JButton btnGameStart;
	private JComboBox cbCho;
	private int n1 = 1;
	private int n2 = 1;
	private ImageIcon bgPic = new ImageIcon(Game1.class.getResource("/miniCasino/images/시계.png"));
	private ImageIcon ig1 = new ImageIcon(Game1.class.getResource("/miniCasino/images/1h.png"));
	private ImageIcon ig2 = new ImageIcon(Game1.class.getResource("/miniCasino/images/2h.png"));
	private ImageIcon ig3 = new ImageIcon(Game1.class.getResource("/miniCasino/images/3h.png"));
	private ImageIcon ig4 = new ImageIcon(Game1.class.getResource("/miniCasino/images/4h.png"));
	private ImageIcon ig5 = new ImageIcon(Game1.class.getResource("/miniCasino/images/5h.png"));
	private ImageIcon ig6 = new ImageIcon(Game1.class.getResource("/miniCasino/images/6h.png"));
	private ImageIcon ig7 = new ImageIcon(Game1.class.getResource("/miniCasino/images/7h.png"));
	private ImageIcon ig8 = new ImageIcon(Game1.class.getResource("/miniCasino/images/8h.png"));
	private ImageIcon ig9 = new ImageIcon(Game1.class.getResource("/miniCasino/images/9h.png"));
	private ImageIcon ig10 = new ImageIcon(Game1.class.getResource("/miniCasino/images/10h.png"));
	private ImageIcon ig11 = new ImageIcon(Game1.class.getResource("/miniCasino/images/11h.png"));
	private ImageIcon ig12 = new ImageIcon(Game1.class.getResource("/miniCasino/images/12h.png"));
	private ImageIcon[] igs = {ig1,ig2,ig3,ig4,ig5,ig6,ig7,ig8,ig9,ig10,ig11,ig12};
	RotImage rotImage = new RotImage();
	String res = "";
	String gameRes = "";
	int betting = 0;
	public Game1() {
		super("홀짝게임");
		setSize(800,600);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 10, 760, 49);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblTitle = new JLabel("홀짝 게임");
		lblTitle.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 30));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(0, 0, 760, 49);
		panel.add(lblTitle);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 69, 760, 423);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		lblFgr = new JLabel("New label");
		lblFgr.setIcon(ig12);
		lblFgr.setHorizontalAlignment(SwingConstants.CENTER);
		lblFgr.setBounds(290, 100, 192, 187);
		panel_1.add(lblFgr);
		
		lblBgr = new JLabel("백그라운드");
		lblBgr.setIcon(bgPic);
		Image bgPic_ = bgPic.getImage();
		bgPic_ = bgPic_.getScaledInstance(380, 380, Image.SCALE_SMOOTH);
		ImageIcon upbgPic = new ImageIcon(bgPic_);
		lblBgr.setIcon(upbgPic);
		lblBgr.setHorizontalAlignment(SwingConstants.CENTER);
		lblBgr.setBounds(196, 0, 380, 380);
		panel_1.add(lblBgr);
		
		lblRsMenu = new JLabel("결과");
		lblRsMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblRsMenu.setFont(new Font("굴림", Font.BOLD, 20));
		lblRsMenu.setBounds(86, 374, 140, 49);
		panel_1.add(lblRsMenu);
		
		lblRsContent = new JLabel("홀/짝");
		lblRsContent.setHorizontalAlignment(SwingConstants.CENTER);
		lblRsContent.setFont(new Font("굴림", Font.BOLD, 20));
		lblRsContent.setBounds(238, 374, 140, 49);
		panel_1.add(lblRsContent);
		
		lblRsMessage = new JLabel("W/L");
		lblRsMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblRsMessage.setFont(new Font("굴림", Font.BOLD, 20));
		lblRsMessage.setBounds(390, 374, 267, 49);
		panel_1.add(lblRsMessage);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 502, 760, 49);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		cbCho = new JComboBox();
		cbCho.setFont(new Font("굴림", Font.BOLD, 20));
		cbCho.setModel(new DefaultComboBoxModel(new String[] {"홀수", "짝수"}));
		cbCho.setBounds(106, 0, 135, 49);
		panel_2.add(cbCho);
		
		lblChoMenu = new JLabel("선택");
		lblChoMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblChoMenu.setFont(new Font("굴림", Font.BOLD, 20));
		lblChoMenu.setBounds(0, 0, 104, 49);
		panel_2.add(lblChoMenu);
		
		lblBetMenu = new JLabel("배팅금액");
		lblBetMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblBetMenu.setFont(new Font("굴림", Font.BOLD, 20));
		lblBetMenu.setBounds(244, 0, 140, 49);
		panel_2.add(lblBetMenu);
		
		txtBet = new JTextField();
		txtBet.setFont(new Font("굴림", Font.PLAIN, 26));
		txtBet.setBounds(385, 0, 246, 49);
		panel_2.add(txtBet);
		txtBet.setColumns(10);
		
		btnGameStart = new JButton("게임시작");
		btnGameStart.setFont(new Font("굴림", Font.BOLD, 20));
		btnGameStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//dao에서 회원정보 vo로 받아오기
				int money = 10000;	//개인재산 뽑아오기 vo로
				if(Pattern.matches("^[1-9][0-9]*$", txtBet.getText()))
				{
					betting = Integer.parseInt( txtBet.getText());  //배팅금액 //텍스트 필드에서 뽑아오기
					System.out.println(betting);
					res = "";
					gameRes = "";
					n1 = (int)(Math.random()*12) + 1;	//홀짝 랜덤수
					n2 = (int)(Math.random()*3) + 1;	//바퀴 랜덤수
					Thread th1 = new Thread(rotImage);
					th1.start();
					System.out.println(n1);
					if(n1 % 2 == 0)
					{
						res = "짝수";
					}
					else if(n1 % 2 != 0)
					{
						res = "홀수";
					}
					
					String ans = (String)cbCho.getSelectedItem(); //콤보박스에서 값 받아오기
					System.out.println(ans);
					if(ans.equals(res))
					{
						gameRes = "win";
					}
					else gameRes = "lose";
					
					if(gameRes.equals("win"))
					{
						money += betting*2;
						//dao로 데이터베이스 접근해서 재산 업데이트 시키기
						//등급도 게임한판할때마다 업데이트 시켜야댐
					}
				}
				else JOptionPane.showMessageDialog(null, "배팅금액은 숫자만 입력해주세요\n 0으로 시작배팅 불가능\n예시:0500");
			}
		});
		btnGameStart.setBounds(631, 0, 129, 49);
		panel_2.add(btnGameStart);
		
		
		
		
		setVisible(true);
	}
	
	public class RotImage implements Runnable {

		@Override
		public void run() {
			for(int j = 0; j < n2; j++)
			{
				for(int i = 0; i < igs.length; i++)
				{
					
					lblFgr.setIcon(igs[i]);
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			for(int i = 0; i < n1; i++)
			{
				if(i < n1 / 2)
				{
					lblFgr.setIcon(igs[i]);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				else
				{
					lblFgr.setIcon(igs[i]);
					try {
						Thread.sleep(150);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			lblRsContent.setText(res);
			if(gameRes.equals("win"))
			{
				JOptionPane.showMessageDialog(null, "선택:"+(String)cbCho.getSelectedItem()+"\n축하합니다~\n획득금액:"+((int)(betting*2)+"원"));
				lblRsMessage.setText("맞추셨습니다~~");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "선택:"+(String)cbCho.getSelectedItem()+"\n다음기회에...");
				lblRsMessage.setText("틀렸습니다...");
			}
			
		}
		
	}
	public static void main(String[] args) {
		new Game1();
	}
}
