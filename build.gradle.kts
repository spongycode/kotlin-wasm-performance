import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpack

plugins {
	kotlin("multiplatform") version "2.0.0"
}

repositories {
	mavenCentral()
}

kotlin {
	@OptIn(org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl::class)
	wasmJs {
		browser {
			commonWebpackConfig {
				outputFileName = "kotlin-wasm-demo.js"
			}
		}
		binaries.executable()
	}
}

tasks.named<KotlinWebpack>("wasmJsBrowserProductionWebpack") {
	outputDirectory = projectDir.resolve("public")
}

tasks.register<Copy>("copyWasmAndHtml") {
	from(fileTree("${buildDir}/compileSync/wasmJs/main/productionExecutable/optimized") {
		include("*.wasm")
	})
	from("src/wasmJsMain/resources/index.html")
	into("public")
}

tasks.named("wasmJsBrowserProductionWebpack") {
	finalizedBy("copyWasmAndHtml")
}