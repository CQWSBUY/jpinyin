package io.github.jpinyin;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;


/**
 * Configuration properties for JPingYing.
 *
 * @author Moky
 */
@ConfigurationProperties(prefix = "jpingying",ignoreInvalidFields = true)
public class JPingYingProperties {

    private static final ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();

    /**
     * 外部拓展字典位置
     */
    private String extFilePath;

    public String getExtFilePath() {
        return extFilePath;
    }

    public void setExtFilePath(String extFilePath) {
        this.extFilePath = extFilePath;
    }

    private Resource[] getResources(String location) {
        try {
            return resourceResolver.getResources(location);
        } catch (IOException e) {
            return new Resource[0];
        }
    }
}
