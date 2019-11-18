#!/usr/bin/env groovy

def call(containerTested) {
  podTemplate(yaml: "${libraryResource 'pods/podExample.yaml'}" ) {
    node(POD_LABEL) {
      checkout scm
      container(containerTested) {
        sh "./unitTests.sh"
      }
    }
  }
}
