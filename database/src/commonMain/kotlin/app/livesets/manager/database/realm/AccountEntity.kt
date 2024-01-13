package app.livesets.manager.database.realm

import app.livesets.manager.database.domain.AccountModel
import app.livesets.manager.database.domain.AccountType
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

internal class AccountEntity : RealmObject {

    @PrimaryKey
    var id: String = ""
    var accessToken: String = ""
    var accessTokenExpireTime: Long = 0
    var refreshToken: String = ""
    var type: String = ""

    fun toModel(): AccountModel {
        return AccountModel(
            id = id,
            accessToken = accessToken,
            accessTokenExpireTime = accessTokenExpireTime,
            refreshToken = refreshToken,
            type = AccountType.valueOf(type)
        )
    }

}
