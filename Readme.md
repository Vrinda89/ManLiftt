### News Article

## Project pre requisites
   - Android Studio
   - Android Sdk

## Project Dependencies
    - Rx Java
    - Dagger
    - Retrofit
    - Android Architecture component
    - Picasso
    - Calligraphy
    - Collection binding adapter
    - Lottie

## About

    Kotlin is the chosen language for this project development since Google is officially supporting
    kotlin and soon will be shifted to Dart. Kotlin keeps the class clean with minimal lines of code
    as compared with java.

    This project is developed in MVVM Architecture, followed the repository pattern inspired by the
    Google sunflower project repo.

    Dagger is used for dependency injection so that depended object is ready during the runtime of
    the application.

    Network calls are done using retrofit library in which response is handled by Live data object
    which is of lifecycle aware. Therefore no need to worry if the view context is not available when
    the response is received. Response will be handled one view comes foreground.

    List is shown using collection binding adapter which uses data binding methodology for populating
    the list in recycler view. Ease in handling the list items.

    Datas are populated in UI using databinding method.

    Clear text traffic is enabled for the api url since it is http url. And from Android Oreo OS
    doesn't allow the url request without https.


