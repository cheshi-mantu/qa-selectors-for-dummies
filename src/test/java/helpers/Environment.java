package helpers;

public class Environment {
    public static final String
        webUrl = System.getProperty("web_url", null),
        jUserName = System.getProperty("j_username", null),
        jPassword = System.getProperty("j_password", null),
        remoteDriverUrl = System.getProperty("remote_driver_url"),
        url = System.getProperty("url","src/test/resources/html/001selectors.html"),
        videoStorageUrl = System.getProperty("video_storage_url");
    public static boolean
        isRemoteDriver = remoteDriverUrl != null,
        isVideoOn = videoStorageUrl != null;
}

