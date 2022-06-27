package com.kmm.myapplication.android.screen.animal

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import com.kmm.domain.model.Animal
import com.kmm.domain.viewmodel.AnimalListViewModel
import com.kmm.myapplication.android.screen.BaseScreen
import com.kmm.myapplication.android.screen.Screen
import com.kmm.myapplication.android.screen.detail.DetailScreenArgument

class AnimalScreen(
    private val viewModel: AnimalListViewModel
) : BaseScreen {

    @Composable
    override fun createScreen(navController: NavController) {
        val list = viewModel.animals.collectAsState(listOf()).value
        val error = viewModel.error.collectAsState(null).value
        error?.let {
            Toast.makeText(LocalContext.current, it, Toast.LENGTH_SHORT).show()
        }
        LazyColumn {
            items(list) {
                Row(
                    modifier = Modifier
                        .clickable {
                            val data = DetailScreenArgument(
                                title = it.name.toString()
                            )

                            putArgument(navController) {
                                set(
                                    Screen.DetailScreen.argumentId,
                                    data
                                )
                            }
                            navController.navigate(
                                Screen.DetailScreen.route,
                            )
                        }
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    createImageView(it)
                    Spacer(modifier = Modifier.padding(5.dp))
                    createContent(it)
                }
            }
        }
    }

    @Composable
    private fun createImageView(animal: Animal) = Image(
        modifier = Modifier
            .width(100.dp)
            .height(100.dp),
        painter = rememberAsyncImagePainter(
            ImageRequest.Builder(LocalContext.current).data(
                data = animal.imageLink,
            ).apply {
                crossfade(true)
                //placeholder(R.drawable.place_holder)
                scale(Scale.FILL)
            }.build()
        ),
        contentDescription = "image",
        contentScale = ContentScale.Crop
    )

    @Composable
    private fun createContent(animal: Animal) {
        Column {
            Text(text = animal.name.toString())
            Spacer(modifier = Modifier.padding(3.dp))
            Text(text = animal.animalType.toString(), fontSize = 12.sp)
        }
    }
}