package com.esi.tdm.apetito

import android.app.Application
import com.joanzapata.iconify.Iconify
import com.joanzapata.iconify.fonts.*

/**
 * Created by djall on 4/24/2018.
 */
class Apetito: Application() {
    override fun onCreate() {
        super.onCreate()
        Iconify
                .with(FontAwesomeModule())
                .with(EntypoModule())
                .with(TypiconsModule())
                .with(MaterialModule())
                .with(MaterialCommunityModule())
                .with(MeteoconsModule())
                .with(WeathericonsModule())
                .with(SimpleLineIconsModule())
                .with(IoniconsModule());
    }
}