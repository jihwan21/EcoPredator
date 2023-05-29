package TeamProject;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

class ShowInventory extends JFrame {
	JTable table;
	JScrollPane scroll; // 테이블 위에 열 라벨 넣기
	String[][] data; // 2차원 배열을 생성
	String[] title = { "구분", "개수" }; // 제목

	public ShowInventory() {
		data = new String[9][3];//9x3테이블 생성
		//hpPotionN, mpPotionN, 수류탄N, 일반장비N, 아가미N, 어항N, 날개N, pMoney;
		data[0][0] = "투구";
		if (Player.투구N == 0)
			data[0][1] = "없음";
		else
			data[0][1] = "장비LV : " + Player.h.lv;

		data[1][0] = "갑옷";
		if (Player.갑옷N == 0)
			data[1][1] = "없음";
		else
			data[1][1] = "장비LV : " + Player.a.lv;

		data[2][0] = "날개";
		if (Player.날개N == 0)
			data[2][1] = "없음";
		else
			data[2][1] = "보유중";

		data[3][0] = "아가미";
		if (Player.아가미N == 0)
			data[3][1] = "없음";
		else
			data[3][1] = "보유중";

		data[4][0] = "어항";
		if (Player.어항N == 0)
			data[4][1] = "없음";
		else
			data[4][1] = "보유중";

		data[5][0] = "HP포션";
		data[5][1] = Integer.toString(Player.hpPotionN);//플레이어 클래스의 전역 필드 hpPotionN을 사용

		data[6][0] = "MP포션";
		data[6][1] = Integer.toString(Player.mpPotionN);
		data[6][2] = "//";

		data[7][0] = "수류탄";
		data[7][1] = Integer.toString(Player.수류탄N);

		data[8][0] = "돈";
		data[8][1] = Integer.toString(Player.pMoney);

		table = new JTable(data, title);
		scroll = new JScrollPane(table);
		add(scroll);

		table.getColumn("구분").setPreferredWidth(80);//크기 조정
		table.getColumn("개수").setPreferredWidth(100);
//		table.getColumn(Player.name).setPreferredWidth(75);
//Player.style + " " + Player.p.tribe + " " + Player.name,
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);//창닫기
		pack();
		setSize(180, 220);//전체 크기 조정
		setVisible(true);
	}
}
