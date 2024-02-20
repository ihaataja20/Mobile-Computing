package com.example.mobilecomputing

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.mobilecomputing.R

data class Message(val author: String, val body: String)

@Composable
fun MessageCard(msg: Message,
                navController: NavHostController
) {
    //Padding around message
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(R.drawable.cat),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                //image size
                .size(40.dp)
                //image shape
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
        )
        //Horizontal space between image and column
        Spacer(modifier = Modifier.width(8.dp))

        //variable for saving expand state
        var isExpanded by remember { mutableStateOf(false) }
        //surfaceColor will be changed if expanded
        val surfaceColor by animateColorAsState(
            if (isExpanded) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
            label = "",
        )

        //toggle isExpanded when click this column
        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            Text(
                text = msg.author,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleSmall
            )
            //space between author and msg
            Spacer(modifier = Modifier.height(4.dp))

            Surface(
                shape = MaterialTheme.shapes.medium,
                shadowElevation = 1.dp,
                color = surfaceColor,
                modifier = Modifier
                    .animateContentSize()
                    .padding(1.dp)) {
                Text(
                    text = msg.body,
                    modifier = Modifier.padding(all = 4.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    //if msg is expanded, display all content, otherwise only 1st line
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1
                )
            }

        }
    }
}

@Composable
fun Conversation(messages: List<Message>,
                 navController: NavHostController) {
    Column {
        Row (
            modifier = Modifier.fillMaxWidth().background(MaterialTheme.colorScheme.primary),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ){
            IconButton(onClick = { navController.navigate("settings")}) {
                Icon(Icons.Filled.Settings, contentDescription = "Settings")
            }
        }
        Divider(color = MaterialTheme.colorScheme.secondary)
        LazyColumn {
            items(messages) { message ->
                MessageCard(message, navController)
            }
        }
    }
}

/*
@Preview
@Composable
fun PreviewConversation() {
    HW1Theme {
        Conversation(SampleData.conversationSample)
    }
}

//@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun PreviewMessageCard() {
    HW1Theme {
        Surface {
            MessageCard(
                msg = Message("Kissa", "miau miau")
            )
        }
    }
}*/