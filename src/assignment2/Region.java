package assignment2;
public class Region {
    private int minX;
    private int maxX;
    private int minY;
    private int maxY;
    public Region(int minX, int minY, int maxX, int maxY){
        if(minX < 0 || minY < 0){
            throw new IllegalArgumentException("Minimum X and Y values cannot be lower than 0");
        } else {
            this.minX = minX;
            this.maxX = maxX;
            this.minY = minY;
            this.maxY = maxY;
        }
    }
    public boolean contains(Position input){
        return ((this.minX <= input.getX()) && (input.getX() <= this.maxX)) || ((this.minY <= input.getY()) && (input.getY() <= this.maxY));
    }
}
