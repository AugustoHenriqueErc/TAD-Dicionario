package app;

import controller.DataValidator;
import controller.TestGenerator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = null;
        boolean exit = false;
        System.out.println("BEM VINDO AO DICIONÁRIO TAD");
        while(!exit) {
            System.out.println("\nVOCÊ PODE REALIZAR OPERAÇÕES PARA MEDIR O CUSTO COMPUTACIONAL DE:\nINSERÇÃO\nREMOÇÃO\nBUSCA\nEM 3 ESTRUTURAS DE DADOS: CIRCULAR LINKED LIST, BINARY TREE E AVL BINARY TREE\nDIGITE A QUANTIDADE DE DADOS QUE GOSTARIA DE REALIZAR OS TESTES\nRECOMENDO NÃO USAR MAIS DE 10000000 DEVIDO AO TEMPO DE PROCESSAMENTO");
            System.out.println("CASO QUEIRA SAIR DIGITE SAIR");
            input = sc.nextLine().trim().toUpperCase();
            if(DataValidator.validadeInput(input)) TestGenerator.generateTests(Integer.parseInt(input));
            else if (input.equals("SAIR")) {
                System.out.println("OBRIGADO POR UTILIZAR O DICIONÁRIO TAD");
                exit = true;
            }
            else{
                System.out.println("NÃO ENTENDI O QUE DESEJA FAZER, POR FAVOR DIGITE NOVAMENTE");
            }
        }

    }
}