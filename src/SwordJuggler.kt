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

    println("You juggle $numSwords!")
}

fun proficiencyCheck(swordsJuggling: Int?) {
    swordsJuggling ?: throw UnskilledSwordJugglerException()
}

class UnskilledSwordJugglerException() :
        IllegalStateException("Player cannot juggle swords")