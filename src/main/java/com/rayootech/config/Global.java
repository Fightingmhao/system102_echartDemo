package com.rayootech.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author luchunfang
 * @version 1.0
 * @created 2020/11/16 11:41
 */

@Component
@ConfigurationProperties(prefix = "config")
public class Global {

    /** 上传路径 */
    private static String profile;

    /** 表头*/
    private static String sheetAt;

    public static String getProfile()
    {
        return profile;
    }

    public static String getSheetAt()
    {
        return sheetAt;
    }

    public void setProfile(String profile)
    {
        Global.profile = profile;
    }

    public void setSheetAt(String sheetAt)
    {
        Global.sheetAt = sheetAt;
    }

}
