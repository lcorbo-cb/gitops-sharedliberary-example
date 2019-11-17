#!/usr/bin/env groovy

def call() {
  podTemplate(yaml: "${libraryResource 'pods/containerdUnitTest.yaml'}" ) {
    node(POD_LABEL) {
      checkout scm
      container('dgoss') {
        sh "ls -l"
      }
    }
  }
}
