

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
        stage('cloning repo ... ') {
            steps {
                git 'https://github.com/Apurv11/test-jenkins.git'
            }
        }
        stage('Build') {
            steps {
                sh 'npm install'
                sh 'sleep 10000'
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
