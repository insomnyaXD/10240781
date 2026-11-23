fun printField(field: Array<CharArray>, title: String) {
}

fun printBothFields(player: Player, enemy: Player) {
    print("=== Поле игрока ${player.name} ===       === Поле игрока ${enemy.name} ===")
    println()
    print("   ")
    for (l in 0 until 2) {
        for (c in 0 until player.field.size) print("$c ")
        print("           ")
    }

    println()
    for (r in 0 until player.field.size) {
        print("$r  ")
        for (c in 0 until player.field.size) print("${player.field[c][r]} ")
        print("        ")
        print("$r  ")
        for (c in 0 until player.field.size) print("${enemy.field[c][r]} ")
        println()
    }
}

fun main() {
    val player = Player("Имя")
    val enemy = Player("Имя2")

    printBothFields(player, enemy)
}