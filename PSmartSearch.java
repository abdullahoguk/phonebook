import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PSmartSearch extends JPanel {

	public JLabel lSmartSearch;
	public JTextField tname, tsurname, tadd, thome, tcell, twork, tSmartSearch;
	private JButton bSmartSearch;
	private static final long serialVersionUID = 1L;

	// Constructor Of Smart Search Panel
	public PSmartSearch() {
		setLayout(null);

		lSmartSearch = new JLabel("Smart Search");
		lSmartSearch.setBounds(29, 12, 80, 20);
		add(lSmartSearch);

		tSmartSearch = new JTextField();
		tSmartSearch.setBounds(129, 12, 80, 20);
		add(tSmartSearch);
		tSmartSearch.setColumns(10);

		bSmartSearch = new JButton("Find");
		bSmartSearch.setBounds(229, 12, 80, 20);
		add(bSmartSearch);
		// The Action of Smart Searching
		bSmartSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String searchEntry = tSmartSearch.getText();
				if ("0123456789".contains(searchEntry)) {
					JOptionPane.showMessageDialog(null, People
							.makeString(People.searchByNumber(tSmartSearch
									.getText())));
				} else {
					JOptionPane.showMessageDialog(null, People
							.makeString(People.searchByName(tSmartSearch
									.getText())));
				}
			}

		});
	}
}
