package app.livesets.manager.desktop

import androidx.compose.ui.window.application
import app.livesets.manager.database.DaoRealm

fun main() = application {
    DaoRealm("build/test/db")
}
