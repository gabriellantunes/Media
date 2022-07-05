
package principal;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Operacoes {
    
    public int selecionarOpcoes(){
        String voltar = "1- Cadastrar alunos\n";
        voltar += "2- Cadastrar notas\n";
        voltar += "3- Vizualizar todas as médias dos Alunos\n";
        voltar += "4- Sair do programa";
        String opcao = JOptionPane.showInputDialog(voltar);
	
        return Integer.parseInt(opcao);
    }   
    
    public boolean continuarOperacao(){
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja realizar outra operação?", "Projeto Média Alunos", JOptionPane.YES_NO_OPTION);
        if (opcao == JOptionPane.NO_OPTION){
            return false;
        } else {
            return true;
        }
                
    }
    
    public void cadastraAluno(ArrayList<Aluno> aluno){
        String rga = JOptionPane.showInputDialog(null, "Informe seu RGA: ","Cadastro de aluno", JOptionPane.INFORMATION_MESSAGE);
        String nome = JOptionPane.showInputDialog(null, "Informe seu nome: ","Cadastro de aluno", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso","Projeto Média Alunos", JOptionPane.INFORMATION_MESSAGE);
        float mediaFinal = 0;
        
        Aluno alunoCadastrado = new Aluno(rga, nome, mediaFinal);
        aluno.add(alunoCadastrado);
    }
    
    
    public Aluno buscaRga(ArrayList<Aluno> arrayAluno, String rga){
        Aluno aluno = null;
        
        for(int i = 0; i < arrayAluno.size(); i++){
            if(arrayAluno.get(i).getRga().equals(rga)){
                aluno = arrayAluno.get(i);
                break;
            }
        }
        return aluno;
    }
    
    public int buscaAluno(ArrayList<Aluno> arrayAluno, String rga){
        Aluno aluno = null;
        int i; 
        
        for( i = 0; i < arrayAluno.size(); i++){
            if(arrayAluno.get(i).getRga().equals(rga)){
                aluno = arrayAluno.get(i);
                break;
            }
        }
        return i;
    }
    
    public void cadastraNota(ArrayList<Aluno> aluno, ArrayList<Notas> notas){
        String rga = JOptionPane.showInputDialog(null,"Informe o rga:"," Cadastro Notas", JOptionPane.INFORMATION_MESSAGE);
        Aluno infos = buscaRga(aluno, rga);
        
        if(aluno.contains(infos) == false){
            JOptionPane.showMessageDialog(null, "Esse aluno não foi cadastrado!","Projeto Média Alunos", JOptionPane.INFORMATION_MESSAGE);
        }else{
            String nota = JOptionPane.showInputDialog(null, "Informe a nota: ","Cadastro de notas", JOptionPane.INFORMATION_MESSAGE);
            String peso = JOptionPane.showInputDialog(null, "Informe o peso da nota: ","Cadastro de notas", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso","Projeto Média Alunos", JOptionPane.INFORMATION_MESSAGE);
            double nFinal = Double.parseDouble(nota) * Double.parseDouble(peso);
            Notas notaCadastrada = new Notas(rga, Double.parseDouble(nota), Double.parseDouble(peso), nFinal);
            notas.add(notaCadastrada);
        }
        atualizarMedia(aluno, notas, rga);
        mostraMediaAluno(aluno, rga);
    }
    
    
    public void atualizarMedia(ArrayList<Aluno> aluno, ArrayList<Notas> notas, String rga){
        Aluno infos = buscaRga(aluno, rga);
        double somatoria = 0;
        
        if(aluno.contains(infos) == false){
            JOptionPane.showMessageDialog(null, "Esse aluno não foi cadastrado!","Projeto Média Alunos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            for(int i = 0; i < notas.size(); i++){
                if(notas.get(i).getRga().equals(rga)){
                    somatoria = somatoria + notas.get(i).getnFinal();
                }
            }
            infos.setMediaFinal(somatoria);
        }
    }
    
    public void mostraMediaGeral(ArrayList<Aluno> aluno){
        String saida = "";
        for(Aluno infos : aluno){
            saida += ("Nome: " + infos.getNome() + "\n");
            saida += ("RGA: " + infos.getRga()+ "\n");
            saida += ("Media Final: " + infos.getMediaFinal()+ "\n");
            saida += ("-----------------------\n");
        }
        JOptionPane.showMessageDialog(null, saida,"Projeto Média Alunos", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void mostraMediaAluno(ArrayList<Aluno> aluno, String rga){
        int i = buscaAluno(aluno, rga);
        String saida = "";
        saida += ("Nome: " + aluno.get(i).getNome() + "\n");
        saida += ("RGA: " + aluno.get(i).getRga()+ "\n");
        saida += ("Media Final: " + aluno.get(i).getMediaFinal()+ "\n");
        
        JOptionPane.showMessageDialog(null, saida,"Projeto Média Alunos", JOptionPane.INFORMATION_MESSAGE);
    }
        
}
