package co.com.alameda181.unidadresidencialalameda181

import android.content.ClipData.Item
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import co.com.alameda181.unidadresidencialalameda181.about.AboutActivity
import co.com.alameda181.unidadresidencialalameda181.ui.composite.Alameda181
import co.com.alameda181.unidadresidencialalameda181.ui.composite.navigator.Navigator
import co.com.alameda181.unidadresidencialalameda181.ui.composite.navigator.NavigatorSplash
import co.com.alameda181.ui.theme.theme.UnidadResidencialAlameda181Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val context = LocalContext.current.applicationContext
            co.com.alameda181.ui.theme.theme.UnidadResidencialAlameda181Theme {
                NavigatorSplash(
                    navController = navController,
                    modifier = Modifier.padding(0.dp),
                    context = context
                )
            }
        }
    }
}

