package cafe.adriel.chroma.model.tuner

import cafe.adriel.chroma.manager.SettingsManager
import cafe.adriel.chroma.model.settings.AccidentalOption
import cafe.adriel.chroma.model.settings.NotationOption
import cafe.adriel.chroma.model.settings.Settings

data class Tuning(
    val note: ChromaticNote? = null,
    val frequency: Float = -1f,
    val deviation: TuningDeviationResult = TuningDeviationResult.NotDetected
) {

    val formattedFrequency by lazy { SettingsManager.ChromaticScale.FREQUENCY_FORMAT.format(frequency) }

    fun getTone(settings: Settings): String {
        requireNotNull(note)

        return when {
            settings.accidental == AccidentalOption.FLAT &&
                settings.notation == NotationOption.DO_RE_MI &&
                note.note.semitone -> SettingsManager.ChromaticScale.getSolfegeTone(SettingsManager.ChromaticScale.getFlatTone(note.note.tone))

            settings.accidental == AccidentalOption.FLAT &&
                note.note.semitone -> SettingsManager.ChromaticScale.getFlatTone(note.note.tone)

            settings.notation == NotationOption.DO_RE_MI -> SettingsManager.ChromaticScale.getSolfegeTone(note.note.tone)

            else -> note.note.tone
        }
    }

    fun getSemitoneSymbolRes(settings: Settings): Int? {
        requireNotNull(note)

        return if (note.note.semitone) {
            settings.accidental.symbolRes
        } else {
            null
        }
    }
}
