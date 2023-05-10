pipeline {
    agent any
    environment {
        JAVA_HOME = 'C:\\Users\\akashjindal\\jdk-11.0.2'
        PATH = "${JAVA_HOME}\\bin:${env.PATH}"
    }

    stages {
        stage('checkout') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: 'ce27d19b-c1a0-42f3-a907-f4f58f63c6f0', url: 'https://github.com/Mate-20/main.git']]])
            }
        }
        stage('build') {
            steps {
               bat "\"C:\\Windows\\System32\\cmd.exe\" /C \"C:\\.Net & Java Software\\apache-maven-3.6.3-bin\\apache-maven-3.6.3\\bin\\mvn.cmd\" -f AdvanceJavaFive/LibraryMangBackend/pom.xml clean package"
            }
        }
    }
}
