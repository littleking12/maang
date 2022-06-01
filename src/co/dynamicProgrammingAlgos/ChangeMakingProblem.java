package co.dynamicProgrammingAlgos;


public class ChangeMakingProblem {
    static int[] denominations = { 1, 2, 5 };

    public static void main(String[] args) {
        System.out.println(subProblem(denominations.length - 1, 4));
    }

    public static int subProblem(int d, int t) {
        if (d < 0)
            return 9999;
        int coinValue = denominations[d];
        int choiceTake;
        if (coinValue > t) {
            choiceTake = 9999;
        } else if (coinValue == t) {
            //target reached
            choiceTake = 1;
        } else {
            //Take and recurse
            choiceTake = 1 + subProblem(d, t - coinValue);
        }

        int choiceLeave;
        if (d < 0) {
            choiceLeave = 9999;
        } else {
            choiceLeave = subProblem(d - 1, t);
        }

        int optimal;
        if (choiceTake <= choiceLeave) {
            optimal = choiceTake;
        } else {
            optimal = choiceLeave;
        }
        return optimal;
    }
}
