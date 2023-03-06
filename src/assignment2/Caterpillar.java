package assignment2;
import java.util.Iterator;
public class Caterpillar extends MyDoublyLinkedList<Position> {
    public Caterpillar() {
        super();
        Position startPosition = new Position(7, 7);
        super.addLast(startPosition);
    }

    public Position getHead() {
        return super.peekFirst();
    }
    //Immediately orthogonal ONLY (1 block distance)
    public void eat(Position input) {
        if (super.peekFirst().getDistance(input) != 1){
            throw new IllegalArgumentException("Position to be eaten is not immediately orthogonal to head of caterpillar");
        } else {
            super.addFirst(input);
        }
    }
    //Immediately adjacent ONLY
    //FINISH THIS AFTER ED ANSWER!
    public void move(Position input) {
        Position currentPosition = super.peekFirst();
        if() {

        } else {
            throw new IllegalArgumentException("Position to move to is not adjacent to head of caterpillar")
        }
    }

    public boolean selfCollision(Position input) {
        Iterator<Position> caterpillar = super.iterator();
        while(caterpillar.hasNext()){
            if(caterpillar.next().equals(input)){
                return true;
            }
        }
        return false;
    }
}
