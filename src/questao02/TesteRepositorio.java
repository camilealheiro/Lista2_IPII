package questao02;

import java.time.LocalDate;
import java.util.ArrayList;

public class TesteRepositorio {

    public static void main(String[] args) {

        RepositorioPessoas repositorio = new RepositorioPessoas();

        Pessoa c1 = new Cliente("Caroline", LocalDate.of(1994, 7,1), 1234);
        Pessoa c2 = new Cliente("Regina", LocalDate.of(1963, 6,13), 5678);
        Pessoa c3 = new Cliente("José", LocalDate.of(1955, 5,13), 9012);
        Pessoa c4 = new Cliente("Gabriele", LocalDate.of(2004, 12,10), 3456);
        Pessoa c5 = new Cliente("Doralice", LocalDate.of(2011, 5,22), 7890);
        Pessoa c6 = new Cliente("José", LocalDate.of(1955, 5,13), 9012);
        repositorio.cadastrarPessoa(c1);
        repositorio.cadastrarPessoa(c2);
        repositorio.cadastrarPessoa(c3);
        repositorio.cadastrarPessoa(c4);
        repositorio.cadastrarPessoa(c5);
        repositorio.cadastrarPessoa(c6);

        Pessoa f1 = new Funcionario("Ruth", LocalDate.of(2003, 3, 23), 2500);
        Pessoa f2 = new Funcionario("Leticia", LocalDate.of(2005, 8, 14), 2600);
        Pessoa f3 = new Funcionario("Pedro", LocalDate.of(2003, 6, 12), 3300);
        Pessoa f4 = new Funcionario("Junior", LocalDate.of(2006, 9, 15), 1700);
        Pessoa f5 = new Funcionario("Ester", LocalDate.of(1995, 5, 19), 4900);
        Pessoa f6 = new Funcionario("Leticia", LocalDate.of(2005, 8, 14), 2600);
        repositorio.cadastrarPessoa(f1);
        repositorio.cadastrarPessoa(f2);
        repositorio.cadastrarPessoa(f3);
        repositorio.cadastrarPessoa(f4);
        repositorio.cadastrarPessoa(f5);
        repositorio.cadastrarPessoa(f6);

        Pessoa g1 = new Gerente("Carmem", LocalDate.of(1987, 4,18), 1200, "Interno");
        Pessoa g2 = new Gerente("Ronaldo", LocalDate.of(1993, 7,10), 2507, "Organizacao");
        Pessoa g3 = new Gerente("Silvia", LocalDate.of(1976, 3,27), 5000, "Interno");
        Pessoa g4 = new Gerente("Jorge", LocalDate.of(1999, 1,12), 1500, "Admministracao");
        Pessoa g5 = new Gerente("Junior", LocalDate.of(1985, 2,15), 4300, "Geral");
        Pessoa g6 = new Gerente("Carmem", LocalDate.of(1987, 4,18), 1200, "Interno");
        repositorio.cadastrarPessoa(g1);
        repositorio.cadastrarPessoa(g2);
        repositorio.cadastrarPessoa(g3);
        repositorio.cadastrarPessoa(g4);
        repositorio.cadastrarPessoa(g5);
        repositorio.cadastrarPessoa(g6);

        System.out.println("/**********Listar Pessoas Maiores de Idade**********/");
        ArrayList<Pessoa> lista1 = repositorio.listarPessoasMaioresIdade();
        for (Pessoa pessoa : lista1) {
            System.out.println(pessoa);
        }

        System.out.println();
        System.out.println("/**********Listar Clientes Maiores de idade**********/");
        ArrayList<Cliente> lista2 = repositorio.listarClientesMaioresIdade();
        for (Cliente cliente : lista2) {
            System.out.println(cliente);
        }

        System.out.println();
        System.out.println("/**********Listar Funcionarios com Salarios maiores Que**********/");
        ArrayList<Funcionario> lista3 = repositorio.listarFuncionariosComSalarioMaiorQue(2000);
        for (Funcionario funcionario : lista3) {
            System.out.println(funcionario);
        }

        System.out.println();
        System.out.println("/**********Listar Gerentes da Area**********/");
        ArrayList<Gerente> lista4 = repositorio.listarGerentesDaArea("Interno");
        for (Gerente gerente : lista4) {
            System.out.println(gerente);
        }
    }
}
