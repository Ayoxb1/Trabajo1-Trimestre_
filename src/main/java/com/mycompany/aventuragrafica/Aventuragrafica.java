package com.mycompany.aventuragrafica;

import modulos.*;

 // INDICE


// ===== VARIABLES GLOBALES ===== 7

// ===== MAIN ===== 18

// ===== INICIO GENERAL ===== 27

// ===== INICIO DEL JUEGO ===== 58

// ===== ESCENA PRINCIPAL (CIUDAD) ===== 118

// ===== PLAZA CENTRAL ===== 148

// ===== ALAMEDA AULLANTE ===== 215

// ===== CENTRAL NUCLEAR ===== 265

// ===== ESTACIÓN CENTRAL ===== 316

// ===== BARRIO ANTIGUO ===== 360 

// ===== MERCADO MAYORISTA ===== 407

// ===== ZONA TIENDA / BAZAR ===== 435

// ===== ACERTIJO 1 (SUCEC. FIBONACCI) ===== 526


public class Aventuragrafica {

    // ===== VARIABLES GLOBALES =====
    static int dinero;
    static boolean pergamino1 = false;
    static boolean pergamino2 = false;
    static boolean pergamino3 = false;
    static boolean hablarSeñor = false;
    static boolean colarseAtras = false;
    static boolean colarseTienda = false;

    static String nombreJug;

    // ===== MAIN =====
    public static void main(String[] args) {
        inicio();
        presentacionJuego();
        datosPersonajes();
        inicioJuego();
        FuncionesGraficas.warning("Fin del juego", "Has terminado el juego, enhorabuena " + nombreJug);
    }

    // ===== INICIO GENERAL =====
    static void inicio() {
        dinero = 0;
        pergamino1 = pergamino2 = pergamino3 = false;
        hablarSeñor = false;
        colarseAtras = false;
        colarseTienda = false;

        nombreJug = FuncionesGraficas.pedirDatos("Bienvenido",
                "¿Cuál es tu nickname?");
    }

   static void presentacionJuego() {
    Reproductor.reproducir("src/main/java/resources/Sonidos/Layton1.mp3");

    FuncionesGraficas.FotoyMensaje(
            "Portada",
            "src/main/java/resources/imagenes/inicio_general/PORTADA IMAGEN BUENA.png",
            "Profesor Layton: Misterio de la Ciudad Subterránea",
            0.4,
            false
    );
}


    static void datosPersonajes() {
        String nombreMujer = FuncionesGraficas.pedirDatos("Personaje 1", "Nombre de la chica:");
        String nombreHombre = FuncionesGraficas.pedirDatos("Personaje 2", "Nombre del chico:");
        // Si luego los necesitas, guárdalos en variables globales
    }

    // ===== INICIO DEL JUEGO =====
    static void inicioJuego() {
        escena_papel_suelo();
        escena_mirando_papel();
        escena_mirando_jeroglificos();
        escena_cama_conver();
        capturarTiempo();
        escenaPrincipal();
    }
                                                                                                       
    static void escena_papel_suelo() {
        FuncionesGraficas.FotoyMensaje(
                "Una hoja en el suelo",
                "src/main/java/resources/imagenes/inicio_del_juego/imagen_perso_papel_fondo.png",
                "Encuentras un papel misterioso tirado en el suelo.",
                0.5,
                false
        );
    }

    static void escena_mirando_papel() {
        FuncionesGraficas.FotoyMensaje(
                "Mirando el papel",
                "src/main/java/resources/imagenes/inicio_del_juego/papel_jeroglificos.png",
                "El papel contiene unos extraños jeroglíficos.",
                0.5,
                false
        );
    }

    static void escena_mirando_jeroglificos() {
        FuncionesGraficas.FotoyMensaje(
                "Jeroglíficos",
                "src/main/java/resources/imagenes/inicio_del_juego/leyendo.png",
                "Intentas descifrar el mensaje oculto.",
                0.5,
                false
        );
    }

    static void escena_cama_conver() {
        FuncionesGraficas.FotoyMensaje(
                "Conversación",
                "src/main/java/resources/imagenes/inicio_del_juego/conver_cama.png",
                "Comentas el hallazgo con tu compañero.",
                0.5,
                false
        );
    }

    static void capturarTiempo() {
        FuncionesGraficas.FotoyMensaje(
                "Cuenta atrás",
                "src/main/java/resources/imagenes/inicio_del_juego/Imagen central nmuclear.png",
                "Algo importante va a ocurrir en la ciudad...",
                0.4,
                false
        );
    }

