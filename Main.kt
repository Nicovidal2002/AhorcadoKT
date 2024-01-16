import java.util.Random

fun main() {
    val rm = ReproductorMidi("pugnodollari.mid")
    println("Cargando juego...")
    Thread.sleep(3000)

    val frutas =
        listOf("manzana", "limon", "kiwi", "pera", "platano", "naranja", "mandarina", "mango", "chirimoya", "aguacate")
    val random = Random()
    val indiceAleatorio = random.nextInt(frutas.size)
    val palabra = frutas[indiceAleatorio]
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
            println("La palabra no con tiene esa letra, lo siento, has perdido una vida")
            DibujoAhorcado.dibujar(a)
            Thread.sleep(500)
            println("Te quedan $vidas vidas")
        }
        if (oculto == palabra) {
            println("Felicidades! Has adivinado la palabra poco a poco.")
            break
        }
        if (vidas == 0) {
            println("Lo siento, has perdido")
            break
        }

    }
    rm.cerrar()
}




