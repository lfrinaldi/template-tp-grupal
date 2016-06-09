package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.action.ComplexAction;
import ar.fiuba.tdd.tp.action.SimpleAction;
import ar.fiuba.tdd.tp.action.simple.ChangeAttributeSimpleAction;
import ar.fiuba.tdd.tp.action.simple.LookAroundSimpleAction;
import ar.fiuba.tdd.tp.action.simple.MessageSimpleAction;
import ar.fiuba.tdd.tp.action.simple.MoveChildSimpleAction;
import ar.fiuba.tdd.tp.action.simple.parameter.ExplicitParameter;
import ar.fiuba.tdd.tp.action.simple.parameter.ImplicitParameter;
import ar.fiuba.tdd.tp.action.simple.parameter.Parameter;
import ar.fiuba.tdd.tp.condition.AttributeEqualsCondition;
import ar.fiuba.tdd.tp.condition.ChildrenSizeEqualsCondition;
import ar.fiuba.tdd.tp.condition.HasChildCondition;
import ar.fiuba.tdd.tp.condition.TrueCondition;
import ar.fiuba.tdd.tp.condition.core.Condition;
import ar.fiuba.tdd.tp.model.Game;
import ar.fiuba.tdd.tp.model.GameBuilder;
import ar.fiuba.tdd.tp.model.GameObject;

@SuppressWarnings("CPD-START")
public class EscapeGameBuilder implements GameBuilder {

    @Override
    public Game build() {
        GameObject scene = buildScene();
        Game game = new Game(scene, "El Escape 2");
        game.setMultiPlayer();
        addActions(game);

        return game;
    }

    private void addActions(Game game) {
        addGotoActions(game);
        game.addAction(buildPickComplexAction(game));
        game.addAction(buildMoveCuadroBarcoComplexAction(game));
        game.addAction(buildMoveLibroViejoComplexAction(game));
        game.addAction(buildBreakWindowComplexAction(game));
        game.addAction(buildOpenComplexAction(game));
        game.addAction(buildPutComplexAction(game));
        game.addAction(buildShowComplexAction(game));
        game.addAction(buildLookAroundComplexAction(game));

        game.addAction(buildAddPlayerComplexAction(game));
        game.addAction(buildInitPlayerComplexAction(game));
    }

    private void addGotoActions(Game game) {
        game.addAction(buildGotoComplexAction(game, "Salon1"));
        game.addAction(buildGotoComplexAction(game, "Salon2"));
        game.addAction(buildGotoComplexAction(game, "Salon3"));
        game.addAction(buildGotoComplexAction(game, "Salon4"));
        game.addAction(buildGotoComplexAction(game, "Pasillo"));
        game.addAction(buildGotoComplexAction(game, "BibliotecaAcceso"));
        game.addAction(buildGotoSotanoComplexAction(game));
        game.addAction(buildUseBarandaComplexAction(game));
        game.addAction(buildUseEscaleraComplexAction(game));
        game.addAction(buildGotoBibliotecaComplexAction(game));
        game.addAction(buildGotoAfueraComplexAction(game));
    }

    private GameObject buildScene() {
        GameObject scene = new GameObject("scene");
        scene.addChild(buildRoom1());
        scene.addChild(buildRoom2());
        scene.addChild(buildRoom3());
        scene.addChild(buildRoom4());
        scene.addChild(buildRoom5());
        scene.addChild(buildRoom6());
        scene.addChild(buildRoom7());
        scene.addChild(buildRoom8());

        GameObject foto = new GameObject("Foto");
        scene.addChild(foto);

        return scene;
    }

    private GameObject buildRoom1() {
        GameObject pasillo = new GameObject("Pasillo");
        //GameObject player = new GameObject("player");

        GameObject lapicera = new GameObject("Lapicera");
        pasillo.addChild(lapicera);

        //pasillo.addChild(player);

        return pasillo;
    }

    private GameObject buildRoom2() {
        GameObject salon1 = new GameObject("Salon1");
        GameObject mesa = new GameObject("Mesa");
        GameObject botella = new GameObject("Botella");
        GameObject vaso1 = new GameObject("Vaso1");
        GameObject vaso2 = new GameObject("Vaso2");
        mesa.addChild(botella);
        mesa.addChild(vaso1);
        mesa.addChild(vaso2);

        GameObject silla1 = new GameObject("Silla1");
        GameObject silla2 = new GameObject("Silla2");
        GameObject cuadroTren = new GameObject("CuadroTren");
        GameObject cuadroBarco = new GameObject("CuadroBarco");
        GameObject cajaFuerte = new GameObject("CajaFuerte");
        cuadroBarco.addChild(cajaFuerte);
        GameObject credencial = new GameObject("Credencial");
        cajaFuerte.addChild(credencial);

        salon1.addChild(mesa);
        salon1.addChild(silla1);
        salon1.addChild(silla2);
        salon1.addChild(cuadroTren);
        salon1.addChild(cuadroBarco);

        return salon1;
    }

