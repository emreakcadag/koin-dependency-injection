package com.emreakcadag.koindependencyinjection

import com.emreakcadag.koindependencyinjection.di.networkModule
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.check.checkModules

/**
 * Created by Emre Akçadağ on 3.06.2020
 *
 */
class ModuleTest : KoinTest {
    @Test
    fun `Test Koin Modules`() {
        startKoin {
            modules(listOf(networkModule))
        }.checkModules()

        stopKoin()
    }
}