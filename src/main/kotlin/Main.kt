import kotlin.random.Random
import kotlin.system.exitProcess


fun ahorcado(){
    println("\n\n Seleccione el modo de juego: ")
    println("\t (1) Modo Fácil")
    println("\t (2) Modo Difícil")
    println("\t (0) Salir")
    print("Selección: ")
    var modoDeJuego = readln()  //Con esto pedimos el modo de juego
    while (modoDeJuego != "1" && modoDeJuego != "2" && modoDeJuego != "0" && modoDeJuego.isNullOrEmpty()){
        println("Selección errónea, porfavor introduzca de nuevo su selección: ") // Si lo escriben erroneamente vuelve a preguntarlo
        modoDeJuego  = readln()
    }


    when(modoDeJuego){
        "1" -> {
            val palabras = listOf("audi","bmw","fiat","ford","honda","hyundai","kia","lexus","mazda","nissan",
                "opel","peugeot","porsche","renault","saab","seat","skoda","subaru","suzuki","tesla",
                "toyota","volvo","acura","alfa","bentley","bugatti","cadillac","chevrolet","chrysler","dodge",
                "ferrari","jaguar","jeep","lamborghini","maserati","mclaren","mercedes",
                "mitsubishi","pagani","porsche","ram","subaru","tesla","volkswagen","volvo")
            val random = Random.nextInt(palabras.size)
            val palabra = palabras[random]
            val palabraSecreta = palabra.toCharArray()  //Vamos a convertir la palabra en un array de caracteres

            val palabraAdivinada = CharArray(palabraSecreta.size) //Creo un array con la misma longitud que el array creado antes
            for (i in palabraAdivinada.indices) { //Recorremos todas las posiciones del array y asignamos el '*'
                palabraAdivinada[i] = '*'
            }

            println("Intenta adivinar el nombre de una marca de coche.")
            println("El tamaño de la palabra es el siguiente: "+ String(palabraAdivinada))

            var numeroIntentos:Int = 0
            while (numeroIntentos != 7) {
                println("Numero de intentos restantes: " + (7 - numeroIntentos))
                print("Ingrese una letra que creas que se ecuentra en la plabra o la palabra entera(si deseas envíe un 0):")
                val entrada = readLine()
                if (!entrada.isNullOrEmpty()) { // Si la entrada no es nula hacemos lo siguiente
                    if (entrada.length >= 2) { // Si el usuario escribe la plabra: dos opciones o ganar o perder
                        if (entrada.toLowerCase() == palabra) {
                            println("¡¡ENHORABUENA HAS ADIVINADO LA PALABRA!!")
                            DibujoAhorcado.dibujar(8) //Dibujamos la victoria
                            return

                        } else {
                            println("Lo siento, la palabra no es correcta")
                            println("La palabra era: "+ palabra)
                            DibujoAhorcado.dibujar(7) //Dibujamos la derrota
                            return

                        }
                    } else { // Si no decide poner la palabra quiere decir que escribe una letra
                        if (entrada[0].toLowerCase() in palabraSecreta) { //Con esto comprobamos que la primera letra de la entrada esta incluida en la palabra
                            for (i in palabraSecreta.indices) { // recorremos todas los caracteres de la palabra
                                if (palabraSecreta[i] == entrada[0].toLowerCase()) { // Comprobamso que la letra pedida por el usuario es igual a la letra de la palbra secreta
                                    palabraAdivinada[i] = entrada[0].toLowerCase()   // entonces se actualice el arreglo poniendo la letra adivinada
                                }
                            }
                            if (String(palabraAdivinada) == palabra){
                                println("¡¡ENHORABUENA HAS ADIVINADO LA PALABRA!!")
                                println("La palabra era: "+ String(palabraAdivinada))
                                DibujoAhorcado.dibujar(8) //Dibujamos la victoria
                                return

                            }else {
                                println("¡¡GENIAL!! La letra se encuentra en la palabra " + String(palabraAdivinada))
                            }

                        } else {
                            println("La letra no se encuentra en la palabra, has fallado ")
                            println("Letras adivinadas: " + String(palabraAdivinada))
                            numeroIntentos++;
                            if (numeroIntentos == 7){
                                println("La palabra era: "+ palabra)
                                DibujoAhorcado.dibujar(numeroIntentos)
                                return
                            }else{
                                DibujoAhorcado.dibujar(numeroIntentos)
                            }
                        }
                    }
                }else{
                    println("Valor erróneo, porfavor ingrese un valor correcto.")
                }
            }
            return
        }
        "2" -> {
            val palabras = listOf("manzana", "guitarra", "azul", "perro", "casa", "jardín", "lápiz", "montaña", "papel", "café", "hoja", "nube", "espejo", "ratón", "sol", "playa", "nieve", "teclado", "libro", "ventana", "puerta", "mariposa", "tierra", "luz", "silla", "cielo", "canción", "río", "puente", "reloj", "pelota", "estrella", "luna", "calle", "naranja", "silencio", "flor", "sombra", "abeja", "roca", "fuego", "árbol", "taza", "mesa", "sombrero", "ola", "rana", "camino", "ciudad", "espejo", "nube", "piedra", "pintura", "sueño", "campana", "caracol", "tigre", "unicornio", "diente", "humo", "tren", "planta", "escalera", "ola", "pájaro", "aurora", "puente", "hoja", "vela", "viento", "balón", "nido", "caramelo", "cola", "espejismo", "selva", "piedra", "candado", "pared", "vuelo", "eco", "risa", "huevo", "botella", "hojalata", "círculo", "ventilador", "silla", "escalera", "cascada")
            val random = Random.nextInt(palabras.size)
            val palabra = palabras[random]
            val palabraSecreta = palabra.toCharArray()  //Vamos a convertir la palabra en un array de caracteres

            val palabraAdivinada = CharArray(palabraSecreta.size) //Creo un array con la misma longitud que el array creado antes
            for (i in palabraAdivinada.indices) { //Recorremos todas las posiciones del array y asignamos el '*'
                palabraAdivinada[i] = '*'
            }
            println("El tamaño de la palabra es el siguiente: "+ String(palabraAdivinada))

            var numeroIntentos:Int = 0
            while (numeroIntentos != 7) {
                println("Numero de intentos restantes: " + (7 - numeroIntentos))
                print("Ingrese una letra que creas que se ecuentra en la plabra o la palabra entera(si deseas envíe un 0):")
                val entrada = readLine()
                if (!entrada.isNullOrEmpty()) { // Si la entrada no es nula hacemos lo siguiente
                    if (entrada.length >= 2) { // Si el usuario escribe la plabra: dos opciones o ganar o perder
                        if (entrada.toLowerCase() == palabra) {
                            println("¡¡ENHORABUENA HAS ADIVINADO LA PALABRA!!")
                            DibujoAhorcado.dibujar(8) //Dibujamos la victoria
                            return
                        } else {
                            println("Lo siento, la palabra no es correcta")
                            println("La palabra era: "+palabra)
                            DibujoAhorcado.dibujar(7) //Dibujamos la derrota
                            return

                        }
                    } else { // Si no decide poner la palabra quiere decir que escribe una letra
                        if (entrada[0].toLowerCase() in palabraSecreta) { //Con esto comprobamos que la primera letra de la entrada esta incluida en la palabra
                            for (i in palabraSecreta.indices) { // recorremos todas los caracteres de la palabra
                                if (palabraSecreta[i] == entrada[0].toLowerCase()) { // Comprobamso que la letra pedida por el usuario es igual a la letra de la palbra secreta
                                    palabraAdivinada[i] = entrada[0].toLowerCase()   // entonces se actualice el arreglo poniendo la letra adivinada
                                }
                            }
                            if (String(palabraAdivinada) == palabra){
                                println("¡¡ENHORABUENA HAS ADIVINADO LA PALABRA!!")
                                println("La palabra era: "+ String(palabraAdivinada))
                                DibujoAhorcado.dibujar(8) //Dibujamos la victoria
                                return

                            }else {
                                println("¡¡GENIAL!! La letra se encuentra en la palabra " + String(palabraAdivinada))
                            }

                        } else {
                            println("La letra no se encuentra en la palabra, has fallado ")
                            println("Letras adivinadas: " + String(palabraAdivinada))
                            numeroIntentos++;
                            if (numeroIntentos == 7){
                                println("La palabra era: "+ palabra)
                                DibujoAhorcado.dibujar(numeroIntentos)
                                return
                            }else{
                                DibujoAhorcado.dibujar(numeroIntentos)
                            }
                        }
                    }
                }else{
                    println("Valor erróneo, porfavor ingrese un valor correcto.")
                }
            }
            return

        }
        "0" -> {
        }
    }
}



