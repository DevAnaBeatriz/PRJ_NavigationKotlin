package com.example.prj_navigation.views

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.prj_navigation.components.ButtonIcon
import com.example.prj_navigation.components.ButtonNormal
import com.example.prj_navigation.components.ButtonNormal2
import com.example.prj_navigation.components.ButtonOutline
import com.example.prj_navigation.components.ButtonSwitch
import com.example.prj_navigation.components.ButtonText
import com.example.prj_navigation.components.DarkMode
import com.example.prj_navigation.components.FloatingAction
import com.example.prj_navigation.components.MainButton
import com.example.prj_navigation.components.MainIconButton
import com.example.prj_navigation.ui.theme.ChangeStatusBarColor
import com.example.prj_navigation.ui.theme.PRJ_NavigationTheme


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ButtonsView(navController: NavController){
    val darkMode = remember { mutableStateOf(false) }

    PRJ_NavigationTheme(darkTheme = darkMode.value) {
        // A surface container using the 'background' color from the theme


        Scaffold(
            containerColor= MaterialTheme.colorScheme.background,
            bottomBar =  {
                BottomAppBar(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.primary

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
                        color = MaterialTheme.colorScheme.onPrimary
                    ) },
                    colors = TopAppBarDefaults.mediumTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    ),
                    navigationIcon = {
                        MainIconButton(icon = Icons.Default.ArrowBack, color=MaterialTheme.colorScheme.onPrimary) {
                            navController.popBackStack()

                        }
                    }
                )

            }
        ) {

            ContentButtonsView(darkMode = darkMode, navController)

        }


    }

    }


@Composable
fun ContentButtonsView(darkMode: MutableState<Boolean>, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Spacer(modifier = Modifier.height(75.dp))
        ButtonNormal()
        Spacer(modifier = Modifier.height(10.dp))
        ButtonNormal2()
        Spacer(modifier = Modifier.height(10.dp))
        ButtonText()
        Spacer(modifier = Modifier.height(10.dp))
        ButtonOutline()
        Spacer(modifier = Modifier.height(10.dp))
        ButtonIcon()
        Spacer(modifier = Modifier.height(10.dp))
        ButtonSwitch()
        Spacer(modifier = Modifier.height(10.dp))
        DarkMode(darkMode = darkMode)
        Spacer(modifier = Modifier.height(10.dp))
        FloatingAction()
        Spacer(modifier = Modifier.height(10.dp))

        MainButton(name = "Return Home", backColor = MaterialTheme.colorScheme.primary, color = MaterialTheme.colorScheme.onPrimary,
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(2.dp, MaterialTheme.colorScheme.primary),) {
            navController.navigate("Home")
        }
    }

}