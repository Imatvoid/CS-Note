#!/bin/bash

ping www.baidu.com -c2
if [ $? -eq 0 ];
then
  echo Successful ;
else
  echo Failure
fi