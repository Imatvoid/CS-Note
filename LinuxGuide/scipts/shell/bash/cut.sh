#!/bin/bash

echo -------------content:---------------
#cut -f FIELD_LIST filename
#cut -f 2,3 filename 这条命令将显示第2列和第3列。

echo -e " No  Name  Mark  Percent\n"  \
        "1  Sarath  45  90\n" \
        "2  Alex  49  98\n" \
        "3 Anu 45 90\n" 



echo -------------cut:2 3 col---------------
#cut -f FIELD_LIST filename
#cut -f 2,3 filename 这条命令将显示第2列和第3列。

echo -e " No \t Name\t Mark \t Percent\n"  \
        "1 \t Sarath \t 45\t 90\n" \
        "2 \t Alex \t 49 \t 98\n" \
        "3 \t Anu \t 45 \t 90" \
| cut -f 1,4 


echo -------------cut: except 2 3 ---------------
echo -e " No \t Name\t Mark \t Percent\n"  \
        "1 \t Sarath \t 45\t 90\n" \
        "2 \t Alex \t 49 \t 98\n" \
        "3 \t Anu \t 45 \t 90" \
| cut -f3 --complement

