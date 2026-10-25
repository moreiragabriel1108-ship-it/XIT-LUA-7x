
package com.luaxit.sevenx

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Black = Color(0xFF090909)
private val CardBlack = Color(0xFF171717)
private val Red = Color(0xFFFF2438)
private val White = Color(0xFFF5F5F5)
private val Gray = Color(0xFFAAAAAA)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                LuaXitScreen()
            }
        }
    }
}

@Composable
fun LuaXitScreen() {
    var aimTraining by remember { mutableStateOf(false) }
    var floatingPanel by remember { mutableStateOf(false) }
    var sensitivity by remember { mutableFloatStateOf(100f) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Black
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            Text(
                text = "LUA XIT 7x",
                color = Red,
                fontSize = 30.sp,
                fontWeight = FontWeight.Black
            )
            Text(
                text = "GAMING PANEL  •  ANDROID",
                color = Gray,
                fontSize = 12.sp
            )

            HorizontalDivider(color = Red)

            Text(
                text = "PAINEL PRINCIPAL",
                color = White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            PanelCard {
                SettingSwitch(
                    title = "Modo de treino",
                    subtitle = "Ativa o modo de treino dentro do painel",
                    checked = aimTraining,
                    onCheckedChange = { aimTraining = it }
                )
            }

            PanelCard {
                SettingSwitch(
                    title = "Painel flutuante",
                    subtitle = "Atalho visual dentro deste app",
                    checked = floatingPanel,
                    onCheckedChange = { floatingPanel = it }
                )
            }

            PanelCard {
                Text(
                    text = "Sensibilidade",
                    color = White,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "${sensitivity.toInt()}%",
                    color = Red,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Slider(
                    value = sensitivity,
                    onValueChange = { sensitivity = it },
                    valueRange = 0f..100f,
                    colors = SliderDefaults.colors(
                        thumbColor = Red,
                        activeTrackColor = Red
                    )
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "LUA XIT 7x • V1.0",
                color = Gray,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 12.sp
            )
        }
    }
}

@Composable
fun PanelCard(content: @Composable ColumnScope.() -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(CardBlack, RoundedCornerShape(16.dp))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        content = content
    )
}

@Composable
fun SettingSwitch(
    title: String,
    subtitle: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(title, color = White, fontWeight = FontWeight.Bold)
            Text(subtitle, color = Gray, fontSize = 12.sp)
        }
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = SwitchDefaults.colors(
                checkedThumbColor = White,
                checkedTrackColor = Red
            )
        )
    }
}
