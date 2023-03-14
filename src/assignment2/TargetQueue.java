package assignment2;
public class TargetQueue extends MyQueue<Position>{
    private MyStack<String> input;
    public TargetQueue(){
        super();
        this.input = new MyStack<String>();
    }
    public void clear() { this.input.clear(); super.clear(); }

    // ( -> Stack must be empty
    // digit -> Peek must be ( & size 1, digit & size 2 or 4, , & size 3
    // , -> Peek must be number & size 2
    // ) -> Peek must be numeric & size 4
    // . -> Have a flag for a successfully parsed "entry"

    //Helper function to check if a string is numeric
    private static boolean isNumeric(String input){
        if (input == null) {
            return false;
        }
        if (input.length() == 0){
            return false;
        }
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c < '0' || c > '9'){
                return false;
            }
        }
        return true;
    }
    public void addTargets(String inputString){
        this.input.clear();
        boolean entryParsed = false;

        for (int i = 0; i < inputString.length(); i++){
            char x = inputString.charAt(i);

            if(x == '(') {
                if(this.input.isEmpty()){
                    this.input.push(Character.toString(x));
                } else {
                    throw new IllegalArgumentException(" '(' found before previous ')' closed");
                }
            } else if (Character.isDigit(x)) {
                String top = null;
                int length = this.input.getSize();

                try {
                    top = this.input.peek();
                } catch (Exception e){
                    throw new IllegalArgumentException("x");
                }

                if ((length == 1 && top.equals("(")) || (length == 3 && top.equals(","))) {
                    this.input.push(String.valueOf(x));
                } else if (isNumeric(top) && (length == 2 || length == 4)){
                    this.input.pop();
                    this.input.push(top + x);
                } else {
                    throw new IllegalArgumentException("digit provided in illegal position");
                }
            } else if (x == ',') {
                String top = null;
                int length = this.input.getSize();

                try {
                    top = this.input.peek();
                } catch (Exception e){
                    throw new IllegalArgumentException("x");
                }

                if (isNumeric(top) && length == 2) {
                    this.input.push(String.valueOf(x));
                } else {
                    throw new IllegalArgumentException("',' found before at (digit provided");
                }
            } else if (x == ')') {
                String top = null;
                int length = this.input.getSize();

                try {
                    top = this.input.peek();
                } catch (Exception e){
                    throw new IllegalArgumentException("x");
                }

                if (isNumeric(top) && length == 4) {
                    int yCoord = Integer.parseInt(this.input.pop());
                    this.input.pop();
                    int xCoord = Integer.parseInt(this.input.pop());
                    this.input.clear();
                    Position newEntry = new Position(xCoord,yCoord);
                    super.enqueue(newEntry);
                    entryParsed = true;
                } else {
                    throw new IllegalArgumentException("')' found before full set of coordinates provided");
                }
            } else if (x == '.'){
                if (entryParsed) {
                    entryParsed = false;
                } else {
                    throw new IllegalArgumentException(" '.' found before successful entry parsed");
                }
            } else {
                throw new IllegalArgumentException("Illegal character found");
            }
        }
    }

    private static void testRunner(String[] tests, TargetQueue testInstance){
        for (String test : tests) {
            System.out.println("Testing using test string: " + test);
            try {
                testInstance.addTargets(test);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        TargetQueue test = new TargetQueue();
        String test1 = "(1,2).(3,4).(5,6)"; //Base Test Case
        String test2 = "(1000000000,2).(1,2147483647)"; //Should work regardless of how long one of your coords are

        //Illegal positioning of .
        String test3 = ".(1,24)";
        String test4 = "(.12,6)";
        String test5 = "(1.2,6)";
        String test6 = "(12.,6)";
        String test7 = "(12,.6)";
        String test8 = "(12,6.7)";
        String test9 = "(12,67.)";
        //String test10 = "(12,8)."; //?

        //Illegal parentheses
        String test11 = "3()";
        String test12 = "(1)";
        String test13 = "(1,)";
        String test14 = "(()";
        String test15 = "())";
        String test16 = "(1())";
        String test17 = "(9,9).(14,7).(10,7).(5,6).(1,9)";

        String[] tests1 = {test3,test4,test5,test6,test7,test8,test9};
        String[] tests2 = {test11,test12,test13,test14,test15,test16};
        String[] tests3 = {test17};

        testRunner(tests3,test);
        //test.addTargets(test2);

    }
}
