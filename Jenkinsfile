pipeline {
    agent any

    tools {
        maven '3.9.9' // Ensure you have configured Maven in Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout code from your Git repository
                git branch: 'main', url: 'https://github.com/pratikshaghotkar15/TestFramework'
            }
        }

        stage('Install Dependencies') {
            steps {
                // Run Maven to download dependencies
                bat 'mvn clean install'
            }
        }

        stage('Run Tests') {
            steps {
                // Run the Cucumber tests
                bat 'mvn test'
            }
        }

        stage('Publish Test Results') {
            steps {
                // Publish JUnit test results
                junit '**/target/surefire-reports/*.xml'
            }
        }
    }

    post {
        always {
            // Archive the test results and reports
            archiveArtifacts artifacts: '**/target/cucumber-reports/*.html', allowEmptyArchive: true
        }

        failure {
            // Notify on failure (if configured)
            echo 'Tests failed!'
        }
    }
}
