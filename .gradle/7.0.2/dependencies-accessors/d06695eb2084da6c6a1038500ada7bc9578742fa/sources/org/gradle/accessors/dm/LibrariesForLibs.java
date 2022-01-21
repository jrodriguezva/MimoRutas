package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the `libs` extension.
*/
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final AccompanistLibraryAccessors laccForAccompanistLibraryAccessors = new AccompanistLibraryAccessors(owner);
    private final AndroidLibraryAccessors laccForAndroidLibraryAccessors = new AndroidLibraryAccessors(owner);
    private final AndroidxLibraryAccessors laccForAndroidxLibraryAccessors = new AndroidxLibraryAccessors(owner);
    private final ComposeLibraryAccessors laccForComposeLibraryAccessors = new ComposeLibraryAccessors(owner);
    private final CoroutinesLibraryAccessors laccForCoroutinesLibraryAccessors = new CoroutinesLibraryAccessors(owner);
    private final FirebaseLibraryAccessors laccForFirebaseLibraryAccessors = new FirebaseLibraryAccessors(owner);
    private final GoogleLibraryAccessors laccForGoogleLibraryAccessors = new GoogleLibraryAccessors(owner);
    private final GradlePluginLibraryAccessors laccForGradlePluginLibraryAccessors = new GradlePluginLibraryAccessors(owner);
    private final KoinLibraryAccessors laccForKoinLibraryAccessors = new KoinLibraryAccessors(owner);
    private final KotlinxLibraryAccessors laccForKotlinxLibraryAccessors = new KotlinxLibraryAccessors(owner);
    private final KtorLibraryAccessors laccForKtorLibraryAccessors = new KtorLibraryAccessors(owner);
    private final MultiplatformSettingsLibraryAccessors laccForMultiplatformSettingsLibraryAccessors = new MultiplatformSettingsLibraryAccessors(owner);
    private final SqlDelightLibraryAccessors laccForSqlDelightLibraryAccessors = new SqlDelightLibraryAccessors(owner);
    private final TouchlabLibraryAccessors laccForTouchlabLibraryAccessors = new TouchlabLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers) {
        super(config, providers);
    }

        /**
         * Creates a dependency provider for junit (junit:junit)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJunit() { return create("junit"); }

        /**
         * Creates a dependency provider for roboelectric (org.robolectric:robolectric)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getRoboelectric() { return create("roboelectric"); }

        /**
         * Creates a dependency provider for turbine (app.cash.turbine:turbine)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getTurbine() { return create("turbine"); }

    /**
     * Returns the group of libraries at accompanist
     */
    public AccompanistLibraryAccessors getAccompanist() { return laccForAccompanistLibraryAccessors; }

    /**
     * Returns the group of libraries at android
     */
    public AndroidLibraryAccessors getAndroid() { return laccForAndroidLibraryAccessors; }

    /**
     * Returns the group of libraries at androidx
     */
    public AndroidxLibraryAccessors getAndroidx() { return laccForAndroidxLibraryAccessors; }

    /**
     * Returns the group of libraries at compose
     */
    public ComposeLibraryAccessors getCompose() { return laccForComposeLibraryAccessors; }

    /**
     * Returns the group of libraries at coroutines
     */
    public CoroutinesLibraryAccessors getCoroutines() { return laccForCoroutinesLibraryAccessors; }

    /**
     * Returns the group of libraries at firebase
     */
    public FirebaseLibraryAccessors getFirebase() { return laccForFirebaseLibraryAccessors; }

    /**
     * Returns the group of libraries at google
     */
    public GoogleLibraryAccessors getGoogle() { return laccForGoogleLibraryAccessors; }

    /**
     * Returns the group of libraries at gradlePlugin
     */
    public GradlePluginLibraryAccessors getGradlePlugin() { return laccForGradlePluginLibraryAccessors; }

    /**
     * Returns the group of libraries at koin
     */
    public KoinLibraryAccessors getKoin() { return laccForKoinLibraryAccessors; }

    /**
     * Returns the group of libraries at kotlinx
     */
    public KotlinxLibraryAccessors getKotlinx() { return laccForKotlinxLibraryAccessors; }

    /**
     * Returns the group of libraries at ktor
     */
    public KtorLibraryAccessors getKtor() { return laccForKtorLibraryAccessors; }

    /**
     * Returns the group of libraries at multiplatformSettings
     */
    public MultiplatformSettingsLibraryAccessors getMultiplatformSettings() { return laccForMultiplatformSettingsLibraryAccessors; }

    /**
     * Returns the group of libraries at sqlDelight
     */
    public SqlDelightLibraryAccessors getSqlDelight() { return laccForSqlDelightLibraryAccessors; }

    /**
     * Returns the group of libraries at touchlab
     */
    public TouchlabLibraryAccessors getTouchlab() { return laccForTouchlabLibraryAccessors; }

    /**
     * Returns the group of versions at versions
     */
    public VersionAccessors getVersions() { return vaccForVersionAccessors; }

    /**
     * Returns the group of bundles at bundles
     */
    public BundleAccessors getBundles() { return baccForBundleAccessors; }

    public static class AccompanistLibraryAccessors extends SubDependencyFactory {
        private final AccompanistAppcompatLibraryAccessors laccForAccompanistAppcompatLibraryAccessors = new AccompanistAppcompatLibraryAccessors(owner);

        public AccompanistLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for insets (com.google.accompanist:accompanist-insets)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getInsets() { return create("accompanist-insets"); }

            /**
             * Creates a dependency provider for systemuicontroller (com.google.accompanist:accompanist-systemuicontroller)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getSystemuicontroller() { return create("accompanist-systemuicontroller"); }

        /**
         * Returns the group of libraries at accompanist.appcompat
         */
        public AccompanistAppcompatLibraryAccessors getAppcompat() { return laccForAccompanistAppcompatLibraryAccessors; }

    }

    public static class AccompanistAppcompatLibraryAccessors extends SubDependencyFactory {

        public AccompanistAppcompatLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for theme (com.google.accompanist:accompanist-appcompat-theme)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getTheme() { return create("accompanist-appcompat-theme"); }

    }

    public static class AndroidLibraryAccessors extends SubDependencyFactory {

        public AndroidLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for desugaring (com.android.tools:desugar_jdk_libs)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getDesugaring() { return create("android-desugaring"); }

    }

    public static class AndroidxLibraryAccessors extends SubDependencyFactory {
        private final AndroidxLifecycleLibraryAccessors laccForAndroidxLifecycleLibraryAccessors = new AndroidxLifecycleLibraryAccessors(owner);
        private final AndroidxTestLibraryAccessors laccForAndroidxTestLibraryAccessors = new AndroidxTestLibraryAccessors(owner);

        public AndroidxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (androidx.core:core-ktx)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() { return create("androidx-core"); }

        /**
         * Returns the group of libraries at androidx.lifecycle
         */
        public AndroidxLifecycleLibraryAccessors getLifecycle() { return laccForAndroidxLifecycleLibraryAccessors; }

        /**
         * Returns the group of libraries at androidx.test
         */
        public AndroidxTestLibraryAccessors getTest() { return laccForAndroidxTestLibraryAccessors; }

    }

    public static class AndroidxLifecycleLibraryAccessors extends SubDependencyFactory {

        public AndroidxLifecycleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for runtime (androidx.lifecycle:lifecycle-runtime-ktx)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getRuntime() { return create("androidx-lifecycle-runtime"); }

            /**
             * Creates a dependency provider for viewmodel (androidx.lifecycle:lifecycle-viewmodel-ktx)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getViewmodel() { return create("androidx-lifecycle-viewmodel"); }

    }

    public static class AndroidxTestLibraryAccessors extends SubDependencyFactory {

        public AndroidxTestLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for junit (androidx.test.ext:junit)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getJunit() { return create("androidx-test-junit"); }

    }

    public static class ComposeLibraryAccessors extends SubDependencyFactory {

        public ComposeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for activity (androidx.activity:activity-compose)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getActivity() { return create("compose-activity"); }

            /**
             * Creates a dependency provider for foundation (androidx.compose.foundation:foundation)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getFoundation() { return create("compose-foundation"); }

            /**
             * Creates a dependency provider for material (androidx.compose.material:material)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getMaterial() { return create("compose-material"); }

            /**
             * Creates a dependency provider for material3 (androidx.compose.material3:material3)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getMaterial3() { return create("compose-material3"); }

            /**
             * Creates a dependency provider for navigation (androidx.navigation:navigation-compose)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getNavigation() { return create("compose-navigation"); }

            /**
             * Creates a dependency provider for tooling (androidx.compose.ui:ui-tooling)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getTooling() { return create("compose-tooling"); }

            /**
             * Creates a dependency provider for ui (androidx.compose.ui:ui)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getUi() { return create("compose-ui"); }

    }

    public static class CoroutinesLibraryAccessors extends SubDependencyFactory {

        public CoroutinesLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (org.jetbrains.kotlinx:kotlinx-coroutines-core)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() { return create("coroutines-core"); }

            /**
             * Creates a dependency provider for test (org.jetbrains.kotlinx:kotlinx-coroutines-test)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getTest() { return create("coroutines-test"); }

    }

    public static class FirebaseLibraryAccessors extends SubDependencyFactory {

        public FirebaseLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for auth (dev.gitlive:firebase-auth)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getAuth() { return create("firebase-auth"); }

    }

    public static class GoogleLibraryAccessors extends SubDependencyFactory {

        public GoogleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for maps (com.google.android.gms:play-services-maps)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getMaps() { return create("google-maps"); }

            /**
             * Creates a dependency provider for mapsKtx (com.google.maps.android:maps-ktx)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getMapsKtx() { return create("google-mapsKtx"); }

            /**
             * Creates a dependency provider for services (com.google.gms:google-services)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getServices() { return create("google-services"); }

    }

    public static class GradlePluginLibraryAccessors extends SubDependencyFactory {

        public GradlePluginLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for android (com.android.tools.build:gradle)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getAndroid() { return create("gradlePlugin-android"); }

            /**
             * Creates a dependency provider for kotlinSerialization (org.jetbrains.kotlin:kotlin-serialization)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getKotlinSerialization() { return create("gradlePlugin-kotlinSerialization"); }

            /**
             * Creates a dependency provider for ktlint (org.jlleitschuh.gradle:ktlint-gradle)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getKtlint() { return create("gradlePlugin-ktlint"); }

            /**
             * Creates a dependency provider for secrets (com.google.android.libraries.mapsplatform.secrets-gradle-plugin:secrets-gradle-plugin)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getSecrets() { return create("gradlePlugin-secrets"); }

            /**
             * Creates a dependency provider for sqlDelight (com.squareup.sqldelight:gradle-plugin)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getSqlDelight() { return create("gradlePlugin-sqlDelight"); }

    }

    public static class KoinLibraryAccessors extends SubDependencyFactory {

        public KoinLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for android (io.insert-koin:koin-android)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getAndroid() { return create("koin-android"); }

            /**
             * Creates a dependency provider for core (io.insert-koin:koin-core)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() { return create("koin-core"); }

            /**
             * Creates a dependency provider for test (io.insert-koin:koin-test)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getTest() { return create("koin-test"); }

    }

    public static class KotlinxLibraryAccessors extends SubDependencyFactory {

        public KotlinxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for dateTime (org.jetbrains.kotlinx:kotlinx-datetime)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getDateTime() { return create("kotlinx-dateTime"); }

    }

    public static class KtorLibraryAccessors extends SubDependencyFactory {
        private final KtorClientLibraryAccessors laccForKtorClientLibraryAccessors = new KtorClientLibraryAccessors(owner);

        public KtorLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at ktor.client
         */
        public KtorClientLibraryAccessors getClient() { return laccForKtorClientLibraryAccessors; }

    }

    public static class KtorClientLibraryAccessors extends SubDependencyFactory {

        public KtorClientLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (io.ktor:ktor-client-core)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() { return create("ktor-client-core"); }

            /**
             * Creates a dependency provider for ios (io.ktor:ktor-client-ios)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getIos() { return create("ktor-client-ios"); }

            /**
             * Creates a dependency provider for logging (io.ktor:ktor-client-logging)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getLogging() { return create("ktor-client-logging"); }

            /**
             * Creates a dependency provider for okHttp (io.ktor:ktor-client-okhttp)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getOkHttp() { return create("ktor-client-okHttp"); }

            /**
             * Creates a dependency provider for serialization (io.ktor:ktor-client-serialization)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getSerialization() { return create("ktor-client-serialization"); }

    }

    public static class MultiplatformSettingsLibraryAccessors extends SubDependencyFactory {

        public MultiplatformSettingsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for common (com.russhwolf:multiplatform-settings)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCommon() { return create("multiplatformSettings-common"); }

            /**
             * Creates a dependency provider for test (com.russhwolf:multiplatform-settings-test)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getTest() { return create("multiplatformSettings-test"); }

    }

    public static class SqlDelightLibraryAccessors extends SubDependencyFactory {

        public SqlDelightLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for android (com.squareup.sqldelight:android-driver)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getAndroid() { return create("sqlDelight-android"); }

            /**
             * Creates a dependency provider for coroutinesExt (com.squareup.sqldelight:coroutines-extensions)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getCoroutinesExt() { return create("sqlDelight-coroutinesExt"); }

            /**
             * Creates a dependency provider for native (com.squareup.sqldelight:native-driver)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getNative() { return create("sqlDelight-native"); }

            /**
             * Creates a dependency provider for runtime (com.squareup.sqldelight:runtime)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getRuntime() { return create("sqlDelight-runtime"); }

    }

    public static class TouchlabLibraryAccessors extends SubDependencyFactory {

        public TouchlabLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for kermit (co.touchlab:kermit)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getKermit() { return create("touchlab-kermit"); }

            /**
             * Creates a dependency provider for stately (co.touchlab:stately-common)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getStately() { return create("touchlab-stately"); }

    }

    public static class VersionAccessors extends VersionFactory {

        private final CoroutinesVersionAccessors vaccForCoroutinesVersionAccessors = new CoroutinesVersionAccessors(providers, config);
        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: accompanist (0.22.0-rc)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getAccompanist() { return getVersion("accompanist"); }

            /**
             * Returns the version associated to this alias: compileSdk (31)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getCompileSdk() { return getVersion("compileSdk"); }

            /**
             * Returns the version associated to this alias: compose (1.0.5)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getCompose() { return getVersion("compose"); }

            /**
             * Returns the version associated to this alias: firebase (1.4.3)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getFirebase() { return getVersion("firebase"); }

            /**
             * Returns the version associated to this alias: koin (3.1.4)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKoin() { return getVersion("koin"); }

            /**
             * Returns the version associated to this alias: kotlin (1.5.31)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKotlin() { return getVersion("kotlin"); }

            /**
             * Returns the version associated to this alias: ktor (1.6.5)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKtor() { return getVersion("ktor"); }

            /**
             * Returns the version associated to this alias: lifecycle (2.4.0-rc01)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getLifecycle() { return getVersion("lifecycle"); }

            /**
             * Returns the version associated to this alias: maps (18.0.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getMaps() { return getVersion("maps"); }

            /**
             * Returns the version associated to this alias: minSdk (24)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getMinSdk() { return getVersion("minSdk"); }

            /**
             * Returns the version associated to this alias: multiplatformSettings (0.8.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getMultiplatformSettings() { return getVersion("multiplatformSettings"); }

            /**
             * Returns the version associated to this alias: sqlDelight (1.5.3)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getSqlDelight() { return getVersion("sqlDelight"); }

            /**
             * Returns the version associated to this alias: targetSdk (31)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getTargetSdk() { return getVersion("targetSdk"); }

        /**
         * Returns the group of versions at versions.coroutines
         */
        public CoroutinesVersionAccessors getCoroutines() { return vaccForCoroutinesVersionAccessors; }

    }

    public static class CoroutinesVersionAccessors extends VersionFactory {

        public CoroutinesVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: coroutines-native (1.5.2-native-mt)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getNative() { return getVersion("coroutines-native"); }

    }

    public static class BundleAccessors extends BundleFactory {
        private final AppBundleAccessors baccForAppBundleAccessors = new AppBundleAccessors(providers, config);
        private final KtorBundleAccessors baccForKtorBundleAccessors = new KtorBundleAccessors(providers, config);
        private final SharedBundleAccessors baccForSharedBundleAccessors = new SharedBundleAccessors(providers, config);

        public BundleAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a dependency bundle provider for accompanist which is an aggregate for the following dependencies:
             * <ul>
             *    <li>com.google.accompanist:accompanist-appcompat-theme</li>
             *    <li>com.google.accompanist:accompanist-systemuicontroller</li>
             *    <li>com.google.accompanist:accompanist-insets</li>
             * </ul>
             * This bundle was declared in catalog libs.versions.toml
             */
            public Provider<ExternalModuleDependencyBundle> getAccompanist() { return createBundle("accompanist"); }

            /**
             * Creates a dependency bundle provider for firebase which is an aggregate for the following dependencies:
             * <ul>
             *    <li>dev.gitlive:firebase-auth</li>
             * </ul>
             * This bundle was declared in catalog libs.versions.toml
             */
            public Provider<ExternalModuleDependencyBundle> getFirebase() { return createBundle("firebase"); }

            /**
             * Creates a dependency bundle provider for gradlePlugins which is an aggregate for the following dependencies:
             * <ul>
             *    <li>com.android.tools.build:gradle</li>
             *    <li>org.jetbrains.kotlin:kotlin-serialization</li>
             *    <li>org.jlleitschuh.gradle:ktlint-gradle</li>
             *    <li>com.squareup.sqldelight:gradle-plugin</li>
             *    <li>com.google.gms:google-services</li>
             *    <li>com.google.android.libraries.mapsplatform.secrets-gradle-plugin:secrets-gradle-plugin</li>
             * </ul>
             * This bundle was declared in catalog libs.versions.toml
             */
            public Provider<ExternalModuleDependencyBundle> getGradlePlugins() { return createBundle("gradlePlugins"); }

            /**
             * Creates a dependency bundle provider for maps which is an aggregate for the following dependencies:
             * <ul>
             *    <li>com.google.android.gms:play-services-maps</li>
             *    <li>com.google.maps.android:maps-ktx</li>
             * </ul>
             * This bundle was declared in catalog libs.versions.toml
             */
            public Provider<ExternalModuleDependencyBundle> getMaps() { return createBundle("maps"); }

        /**
         * Returns the group of bundles at bundles.app
         */
        public AppBundleAccessors getApp() { return baccForAppBundleAccessors; }

        /**
         * Returns the group of bundles at bundles.ktor
         */
        public KtorBundleAccessors getKtor() { return baccForKtorBundleAccessors; }

        /**
         * Returns the group of bundles at bundles.shared
         */
        public SharedBundleAccessors getShared() { return baccForSharedBundleAccessors; }

    }

    public static class AppBundleAccessors extends BundleFactory {

        public AppBundleAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a dependency bundle provider for app-ui which is an aggregate for the following dependencies:
             * <ul>
             *    <li>androidx.core:core-ktx</li>
             *    <li>androidx.lifecycle:lifecycle-runtime-ktx</li>
             *    <li>androidx.lifecycle:lifecycle-viewmodel-ktx</li>
             *    <li>androidx.compose.ui:ui</li>
             *    <li>androidx.compose.ui:ui-tooling</li>
             *    <li>androidx.compose.foundation:foundation</li>
             *    <li>androidx.compose.material:material</li>
             *    <li>androidx.compose.material3:material3</li>
             *    <li>androidx.navigation:navigation-compose</li>
             *    <li>androidx.activity:activity-compose</li>
             * </ul>
             * This bundle was declared in catalog libs.versions.toml
             */
            public Provider<ExternalModuleDependencyBundle> getUi() { return createBundle("app-ui"); }

    }

    public static class KtorBundleAccessors extends BundleFactory {

        public KtorBundleAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a dependency bundle provider for ktor-common which is an aggregate for the following dependencies:
             * <ul>
             *    <li>io.ktor:ktor-client-core</li>
             *    <li>io.ktor:ktor-client-logging</li>
             *    <li>io.ktor:ktor-client-serialization</li>
             * </ul>
             * This bundle was declared in catalog libs.versions.toml
             */
            public Provider<ExternalModuleDependencyBundle> getCommon() { return createBundle("ktor-common"); }

    }

    public static class SharedBundleAccessors extends BundleFactory {

        public SharedBundleAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a dependency bundle provider for shared-androidTest which is an aggregate for the following dependencies:
             * <ul>
             *    <li>androidx.test.ext:junit</li>
             *    <li>org.jetbrains.kotlinx:kotlinx-coroutines-test</li>
             *    <li>org.robolectric:robolectric</li>
             * </ul>
             * This bundle was declared in catalog libs.versions.toml
             */
            public Provider<ExternalModuleDependencyBundle> getAndroidTest() { return createBundle("shared-androidTest"); }

            /**
             * Creates a dependency bundle provider for shared-commonTest which is an aggregate for the following dependencies:
             * <ul>
             *    <li>com.russhwolf:multiplatform-settings-test</li>
             *    <li>io.insert-koin:koin-test</li>
             *    <li>app.cash.turbine:turbine</li>
             * </ul>
             * This bundle was declared in catalog libs.versions.toml
             */
            public Provider<ExternalModuleDependencyBundle> getCommonTest() { return createBundle("shared-commonTest"); }

    }

}
