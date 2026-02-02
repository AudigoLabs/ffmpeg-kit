plugins {
    `maven-publish`
}

publishing {
    publications {
        create<MavenPublication>("ios") {
            groupId = "com.arthenica"
            artifactId = "ffmpeg-kit-ios"
            version = System.getenv("GIT_TAG") ?: "0.0.0-SNAPSHOT"
            artifact("../ffmpeg-kit-ios-lts.xcframework.zip") {
                extension = "zip"
            }
        }
    }
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/${System.getenv("GITHUB_REPOSITORY") ?: "AudigoLabs/ffmpeg-kit"}")
            credentials {
                username = System.getenv("GITHUB_ACTOR") ?: ""
                password = System.getenv("GITHUB_TOKEN") ?: ""
            }
        }
    }
}
