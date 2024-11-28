package com.kodeman.composestudy.tips.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import com.kodeman.composestudy.ui.theme.ComposeStudyTheme
import com.kodeman.composestudy.utils.ui.CustomIconButton
import com.kodeman.composestudy.utils.ui.CustomInputField
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class TipCalculator() {

    var billAmount: Double = 100.0
    var tip: Int = 15
    var peopleCount: Int = 1

    var finalAmount: Double = 0.0
        set(value) {
            field = if (value > 0) {
                value
            } else {
                0.0
            }
        }

    var dividedAmount: Double = 0.0

    init {
        calculateFinalAmount()
    }

    private fun calculateFinalAmount(): Double {
        finalAmount = billAmount + (billAmount * (tip.toDouble() / 100))
        dividedAmount = if (peopleCount > 1) {
            finalAmount / peopleCount
        } else {
            finalAmount
        }
        return finalAmount
    }

    fun onBillChange(billAmount: Double): Double {
        this.billAmount = billAmount
        return calculateFinalAmount()
    }

    fun onTipChange(tip: Int): Double {
        this.tip = tip
        return calculateFinalAmount()
    }

    fun onPeopleCountChange(peopleCount: Int): Double {
        this.peopleCount = peopleCount
        return calculateFinalAmount()
    }
}

@Composable
fun TipView(modifier: Modifier = Modifier) {
    val tipCalculator = TipCalculator()

    val billAmount = remember { mutableDoubleStateOf(tipCalculator.billAmount) }
    val tipValue = remember { mutableIntStateOf(tipCalculator.tip) }
    val peopleCount = remember { mutableIntStateOf(tipCalculator.peopleCount) }


    val finalBill = remember { mutableDoubleStateOf(tipCalculator.finalAmount) }
    val dividedBill = remember { mutableDoubleStateOf(tipCalculator.dividedAmount) }

    val customInputField = CustomInputField()
    val customIconButton = CustomIconButton()
    Column(
        modifier.padding(horizontal = 40.dp),
        Arrangement.Top,
        Alignment.CenterHorizontally
    ) {
        /// Bill Amount
        customInputField.BasicInputField(title = "Bill", value = billAmount.doubleValue
            .toString(), onChanged = {
            if (it.matches(Regex("^(\\d)+\\.?(\\d){1,2}\$"))) {
                billAmount.doubleValue = it.toDouble()
                finalBill.doubleValue = tipCalculator.onBillChange(billAmount.doubleValue)
            }
        })

        /// Tip Value
        Column {
            customInputField.BasicInputField(
                title = "Tip", value = tipValue.intValue.toString(),
                onChanged = {},
                readOnly = true,
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .background(color = Color.Black)
                    .fillMaxWidth()
            ) {
                customIconButton.IconButtonColors(
                    onClick = {
                        finalBill.doubleValue = tipCalculator.onTipChange(tipValue.intValue--)
                    },
                    icon = Icons.Filled.Star
                )

                customIconButton.IconButtonColors(
                    onClick = {
                        tipValue.intValue++
                        finalBill.doubleValue = tipCalculator.onTipChange(tipValue.intValue)
                    },
                    icon = Icons.Filled.Add, contentDescription = "Add"
                )
            }
        }

        /// Number of People
        Column {
            Text("No. of Person")
            TextField(peopleCount.intValue.toString(), onValueChange = {})
        }

        Button(onClick = {}) {
            Text("Bill Now!")
        }

        Text(finalBill.doubleValue.toString())
    }
}

@Preview(showBackground = true, heightDp = 600, widthDp = 400)
@Composable
private fun TipPreview() {
    ComposeStudyTheme {
        TipView()
    }
}