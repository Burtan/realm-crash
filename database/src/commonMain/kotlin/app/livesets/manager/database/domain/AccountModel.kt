package app.livesets.manager.database.domain

data class AccountModel(
    val id: String,
    val accessToken: String,
    val accessTokenExpireTime: Long,
    val refreshToken: String,
    val type: AccountType
)
