package com.bignerdranch.nyethack

const val MAX_EXPERIENCE: Int = 5000

fun main(args: Array<String>) {

    val player = Player("xpy")


    val auraColor = player.getAuraColor()

    printPlayerStatus(player)
    player.castFireball()
}

private fun printPlayerStatus(player: Player) {
    println("Aura: ${player.getAuraColor()} " +
    "(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
    println("${player.name} ${player.formatHealthStatus()}")
}