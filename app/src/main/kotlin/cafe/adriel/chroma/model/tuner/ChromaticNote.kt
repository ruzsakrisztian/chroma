package cafe.adriel.chroma.model.tuner

import cafe.adriel.chroma.manager.SettingsManager

class ChromaticNote(
    val note: SettingsManager.ChromaticScale,
    val actualPitch: Float
) {
}
