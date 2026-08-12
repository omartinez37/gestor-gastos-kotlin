package src

//Crear función registrarGasto
//Crear función mostrarGastos
//Declarar variables de la función registrarGastos
    //val conceptos
    // val categorias
    // val montos
//Crear categorias para los conceptos:
    //  Alimentos
    //  Transporte
    //  Materiales escolares
    //  Entretenimiento
    //  Otros
//Mostrar menu de opciones
//Mostrar categorias
//Mostrar Conceptos registrados
//buclce del menu

fun main() {
    // Listas paralelas para almacenar la información
    val conceptos = mutableListOf<String>()
    val categorias = mutableListOf<String>()
    val montos = mutableListOf<Double>()

    var opcion: String?

    do {
        println("\nCONTROL PERSONAL DE GASTOS\n")
        println("1. Registrar gasto")
        println("2. Mostrar todos los gastos")
        println("3. Calcular gasto total")
        println("4. Mostrar gasto mayor")
        println("5. Mostrar gastos por categoría")
        println("6. Mostrar resumen semanal")
        println("7. Salir\n")
        print("Seleccione una opción: ")

        opcion = readlnOrNull()?.trim()

        when (opcion) {
            "1" -> registrarGasto(conceptos, categorias, montos)
            "2" -> mostrarGastos(conceptos, categorias, montos)
            "3", "4", "5", "6" -> println("\n[Info] Esta opción será implementada por el Estudiante B.")
            "7" -> println("\n¡Saliendo del programa! Hasta luego.")
            else -> println("\nOpción no válida. Por favor, seleccione un número del 1 al 7.")
        }

    } while (opcion != "7")
}

//--Fase 3. Trabajo del estudiante A--//

// Commit 1 Agrega función para registrar gastos //

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

////commit 2 Agrega listado de gastos registrados //

fun mostrarGastos(
    conceptos: List<String>,
    categorias: List<String>,
    montos: List<Double>
) {
    println("\nGASTOS REGISTRADOS\n")

    if (conceptos.isEmpty()) {
        println("No hay gastos registrados en este momento.")
        return
    }

    // Recorrer las listas paralelas
    for (i in conceptos.indices) {
        val indice = "${i + 1}."
        val conceptoFormateado = conceptos[i].padEnd(15)
        val categoriaFormateada = categorias[i].padEnd(20)
        val montoFormateado = "$%.2f".format(montos[i])

        println("$indice $conceptoFormateado | $categoriaFormateada | $montoFormateado")
    }
}

///commit 1 Estudiante B //

fun calcularTotal(montos: List<Double>): Double {
    if (montos.isEmpty()) {
        return 0.0
    }
    var total = 0.0
    for (monto in montos) {
        total += monto
    }
    return total
}

 //Encuentra la posición (índice) del gasto con el monto más alto.
 // Devuelve -1 si la lista está vacía.

fun obtenerPosicionGastoMayor(montos: List<Double>): Int {
    if (montos.isEmpty()) {
        return -1
    }

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