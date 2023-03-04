package assignment2;

public class TargetQueue extends MyQueue<Position>{
    private MyStack<String> input;
    public TargetQueue(){
        super();
    }
    public void clear() { this.input.clear(); super.clear(); }

    //Literal string parsing hell
    //Format: (x,y).(x,y).
    //If (, check if stack already has anything in it. If it does throw an error, else push it on
    //If a digit, check if the stack has a ( or a , in it on top. Ensure size of stack is exactly 1 or 3
    // If not, throw an error, else push it on.
    //If a , , check if the stack has a digit on the top. Ensure size of stack is exactly 2 ( (digit
    // If not throw an error, else push it on
    //If ), check if top of stack has a digit and is of length 4. Pack the input, send it to position and clear the stack


    public void addTargets(String inputString){
        for (int i = 0; i < inputString.length(); i++){
            char x = inputString.charAt(i);

            if(x == '('){
                if(this.input.isEmpty()) {
                    this.input.push(String.valueOf(x));
                }else{
                    throw new IllegalArgumentException("Invalid Input: ( before closing");
                }
            }else if (Character.isDigit(x)) {
                if(((this.input.peek().equals("(")) && (this.input.getSize() == 1))
                        || ((this.input.peek().equals(",")) && (this.input.getSize() == 3))){
                    this.input.push(String.valueOf(x));
                } else {
                    throw new IllegalArgumentException("Invalid Input: Digit provided before ( opened or , provided");
                }
            }else if (x == ','){
                String top = this.input.peek();
                if(!(Character.isDigit(top.charAt(0))) || this.input.getSize() !=2 ) { //this is so fucking ghetto
                    throw new IllegalArgumentException(", provided before digit");
                } else {
                    this.input.push(String.valueOf(x));
                }
            }else if (x == ')'){
                String top = this.input.peek();
                if(!(Character.isDigit(top.charAt(0))) || this.input.getSize() != 4 ) {
                    throw new IllegalArgumentException("), provided before full set");
                } else {
                    int yCoord = Integer.parseInt(this.input.pop());
                    this.input.pop();
                    int xCoord = Integer.parseInt(this.input.pop());
                    this.input.clear();
                    Position newEntry = new Position(xCoord,yCoord);
                    super.enqueue(newEntry);
                }
            } else {
                throw new IllegalArgumentException("Illegal character found");
            }
        }
    }
}
