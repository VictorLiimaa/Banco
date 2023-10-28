import java.util.ArrayList;
import java.util.List;

public class ContaPoupanca extends Conta{
    private double taxaSaque;
    private double taxaTransferencia;
    private double rendimento;

    public ContaPoupanca(String agencia, String numero, Cliente cliente, double taxaSaque, double taxaTransferencia, double rendimento, int transferenciasRealizadas, Notificacao notificacoes) {
        super(agencia, numero, cliente, transferenciasRealizadas, notificacoes);
        this.taxaSaque = taxaSaque;
        this.taxaTransferencia = taxaTransferencia;
        this.rendimento = rendimento;
    }

    public void sacar(double valor) {
        double taxa = valor * taxaSaque;
        if (valor + taxa <= saldo) {
            saldo -= valor + taxa;
            getNotificacao().enviaNotificacao("Saque", valor);
            getTransacoes().add(new Transacao("Saque", valor));
        } else {
           System.out.println("Saldo insuficiente"); 
        }
    }

    public void transferir(Conta contaDestino, double valor) {
        double taxa = valor * taxaTransferencia;
        if (valor + taxa <= saldo) {
            saldo -= valor + taxa;
            contaDestino.depositar(valor);
            getNotificacao().enviaNotificacao("Transferencia", valor);
            getTransacoes().add(new Transacao("Transferencia", valor));
        } else {
            System.out.println("Saldo insuficiente");
        }
    }

    public void calcularRendimento() {
        double rend = saldo * rendimento;
        depositar(rend);
    }

    public double getTaxaSaque() {
        return taxaSaque;
    }

    public void setTaxaSaque(double taxaSaque) {
        this.taxaSaque = taxaSaque;
    }

    public double getTaxaTransferencia() {
        return taxaTransferencia;
    }

    public void setTaxaTransferencia(double taxaTransferencia) {
        this.taxaTransferencia = taxaTransferencia;
    }

    public double getRendimento() {
        return rendimento;
    }

    public void setRendimento(double rendimento) {
        this.rendimento = rendimento;
    }

    public void notificacoes() {
        
    }

    public String getTransferenciasRealizadas() {
        return null;
    }

    public void setTransferenciasRealizadas(int transferenciasRealizadas) {
        
        
    }
    

    

    
}
