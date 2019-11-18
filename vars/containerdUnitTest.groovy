#!/usr/bin/env groovy

def call(containerTested) {
  podTemplate(yaml: "${libraryResource 'pods/containerdLint.yaml'}" ) {
    node(POD_LABEL) {
      checkout scm
      container(containerTested) {
        sh "./unitTests.sh"
      }
    }
  }
}
