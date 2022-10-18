package io.github.jpinyin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStreamReader;

@Configuration
@ConditionalOnClass({PinyinUtil.class})
@EnableConfigurationProperties(JPingYingProperties.class)
public class JPingYingAutoConfiguration {

    @Autowired
    JPingYingProperties jPingYingProperties;

    @Bean
    @ConditionalOnMissingBean
    public PinyinUtil getTestService(){
        //外部拓展文件位置
        String extFilePath = jPingYingProperties.getExtFilePath();
        //若用户没有配置拓展文件则直接返回
        if(extFilePath == null){
            return new PinyinUtil();
        }
        //加载外部拓展字典后返回
        ClassPathResource resource = new ClassPathResource(extFilePath);
        InputStreamReader isr = null;
        try {
            isr = new InputStreamReader(  resource.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        PinyinHelper.addMutilPinyinDict(isr);
        return new PinyinUtil();
    }
}
