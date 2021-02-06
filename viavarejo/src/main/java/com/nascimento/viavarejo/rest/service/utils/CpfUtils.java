package com.nascimento.viavarejo.rest.service.utils;


public class CpfUtils {
    public static boolean validateCpf(String cpfString) {
        cpfString = cpfString.replace("-", "").replace(".", "");
        if (cpfString.length() != 11) 
            return false;
        

        if (cpfString.chars().distinct().count() <= 1)
            return false;
        
        

        int[] cpf = cpfString.chars().toArray();

        int num;
        char dig10, dig11;

        int sm = 0;
        int peso = 10;

        for (int i = 0; i < 9; i++) {
            num = (cpf[i] - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
        }

        int r = 11 - (sm % 11);

        if ((r == 10) || (r == 11))
            dig10 = '0';
        else
            dig10 = (char) (r + 48);

        sm = 0;
        peso = 11;

        for (int i = 0; i < 10; i++) {
            num = (cpf[i] - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
        }

        r = 11 - (sm % 11);

        if ((r == 10) || (r == 11))
            dig11 = '0';
        else
            dig11 = (char) (r + 48);
        if ((dig10 == cpf[9]) && (dig11 == cpf[10]))
            return true;
        else
            return false;
    }
}
