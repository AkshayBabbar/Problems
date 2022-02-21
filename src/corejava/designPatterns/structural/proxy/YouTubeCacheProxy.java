package src.corejava.designPatterns.structural.proxy;

import java.util.HashMap;

public class YouTubeCacheProxy implements ThirdPartyYouTubeLib {
    private final ThirdPartyYouTubeLib youTubeService;
    private HashMap<String, Video> cachePopular = new HashMap<>();
    private final HashMap<String, Video> cacheAll = new HashMap<>();


    public YouTubeCacheProxy() {
        this.youTubeService = new ThirdPartyYouTubeClass();
    }

    @Override
    public HashMap<String, Video> popularVideo() {
        if (cachePopular.isEmpty()) {
            cachePopular = youTubeService.popularVideo();
        } else {
            System.out.println("retrived list from cache.");
        }
        return cachePopular;
    }

    @Override
    public Video getVideo(String videoId) {
        Video video = cacheAll.get(videoId);
        if (video == null) {
            video = youTubeService.getVideo(videoId);
            cacheAll.put(videoId, video);
        } else {
            System.out.println("Retrived video '" + videoId + "from cache.");
        }
        return video;

    }

    public void reset() {
        cacheAll.clear();
        cachePopular.clear();
    }
}
