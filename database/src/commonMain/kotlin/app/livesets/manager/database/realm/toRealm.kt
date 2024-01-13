@file:Suppress("DuplicatedCode")

package app.livesets.manager.database.realm

import app.livesets.manager.database.domain.*

internal fun AccountModel.toRealm(): AccountEntity {
    return AccountEntity().also {
        it.id = id
        it.accessToken = accessToken
        it.accessTokenExpireTime = accessTokenExpireTime
        it.refreshToken = refreshToken
        it.type = type.toString()
    }
}
