package cn.godbol.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by li on 2017-11-23 下午9:38.
 */
//@ConfigurationProperties("storage")
public class StorageProperties {

    /**
     * Folder location for storing files
     */
    private String location = "upload-dir";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
