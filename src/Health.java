public class Health extends Report {
    private int maxHP;
    private int currHP;
    private int tempHP;
    private int successSave;
    private int failureSave;

    public Health(int maxHP, int currHP, int tempHP, int successSave, int failureSave) {
        if (currHP > maxHP) {
            this.currHP = maxHP;
            this.tempHP = tempHP + (currHP - maxHP);
        } else {
            this.currHP = currHP;
            this.tempHP = tempHP;
        }
        this.maxHP = maxHP;
        this.successSave = successSave;
        this.failureSave = failureSave;
    }

    public int heal(int amount) {
        if (currHP == 0) {
            this.successSave = 0;
            this.failureSave = 0;
        }
        this.currHP += amount;
        if (this.currHP > this.maxHP) {
            this.currHP = this.maxHP;
        }
        return this.currHP;
    }

    public void addSuccess() {
        this.successSave += 1;
        if (this.successSave >= 3) {
            this.successSave = 0;
            this.failureSave = 0;
            this.currHP = 1;
        }
    }

    public void addFailure() {
        this.failureSave += 1;
        if (this.failureSave >= 3) {
            report("Character is dead!");
        }
    }

    public int damage(int amount, boolean crit) {
        if (this.tempHP > 0) {
            this.tempHP -= amount;
            if (tempHP < 0) {
                amount = Math.abs(this.tempHP);
                this.tempHP = 0;
            }
        }
        if (this.currHP > 0) {
            this.currHP -= amount;
            if (this.currHP < 0) {
                if (Math.abs(this.currHP) > this.maxHP) {
                    this.failureSave = 3;
                    this.currHP = 0;
                } else {
                    this.currHP = 0;
                }
            }
        } else if (this.currHP == 0) {
            if (crit) {
                this.failureSave += 2;
            } else {
                this.failureSave += 1;
            }
        }
        if (this.failureSave >= 3) {
            report("Character is dead!");
        }
        return this.currHP;
    }

    public void setmaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public void setcurrHP(int currHP) {
        this.currHP = currHP;
    }

    public void settempHP(int tempHP) {
        this.tempHP = tempHP;
    }

    public void setsuccessSave(int successSave) {
        this.successSave = successSave;
    }

    public void setfailureSave(int failureSave) {
        this.failureSave = failureSave;
    }

    public int getmaxHP() {
        return this.maxHP;
    }

    public int getcurrHP() {
        return this.currHP;
    }

    public int gettempHP() {
        return this.tempHP;
    }

    public int getsuccessSave() {
        return successSave;
    }

    public int getfailureSave() {
        return failureSave;
    }

    public String toString() {
        String res = "";
        res += "Maximum HP: " + maxHP + "\n";
        res += "Current HP: " + currHP + "\n";
        res += "Temporary HP: " + tempHP + "\n";
        res += "Current amount of success saves: " + successSave + "\n";
        res += "Current amount of failure saves: " + failureSave + "\n";
        return res;
    }
}
