package sanzlimited.com.androiddevclasses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sanzlimited.com.androiddevclasses.ui.theme.AndroidDevClassesTheme
import java.lang.NumberFormatException

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidDevClassesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    customScaffold()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun customScaffold() {
    val keyboardController = LocalSoftwareKeyboardController.current

    Scaffold (
        topBar = {
            TopAppBar(
                title = { Text(text= "Tip Time") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White
                ),
            )
        }
    ){ contentPadding ->
        Box(modifier = Modifier
            .padding(contentPadding)
            .fillMaxSize()
            .clickable {
                keyboardController?.hide()
            }
        ) {
            content()
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun content() {
    var isRoundedChecked by remember { mutableStateOf(true) }
    var costOfService by remember{ mutableStateOf(0.0)}
    val options = listOf(
        Option("Amazing (20%)"),
        Option("Good (18%)"),
        Option("Okay (15%)")
    )
    var selectedService by remember { mutableStateOf<Option>(options[0]) }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        costInput(cost = costOfService, onUserInput = {
            newCost -> costOfService = newCost
        })
        serviceRadioButtons(selectedService, options){ option ->
            selectedService = option
        }
        roundTip(isRoundedChecked, onSwitchChange = {
            isRoundedChecked = it
        })

        Button(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            onClick = {
                //Handle complete
            }
        ) {
            Text(text = "Calculate")
        }
    }
}

data class Option(val name: String)


@Composable
fun serviceRadioButtons(selectedService: Option, options: List<Option>, onOptionSelected: (Option) -> Unit) {

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = "How was the service?", modifier = Modifier.padding(bottom = 10.dp))
        options.forEach { option ->
            val isSelected = option == selectedService
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onOptionSelected(option)
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(selected = isSelected, onClick = {
                    onOptionSelected(option)
                })
                Text(text = option.name, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun costInput(cost: Double, onUserInput: (Double) -> Unit) {
    var text by remember { mutableStateOf(cost.toString()) }
    val keyboardController = LocalSoftwareKeyboardController.current
    OutlinedTextField(
        value = text,
        onValueChange = {
            text = it
            try {
                val newCost = it.toDouble()
                onUserInput(newCost)
            } catch (e: NumberFormatException) {
                // handle invalid input here
                println(e.message)
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                keyboardController?.hide()
            }
        ),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        label = { Text("Cost of Service") },
        singleLine = true
    )
}


@Composable
fun roundTip(isChecked: Boolean, onSwitchChange: (Boolean) -> Unit) {

    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(text = "Round up tip?")
        Switch(checked = isChecked, onCheckedChange = { onSwitchChange(!isChecked) })
    }
}