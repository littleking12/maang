package co.recursion;

public class TowerOfHanoi {

    public static void main(String[] args) {
        solveTower(6,'A','B','C');
    }

    public static void solveTower(int numberOfDisks, char a, char b, char c) {

        if(numberOfDisks == 1){
            System.out.println("Move disk 1 from "+a+" to "+c);
            return;
        }
        solveTower(numberOfDisks-1,a,c,b);
        System.out.println("Move disk "+numberOfDisks+" from "+a+" to "+c);
        solveTower(numberOfDisks-1,b,a,c);
    }
}
