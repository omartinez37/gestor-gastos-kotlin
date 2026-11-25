fun calcularTotal(montos: List<Double>): Double {
    var total = 0.0
    for (monto in montos) {
        total += monto
    }
    return total
}

fun obtenerPosicionGastoMayor(montos: List<Double>): Int {
    if (montos.isEmpty()) return -1

    var indiceMayor = 0
    var montoMayor = montos[0]

    for (i in 1 until montos.size) {
        if (montos[i] > montoMayor) {
            montoMayor = montos[i]
            indiceMayor = i
        }
    }
    return indiceMayor
}
fun calcularTotalPorCategoria(
    categorias: List<String>,
    montos: List<Double>,
    categoriaBuscada: String
): Double {
    var totalCategoria = 0.0
    for (i in categorias.indices) {
        if (categorias[i].equals(categoriaBuscada, ignoreCase = true)) {
            totalCategoria += montos[i]
        }
    }
    return totalCategoria
}

fun mostrarResumen(
    conceptos: List<String>,
    categorias: List<String>,
    montos: List<Double>
) {
    println("\nRESUMEN SEMANAL\n")
    if (montos.isEmpty()) {
        println("Aún no hay gastos registrados.")
        return
    }

    val cantidad = montos.size
    val total = calcularTotal(montos)
    val promedio = total / cantidad
    val posMayor = obtenerPosicionGastoMayor(montos)

    println("Número de gastos: $cantidad")
    println("Gasto total: $${"%.2f".format(total)}")
    println("Promedio por gasto: $${"%.2f".format(promedio)}")
    println("Gasto mayor: ${conceptos[posMayor]}, $${"%.2f".format(montos[posMayor])}")
}