fun main(args: Array<String>) {
    println("----------|BIENVENIDO AL JUEGO DEL AHORCADO|----------")
    Thread.sleep(1000)
    val rm  = ReproductorMidi("pugnodollari.mid")
    println("Cargando juego...")
    Thread.sleep(2000)
    println("Antes de comenzar vas a disponer de dos modos: (1) Fácil y (2) Difícil")
    println("|--------------------------REGLAS--------------------------|")
    println("| --> Modo fácil:                                          |")
    println("| En este modo vas a disponer de una pista que te ayudará  |")
    println("| a resolver la palabra.                                   |")
    println("|                                                          |")
    println("| --> Modo difícil:                                        |")
    println("| En este modo no recibirás ninguna pista.                 |")
    println("|                                                          |")
    println("| -->A tener en cuenta:                                    |")
    println("| Si decides escribir la palabra completa, ten en cuenta   |")
    println("| que si fallas la palabra pierdes instantáneamente.       |")
    println("|                                                          |")
    println("| Sin mas dilación...                                      |")
    println("|                   ¡¡¡BUENA SUERTE!!!|                    |")
    println("|----------------------------------------------------------|")
    Thread.sleep(4000)
    ahorcado()
    print("Deseas jugar de nuevo(S/N): ")
    var entrada = readln()
    while (entrada.toUpperCase() == "S"){
        ahorcado()
        print("Deseas jugar de nuevo(S/N): ")
        entrada = readln()
    }
    exitProcess(0)
}