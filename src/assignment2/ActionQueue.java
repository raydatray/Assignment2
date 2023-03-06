package assignment2;
public class ActionQueue extends MyQueue<Direction>{
    private MyStack<String> directions;
    private MyStack<Integer> counts;
    public ActionQueue() {
        super();
        this.directions = new MyStack<String>();
        this.counts = new MyStack<Integer>();
    }
    public void clear(){
        this.directions.clear();
        this.counts.clear();
        super.clear();
    }
    public void loadFromEncodedString(String inputString){
        this.clear();
        String result = "";
        char lastParsed = 'x';
        int index = 0;
        int bracketsOpened = 0;

        while (index < inputString.length()){
            char c = inputString.charAt(index);

            if(Character.isDigit(c)){
                if(lastParsed == '[' || lastParsed == ']' || index == 0) {
                    int count = 0;
                    while (Character.isDigit(inputString.charAt(index))) {
                        count = 10 * count + (inputString.charAt(index) - '0');
                        index++;
                    }
                    lastParsed = c;
                    this.counts.push(count);
                } else {
                    throw new IllegalArgumentException("Digit provided in illegal position");
                }
            } else if (c == '['){
                if(Character.isDigit(lastParsed) || lastParsed != 'x') {
                    this.directions.push(result);
                    result = "";
                    lastParsed = c;
                    index++;
                    bracketsOpened++;
                } else {
                    throw new IllegalArgumentException("'[' provided in illegal position");
                }
            } else if (c == ']'){
                if (bracketsOpened == 0) {
                    throw new IllegalArgumentException("']' provided before '['");
                } else {
                    StringBuilder temp = new StringBuilder(this.directions.pop());
                    int count = this.counts.pop();
                    for (int i = 0; i < count; i++) {
                        temp.append(result);
                    }
                    result = temp.toString();
                    lastParsed = c;
                    index++;
                    bracketsOpened --;
                }
            } else if (String.valueOf(c).matches("[NSEW]*")){
                if(lastParsed == '[' || lastParsed == ']' || String.valueOf(lastParsed).matches("[NSEW]*") || index == 0) {
                    lastParsed = c;
                    result += c;
                    index++;
                } else {
                    throw new IllegalArgumentException("Direction provided in illegal position");
                }
            } else {
                throw new IllegalArgumentException("Illegal Character found");
            }
        }
        System.out.println(result); //DELETE THIS

        char[] decodedString = result.toCharArray();
        Direction N = Direction.NORTH;
        Direction S = Direction.SOUTH;
        Direction E = Direction.EAST;
        Direction W = Direction.WEST;

        for (char c : decodedString){
            switch(c) {
                case 'N' -> super.enqueue(N);
                case 'S' -> super.enqueue(S);
                case 'E' -> super.enqueue(E);
                case 'W' -> super.enqueue(W);
            }
        }
        super.queue.printList();
    }
    private void testRunner(String[] tests){
        for (String test : tests) {
            System.out.println("Testing using test string: " + test);
            try {
                this.loadFromEncodedString(test);

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args){
        ActionQueue test = new ActionQueue();
        String test1 = "ES";
        String test2 = "3[N]";
        String test3 = "3[NE]";
        String test4 = "3[2[NW]2[E]]S";
        String test5 = "2E[N]";
        String test6 = "EN]";
        String test7 = "E[EN]";
        String test8 = "A";
        String test9 = "3[2[3[N]3[S]]4[W]]";

        String[] tests1 = {test1,test2,test3,test4,test5,test6,test7,test8,test9};

        test.testRunner(tests1);
    }
}
