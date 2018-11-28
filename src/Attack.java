public class Attack {
    private DamageTypes[] types;
    private DiceRoll[] damages;

    public Attack(DamageTypes[] types, DiceRoll[] damages) {
        this.types = types;
        this.damages = damages;
    }

    public String getDamage(boolean crit) {
        String res = "Dealt ";
        for (int i = 0; i < types.length; i++) {
            if (i > 0) {
                res += " and ";
            }
            res += damages[i] + " " + types[i] + " damage";
        }
        return res + ".";
    }
}
