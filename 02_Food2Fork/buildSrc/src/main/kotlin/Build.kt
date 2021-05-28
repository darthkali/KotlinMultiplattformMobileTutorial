object Build {
//    private const val gradleBuildTools = "2.3.0"
    private const val gradleBuildTools = "7.1.0-alpha01"
    const val buildTools = "com.android.tools.build:gradle:${gradleBuildTools}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.version}"
    const val hiltGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:${Hilt.version}"

}