package optional;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode

public class Player implements Runnable {

    private String name;
    private int myTurn;
    private List<Token> myTokens = new ArrayList<>();
    private Board board;
    private String playerType;

    /**
     * constructor
     * @param name
     * @param board
     * @param playerType
     */

    public Player(String name, Board board, String playerType) {
        this.name = name;
        this.board = board;
        this.playerType=playerType;
    }

    /**
     * this method allows players to extract tokens as long as they exist
     * if the player is human then extractTokenHuman() is called, else extractToken is called
     */
    @SneakyThrows
    @Override
    public void run() {

        while(!board.isEmpty())
        {
            if(playerType=="human") {
                Token t = board.extractTokenHuman(myTurn);
                myTokens.add(t);
            }
            else
            {
                Token t = board.extractToken(myTurn);
                myTokens.add(t);
            }
        }
        board.getGame().getWinner();
    }

    /**
     * this method calculate the score of the player
     * @return
     */
    public int getScore()
    {
        int score=0;
        for(int i=0;i<myTokens.size();i++)
            score+=myTokens.get(i).getValues().getKey()*myTokens.get(i).getValues().getValue();
        return score;
    }

    @Override
    public String toString() {
        return "Nume_Player = '" +
                name + '\'';
    }


}