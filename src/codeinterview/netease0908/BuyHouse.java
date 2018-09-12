package codeinterview.netease0908;

import java.util.Scanner;


class HouseDesc {
    int n;
    int k;
}

public class BuyHouse {

    public static int findMax(int n, int k) {
        if (n <= 2) return 0;
        int m = n - k;
        if (m >= k) {
            if (k == 0) return 0;
            else
                return k - 1;
        } else {
            return m;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        HouseDesc[] houseDescs = new HouseDesc[num];
        for (int i = 0; i < num; i++) {
            HouseDesc houseDesc = new HouseDesc();
            houseDesc.n = sc.nextInt();
            houseDesc.k = sc.nextInt();
            if (houseDesc.n < houseDesc.k) return;
            houseDescs[i] = houseDesc;
        }

        for (HouseDesc houseDesc : houseDescs) {
            System.out.println(0 + " " + findMax(houseDesc.n, houseDesc.k));
        }
    }
}
