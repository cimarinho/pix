import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	val kotlinVersion = "1.8.22"
	id("idea")
	kotlin("jvm") version kotlinVersion
}

group = "com.payments.payments.integration"
version = "1.0.0"

java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

extra["springCloudVersion"] = "2022.0.1"

sourceSets {
	main {
		kotlin {
			srcDir("src/main/kotlin")
		}
	}
}

dependencies {

}



tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.test {
	useJUnitPlatform()
}

