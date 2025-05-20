package Model;

public class MazePoint {

    private int x;
    private int y;
    private boolean white;

    public MazePoint(int x, int y, boolean white) {
        this.x = x;
        this.y = y;
        this.white = white;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isWhite() {
        return white;
    }

    @Override
    public String toString() {
        return "x: " + x + ", y: " + y;
    }
}
