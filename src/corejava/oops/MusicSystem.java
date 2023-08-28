package src.corejava.oops;

public interface MusicSystem {
    void play();
    void pause();
    void forward(int duration);

    void rewind(int duration);
    void setVolume(int level);
}
