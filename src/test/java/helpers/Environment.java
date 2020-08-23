package helpers;

public class Environment {
    public static final String
//        webUrl = "http://" + System.getProperty("web_url", "autotests.cloud"),
        remoteDriverUrl = System.getProperty("remote_driver_url"),
        url = System.getProperty("url","src/test/resources/html/001selectors.html"),
        videoStorageUrl = System.getProperty("video_storage_url");
    public static boolean
        isRemoteDriver = remoteDriverUrl != null,
        isVideoOn = videoStorageUrl != null;
}

