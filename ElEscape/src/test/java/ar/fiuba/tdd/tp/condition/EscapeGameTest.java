package ar.fiuba.tdd.tp.condition;

import ar.fiuba.tdd.tp.EscapeGameBuilder;
import ar.fiuba.tdd.tp.model.Game;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("CPD-START")
public class EscapeGameTest {

    private Game game;

    @Before
    public void setup() {
        EscapeGameBuilder escapeGameBuilder = new EscapeGameBuilder();
        game = escapeGameBuilder.build();
    }

    private String execute(String command) {
        System.out.println("> " + command);
        String result = game.doCommand(command);
        System.out.println(result);
        return result;
    }

    @Test
    public void escapeGameTest() {
        Assert.assertEquals("Entro", execute("goto BibliotecaAcceso"));
        Assert.assertEquals("Entro", execute("goto Pasillo"));
        Assert.assertEquals("Entro", execute("goto Salon3"));
        Assert.assertEquals("Agarro", execute("pick Llave"));
        Assert.assertEquals("Entro", execute("goto Pasillo"));
        Assert.assertEquals("Entro", execute("goto Salon2"));
        Assert.assertEquals("Agarro", execute("pick Martillo"));
        Assert.assertEquals("Entro", execute("goto Pasillo"));
        Assert.assertEquals("Entro", execute("goto Salon1"));
        Assert.assertEquals("Movio", execute("move CuadroBarco"));
        Assert.assertEquals("Abrio", execute("open CajaFuerte using Llave"));
        Assert.assertEquals("Agarro", execute("pick Credencial"));
        Assert.assertEquals("Puso", execute("put Foto in Credencial"));
        Assert.assertEquals("Entro", execute("goto Pasillo"));
        Assert.assertEquals("Entro", execute("goto BibliotecaAcceso"));
        Assert.assertEquals("Mostro", execute("show Credencial in Bibliotecario"));
        Assert.assertEquals("Entro", execute("goto Biblioteca"));
        Assert.assertEquals("Aparece pasaje al Sotano", execute("move LibroViejo"));
        Assert.assertEquals("Entro", execute("goto Sotano"));
        Assert.assertEquals("Uso", execute("use Baranda"));
        Assert.assertEquals("Rompio" , execute("break Ventana using Martillo"));
    }
}