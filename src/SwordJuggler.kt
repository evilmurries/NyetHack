fun main(args: Array<String>) {
    var numSwords: Int? = null
    val jugglingProficiency = (1..3).shuffled().last() == 3
    if (jugglingProficiency) {
        numSwords = 2
    }
    println("You juggle $numSwords!")
}