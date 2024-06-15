package com.dfc.ezekiel.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dfc.ezekiel.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskManagerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TaskCompleted(
                        painterResource(id = R.drawable.ic_task_completed),
                        stringResource(id = R.string.primaryMessage),
                        stringResource(id = R.string.secondaryMessage),
                    )
                }
            }
        }
    }
}

@Composable
fun TaskCompleted(completed:Painter, mainMessage: String, secondaryMessage: String,
                  modifier: Modifier = Modifier) {
    privateTaskCompleted(
        completed, mainMessage, secondaryMessage, modifier
    )
}

@Composable
private fun privateTaskCompleted(completed:Painter, mainMessage:String,
                                 secondaryMessage:String, modifier: Modifier = Modifier){
    val imageCheckSymbol = completed
    Column(
        modifier = Modifier.fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = imageCheckSymbol,
            contentDescription = null
        )
        Text(
            text = mainMessage,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
        )
        Text(
            text = secondaryMessage,
            fontSize = 16.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TaskManagerTheme {
        TaskCompleted(
            painterResource(id = R.drawable.ic_task_completed),
            stringResource(id = R.string.primaryMessage),
            stringResource(id = R.string.secondaryMessage)
        )
    }
}