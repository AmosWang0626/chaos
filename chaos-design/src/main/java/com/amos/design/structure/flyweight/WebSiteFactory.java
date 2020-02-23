package com.amos.design.structure.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * DESCRIPTION: 网站工厂
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 2/23/2020
 */
public class WebSiteFactory {

    private Map<String, Website> publicWebSite = new HashMap<>();

    public Website getPublicWebSite(String websiteName) {
        if (publicWebSite.get(websiteName) == null) {
            publicWebSite.put(websiteName, new PublicWebsite(websiteName));
        }
        return publicWebSite.get(websiteName);
    }

    public Website getPrivateWebSite(String websiteName) {

        return new PublicWebsite(websiteName);
    }

    public int getPublicWebsiteCount() {
        return publicWebSite.size();
    }

}
