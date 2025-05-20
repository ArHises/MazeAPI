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

    public boolean equals(MazePoint other) {
        return this.x == other.x && this.y == other.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "x: " + x + ", y: " + y;
    }
}
