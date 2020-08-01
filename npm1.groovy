

pipeline {
    agent {
        node {
          label 'master'
        }
    }
    environment {
        CI = 'true'
    }
    stages {
        
        stage('Build') {
            steps {
                sh 'echo "New"'
            }
        }
        stage('Test') {
            steps {
                echo "Test Stage"
                sh './scripts/test.sh'
            }
        }
        stage ('test shared library') {
            steps {
                sample "Apurba"
            }
        }
        stage('Deliver') {
            steps {
                sh './scripts/deliver.sh'
                input message: 'Finished using the web site? (Click "Proceed" to continue)'
                sh './scripts/kill.sh'
            }
        }
    }
}
