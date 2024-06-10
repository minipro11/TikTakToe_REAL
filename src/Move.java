public class Move {
    private boolean space;
    private boolean circle;
    private boolean X;
    public Move() {
        space = true;
    }

    public boolean getCircle() {
        return circle;
    }
    public boolean getX() {
        return X;
    }
    public boolean canMove() {
        return space;
    }
    public void setCircle(boolean x) {
        circle = x;
    }
    public void setX(boolean x) {
        X = x;
    }

    public void moved() {
        space = false;
    }

}//
