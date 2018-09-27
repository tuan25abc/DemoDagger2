# Demo Dagger 2
Demo Dagger 2 with:
* AndroidInjector
* @ContributesAndroidInjector annotation

## Code
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


## References

* [Google Dagger 2](https://github.com/google/dagger)


## Authors

* **Tuan Nguyen** - Gmail: *tuan25abc@gmail.com*