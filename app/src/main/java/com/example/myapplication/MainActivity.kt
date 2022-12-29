package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.iit.certificateAuthority.endUser.libraries.signJava.EndUser
import com.iit.certificateAuthority.endUser.libraries.signJava.EndUserResourceExtractor


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        EndUserResourceExtractor.SetPath(this.filesDir.absolutePath)

        EndUserResourceExtractor.SetPreLoad(true)
        var endUser = EndUser()
        endUser.SetUIMode(true)
        endUser.SetLanguage(EndUser.EU_UA_LANG)
        if (endUser.IsInitialized())
            throw IllegalStateException("CryptoService is already initialized. Why creating a second instance?")
        endUser.Initialize()
    }
}