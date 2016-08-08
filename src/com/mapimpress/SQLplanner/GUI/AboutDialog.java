package com.mapimpress.SQLplanner.GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AboutDialog extends JDialog {

    public AboutDialog(JFrame owner) {
        super(owner, true);
        setTitle("About");
        setResizable(false);
        setSize(260, 160);
        lbl = new JLabel();
        pnl = new JPanel();
        btn = new JButton();

        lbl.setText("<html><h1><i>SQLplanner</i></h1><hr>SQL optimizer for Oracle</html>");
        add(lbl, BorderLayout.CENTER);
        btn.setText("Close");
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                btnActionPerformed(event);
            }
        });
        pnl.add(btn);
        add(pnl, BorderLayout.SOUTH);
    }

    private void btnActionPerformed(ActionEvent event) {
        setVisible(false);
    }

private JLabel lbl;
private JPanel pnl;
private JButton btn;
}
