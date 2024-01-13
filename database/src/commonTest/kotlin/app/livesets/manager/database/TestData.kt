package app.livesets.manager.database

import app.livesets.manager.database.domain.AccountModel
import app.livesets.manager.database.domain.AccountType

object TestData {
    // accounts
    val Account1 = AccountModel(
        id = "testAccount1",
        accessToken = "accessToken1",
        accessTokenExpireTime = 10,
        refreshToken = "refreshToken1",
        type = AccountType.Google
    )
    val Account2 = AccountModel(
        id = "testAccount2",
        accessToken = "accessToken2",
        accessTokenExpireTime = 20,
        refreshToken = "refreshToken2",
        type = AccountType.Amazon
    )
}
