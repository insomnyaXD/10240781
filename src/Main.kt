fun createEmptyField(size: Int = 10): Array<CharArray> {
    return Array(size) { CharArray(size) { '.' } }
}

fun printField(field: Array<CharArray>, title: String, showShips: Boolean = true, debug: Boolean = false) {
    val size = field.size
    val border = "+" + "---+".repeat(size)

    print("=== $title ===")
    println()
    print("    ")

    for (c in 0 until size) if (debug) print("$c | ")  else print("$c ")
    println()
    print("  ")
    if (debug) println(border)
    for (r in 0 until size) {
        if (debug) print("$r | ")  else print("$r ")

        for (c in 0 until size) {
            var show = field[r][c]
            if (!showShips && show == '#') show = '.'

            if (debug) print("${show} | ") else print("${show} ")
        }
        println()
        print("  ")
        if (debug) println(border)
    }

}

fun printBothFields(player: Array<CharArray>, enemy: Array<CharArray>, showEnemyShips: Boolean = false) {
    if (player.size != enemy.size) {
        print("Ошибка! Поля должны быть одного размера!")
        return
    }

    val size = player.size

    println("    === Ваше поле ===         === Поле противника ===")

    for (l in 0..1) {
        print("   ")
        for (c in 0 until size) print("$c ")
        print("       ")
    }
    println()

    for (r  in 0 until size) {
        print("$r  ")
        for (c in  0 until size) print("${player[r][c]} ")
        print("       " )
        print("$r  ")
        for (c in  0 until size) {
            var show = enemy[r][c]
            if (!showEnemyShips && show == '#') show = '.'
            print("${show} ")
        }
        println()
    }
}

fun printFields(fields: Array<Array<CharArray>>, titles: Array<String>, showShips: BooleanArray) {
    if (fields.size != titles.size || titles.size != showShips.size) {
        println("Ошибка! Размеры массивов должны быть одинаковы!")
        return
    }

    for (i in 0 until  fields.size - 1 ) {
        if (fields[i].size != fields[i + 1].size) {
            println("Ошибка! Поля должны быть одного размера!")
            return
        }
    }

    val size = fields[0].size

    for (l in 0 until fields.size) {
        val title = titles[l]
        print(" === $title === ")
        print("         ")
    }
    println()

    for (l in 0 until fields.size) {
        print("   ")
        for (c in 0 until size) print("$c ")
        print("     ")
    }

    println()

    // 3) строки данных для каждого поля
    for (r in 0 until size) {
        for (l in fields.indices) {
            print("$r  ")
            for (c in 0 until size) {
                val cell = fields[l][r][c]
                val show = if (!showShips[l] && cell == '#') '.' else cell
                print("$show ")
            }
            print("     ")
        }
        println()
    }

}

fun main() {
    val playerField = createEmptyField()
    val enemyField = createEmptyField()
    val thirdField = createEmptyField()

    playerField[3][2] = '#'
    playerField[3][3] = '#'
    playerField[3][4] = '#'
    playerField[3][5] = '#'

    enemyField[5][7] = '#'
    enemyField[6][7] = '#'
    enemyField[7][7] = '#'
    enemyField[5][6] = 'X'
    enemyField[6][6] = 'O'

    val fields = arrayOf(playerField, enemyField, thirdField)
    val titles = arrayOf("Ваше поле", "Противник", "Третье")
    val show = booleanArrayOf(true, false, false)

    //printBothFields(playerField, enemyField)
    printFields(fields, titles, show)
}