package assignment2;

import javax.swing.*;

public class ActionQueue extends MyQueue<Direction>{
    private MyStack<String> input;
    public ActionQueue() { super(); }
    public void clear() {this.input.clear(); super.clear(); }
    //String parsing hell AGAIN
    //Format: K[D]

    public void loadFromEncodedString(String inputString) {
        for (int i = 0; i < inputString.length(); i++) {
            char x = inputString.charAt(i);

        }
    }
}
