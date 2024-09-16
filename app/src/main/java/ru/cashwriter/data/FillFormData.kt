package ru.cashwriter.data

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import ru.cashwriter.AppNavigationActions
import java.util.ArrayList
import java.util.HashMap

private const val TAG = "FillFormData"

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object FillFormData {

    /**
     * An array of sample (placeholder) items.
     */
    val ITEMS: MutableList<PlaceholderItem> = ArrayList()

    /**
     * A map of sample (placeholder) items, by ID.
     */
    val ITEM_MAP: MutableMap<String, PlaceholderItem> = HashMap()

    private val COUNT = 25

    init {
        // Add some sample items.
        for (i in 1..COUNT) {
            addItem(createItem(i))
        }
    }

    private fun addItem(item: PlaceholderItem) {
        ITEMS.add(item)
        ITEM_MAP.put(item.id, item)
    }

    private fun createItem(position: Int): PlaceholderItem {
        return PlaceholderItem(position.toString(), "Item " + position, makeDetails(position))
    }

    private fun makeDetails(position: Int): String {
        val builder = StringBuilder()
        builder.append("Details about Item: ").append(position)
        for (i in 0..position - 1) {
            builder.append("\nMore details information here.")
        }
        return builder.toString()
    }

    /**
     * A placeholder item representing a piece of content.
     */
    data class PlaceholderItem(val id: String, val content: String, val details: String) {
        override fun toString(): String = content
    }

}

@Composable
fun FillFormWindow(navActions: AppNavigationActions) {
    var text1 by rememberSaveable { mutableStateOf("") }
    var text2 by rememberSaveable { mutableStateOf("") }
    var text3 by rememberSaveable { mutableStateOf("") }
    Column {
        Row {
            TextField(
                value = text1,
                onValueChange = { value ->
                    text1 = value
                    Log.d(TAG, "onValueChange1 $value")
                },
                label = { Text("Email") },
                placeholder = { Text("example@gmail.com") }
            )
        }
        Row {
            TextField(
                value = text2,
                onValueChange = { value ->
                    text2 = value
                    Log.d(TAG, "onValueChange2 $value")
                }
            )
        }
        Row {
            TextField(
                value = text3,
                onValueChange = { value ->
                    text3 = value
                    Log.d(TAG, "onValueChange3 $value")
                }
            )
        }
        Row {
            Button(onClick = {
                Log.d(TAG, "Button click FillFormFragment")
                navActions.navigateToTable()
            }) {

            }

        }
    }

}
//class DatePickerFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {
//
//    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
//        // Use the current date as the default date in the picker.
//        val c = Calendar.getInstance()
//        val year = c.get(Calendar.YEAR)
//        val month = c.get(Calendar.MONTH)
//        val day = c.get(Calendar.DAY_OF_MONTH)
//
//        // Create a new instance of DatePickerDialog and return it.
//        return DatePickerDialog(requireContext(), this, year, month, day)
//
//    }
//
//    override fun onDateSet(view: DatePicker, year: Int, month: Int, day: Int) {
//        // Do something with the date the user picks.
//    }
//}


@Composable
fun FillFormWindow2(items: MutableList<FillFormData.PlaceholderItem>) {
//    var text1 by rememberSaveable { mutableStateOf("") }
//    var text2 by rememberSaveable { mutableStateOf("") }
//    var text3 by rememberSaveable { mutableStateOf("") }
    LazyColumn {
        items(1) { af ->
            MyColumn()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MyColumn() {
    Column {
        Row {
            TextField(
                value = "text1",
                onValueChange = { value ->
//                    text1 = value
                    Log.d(TAG, "onValueChange1 $value")
                },
                label = { Text("Email") },
                placeholder = { Text("example@gmail.com") }
            )
        }
//        Row {
//            TextField(
//                value = text2,
//                onValueChange = { value ->
//                    text2 = value
//                    Log.d(TAG, "onValueChange2 $value")
//                }
//            )
//        }
//        Row {
//            TextField(
//                value = text3,
//                onValueChange = { value ->
//                    text3 = value
//                    Log.d(TAG, "onValueChange3 $value")
//                }
//            )
//        }
//        Row {
//            Button(onClick = {
//                Log.d(TAG, "Button click FillFormFragment")
//            }) {
//
//            }
//
//        }
    }
}