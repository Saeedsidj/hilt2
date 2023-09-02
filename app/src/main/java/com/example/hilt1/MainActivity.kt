package com.example.hilt1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import com.example.hilt1.ui.theme.Hilt1Theme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var persianGreeter: PersianGreeter

    @Inject
    lateinit var englishGreeter: EnglishGreeter

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var textState by remember {
                mutableStateOf("")
            }
            Hilt1Theme {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TextField(value = textState, onValueChange = {
                        textState=it
                    } )
                    Button(onClick = {
                        persianGreeter.greet(textState)
                        englishGreeter.greet(textState)
                    }) {
                        Text(text = "S U B M I T")

                    }
                }
            }
        }
    }
}
