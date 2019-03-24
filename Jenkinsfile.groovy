node {
    properties([parameters([string(defaultValue: '127.0.0.1', description: 'Please provide an IP to host', name: 'IP', trim: true)])])
    stage("Remove conteiner"){
        try{
            sh "ssh root@${IP} docker rm -f flaskex"
        }
        catch(exc){
            sh "echo container deleted"
        }
    }
    stage("Run conteiner"){
        sh "ssh root@${IP} docker run -d --name flaksex -p 6000:6000 sstanytska/flaskex"
    }
}