package optional;

import javafx.util.Pair;

public class Token {
    private Pair<Integer, Integer> values;

    /**
     * constructor
     * @param token1
     * @param token2
     */
    public Token(int token1, int token2) {
        this.values = new Pair<>(token1, token2);
    }


    @Override
    public String toString() {
        return "" + values.getKey()+"-"+values.getValue();
    }

    /**
     * getter
     * @return
     */
    public Pair<Integer,Integer> getValues() {
        return values;
    }
}