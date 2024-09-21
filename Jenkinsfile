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

        stage('Build & Test Microservices') {
            parallel {
                stage('Build & Test user-service') {
                    steps {
                        dir('user-service') {
                            bat 'mvn clean package'
                        }
                    }
                }

                stage('Build & Test projet-service') {
                    steps {
                        dir('projet-service') {
                            bat 'mvn clean package'
                        }
                    }
                }

                stage('Build & Test tache-service') {
                    steps {
                        dir('tache-service') {
                            bat 'mvn clean package'
                        }
                    }
                }

                stage('Build & Test ressource-service') {
                    steps {
                        dir('ressource-service') {
                            bat 'mvn clean package'
                        }
                    }
                }

                stage('Build & Package gateway-service') {
                    steps {
                        dir('gateway-service') {
                            bat 'mvn clean install'
                        }
                    }
                }

                stage('Build & Test eureka-service') {
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
                bat 'docker-compose up'
            }
        }
    }
}
