package co.com.japl.connect.gdrive

import android.accounts.AuthenticatorException
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.os.AsyncTask
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.core.content.ContextCompat
import com.fasterxml.jackson.core.JacksonException
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.api.client.extensions.android.http.AndroidHttp
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport
import com.google.api.client.googleapis.json.GoogleJsonResponseException
import com.google.api.client.http.HttpTransport
import com.google.api.client.http.javanet.NetHttpTransport
import com.google.api.client.json.jackson2.JacksonFactory
import com.google.api.services.drive.Drive
import com.google.api.services.drive.DriveScopes
import com.google.api.services.drive.model.File
import com.google.auth.http.HttpCredentialsAdapter
import com.google.auth.http.HttpTransportFactory
import com.google.auth.oauth2.GoogleCredentials
import kotlinx.coroutines.Dispatchers
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class GDrive() {
    @RequiresApi(34)
    fun connect( context:Context){

        My5Task(context).execute()
    }


    class My2Task(val context:Context):AsyncTask<Void,Void,Void>() {
        override fun doInBackground(vararg p0: Void?): Void? {
            val folderId =
                "0B3jBktJ8T7h8dWxzZUlNem5HZGs?resourcekey=0-x_xsSsu68PILRyU1MnrGfQ&usp=drive_link"
            val urlInitial = "https://drive.google.com/drive/u/0/folders/${folderId}"
            val url = URL(urlInitial)
            val connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "GET"
            connection.connect()
            val code = connection.responseCode
            if (code == 200) {
                Log.d(javaClass.name,"doInBackgound ${connection.responseMessage} ${connection.content}")
                val buffered = BufferedReader(InputStreamReader(connection.inputStream))
                val lines = buffered.readLines()
                Log.d(javaClass.name,"doInBackgound ${lines}")
                connection.inputStream.close()
                buffered.close()
            }
        return null;
        }
    }

    class My3Task(val context:Context):AsyncTask<Void,Void,Void>() {
        override fun doInBackground(vararg p0: Void?): Void? {

            val transport = GoogleNetHttpTransport.newTrustedTransport()
            val jsonFactory = JacksonFactory.getDefaultInstance()
            val credentials = GoogleCredentials.getApplicationDefault()
            val requestInitializer = HttpCredentialsAdapter(credentials)
            val drive = Drive.Builder(transport,jsonFactory,requestInitializer)
                .setApplicationName("URAlameda181")
                .build()
            val folderId ="0B3jBktJ8T7h8dWxzZUlNem5HZGs"
            val folderLink = "https://drive.google.com/drive/u/0/folders/${folderId}"
            val request = drive.files().list()
            request.q = "'$folderLink' in parents"
            try{
                val response = request.execute()
                response.files.forEach { Log.d(javaClass.name,"Name: ${it.name}") }
            }catch(e:GoogleJsonResponseException){
                Log.e(javaClass.name,"$e")
            }

            return null;
        }
    }



    data class DriveFile(
        val id: String,
        val name: String,
        val mimeType: String,
        val modifiedTime: String,
        val size: Long
    )

    class MyTask(val context:Context):AsyncTask<Void,Void,Void>(){
        override fun doInBackground(vararg p0: Void?): Void? {

            val transport = GoogleNetHttpTransport.newTrustedTransport()
            val stream = context.resources.openRawResource(R.raw.uralameda181_auth2)
            val credentials = GoogleCredentials.fromStream(stream).createScoped(DriveScopes.all())
            val requestInitializer = HttpCredentialsAdapter(credentials)
            val service:Drive = Drive.Builder(transport,JacksonFactory.getDefaultInstance(),requestInitializer)
                .setApplicationName("URAlameda181")
                .build()
            val folderId = "0B3jBktJ8T7h8dWxzZUlNem5HZGs"
            val resourceKey = "0-x_xsSsu68PILRyU1MnrGfQ"
            val files = mutableListOf<File>()
            var pageToken: String? = null
            do{
                val result = service.files().list()
                    .execute()
                result.files?.forEach{ Log.d(javaClass.name,"Found file: ${it.id} ${it.name} ") }
                files.addAll(result.files ?: emptyList())
                pageToken = result.nextPageToken
            }while (pageToken != null)
            return null
        }

    }

    class My4Task(val context:Context):AsyncTask<Void,Void,Void>(){
        override fun doInBackground(vararg p0: Void?): Void? {

            val APPLICATION_NAME = "cralameda181"
            val JSON_FILE_PATH = "uralameda181_auth2.json"
            val packageName = "co.com.alameda181.unidadresidencialalameda181"

            val transport = NetHttpTransport.Builder().build()
            val stream = context.resources.openRawResource(R.raw.credentials)
            val jsonFactory = JacksonFactory.getDefaultInstance()
            //val serviceAccountKeyStream = resources.openRawResource(resources.getIdentifier(JSON_FILE_PATH,"raw",packageName))
            val serviceAccountKey = GoogleCredentials.fromStream(stream)
            val scopes = serviceAccountKey.createScoped(listOf("https://www.googleapis.com/auth/drive","https://www.googleapis.com/auth/drive.file"))
            val scoped = HttpCredentialsAdapter(scopes)
            val driveService = Drive.Builder(transport,jsonFactory,null)
                .setHttpRequestInitializer(scoped)
                .setApplicationName(APPLICATION_NAME)
                .build()
            driveService.files().list().execute().files.forEach { Log.d(javaClass.name,"Archivo: ${it.name}") }

            return null
        }

    }

    class My5Task(val context:Context):AsyncTask<Void,Void,Void>(){

        fun getDriveService():Drive?{
            Log.d(javaClass.name,"Start getDriveService")
            val googleAccount = GoogleSignIn.getLastSignedInAccount(context)
            if(googleAccount == null){
                if(!login(context)) {
                    throw AuthenticatorException("Usuario no logeado")
                }
            }
                val credentials =
                    GoogleAccountCredential.usingOAuth2(context, listOf(DriveScopes.DRIVE_FILE))
                credentials.selectedAccount = googleAccount?.account!!
                return Drive.Builder(AndroidHttp.newCompatibleTransport(),
                    JacksonFactory.getDefaultInstance(),
                    credentials)
                    .setApplicationName("cralameda181")
                    .build()
        }

        fun login(context:Context):Boolean{
            val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()
            val client = GoogleSignIn.getClient(context, gso)
            val intent = client.signInIntent
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            return ContextCompat.startActivities(context, arrayOf(intent))
        }

        fun accessDriveFiles(googleDriveService:Drive){
                //scope.launch(Dispatchers.Default) {
                    var pageToken: String? = null
                    do{
                        val result = googleDriveService.files().list().apply {
                            spaces = "drive"
                            fields = "nextPageToken, files(id, name)"
                            pageToken = this.pageToken
                        }.execute()
                        result.files.forEach { Log.d(javaClass.name,"Name: ${it.name}") }
                    }while(pageToken != null)
                //}
        }
        override fun doInBackground(vararg p0: Void?): Void? {
            Log.d(javaClass.name,"Start doInBackgound")
            val googleDriveService = getDriveService()
            val result = accessDriveFiles(googleDriveService!!)
            Log.d(javaClass.name,"Finish doInBackgound $result")
            return null
        }

    }

}