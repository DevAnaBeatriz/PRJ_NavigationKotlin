package com.example.prj_navigation.components

import android.content.ContentValues
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.LinearGradient
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope

import kotlinx.coroutines.launch

@Composable
fun TitleView(name: String, color: Color){
    Text(text = name, fontSize = 40.sp, fontWeight = FontWeight.Bold, color = color)
}

@Composable
fun Space(){
    Spacer(modifier = Modifier.height(15.dp))
}

@Composable
fun MainButton(name: String, backColor: Color, color: Color, shape: Shape, border: BorderStroke, onClick: () -> Unit){
    Button(onClick = onClick,
        colors = ButtonDefaults.buttonColors(
        contentColor = color,
        containerColor = backColor,
    ),
        shape = shape,
        border = border,

        ) {
        Text(text = name)
    }
}

@Composable
fun CardInfo(
    name: String,
    description: String,
    date: String,
    iconRes: Int,
    titulo: String,
    textnoti: String,


    ) {
    Column(
        modifier = Modifier

            .padding(16.dp)
            .fillMaxWidth()
            .background(Color(0xFF2B2C2C), shape = RoundedCornerShape(6.dp) )
            .border(
                border = BorderStroke(2.dp, Color(0xFF7AD4FD)),
                shape = RoundedCornerShape(6.dp)
            )
    ) {
        Text(text = titulo,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color(0xFFFFFFFF),
            modifier = Modifier
                .padding(start = 18.dp, top = 18.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(18.dp)
                .fillMaxWidth()) {

            Image(
                painter = painterResource(iconRes),
                contentDescription = stringResource(id = com.example.prj_navigation.R.string.fotoperfil_content_description),
                modifier = Modifier
                    .size(120.dp)
                    .fillMaxWidth()
            )

        }
            Column (  modifier = Modifier
                .padding(18.dp)
                .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
            ) {


                Spacer(modifier = Modifier.width(8.dp))
                Text(text = name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color(0xFFFFFFFF)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = description,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = Color(0xFFFFFFFF))
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = date,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = Color(0xFFFFFFFF))
            }
        }

    }


