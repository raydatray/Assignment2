package assignment2;

public class World {
    private Caterpillar caterpillar;
    private Position currentFood;
    private Region map;
    private ActionQueue moveSet;
    private TargetQueue foodSet;
    private GameState gameState;
    public World(TargetQueue food, ActionQueue moves) {
        this.caterpillar = new Caterpillar();
        this.map = new Region(0, 0, 15, 15);
        this.moveSet = moves;
        this.foodSet = food;

        this.currentFood = this.foodSet.dequeue();
        this.gameState = GameState.MOVE;
    }
    public void step() {
        Direction nextDirection;
        Position nextPosition;

        if(this.moveSet.isEmpty()){
            this.gameState = GameState.NO_MORE_ACTION;
            return;
        }else if (!(this.gameState == GameState.MOVE || this.gameState == GameState.EAT)){
            return;
        }else{
            nextDirection = this.moveSet.dequeue();
            nextPosition =  new Position(getCaterpillar().getHead());
        }

        switch(nextDirection){
            case NORTH -> {
                try{
                    nextPosition.moveNorth();
                } catch (Exception e) {
                    gameState = GameState.WALL_COLLISION;
                    return;
                }
            }
            case SOUTH ->  nextPosition.moveSouth();
            case EAST -> nextPosition.moveEast();
            case WEST -> {
                try{
                    nextPosition.moveWest();
                } catch (Exception e){
                    gameState = GameState.WALL_COLLISION;
                    return;
                }
            }
        }

        if (!map.contains(nextPosition)) {
            gameState = GameState.WALL_COLLISION;
        } else if(caterpillar.selfCollision(nextPosition)){
            gameState = GameState.SELF_COLLISION;
        } else if (nextPosition.equals(currentFood)){
            caterpillar.eat(currentFood);
            if(foodSet.isEmpty()){
                gameState = GameState.DONE;
            } else {
                currentFood = foodSet.dequeue();
            }
        } else {
            caterpillar.move(nextPosition);
            gameState = GameState.MOVE;
        }
    }

    public GameState getState(){ return this.gameState; }
    public Caterpillar getCaterpillar(){ return this.caterpillar; }
    public Position getFood(){ return this.currentFood; };
    public boolean isRunning(){ return (this.gameState == GameState.MOVE || this.gameState == GameState.EAT); }
}
