package assignment2;
public class Position {
    private int x;
    private int y;
    public Position(int x, int y){
        if (x < 0 || y < 0){
            throw new IllegalArgumentException("Coordinates cannot be negative");
        } else {
            this.x = x;
            this.y = y;
        }
    }
    public Position(Position that) {
        this.x = that.x;
        this.y = that.y;
    }
    public void reset(int x, int y){
        if (x < 0 || y < 0){
            throw new IllegalArgumentException("Coordinates cannot be negative");
        } else {
            this.x = x;
            this.y = y;
        }
    }
    public void reset(Position that){
        this.x = that.x;
        this.y = that.y;
    }
    //No math module? (lol)
    public int getDistance(Position that){
        int xDistance = this.x - that.x;
        xDistance = (xDistance < 0) ? -xDistance : xDistance;
        int yDistance = this.y - that.y;
        yDistance = (yDistance < 0) ? -yDistance : yDistance;
        return xDistance + yDistance;
    }
    public int getX(){ return this.x; }
    public int getY(){ return this.y; }
    public boolean moveWest(){
        if(this.x == 0) {
            throw new IllegalArgumentException("This move is illegal");
        } else {
            this.x--;
            return true;
        }
    }
    public boolean moveEast(){ this.x++; return true;}
    public boolean moveNorth(){
        if(this.y == 0){
            throw new IllegalArgumentException("This move is illegal");
        } else {
            this.y--;
            return true;
        }
    }
    public boolean moveSouth(){ this.y++; return true;}
    public boolean equals(Object o){
        if(o == null) {
            return false;
        } else if (!(o instanceof Position)){
            return false;
        } else {
            return ((this.x == ((Position) o).x) && (this.y == ((Position) o).y));
        }
    }
}
