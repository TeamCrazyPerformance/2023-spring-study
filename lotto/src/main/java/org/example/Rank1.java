enum Rank1 {
    THREE(3,100), FOUR(4,500), Five(5,1500), FIVE_BONUS(5,30000), SIX(6,2000000);
    private int number;
    private int amount;
    Rank1(int number,int amount){
        this.number = number;
        this.amount = amount;
    }
    public int getNumber() {
        return number;
    }
    public int getAmount() {
        return amount;
    }
}