    private GameObject buildRoom3() {
        GameObject salon2 = new GameObject("Salon2");
        GameObject martillo = new GameObject("Martillo");
        GameObject destornillador1 = new GameObject("Destornillador1");
        GameObject destornillador2 = new GameObject("Destornillador2");
        salon2.addChild(martillo);
        salon2.addChild(destornillador1);
        salon2.addChild(destornillador2);

        return salon2;
    }

    private GameObject buildRoom4() {
        GameObject salon3 = new GameObject("Salon3");
        GameObject llave = new GameObject("Llave");
        salon3.addChild(llave);

        return salon3;
    }

    private GameObject buildRoom5() {
        GameObject bibliotecaAcceso = new GameObject("BibliotecaAcceso");
        GameObject bibliotecario = new GameObject("Bibliotecario");
        bibliotecaAcceso.addChild(bibliotecario);

        return bibliotecaAcceso;
    }

    private GameObject buildRoom6() {
        GameObject biblioteca = new GameObject("Biblioteca");
        GameObject estante = new GameObject("Estante");
        GameObject libroViejo = new GameObject("LibroViejo");
        GameObject libro1 = new GameObject("Libro1");
        GameObject libro2 = new GameObject("Libro2");
        GameObject libro3 = new GameObject("Libro3");
        GameObject libro4 = new GameObject("Libro4");
        GameObject libro5 = new GameObject("Libro5");
        GameObject libro6 = new GameObject("Libro6");
        GameObject libro7 = new GameObject("Libro7");
        GameObject libro8 = new GameObject("Libro8");
        GameObject libro9 = new GameObject("Libro9");

        biblioteca.addChild(estante);
        biblioteca.addChild(libro1);
        biblioteca.addChild(libro2);
        biblioteca.addChild(libro3);
        biblioteca.addChild(libro4);
        biblioteca.addChild(libro5);
        biblioteca.addChild(libro6);
        biblioteca.addChild(libro7);
        biblioteca.addChild(libro8);
        biblioteca.addChild(libro9);
        biblioteca.addChild(libroViejo);

        return biblioteca;
    }

    private GameObject buildRoom7() {
        GameObject sotano = new GameObject("Sotano");
        GameObject escalera = new GameObject("Escalera");
        GameObject baranda = new GameObject("Baranda");
        sotano.addChild(escalera);
        sotano.addChild(baranda);

        return sotano;
    }

    private GameObject buildRoom8() {
        GameObject baranda = new GameObject("Baranda");
        GameObject ventana = new GameObject("Ventana");
        baranda.addChild(ventana);

        return baranda;
    }

    private ComplexAction buildAddPlayerComplexAction(Game game) {
        String name = "add player";
        String command = "add player <parameter>";
        ComplexAction complexAction = new ComplexAction(name, command, game);
        complexAction.addAction(buildAddPlayerSimpleAction(game, complexAction));

        return complexAction;
    }

    private SimpleAction buildAddPlayerSimpleAction(Game game, ComplexAction complexAction) {
        Parameter childParameter = new ExplicitParameter(2); //player
        Parameter targetParameter = new ImplicitParameter("Pasillo");

        return new MoveChildSimpleAction(complexAction, new TrueCondition(), childParameter,
                targetParameter, "New player added");
    }

    private ComplexAction buildInitPlayerComplexAction(Game game) {
        String name = "init player";
        String command = "init player <parameter>";
        ComplexAction complexAction = new ComplexAction(name, command, game);
        complexAction.addAction(buildInitPlayerSimpleAction(game, complexAction));

        return complexAction;
    }

    private SimpleAction buildInitPlayerSimpleAction(Game game, ComplexAction complexAction) {
        Parameter targetParameter = new ExplicitParameter(2); //player
        Parameter childParameter = new ImplicitParameter("Foto");

        return new MoveChildSimpleAction(complexAction, new TrueCondition(), childParameter,
                targetParameter, "Ok");
    }

