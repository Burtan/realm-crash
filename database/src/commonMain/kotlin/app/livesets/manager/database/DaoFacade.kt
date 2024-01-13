package app.livesets.manager.database

import app.livesets.manager.database.domain.AccountModel
import kotlinx.coroutines.flow.Flow

interface DaoFacade {
    fun observeAccounts(): Flow<List<AccountModel>>
    suspend fun removeAccount(account: AccountModel)
    suspend fun persistAccounts(accounts: Iterable<AccountModel>)
}
