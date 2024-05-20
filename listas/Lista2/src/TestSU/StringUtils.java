package TestSU;


public class StringUtils {
    private StringUtils () {
        throw new IllegalStateException("Classe utilitária! Não deve ser instanciada");
    }

    public static String paraMaiscula (String str) {
        return str.toUpperCase();
    }

    public static String paraMinuscula (String str) {
        return str.toLowerCase();
    }

    public static boolean palindromo (String str) {
        char []s = str.toCharArray();
        int i=0, j=str.length() - 1, len = j;
        for (; i <= len/2 ; i++, j--) {
            if (s[i] != s[j])
                return false;
        }
        return true;
    }


}
