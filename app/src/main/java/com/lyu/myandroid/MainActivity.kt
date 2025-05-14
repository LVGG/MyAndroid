package com.lyu.myandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lyu.myandroid.activity.KotlinBasicActivity
import com.lyu.myandroid.data.ButtonInfo
import com.lyu.myandroid.databinding.ActivityMainLayoutBinding
import com.lyu.myandroid.myview.VerticalButtonList
import com.lyu.myandroid.ui.theme.MyAndroidTheme


class MainActivity : ComponentActivity() {

    private val activityList =  listOf(
        ButtonInfo("Rxjava", KotlinBasicActivity::class.java),
        ButtonInfo("Kotlin 基础", KotlinBasicActivity::class.java),
        ButtonInfo("Kotlin 进阶", KotlinBasicActivity::class.java),
    )

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()

        setContent {
            MyAndroidTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        SmallTopAppBar (
                            title = {
                                Text(text = "MyAndroid")
                            }
                        )
                    },
                ) { paddingValues ->
                    VerticalButtonList(
                        context = this,
                        buttonInfoList = activityList,
                        modifier = Modifier.padding(paddingValues)
                    )
                }
            }
        }
    }
}


