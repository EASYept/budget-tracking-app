package ru.cashwriter.apps.birthdaycard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import ru.cashwriter.R
import ru.cashwriter.ui.theme.MyApplicationTheme


@Composable
fun GreetingText(message: String, from: String = "User", modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Text(
            text = message,
            fontSize = 40.sp,
            lineHeight = 18.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 40.sp,
            lineHeight = 11.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingTextPreview() {
    MyApplicationTheme {
        GreetingText(message = "you can manually add the imports at the top of the file")
    }
}

@Composable
fun KekWImage(message: String, from: String, modifier: Modifier = Modifier) {
    val kekKekw = painterResource(R.drawable.androidparty);
    Box(modifier, Alignment.Center) {
        Image(
            painter = kekKekw,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F,
        )
        GreetingText(message = message, modifier = modifier)

    }

}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    MyApplicationTheme {
        KekWImage(
            message = "Happy Birthday!",
            from = "From Emma"
        )
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

