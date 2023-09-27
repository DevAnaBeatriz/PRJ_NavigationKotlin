package com.example.prj_navigation.ui.theme

import android.app.Activity
import android.view.View
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

@Composable
fun ChangeStatusBarColor(color: Color) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    AndroidView(factory = { context ->
        View(context).apply {
            setBackgroundColor(color.toArgb())
        }
    }, update = { view ->
        val window = (context as? Activity)?.window
        val originalStatusBarColor = window?.statusBarColor
        window?.statusBarColor = color.toArgb()

        val observer = object : LifecycleObserver {
            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            fun onDestroy() {
                window?.statusBarColor = 0xFF7AD4FD.toInt()
                lifecycleOwner.lifecycle.removeObserver(this)
            }
        }

        lifecycleOwner.lifecycle.addObserver(observer)
    })

}