    private ComplexAction buildGotoBibliotecaComplexAction(Game game) {
        String name = "goto Biblioteca";
        String command = "goto <parameter> <player>";
        ComplexAction complexAction = new ComplexAction(name, command, game);
        SimpleAction simpleAction = buildGotoCantBibliotecaSimpleAction(game, complexAction);
        complexAction.addAction(simpleAction);
        simpleAction = buildGotoBibliotecaSimpleAction(game, complexAction);
        complexAction.addAction(simpleAction);
        simpleAction = buildGotoSimpleAction(game, complexAction, "Entro");
        complexAction.addAction(simpleAction);

        return complexAction;
    }

    private ComplexAction buildGotoSotanoComplexAction(Game game) {
        String name = "goto Sotano";
        String command = "goto <parameter>";
        ComplexAction complexAction = new ComplexAction(name, command, game);
        SimpleAction simpleAction = buildGotoCantSotanoSimpleAction(game, complexAction);
        complexAction.addAction(simpleAction);
        simpleAction = buildGotoSimpleAction(game, complexAction, "Entro");
        complexAction.addAction(simpleAction);

        return complexAction;
    }

    private ComplexAction buildGotoComplexAction(Game game, String roomName) {
        String name = "goto " + roomName;
        String command = "goto <parameter> <player>";
        ComplexAction complexAction = new ComplexAction(name, command, game);
        SimpleAction simpleAction = buildGotoSimpleAction(game, complexAction, "Entro");
        complexAction.addAction(simpleAction);

        return complexAction;
    }

    private ComplexAction buildUseBarandaComplexAction(Game game) {
        String name = "use Baranda";
        String command = "use <parameter> <player>";
        ComplexAction complexAction = new ComplexAction(name, command, game);
        SimpleAction simpleAction = buildUseBarandaSinMartilloSimpleAction(game, complexAction);
        complexAction.addAction(simpleAction);
        simpleAction = buildGotoSimpleAction(game, complexAction, "Uso");
        complexAction.addAction(simpleAction);

        return complexAction;
    }

    private SimpleAction buildUseBarandaSinMartilloSimpleAction(Game game, ComplexAction complexAction) {
        // Si usa la baranda, sin el martillo, pierde.
        Parameter player = new ExplicitParameter(2);
        Parameter martillo = new ImplicitParameter("Martillo");
        Condition<String> condition = new HasChildCondition(game, player, martillo).not(null);
        Parameter scene = new ImplicitParameter("scene");

        String result = "Perdio";
        return new ChangeAttributeSimpleAction(complexAction, condition, scene, result, "lose",
                "true");
    }

    private ComplexAction buildUseEscaleraComplexAction(Game game) {
        String name = "use Escalera";
        String command = "use <parameter>";
        ComplexAction complexAction = new ComplexAction(name, command, game);
        SimpleAction simpleAction = buildUseEscaleraSimpleAction(game, complexAction);
        complexAction.addAction(simpleAction);

        return complexAction;
    }

    private SimpleAction buildUseEscaleraSimpleAction(Game game, ComplexAction complexAction) {
        // Si usa la escalera pierde, no hay ninguna condicion.
        Parameter scene = new ImplicitParameter("scene");

        String result = "Perdio";
        return new ChangeAttributeSimpleAction(complexAction, new TrueCondition(), scene, result, "lose",
                "true");
    }

    private SimpleAction buildGotoCantBibliotecaSimpleAction(Game game, ComplexAction complexAction) {
        Parameter bibliotecario = new ImplicitParameter("Bibliotecario");
        Parameter credencial = new ImplicitParameter("Credencial");
        Condition<String> condition = new HasChildCondition(game, bibliotecario, credencial).not(null);

        String result = "Entro";
        return new MessageSimpleAction(complexAction, condition, result);
    }

    private SimpleAction buildGotoCantSotanoSimpleAction(Game game, ComplexAction complexAction) {
        Parameter libroViejo = new ImplicitParameter("LibroViejo");
        Condition<String> condition = new AttributeEqualsCondition(game, libroViejo, "moved", "false");

        String result = "No hay ningun cuarto con ese nombre";
        return new MessageSimpleAction(complexAction, condition, result);
    }

    private SimpleAction buildGotoBibliotecaSimpleAction(Game game, ComplexAction complexAction) {
        Parameter childParameter = new ExplicitParameter(2); //player
        Parameter targetParameter = new ImplicitParameter("Biblioteca");
        Parameter bibliotecario = new ImplicitParameter("Bibliotecario");
        Parameter credencial = new ImplicitParameter("Credencial");
        Condition<String> condition = new HasChildCondition(game, bibliotecario, credencial);

        String result = "Entro";
        return new MoveChildSimpleAction(complexAction, condition, childParameter,
                targetParameter, result);
    }

