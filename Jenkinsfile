pipeline {
    agent any

    stages {
        stage('checkout') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: 'ce27d19b-c1a0-42f3-a907-f4f58f63c6f0', url: 'https://github.com/Mate-20/main.git']]])
            }
        }
        stage('build') {
            steps {
                cmd 'C:\\.Net&JavaSoftware\\apache-maven-3.6.3-bin\\apache-maven-3.6.3\\bin\\mvn'
            }
        }
    }
}



