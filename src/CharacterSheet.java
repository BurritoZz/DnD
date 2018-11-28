import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.Console;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
public class CharacterSheet implements ActionListener {
    private static Console console = System.console();
    private String name;
    private String race;
    private String background;
    private String playerName;
    private String characterClass;
    private Health hp;
    private ArrayList<Stat> stats;
    private JFrame frame;
    private JMenuBar menuBar;
    private JMenu menu, submenu;
    private JMenuItem menuItem;
    private JRadioButtonMenuItem rbMenuItem;
    private JCheckBoxMenuItem cbMenuItem;

    public CharacterSheet(String filename) {
        startWindow();
    }

    public void startWindow() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame = new JFrame("FrameDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(initMenu());
        frame.add(getContentPane(), BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getContentPane() {
        JPanel content = new JPanel();
        content.setBorder(BorderFactory.createLineBorder(Color.black));
        JTextArea textArea = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setEditable(true);
        textArea.append("Hello BOI \n");
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.cyan));
        content.add(scrollPane);
        return content;
    }

    public JMenuBar initMenu() {
        menuBar = new JMenuBar();

        menu = new JMenu("File");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items");
        menuBar.add(menu);

        menuItem = new JMenuItem("Exit", KeyEvent.VK_T);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menu.addSeparator();
        ButtonGroup group = new ButtonGroup();
        rbMenuItem = new JRadioButtonMenuItem("A radio button menu item");
        rbMenuItem.setSelected(true);
        rbMenuItem.setMnemonic(KeyEvent.VK_R);
        group.add(rbMenuItem);
        menu.add(rbMenuItem);

        rbMenuItem = new JRadioButtonMenuItem("Another one");
        rbMenuItem.setMnemonic(KeyEvent.VK_O);
        group.add(rbMenuItem);
        menu.add(rbMenuItem);

        menu.addSeparator();
        cbMenuItem = new JCheckBoxMenuItem("A check box menu item");
        cbMenuItem.setMnemonic(KeyEvent.VK_C);
        menu.add(cbMenuItem);

        cbMenuItem = new JCheckBoxMenuItem("Another one");
        cbMenuItem.setMnemonic(KeyEvent.VK_H);
        menu.add(cbMenuItem);

        menu.addSeparator();
        JMenu submenu = new JMenu("A submenu");
        submenu.setMnemonic(KeyEvent.VK_S);
        menuItem = new JMenuItem("An item in the submenu");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
        submenu.add(menuItem);
        menuItem = new JMenuItem("Another item");
        submenu.add(menuItem);
        menu.add(submenu);

        return menuBar;
    }

    public static void main(String[] args) {
        //if (console == null) {
        //    System.out.println("No console");
        //    System.exit(0);
        //}
        //if (args.length == 0) {
        //    String s = console.readLine("You did not enter a filename, do you want to create a new character? y/n: ");
        //    if (s.contains("y")) {
        //        new CharacterSheet(null);
        //    } else {
        //        System.exit(0);
        //    }
        //}
        //new CharacterSheet(args[0]);
        new CharacterSheet(null);
    }

    public void init() {
        playerName = console.readLine("Please enter your name: ");
        name = console.readLine("Please enter the name of your character: ");
        race = console.readLine("Please enter the race of your character: ");
        characterClass = console.readLine("Please enter the class of your character: ");
        background = console.readLine("Please enter your character's background: ");
        int maxHP = askForInt("Please enter your maximum HP: ");
        int currHP = askForInt("Please enter your current HP: ");
        int tempHP = askForInt("Please enter your temporary HP: ");
        hp = new Health(maxHP, currHP, tempHP, 0, 0);
        System.out.println(hp);
        stats = new ArrayList<Stat>();
        for (Stats s : Stats.values()) {
            Stat stat;
            int val = askForInt("Please enter your score for " + s + ": ");
            String p = console.readLine("Are you proficient with that skill? y/n: ");
            if (p.contains("y")) {
                stat = new Stat(s, val, true);
            } else {
                stat = new Stat(s, val, false);
            }
            System.out.println(stat);
            stats.add(stat);
        }
    }

    public void load(String filename) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public int askForInt(String message) {
        return Integer.parseInt(console.readLine(message));
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Exit")) {
            System.exit(0);
        }
    }

}
