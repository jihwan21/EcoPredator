package TeamProject;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

class JFrameWindowClosingEventHandler extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		JFrame frame = (JFrame) e.getWindow();
		frame.dispose();
		System.out.println("windowClosing()");
	}
}

public class ShowStatus extends JFrame {
	JTable table;
	JScrollPane scroll; // 테이블 위에 열 라벨을 넣어주자~ scroll
	String[][] data; // 3명의 정보를 담을 2차원 배열을 생성한다.
	String[] title = { "구분", "현재값", "최대값" }; // 제목

	public ShowStatus() {
		// 플레이어 클래스 필수 -> 플레이어 클래스로 객체 생성-> 사실상 필드멤버를 복사
		data = new String[10][3];

		data[0][0] = "레벨";
		data[0][1] = Integer.toString(Player.p.level) + "LV";
		data[0][2] = "||||||||||||||||||||||||||||||";

		data[1][0] = "공격력";
		data[1][1] = Integer.toString(Player.p.attack);
		data[1][2] = "||||||||||||||||||||||||||||||";

		if (Player.투구N != 0 && Player.갑옷N != 0) {
			data[2][0] = "방어력";
			data[2][1] = Integer.toString(Player.p.defense) + "(+"
					+ Integer.toString(Player.h.defense + Player.h.reinforceN + Player.a.defense + Player.a.reinforceN)
					+ ")";
			data[2][2] = "||||||||||||||||||||||||||||||";

		} else if (Player.투구N != 0 && Player.갑옷N == 0) {
			data[2][0] = "방어력";
			data[2][1] = Integer.toString(Player.p.defense) + "(+"
					+ Integer.toString(Player.h.defense + Player.h.reinforceN) + ")";
			data[2][2] = "||||||||||||||||||||||||||||||";
		} else if (Player.투구N == 0 && Player.갑옷N != 0) {
			data[2][0] = "방어력";
			data[2][1] = Integer.toString(Player.p.defense) + "(+"
					+ Integer.toString(Player.a.defense + Player.a.reinforceN) + ")";
			data[2][2] = "||||||||||||||||||||||||||||||";
		}
		if (Player.투구N == 0 && Player.갑옷N == 0) {
			data[2][0] = "방어력";
			data[2][1] = Integer.toString(Player.p.defense);
			data[2][2] = "||||||||||||||||||||||||||||||";

		}

		data[3][0] = "HP";
		data[3][1] = Integer.toString(Player.p.hp);
		data[3][2] = Integer.toString(Player.p.hpMax);

		data[4][0] = "MP";
		data[4][1] = Integer.toString(Player.p.mp);
		data[4][2] = Integer.toString(Player.p.mpMax);

		data[5][0] = "EXP";
		data[5][1] = Integer.toString(Player.p.exp);
		data[5][2] = Integer.toString(Player.p.expMax);

		data[6][0] = "돈";
		data[6][1] = Integer.toString(Player.pMoney);
		data[6][2] = "||||||||||||||||||||||||||||||";

		data[7][0] = "칭호";
		data[7][1] = Player.style;
		data[7][2] = "||||||||||||||||||||||||||||||";

		data[8][0] = "종족";
		data[8][1] = Player.p.tribe;
		data[8][2] = "||||||||||||||||||||||||||||||";

		data[9][0] = "이름";
		data[9][1] = Player.name;
		data[9][2] = "||||||||||||||||||||||||||||||";

		table = new JTable(data, title);
		scroll = new JScrollPane(table);
		add(scroll);

		table.getColumn("현재값").setPreferredWidth(100);
		table.getColumn("최대값").setPreferredWidth(100);
		table.getColumn("구분").setPreferredWidth(50);

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		setSize(250, 220);
		setVisible(true);
	}
}
