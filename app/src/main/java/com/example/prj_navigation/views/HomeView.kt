package com.example.prj_navigation.views

import android.annotation.SuppressLint
import android.content.ContentValues
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.prj_navigation.R
import com.example.prj_navigation.components.ActionButton
import com.example.prj_navigation.components.CardInfo
import com.example.prj_navigation.components.MainButton
import com.example.prj_navigation.components.Space
import com.example.prj_navigation.components.TitleView
import com.example.prj_navigation.ui.theme.ChangeStatusBarColor

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView(navController: NavController) {
    Scaffold(
        containerColor= Color(0xFF2B2C2C),
        bottomBar =  {BottomAppBar(
            containerColor = Color(0xFF7AD4FD),
            contentColor = Color.White,

        ) {
//
        }},

        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Home View",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color(0xFF333536)
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(Color(0xFF7AD4FD)),
                navigationIcon = {},
                actions = {
                    IconButton(
                        onClick = {
                            Log.i(ContentValues.TAG, "Clicou em Home!")
                        }
                    ) {
                        Icon(
                            Icons.Default.Home,
                            contentDescription = null,
                            tint = Color(0xFF333536)
                        )
                    }
                }
            )
        }
    ) {

                ContentHomeView(navController)

        }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentHomeView(navController: NavController) {
    val id = 123
    var opcional by remember { mutableStateOf("") }
    ChangeStatusBarColor(color = Color(0xFF7AD4FD))
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF2B2C2C))
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(top=60.dp)
                .verticalScroll(rememberScrollState())
        ) {
            TitleView(name = "Digite um valor:", color = Color.White)
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(

                value = opcional,
                onValueChange = { opcional = it },
                label = { Text(text = "Digite aqui!", color = Color(0xFF7AD4FD)) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF7AD4FD),
                    unfocusedBorderColor = Color(0xFF7AD4FD),
                    containerColor = Color(0xFF2B2C2C),
                    textColor = Color(0xFF7AD4FD)
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                MainButton(
                    name = "Detail View",
                    backColor = Color(0xFF4CAF50),
                    color = Color.White,
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(2.dp, Color(0xFF4CAF50)),
                    onClick = { navController.navigate("Detail/${id}/?${opcional}") }
                )
                MainButton(
                    name = "Buttons View",
                    backColor = Color.Red,
                    color = Color.White,
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(2.dp, Color.Red),
                    onClick = { navController.navigate("Buttons") }
                )
                ActionButton()
            }
            Spacer(modifier = Modifier.height(16.dp))
            CardInfo(
                name = "Ana Beatriz Martins Batista",
                description = "Registro de Matrícula: 22284",
                date = "Aplicativo desenvolvido em: 13/09/2023",
                R.drawable.menina,
                titulo = "Desenvolvedora",
                textnoti = "Clicou em Desenvolvedora."
            )

        }


    }
}