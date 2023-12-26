pipeline {
  agent any
  tools{
      maven 'maven'
  }
  stages {
    stage('Build') {
      steps {
        sh "mvn clean package -DskipTests"
      }
    }
    stage('Deploy') {
      steps {
        sh "docker compose up -d --build"
      }
    }
  }
}
