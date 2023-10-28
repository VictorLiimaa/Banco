import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int operacao;
        Cliente cliente = new Cliente(null, null, null, null);
        ContaPoupanca contaPoupanca = new ContaPoupanca(null, null, cliente, 0.01, 0.01, 0.01, 0, new NotificacaoSms());
        ContaCorrente contaCorrente = new ContaCorrente(null, null, cliente, 0.01, 0,  new NotificacaoEmail());



       do {
            System.out.println("***********************************");
            System.out.println("********** Banco Maut *************");
            System.out.println("********** Seja Bem Vindo *********");
            System.out.println("***********************************");
            System.out.println("********** Menu Principal *********");
            System.out.println("********** Escolha uma opção! ******");
            System.out.println("***********************************");
            System.out.println("OBS: Para realizar qualquer operação, é necessário abrir uma conta!");
            System.out.println("********************************************************************");
            System.out.println("1. Abrir Conta");
            System.out.println("2. Sacar");
            System.out.println("3. Depositar");
            System.out.println("4. Transferir");
            System.out.println("5. Extrato");
            System.out.println("6. Sair");

            operacao = input.nextInt();

            if(operacao == 1){
                System.out.println("***********************************");
                System.out.println("********** Abrir Conta ************");
                System.out.println("***********************************");
                System.out.println("********** Escolha uma opção! ******");
                System.out.println("***********************************");
                System.out.println("1. Conta Poupança");
                System.out.println("2. Conta Corrente");
                operacao = input.nextInt();

                if(operacao == 1){
                    contaPoupanca = new ContaPoupanca(null, null, cliente, 0.01, 0.01, 0.01, 0, new NotificacaoSms());
                    System.out.println("***********************************");
                    System.out.println("********** Abrir Conta ************");
                    System.out.println("***********************************");
                    System.out.println("********** Conta Poupança *********");
                    System.out.println("***********************************");
                    System.out.println("Digite o nome do cliente: ");
                    String nome = input.next();
                    System.out.println("Digite o cpf do cliente: ");
                    String cpf = input.next();
                    System.out.println("Digite a data de nascimento do cliente: ");
                    String dataNascimento = input.next();
                    System.out.println("Digite o numero do cliente: ");
                    String numero = input.next();
                    System.out.println("Digite o cep do cliente: ");
                    String cep = input.next();
                    System.out.println("Digite a agencia do cliente: ");
                    String agencia = input.next();
                    System.out.println("Digite o numero da conta do cliente: ");
                    String numeroConta = input.next();
                    System.out.println("Parabens, sua conta foi criada com sucesso!");
                }else{
                    contaCorrente = new ContaCorrente(null, null, cliente, 0.01, 0,  new NotificacaoEmail());
                    System.out.println("***********************************");
                    System.out.println("********** Abrir Conta ************");
                    System.out.println("***********************************");
                    System.out.println("********** Conta Corrente *********");
                    System.out.println("***********************************");
                    System.out.println("Digite o nome do cliente: ");
                    String nome = input.next();
                    System.out.println("Digite o cpf do cliente: ");
                    String cpf = input.next();
                    System.out.println("Digite a data de nascimento do cliente: ");
                    String dataNascimento = input.next();
                    System.out.println("Digite o numero do cliente: ");
                    String numero = input.next();
                    System.out.println("Digite o cep do cliente: ");
                    String cep = input.next();
                    System.out.println("Digite a agencia do cliente: ");
                    String agencia = input.next();
                    System.out.println("Digite o numero da conta do cliente: ");
                    String numeroConta = input.next();
                    System.out.println("Parabens, sua conta foi criada com sucesso!");
                }
            }else if(operacao == 2){
                System.out.println("***********************************");
                System.out.println("********** Sacar ******************");
                System.out.println("***********************************");
                System.out.println("********** Escolha uma opção! ******");
                System.out.println("***********************************");
                System.out.println("1. Conta Poupança");
                System.out.println("2. Conta Corrente");
                operacao = input.nextInt();

                if(operacao == 1){
                    System.out.println("***********************************");
                    System.out.println("********** Sacar ******************");
                    System.out.println("***********************************");
                    System.out.println("********** Conta Poupança *********");
                    System.out.println("***********************************");
                    System.out.println("Digite o valor do saque: ");
                    double sacar = input.nextDouble();
                    contaPoupanca.sacar(sacar);
                    contaPoupanca.exibirExtrato();
                    System.out.println("Seu saldo " + contaPoupanca.getSaldo());


                }else{
                    System.out.println("***********************************");
                    System.out.println("********** Sacar ******************");
                    System.out.println("***********************************");
                    System.out.println("********** Conta Corrente *********");
                    System.out.println("***********************************");
                    System.out.println("Digite o valor do saque: ");
                    double sacar = input.nextDouble();
                    contaCorrente.sacar(sacar);
                    contaCorrente.exibirExtrato();
                    if(contaCorrente.getChequeEspecial() > 0){
                        System.out.println("Deseja utilizar Cheque Especial?");
                        System.out.println("1. Sim");
                        System.out.println("2. Não");
                        int opcao = input.nextInt(); 
                    }else{
                        System.out.println("Saque realizado com sucesso!" + contaCorrente.getSaldo());
                    }
                }

            }else if(operacao == 3){
                System.out.println("***********************************");
                System.out.println("********** Depositar **************");
                System.out.println("***********************************");
                System.out.println("********** Escolha uma opção! ******");
                System.out.println("***********************************");
                System.out.println("1. Conta Poupança");
                System.out.println("2. Conta Corrente");
                operacao = input.nextInt();

                if(operacao == 1){
                    System.out.println("***********************************");
                    System.out.println("********** Depositar **************");
                    System.out.println("***********************************");
                    System.out.println("********** Conta Poupança *********");
                    System.out.println("***********************************");
                    System.out.println("Digite o valor do deposito: ");
                    double depositar = input.nextDouble();
                    contaPoupanca.depositar(depositar);
                    contaPoupanca.exibirExtrato();
                    System.out.println("Deposito realizado com sucesso!" + contaPoupanca.getSaldo());

                }else{
                    System.out.println("***********************************");
                    System.out.println("********** Depositar **************");
                    System.out.println("***********************************");
                    System.out.println("********** Conta Corrente *********");
                    System.out.println("***********************************");
                    System.out.println("Digite o valor do deposito: ");
                    double depositar = input.nextDouble();
                    contaCorrente.depositar(depositar);
                    contaCorrente.exibirExtrato();
                    System.out.println("Deposito realizado com sucesso! " + contaCorrente.getSaldo());
                }

            }else if(operacao == 4){
                System.out.println("***********************************");
                System.out.println("********** Transferir *************");
                System.out.println("***********************************");
                System.out.println("********** Escolha uma opção! ******");
                System.out.println("***********************************");
                System.out.println("1. Conta Poupança");
                System.out.println("2. Conta Corrente");
                operacao = input.nextInt();

                if(operacao == 1){
                    System.out.println("***********************************");
                    System.out.println("********** Transferir *************");
                    System.out.println("***********************************");
                    System.out.println("********** Conta Poupança *********");
                    System.out.println("***********************************");
                    System.out.println("Digite o valor da transferencia: ");
                    double transferir = input.nextDouble();
                    contaPoupanca.exibirExtrato();
                    contaPoupanca.transferir(contaCorrente, transferir);

                }else{
                    System.out.println("***********************************");
                    System.out.println("********** Transferir *************");
                    System.out.println("***********************************");
                    System.out.println("********** Conta Corrente *********");
                    System.out.println("***********************************");
                    System.out.println("Digite o valor da transferencia: ");
                    double transferir = input.nextDouble();
                    contaCorrente.exibirExtrato();
                    contaCorrente.transferir(contaPoupanca, transferir);
                }

            }else if(operacao == 5){
                System.out.println("***********************************");
                System.out.println("********** Extrato ****************");
                System.out.println("***********************************");
                System.out.println("********** Escolha uma opção! ******");
                System.out.println("***********************************");
                System.out.println("1. Conta Poupança");
                System.out.println("2. Conta Corrente");
                operacao = input.nextInt();

                if(operacao == 1){
                    System.out.println("***********************************");
                    System.out.println("********** Extrato ****************");
                    System.out.println("***********************************");
                    System.out.println("********** Conta Poupança *********");
                    System.out.println("***********************************");
                    System.out.println("Extrato: ");
                    contaPoupanca.exibirExtrato();

                }else{
                    System.out.println("***********************************");
                    System.out.println("********** Extrato ****************");
                    System.out.println("***********************************");
                    System.out.println("********** Conta Corrente *********");
                    System.out.println("***********************************");
                    System.out.println("Extrato: ");
                    contaCorrente.exibirExtrato();
                }

            }else if(operacao == 6){
                System.out.println("***********************************");
                System.out.println("********** Sair *******************");
                System.out.println("***********************************");
                System.out.println("********** Obrigado! **************");
                System.out.println("***********************************");
                System.out.println("Volte sempre!");
                break;


                
            }
            
        
        }while(operacao != 7);
    }
}

