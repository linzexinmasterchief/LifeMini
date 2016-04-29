package io.github.lzx3778.lifemini;


import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JMenuBar;

public class Life_mini extends JFrame {
	private JPanel c;
	private JButton[] jb = new JButton[9];
	private Random r = new Random();
	
	public static void main(String[] args) {
		Life_mini frame = new Life_mini();
		frame.setVisible(true);
	}
	public Life_mini() {
		setResizable(false);
		setType(Type.UTILITY);
		setTitle("Life_mini");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 600, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JButton btnRestart = new JButton("转世重生");
		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clear();
				jb[4].setBackground(Color.YELLOW);
				jb[4].setText("你的人生从此开始");
			}
		});
		menuBar.add(btnRestart);
		
		JButton btnExit = new JButton("灵魂出窍");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		menuBar.add(btnExit);
		c = new JPanel();
		c.setLayout(new GridLayout(3, 3));
		setContentPane(c);
		
		for(int i = 0;i < 9;i ++){
			jb[i] = new JButton();
			jb[i].setBackground(Color.GRAY);
			lis l = new lis(i);
			jb[i].addActionListener(l);
			c.add(jb[i]);
		}
		jb[4].setBackground(Color.YELLOW);
		jb[4].setText("你的人生从此开始");
	}
	public void set(int i,Color c,String s){
		jb[i].setText(s);
		if(jb[i].getText().equals("")){
			jb[i].setBackground(Color.GRAY);
			return;
		}
		jb[i].setBackground(c);
	}
	public void setAround(String s1,String s2,String s3,String s4){
		set(1,Color.YELLOW,s1);
		set(3,Color.YELLOW,s2);
		set(5,Color.YELLOW,s3);
		set(7,Color.YELLOW,s4);
	}
	public void clear(){
		for(int i = 0;i < 9;i ++){
			jb[i].setBackground(Color.GRAY);
			jb[i].setText("");
		}
	}
	class lis implements ActionListener{
		int t;
		public lis(int i){
			t = i;
		}
		public void actionPerformed(ActionEvent e) {
			if(jb[t].getBackground()==Color.YELLOW){
				//1
				switch(jb[t].getText()){
				case("你的人生从此开始"):
					//set(blockID,color,text)
					set(4,Color.WHITE,"你的人生从此开始");
					//setAround(jb[1].text,jb[3].text,jb[5].text,jb[7].text)
					setAround("出生","再等一下","无聊的世界","");
					break;
				//2
				case("出生"):
					clear();
					set(4,Color.YELLOW,"遇到粗心的医生");
					break;
				case("无聊的世界"):
					clear();
					set(4,Color.YELLOW,"世界再见");
					break;
				case("再等一下"):
					clear();
					set(4,Color.WHITE,"再等一下");
					setAround("顺利出生","","","");
					break;
				//3
				case("遇到粗心的医生"):
					clear();
					int temp = r.nextInt(100);
					if(temp >= 50){
						set(4,Color.RED,"你死了！！！");
					}else{
						set(4,Color.YELLOW,"你残疾了");
					}
					break;
				case("世界再见"):
					clear();
					set(4,Color.CYAN,"天堂欢迎你！");
					break;
				case("顺利出生"):
					clear();
					set(4,Color.WHITE,"顺利出生");
					setAround("好奇","不睁眼","打别人","");
					break;
				//4
				case("你残疾了"):
					clear();
					set(4,Color.WHITE,"你残疾了");
					setAround("伤心","无所谓","非常开心","自杀");
					break;
				case("好奇"):
					clear();
					set(4,Color.WHITE,"好奇");
					setAround("摸索四周","大喊大叫","","");
					break;
				case("不睁眼"):
					clear();
					set(4,Color.WHITE,"不睁眼");
					setAround("摸索四周","睡着","大喊大叫","");
					break;
				case("打别人"):
					clear();
					set(4,Color.WHITE,"打别人");
					setAround("打医生","打你爸","打你妈","算了不打了");
					break;
				//5
				case("伤心"):
					clear();
					set(4,Color.WHITE,"伤心");
					setAround("自杀","大喊大叫","","");
					break;
				case("无所谓"):
					clear();
					set(4,Color.WHITE,"无所谓");
					setAround("摸索四周","睡着","","");
					break;
				case("非常开心"):
					clear();
					set(4,Color.WHITE,"你被送进神经病院");
					break;
				case("自杀"):
					clear();
					set(4,Color.RED ,"你死了");
					break;
				case("摸索四周"):
					clear();
					set(4,Color.WHITE,"摸到了东西");
					setAround("抓起圆的","抓起方的","不抓","");
					break;
				case("睡着"):
					clear();
					set(4,Color.WHITE,"睡着");
					setAround("醒来","","","");
					break;
				case("大喊大叫"):
					clear();
					set(4,Color.WHITE,"被打");
					setAround("伤心","无所谓","非常开心","打别人");
					break;
				case("打医生"):
					clear();
					set(4,Color.WHITE,"打医生");
					setAround("大喊大叫","","非常开心","");
					break;
				case("打你爸"):
					clear();
					set(4,Color.WHITE,"打你爸");
					setAround("大喊大叫","","非常开心","");
					break;
				case("打你妈"):
					clear();
					set(4,Color.WHITE,"打你妈");
					setAround("大喊大叫","","非常开心","");
					break;
				case("算了不打了"):
					clear();
					set(4,Color.WHITE,"算了不打了");
					setAround("大喊大叫","","睡着","");
					break;
				}
			}
		}
	}
}
