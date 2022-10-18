import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Notiz extends JFrame implements ActionListener
{
    static Font notizLargeFont = new Font("Ink Free", 1, 25);
    static Font notizMediumFont = new Font("Ink Free", 1, 20);
    static Font notizSmallFont = new Font("Ink Free", 1, 15);

    static JFrame notizFrame;
    JButton notizClearBtn, notizTxSmallBtn, notizTxLargeBtn;
    JLabel notizTxSizeLab, notizErrorLab;
    JTextArea notizTxArea;



    public static void setNotizVisOn()
    {
        notizFrame.setVisible(true);
    }


    Notiz()
    {

        notizFrame = new JFrame("Notiz");
        notizFrame.setDefaultCloseOperation(notizFrame.HIDE_ON_CLOSE);
        notizFrame.setSize(420, 560);
        notizFrame.setLocation(55, 260);
        notizFrame.setResizable(false);
        notizFrame.setLayout(null);

        notizClearBtn = new JButton("Löschen");
        notizClearBtn.setBounds(10,10, 100, 40);
        notizClearBtn.setFont(notizSmallFont);
        notizClearBtn.setVisible(true);
        notizClearBtn.addActionListener(this);

        notizTxSizeLab = new JLabel("Text Grösse");
        notizTxSizeLab.setBounds(120, 5, 100, 50);
        notizTxSizeLab.setFont(notizSmallFont);

        notizTxSmallBtn = new JButton("<<");
        notizTxSmallBtn.setBounds(220,10, 50, 40);
        notizTxSmallBtn.setFont(notizSmallFont);
        notizTxSmallBtn.setVisible(true);
        notizTxSmallBtn.addActionListener(this);

        notizTxLargeBtn = new JButton(">>");
        notizTxLargeBtn.setBounds(280,10, 50, 40);
        notizTxLargeBtn.setFont(notizSmallFont);
        notizTxLargeBtn.setVisible(true);
        notizTxLargeBtn.addActionListener(this);

        notizTxArea = new JTextArea();
        notizTxArea.setBounds(10,60,385, 400);
        notizTxArea.setFont(notizMediumFont);
        notizTxArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        notizTxArea.setVisible(true);

        notizErrorLab = new JLabel("ERROR:  keine");
        notizErrorLab.setBounds(10, 460, 300, 50);
        notizErrorLab.setFont(notizSmallFont);


        notizFrame.add(notizClearBtn);
        notizFrame.add(notizTxSizeLab);
        notizFrame.add(notizTxSmallBtn);
        notizFrame.add(notizTxLargeBtn);
        notizFrame.add(notizTxArea);
        notizFrame.add(notizErrorLab);

        notizFrame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        if ( e.getSource() == notizClearBtn)
        {
            notizTxArea.setText("");
        }
        if ( e.getSource() == notizTxSmallBtn)
        {
            if ( notizTxArea.getFont() == notizSmallFont)
            {
                notizTxSmallBtn.setEnabled(false);
                notizTxLargeBtn.setEnabled(true);
                notizErrorLab.setText("ERROR:  kleinste Einstellung erreicht");
            }
            else if ( notizTxArea.getFont() == notizMediumFont)
            {
                notizTxArea.setFont(notizSmallFont);
                notizTxSmallBtn.setEnabled(true);
                notizTxLargeBtn.setEnabled(true);
                notizErrorLab.setText("ERROR:  keine");
            }
            else if ( notizTxArea.getFont() == notizLargeFont)
            {
                notizTxArea.setFont(notizMediumFont);
                notizTxSmallBtn.setEnabled(true);
                notizTxLargeBtn.setEnabled(true);
                notizErrorLab.setText("ERROR:  keine");
            }
        }
        if ( e.getSource() == notizTxLargeBtn)
        {
            if ( notizTxArea.getFont() == notizSmallFont)
            {
                notizTxArea.setFont(notizMediumFont);
                notizTxLargeBtn.setEnabled(true);
                notizTxSmallBtn.setEnabled(true);
                notizErrorLab.setText("ERROR:  keine");
            }
            else if ( notizTxArea.getFont() == notizMediumFont)
            {
                notizTxArea.setFont(notizLargeFont);
                notizTxLargeBtn.setEnabled(true);
                notizTxSmallBtn.setEnabled(true);
                notizErrorLab.setText("ERROR:  keine");
            }
            else if ( notizTxArea.getFont() == notizLargeFont)
            {
                notizTxLargeBtn.setEnabled(false);
                notizTxSmallBtn.setEnabled(true);
                notizErrorLab.setText("ERROR:  grösste Einstellung erreicht");
            }
        }
    }
}
