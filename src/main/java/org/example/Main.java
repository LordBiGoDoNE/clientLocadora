package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.example.model.vo.ConfiguracaoVO;
import org.example.service.ConfiguracaoService;
import org.example.singleton.Configuracao;
import org.example.view.ConfigurationGUI;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        ConfiguracaoService configuracaoService = new ConfiguracaoService();

        try {
            configuracaoService.carregarConfiguracao();
        } catch (FileNotFoundException ex) {
            ConfigurationGUI configurationForm = new ConfigurationGUI(configuracaoService);
            configurationForm.setVisible(true);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        ConfiguracaoVO config = Configuracao.getConfig();

        switch (config.getConfigurationType()) {
            case DESKTOP:

                break;
            case SERVER:

                break;
            default:
                throw new RuntimeException(
                        String.format(
                                "Tipo de Configuracao %s invalido!",
                                config.getConfigurationType().name())
                );
        }
    }
}
