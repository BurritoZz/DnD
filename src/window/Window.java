import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Window implements ActionListener {
    private JFrame frame;
    private JMenuBar menuBar;
    private JMenu menu, submenu;
    private JMenuItem menuItem;

    public static void main(String[] args) {
        new Window();
    }

    public Window() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame = new JFrame("Character Sheet");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(initMenu());
        frame.add(getContentPane(), BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getContentPane() {
        JPanel content = new JPanel();
        content.setBorder(BorderFactory.createLineBorder(Color.black));
        JTextField textfield = new JTextField("0", 2);
        content.add(textfield);
        return content;
    }

    public JMenuBar initMenu() {
        menuBar = new JMenuBar();

        menu = new JMenu("File");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription("File options");
        menuBar.add(menu);

        menuItem = new JMenuItem("Load");
        menuItem.getAccessibleContext().setAccessibleDescription("Load a character sheet");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menuItem = new JMenuItem("Save");
        menuItem.getAccessibleContext().setAccessibleDescription("Save a character sheet");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menuItem = new JMenuItem("Exit");
        menuItem.getAccessibleContext().setAccessibleDescription("Exit");
        menuItem.addActionListener(this);
        menu.add(menuItem);
        return menuBar;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Exit")) {
            System.exit(0);
        }
    }
}
