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
    public void moveWest(){
        if(this.x == 0) {
            throw new IllegalArgumentException("This move is illegal");
        } else {
            this.x--;
        }
    }
    public void moveEast(){ this.x++; }
    public void moveNorth(){
        if(this.y == 0){
            throw new IllegalArgumentException("This move is illegal");
        } else {
            this.y--;
        }
    }
    public void moveSouth(){ this.y++; }
    public boolean equals(Object o){
        if(o == null) {
            return false;
        } else if (!(o instanceof Position)){
            return false;
        } else {
            return ((this.x == ((Position) o).x) && (this.y == ((Position) o).y));
        }
    }
    private void printPosition() {
        System.out.println("X coord :" + this.getX() + " Y coord: " + this.getY());
    }
    public static void main(String[] args) {
        Position origin = new Position(0,0);
        Position fiveZero = new Position(5,0);
        Position zeroFive = new Position(0,5);
        try {
            Position illegalX = new Position(-1,0);
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            Position illegalY = new Position(0,-1);
        } catch (Exception e) {
            System.out.println(e);
        }
        Position fiveZeroDupe = new Position(fiveZero);
        origin.printPosition();
        fiveZero.printPosition();
        zeroFive.printPosition();
        fiveZeroDupe.printPosition();


    }
}
