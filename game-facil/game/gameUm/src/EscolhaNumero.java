import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class EscolhaNumero {
    public static Scanner leia = new Scanner(System.in);
    public static List<Integer> chutes = new ArrayList<Integer>();
    public static void main(String[] args) throws Exception {
        System.out.println("jogos de descobri o chute! \n escola um dificuldade: \n 1-Fácil \n 2-Médio \n 3-Difícil");
        Integer escolhaDificuldade = 1 ;
        try {
            escolhaDificuldade = EscolhaNumero.leia.nextInt();
        } catch (Exception e) {
            System.out.println("erro tente novamente apenas valores inteiros");
            escolhaDificuldade = EscolhaNumero.leia.nextInt();
        }
        EscolhaNumero.menu(escolhaDificuldade);
    }
    public static void menu(Integer dificuldade){
        Integer numeroEscolhido , numeroTentativas ;
        switch (dificuldade) {
            
            case 1:
                numeroEscolhido = EscolhaNumero.escolaNumeroFacil();
                numeroTentativas = 9 ;

                EscolhaNumero.adivinharNumero(numeroTentativas , numeroEscolhido);
                break;

            case 2:
                numeroEscolhido = EscolhaNumero.escolaNumeroMedio();
                numeroTentativas = 7 ;

                EscolhaNumero.adivinharNumero(numeroTentativas , numeroEscolhido);
                break;
            case 3:
                numeroEscolhido = EscolhaNumero.escolaNumeroDificil();
                numeroTentativas = 5 ;

                EscolhaNumero.adivinharNumero(numeroTentativas , numeroEscolhido);
                break;
                
        }

    }
    public static void adivinharNumero(Integer numeroTentativas , Integer numeroEscolhido){
        for (int i = 0; i < numeroTentativas; i++) {
            System.out.println("chute um numero");
            int chute = 1 ;
            try {
                chute = EscolhaNumero.leia.nextInt();
            } catch (Exception e) {
                System.out.println("valor invalido tente novamente apenas valores inteiros");
                chute = EscolhaNumero.leia.nextInt();
            }
            
            EscolhaNumero.armazenarChutes(chute);

            if (chute == numeroEscolhido) {
                i = numeroTentativas ;
                EscolhaNumero.fimDeJogo();
            }
            else if(i == numeroTentativas){
                EscolhaNumero.fimDeJogo();
            }
            else{
                System.out.println("numero errado tente novamente : "  + numeroTentativas + " / " + i );
            }
        }
        
       
    }
    public static void armazenarChutes(Integer chutee){
        EscolhaNumero.chutes.add(chutee);

    }
    public static void fimDeJogo(){
        System.out.println("números chutados");
        for (int i = 0; i < EscolhaNumero.chutes.size(); i++) {
            EscolhaNumero.chutes.get(i);
        }
        System.out.println("números escolhido :" + 1);// alterar esta linha para o numero escolhido
    }
    public static Integer escolaNumeroFacil(){
        Random numeroAleatorio = new Random();
        Integer escolaNumero = numeroAleatorio.nextInt(100) + 1;

        return escolaNumero ;
    }
    public static Integer escolaNumeroMedio(){
        Random numeroAleatorio = new Random();
        Integer escolaNumero = numeroAleatorio.nextInt(1000) + 1;

        return escolaNumero ;
    }
    public static Integer escolaNumeroDificil(){
        Random numeroAleatorio = new Random();
        Integer escolaNumero = numeroAleatorio.nextInt(10000) + 1;
        
        return escolaNumero ;
    }
}
