import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	val kotlinVersion = "1.8.22"
	id("idea")
	kotlin("jvm") version kotlinVersion

}

group = "com.payments.nalance"
version = "1.0.0"

java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}


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

