package app.livesets.manager.database

import io.kotest.matchers.shouldBe
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import kotlin.random.Random
import kotlin.test.Test

class DaoRealmTestWithRobo : MultiPlatformTest() {

    @Test
    fun testAccountDb() = runTest {
        val dao = DaoRealm("build/test/db${Random.nextInt()}")
        dao.persistAccounts(
            listOf(
                TestData.Account1,
                TestData.Account2
            )
        )

        val accounts = dao.observeAccounts()
            .filterNotNull()
            .first()

        accounts.size shouldBe 2

        accounts[0] shouldBe TestData.Account1
        accounts[1] shouldBe TestData.Account2

        dao.removeAccount(accounts[0])
        dao.removeAccount(accounts[1])

        val postAccounts = dao.observeAccounts()
            .filterNotNull()
            .first()

        postAccounts.size shouldBe 0
    }

}
