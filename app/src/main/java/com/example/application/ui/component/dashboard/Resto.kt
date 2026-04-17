package com.example.application.ui.component.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.application.R

data class Resto(
    val name: String,
    val rating: String,
    val image: Int
)

@Composable
fun RestoSection() {

    val restos = listOf(
        Resto("Kopi Kenangan", "⭐ 4.8 • 1.2km", R.drawable.resto_kopikenangan),
        Resto("Ayam Geprek", "⭐ 4.6 • 0.8km", R.drawable.resto_ayamgeprek),
        Resto("Sate Madura", "⭐ 4.7 • 1.5km", R.drawable.resto_sate)
    )

    val displayList = List(6) { restos[it % restos.size] }

    Column(modifier = Modifier.padding(16.dp)) {

        Text(
            "Semar Resto Termurah",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        LazyRow {
            items(displayList) { resto ->
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .width(160.dp)
                        .border(
                            2.dp,
                            Color(0xFFE0E0E0),
                            RoundedCornerShape(16.dp)
                        ),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Transparent
                    ),
                    elevation = CardDefaults.cardElevation(0.dp)
                ) {

                    Column {

                        Image(
                            painter = painterResource(id = resto.image),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .height(100.dp)
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                        )

                        Column(modifier = Modifier.padding(8.dp)) {
                            Text(resto.name, fontWeight = FontWeight.Bold, color = Color.Black)
                            Text(resto.rating, fontSize = 12.sp, color = Color.Black)
                        }
                    }
                }
            }
        }
    }
}
