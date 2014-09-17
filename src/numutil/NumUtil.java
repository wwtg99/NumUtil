/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package numutil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Number computation functions
 * 
 * @author wwt
 */
public class NumUtil {

    public static double[] getDoubleVector(String str, String del){
        String[] ss = str.split(del);
        double[] d = new double[ss.length];
        for(int i = 0; i < ss.length; i++){
            d[i] = Double.parseDouble(ss[i]);
        }
        return d;
    }
    
    public static int[] getIntVector(String str, String del){
        String[] ss = str.split(del);
        int[] d = new int[ss.length];
        for(int i = 0; i < ss.length; i++){
            d[i] = Integer.parseInt(ss[i]);
        }
        return d;
    }

    public static String vector2String(double[] array, String del){
        StringBuilder sb = new StringBuilder();
        for(double d:array){
            sb.append(d).append(del);
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    public static String vector2String(int[] array, String del){
        StringBuilder sb = new StringBuilder();
        for(int d:array){
            sb.append(d).append(del);
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    public static String matrix2String(double[][] matrix, String del){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                sb.append(matrix[i][j]).append(del);
            }
            sb.delete(sb.length() - del.length(), sb.length());
            sb.append("\n");
        }
        return sb.toString();
    }
    
    public static String matrix2String(int[][] matrix, String del){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                sb.append(matrix[i][j]).append(del);
            }
            sb.delete(sb.length() - del.length(), sb.length());
            sb.append("\n");
        }
        return sb.toString();
    }

    public static double[][] getDoubleMatrix(String str, String del){
        String[] line = str.split("\n");
        double[][] out = new double[line.length][];
        for(int i = 0; i < line.length; i++){
            String s = line[i];
            String[] ss = s.split(del);
            out[i] = new double[ss.length];
            for(int j = 0; j < ss.length; j++){
                out[i][j] = Double.parseDouble(ss[j]);
            }
        }
        return out;
    }
    
    public static int[][] getIntMatrix(String str, String del){
        String[] line = str.split("\n");
        int[][] out = new int[line.length][];
        for(int i = 0; i < line.length; i++){
            String s = line[i];
            String[] ss = s.split(del);
            out[i] = new int[ss.length];
            for(int j = 0; j < ss.length; j++){
                out[i][j] = Integer.parseInt(ss[j]);
            }
        }
        return out;
    }
    
    /*
    阶乘
    
    */
    public static int factorial(int n){
        if(n == 0) return 1;
        if(n == 1) return 1;
        return n * factorial(n - 1);
    }
    
    /*
    组合 C
    @Param n 总数， m 选择数
    */
    public static int combination(int n, int m){
        return factorial(n) / (factorial(m) * factorial(n - m));
    }
    
    /*
    数组中选出n个值的所有组合, n个值必须不同
    */
    public static double[][] pickFromArray(double[] array, int n){
        if(n <= 0 || n > array.length) return null;
        if(n == 1){
            double[][] out = new double[array.length][1];
            for (int i = 0; i < array.length; i++) {
                out[i][0] = array[i];
            }
            return out;
        }
        double[][] preout = pickFromArray(array, n - 1);
        List<double[]> out = new LinkedList<>();
        for (int i = 0; i < preout.length; i++) {
            Arrays.sort(preout[i]);
            for (int j = 0; j < array.length; j++) {
                if(Arrays.binarySearch(preout[i], array[j]) < 0){
                    double[] newrow = new double[preout[i].length + 1];
                    System.arraycopy(preout[i], 0, newrow, 0, preout[i].length);
                    newrow[newrow.length - 1] = array[j];
                    out.add(newrow);
                }
            }
        }
        preout = new double[out.size()][];
        preout = out.toArray(preout);
        preout = removeSameRow(preout);
        return preout;
    }
    
    /*
    删除矩阵相同行
    */
    public static double[][] removeSameRow(double[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            Arrays.sort(matrix[i]);
        }
        List<double[]> out = new LinkedList<>();
        for (int i = 0; i < matrix.length - 1; i++) {
            if(matrix[i] == null) continue;
            for (int j = i + 1; j < matrix.length; j++) {
                if(Arrays.equals(matrix[i], matrix[j])){
                    matrix[j] = null;
                }
            }
        }
        for (double[] ds : matrix) {
            if(ds != null){
                out.add(ds);
            }
        }
        matrix = new double[out.size()][];
        matrix = out.toArray(matrix);
        return matrix;
    }
    
    /*
    数组中选出n个值的所有组合, n个值必须不同
    */
    public static int[][] pickFromArray(int[] array, int n){
        if(n <= 0 || n > array.length) return null;
        if(n == 1){
            int[][] out = new int[array.length][1];
            for (int i = 0; i < array.length; i++) {
                out[i][0] = array[i];
            }
            return out;
        }
        int[][] preout = pickFromArray(array, n - 1);
        List<int[]> out = new LinkedList<>();
        for (int i = 0; i < preout.length; i++) {
            Arrays.sort(preout[i]);
            for (int j = 0; j < array.length; j++) {
                if(Arrays.binarySearch(preout[i], array[j]) < 0){
                    int[] newrow = new int[preout[i].length + 1];
                    System.arraycopy(preout[i], 0, newrow, 0, preout[i].length);
                    newrow[newrow.length - 1] = array[j];
                    out.add(newrow);
                }
            }
        }
        preout = new int[out.size()][];
        preout = out.toArray(preout);
        preout = removeSameRow(preout);
        return preout;
    }
    
