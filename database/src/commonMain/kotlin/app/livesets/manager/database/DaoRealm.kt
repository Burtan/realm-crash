package app.livesets.manager.database

import app.livesets.manager.database.domain.AccountModel
import app.livesets.manager.database.realm.AccountEntity
import app.livesets.manager.database.realm.toRealm
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.UpdatePolicy
import io.realm.kotlin.ext.query
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DaoRealm(path: String = "") : DaoFacade {

    private val realm: Realm

    init {
        val config = RealmConfiguration
            .Builder(
                schema = setOf(
                    AccountEntity::class,
                )
            )
            .deleteRealmIfMigrationNeeded()
            .directory(path)
            .build()

        realm = Realm.open(config)
    }

    override suspend fun removeAccount(account: AccountModel) {
        realm.write {
            realm.query<AccountEntity>("id = $0", account.id)
                .find()
                .firstOrNull()
                ?.let { entity ->
                    findLatest(entity)?.let {
                        delete(it)
                    }
                }
        }
    }

    override fun observeAccounts(): Flow<List<AccountModel>> {
        return realm.query<AccountEntity>()
            .find()
            .asFlow()
            .map { change ->
                change.list.map { it.toModel() }
            }
    }

    override suspend fun persistAccounts(accounts: Iterable<AccountModel>) {
        realm.write {
            accounts
                .map { it.toRealm() }
                .forEach {
                    copyToRealm(it, UpdatePolicy.ALL)
                }
        }
    }

}
