package com.fintecsystems.xs2awizard.wrappers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fintecsystems.xs2awizard.XS2AWizard
import com.fintecsystems.xs2awizard.components.XS2AWizardConfig

/**
 * Wrapper for the XS2A-Wizard Compose Component
 */
class XS2AWizardFragment() : Fragment() {
    private var mConfig: XS2AWizardConfig? = null

    constructor(_xS2AWizardConfig: XS2AWizardConfig) : this() {
        mConfig = _xS2AWizardConfig
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)

            setContent {
                val xS2AWizardConfigHolder = viewModel<XS2AWizardConfigHolderViewModel>()

                if (mConfig != null)
                    xS2AWizardConfigHolder.xS2AWizardConfig = mConfig

                if (xS2AWizardConfigHolder.xS2AWizardConfig != null)
                    XS2AWizard(xS2AWizardConfig = xS2AWizardConfigHolder.xS2AWizardConfig!!)
            }
        }
    }
}