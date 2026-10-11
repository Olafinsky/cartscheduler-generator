# Generator

Biblioteka Java do generowania arkuszy z kandydatami. Wymaga Java 21 lub nowszej.

## Budowanie

```shell
./gradlew build
```

Na Windowsie użyj `gradlew.bat build`. Gotowy plik JAR znajduje się w `build/libs`.

## Użycie w innym projekcie Gradle

Najpierw opublikuj bibliotekę w lokalnym repozytorium Maven:

```shell
./gradlew publishToMavenLocal
```

Dodaj `mavenLocal()` oraz zależność do `build.gradle` projektu-klienta:

```groovy
repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation 'org.generator:generator:1.0.0'
}
```

Główne API znajduje się w pakiecie `org.generator`. Gotowe filtry są w pakietach
`org.generator.acceptancefilter`, `org.generator.scorefilter` i
`org.generator.postgenerationfilter`.
