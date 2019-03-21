package com.example.tuannguyen.demodagger2

import android.content.Intent
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import com.nhaarman.mockitokotlin2.mock
import dagger.android.AndroidInjector
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    @get:Rule
    val rule = object : ActivityTestRule<MainActivity>(MainActivity::class.java) {
        override fun beforeActivityLaunched() {
            super.beforeActivityLaunched()
            val application = InstrumentationRegistry.getTargetContext().applicationContext as DemoDaggerApplication
            application.activityInjector = AndroidInjector {
                mock(it as MainActivity)
            }
        }
    }

    fun mock(mainActivity: MainActivity) {
        mainActivity.info = mock {
            on { getMessage() }.thenReturn("Mock activity success")
        }
    }

    @Test
    fun startActivity() {
        rule.launchActivity(Intent())
        onView(withText("Mock activity success")).check(matches(isDisplayed()))
    }
}