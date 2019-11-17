#!/usr/bin/env groovy

def call() {
  podTemplate(yaml: "${libraryResource 'pods/containerdUnitTest.yaml'}" ) {
    node(POD_LABEL) {
      checkout scm
      container('dgoss') {
        sh "dgoss -g dgoss.yaml validate --format documentation hadolint/hadolint:v1.17.2-20-ge2f77c5-debian"
      }
    }
  }
}
