class Player(val name: String) {
    var _field: Array<CharArray> = Array(10) { CharArray(10) {'.'} }

    private var _shots: Int = 0
    private var _hits: Int = 0
    private var _shipLeft: Int = 20

    val shots: Int
        get() = _shots

    val hits: Int
        get() = _hits

    fun markShot(row: Int, col: Int, hit: Boolean) {
        if (row in 0..9 && col in 0..9) {
            _field[row][col] = if (hit) 'X' else 'O'
        }
    }

    fun reset() {
        _shots = 0
        _hits = 0
        _shipLeft = 20

        print("=== Поле игрока $name ===")
        print("    ")
        println()
        print("  ")

        for (c in 0 until _field.size) print("$c ")
        println()
        for (r in 0 until _field.size) {
            print("$r ")
            for (c in 0 until _field.size) print(". ")
            println()
        }

    }

    fun isAlive(): Boolean {
        if (_shipLeft > 0) return true
        else return false
    }

    fun accuracy(): Double {
        if (shots != 0) return hits * 100.0 / shots
        else return 0.0
    }

    fun status(){
        println("Игрок $name: палуб осталось: $_shipLeft, выстрелов: $shots, попаданий: $hits, точночть ${accuracy()}%")
    }

    fun takeDamage(): Boolean {
        _shipLeft--
        return isAlive()
    }

    fun registerShot(hit: Boolean) {
        _shots++
        if (hit) _hits++
    }

    fun printField() {
        print("=== Поле игрока $name ===")
        print("    ")
        println()
        print("  ")

        for (c in 0 until _field.size) print("$c ")
        println()
        for (r in 0 until _field.size) {
            print("$r ")
            for (c in 0 until _field.size) print("${_field[r][c]} ")
            println()
        }
    }

    fun printStats() {
        println("Игрок $name сделал выстрелов: $shots и попал: $hits")
    }
}
