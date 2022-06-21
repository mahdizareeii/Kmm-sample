package com.kmm.myapplication.android.screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import com.kmm.domain.viewmodel.AnimalListViewModel

@Composable
fun AnimalListScreen(viewModel: AnimalListViewModel) {
    val list = viewModel.animals.collectAsState(listOf()).value
    val error = viewModel.error.collectAsState(null).value
    error?.let {
        Toast.makeText(LocalContext.current, it, Toast.LENGTH_SHORT).show()
    }
    LazyColumn {
        items(list) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp),
                    painter = rememberAsyncImagePainter(
                        ImageRequest.Builder(LocalContext.current).data(
                            data = it.imageLink,
                        ).apply {
                            crossfade(true)
//                            placeholder(R.drawable.place_holder)
                            scale(Scale.FILL)
                        }.build()
                    ),
                    contentDescription = "image",
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.padding(5.dp))
                Column {
                    Text(text = it.name.toString())
                    Spacer(modifier = Modifier.padding(3.dp))
                    Text(text = it.animalType.toString(), fontSize = 12.sp)
                }
            }
        }
    }
}