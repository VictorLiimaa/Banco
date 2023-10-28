import java.util.Date;
import java.util.List;
import java.util.ArrayList;


public abstract class Conta {
    private String agencia;
    private String numero;
    protected double saldo;
    private Cliente cliente;
    private Notificacao notificacao;

    private List<Transacao> transacoes;

    public Conta(String agencia, String numero, Cliente cliente, int transferenciasRealizadas, Notificacao notificacao) {
        this.agencia = agencia;
        this.numero = numero;
        this.cliente = cliente;
        this.saldo = 0;
        this.notificacao = notificacao;
        this.transacoes = new ArrayList<Transacao>();
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            this.saldo -= valor;
            getNotificacao().enviaNotificacao("Saque", valor);
            getTransacoes().add(new Transacao("Saque", valor));
        } else {
            System.out.println("Saldo insuficiente");
        }
    }
    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public void transferir(Conta contaDestino, double valor) {
        if (valor <= saldo) {
            this.saldo -= valor;
            contaDestino.depositar(valor);
            getNotificacao().enviaNotificacao("Transferencia", valor);
            getTransacoes().add(new Transacao("Transferencia", valor));
        } else {
            System.out.println("Saldo insuficiente");
        }
    }
    
    public void exibirExtrato() {
        System.out.println("Data: " + new Date());
        System.out.println("Saldo: " + this.saldo);
    }

    public String getAgencia() {
        return agencia;
    }

    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void notificacao(String tipo, double valor) {
        notificacao.enviaNotificacao(tipo, valor);
    }

    public void setNotificacao (Notificacao notificacao) {
        this.notificacao = notificacao;
    }

    public Notificacao getNotificacao() {
        return notificacao;
    }





    
} 
    


