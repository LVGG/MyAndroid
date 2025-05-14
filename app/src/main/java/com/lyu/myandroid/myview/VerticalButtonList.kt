package com.lyu.myandroid.myview

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lyu.myandroid.data.ButtonInfo

@Composable
fun VerticalButtonList(
    context: Context,
    buttonInfoList: List<ButtonInfo>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.then(
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        buttonInfoList.forEach { buttonInfo ->
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    val intent = Intent(context, buttonInfo.targetActivity)
                    context.startActivity(intent)
                }
            ) {
                Text(text = buttonInfo.name)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VerticalButtonListPreview() {

    // 由于预览环境中无法启动 Activity，使用一个空的 Activity 类作为占位符
    class PreviewActivity : Activity()

    // 获取预览上下文
    val context = LocalContext.current
    // 模拟按钮信息列表
    val buttonInfoList = listOf(
        ButtonInfo("按钮 1", PreviewActivity::class.java),
        ButtonInfo("按钮 2", PreviewActivity::class.java),
        ButtonInfo("按钮 3", PreviewActivity::class.java)
    )
    // 调用组件
    VerticalButtonList(
        context = context,
        buttonInfoList = buttonInfoList
    )

}