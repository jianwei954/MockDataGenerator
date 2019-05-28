@echo off & setlocal enabledelayedexpansion

title MockDataGenerator

if not exist "%JAVA_HOME%\bin\MockDataGenerator.exe"  copy "%JAVA_HOME%\bin\java.exe" "%JAVA_HOME%\bin\MockDataGenerator.exe"

set LIB_JARS="lib\*;config\*"

if ""%1"" == ""debug"" goto debug
if ""%1"" == ""jmx"" goto jmx

"%JAVA_HOME%\bin\MockDataGenerator.exe" -Xms1201m -Xmx2401m -Xmn801m  -XX:MaxPermSize=64M -XX:+UseParNewGC -Xss256k -XX:+UseConcMarkSweepGC -XX:+UseCMSCompactAtFullCollection  -XX:CMSFullGCsBeforeCompaction=5 -XX:ParallelGCThreads=4 -classpath %LIB_JARS% com.jw.mockdata.generator.Application
pause
goto end

:debug
"%JAVA_HOME%\bin\MockDataGenerator.exe" -Xms1201m -Xmx2401m -Xmn801m  -XX:MaxPermSize=64M -XX:+UseParNewGC -Xss256k -XX:+UseConcMarkSweepGC -XX:+UseCMSCompactAtFullCollection  -XX:CMSFullGCsBeforeCompaction=5 -XX:ParallelGCThreads=4 -Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,address=5089,server=y,suspend=n -classpath ..\config\;%LIB_JARS% com.jw.mockdata.generator.Application
goto end

:jmx
"%JAVA_HOME%\bin\MockDataGenerator.exe" -Xms64m -Xmx1024m  -XX:MaxPermSize=64M -Dcom.sun.management.jmxremote.port=1099 -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false -classpath ..\config\;%LIB_JARS% com.jw.mockdata.generator.Application

:end
exit