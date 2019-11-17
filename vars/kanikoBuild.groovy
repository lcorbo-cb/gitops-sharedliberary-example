#!/usr/bin/env groovy

def call() {
  def pod_def = libraryResource 'pods/kanikoBuild.yaml'
  podTemplate(yaml: pod_def ) {
    node(POD_LABEL) {
      checkout scm
      container('kaniko') {
        sh '/kaniko/executor -f `pwd`/Dockerfile -c `pwd` --skip-tls-verify --cache=true --destination=lcorbocb/my-third-repo'
      }
    }
  }
}
