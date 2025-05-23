package Design.LLD.SnakeLadder;

public class Player {
    private final String playerName;
    private int position;

    public Player(String playerName){
        this.playerName = playerName;
        position = 0;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
