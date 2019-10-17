pipeline {
    agent any
    tools {
            maven 'maven'
            jdk 'JDK 1.8.0_92'
    }
    stages {
        stage('Testing') {
            steps {
                script {
                    if (isUnix()) {
                        sh 'mvn verify'
                    } else {
                        bat 'mvn verify'
                    }
                    archiveArtifacts artifacts: '**', onlyIfSuccessful: false
                }
            }
        }
        stage('Cucumber Report') {
            steps {
                script {
                    cucumber fileIncludePattern: '**/*.json', jsonReportDirectory: 'target/json-cucumber-reports', sortingMethod: 'ALPHABETICAL'
                }
            }
        }
        stage('Live Documentation') {
            steps {
                script {
                    livingDocs featuresDir: 'target/json-cucumber-reports', format: 'ALL', hideScenarioKeyword: true, toc: 'LEFT'
                }
            }
        }
    }
    post {
        always {
            step([$class: 'Publisher', reportFilenamePattern: 'target/testng-cucumber-reports/*.xml'])
        }
    }
}