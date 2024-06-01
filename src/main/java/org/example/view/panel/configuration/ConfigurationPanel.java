package org.example.view.panel.configuration;

import javax.swing.JPanel;
import org.example.model.vo.ConfiguracaoVO;

public abstract class ConfigurationPanel extends JPanel {

    public abstract ConfiguracaoVO getConfiguration();
}