    // ===== ESCENA PRINCIPAL (CIUDAD) =====
    static void escenaPrincipal() {

        String[] opciones = {
            "1. Ir a plaza central",
            "2. Ir a mercado mayorista",
            "3. Ir a barrio antiguo",
            "4. Ir a alameda aullante",
            "5. Ir a estación central"
        };

        int eleccion = FuncionesGraficas.FotoMensajeMenu(
                "Ciudad",
                opciones,
                "src/main/java/resources/imagenes/escena_principal_(ciudad)/ciudad_juego.png",
                "Te encuentras en la ciudad. ¿A dónde quieres ir?",
                0.4,
                false
        );

        switch (eleccion) {
            case 0 -> plazaCentral();
            case 1 -> mercadoMayorista();
            case 2 -> barrioAntiguo();
            case 3 -> alamedaAullante();
            case 4 -> estacionCentral();
            default -> escenaPrincipal();
        }
    }

    // ===== PLAZA CENTRAL =====
   static void plazaCentral() {
Reproductor.reproducir("src/main/java/resources/Sonidos/Ciudad.mp3");

    String[] opciones = {
        "1. Hablar con el señor",
        "2. Observar la alcantarilla",
        "3. Ir al barrio antiguo",
        "4. Ir a alameda aullante",
        "5. Ir a mercado mayorista",
        "6. Ir a estación central"
    };

    int eleccion = FuncionesGraficas.FotoMensajeMenu(
        "Plaza Central",
        opciones,
        "src/main/java/resources/imagenes/plaza_central/plaza_central.png",  // ruta desde donde ejecutes el jar
        "La aventura comienza en la plaza central.\n¿Qué quieres hacer?",
        0.4,
        false
    );

    switch (eleccion) {
        case 0 -> { // Hablar con el señor
            if (!hablarSeñor) {
                FuncionesGraficas.FotoyMensaje(
                    "Señor misterioso",
                    "src/main/java/resources/imagenes/plaza_central/EscenaHablandoConSeñorfuera.png",
                    "El señor te da información importante sobre la ciudad subterránea.",
                    0.4,
                    false
                );
                hablarSeñor = true;
            } else {
                FuncionesGraficas.FotoyMensaje(
                    "Señor",
                    "src/main/java/resources/imagenes/plaza_central/EscenaHablandoConSeñorfuera.png",
                    "Ya has hablado con el señor. No tiene nada nuevo que decir.",
                    0.4,
                    false
                );
            }
            plazaCentral();
        }
        case 1 -> { // Alcantarilla
            escenaAlcantarilla();
            plazaCentral();
        }
        case 2 -> barrioAntiguo();
        case 3 -> alamedaAullante();
        case 4 -> mercadoMayorista();
        case 5 -> estacionCentral();
        default -> plazaCentral();
    }
}

static void escenaAlcantarilla() {
    FuncionesGraficas.FotoyMensaje(
        "Alcantarilla",
        "src/main/java/resources/imagenes/plaza_central/Observando_alcantarilla_mercado_central.png",
        "Te fijas en una extraña alcantarilla en el centro de la ciudad.",
        0.4,
        false
    );
}


    // ===== ALAMEDA AULLANTE =====
   static void alamedaAullante() {
   Reproductor.reproducir("src/main/java/resources/Sonidos/Buho.mp3");
    String[] opciones = {
        "1. Buscar tras el árbol",
        "2. Volver a la plaza central",
        "3. Ir hacia la izquierda",
        "4. Ir hacia la derecha"
    };

    int eleccion = FuncionesGraficas.FotoMensajeMenu(
        "Alameda aullante",
        opciones,
        "src/main/java/resources/imagenes/alameda_aullante/alameda_aullante.png",
        "La alameda está silenciosa, se oyen ruidos extraños.",
        0.4,
        false
    );

    switch (eleccion) {
        case 0 -> {
            FuncionesGraficas.FotoyMensaje(
                "Tras el árbol",
                "src/main/java/resources/imagenes/alameda_aullante/Imagen buscando detras del arbol.png",
                "Buscas tras el árbol y descubres unas huellas extrañas.",
                0.4,
                false
            );
            alamedaAullante();
        }
        case 1 -> plazaCentral();
        case 2 -> {
            FuncionesGraficas.FotoyMensaje(
                "Camino izquierdo",
                "src/main/java/resources/imagenes/alameda_aullante/bifurcacion_camino.png",
                "Tomas el camino de la izquierda.",
                0.4,
                false
            );
        }
        case 3 -> {
            FuncionesGraficas.FotoyMensaje(
                "Camino derecho",
                "src/main/java/resources/imagenes/alameda_aullante/camino_derecha.png",
                "Tomas el camino de la derecha.",
                0.4,
                false
            );
        }
        default -> alamedaAullante();
    }
}


