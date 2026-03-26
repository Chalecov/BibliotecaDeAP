plugins {
    alias(libs.plugins.android.application) apply false
    id("com.google.gms.google-services") version "4.4.1" apply false
    kotlin("android") version "2.0.21" apply false
    kotlin("kapt") version "2.0.21" apply false
}