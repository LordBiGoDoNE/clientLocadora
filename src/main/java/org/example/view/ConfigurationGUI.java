package org.example.view;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.example.model.vo.ConfiguracaoVO;
import org.example.service.ConfiguracaoService;
import org.example.singleton.Configuracao;
import org.example.view.panel.configuration.ConfigurationDesktopPanel;
import org.example.view.panel.configuration.ConfigurationPanel;
import org.example.view.panel.configuration.ConfigurationServerPanel;

public class ConfigurationGUI extends javax.swing.JDialog {

    private ConfiguracaoService configuracaoService;

    public ConfigurationGUI(ConfiguracaoService pConfiguracaoService) {
        this.setModal(true);
        configuracaoService = pConfiguracaoService;
        
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btnSalvar = new javax.swing.JButton();
        pnlConfiguracao = new javax.swing.JPanel();
        pnlConfigurationInterface = new javax.swing.JPanel();
        radioBtnDesktop = new javax.swing.JRadioButton();
        radioBtnServer = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(240, 346));
        setMinimumSize(new java.awt.Dimension(240, 346));
        setResizable(false);

        btnSalvar.setText("Salvar");
        btnSalvar.setEnabled(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        pnlConfiguracao.setBorder(javax.swing.BorderFactory.createTitledBorder("Configuração"));

        pnlConfigurationInterface.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnlConfigurationInterface.setMaximumSize(new java.awt.Dimension(243, 206));
        pnlConfigurationInterface.setMinimumSize(new java.awt.Dimension(243, 206));
        pnlConfigurationInterface.setPreferredSize(new java.awt.Dimension(243, 206));
        pnlConfigurationInterface.setLayout(new java.awt.BorderLayout());

        buttonGroup1.add(radioBtnDesktop);
        radioBtnDesktop.setText("Desktop");
        radioBtnDesktop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtnDesktopActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioBtnServer);
        radioBtnServer.setText("Server");
        radioBtnServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtnServerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlConfiguracaoLayout = new javax.swing.GroupLayout(pnlConfiguracao);
        pnlConfiguracao.setLayout(pnlConfiguracaoLayout);
        pnlConfiguracaoLayout.setHorizontalGroup(
            pnlConfiguracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConfiguracaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlConfiguracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlConfiguracaoLayout.createSequentialGroup()
                        .addComponent(radioBtnDesktop, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioBtnServer, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pnlConfigurationInterface, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlConfiguracaoLayout.setVerticalGroup(
            pnlConfiguracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlConfiguracaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlConfiguracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioBtnDesktop)
                    .addComponent(radioBtnServer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlConfigurationInterface, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlConfiguracao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalvar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlConfiguracao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalvar)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        ConfiguracaoVO configuracao = ((ConfigurationPanel) pnlConfigurationInterface.getComponent(0)).getConfiguration();

        try {
            configuracaoService.salvarConfiguracao(configuracao);

            Configuracao.initConfig();
        } catch (IOException | IllegalAccessException ex) {
            Logger.getLogger(ConfigurationGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void radioBtnDesktopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtnDesktopActionPerformed
        carregarPanelConfiguracao(new ConfigurationDesktopPanel());
    }//GEN-LAST:event_radioBtnDesktopActionPerformed

    private void radioBtnServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtnServerActionPerformed
        carregarPanelConfiguracao(new ConfigurationServerPanel());
    }//GEN-LAST:event_radioBtnServerActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel pnlConfiguracao;
    private javax.swing.JPanel pnlConfigurationInterface;
    private javax.swing.JRadioButton radioBtnDesktop;
    private javax.swing.JRadioButton radioBtnServer;
    // End of variables declaration//GEN-END:variables

    private void carregarPanelConfiguracao(ConfigurationPanel panel) {
        pnlConfigurationInterface.removeAll();
        pnlConfigurationInterface.add(panel);
        pnlConfigurationInterface.repaint();
        pnlConfigurationInterface.revalidate();
        
        btnSalvar.setEnabled(true);
    }
}
