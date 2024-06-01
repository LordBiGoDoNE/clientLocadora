package org.example.singleton;

import java.io.IOException;
import org.example.model.vo.ConfiguracaoVO;
import org.example.service.ConfiguracaoService;

public class Configuracao {

    private static ConfiguracaoVO configuracaoVO = null;
    
    public static void initConfig() throws IllegalAccessException, IOException{
        if (configuracaoVO != null) {
            throw new RuntimeException("Configuração ja inicializada!");
        }
        
        configuracaoVO = new ConfiguracaoService().carregarConfiguracao();
    }
    
    public static ConfiguracaoVO getConfig(){
        if (configuracaoVO == null) {
            throw new RuntimeException("Configuração não inicializada!");
        }
        
        return configuracaoVO;
    }

}
