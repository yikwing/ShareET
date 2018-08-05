/**
 * Demo class
 *
 * @author yikwing
 * @date 2018/6/4
 */

object Version {
    const val kotlin = "1.2.50"
    const val support = "27.1.1"
    const val anko = "0.10.5"
    const val rxkotlin = "2.2.0"
    const val rxjava2 = "2.1.16"
    const val rxandroid = "2.0.2"
    const val rxlifecycle2 = "2.2.1"
    const val okhttp = "3.10.0"
    const val retrofit = "2.4.0"
    const val glide = "4.7.1"
    const val dagger = "2.16"
}

object Deps {
    //support
    val support_v7 = "com.android.support:appcompat-v7:${Version.support}"

    //kotlin
    val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Version.kotlin}"
    val kotlin_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlin}"

    //anko
    val anko_common = "org.jetbrains.anko:anko-commons:${Version.anko}"

    //reactiveX
    val rxkotlin2 = "io.reactivex.rxjava2:rxkotlin:${Version.rxkotlin}"
    val rxandroid2 = "io.reactivex.rxjava2:rxandroid:${Version.rxandroid}"
    val rxjava2 = "io.reactivex.rxjava2:rxjava:${Version.rxjava2}"
    val rxlifecycle2 = "com.trello.rxlifecycle2:rxlifecycle-components:${Version.rxlifecycle2}"
    val rxCache2 = "com.github.VictorAlbertos.RxCache:runtime:1.8.3-2.x"
    val rxCache2_gson = "com.github.VictorAlbertos.Jolyglot:gson:0.0.4"

    // okhttp3
    val okhttp = "com.squareup.okhttp3:okhttp:${Version.okhttp}"
    val okhttp_logging = "com.squareup.okhttp3:logging-interceptor:${Version.okhttp}"

    //retrofit
    val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
    val retrofit_gson = "com.squareup.retrofit2:converter-gson:${Version.retrofit}"
    val retrofit_rxjava2 = "com.squareup.retrofit2:adapter-rxjava2:${Version.retrofit}"

    //glide
    val glide = "com.github.bumptech.glide:glide:${Version.glide}"
    val glide_kapt = "com.github.bumptech.glide:compiler:${Version.glide}"

    //dagger2
    val dagger = "com.google.dagger:dagger:${Version.dagger}"
    val dagger_kapt = "com.google.dagger:dagger-compiler:${Version.dagger}"
}