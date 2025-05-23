package Design.LLD.SnakeLadder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {

    private final int boardSize;
    private final Map<Integer, Integer> snakes;
    private final Map<Integer, Integer> ladders;

    public Board(int boardSize, List<Snake> snakeList, List<Ladder> ladderList)
    {
        this.boardSize = boardSize;
        this.snakes = new HashMap<>();
        this.ladders = new HashMap<>();

        for(Snake s : snakeList)
        {
            snakes.put(s.getHead(), s.getTail());
        }

        for(Ladder l : ladderList)
        {
            ladders.put(l.getStartPosition(), l.getEndPosition());
        }
    }

    public int getBoardSize(){
        return boardSize;
    }

    public int getNextPosition(int position){
        if(snakes.containsKey(position)) {
            System.out.println("Oops bit by snake");
            return snakes.get(position);
        }
        if(ladders.containsKey(position)) {
            System.out.println("Great! climbed a ladder");
            return ladders.get(position);
        }
        return position;
    }


}
