fun main() {
    val playerField = Array(10) { CharArray(10) { '.' } }

    playerField[3][2] = '#'
    playerField[3][3] = '#'
    playerField[3][4] = '#'
    playerField[3][5] = '#'

    val enemyField = Array(10) { CharArray(10) { '.' } }

    enemyField[5][7] = '#'
    enemyField[6][7] = '#'
    enemyField[7][7] = '#'

    println("    === Ваше поле ===         === Поле противника ===")

    print("   ")
    for (c in 0..9) print("$c ")
    print("       ")
    print("   ")
    for (c in 0..9) print("$c ")
    println()

    for (r  in 0..9) {
        print("$r  ")
        for (c in 0..9) print("${playerField[r][c]} ")

        print("       ")

        print("$r  ")
        for (c in 0..9) print("${enemyField[r][c]} ")
        println()
    }
}