#!/bin/bash
echo "============================================="
echo "init system"
basedir=$(pwd) 
echo ${basedir}
libpath=${basedir}/lib
libs=
jarlist=$(ls $libpath|grep jar)
echo $jarlist
for i in $jarlist
do
libs="$libpath/$i":$libs
done
#!echo $libs

cls="${basedir}/config;"
#!echo ${cls}

export CLASSPATH=$CLASSPATH:$libs:$cls
#!echo $CLASSPATH

java -Xms50m -Xmx512m -Duser.timezone=GMT+08  com.jw.mockdata.generator.Application
echo "=============================================" end
exit

