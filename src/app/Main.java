package app;

import controller.TestGenerator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = null;
        boolean exit = false;
        System.out.println("BEM VINDO AO DICIONÁRIO TAD");
        while(!exit) {
            System.out.println("\nPODES REALIZAR OPERAÇÕES PARA MEDIR O CUSTO COMPUTACIONAL DE:\nINSERÇÃO\nREMOÇÃO\nBUSCA\nEM 3 ESTRUTURAS DE DADOS: CIRCULAR LINKED LIST, \nDIGITE PARA QUAL TIPO DE DADOS GOSTARIA DE TESTAR\n[1] BOOKS\n[2] INTEGER\nSEGUIDO DA QUANTIDADE DE DADOS QUE GOSTARIA DE TESTAR\nEXEMPLO: 1, 10000");
            System.out.println("CASO QUEIRA SAIR DIGITE 3");
            input = sc.nextLine().trim().toUpperCase();
            String[] s = input.split(",");
            if(s.length != 2) main(null);
            switch(s[0]) {
                case "1" -> TestGenerator.generateBookTests(Integer.parseInt(s[1].trim()));
                case "2" -> TestGenerator.generateIntegerTests(Integer.parseInt(s[1].trim()));
                case "3" -> exit = true;
                default -> System.out.println("NÃO ENTENDI QUAL TESTE DESEJA REALIZAR, POR FAVOR DIGITE NOVAMENTE");
            };
        }

    }
}