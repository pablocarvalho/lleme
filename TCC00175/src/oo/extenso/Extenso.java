package oo.extenso;

public class Extenso {

    public static String extenso(long numero) {
        return extensoDezena((byte) (numero % 100));
    }

    private static String extensoUnidade(byte digito) {
        digito = (byte) (digito % 10);
        switch (digito) {
            case 0:
                return "zero";
            case 1:
                return "um";
            case 2:
                return "dois";
            case 3:
                return "três";
            case 4:
                return "quatro";
            case 5:
                return "cinco";
            case 6:
                return "seis";
            case 7:
                return "sete";
            case 8:
                return "oito";
            case 9:
                return "nove";
            default:
                return "";
        }
    }

    private static String extenso1aDezena(byte dezena) {
        dezena = (byte) (dezena % 100);
        switch (dezena) {
            case 10:
                return "dez";
            case 11:
                return "onze";
            case 12:
                return "doze";
            case 13:
                return "treze";
            case 14:
                return "quatorze";
            case 15:
                return "quinze";
            case 16:
                return "dezesseis";
            case 17:
                return "dezessete";
            case 18:
                return "dezoito";
            case 19:
                return "dezenove";
            default:
                return "";
        }
    }

    private static String extensoDezena(byte dezena) {
        dezena = (byte) (dezena % 100);
        if (dezena < 10)
            return extensoUnidade(dezena);
        else if (dezena < 20)
            return extenso1aDezena(dezena);
        else if (dezena < 30)
            return "vinte e " + extensoUnidade((byte) (dezena % 10));
        else if (dezena < 40)
            return "trinta  e " + extensoUnidade((byte) (dezena % 10));
        else if (dezena < 50)
            return "quarenta e " + extensoUnidade((byte) (dezena % 10));
        else if (dezena < 60)
            return "cinquenta e " + extensoUnidade((byte) (dezena % 10));
        else if (dezena < 70)
            return "sessenta e " + extensoUnidade((byte) (dezena % 10));
        else if (dezena < 80)
            return "setenta e " + extensoUnidade((byte) (dezena % 10));
        else if (dezena < 90)
            return "oitenta e " + extensoUnidade((byte) (dezena % 10));
        else if (dezena < 100)
            return "noventa e " + extensoUnidade((byte) (dezena % 10));
        else
            return "";
    }
}
