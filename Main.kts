fun main() {
    println("Gestor semanal de gastos")
}

fun registrarGasto(
    conceptos: MutableList<String>,
    categorias: MutableList<String>,
    montos: MutableList<Double>
) {
    println("\n--- REGISTRO DE GASTO ---")

    // 1. Solicitar concepto
    print("Ingrese el concepto: ")
    val concepto = readlnOrNull()?.trim() ?: "Sin concepto"

    // 2. Mostrar y validar categoría
    var categoria = ""
    while (categoria.isEmpty()) {
        println("\nCategorías disponibles:")
        println("1. Alimentos")
        println("2. Transporte")
        println("3. Materiales escolares")
        println("4. Entretenimiento")
        println("5. Otros")
        print("Seleccione una opción (1-5): ")

        when (readlnOrNull()?.trim()) {
            "1" -> categoria = "Alimentos"
            "2" -> categoria = "Transporte"
            "3" -> categoria = "Materiales escolares"
            "4" -> categoria = "Entretenimiento"
            "5" -> categoria = "Otros"
            else -> println("Error: Selección inválida. Intente nuevamente.")
        }
    }

    // 3. Solicitar y validar monto
    var monto = 0.0
    while (monto <= 0.0) {
        print("Ingrese el monto: $")
        val entrada = readlnOrNull()?.trim()
        val montoIngresado = entrada?.toDoubleOrNull()

        if (montoIngresado != null && montoIngresado > 0) {
            monto = montoIngresado
        } else {
            println("Error: El monto debe ser un número mayor a cero.")
        }
    }

    // 4. Agregar a las listas
    conceptos.add(concepto)
    categorias.add(categoria)
    montos.add(monto)

    println("\n¡Gasto registrado correctamente!")
}