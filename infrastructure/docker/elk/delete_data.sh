#!/bin/sh
 
#15일 이전 데이은 삭제
DATE_DAYS_AGO=`date +%Y.%m.%d --date '15 day ago'`
 
echo $DATE_DAYS_AGO
 
curl -XDELETE "http://localhost:9200/logstash-$DATE_DAYS_AGO*"
