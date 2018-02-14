

def runWithNodeVersion(shCommand) {
  try {
    withEnv([]) {
      def NODE_VERSION = "8.9.4"
      sh 'whoami'
      sh """
      . ${env.HOME}/.nvm/nvm.sh
      nvm install ${NODE_VERSION}
      nvm use ${NODE_VERSION}
      ${shCommand}
      sh """
    }
  } 
  catch (err) {
    throw err
  }
}

node {
  stage("Build") {
    runWithNodeVersion("npm install")
  }
  stage("UnitTest") {
    runWithNodeVersion("npm test")
  }
}