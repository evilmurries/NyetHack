package com.bignerdranch.nyethack

const val MAX_EXPERIENCE: Int = 5000

fun main(args: Array<String>) {
    Game.play()
}

object Game {

    val player = Player("xpy")
    var currentRoom = TownSquare()

    init {
        println("Welcome, adventurer.")
        player.castFireball()
    }

    fun play() {
        while (true) {

            // Room info
            println(currentRoom.description())
            println(currentRoom.load())

            // Player Status
            printPlayerStatus(player)

            // User feedback loop
            print("> Enter your command: ")
            println("Last command: ${readLine()}")
        }
    }

    private fun printPlayerStatus(player: Player) {
        println("Aura: ${player.getAuraColor()} " +
                "(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
        println("${player.name} ${player.formatHealthStatus()}")
    }

    private class GameInput(arg: String?) {
        private val input = arg ?: ""
        val command = input.split(" ")[0]
        val argument = input.split(" ").getOrElse(1, { "" })
    }
}