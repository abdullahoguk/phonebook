import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private static int dimY = 400;
	private static int dimX = 600;
	JPanel pMain;

	private JPanel pMenu;
	private JPanel pCardHolder;

	private JButton bHome, bSmartSearch, bAddContact, bListAll;
	public CardLayout cardLayout;

	public static PHome pHome;
	public static PSmartSearch pSmartSearch;
	public static PAddContact pAddContact;
	public static PListAll pListAll;

	public MainFrame() {
		super("Phone Book App");

		setLayout(new BorderLayout());

		pMain = new JPanel();
		add(pMain, BorderLayout.CENTER);

		setLayout(new BorderLayout());

		// MENU PANEL STARTS

		pMenu = new JPanel();
		add(pMenu, BorderLayout.NORTH);
		pMenu.setBackground(Color.ORANGE);

		bHome = new JButton("Home");
		pMenu.add(bHome);

		bHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Show Home Panel
				cardLayout = (CardLayout) (pCardHolder.getLayout());
				cardLayout.show(pCardHolder, (String) "pHome");
			}
		});

		bSmartSearch = new JButton("Smart Search");
		pMenu.add(bSmartSearch);

		bSmartSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Show Smart Search Panel
				cardLayout = (CardLayout) (pCardHolder.getLayout());
				cardLayout.show(pCardHolder, (String) "pSmartSearch");
			}
		});

		bAddContact = new JButton("New Contact");
		pMenu.add(bAddContact);

		bAddContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Show Add Contact Panel
				cardLayout = (CardLayout) (pCardHolder.getLayout());
				cardLayout.show(pCardHolder, (String) "pAddContact");
			}
		});

		bListAll = new JButton("List All");
		pMenu.add(bListAll);

		bListAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Show List All Panel
				cardLayout = (CardLayout) (pCardHolder.getLayout());
				cardLayout.show(pCardHolder, (String) "pListAll");
			}
		});

		// CARD HOLDER PANEL STARTS

		pCardHolder = new JPanel();
		add(pCardHolder, BorderLayout.CENTER);

		CardLayout layout = new CardLayout();
		layout.setHgap(0);
		layout.setVgap(0);
		pCardHolder.setLayout(layout);

		pHome = new PHome();
		pHome.setBackground(new Color(0, 153, 255));
		pCardHolder.add("pHome", pHome);

		pSmartSearch = new PSmartSearch();
		pSmartSearch.setBackground(new Color(0, 153, 255));
		pCardHolder.add("pSmartSearch", pSmartSearch);

		pAddContact = new PAddContact();
		pAddContact.setBackground(new Color(0, 153, 255));
		pCardHolder.add("pAddContact", pAddContact);

		pListAll = new PListAll();
		pListAll.setBackground(new Color(0, 153, 255));
		pCardHolder.add("pListAll", pListAll);

		setSize(dimX, dimY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}
}
