import java.util.ArrayList;
import java.util.List;

public class ContaCorrente extends Conta {
    private double chequeEspecial;
    private int transferenciasRealizadas;

    public ContaCorrente(String agencia, String numero, Cliente cliente, double chequeEspecial, int transferenciasRealizadas, Notificacao notificacoes) {
        super(agencia, numero, cliente, transferenciasRealizadas, notificacoes);
        this.chequeEspecial = chequeEspecial;
        this.transferenciasRealizadas = 0;
    }

    @Override
    public void transferir(Conta contaDestino, double valor) {
        if (transferenciasRealizadas < 2) {
            super.transferir(contaDestino, valor);
            transferenciasRealizadas++;
            getNotificacao().enviaNotificacao("Transferencia", valor);
            getTransacoes().add(new Transacao("Transferencia", valor));
        } else {
            double taxa = valor * 0.10;
            super.transferir(contaDestino, valor + taxa);
        }
    }

    public double getSaldoComChequeEspecial() {
        return saldo + chequeEspecial;
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    public int getTransferenciasRealizadas() {
        return transferenciasRealizadas;
    }

    public void setTransferenciasRealizadas(int transferenciasRealizadas) {
        this.transferenciasRealizadas = transferenciasRealizadas;
    }

    public void notificacoes() {
    }

    
}