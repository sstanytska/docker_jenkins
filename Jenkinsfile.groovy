node {
    properties([parameters([string(defaultValue: '127.0.0.1', description: 'Please provide IP host', name: 'IP', trim: true), string(defaultValue: 'latest', description: 'What version would you like to apply?', name: 'VER', trim: true)])])
    stage("Remove conteiner"){
        try{
            sh "ssh root@${IP} docker rm -f flaksex"
        }
        catch(exc){
            sh "echo container deleted"
        }
    }
    stage("Run conteiner"){
        sh "ssh root@${IP} docker run -d --name flaksex -p 6000:6000 sstanytska/flaskex"
    }
}