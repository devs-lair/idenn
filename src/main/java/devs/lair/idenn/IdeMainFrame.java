package devs.lair.idenn;

import devs.lair.idenn.ui.IdeStrings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class IdeMainFrame extends JFrame {

    private JPanel mainPanel;
    private JPanel stateLine;

    public IdeMainFrame() {
        super(IdeStrings.Titles.FRAME_TITLE);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        createUI();
    }

    private void createUI() {
        createMenu();
        createMainPanel();
    }

    private void createMainPanel() {
        mainPanel = new JPanel(new BorderLayout());

//        mainPanel.add(createNorthPanel(), BorderLayout.NORTH);
//        mainPanel.add(createWestPanel(),  BorderLayout.WEST );
//        mainPanel.add(createEastPanel(), BorderLayout.EAST);
//        mainPanel.add(createCenterPanel(), BorderLayout.CENTER);
//
        mainPanel.add(createSouthPanel(), BorderLayout.SOUTH);
        add(mainPanel);
    }

    private JComponent createSouthPanel() {
        stateLine = new StateLine();
        return stateLine;
    }

    private JComponent createCenterPanel() {
        return null;
    }

    private JComponent createEastPanel() {
        return null;
    }

    private JComponent createWestPanel() {
        return null;
    }

    private JComponent createNorthPanel() {
        return null;
    }

    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu file = new JMenu(IdeStrings.Menus.FILE);
        menuBar.add(file);

        file.add(new JMenuItem(new AbstractAction(IdeStrings.Actions.OPEN_PROJECT) {
            @Override
            public void actionPerformed(ActionEvent e) {}
        }));

        file.add(new JMenuItem(new AbstractAction(IdeStrings.Actions.CLOSE) {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        }));

        setJMenuBar(menuBar);
    }

    public void showFrame() {
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
