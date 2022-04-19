package main.java;

public class Player implements PlayerState{

    private int money;
    private String name;
    
    PlayerState playerState;
    
    //PlayerState lostPlayerState;
    PlayerState wonPlayerState;
    
    public Player() {
        //lostPlayerState = new lostPlayerState(this);
        //wonPlayerState = new WonPlayerState(this);
    }
    
    
    //=========================================
    //SIMPLE GETTERS AND SETTERS
    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    //public PlayerState getloPlayerState() { return lostPlayerState; } 
    public PlayerState getWonPlayerState() { return wonPlayerState; } 
    //=========================================
    // STATE METHODS
    public void setState(PlayerState newState) {
        playerState = newState;
    }
    @Override
    public void hasLost() {
        playerState.hasLost();
        
    }
    @Override
    public void hasWon() {
        playerState.hasWon();
        
    }
    @Override
    public void isOutOfMoney() {
        // TODO Auto-generated method stub
        
    }
    
}
