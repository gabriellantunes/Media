
package principal;

import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Principal {

    public static void main(String[] args) {
        ArrayList<Aluno> aluno = new ArrayList<Aluno>();
        ArrayList<Notas> notas = new ArrayList<Notas>();
        
        Operacoes operacoes = new Operacoes();
        boolean sair = false;
        boolean voltar = false;
        
        while(!sair){
            int operacao = operacoes.selecionarOpcoes();
            
            if(operacao == 1){
                operacoes.cadastraAluno(aluno);
                continue;
            } else if(operacao == 2){
               operacoes.cadastraNota(aluno, notas);
               continue;
            } else if(operacao == 3){
                operacoes.mostraMediaGeral(aluno);
                continue;
            }  else if(operacao == 4){
                sair = true;
                continue;
            } else{
                JOptionPane.showConfirmDialog(null,"Opção Invalida","Projeto Media Notas", JOptionPane.ERROR_MESSAGE);
            }
            sair = !operacoes.continuarOperacao();
        }
        
        
    }
    
}
