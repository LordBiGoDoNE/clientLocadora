package org.example.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import org.example.constants.ConfigurationType;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
public class ConfiguracaoVO {

    private String host;
    private String port;
    private String dataBaseName;
    private String dataBaseUser;
    private String dataBasePassword;
    
    @Setter
    private ConfigurationType configurationType;

    public ConfiguracaoVO(String host, String port) {
        this.host = host;
        this.port = port;
    }

}
