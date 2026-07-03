# Cynbom - Application Android Native

App Android native en **Kotlin** pour Cynbom - Plateforme de streaming indépendante.

## 📋 Table des matières

- Structure du projet
- Configuration
- Features
- Icons incluées
- Installation
- Architecture
- Network Management
- API
- Fichiers-clés
- Troubleshooting

## 🏗️ Structure du projet

```
cynbom-app/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── kotlin/net/mmt_entertaiment/cynbom/
│   │   │   │   ├── MainActivity.kt
│   │   │   │   ├── VideoActivity.kt
│   │   │   │   ├── OfflineActivity.kt
│   │   │   │   ├── ui/
│   │   │   │   │   ├── accueil/AccueilFragment.kt
│   │   │   │   │   ├── recherche/
│   │   │   │   │   │   ├── RechercheFragment.kt
│   │   │   │   │   │   └── SerieAdapter.kt
│   │   │   │   │   ├── parametres/ParametresFragment.kt
│   │   │   │   │   └── viewmodel/SerieViewModel.kt
│   │   │   │   ├── data/
│   │   │   │   │   ├── api/
│   │   │   │   │   │   ├── CynbomApi.kt
│   │   │   │   │   │   └── RetrofitClient.kt
│   │   │   │   │   ├── model/Serie.kt
│   │   │   │   │   └── repository/SerieRepository.kt
│   │   │   │   └── network/
│   │   │   │       ├── NetworkChangeReceiver.kt
│   │   │   │       ├── NetworkInterceptor.kt
│   │   │   │       └── ConnectivityManager.kt
│   │   │   ├── res/
│   │   │   │   ├── layout/
│   │   │   │   │   ├── activity_main.xml
│   │   │   │   │   ├── activity_video.xml
│   │   │   │   │   ├── activity_offline.xml
│   │   │   │   │   ├── fragment_accueil.xml
│   │   │   │   │   ├── fragment_recherche.xml
│   │   │   │   │   ├── fragment_parametres.xml
│   │   │   │   │   └── item_serie.xml
│   │   │   │   ├── menu/bottom_nav_menu.xml
│   │   │   │   ├── navigation/nav_graph.xml
│   │   │   │   ├── values/
│   │   │   │   │   ├── colors.xml
│   │   │   │   │   ├── strings.xml
│   │   │   │   │   └── themes.xml
│   │   │   │   └── drawable/
│   │   │   │       ├── ic_home.xml
│   │   │   │       ├── home_48px_fill.xml
│   │   │   │       ├── search_48px.xml
│   │   │   │       ├── settings_48px.xml
│   │   │   │       ├── settings_48px_fill.xml
│   │   │   │       ├── ic_wifi_off.xml
│   │   │   │       └── gradient_bottom.xml
│   │   │   └── AndroidManifest.xml
│   ├── build.gradle.kts
│   └── proguard-rules.pro
└── build.gradle.kts
```

## ⚙️ Configuration

**MinSDK:** API 28 (Android 9)  
**TargetSDK:** API 35 (Android 15+)  
**Language:** Kotlin  
**Package Name:** net.mmt_entertaiment.cynbom  
**Taille:** ~63KB (ZIP)

## ✨ Features

- ✅ Accueil avec vedette + sections
- ✅ Recherche de séries
- ✅ Paramètres avec lien vers ToS
- ✅ Lecteur vidéo ExoPlayer
- ✅ Récupération données via API REST
- ✅ Material Design 3
- ✅ Icons Material Design prêtes
- ✅ Détection connexion réseau en temps réel
- ✅ Page offline dédiée avec icône WiFi off
- ✅ Navigation fluide entre fragments
- ✅ Gestion d'erreurs robuste

## 🎨 Icons incluées

- **ic_home.xml** - Icône Accueil (Material Design)
- **home_48px_fill.xml** - Icône Accueil Fill (variant)
- **search_48px.xml** - Icône Recherche (Material Design)
- **settings_48px.xml** - Icône Paramètres (Material Design)
- **settings_48px_fill.xml** - Icône Paramètres Fill (variant)
- **ic_wifi_off.xml** - Icône WiFi Off (android_wifi_3_bar_off - Google Material)
- **Icon.jpg** - Logo Cynbom (pour launcher icon)

## 📦 Dépendances principales

- **Kotlin** - Langage de programmation
- **Androidx** - Libs Android modernes
- **Material Design 3** - UI components
- **Retrofit** - API HTTP client
- **Glide** - Image loading
- **Media3/ExoPlayer** - Lecteur vidéo
- **Navigation Component** - Navigation entre fragments
- **OkHttp** - HTTP client avec interceptors

