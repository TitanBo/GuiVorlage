import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame implements ActionListener
{

//  create Font's
    static Font largeFont = new Font("Ink Free", 1, 25);
    static Font smallFont = new Font("Ink Free", 1, 15);

// all Frame parts
    JFrame mainFrame;
    JMenuBar menuBar;
    JMenu dateien, tools;
    JMenuItem mILaden, mISpeichern, mIRechner, mINotiz;
    Container container;


    Gui()
    {

    // create Frame
        mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1000,560);
        mainFrame.setResizable(false);
        mainFrame.setLayout(null);
        mainFrame.setLocationRelativeTo(null);

    // create MenuBar
        menuBar = new JMenuBar();

    // create Menue's
        dateien = new JMenu("Dateien");
        dateien.setFont(smallFont);
        tools = new JMenu("Tool's");
        tools.setFont(smallFont);

    // create MenuItem's
        mILaden = new JMenuItem("Laden");
        mILaden.setFont(smallFont);
        mILaden.addActionListener(this);

        mISpeichern = new JMenuItem("Speichern");
        mISpeichern.setFont(smallFont);
        mISpeichern.addActionListener(this);

        mIRechner = new JMenuItem("Rechner");
        mIRechner.setFont(smallFont);
        mIRechner.addActionListener(this);

        mINotiz = new JMenuItem("Notiz");
        mINotiz.setFont(smallFont);
        mINotiz.addActionListener(this);

    //  create Container
        container = mainFrame.getContentPane();

    // add MenuItem's to Menu's
        dateien.add(mILaden);
        dateien.add(mISpeichern);

        tools.add(mINotiz);
        tools.add(mIRechner);

    // add Menu's to MenuBar
        menuBar.add(dateien);
        menuBar.add(tools);

        mainFrame.setJMenuBar(menuBar);

        mainFrame.setVisible(true);
    }
    public void calcClose()
    {
        Calculator.calculatorFrame = null;
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if ( e.getSource() == mILaden)
        {
            JOptionPane.showMessageDialog(mainFrame, "befindet sich noch im Konstrucktionsprozess");
        }
        if ( e.getSource() == mISpeichern)
        {
            JOptionPane.showMessageDialog(mainFrame, "befindet sich noch im Konstrucktionsprozess");
        }
        // set MenuItem Rechner
        if ( e.getSource() == mIRechner )
        {
            if ( Calculator.calculatorFrame != null )
            {
                Calculator.setCalcVisOn();
            }
            else
            {
                new Calculator();
                Calculator.setCalcVisOn();
            }
        }
        // set MenuItem Notiz
        if ( e.getSource() == mINotiz )
        {
            if ( Notiz.notizFrame != null )
            {
                Notiz.setNotizVisOn();
            }
            else
            {
                new Notiz();
                Notiz.setNotizVisOn();
            }
        }
    }
}
