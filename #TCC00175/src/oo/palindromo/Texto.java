package oo.palindromo;

public class Texto {

    /**
     * @attribute
     */
    public String caracteres;

    /**
     * @param str ertertrt
     */
    public Texto(String str) {
        caracteres = str;
    }

    /**
     * @return retert
     */
    public boolean isPalindromo() {
        for (int i = 0; i <= caracteres.length() / 2; i++)
            if (caracteres.charAt(i)
                    != caracteres.charAt(caracteres.length() - i - 1))
                return false;
        return true;
    }

    /**
     * @return ertrt
     */
    public int length() {
        return caracteres.length();
    }

    /**
     * @param index ertrt
     * @return ertet
     */
    public char charAt(int index) {
        return caracteres.charAt(index);
    }

    /**
     * @param start twert
     * @param endr ertwert
     * @return erwtewrt
     */
    public CharSequence subSequence(int start, int end) {
        return caracteres.subSequence(start, end);
    }

    /**
     * @return dsfgdsfg
     */
    public String toString() {
        return caracteres.toString();
    }
}
