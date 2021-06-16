package coreJava.designPatterns.structural.proxy;

import java.util.HashMap;

public class ThirdPartyYouTubeClass implements ThirdPartyYouTubeLib {
    @Override
    public HashMap<String, Video> popularVideo() {
        connectToServer("http://youtube.com");
        return getRandomVideo();
    }

    private HashMap<String, Video> getRandomVideo() {
        System.out.println("Downloading Popular ....  ");

        experienceNetworkLatency();

        HashMap<String, Video> hmap = new HashMap<>();
        hmap.put("catzzzzzzzzz", new Video("sadgahasgdas", "Catzzzz.avi"));
        hmap.put("mkafksangasj", new Video("mkafksangasj", "Dog play with ball.mp4"));
        hmap.put("dancesvideoo", new Video("asdfas3ffasd", "Dancing video.mpq"));
        hmap.put("dlsdk5jfslaf", new Video("dlsdk5jfslaf", "Barcelona vs RealM.mov"));
        hmap.put("3sdfgsd1j333", new Video("3sdfgsd1j333", "Programing lesson#1.avi"));

        System.out.println("Done ");

        return hmap;
    }

    private void connectToServer(String server) {
        System.out.println("Connecting to " + server + "...........");
        experienceNetworkLatency();
        System.out.println("Connected!.." + "\n");
    }

    private void experienceNetworkLatency() {
        int randomeLatency = 4;
        for (int i = 0; i < randomeLatency; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Video getVideo(String videoId) {
        return getSomeVideo(videoId);
    }

    private Video getSomeVideo(String videoId) {

        System.out.println("Downloading Videos.....");

        experienceNetworkLatency();
        Video video = new Video(videoId, "Some Video Title");
        System.out.println("DOne!");

        return video;
    }

}