## 🚀 Installation

### Prérequis

- Android Studio (dernière version)
- JDK 17+
- Android SDK 28-35+
- Git (optionnel)

### Étapes

1. **Créer le projet**
   ```bash
   # Ouvre Android Studio
   # New Project → Empty Activity
   # Package: net.mmt_entertaiment.cynbom
   # Min SDK: API 28
   ```

2. **Extraire le ZIP**
   ```bash
   unzip cynbom-android.zip
   ```

3. **Copier les fichiers Kotlin**
   
   Copie tous les fichiers `.kt` dans :
   ```
   app/src/main/kotlin/net/mmt_entertaiment/cynbom/
   ```

   Créé les dossiers :
   - `ui/accueil/`
   - `ui/recherche/`
   - `ui/parametres/`
   - `ui/viewmodel/`
   - `data/api/`
   - `data/model/`
   - `data/repository/`
   - `network/`

4. **Copier les fichiers XML**

   **Layouts :**
   ```
   app/src/main/res/layout/
   ```

   **Menu & Navigation :**
   ```
   app/src/main/res/menu/
   app/src/main/res/navigation/
   ```

   **Values :**
   ```
   app/src/main/res/values/
   ```

   **Drawable (Icons) :**
   ```
   app/src/main/res/drawable/
   ```

5. **Mettre à jour les fichiers config**

   **AndroidManifest.xml :**
   Remplace par le contenu de `AndroidManifest_updated.xml`

   **build.gradle.kts (app level) :**
   Remplace par le fichier fourni

6. **Sync Gradle**
   ```
   File → Sync Now
   ```

7. **Build & Run**
   ```bash
   ./gradlew build
   ./gradlew installDebug
   ```

   Ou depuis Android Studio : Run → Run 'app'

## 🏛️ Architecture

```
Clean Architecture + MVVM
├── UI Layer (Fragments + Activities)
│   ├── MainActivity (Navigation)
│   ├── VideoActivity (Lecteur vidéo)
│   ├── OfflineActivity (Mode hors ligne)
│   └── Fragments (Accueil, Recherche, Paramètres)
├── ViewModel Layer (SerieViewModel)
├── Repository Layer (SerieRepository)
├── Data Layer (API + Models)
│   ├── CynbomApi (Interface Retrofit)
│   ├── RetrofitClient (HTTP client)
│   └── Serie (Data models)
├── Network Layer (Connectivity)
│   ├── NetworkChangeReceiver (Écoute changements)
│   ├── NetworkInterceptor (Capture erreurs)
│   └── ConnectivityManager (Vérification connexion)
└── Domain Layer (Business Logic)
```

## 🌐 Network Management

### Détection de connexion

L'app détecte les changements de connexion réseau en temps réel :

- **NetworkChangeReceiver** : Écoute les changements de connexion via BroadcastReceiver
- **ConnectivityManager** : Vérifie l'état de la connexion (WiFi, 4G, 5G, Ethernet)
- **NetworkInterceptor** : Capture les erreurs réseau au niveau HTTP

### Affichage OfflineActivity

Lorsque la connexion est perdue :
1. `NetworkChangeReceiver` détecte le changement
2. `ConnectivityManager` confirme l'absence de connexion
3. L'app affiche `OfflineActivity` automatiquement
4. Utilisateur voit : icône WiFi off + message + bouton "Réessayer"
5. Quand connexion revient, app revient à l'écran précédent

### Permissions requises

```xml
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
<uses-permission android:name="android.permission.CHANGE_NETWORK_STATE" />
```

## 📡 API

**Base URL:** `https://cynbom-backend-production.up.railway.app`

**Endpoints :**

- `GET /series` - Liste des séries
- `GET /series/{titre}/episodes` - Épisodes d'une série

## 📝 Fichiers clés

### Activities
- **MainActivity.kt** - Écran principal avec navigation
- **VideoActivity.kt** - Lecteur vidéo ExoPlayer
- **OfflineActivity.kt** - Page sans connexion

### Fragments
- **AccueilFragment.kt** - Accueil avec vedette
- **RechercheFragment.kt** - Recherche de séries
- **ParametresFragment.kt** - Paramètres utilisateur

### Network
- **NetworkChangeReceiver.kt** - Détecte changements réseau
- **NetworkInterceptor.kt** - Intercepte requêtes HTTP
- **ConnectivityManager.kt** - Vérifie état connexion