    private SimpleAction buildGotoSimpleAction(Game game, ComplexAction complexAction, String result) {
        Parameter childParameter = new ExplicitParameter(2); //player
        Parameter targetParameter = new ExplicitParameter(1);

        return new MoveChildSimpleAction(complexAction, new TrueCondition(), childParameter,
                targetParameter, result);
    }

    private ComplexAction buildGotoAfueraComplexAction(Game game) {
        String name = "goto Afuera";
        String command = "goto <parameter>";
        ComplexAction complexAction = new ComplexAction(name, command, game);
        SimpleAction simpleAction = buildGotoCantAfueraSimpleAction(game, complexAction);
        complexAction.addAction(simpleAction);
        simpleAction = buildGotoAfueraSimpleAction(game, complexAction);
        complexAction.addAction(simpleAction);

        return complexAction;
    }

    private SimpleAction buildGotoCantAfueraSimpleAction(Game game, ComplexAction complexAction) {
        Parameter ventana = new ImplicitParameter("Ventana");
        Condition<String> condition = new AttributeEqualsCondition(game, ventana, "broke", "false");

        String result = "Debe romper la ventana con el martillo";
        return new MessageSimpleAction(complexAction, condition, result);
    }

    private SimpleAction buildGotoAfueraSimpleAction(Game game, ComplexAction complexAction) {
        Parameter ventana = new ImplicitParameter("Ventana");
        Condition<String> condition = new AttributeEqualsCondition(game, ventana, "broke", "true");
        Parameter scene = new ImplicitParameter("scene");

        String result = "Gano";
        return new ChangeAttributeSimpleAction(complexAction, condition, scene, result, "win",
                "true");
    }

    private ComplexAction buildPickComplexAction(Game game) {
        String name = "pick";
        String command = "pick <parameter> <player>";
        ComplexAction complexAction = new ComplexAction(name, command, game);
        SimpleAction simpleAction = buildCantPickSimpleAction(game, complexAction);
        complexAction.addAction(simpleAction);
        simpleAction = buildPickSimpleAction(game, complexAction);
        complexAction.addAction(simpleAction);

        return complexAction;
    }

    private SimpleAction buildPickSimpleAction(Game game, ComplexAction complexAction) {
        Parameter childParameter = new ExplicitParameter(1);
        Parameter targetParameter = new ExplicitParameter(2); //player
        Condition<String> condition = new ChildrenSizeEqualsCondition(game, targetParameter, 0).or(new
                ChildrenSizeEqualsCondition(game, targetParameter, 1)).or(new ChildrenSizeEqualsCondition(game,
                targetParameter, 2)).or(new ChildrenSizeEqualsCondition(game, targetParameter, 3));

        String result = "Agarro";
        return new MoveChildSimpleAction(complexAction, new TrueCondition(), childParameter,
                targetParameter, result);
    }

    private SimpleAction buildCantPickSimpleAction(Game game, ComplexAction complexAction) {
        Parameter targetParameter = new ExplicitParameter(2); //player
        Condition<String> condition = new ChildrenSizeEqualsCondition(game, targetParameter, 0).or(new
                ChildrenSizeEqualsCondition(game, targetParameter, 1)).or(new ChildrenSizeEqualsCondition(game,
                targetParameter, 2)).or(new ChildrenSizeEqualsCondition(game, targetParameter, 3)).not(null);
        String result = "Ya tenes muchas cosas";

        return new MessageSimpleAction(complexAction, condition, result);
    }

    private ComplexAction buildMoveCuadroBarcoComplexAction(Game game) {
        String name = "move CuadroBarco";
        String command = "move CuadroBarco";
        ComplexAction complexAction = new ComplexAction(name, command, game);
        SimpleAction simpleAction = buildMoveCuadroBarcoSimpleAction(game, complexAction);
        complexAction.addAction(simpleAction);
        return complexAction;
    }

    private ComplexAction buildBreakWindowComplexAction(Game game) {
        String name = "break Ventana using Martillo";
        String command = "break Ventana using Martillo";
        ComplexAction complexAction = new ComplexAction(name, command, game);
        SimpleAction simpleAction = buildBreakWindowSimpleAction(game, complexAction);
        complexAction.addAction(simpleAction);
        return complexAction;
    }

    private SimpleAction buildBreakWindowSimpleAction(Game game, ComplexAction complexAction) {
        Parameter player = new ImplicitParameter("Ventana");

        String result = "Rompio";
        return new ChangeAttributeSimpleAction(complexAction, new TrueCondition(), player, result, "broke",
                "true");
    }

