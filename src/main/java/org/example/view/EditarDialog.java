package org.example.view;

import java.awt.Frame;
import javax.swing.JDialog;

public abstract class EditarDialog extends JDialog {

    public EditarDialog(Frame owner, boolean modal) {
        super(owner, modal);
    }
    
    public abstract void carregarEntidade(int id);
}
