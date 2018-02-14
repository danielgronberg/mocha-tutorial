def runWithNodeVersion(shCommand) {
    withEnv(["NVM_DIR=${env.HOME}/.nvm"]) {
      try {
        def NODE_VERSION = "8.9.4"
        sh """
        set +x
        . ~/.nvm/nvm.sh
        nvm install 8.9.4
        nvm use 8.9.4
        set -x
        node -v
        ${shCommand}
        sh """
      } 
      catch (err) {
        throw err
      }
  }
}

node {
  checkout scm
  stage("Build") {
    runWithNodeVersion("npm install")
  }
  stage("UnitTest") {
    runWithNodeVersion("npm test")
  }
}