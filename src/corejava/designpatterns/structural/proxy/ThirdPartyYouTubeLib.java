package src.corejava.designpatterns.structural.proxy;

import java.util.HashMap;

public interface ThirdPartyYouTubeLib {
    HashMap<String, Video> popularVideo();


    Video getVideo(String videoId);
}
