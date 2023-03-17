package com.fundrise.gto.core.config.secrets.properties.file;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.PropertySource;

import com.fundrise.gto.core.config.secrets.configuration.BaseInterface;

@AutoConfiguration
@ConditionalOnBean(BaseInterface.class)
@AutoConfigureAfter(BaseInterface.class)
@PropertySource(value = "classpath:/test-config.properties", factory = CustomFactory.class)
public class Properties {

}
