/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package numutil;

/**
 *
 * @author wwt
 */
public class MultiLoop {
    
    private static int num = 0;
    
    public static void multiLoop(int m, int n, int i, int[] al){
        if(i == m - 1){
            for (int j = 0; j < n; j++) {
                //do
                num++;
            }
        }else{
            while(al[i] < n){
                multiLoop(m, n, i + 1, al);
                al[i]++;
                for (int j = i + 1; j < m; j++) {
                    al[j] = 0;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int m = 2, n = 3;
        int[] al = new int[m];
        multiLoop(m, n, 0, al);
        System.out.println(num);
    }
}
