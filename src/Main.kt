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
    val player = Player()
    val enemy = Player()
    player.name = "Имя"
    enemy.name = "Имя2"

    player.shots = 10
    player.hits = 7
    player.shipLeft = 20

    player.printField()
    player.printStats()

    printBothFields(player, enemy)
}