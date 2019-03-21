# Demo Dagger 2
Demo Dagger 2 with:
* AndroidInjector
* @ContributesAndroidInjector @Binds @Inject constructor() annotation
* Custom `ActivityTestRule` to Inject mock for testing Activity

## Code
* MainActivity
```
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var info: Info

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text_view.text = info.text
    }
}
```

* DemoDaggerApplication
```
class DemoDaggerApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroid: DispatchingAndroidInjector<Activity>

    lateinit var activityInjector: AndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder().application(this).build().inject(this)

        activityInjector = activityDispatchingAndroid
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityInjector
    }
}
```

* AppActivityBindingModule
```
@Module
abstract class AppActivityBindingModule {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun activity(): MainActivity
}
```

* MainActivityModule
```
@Module
abstract class MainActivityModule {
    @Binds
    abstract fun provideInfo(info: Info): InfoInterface
}
```

* MainActivityTest
```
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
```

## References

* [Google Dagger 2](https://github.com/google/dagger)


## Authors

* **Tuan Nguyen** - Gmail: *tuan25abc@gmail.com*
