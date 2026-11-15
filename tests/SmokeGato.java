import gato.Logica.LocalDatabase;
import java.sql.*;
import javax.persistence.EntityManager;
import javax.swing.*;

public class SmokeGato {
    public static void main(String[] args) throws Exception {
        try (Connection c = LocalDatabase.open(); PreparedStatement insert = c.prepareStatement(
                "INSERT INTO dbo.Jugadores (Jugador,Ganes,Perdidas,Empates) VALUES (?,0,0,0)")) {
            insert.setString(1, "Jugador de prueba"); insert.executeUpdate();
            insert.setString(1, "O'Connor"); insert.executeUpdate();
        }
        EntityManager em = LocalDatabase.entityManager();
        if (em.createQuery("SELECT j FROM Jugadores_1 j").getResultList().size() != 2)
            throw new AssertionError("consulta JPA de jugadores");
        em.close();
        SwingUtilities.invokeAndWait(() -> {
            JInternalFrame[] ventanas = {new gato.IU.Frm_NuevoJuego(), new gato.IU.Frm_ListaJugadores(), new gato.IU.Frm_Estadistc()};
            for (JInternalFrame ventana : ventanas) {
                ventana.pack();
                if (ventana.getWidth() <= 0 || ventana.getHeight() <= 0) throw new AssertionError("dimensiones");
                ventana.dispose();
            }
        });
        System.out.println("PASS: JDBC, consulta JPA y construcción de tres pantallas sin servidor externo");
        System.exit(0);
    }
}
