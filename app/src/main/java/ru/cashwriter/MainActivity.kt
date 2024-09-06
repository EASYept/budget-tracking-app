package ru.cashwriter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.cashwriter.apps.dice.DiceApp
import ru.cashwriter.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                val layoutDirection = LocalLayoutDirection.current
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .statusBarsPadding()
                        .padding(
                            start = WindowInsets.safeDrawing
                                .asPaddingValues()
                                .calculateStartPadding(layoutDirection),
                            end = WindowInsets.safeDrawing
                                .asPaddingValues()
                                .calculateEndPadding(layoutDirection),
                        ),
                ) {
                    DiceApp()
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScrollableApp() {
    CardList()
}

@Composable
fun CardList() {
    val loadAffirmations: List<Affirmation> = loadAffirmations()
    val layoutDirection = LocalLayoutDirection.current
    val modifier = Modifier
        .fillMaxWidth()
        .statusBarsPadding()
        .padding(
            start = WindowInsets.safeDrawing
                .asPaddingValues()
                .calculateStartPadding(layoutDirection),
            end = WindowInsets.safeDrawing
                .asPaddingValues()
                .calculateEndPadding(layoutDirection),
        );
    LazyColumn(modifier) {
        items(loadAffirmations) { af ->
            OneCard(affirmation = af, modifier = Modifier.padding(15.dp))
        }
    }
}


@Composable
fun OneCard(affirmation: Affirmation, modifier: Modifier) {
    Card(modifier = modifier) {
        Column {
            val contentDescription = stringResource(id = affirmation.stringResourceId)
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = affirmation.imageResourceId),
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )
//            Spacer(modifier = modifier)
            Text(
                text = contentDescription,
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )

        }
    }

}


data class Affirmation(
    val stringResourceId: Int,
    val imageResourceId: Int
)

fun loadAffirmations(): List<Affirmation> {
    return listOf<Affirmation>(
        Affirmation(R.string.affirmation1, R.drawable.dice_1),
        Affirmation(R.string.affirmation2, R.drawable.dice_2),
        Affirmation(R.string.affirmation3, R.drawable.dice_3),
        Affirmation(R.string.affirmation4, R.drawable.dice_4),
        Affirmation(R.string.affirmation5, R.drawable.dice_5),
        Affirmation(R.string.affirmation6, R.drawable.dice_6),
        Affirmation(R.string.affirmation7, R.drawable.dice_2),
        Affirmation(R.string.affirmation8, R.drawable.dice_1)
    )
}

