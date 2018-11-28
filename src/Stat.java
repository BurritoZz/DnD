public class Stat {
    private Stats type;
    private int val;
    private boolean proficient;

    public Stat(Stats type, int val, boolean proficient) {
        this.type = type;
        if (val > 20) {
            this.val = 20;
        } else if (val < 0){
            this.val = 0;
        }else {
            this.val = val;
        }
        this.proficient = proficient;
    }

    public void setType(Stats type) {
        this.type = type;
    }

    public void setVal(int val) {
        if (val > 20) {
            this.val = 20;
        } else if (val < 0) {
            this.val = 0;
        } else {
            this.val = val;
        }
    }

    public void setProficient(boolean proficient) {
        this.proficient = proficient;
    }

    public Stats getType() {
        return this.type;
    }

    public int getVal() {
        return this.val;
    }

    public boolean getProficient() {
        return this.proficient;
    }

    public int getMod() {
        return Math.floorDiv(10 - getVal(), 2);
    }


    @Override
    public String toString() {
        return "" + type + " " + val + " " + proficient;
    }

}