### API & Data
- **CynbomApi.kt** - Interface API Retrofit
- **RetrofitClient.kt** - Configuration client HTTP
- **SerieRepository.kt** - Accès aux données
- **Serie.kt** - Modèles de données

### ViewModel
- **SerieViewModel.kt** - Logique métier des séries

## 🔧 Troubleshooting

**"Package name doesn't match"**
→ Change le package name dans `build.gradle.kts` et `AndroidManifest.xml`

**"Gradle sync failed"**
→ Vérifie que les dépendances dans `build.gradle.kts` sont correctes
→ Utilise JDK 17+

**"Icons not showing"**
→ Vérifie que les fichiers `.xml` sont dans `res/drawable/`
→ Vérifie les noms des fichiers (sensible à la casse)

**"Offline page not displayed"**
→ Vérifie que `OfflineActivity.kt` est enregistrée dans `AndroidManifest.xml`
→ Teste avec WiFi désactivé

**"API calls not working"**
→ Vérifie que tu as les permissions INTERNET dans AndroidManifest.xml
→ Vérifie que le backend est accessible : `https://cynbom-backend-production.up.railway.app`
→ Teste avec logcat pour voir les erreurs réseau

**"Fragment not loading"**
→ Vérifie que le fragment est enregistré dans `nav_graph.xml`
→ Vérifie que les layouts XML existent

## 📝 À faire

- [ ] Tester API calls sur device/emulator
- [ ] Ajouter caching local (SharedPreferences/Room)
- [ ] Intégrer lecteur vidéo ExoPlayer complet
- [ ] Polish UI/UX
- [ ] Tester sur multiples versions Android (28-35)
- [ ] Performance optimization
- [ ] Release APK signing
- [ ] Tests unitaires et intégration
- [ ] Analytics

## 🤝 Contribuer

Les PRs sont bienvenues ! 🚀

### Open Source & Contributions

Cynbom est **100% Open Source**. Les mises à jour créées par les utilisateurs peuvent être acceptées comme mises à jour officielles de l'app.

**Comment contribuer :**
1. Fork le repo
2. Crée une branche (`git checkout -b feature/ma-feature`)
3. Commit tes changements (`git commit -m 'Ajoute ma feature'`)
4. Push (`git push origin feature/ma-feature`)
5. Ouvre une Pull Request

### Crédits des contributeurs

Tout contributeur dont la PR est acceptée sera crédité dans le README et les release notes :

**Options de crédit (au choix du contributeur) :**

- **Pseudo GitHub** (par défaut, automatique)
  - Utilise ton pseudo GitHub officiel
  
- **Pseudo personnalisé** (sur demande)
  - Choisis ton propre pseudo/pseudo-onyme
  
- **Prénom + Initiale du nom** (sur demande, à partir de 15 ans)
  - Format : "John D." 
  - Valide à partir de la majorité numérique en France Métropolitaine et d'Outre-mer (15 ans)
  
- **Nom complet** (sur demande, majorité législative du pays)
  - Format : "John Doe"
  - Valide à partir de la majorité législative locale du pays de résidence

### Processus de crédit

1. Mentionne dans ta PR quelle option de crédit tu préfères
2. Si majorité numérique/législative requise, confirme ton âge
3. Après fusion, tu seras crédité dans :
   - Le README (section "Contributors")
   - Les release notes de la version
   - Les commits git

## 📄 Licence

© 2024-2026 MMT Entertaiment - Studio créatif indépendant

---

## 👥 Crédits

**Technologies :**
- Frontend : HTML5, CSS3, JavaScript, Google Sans, Material Design
- Backend : Node.js, Express, better-sqlite3, Discord.js Bot
- App Android : Kotlin, Jetpack, Retrofit, Material Design 3, ExoPlayer
- Icons : Material Design Icons (Google Fonts)

**Contributeurs :**
Les contributeurs qui améliorent Cynbom via des Pull Requests ou les Issue seront crédités selon leur choix (pseudo GitHub, pseudo personnalisé, prénom+initiale, ou nom complet). Voir la page [Crédits](https://mmt-entertaiment.github.io/Cynbom/credit.html) pour plus de détails.

---

## 📌 Notes importantes

- Tous les icons sont en Material Design XML (vector drawables)
- Compatible Android 9 (API 28) à Android 15+ (API 35+)
- App non publiée sur Play Store (distribution directe APK)
- Network detection en temps réel avec page offline
- Offline mode avec page dédiée (OfflineActivity)
- Architecture modulaire et extensible
- Package Name: `net.mmt_entertaiment.cynbom`
