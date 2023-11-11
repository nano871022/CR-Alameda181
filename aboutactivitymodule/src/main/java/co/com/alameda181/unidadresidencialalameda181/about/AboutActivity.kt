package co.com.alameda181.unidadresidencialalameda181.about

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import co.com.alameda181.ui.theme.theme.MaterialThemeComposeUI
import co.com.alameda181.unidadresidencialalameda181.about.UI.About

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            val context = LocalContext.current.applicationContext
            MaterialThemeComposeUI {
                About("Module sin version")
            }
        }
    }
}