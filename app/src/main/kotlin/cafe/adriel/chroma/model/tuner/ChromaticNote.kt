package cafe.adriel.chroma.model.tuner

class ChromaticNote(
    val tone: String,
    val frequency: Float,
    val semitone: Boolean = false
) {

    val formattedFrequency = "%.2f".format(frequency)

}
