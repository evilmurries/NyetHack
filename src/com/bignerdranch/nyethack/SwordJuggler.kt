package com.bignerdranch.nyethack

import java.lang.IllegalStateException

fun main(args: Array<String>) {
    var numSwords: Int? = null
    val jugglingProficiency = (1..3).shuffled().last() == 3
    if (jugglingProficiency) {
        numSwords = 2
    }

    try {
        proficiencyCheck(numSwords)
        numSwords = numSwords!!.plus(1)
    } catch (e: Exception) {
        println(e)
    }

    println("You juggle $numSwords swords!")
}

fun juggleSwords(swordsJuggling: Int) {
    require(swordsJuggling >= 3, { "Juggle at least three swprds to be exciting." })
}

fun proficiencyCheck(swordsJuggling: Int?) {
    checkNotNull(swordsJuggling, {"com.bignerdranch.nyethack.Player cannot juggle swords"})
}

class UnskilledSwordJugglerException() :
        IllegalStateException("com.bignerdranch.nyethack.Player cannot juggle swords")