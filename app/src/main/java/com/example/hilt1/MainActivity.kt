package com.example.hilt1

import android.content.SharedPreferences
import android.os.Bundle
import android.provider.Settings.Secure.putString
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.content.edit
import com.example.hilt1.ui.theme.Hilt1Theme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

const val KEY_NAME = "name"

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    @Named("Persian")
    lateinit var persianGreeter: Greet

    @Inject
    @Named("English")
    lateinit var englishGreeter: Greet

    @Inject
    @Named("Germany")
    lateinit var germanyGreeter: Greet

    @Inject
    lateinit var shered: SharedPreferences

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var selectedOption by remember { mutableStateOf(1) }
            var textState by remember {
                mutableStateOf("")
            }
            Hilt1Theme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "TEXT : ${shered.getString("", "")}")
                    TextField(value = textState, onValueChange = {
                        textState = it
                    })
                    Row {
                        RadioButton(
                            selected = selectedOption == 1,
                            onClick = {
                                selectedOption = 1
                                shered.edit { putString(KEY_NAME,"IR") }
                            })
                        RadioButton(
                            selected = selectedOption == 2,
                            onClick = {
                                selectedOption = 2
                                shered.edit { putString(KEY_NAME,"EN") }
                            })
                        RadioButton(
                            selected = selectedOption == 3,
                            onClick = {
                                selectedOption = 3
                                shered.edit { putString(KEY_NAME,"GR") }
                            })
                    }
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(29.dp)
                    ) {
                        Text(text = "IR")
                        Text(text = "EN")
                        Text(text = "GR")
                    }
                    Button(onClick = {
                        when(selectedOption){
                            1-> {
                                persianGreeter.greet(textState)
                                shered.edit {
                                    putString(KEY_NAME,textState)
                                }
                            }
                            2-> {
                                englishGreeter.greet(textState)
                                shered.edit {
                                    putString(KEY_NAME,textState)
                                }
                            }
                            3-> {
                                germanyGreeter.greet(textState)
                                shered.edit {
                                    putString(KEY_NAME,textState)
                                }
                            }
                        }

                    }) {
                        Text(text = "S U B M I T")

                    }
                }
            }
        }
    }
}
