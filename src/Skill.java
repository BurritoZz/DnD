public class Skill {
    public Skills type;
    public Stat stat;
    public boolean proficient;

    public Skill(Skills type, Stat stat, boolean proficient) {
        this.type = type;
        this.stat = stat;
        this.proficient = proficient;
    }

    public void setType(Skills type) {
        this.type = type;
    }

    public void setStat(Stat stat) {
        this.stat = stat;
    }

    public void setProficient(boolean proficient) {
        this.proficient = proficient;
    }

    public Skills getType() {
        return this.type;
    }

    public Stat getStat() {
        return this.stat;
    }

    public boolean getProficient() {
        return this.proficient;
    }
}
