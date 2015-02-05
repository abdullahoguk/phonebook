import java.io.IOException;

import javax.swing.SwingUtilities;

public class UI {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					People.loadData();
				} catch (IOException e) {
					// TODO sAuto-generated catch block
					e.printStackTrace();
				}
				new MainFrame();
			}
		});
	}

}
