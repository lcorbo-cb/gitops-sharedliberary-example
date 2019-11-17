#!/usr/bin/env groovy

def call() {
  podTemplate(yaml: "${libraryResource 'pods/containerdLint.yaml'}" ) {
    node(POD_LABEL) {
      checkout scm
      container('hadolint') {
        sh "hadolint ${dockerFile}"
      }
    }
  }
}
