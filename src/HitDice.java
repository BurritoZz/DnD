public class HitDice extends Report {
    private HitDices type;
    private int maxAmount;
    private int currAmount;

    public HitDice(HitDices type, int maxAmount, int currAmount) {
        this.type = type;
        this.maxAmount = maxAmount;
        this.currAmount = currAmount;
    }

    public int usedDice() {
        if (this.currAmount > 0) {
            this.currAmount -= 1;
        } else {
            report("No hitdice left!");
        }
        return this.currAmount;
    }

    public int recoveredDice() {
        this.currAmount += Math.floorDiv(this.maxAmount, 2);
        if (this.currAmount > this.maxAmount)
            this.currAmount = this.maxAmount;
        return this.currAmount;
    }

    public void setType(HitDices type) {
        this.type = type;
    }

    public void setMaxAmount(int maxAmount) {
        this.maxAmount = maxAmount;
    }

    public void setCurrAmount(int currAmount) {
        this.currAmount = currAmount;
    }

    public HitDices getType() {
        return this.type;
    }

    public int getMaxAmount() {
        return this.maxAmount;
    }

    public int getCurrAmount() {
        return this.currAmount;
    }
}
