package questao02;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class RepositorioPessoas {

    private ArrayList<Pessoa> pessoas;

    public RepositorioPessoas() {
        this.pessoas = new ArrayList<>();
    }

    public void cadastrarPessoa(Pessoa pessoa) {
        long tamanho = 0;
        for (int i = 0; i < pessoas.size(); i++) {
            if(!pessoa.equals(pessoas.get(i)))
                tamanho++;
        }

        if(tamanho == pessoas.size())
            pessoas.add(pessoa);
    }

    public ArrayList<Pessoa> listarPessoasMaioresIdade() {
        ArrayList<Pessoa> lista = new ArrayList<>();
        for (Pessoa verificar : pessoas) {
            if(verificar.idade() >= 18)
                lista.add(verificar);
        }
        return lista;
    }

    public ArrayList<Cliente> listarClientesMaioresIdade() {
        ArrayList<Cliente> lista = new ArrayList<>();
        for(Pessoa verificar : pessoas) {
            if(verificar instanceof Cliente && verificar.idade() >= 18)
                lista.add((Cliente)verificar);
        }
        return lista;
    }

    public ArrayList<Funcionario> listarFuncionariosComSalarioMaiorQue(double salario) {
        ArrayList<Funcionario> lista = new ArrayList<>();
        for(Pessoa verificar : pessoas){
            if(verificar instanceof Funcionario && ((Funcionario) verificar).getSalario() > salario)
                lista.add((Funcionario)verificar);
        }
        return lista;
    }

    public ArrayList<Gerente> listarGerentesDaArea(String area) {
        ArrayList<Gerente> lista = new ArrayList<>();
        for(Pessoa verificar : pessoas) {
            if(verificar instanceof Gerente && ((Gerente) verificar).getArea().equals(area))
                lista.add((Gerente) verificar);
        }
        return lista;
    }
}
