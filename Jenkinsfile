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
    stage('Build Docker image') {
      steps {
        sh "docker build -t springboot-mapstruct:v1 ."
      }
    }
    stage('Deploy') {
      steps {
        sh "docker run --name springboot-mapstruct -d -p 8080:8080 springboot-mapstruct:v1"
      }
    }
  }
}
