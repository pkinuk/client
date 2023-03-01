pipeline {
    agent any
	environment {
		DOCKERHUB_CREDENTIALS=credentials('DockerHubPkinuk')
	}

    tools {
        jdk 'Java17'
        maven 'maven-3.9.0'
    }

    stages {
        stage('Check version') {
            steps {
                sh 'mvn -version'
            }
        }
        stage('Checkout') {
            steps {
                git url: 'https://github.com/pkinuk/client.git'
            }
        }


        stage('Build') {
            steps {

                // Run the build and capture the exit code
                script {
                    def buildExitCode = sh(script: './mvnw clean install -Dquarkus.container-image.group=pkinuk', returnStatus: true)
                    if (buildExitCode != 0) {
                        error('Build failed!')
                    }
                }
            }
        }

        stage('Push docker hub') {
              steps {
                script {
                    sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
                    sh 'docker images'
                    sh 'docker push pkinuk/client:1.0.0-SNAPSHOT'
                }
              }
        }

    }

    post {
        always {
            sh 'docker logout'
        }
    }
}