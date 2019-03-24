node {
    properties([parameters([string(defaultValue: '157.230.176.35', description: 'Default value', name: 'IP', trim: true), string(defaultValue: 'latest', description: 'What version would you like to apply?', name: 'VER', trim: true), string(defaultValue: '4000', description: 'What port would you like to run', name: 'PORT', trim: true)])])
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