    // ===== CENTRAL NUCLEAR =====
    static void centralNuclear() {

        
        String[] opciones = {
            "1. Investigar alrededores",
            "2. Hablar con el segurata",
            "3. Volver a la estación central",
            "4. Volver a la alameda aullante"
        };

        int eleccion = FuncionesGraficas.FotoMensajeMenu(
                "Central nuclear",
                opciones,
                "src/main/java/resources/imagenes/central_nuclear/central_nuclear.png",
                "Llegas a la central nuclear de las afueras.",
                0.4,
                false
        );

        switch (eleccion) {
            case 0 -> {
                FuncionesGraficas.FotoyMensaje(
                        "Alrededores",
                        "src/main/java/resources/imagenes/central_nuclear/ciudad_aliens.png",
                        "Investigas los alrededores en busca de pistas.",
                        0.4,
                        false
                );
                centralNuclear();
            }
            case 1 -> {
                FuncionesGraficas.FotoyMensaje(
                        "Segurata",
                        "src/main/java/resources/imagenes/central_nuclear/conversacion_guardia.png",
                        "Hablas con el guardia de seguridad.",
                        0.4,
                        false
                );
                centralNuclear();
            }
            case 2 -> estacionCentral();
            case 3 -> alamedaAullante();
            default -> centralNuclear();
        }
    }

    // ===== ESTACIÓN CENTRAL =====
    static void estacionCentral() {

        String[] opciones = {
            "1. Volver a plaza central",
            "2. Ir a mercado mayorista",
            "3. Ir a central nuclear (si tienes dinero)",
            "4. Quedarse mirando la estación"
        };

        int eleccion = FuncionesGraficas.FotoMensajeMenu(
                "Estación central",
                opciones,
                "src/main/java/resources/imagenes/estacion_central/estacion_central.png",
                "La estación central está llena de viajeros.",
                0.4,
                false
        );

        switch (eleccion) {
            case 0 -> plazaCentral();
            case 1 -> mercadoMayorista();
            case 2 -> {
                if (dinero >= 10) {
                    centralNuclear();
                } else {
                    FuncionesGraficas.warning("Sin dinero", "Necesitas al menos 10 monedas para el billete.");
                    estacionCentral();
                }
            }
            case 3 -> {
                FuncionesGraficas.FotoyMensaje(
                        "Andén",
                        "src/main/java/resources/imagenes/estacion_central/estacion central dentro.png",
                        "Te quedas observando a la gente en los andenes.",
                        0.4,
                        false
                );
                estacionCentral();
            }
            default -> estacionCentral();
        }
    }

    // ===== BARRIO ANTIGUO =====
    static void barrioAntiguo() {

        String[] opciones = {
            "1. Entrar a la biblioteca",
            "2. Volver a la plaza central",
            "3. Ir al callejón oscuro"
        };

        int eleccion = FuncionesGraficas.FotoMensajeMenu(
                "Barrio antiguo",
                opciones,
                "src/main/java/resources/imagenes/barrio_antiguo/Biblioteca_callejon.png",
                "Llegas al barrio antiguo de la ciudad.",
                0.4,
                false
        );
    
    // ===== MERCADO MAYORISTA =====
      Reproductor.reproducir("src/main/java/resources/Sonidos/MercadoMayoristaAudio");
        switch (eleccion) {
            case 0 -> entrarBiblioteca();
            case 1 -> plazaCentral();
            case 2 -> callejonOscuro();
            default -> barrioAntiguo();
        }
    }

    static void entrarBiblioteca() {
        FuncionesGraficas.FotoyMensaje(
                "Biblioteca",
                "src/main/java/resources/imagenes/barrio_antiguo/Libreria.png",
                "La biblioteca está llena de estanterías y libros antiguos.",
                0.4,
                false
        );
        // aquí seguiría todo el árbol de la biblioteca si lo desarrollas
    }

    static void callejonOscuro() {
        FuncionesGraficas.FotoyMensaje(
                "Callejón",
                "src/main/java/resources/imagenes/barrio_antiguo/biblioteca_callejon BUENApng.png", // ajusta al nombre exacto
                "Te adentras en un callejón oscuro entre los edificios.",
                0.4,
                false
        );
    }

