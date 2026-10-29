class Player {
    var name: String = ""
    var field: Array<CharArray> = Array(10) { CharArray(10) {'.'} }

    var shots: Int = 0
    var hits: Int = 0
    var shipLeft: Int = 20

    fun reset() {
        shots = 0
        hits = 0
        shipLeft = 20

        print("=== Поле игрока $name ===")
        print("    ")
        println()
        print("  ")

        for (c in 0 until field.size) print("$c ")
        println()
        for (r in 0 until field.size) {
            print("$r ")
            for (c in 0 until field.size) print(". ")
            println()
        }

    }

    fun isAlive(): Boolean {
        if (shipLeft > 0) return true
        else return false
    }

    fun accuracy(): Double {
        if (shots != 0) return hits * 100.0 / shots
        else return 0.0
    }

    fun status(){
        println("Игрок $name: палуб осталось: $shipLeft, выстрелов: $shots, попаданий: $hits, точночть ${accuracy()}%")
    }

    fun takeDamage(): Boolean {
        shipLeft--
        return isAlive()
    }

    fun registerShot(hit: Boolean) {
        shots++
        if (hit) hits++
    }

    fun printField() {
        print("=== Поле игрока $name ===")
        print("    ")
        println()
        print("  ")

        for (c in 0 until field.size) print("$c ")
        println()
        for (r in 0 until field.size) {
            print("$r ")
            for (c in 0 until field.size) print("${field[r][c]} ")
            println()
        }
    }

    fun printStats() {
        println("Игрок $name сделал выстрелов: $shots и попал: $hits")
    }
}
