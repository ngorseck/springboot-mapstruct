pipeline {
  agent any
  tools{
      maven 'MAVEN_JENKINS'
  }
  stages {
    stage('Build') {
      steps {
        sh "mvn clean package -DskipTests"
      }
    }
  }
}
