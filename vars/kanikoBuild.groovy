#!/usr/bin/env groovy

def call(destination) {
  podTemplate(yaml: "${libraryResource 'pods/kanikoBuild.yaml'}" ) {
    node(POD_LABEL) {
      checkout scm
      container('kaniko') {
        sh "/kaniko/executor -f `pwd`/Dockerfile -c `pwd` --skip-tls-verify --cache=true --destination=${destination}"
      }
    }
  }
}
