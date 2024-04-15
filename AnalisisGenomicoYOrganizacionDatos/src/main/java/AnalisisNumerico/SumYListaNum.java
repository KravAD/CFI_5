package AnalisisNumerico;

public class SumYListaNum {
    public int sumatoria(int n) {
        if (n <= 0) {
            return 0;
        } else {
            return n + sumatoria(n - 1);
        }
    }
    public void listarNumeros(int start, int end) {
        if (start > end) {
            return;
        } else {
            System.out.println(start);
            listarNumeros(start + 1, end);
        }
    }
}