# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Commands

Build, lint, and test via the Gradle wrapper from the repo root:

```bash
./gradlew assembleDebug              # build debug APK
./gradlew build                      # full build (compile + lint + unit tests)
./gradlew test                       # run all JVM unit tests (app/src/test)
./gradlew testDebugUnitTest --tests "subrota.shuvro.newsapp.SomeClassTest"  # run a single unit test
./gradlew connectedAndroidTest       # run instrumented tests (app/src/androidTest), needs a device/emulator
./gradlew lint                       # Android lint
```

There are currently no unit or instrumented tests checked in beyond the default templates — `app/src/test` and `app/src/androidTest` are effectively empty scaffolding.

## Architecture

Single-module Android app (`app`) using Jetpack Compose, package root `subrota.shuvro.newsapp`. The code is organized as Clean Architecture layers, even though the app is still early-stage (onboarding flow only, no networking yet):

- `domain/` — interfaces describing capabilities, independent of implementation (e.g. `domain/manager/LocalUserManager`). Domain code should not depend on Android framework types beyond what's unavoidable, and should not depend on `data/`.
- `data/` — concrete implementations of domain interfaces (e.g. `data/manager/LocalUserManagerImpl` backed by Jetpack DataStore Preferences). `data/` implements `domain/` interfaces; nothing constructs `data/` classes from within `domain/`.
- `presentation/` — Compose UI, organized by feature folder (currently `presentation/onboarding/` with a `components/` subfolder for that feature's private composables). Shared composables used across features live in `presentation/common/` (e.g. `NewsButton`). Shared layout constants live in `presentation/Dimensions.kt`.
- `ui/theme/` — Material3 theme setup (`Theme.kt`, `Color.kt`, `Type.kt`); uses the Poppins font family from `res/font/`.
- `util/Constants.kt` — shared constant keys (e.g. DataStore preference names).

There is no dependency-injection framework and no manual DI container wired up yet — `LocalUserManagerImpl` is not currently instantiated/injected anywhere in `presentation/`. When wiring a domain interface to a screen, either construct the impl directly (temporary/manual DI) or introduce a DI solution — check with the user before adding a new framework dependency.

There is no navigation library set up yet; `MainActivity` sets content directly to a single screen (`OnBoardingScreen`) inside `NewsAppTheme`. The "Get Started" button's navigation to a Home screen is a known TODO in `OnBoardingScreen.kt`.

Persistence uses Jetpack DataStore (`androidx.datastore.preferences`), not SharedPreferences directly — see `LocalUserManagerImpl` for the pattern (private `Context.datastore` extension + `preferencesDataStore`, plus a private `PreferencesKey` object mapping to `Constants` string keys).

Dependency versions are centralized in `gradle/libs.versions.toml` (Gradle version catalog) and referenced from `app/build.gradle.kts` via `libs.*` aliases — add new dependencies there rather than hardcoding coordinates in `build.gradle.kts`.