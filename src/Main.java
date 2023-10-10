import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<PessoaFisica> listaPf = new ArrayList<>();
        ArrayList<PessoaJuridica> listaPj = new ArrayList<>();
        PessoaFisica metodoPf = new PessoaFisica();
        PessoaJuridica metodoPj = new PessoaJuridica();

        System.out.println("Bem vinde ao sistema de cadastro de Pessoa Física e Juridica");

        Scanner leitor = new Scanner(System.in);

        String opcao;

        do {
            System.out.println("Digite uma opção: 1 - Pessoa Física / 2 - Pessoa Jurídica / 0 - Sair");
            opcao = leitor.nextLine();

            switch (opcao) {
                case "1":
                    String opcaoPF;
                    do {
                        System.out.println("Digite uma opção: 1 - Cadastrar PF / 2 - Listar PF / 0 - Voltar");
                        opcaoPF = leitor.nextLine();

                        switch (opcaoPF) {
                            case "1":
                                PessoaFisica novaPf = new PessoaFisica();
                                Endereco novoEndPf = new Endereco();

                                System.out.println("Digite o nome");
                                novaPf.nome = leitor.nextLine();

                                System.out.println("Digite o CPF");
                                novaPf.cpf = leitor.nextLine();

                                System.out.println("Digite o rendimento");
                                novaPf.rendimento = leitor.nextFloat();

                                System.out.println("Digite a data de nascimento: (dd/mm/aaaa)");
                                novaPf.dataNasc = LocalDate.parse(leitor.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                                Period idade = Period.between(novaPf.dataNasc, LocalDate.now());

                                if (idade.getYears() >= 18) {
                                    System.out.println("Idade Válida!");
                                } else {
                                    System.out.println("Idade Inválida");
                                    break;
                                }
                                System.out.println("Digite o logradouro");
                                novoEndPf.logradouro = leitor.next();


                                System.out.println("Digite o número");
                                novoEndPf.numero = leitor.nextInt();


                                System.out.println("Este endereço é comercia s/n:");
                                String endCom = leitor.next();
                                if (endCom.equals("s") || endCom.equals("S")) {
                                    novoEndPf.endComercial = true;
                                } else {
                                    novoEndPf.endComercial = false;
                                }

                                novaPf.endereco = novoEndPf;

                                listaPf.add(novaPf);

                                System.out.println("Cadastro realizado com sucesso!");
                                break;
                            case "2":
                                if (listaPf.size() > 0) {
                                    for (PessoaFisica cadaPf : listaPf) {
                                        System.out.println("Nome: " + cadaPf.nome);
                                        System.out.println("CPF: " + cadaPf.cpf);
                                        System.out.println("Data de nascimento: " + cadaPf.dataNasc.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                                        System.out.println("Imposto a ser pago: " + metodoPf.CalcularImposto(cadaPf.rendimento));
                                        System.out.println("Endereço: " + cadaPf.endereco.logradouro + "-" + cadaPf.endereco.numero);
                                        System.out.println();
                                        System.out.println("Aperte ENTER para continuar");
                                        leitor.nextLine();
                                    }
                                }
                                break;
                            case "0":
                                System.out.println("Volta");
                                break;
                            default:
                                System.out.println("Opção inválida");
                                break;
                        }
                    } while (!opcaoPF.equals("0"));
                    break;

                case "2":
                    String opcaoPJ;

                    do {
                        System.out.println("Digite uma opção: 1 - Cadastrar PJ / 2 - Listar PJ / 0 - Voltar");
                        opcaoPJ = leitor.nextLine();
                        switch (opcaoPJ) {
                            case "1":
                                PessoaJuridica novaPj = new PessoaJuridica();
                                Endereco novoEndPj = new Endereco();

                                System.out.println("Digite o nome");
                                novaPj.nome = leitor.nextLine();

                                System.out.println("Digite a Razão Social");
                                novaPj.razaoSocial = leitor.nextLine();

                                System.out.println("Digite o CNPJ");
                                novaPj.cnpj = leitor.nextLine();

                                System.out.println("Digite o rendimento");
                                novaPj.rendimento = leitor.nextFloat();

                                System.out.println("Digite o logradouro");
                                novoEndPj.logradouro = leitor.next();

                                System.out.println("Digite o número");
                                novoEndPj.numero = leitor.nextInt();

                                System.out.println("Este endereço é comercia s/n:");
                                String endCom = leitor.next();
                                if (endCom.equals("s") || endCom.equals("S")) {
                                    novoEndPj.endComercial = true;
                                } else {
                                    novoEndPj.endComercial = false;
                                }

                                novaPj.endereco = novoEndPj;

                                listaPj.add(novaPj);

                            break;
                            case "2":
                                if (listaPj.size() > 0) {
                                    for (PessoaJuridica cadaPj : listaPj) {
                                        System.out.println("Nome: " + cadaPj.nome);
                                        System.out.println("CNPJ: " + cadaPj.cnpj);
                                        System.out.println("Razão Social: " + cadaPj.razaoSocial);
                                        System.out.println("Imposto a ser pago: " + metodoPj.CalcularImposto(cadaPj.rendimento));
                                        System.out.println("Endereço: " + cadaPj.endereco.logradouro + "-" + cadaPj.endereco.numero);
                                        System.out.println();
                                        System.out.println("Aperte ENTER para continuar");
                                        leitor.nextLine();
                                    }
                                }
                                break;
                            case "0":
                                System.out.println("Volta");
                                break;
                            default:
                                System.out.println("Opção inválida");
                                break;
                        }

                    } while (!opcaoPJ.equals("0"));
                    break;


                case "0":
                    System.out.println("Voltar");
                    break;

                default:
                    System.out.println("Opção inválida");
                    break;
            }

        } while (!opcao.equals("0"));
    }
}