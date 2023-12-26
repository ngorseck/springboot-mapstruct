pipeline {
  tools {
    maven 'M3'
  }
  agent any
  stages {
    stage('Build') {
      steps {
        sh "mvn clean package -DskipTests"
      }
    }
  }
}
