#!/usr/bin/env groovy

def call(dockerFile) {
  podTemplate(yaml: "${libraryResource 'pods/containerdLint.yaml'}" ) {
    node(POD_LABEL) {
      container('hadolint') {
        sh "hadolint ${dockerFile}"
      }
    }
  }
}
