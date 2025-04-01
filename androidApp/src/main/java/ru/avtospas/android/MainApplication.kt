package ru.avtospas.android

import android.app.Application
import androidx.compose.ui.platform.LocalContext
import com.yandex.mapkit.MapKitFactory
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.avtospas.feature.login.di.loginViewModelModule

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(loginViewModelModule)
            //val context = LocalContext.current
            MapKitFactory.setApiKey("fb01341c-367a-49b3-bfa0-7bcda8ac61bf")
            MapKitFactory.initialize(applicationContext)
            MapKitFactory.getInstance().onStart()
        }
    }
}