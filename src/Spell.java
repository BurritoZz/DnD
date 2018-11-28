public class Spell {
    private String name;
    private String effect;
    private String duration;
    private int level;
    private int range;

    public Spell(String name, String effect, String castingTime, String duration, int level, int range) {
        this.name = name;
        this.effect = effect;
        this.duration = duration;
        this.level = level;
        this.range = range;
    }

    public String getName() {
        return this.name;
    }

    public String getEffect() {
        return this.effect;
    }

    public String getDuration() {
        return this.duration;
    }

    public int getLevel() {
        return this.level;
    }

    public int getRange() {
        return this.range;
    }
}
