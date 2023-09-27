package com.example.prj_navigation.components


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun TitleBar(name: String){
    Text(text = name, fontSize = 25.sp, color = Color.White)
}

@Composable
fun ActionButton(){

    FloatingActionButton(
        containerColor = Color(0xFF7AD4FD),
        onClick = {  },
//        modifier = Modifier
//            .padding(16.dp)
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Add",
            tint = Color(color = 0xffe7e0cf)
        )
    }
}

@Composable
fun MainIconButton(icon: ImageVector, color: Color, onClick:() -> Unit){
    IconButton(onClick = onClick) {
        Icon(imageVector = icon, contentDescription = null, tint = color)
    }
}