package com.example.hilt1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import com.example.hilt1.ui.theme.Hilt1Theme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    @Named("Persian")
    lateinit var persianGreeter:Greet

    @Inject
    @Named("English")
    lateinit var englishGreeter:Greet

    @Inject
    @Named("Germany")
    lateinit var germanyGreeter:Greet

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var textState by remember {
                mutableStateOf("")
            }
            Hilt1Theme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TextField(value = textState, onValueChange = {
                        textState=it
                    } )

                    Button(onClick = {
                        persianGreeter.greet(textState)
                        englishGreeter.greet(textState)
                        germanyGreeter.greet(textState)
                    }) {
                        Text(text = "S U B M I T")

                    }
                }
            }
        }
    }
}
