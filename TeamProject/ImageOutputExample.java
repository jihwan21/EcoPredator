package TeamProject;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class ImageOutputExample {//이미지 불러오는 클래스
	
	public static void 사람눈() {
		// 이미지 파일 경로
		String imagePath = "C:\\JAVA2023\\에코프레데터\\images\\눈6.png";

		// 이미지 아이콘 생성

		ImageIcon imageIcon = new ImageIcon(imagePath);

		// JFrame 생성
		JFrame frame = new JFrame("인간과 눈이 마주쳤다.");
		JLabel label = new JLabel(imageIcon);
		frame.setAlwaysOnTop(true);
		frame.getContentPane().add(label);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screenSize.width - frame.getWidth()) / 2;
		int y = (screenSize.height - frame.getHeight()) / 2;
		frame.setLocation(x, y);

		// 타이머 설정 (4초 후에 창 닫기)
		int delay = 4000; // 밀리초 단위, 여기서는 4초뒤에 창 닫기
		Timer timer = new Timer(delay, e -> {
			SwingUtilities.invokeLater(() -> {
				frame.dispose(); // 창 닫기
			});
		});
		timer.setRepeats(false); // 한 번만 실행되도록 설정
		timer.start();

		frame.setVisible(true);
	}

	public static void 환경파괴() {
		// 이미지 파일 경로
		String imagePath = "C:\\JAVA2023\\에코프레데터\\images\\환경파괴.png";

		// 이미지 아이콘 생성

		ImageIcon imageIcon = new ImageIcon(imagePath);

		// JFrame 생성
		JFrame frame = new JFrame("환경파괴");
		JLabel label = new JLabel(imageIcon);
		frame.setAlwaysOnTop(true);
		frame.getContentPane().add(label);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screenSize.width - frame.getWidth()) / 2;
		int y = (screenSize.height - frame.getHeight()) / 2;
		frame.setLocation(x, y);

		// 타이머 설정 (2초 후에 창 닫기)
		int delay = 2000; // 밀리초 단위, 여기서는 2초
		Timer timer = new Timer(delay, e -> {
			SwingUtilities.invokeLater(() -> {
				frame.dispose(); // 창 닫기
			});
		});
		timer.setRepeats(false); // 한 번만 실행되도록 설정
		timer.start();

		frame.setVisible(true);
	}

	public static void 공장연기() {
		// 이미지 파일 경로
		String imagePath = "C:\\JAVA2023\\에코프레데터\\images\\대기오염.png";

		// 이미지 아이콘 생성
		ImageIcon imageIcon = new ImageIcon(imagePath);

		// JFrame 생성
		JFrame frame = new JFrame("대기오염");
		JLabel label = new JLabel(imageIcon);
		frame.setAlwaysOnTop(true);
		frame.getContentPane().add(label);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();

		// 화면 크기를 가져와서 중앙에 위치하도록 설정
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screenSize.width - frame.getWidth()) / 2;
		int y = (screenSize.height - frame.getHeight()) / 2;
		frame.setLocation(x, y);

		// 타이머 설정 (2초 후에 창 닫기)
		int delay = 2000; // 밀리초 단위, 여기서는 2초
		Timer timer = new Timer(delay, e -> {
			SwingUtilities.invokeLater(() -> {
				frame.dispose(); // 창 닫기
			});
		});
		timer.setRepeats(false); // 한 번만 실행되도록 설정
		timer.start();

		frame.setVisible(true);
	}

}
