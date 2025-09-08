import java.util.ArrayList;
import java.util.List;

class Reserva {
    private String nome;
    private int hora;

    public Reserva(String nome, int hora) {
        this.nome = nome;
        this.hora = hora;
    }

    public String getNome() {
        return nome;
    }

    public int getHora() {
        return hora;
    }

    @Override
    public String toString() {
        return "Reserva [nome=" + nome + ", hora=" + hora + "h]";
    }
}

class SistemaReservas {
    private List<Reserva> reservas = new ArrayList<>();

    public boolean adicionarReserva(String nome, int hora) {
        if (hora < 8 || hora > 18) {
            System.out.println("❌ Horário inválido! A sala só pode ser reservada entre 8h e 18h.");
            return false;
        }

        for (Reserva r : reservas) {
            if (r.getHora() == hora) {
                System.out.println("❌ Horário já reservado por: " + r.getNome());
                return false;
            }
        }

        Reserva nova = new Reserva(nome, hora);
        reservas.add(nova);
        System.out.println("✅ Reserva confirmada: " + nova);
        return true;
    }

    public void listarReservas() {
        if (reservas.isEmpty()) {
            System.out.println("Nenhuma reserva cadastrada.");
        } else {
            System.out.println("\n📅 Reservas confirmadas:");
            for (Reserva r : reservas) {
                System.out.println(r);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SistemaReservas sistema = new SistemaReservas();

        sistema.adicionarReserva("Maria", 9);
        sistema.adicionarReserva("João", 10);
        sistema.adicionarReserva("Ana", 9); // deve falhar
        sistema.adicionarReserva("Carlos", 19); // inválido
        sistema.listarReservas();
    }
}
