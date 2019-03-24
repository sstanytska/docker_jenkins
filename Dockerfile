FROM centos:centos7
MAINTAINER "stsofia05@gmail.com"
COPY .  /app/
WORKDIR /app

EXPOSE 4000

run yum install epel-release -y
RUN yum install python-pip -y
RUN pip install -r /app/app/requirements.txt

ENTRYPOINT [ "python", "/app/app/app.py"]
