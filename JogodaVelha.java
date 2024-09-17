import java.util.*;
public class JogodaVelha {
    /*
     * MATRIZ DO JOGO DA VELHA:
     * String[][]
     * { {A, B, C}
     * {D, E, F}
     * {G, H, I} }
     */
    public static String[][] Gerar_colunas(String[][] tabela){
        String[][] colunas = new String[tabela[0].length][tabela.length];
        for (int i = 0; i < tabela.length; i++){
            for (int j = 0; j < tabela[0].length; j++){
                colunas[j][i] = tabela[i][j];
            }
        }
        return colunas;
    }
    public static String[][] Gerar_diagonais(String[][] tabela) {
        String[] diagonalPrincipal = new String[tabela.length];
        String[] diagonalSecundaria = new String[tabela.length];

        // Preenchendo a diagonal principal (esquerda para direita)
        for (int i = 0; i < tabela.length; i++) {
            diagonalPrincipal[i] = tabela[i][i];
        }

        // Preenchendo a diagonal secundária (direita para esquerda)
        for (int i = 0; i < tabela.length; i++) {
            diagonalSecundaria[i] = tabela[i][tabela.length - 1 - i];
        }

        return new String[][] { diagonalPrincipal, diagonalSecundaria };
    }
    public static Boolean verificador(String[][] tabela){
        String[][] colunas = Gerar_colunas(tabela);
        String[][] diagonais = Gerar_diagonais(tabela);
        int contador = 0;
        // verificar se X ganhou
        if (Arrays.toString(tabela[0]).equals("[X, X, X]") || Arrays.toString(tabela[1]).equals("[X, X, X]") || Arrays.toString(tabela[2]).equals("[X, X, X]")){
            System.out.println("Jogador 1 venceu!!");
            return false;
        }else if (Arrays.toString(colunas[0]).equals("[X, X, X]") || Arrays.toString(colunas[1]).equals("[X, X, X]") || Arrays.toString(colunas[2]).equals("[X, X, X]")){
            System.out.println("Jogador 1 venceu!!");
            return false;
        }else if (Arrays.toString(diagonais[0]).equals("[X, X, X]") || Arrays.toString(diagonais[1]).equals("[X, X, X]")){
            System.out.println("Jogador 1 venceu!!");
            return false;
        }
        ///////////////////////////////
        ///////////////////////////////
        //Verificar de O ganhou
        if (Arrays.toString(tabela[0]).equals("[O, O, O]") || Arrays.toString(tabela[1]).equals("[O, O, O]") || Arrays.toString(tabela[2]).equals("[O, O, O]")){
            System.out.println("Jogador 2 venceu!!");
            return false;
        }else if (Arrays.toString(colunas[0]).equals("[O, O, O]") || Arrays.toString(colunas[1]).equals("[O, O, O]") || Arrays.toString(colunas[2]).equals("[O, O, O]")){
            System.out.println("Jogador 2 venceu!!");
            return false;
        }else if (Arrays.toString(diagonais[0]).equals("[O, O, O]") || Arrays.toString(diagonais[1]).equals("[O, O, O]")){
            System.out.println("Jogador 2 venceu!!");
            return false;
        }
        //////////////////////////////////////////////
        /////////////////////////////////////////////
        //verificar Empates
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (tabela[i][j].equals(" ")){
                    contador = contador + 1;
                }
            }
        }
        if (contador == 0){
            System.out.println("EMPATE");
            return false;
        }else{
            return true;
        }
    }
    public static String efetivar_jogada(String jogador, int jogada, String[][] tabela){
        int valor = -1;
        String subs = " ";
        
        if (jogador == "Jogador_1"){
            subs = "X";
        }
        else if (jogador == "Jogador_2"){
            subs = "O";
        }
//////////////////////////////////////////////////////////////////////////////////
        if (jogada <= 3 && jogada >= 1){
            valor = jogada - 1;
            if (tabela[0][valor].equals(" ")){
                return tabela[0][valor] = subs;
            } else {
                System.out.println("Jogada não recebida...");
                return "Paia";
            }
            
        }
        else if (jogada <= 6 && jogada >= 4){
            valor = jogada - 4;
            if (tabela[1][valor].equals(" ")){
                return tabela[1][valor] = subs;
            } else{
                System.out.println("Jogada não recebida...");
                return "Jogada inválida";
            }
            
        }
        else if (jogada <= 9  && jogada >= 7) {
            valor = jogada - 7;
            if (tabela[2][valor].equals(" ")){
                return tabela[2][valor] = subs;
            } else{
                System.out.println("Jogada não recebida...");
                return "Jogada inválida";
            }
        }
        else {
            System.out.println("Jogada não recebida...");
            return "paia";
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        String[][] matriz = {
            {" "," "," "},
            {" "," "," "},
            {" "," "," "}
        };
        Scanner scanner = new Scanner(System.in);
        System.out.println("Olá, bem-vindo ao jogo da velha!");
            System.out.println("esté é o tabuleiro do seu modo original, portanto, coloque números de acordo com a posição desejada: ");
            System.out.printf("\n %d | %d  |%d\r\n" + //
        "---|----|---\r\n" + //
        " %d | %d  |%d\r\n" + // 
        "---|----|---\r\n" + //
         " %d | %d  |%d\r\n",
         1, 2, 3, 4, 5, 6, 7, 8, 9
         );
        System.out.println("Portanto, agora vamos começar:");
         
        while (true) {
            System.out.printf("\nTabuleiro: \n %s |  %s |  %s\r\n" + //
        "---|----|---\r\n" + //
        " %s |  %s |  %s\r\n" + // 
        "---|----|---\r\n" + //
         " %s |  %s |  %s\r\n",
         matriz[0][0], matriz[0][1], matriz[0][2],
         matriz[1][0], matriz[1][1], matriz[1][2],
         matriz[2][0], matriz[2][1], matriz[2][2]);
            System.out.println("Jogador 1: ");
            int J1 = scanner.nextInt();
            efetivar_jogada("Jogador_1", J1, matriz);
            if (!verificador(matriz)){
                break;
            }

            System.out.println("Jogador 2: ");
            int J2 = scanner.nextInt();
            efetivar_jogada("Jogador_2", J2, matriz);
            if (!verificador(matriz)){
                break;
            }
            
        }       
        System.out.printf("\nTabuleiro: \n %s |  %s |  %s\r\n" + //
        "---|----|---\r\n" + //
        " %s |  %s |  %s\r\n" + // 
        "---|----|---\r\n" + //
         " %s |  %s |  %s\r\n",
         matriz[0][0], matriz[0][1], matriz[0][2],
         matriz[1][0], matriz[1][1], matriz[1][2],
         matriz[2][0], matriz[2][1], matriz[2][2]);
        scanner.close();

    }
}