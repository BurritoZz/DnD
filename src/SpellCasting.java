public class SpellCasting extends Report {
    public Stat stat;
    public int[] maxSpellSlots;
    public int[] currSpellSlots;
    public Spell[] spellList;

    public SpellCasting(Stat stat, int[] maxSpellSlots, int[] currSpellSlots, Spell[] spellList) {
        this.stat = stat;
        this.maxSpellSlots = maxSpellSlots;
        this.currSpellSlots = currSpellSlots;
        this.spellList = spellList;
    }

    public int[] castSpell(Spell spell) {
        this.currSpellSlots[spell.getLevel()] -= 1;
        return this.currSpellSlots;
    }

    public int[] refreshSpellSlots() {
        for (int i  = 0; i < this.maxSpellSlots.length; i++) {
            this.currSpellSlots[i] = this.maxSpellSlots[i];
        }
        return this.currSpellSlots;
    }

    public int[] getMaxSpellSlots() {
        return this.maxSpellSlots;
    }

    public int[] getCurrSpellSlots() {
        return this.currSpellSlots;
    }

    public Stats getModifier() {
        return this.stat.getType();
    }

    public Spell[] getSpellList() {
        return this.spellList;
    }

}
