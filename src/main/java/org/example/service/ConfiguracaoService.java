package org.example.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;
import org.example.Main;
import org.example.model.vo.ConfiguracaoVO;

public class ConfiguracaoService {
    
    public static final String PROPERTIES_FILE = new StringBuilder(System.getProperty("user.home")
            .replace("\\", "/"))
            .append("/")
            .append("clientLocadora.properties")
            .toString();

    public void salvarConfiguracao(ConfiguracaoVO vo) throws IOException {
        Properties properties = new Properties();
        properties.merge(ConfiguracaoVO.Fields.host, vo.getHost(), (oldValue, newValue) -> newValue);
        properties.merge(ConfiguracaoVO.Fields.port, vo.getPort(), (oldValue, newValue) -> newValue);
        properties.merge(ConfiguracaoVO.Fields.dataBaseName, vo.getDataBaseName(), (oldValue, newValue) -> newValue);
        properties.merge(ConfiguracaoVO.Fields.dataBaseUser, vo.getDataBaseUser(), (oldValue, newValue) -> newValue);
        properties.merge(ConfiguracaoVO.Fields.dataBasePassword, vo.getDataBasePassword(), (oldValue, newValue) -> newValue);
        properties.merge(ConfiguracaoVO.Fields.configurationType, vo.getConfigurationType().toString(), (oldValue, newValue) -> newValue);

        properties.store(new FileWriter(PROPERTIES_FILE), "Propriedades");
    }

    public ConfiguracaoVO carregarConfiguracao() throws FileNotFoundException, IOException, IllegalAccessException  {
        Properties properties = new Properties();
        properties.load(new FileInputStream(PROPERTIES_FILE));

        ConfiguracaoVO configuracao = new ConfiguracaoVO();

        for (Field field : ConfiguracaoVO.class.getDeclaredFields()) {
            field.set(configuracao, properties.getOrDefault(field.getName(), null));
        }
        
        return configuracao;
    }

}
