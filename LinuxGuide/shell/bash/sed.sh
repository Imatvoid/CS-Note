#!/bin/bash

echo -------------gnu sed---------------------

#ed 's/pattern/replace_string/' file


#stdin
#cat file | sed 's/pattern/replace_string/'

#save
#sed -i 's/text/replace/' file

echo -------------replace first 1--------------
echo 12341567189
echo 12341567189 | sed 's/1//'

echo -------------replace all 1--------------
echo 12341567189
echo 12341567189 | sed 's/1//g'

echo -------------replace N 1--------------
echo 12341567189
# gnu sed
echo 12341567189 | sed  's/1/$/2g'


echo -------------replace empty line--------------
echo -e "start
\nend" 
echo -e "start
\nend" | sed -E '/^$/d' 


echo -------------sed with regex--------------
test="11 abc 111 this 9 file contains 111 11 88 numbers 0000"
echo $test | sed  's/\b[0-9]\{3\}\b/NUM/g'


#已匹配字符串标记(&)

echo -------------sed mark match--------------
test="11 abc 111 this 9 file contains 111 11 88 numbers 0000"
echo $test | sed  's/\w\+/[&]/g'                


echo -------------sed mark match 1-n--------------
echo seven EIGHT | sed 's/\([a-z]\+\) \([A-Z]\+\)/\2 \1/'


