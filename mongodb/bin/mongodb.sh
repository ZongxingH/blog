#!/bin/sh

MONGODB_HOME=/data/mongodb/mongodb-4.1.0
LOGDIR=$MONGODB_HOME/logs
CONFDIR=$MONGODB_HOME/etc

# 进入 bin 目录

cd $MONGODB_HOME/bin

# 启动 mongod 服务
start(){
	nohup ./mongod -f $CONFDIR/mongo.conf > $LOGDIR/mongo.log 2>&1 &
	i=0
	sleep 10000
	mongops=`ps -ef | grep mongod | grep "$MONGODB_HOME"`

	if [ -n "$mongops" ]; then
		psid=`echo $mongops | awk '{print $2}'`
	else
		psid=0
	fi
	echo "PID：$psid"
	echo "mongod already start"
}
# 停止 mongod 服务
stop(){
    mongops=`ps -ef | grep mongod | grep "$MONGODB_HOME"`

	if [ -n "$mongops" ]; then
		psid=`echo $mongops | awk '{print $2}'`
	else
		psid=0
	fi
	echo "PID：$psid"
	kill -9 $psid
	echo "mongod already stop"
}

case "$1" in
   'start')
     start
      ;;
   'stop')
     stop
     ;;
   'restart')
     stop
     start
     ;;
  *)
     echo "Usage: $0 {start|stop|restart}"
     echo "start: start mongod server"
     echo "stop: stop mongod server"
     echo "restart: restart mongod server"
     exit 1
esac
exit 0