    // ===== MERCADO MAYORISTA =====
    static void mercadoMayorista() {

        String[] opciones = {
            "1. Ir a la tienda",
            "2. Ir al bazar",
            "3. Ir a estación central",
            "4. Ir a plaza central"
        };

        int eleccion = FuncionesGraficas.FotoMensajeMenu(
                "Mercado mayorista",
                opciones,
                "src/main/java/resources/imagenes/mercado_mayorista/mercado_mayorista.png",
                "El mercado está lleno de puestos y gente.",
                0.4,
                false
        );

        switch (eleccion) {
            case 0 -> irALaTienda();
            case 1 -> irALBazar();
            case 2 -> estacionCentral();
            case 3 -> plazaCentral();
            default -> mercadoMayorista();
        }
    }

    // ===== ZONA TIENDA / BAZAR =====
    static void irALaTienda() {

        String[] opciones = {
            "1. Ir a la tienda",
            "2. Colarse en la parte de atrás de la tienda",
            "3. Ir atrás"
        };
    
        int eleccion = FuncionesGraficas.FotoMensajeMenu(
                "Calle de la tienda",
                opciones,
                "src/main/java/resources/imagenes/Zona_tienda_bazar/yendo_tienda.png",
                "Te acercas a la tienda del mercado.",
                0.4,
                false
        );

        switch (eleccion) {
            case 0 -> {
                FuncionesGraficas.FotoyMensaje(
                        "Interior tienda",
                        "src/main/java/resources/imagenes/Zona_tienda_bazar/dependiente_mercado.png",
                        "Entras en la tienda por la puerta principal.",
                        0.4,
                        false
                );
                irALaTienda();
            }
            case 1 -> {
                if (colarseTienda) {
                    FuncionesGraficas.warning("Aviso", "Alguien debería saber que te sigues colando...");
                } else {
                    colarseTienda();
                }
                irALaTienda();
            }
            case 2 -> mercadoMayorista();
            default -> irALaTienda();
        }
    }

    static void irALBazar() {

        String[] opciones = {
            "1. Hablar con la dependienta",
            "2. Volver atrás"
        };

        int eleccion = FuncionesGraficas.FotoMensajeMenu(
                "Bazar",
                opciones,
                "src/main/java/resources/imagenes/Zona_tienda_bazar/dependiente_mercado.png",
                "La dependienta te mira con curiosidad.",
                0.4,
                false
        );

        switch (eleccion) {
            case 0 -> acertijo1();
            case 1 -> mercadoMayorista();
            default -> irALBazar();
        }
    }

    static void colarseTienda() {

        String[] opciones = {
            "1. Forzar cerradura",
            "2. Volver atrás"
        };

        int eleccion = FuncionesGraficas.FotoMensajeMenu(
                "Puerta trasera",
                opciones,
                "src/main/java/resources/imagenes/Zona_tienda_bazar/puerta_atras_tienda.png",
                "Llegas a la parte trasera de la tienda y ves una puerta con candado.",
                0.4,
                false
        );

        switch (eleccion) {
            case 0 -> {
                acertijo1();
                colarseTienda = true;
            }
            case 1 -> { /* volver sin hacer nada */ }
            default -> colarseTienda();
        }
    }

    // ===== ACERTIJO 1 (SUCEC. FIBONACCI) =====
    static int acertijo1() {

        FuncionesGraficas.FotoyMensaje(
                "Acertijo",
                "src/main/java/resources/imagenes/Acertijo/Acertijo_biblio.png",
                "Observas la sucesión y tratas de adivinar el siguiente número.",
                0.4,
                false
        );

        int n = FuncionesGraficas.pedirEntero(
                "Acertijo",
                "Introduce el siguiente número de la sucesión:"
        );

        int correcto = 8;   // pon aquí el valor real

        if (n == correcto) {
            FuncionesGraficas.FotoyMensaje(
                    "Correcto",
                    "src/main/java/resources/imagenes/Acertijo/cofre_abierto.png",
                    "¡Has acertado! La caja fuerte se abre.",
                    0.4,
                    false
            );
        } else {
            FuncionesGraficas.FotoyMensaje(
                    "Incorrecto",
                    "src/main/java/resources/imagenes/Acertijo/Despensa chino caja fuerte.png",
                    "No es el número correcto. La caja sigue cerrada.",
                    0.5,
                    false
            );
        }

        return n;
    }
}


