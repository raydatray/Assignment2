package assignment2;
public class World {
    private Caterpillar caterpillar;
    private Position currentFood;
    private Region map;
    private ActionQueue moveSet;
    private TargetQueue foodSet;
    private GameState gameState;
    public World(TargetQueue food, ActionQueue moves){
        this.caterpillar = new Caterpillar();
        this.map = new Region(0,0,15,15);
        this.moveSet = moves;
        this.foodSet = food;

        this.currentFood = this.foodSet.dequeue();
        this.gameState = GameState.MOVE;
    }
    public void step() {

    }
    public GameState getState(){ return this.gameState; }
    public Caterpillar getCaterpillar(){ return this.caterpillar; }
    public Position getFood(){ return this.currentFood; };
    public boolean isRunning(){ return (this.gameState == GameState.MOVE || this.gameState == GameState.EAT); }
}
