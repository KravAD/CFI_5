package AnalisisNumerico;

public class PotenciasMaximos {


    public int potencia(int base, int exponente) {
        if (exponente == 0) {
            return 1;
        } else {
            return base * potencia(base, exponente - 1);
        }
    }

    public int maximo(int[] array, int index) {
        if (index == array.length - 1) {
            return array[index];
        } else {
            return Math.max(array[index], maximo(array, index + 1));
        }
    }
}

