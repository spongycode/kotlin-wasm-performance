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