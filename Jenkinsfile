pipeline {
    agent any

    environment {
        DOCKERHUB_CREDENTIALS = credentials('docker-hub-credentials')
        SONARQUBE_SERVER = 'sonarqube'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/BAOUCHbaSalma/MicroServices-Backend-Part5.git'
            }
        }

        stage('Detect Changes') {
            steps {
                script {

                    def userChanged = sh(script: "git diff --name-only HEAD~1 | grep ^user-service/", returnStatus: true) == 0
                    def projetChanged = sh(script: "git diff --name-only HEAD~1 | grep ^projet-service/", returnStatus: true) == 0
                    def tacheChanged = sh(script: "git diff --name-only HEAD~1 | grep ^tache-service/", returnStatus: true) == 0
                    def ressourceChanged = sh(script: "git diff --name-only HEAD~1 | grep ^ressource-service/", returnStatus: true) == 0
                    def gatewayChanged = sh(script: "git diff --name-only HEAD~1 | grep ^gateway-service/", returnStatus: true) == 0
                    def eurekaChanged = sh(script: "git diff --name-only HEAD~1 | grep ^eureka-service/", returnStatus: true) == 0

                    // Affichage des changements détectés
                    if (userChanged) echo "Changements détectés dans user-service"
                    if (projetChanged) echo "Changements détectés dans projet-service"
                    if (tacheChanged) echo "Changements détectés dans tache-service"
                    if (ressourceChanged) echo "Changements détectés dans ressource-service"
                    if (gatewayChanged) echo "Changements détectés dans gateway-service"
                    if (eurekaChanged) echo "Changements détectés dans eureka-service"
                }
            }
        }

        stage('Build & Test Microservices') {
            parallel {
                stage('Build & Test user-service') {
                    when {
                        expression {
                            return sh(script: "git diff --name-only HEAD~1 | grep ^user-service/", returnStatus: true) == 0
                        }
                    }
                    steps {
                        dir('user-service') {
                            sh 'mvn clean test'
                        }
                    }
                }

                stage('Build & Test projet-service') {
                    when {
                        expression {
                            return sh(script: "git diff --name-only HEAD~1 | grep ^projet-service/", returnStatus: true) == 0
                        }
                    }
                    steps {
                        dir('projet-service') {
                            sh 'mvn clean test'
                        }
                    }
                }

                stage('Build & Test tache-service') {
                    when {
                        expression {
                            return sh(script: "git diff --name-only HEAD~1 | grep ^tache-service/", returnStatus: true) == 0
                        }
                    }
                    steps {
                        dir('tache-service') {
                            sh 'mvn clean test'
                        }
                    }
                }

                stage('Build & Test ressource-service') {
                    when {
                        expression {
                            return sh(script: "git diff --name-only HEAD~1 | grep ^ressource-service/", returnStatus: true) == 0
                        }
                    }
                    steps {
                        dir('ressource-service') {
                            sh 'mvn clean test'
                        }
                    }
                }

                stage('Build & Package gateway-service') {
                    when {
                        expression {
                            return sh(script: "git diff --name-only HEAD~1 | grep ^gateway-service/", returnStatus: true) == 0
                        }
                    }
                    steps {
                        dir('gateway-service') {
                            sh 'mvn clean install'
                        }
                    }
                }

                stage('Build & Test eureka-service') {
                    when {
                        expression {
                            return sh(script: "git diff --name-only HEAD~1 | grep ^eureka-service/", returnStatus: true) == 0
                        }
                    }
                    steps {
                        dir('eureka-service') {
                            sh 'mvn clean install'
                        }
                    }
                }
            }
        }

        stage('Build Docker Images & Push') {
            parallel {
                stage('Build Docker & Push for user-service') {
                    when {
                        expression {
                            return sh(script: "git diff --name-only HEAD~1 | grep ^user-service/", returnStatus: true) == 0
                        }
                    }
                    steps {
                        dir('user-service') {
                            script {
                                def dockerImage = docker.build("salmaba/user-service:${env.BUILD_ID}")
                                docker.withRegistry('https://index.docker.io/v1/', 'docker-hub-credentials') {
                                    dockerImage.push()
                                }
                            }
                        }
                    }
                }

                stage('Build Docker & Push for projet-service') {
                    when {
                        expression {
                            return sh(script: "git diff --name-only HEAD~1 | grep ^projet-service/", returnStatus: true) == 0
                        }
                    }
                    steps {
                        dir('projet-service') {
                            script {
                                def dockerImage = docker.build("salmaba/projet-service:${env.BUILD_ID}")
                                docker.withRegistry('https://index.docker.io/v1/', 'docker-hub-credentials') {
                                    dockerImage.push()
                                }
                            }
                        }
                    }
                }

                stage('Build Docker & Push for tache-service') {
                    when {
                        expression {
                            return sh(script: "git diff --name-only HEAD~1 | grep ^tache-service/", returnStatus: true) == 0
                        }
                    }
                    steps {
                        dir('tache-service') {
                            script {
                                def dockerImage = docker.build("salmaba/tache-service:${env.BUILD_ID}")
                                docker.withRegistry('https://index.docker.io/v1/', 'docker-hub-credentials') {
                                    dockerImage.push()
                                }
                            }
                        }
                    }
                }

                stage('Build Docker & Push for ressource-service') {
                    when {
                        expression {
                            return sh(script: "git diff --name-only HEAD~1 | grep ^ressource-service/", returnStatus: true) == 0
                        }
                    }
                    steps {
                        dir('ressource-service') {
                            script {
                                def dockerImage = docker.build("salmaba/ressource-service:${env.BUILD_ID}")
                                docker.withRegistry('https://index.docker.io/v1/', 'docker-hub-credentials') {
                                    dockerImage.push()
                                }
                            }
                        }
                    }
                }

                stage('Build Docker & Push for gateway-service') {
                    when {
                        expression {
                            return sh(script: "git diff --name-only HEAD~1 | grep ^gateway-service/", returnStatus: true) == 0
                        }
                    }
                    steps {
                        dir('gateway-service') {
                            script {
                                def dockerImage = docker.build("salmaba/gateway-service:${env.BUILD_ID}")
                                docker.withRegistry('https://index.docker.io/v1/', 'docker-hub-credentials') {
                                    dockerImage.push()
                                }
                            }
                        }
                    }
                }

                stage('Build Docker & Push for eureka-service') {
                    when {
                        expression {
                            return sh(script: "git diff --name-only HEAD~1 | grep ^eureka-service/", returnStatus: true) == 0
                        }
                    }
                    steps {
                        dir('eureka-service') {
                            script {
                                def dockerImage = docker.build("salmaba/eureka-service:${env.BUILD_ID}")
                                docker.withRegistry('https://index.docker.io/v1/', 'docker-hub-credentials') {
                                    dockerImage.push()
                                }
                            }
                        }
                    }
                }
            }
        }

        stage('Deploy with Docker Compose') {
            steps {
                sh 'docker-compose pull'  
                sh 'docker-compose up -d'
            }
        }
    }
}
