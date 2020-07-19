package com.bignerdranch.nyethack

import java.lang.IllegalStateException
import kotlin.system.exitProcess

const val MAX_EXPERIENCE: Int = 5000

fun main(args: Array<String>) {
    Game.play()
}

object Game {

    val player = Player("xpy")
    var currentRoom: Room = TownSquare()
    var game = true

    private var worldMap = listOf(listOf(currentRoom, Room("Tavern"), Room("Back Room")), listOf(Room("Long Cooridor"), Room("Generic Room")))

    init {
        println("Welcome, adventurer.")
        player.castFireball()
    }

    private fun fight() = currentRoom.monster?.let {
        while (player.healthPoints > 0 && it.healthPoints > 0) {
            slay(it)
            Thread.sleep(1000)
        }
        "Combat complete"
    } ?: "There is nothing here to fight."

    private fun slay(monster: Monster) {
        println("${monster.name} did ${monster.attack(player)} damage!")
        println("${player.name} did ${monster.attack(monster)} damage!")

        if (player.healthPoints < 0) {
            println(">>>>> You have been defeated. Thanks for playing <<<<<")
            exitProcess(0)
        }
        if (monster.healthPoints <= 0) {
            println(">>>>> ${monster.name} has been defeated! <<<<<")
            currentRoom.monster = null
        }
    }

    private fun move(directionInput: String) =
        try {
            val direction = Direction.valueOf(directionInput.toUpperCase())
            val newPosition = direction.updateCoordinate(player.currentPosition)
                if (!newPosition.isInBounds) {
                    throw IllegalStateException("$direction is out of bounds.")
                }
            val newRoom = worldMap[newPosition.y][newPosition.x]
            player.currentPosition = newPosition
            currentRoom = newRoom
            "Ok, you move $direction to the ${newRoom.name}.\n${newRoom.load()}"
        } catch (e: Exception) {
            "Invalid direction: $directionInput."
        }

    private fun quitGame() {
        println("Farewell adventurer...")
        game = false
    }

    fun play() {
        while (game) {

            // Room info
            println(currentRoom.description())
            println(currentRoom.load())

            // Player Status
            printPlayerStatus(player)

            // User feedback loop
            print("> Enter your command: ")
            println(GameInput(readLine()).processCommand())
        }
    }

    private fun printPlayerStatus(player: Player) {
        println(
            "Aura: ${player.getAuraColor()} " +
                    "(Blessed: ${if (player.isBlessed) "YES" else "NO"})"
        )
        println("${player.name} ${player.formatHealthStatus()}")
    }

    private class GameInput(arg: String?) {
        private val input = arg ?: ""
        val command = input.split(" ")[0]
        val argument = input.split(" ").getOrElse(1, { "" })

        private fun commandNotFound() = "I'm not quite sure what you are trying to do!"

        fun processCommand() = when (command.toLowerCase()) {
            "move" -> move(argument)
            "quit" -> quitGame()
            "exit" -> quitGame()
            "fight" -> fight()
            else -> commandNotFound()
        }
    }
}