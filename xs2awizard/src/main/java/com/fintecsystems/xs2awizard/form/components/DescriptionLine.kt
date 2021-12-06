package com.fintecsystems.xs2awizard.form.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.fintecsystems.xs2awizard.XS2AWizardViewModel
import com.fintecsystems.xs2awizard.components.theme.XS2ATheme
import com.fintecsystems.xs2awizard.form.DescriptionLineData
import com.fintecsystems.xs2awizard.helper.MarkupParser

@Composable
fun DescriptionLine(formData: DescriptionLineData, viewModel: XS2AWizardViewModel) {
    if (formData.text?.isNotEmpty() == true) {
        val annotatedString = MarkupParser.parseMarkupText(formData.text)

        ClickableText(
            modifier = Modifier.fillMaxWidth(),
            text = annotatedString,
            style = TextStyle(
                color = XS2ATheme.CURRENT.textColor,
                fontSize = 15.3.sp,
            ),
            onClick = {
                annotatedString.getStringAnnotations(it, it)
                    .firstOrNull()?.let { annotation ->
                        viewModel.handleAnnotationClick(annotation)
                    }
            }
        )
    }
}