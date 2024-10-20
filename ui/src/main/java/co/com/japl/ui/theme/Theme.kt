package co.com.japl.ui.theme

import android.app.Activity
import android.content.res.Configuration
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = white,
    secondary = yellow_light,
    background = black,
    primaryContainer = yellow_light,
    onPrimaryContainer = green,
    onPrimary = yellow,
    onSurface = white,
    onSurfaceVariant = white

)

private val LightColorScheme = lightColorScheme(
    primary = black,
    secondary = green,
    background = white,
    primaryContainer = green,
    onPrimaryContainer = yellow_light,
    onSurfaceVariant = black

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun MaterialThemeComposeUI(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.secondary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content,
    )
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun preview(){

    MaterialThemeComposeUI {
        Text(text="hi")
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
fun previewDark(){

    MaterialThemeComposeUI {
        Text(text="hi")
    }
}


@Composable
@Preview(showSystemUi = true, showBackground = true)
fun previewSurface(){

    MaterialThemeComposeUI {
        Surface {
            Column {
                Text(text = "hi")
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
fun previewSurfaceDark(){

    MaterialThemeComposeUI {
        Surface {
            Column {
                Text(text = "hi")
            }
        }
    }
}


@Composable
@Preview(showSystemUi = true, showBackground = true)
fun previewCard(){

    MaterialThemeComposeUI {
        Card(modifier = Modifier.padding(30.dp)) {
            Column (modifier = Modifier.padding(30.dp)){
                Text(text = "hi")
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
fun previewCardDark(){

    MaterialThemeComposeUI {
        Card(modifier = Modifier.padding(30.dp)) {
            Column (modifier = Modifier.padding(30.dp)){
                Text(text = "hi")
            }
        }
    }
}