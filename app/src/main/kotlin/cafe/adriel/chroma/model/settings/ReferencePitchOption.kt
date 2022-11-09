package cafe.adriel.chroma.model.settings

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import cafe.adriel.chroma.R
import cafe.adriel.chroma.view.components.SelectOption

enum class ReferencePitchOption(
    @StringRes override val labelRes: Int,
    val freq: Float
) : SelectOption<ReferencePitchOption> {
    Pitch440(R.string.reference_pitch_440, 440f),
    Pitch441(R.string.reference_pitch_441, 441f),
    Pitch442(R.string.reference_pitch_442, 442f);

    companion object {
        const val titleRes = R.string.reference_pitch
    }
}
