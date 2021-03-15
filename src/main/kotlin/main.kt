fun main(args: Array<String>) {
    println("Hello World!")
    var tinyMe = MyParticipant()
    var littleMe = MyParticipant(isCoHost = false)
    var middleMe = MyParticipant(isHost = false, isCoHost = true)
    var bigMe = MyParticipant(isHost = true, isCoHost = true)

    bindAsNotAnOwner(bigMe)
    bindAsNotAnOwner(middleMe)
    bindAsNotAnOwner(littleMe)
    bindAsNotAnOwner(tinyMe)
}

data class MyParticipant(
    @JvmField var isHost: Boolean = false,
    @JvmField var isCoHost: Boolean? = null
)

fun bindAsNotAnOwner(participant: MyParticipant) {
    when {
        participant.isHost -> {
            println("I'm a host")
        }
        participant.isCoHost?:false -> {
            println("I'm a co-host")
        }
        else -> {
            println("Who am I?")
        }
    }
}
