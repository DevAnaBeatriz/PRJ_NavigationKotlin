package com.example.prj_navigation.views

import android.annotation.SuppressLint
import android.content.ContentValues
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.prj_navigation.R
import com.example.prj_navigation.components.MainButton
import com.example.prj_navigation.components.MainIconButton
import com.example.prj_navigation.components.Space
import com.example.prj_navigation.components.TitleBar
import com.example.prj_navigation.components.TitleView
import com.example.prj_navigation.ui.theme.ChangeStatusBarColor

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailView(navController: NavController, id: Int, opcional: String?){
    Scaffold(
        containerColor= Color(0xFF2B2C2C),
        bottomBar =  {
            BottomAppBar(
            containerColor = Color(0xFF4CAF50),
            contentColor = Color.White,

            ) {
//
        }
        },

        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text(
                        "Detail View",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.White
                    ) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color(0xFF4CAF50)
                ),
                navigationIcon = {
                    MainIconButton(icon = Icons.Default.ArrowBack, color = Color.White) {
                        navController.popBackStack()

                    }
                }
            )

        }
    ) {

        ContentDetailView(navController, id, opcional)

    }


}


@Composable
fun ContentDetailView(navController: NavController, id: Int, opcional: String?) {
    ChangeStatusBarColor(color = Color(0xFF4CAF50))
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF2B2C2C))
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)

                .verticalScroll(rememberScrollState()),

            verticalArrangement = Arrangement.Top,
            horizontalAlignment =  Alignment.CenterHorizontally
        ) {

        Spacer(modifier=Modifier.padding(40.dp))
        TitleView(name = "Minha Detail View", color = Color.White)
        Space()
        TitleView(name = id.toString(), color = Color(0xFF4CAF50))
        Space()

        if (opcional == ""){
            Spacer(modifier = Modifier.height(0.dp))
        }else{
            Column(
                modifier = Modifier

                    .padding(16.dp)
                    .fillMaxWidth()
                    .background(Color(0xFF2B2C2C), shape = RoundedCornerShape(6.dp) )
                    .border(
                        border = BorderStroke(2.dp, Color(0xFF4CAF50)),
                        shape = RoundedCornerShape(6.dp)
                    )
            ) {
                Box(modifier = Modifier.padding(8.dp)){
                TitleView(name = opcional.orEmpty(), color = Color.White)

            }
        }
        }

            Space()
            Image(
                painter = painterResource(id = R.drawable.lupa),
                contentDescription = stringResource(id = R.string.fotoperfil_content_description),
                modifier = Modifier
                    .size(200.dp)
                    .fillMaxWidth(),
                alignment = Alignment.BottomCenter
            )
            Spacer(modifier = Modifier.height(40.dp))
            MainButton(name = "Return Home", backColor = Color(0xFF4CAF50), color = Color.White,
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(2.dp, Color(0xFF4CAF50)),) {
                navController.popBackStack()
            }


        }
    }
}