    /*
    删除矩阵相同行
    */
    public static int[][] removeSameRow(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            Arrays.sort(matrix[i]);
        }
        List<int[]> out = new LinkedList<>();
        for (int i = 0; i < matrix.length - 1; i++) {
            if(matrix[i] == null) continue;
            for (int j = i + 1; j < matrix.length; j++) {
                if(Arrays.equals(matrix[i], matrix[j])){
                    matrix[j] = null;
                }
            }
        }
        for (int[] ds : matrix) {
            if(ds != null){
                out.add(ds);
            }
        }
        matrix = new int[out.size()][];
        matrix = out.toArray(matrix);
        return matrix;
    }
    
    /*
    输出+-g[0]+-g[1]+-g[2]+-g[3]...的所有结果
    */
    public static int[] plusSubtractArray(int[] g){
        int[][] gm = new int[g.length][2];
        for (int i = 0; i < gm.length; i++) {
            gm[i][0] = g[i];
            gm[i][1] = -g[i];
        }
        int[] tmpout = gm[0];
        for (int i = 1; i < g.length; i++) {            
            tmpout = plusSubtractArrays(gm[i], tmpout);
        }
        
        return tmpout;
    }
    
    //revised
    /*
    输出数组gp内所有元素加数组g内所有元素的所有结果
    */
    public static int[] plusSubtractArrays(int[] g, int[] gp){
        Set<Integer> out = new HashSet<>();
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < gp.length; j++) {
                out.add(g[i] + gp[j]);
            }
        }
        int[] array = new int[out.size()];
        int i = 0;
        for (Integer d : out) {
            array[i++] = d;
        }
        return array;
    }
    
    /*
    输出+-g[0]+-g[1]+-g[2]+-g[3]...的所有结果
    */
    public static double[] plusSubtractArray(double[] g){
        double[][] gm = new double[g.length][2];
        for (int i = 0; i < gm.length; i++) {
            gm[i][0] = g[i];
            gm[i][1] = -g[i];
        }
        double[] tmpout = gm[0];
        for (int i = 1; i < g.length; i++) {            
            tmpout = plusSubtractArrays(gm[i], tmpout);
        }
        
        return tmpout;
    }
    
    /*
    输出数组gp内所有元素加数组g内所有元素的所有结果
    */
//    public static double[] plusSubtractArrays(double[] g, double[] gp){
//        double[] out = new double[gp.length * g.length];
//        for (int i = 0; i < g.length; i++) {
//            for (int j = 0; j < gp.length; j++) {
//                out[i * gp.length + j] = g[i] + gp[j];
//            }
//        }
//        return out;
//    }
    //revised
    public static double[] plusSubtractArrays(double[] g, double[] gp){
        Set<Double> out = new HashSet<>();
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < gp.length; j++) {
                out.add(g[i] + gp[j]);
            }
        }
        double[] array = new double[out.size()];
        int i = 0;
        for (Double d : out) {
            array[i++] = d;
        }
        return array;
    }
    
    /*
    范数
    */
    public static double norm(double n, double[] v1, double[] v2){
        if(v1.length != v2.length){
            throw new IllegalArgumentException();
        }
        if(n < 0 || n > 99){
            throw new IllegalArgumentException();
        }
        double d = 0;
        for(int i = 0; i < v1.length; i++){
            double diff = v1[i] - v2[i];
            if(diff < 0){
                d += Math.pow(-diff, n);
            }else{
                d += Math.pow(diff, n);
            }
        }
        return d;
    }
    
    /*
    归一化
    */
    public static double normalize(double data, double max, double min){
        return (data - min) / (max - min);
    }
    
    public static double[] normalize(double[] v, double[] max, double[] min){
        double[] out = new double[v.length];
        for (int i = 0; i < v.length; i++) {
            out[i] = (v[i] - min[i]) / (max[i] - min[i]);
        }
        return out;
    }
    
    /*
    点积
    */
    public static double dot(double[] v1, double[] v2){
        if(v1.length != v2.length){
            throw new IllegalArgumentException();
        }
        double d = 0;
        for (int i = 0; i < v1.length; i++) {
            d += v1[i] * v2[i];
        }
        return d;
    }
    
    /*
    点积
    */
    public static int dot(int[] v1, int[] v2){
        if(v1.length != v2.length){
            throw new IllegalArgumentException();
        }
        int d = 0;
        for (int i = 0; i < v1.length; i++) {
            d += v1[i] * v2[i];
        }
        return d;
    }
}
