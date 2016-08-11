# RxAKtivityResult [![](https://jitpack.io/v/kikuchy/RxAKtivityResult.svg)](https://jitpack.io/#kikuchy/RxAKtivityResult) [![Build Status](https://travis-ci.org/kikuchy/RxAKtivityResult.svg?branch=master)](https://travis-ci.org/kikuchy/RxAKtivityResult)

## Usage

```kotlin
class MainActivity : AppCompatActivity(), RxAKtivityResult by RxAKtivityResultDelegate() {
    override fun onCreate(savedInstanceState: Bundle?) {
        activityResultObservable.
            subscribe {
                val (requestCode, resutlCode, data) = it
                doSomething(data);
            }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super<AppCompatActivity>.onActivityResult(requestCode, resultCode, data)
        super<RxAKtivityResult>.onActivityResult(requestCode, resultCode, data)
    }
}
```

## Install

Install from Jitpack.io

```groovy
// at project root build.gradle
    allprojects {
        repositories {
            ...
            maven { url "https://jitpack.io" }
        }
    }

// at each module's build.gradle
    dependencies {
        compile 'com.github.kikuchy:RxAKtivityResult:x.y.z'
    }
```
