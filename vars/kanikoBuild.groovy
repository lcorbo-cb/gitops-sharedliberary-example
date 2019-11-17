#!/usr/bin/env groovy

def call() {
  podTemplate(yaml: "${libraryResource 'pods/kanikoBuild.yaml'}" ) {
    node(POD_LABEL) {
      checkout scm
      container('kaniko') {
        sh '/kaniko/executor -f `pwd`/Dockerfile -c `pwd` --skip-tls-verify --cache=true --destination=lcorbocb/my-third-repo'
      }
    }
  }
}
