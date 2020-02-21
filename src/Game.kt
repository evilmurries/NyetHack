fun main(args: Array<String>) {
    val name: String = "Xpy"
    var healthPoints: Int = 89

    if (healthPoints == 100) {
        println(name + " is in excellent condition!")
    } else if (healthPoints > 90){
        println(name + " has a few scratches.")
    } else if (healthPoints >= 75) {
        println(name + " has some minor wounds.")
    } else if (healthPoints >= 15) {
        println(name + " looks pretty hurt.")
    } else {
    println(name + " is in awful condition!")
    }
}
