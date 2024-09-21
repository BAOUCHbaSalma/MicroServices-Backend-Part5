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
                    def userChanged = bat(script: "git diff --name-only HEAD~1 | findstr ^user-service/", returnStatus: true) == 0
                    def projetChanged = bat(script: "git diff --name-only HEAD~1 | findstr ^projet-service/", returnStatus: true) == 0
                    def tacheChanged = bat(script: "git diff --name-only HEAD~1 | findstr ^tache-service/", returnStatus: true) == 0
                    def ressourceChanged = bat(script: "git diff --name-only HEAD~1 | findstr ^ressource-service/", returnStatus: true) == 0
                    def gatewayChanged = bat(script: "git diff --name-only HEAD~1 | findstr ^gateway-service/", returnStatus: true) == 0
                    def eurekaChanged = bat(script: "git diff --name-only HEAD~1 | findstr ^eureka-service/", returnStatus: true) == 0

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
                            return bat(script: "git diff --name-only HEAD~1 | findstr ^user-service/", returnStatus: true) == 0
                        }
                    }
                    steps {
                        dir('user-service') {
                            bat 'mvn clean test'
                        }
                    }
                }

                stage('Build & Test projet-service') {
                    when {
                        expression {
                            return bat(script: "git diff --name-only HEAD~1 | findstr ^projet-service/", returnStatus: true) == 0
                        }
                    }
                    steps {
                        dir('projet-service') {
                            bat 'mvn clean test'
                        }
                    }
                }

                stage('Build & Test tache-service') {
                    when {
                        expression {
                            return bat(script: "git diff --name-only HEAD~1 | findstr ^tache-service/", returnStatus: true) == 0
                        }
                    }
                    steps {
                        dir('tache-service') {
                            bat 'mvn clean test'
                        }
                    }
                }

                stage('Build & Test ressource-service') {
                    when {
                        expression {
                            return bat(script: "git diff --name-only HEAD~1 | findstr ^ressource-service/", returnStatus: true) == 0
                        }
                    }
                    steps {
                        dir('ressource-service') {
                            bat 'mvn clean test'
                        }
                    }
                }

                stage('Build & Package gateway-service') {
                    when {
                        expression {
                            return bat(script: "git diff --name-only HEAD~1 | findstr ^gateway-service/", returnStatus: true) == 0
                        }
                    }
                    steps {
                        dir('gateway-service') {
                            bat 'mvn clean install'
                        }
                    }
                }

                stage('Build & Test eureka-service') {
                    when {
                        expression {
                            return bat(script: "git diff --name-only HEAD~1 | findstr ^eureka-service/", returnStatus: true) == 0
                        }
                    }
                    steps {
                        dir('eureka-service') {
                            bat 'mvn clean install'
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
                            return bat(script: "git diff --name-only HEAD~1 | findstr ^user-service/", returnStatus: true) == 0
                        }
                    }
                    steps {
                        dir('user-service') {
                            script {
                                def dockerImage = docker.build("salmaba/user-service:${env.TAG_VERSION ?: 'latest'}")
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
                            return bat(script: "git diff --name-only HEAD~1 | findstr ^projet-service/", returnStatus: true) == 0
                        }
                    }
                    steps {
                        dir('projet-service') {
                            script {
                                def dockerImage = docker.build("salmaba/projet-service:${env.TAG_VERSION ?: 'latest'}")
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
                            return bat(script: "git diff --name-only HEAD~1 | findstr ^tache-service/", returnStatus: true) == 0
                        }
                    }
                    steps {
                        dir('tache-service') {
                            script {
                                def dockerImage = docker.build("salmaba/tache-service:${env.TAG_VERSION ?: 'latest'}")
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
                            return bat(script: "git diff --name-only HEAD~1 | findstr ^ressource-service/", returnStatus: true) == 0
                        }
                    }
                    steps {
                        dir('ressource-service') {
                            script {
                                def dockerImage = docker.build("salmaba/ressource-service:${env.TAG_VERSION ?: 'latest'}")
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
                            return bat(script: "git diff --name-only HEAD~1 | findstr ^gateway-service/", returnStatus: true) == 0
                        }
                    }
                    steps {
                        dir('gateway-service') {
                            script {
                                def dockerImage = docker.build("salmaba/gateway-service:${env.TAG_VERSION ?: 'latest'}")
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
                            return bat(script: "git diff --name-only HEAD~1 | findstr ^eureka-service/", returnStatus: true) == 0
                        }
                    }
                    steps {
                        dir('eureka-service') {
                            script {
                                def dockerImage = docker.build("salmaba/eureka-service:${env.TAG_VERSION ?: 'latest'}")
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
                bat 'docker-compose pull'
                bat 'docker-compose up -d'
            }
        }
    }
}
