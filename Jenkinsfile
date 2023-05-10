pipeline {
    agent any
    tools {
        jdk "JAVA_HOME"
        maven "Maven3"
    }

    stages {
        stage('Checkout') {
            steps {
                git credentialsId: 'ce27d19b-c1a0-42f3-a907-f4f58f63c6f0', url: 'https://github.com/Mate-20/main.git'
            }
        }

        stage('Build') {
            steps {
                dir('AdvanceJavaFive/LibraryMangBackend') {
                    bat "\"C:\\.Net & Java Software\\apache-maven-3.6.3-bin\\apache-maven-3.6.3\\bin\\mvn.cmd\" clean package"
                }
            }

            post {
                success {
                    archiveArtifacts '**/target/*.jar'
                }
            }
        }
    }
}