    private ComplexAction buildMoveLibroViejoComplexAction(Game game) {
        String name = "move LibroViejo";
        String command = "move LibroViejo";
        ComplexAction complexAction = new ComplexAction(name, command, game);
        SimpleAction simpleAction = buildMoveLibroViejoSimpleAction(game, complexAction);
        complexAction.addAction(simpleAction);
        return complexAction;
    }

    private SimpleAction buildMoveCuadroBarcoSimpleAction(Game game, ComplexAction complexAction) {
        Parameter keyParameter = new ImplicitParameter("CajaFuerte");
        Parameter room1Parameter = new ImplicitParameter("Salon1");

        String result = "Movio";
        return new MoveChildSimpleAction(complexAction, new TrueCondition(), keyParameter, room1Parameter,
                result);
    }

    private SimpleAction buildMoveLibroViejoSimpleAction(Game game, ComplexAction complexAction) {
        Parameter player = new ImplicitParameter("LibroViejo");

        String result = "Aparece pasaje al Sotano";
        return new ChangeAttributeSimpleAction(complexAction, new TrueCondition(), player, result, "moved",
                "true");
    }

    private ComplexAction buildOpenComplexAction(Game game) {
        String name = "open CajaFuerte using";
        String command = "open CajaFuerte using <parameter> <player>";
        ComplexAction complexAction = new ComplexAction(name, command, game);
        SimpleAction simpleAction = buildOpenLockedDoorSimpleAction(game, complexAction);
        complexAction.getSteps().add(simpleAction);
        simpleAction = buildOpenUnlockedDoorSimpleAction(game, complexAction);
        complexAction.getSteps().add(simpleAction);

        return complexAction;
    }

    private SimpleAction buildOpenUnlockedDoorSimpleAction(Game game, ComplexAction complexAction) {
        Parameter childParameter = new ImplicitParameter("Credencial");
        Parameter targetParameter = new ImplicitParameter("Salon1");
        Parameter player = new ExplicitParameter(4); //player
        Parameter llave = new ExplicitParameter(3);
        Condition<String> condition = new HasChildCondition(game, player, llave);

        String result = "Abrio";
        return new MoveChildSimpleAction(complexAction, condition, childParameter,
                targetParameter, result);
    }

    private SimpleAction buildOpenLockedDoorSimpleAction(Game game, ComplexAction complexAction) {
        Parameter player = new ExplicitParameter(4); //player
        Parameter llave = new ExplicitParameter(3);
        Condition<String> condition = new HasChildCondition(game, player, llave).not(null);

        String result = "Necesitas la Llave";
        return new MessageSimpleAction(complexAction, condition, result);
    }

    private ComplexAction buildPutComplexAction(Game game) {
        String name = "put";
        String command = "put <parameter> in <parameter>";
        ComplexAction complexAction = new ComplexAction(name, command, game);
        SimpleAction simpleAction = buildPutSimpleAction(game, complexAction);
        complexAction.addAction(simpleAction);

        return complexAction;
    }

    private SimpleAction buildPutSimpleAction(Game game, ComplexAction complexAction) {
        Parameter childParameter = new ExplicitParameter(1);
        Parameter targetParameter = new ExplicitParameter(3);

        String result = "Puso";
        return new MoveChildSimpleAction(complexAction, new TrueCondition(), childParameter,
                targetParameter, result);
    }

    private ComplexAction buildShowComplexAction(Game game) {
        String name = "show";
        String command = "show <parameter> in <parameter>";
        ComplexAction complexAction = new ComplexAction(name, command, game);
        SimpleAction simpleAction = buildShowSimpleAction(game, complexAction);
        complexAction.addAction(simpleAction);

        return complexAction;
    }

    private SimpleAction buildShowSimpleAction(Game game, ComplexAction complexAction) {
        Parameter childParameter = new ExplicitParameter(1);
        Parameter targetParameter = new ExplicitParameter(3);

        String result = "Mostro";
        return new MoveChildSimpleAction(complexAction, new TrueCondition(), childParameter,
                targetParameter, result);
    }

    private ComplexAction buildLookAroundComplexAction(Game game) {
        String name = "look around";
        String command = "look around <player>";
        ComplexAction complexAction = new ComplexAction(name, command, game);
        SimpleAction simpleAction = buildLookAroundSimpleAction(game, complexAction);
        complexAction.addAction(simpleAction);

        return complexAction;
    }

    private SimpleAction buildLookAroundSimpleAction(Game game, ComplexAction complexAction) {
        Parameter whichParameter = new ExplicitParameter(2);
        String result = "There’s <siblings> in the room.";
        return new LookAroundSimpleAction(complexAction, new TrueCondition(), whichParameter, result);
    }
}
