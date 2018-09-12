package codeinterview.netease0908;

import java.util.Scanner;

class Voter {
    int vote;
    int value;
}

public class Vote {

    static int indexMax(int[] a) {
        int indexMax = 0;
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
                indexMax = i;
            }
        }
        return indexMax;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Voter[] voters = new Voter[n];
        //记录候选人票数
        int[] voteMap = new int[m];
        //记录
        int[] voteVale = new int[m];

        for (int i = 0; i < n; i++) {
            Voter voter = new Voter();
            voter.vote = sc.nextInt();
            voter.value = sc.nextInt();
            voteMap[voter.vote - 1]++;
            voters[i] = voter;
        }
        if (indexMax(voteMap) == 0) System.out.println(0);
        else{

        }
    }
}
