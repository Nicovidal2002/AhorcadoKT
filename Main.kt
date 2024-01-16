import java.util.Random

fun main() {
    val rm = ReproductorMidi("pugnodollari.mid")
    println("Cargando juego...")
    Thread.sleep(3000)

    val frutas = listOf("manzana", "limon", "kiwi", "pera", "platano", "naranja", "mandarina", "mango", "chirimoya", "aguacate")
    val random = Random()
    val indiceAleatorio = random.nextInt(frutas.size)
    val palabra = frutas[indiceAleatorio]
    println("Palabra a adivinar: $palabra")
    var oculto = "*".repeat(palabra.length)
    println("Palabra oculta: $oculto")

    var vidas = 7
    var a = 0
    while (vidas > 0) {
        println("Escribe solo una letra.")
        val letra = readln().lowercase()
        if (palabra.contains(letra)) {
            println("Muy bien, palabra actualizada.")
            for (i in 0 until oculto.length) {
                if (oculto[i] == '*') {
                    if (palabra[i] == letra[0]) {
                        oculto = oculto.substring(0, i) + letra + oculto.substring(i + 1)
                    }
                }
            }
            println(oculto)

        } else {
            a++
            --vidas
            println("No está dentro")
            DibujoAhorcado.dibujar(a)
            Thread.sleep(500)
            println("Te quedan $vidas vidas")
        }
        if(oculto == palabra){
            println("Felicidades! Has adivinado la palabra poco a poco. ¿Quieres volver a empezar?")
            val restart = readln().uppercase()
            if (restart == "SI") {
                return main()
            }
        }

        if (vidas == 0) {
            println("Lo siento, has perdido. ¿Quieres volver a empezar?")
            val restart = readln().uppercase()
            if (restart == "SI") {
                return main()
            }
        }
    }

    rm.cerrar()
}
