public class DiceRoll {
    private Dices dice;
    private int amount;

    public DiceRoll(Dices dice, int amount) {
        this.dice = dice;
        this.amount = amount;
    }

    public Dices getDice() {
        return this.dice;
    }

    public int getAmount() {
        return this.amount;
    }

    public String toString() {
        return "" + amount + dice;
    }
}
